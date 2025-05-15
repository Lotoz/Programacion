package prog.ud08.actividad803.data.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import prog.ud08.actividad803.data.ServicioAccesoDatos;
import prog.ud08.actividad803.data.ServicioAccesoDatosException;
import prog.ud08.actividad803.data.VisitadorVentas;
import prog.ud08.actividad803.modelo.Cliente;
import prog.ud08.actividad803.modelo.Motocicleta;

public class ServicioAccesoDatosSQLite implements ServicioAccesoDatos {

  //Constantes
  //URL A LA BASE DE DATOS
  private static final String URL_BD = "jdbc:sqlite:";
  
  //MOTOCICLETA
  private static final String SQL_ADD_MOTOCICLETA = "INSERT INTO motocicleta(referencia,cilindrada,tipo,precio,fabricante) VALUES (?,?,?,?,?)";
  private static final String SQL_DELETE_MOTOCICLETA = "DELETE FROM motocicleta WHERE referencia = ?";
  private static final String SQL_DELETE_VENTAS_RELACIONADAS = "DELETE FROM venta WHERE referencia_motocicleta = ?";
  
  //CLIENTE
  private static final String SQL_GET_CLIENTE_BY_NIF = "SELECT * FROM cliente WHERE nif = ?";
  private static final String SQL_UPDATE_CLIENTE = "UPDATE cliente SET nombre = ? AND apellidos = ? AND direccion = ? and nif_recomendado = ? WHERE nif = ?";
  
  private static final String C_CLIENTE_NIF = "nif";
  private static final String C_CLIENTE_NOMBRE = "nombre";
  private static final String C_CLIENTE_APELLIDOS = "apellidos";
  private static final String C_CLIENTE_DIRECCION = "direccion";
  private static final String C_CLIENTE_NIF_RECOMENDADO = "nif_recomendado";
  
  //VENTA
  private static final String SQL_REGISTRA_VENTA = "INSERT INTO venta(nif_cliente,referencia_motocicleta,fecha) VALUES (?,?,?)";
  private static final String SQL_COMPRUEBA_CLIENTE = "SELECT nif FROM cliente WHERE nif = ?";
  private static final String SQL_COMPRUEBA_MOTOCICLETA = "SELECT referencia FROM motocicleta WHERE referencia = ?";
  private static final String SQL_GET_ALL_VENTAS = "SELECT * FROM venta";

  
  //Atributo
  private String ruta;
  
  //Constructor
  public ServicioAccesoDatosSQLite(String rutaDb) {
    this.ruta = URL_BD + rutaDb;
  }

  @Override
  public void addMotocicleta(Motocicleta motocicleta) {
    if (motocicleta.getReferencia().isBlank() || motocicleta.getTipo().isBlank() || motocicleta.getFabricante().isBlank()
        || motocicleta.getCilindrada() < 0 || motocicleta.getPrecio() < 0) {
      throw new IllegalArgumentException();
    }
    
    //Obtenemos conexion y sentencia
    try (Connection conexion = DriverManager.getConnection(ruta);
        PreparedStatement sentenciaPreparada = conexion.prepareStatement(SQL_ADD_MOTOCICLETA, Statement.RETURN_GENERATED_KEYS)){
      //Rellenamos parametros
      sentenciaPreparada.setString(1, motocicleta.getReferencia());
      sentenciaPreparada.setInt(2, motocicleta.getCilindrada());
      sentenciaPreparada.setString(3, motocicleta.getTipo());
      sentenciaPreparada.setDouble(4, motocicleta.getPrecio());
      sentenciaPreparada.setString(5, motocicleta.getFabricante());
      int respuesta = sentenciaPreparada.executeUpdate();
      //Si ya existe una motocicleta con dicha referencia
      if (respuesta == 0) {
        throw new ServicioAccesoDatosException("Error JDBC en addMotocicleta");
      }
      
    } catch (SQLException e) {
      throw new ServicioAccesoDatosException("Error JDBC en addMotocicleta: " + e.getMessage());
    }
  }

  @Override
  public int registrarVenta(String nifCliente, String referenciaMotocicleta) {
  //Obtenemos conexion y sentencia
    try (Connection conexion = DriverManager.getConnection(ruta);
        PreparedStatement sentenciaPreparada = conexion.prepareStatement(SQL_REGISTRA_VENTA, Statement.RETURN_GENERATED_KEYS)){
      //Comprobamos que existe un cliente con el nif roporcionado y una motocicleta con la referencia proporcionada
      String nif = compruebaNif(nifCliente);
      String referencia = compruebaReferencia(referenciaMotocicleta);
      String fecha = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
      //Rellenamos parametros
      sentenciaPreparada.setString(1, nif);
      sentenciaPreparada.setString(2, referencia);
      sentenciaPreparada.setString(3, fecha);
      sentenciaPreparada.executeUpdate();
      //Ejecuta la consulta
      ResultSet resultado = sentenciaPreparada.getGeneratedKeys();
      if (resultado.next()) {
        return resultado.getInt(1);
      }
      
    } catch (SQLException e) {
      throw new ServicioAccesoDatosException("Error JDBC en registrarVenta: " + e.getMessage());
    }
    return 0;
  }

  @Override
  public void getAllVentas(VisitadorVentas visitador) {
    //Obtenemos conexion y sentencia
    try (Connection conexion = DriverManager.getConnection(ruta);
        PreparedStatement sentenciaPreparada = conexion.prepareStatement(SQL_GET_ALL_VENTAS)){
      //Ejecuta la consulta
      
      ResultSet resultado = sentenciaPreparada.executeQuery();
      //Si se encontró el ventas
      while (resultado.next()) {
        //Lo obtiene 
        visitador.visitaFila(resultado);
      }
      //Cierra el ResultSet
      resultado.close();
      
    } catch (SQLException e) {
      throw new ServicioAccesoDatosException("Error JDBC en getAllVentas: " + e.getMessage());
    }
  }

  @Override
  public Cliente getClienteByNif(String nif) {
  //Obtenemos conexion y sentencia
    try (Connection conexion = DriverManager.getConnection(ruta);
        PreparedStatement sentenciaPreparada = conexion.prepareStatement(SQL_GET_CLIENTE_BY_NIF)){
      //Rellenamos parametros
      sentenciaPreparada.setString(1, nif);
      //Ejecuta la consulta
      ResultSet resultado = sentenciaPreparada.executeQuery();
      //Centro a devolver
      Cliente cliente = null;
      //Si se encontró el cliente
      if (resultado.next()) {
        //Lo obtiene 
        cliente = new Cliente(resultado.getString(C_CLIENTE_NIF), resultado.getString(C_CLIENTE_NOMBRE), 
            resultado.getString(C_CLIENTE_APELLIDOS), resultado.getString(C_CLIENTE_DIRECCION), resultado.getString(C_CLIENTE_NIF_RECOMENDADO));
        return cliente;
      }
      //Cierra el ResultSet
      resultado.close();
      
    } catch (SQLException e) {
      throw new ServicioAccesoDatosException("Error JDBC en getClienteByNif: " + e.getMessage());
    }
    return null;
  }

  @Override
  public void updateCliente(Cliente cliente) {
    //Obtenemos conexion y sentencia
    try (Connection conexion = DriverManager.getConnection(ruta);
        PreparedStatement sentenciaPreparada = conexion.prepareStatement(SQL_UPDATE_CLIENTE)){
      //Rellenamos parametros
      sentenciaPreparada.setString(1, cliente.getNombre());
      sentenciaPreparada.setString(2, cliente.getApellidos());
      sentenciaPreparada.setString(3, cliente.getDireccion());
      sentenciaPreparada.setString(4, cliente.getNifRecomendado());
      //Ejecuta la consulta
      sentenciaPreparada.executeUpdate();
      
    } catch (SQLException e) {
      throw new ServicioAccesoDatosException("Error JDBC en updateCliente: " + e.getMessage());
    }
  }

  @Override
  public void deleteMotocicleta(String referencia) {
    //Obtenemos conexion y sentencia
    try (Connection conexion = DriverManager.getConnection(ruta);
        PreparedStatement sentenciaPreparada = conexion.prepareStatement(SQL_DELETE_MOTOCICLETA)){
      //Rellenamos parametros
      sentenciaPreparada.setString(1, referencia);
      //Ejecuta la consulta
      int resultado = sentenciaPreparada.executeUpdate();
      //Si no existe una motocicleta con dicha referencia
      if (resultado == 0) {
        throw new ServicioAccesoDatosException("Error JDBC en deleteMotocicleta");
      }
      
      eliminarVentasConDichaReferencia(referencia);
      
    } catch (SQLException e) {
      throw new ServicioAccesoDatosException("Error JDBC en deleteMotocicleta: " + e.getMessage());
    }
  }

  private String compruebaReferencia(String referenciaMotocicleta) {
    //Obtenemos conexion y sentencia
    try (Connection conexion = DriverManager.getConnection(ruta);
        PreparedStatement sentenciaPreparada = conexion.prepareStatement(SQL_COMPRUEBA_MOTOCICLETA)){
      //Rellenamos parametros
      sentenciaPreparada.setString(1, referenciaMotocicleta);
      //Ejecuta la consulta
      int resultado = sentenciaPreparada.executeUpdate();
      //Si no existe una motocicleta con dicha referencia
      if (resultado == 0) {
        throw new ServicioAccesoDatosException("Error JDBC en compruebaReferencia");
      }
      return referenciaMotocicleta;
    } catch (SQLException e) {
      throw new ServicioAccesoDatosException("Error JDBC en compruebaReferencia: " + e.getMessage());
    }
  }

  private String compruebaNif(String nifCliente) {
    //Obtenemos conexion y sentencia
    try (Connection conexion = DriverManager.getConnection(ruta);
        PreparedStatement sentenciaPreparada = conexion.prepareStatement(SQL_COMPRUEBA_CLIENTE)){
      //Rellenamos parametros
      sentenciaPreparada.setString(1, nifCliente);
      //Ejecuta la consulta
      int resultado = sentenciaPreparada.executeUpdate();
      //Si no existe una motocicleta con dicha referencia
      if (resultado == 0) {
        throw new ServicioAccesoDatosException("Error JDBC en compruebaNif");
      }
      return nifCliente;
    } catch (SQLException e) {
      throw new ServicioAccesoDatosException("Error JDBC en compruebaNif: " + e.getMessage());
    }
  }

  private void eliminarVentasConDichaReferencia(String referencia) {
  //Obtenemos conexion y sentencia
    try (Connection conexion = DriverManager.getConnection(ruta);
        PreparedStatement sentenciaPreparada = conexion.prepareStatement(SQL_DELETE_VENTAS_RELACIONADAS)){
      //Rellenamos parametros
      sentenciaPreparada.setString(1, referencia);
      //Ejecuta la consulta
      sentenciaPreparada.executeUpdate();
      
    } catch (SQLException e) {
      throw new ServicioAccesoDatosException("Error JDBC en eliminarVentasConDichaReferencia: " + e.getMessage());
    }
  }

}
