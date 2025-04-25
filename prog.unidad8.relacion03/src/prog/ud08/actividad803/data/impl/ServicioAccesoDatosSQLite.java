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
import prog.ud08.actividad803.modelo.Venta;

/**
 * Clase que implementa los metodos de la interfaz ServicioAccesoDatos para
 * poder leer, modificar, eliminar y agregar a la base de datos sqlite
 */
public class ServicioAccesoDatosSQLite implements ServicioAccesoDatos, VisitadorVentas {

  // Constantes
  // URL Base para conectar con SQLite
  private static final String URL_BASE = "jdbc:sqlite:";

  // Consultas
  // Consulta para agregar una motocicleta
  private static final String SQL_ADD_MOTOCICLETA = "INSERT INTO MOTOCICLETA(referencia, cilindrada, tipo, precio, fabricante) VALUES (?, ?, ?, ?, ?)";

  // Registrar venta
  private static final String SQL_REGISTRAR_VENTA = "INSERT INTO VENTA(nif_cliente, referencia_motocicleta, fecha) VALUES (?, ?, ?)";

  // Consulta para obtener un cliente por nif
  private static final String SQL_GET_CLIENTE_BY_CODIGO = "SELECT * FROM CLIENTE WHERE nif = ? ";

  // Consulta para actualizar un cliente
  private static final String SQL_UPDATE_CLIENTE = "UPDATE CLIENTE SET nombre = ?, apellidos = ?, direccion = ?, nif_recomendado = ?  WHERE nif = ?";

  // Consulta para borrar motocicleta
  private static final String SQL_DELETE_MOTOCICLETA = "DELETE * FROM MOTOCICLETA WHERE referencia = ?";

  // Borra la tabla venta junto a la motocicleta que se desea borrar
  private static final String SQL_DELETE_VENTA = "DELETE * FROM VENTA WHERE referencia_motocicleta = ?";
  
  // Consulta para toda la tabla venta
  private static final String SQL_ALL_VENTAS = "SELECT * FROM VENTA";

  // Manejo de la tabla cliente
  private static final String C_CLIENTE_NIF = "nif";
  private static final String C_CLIENTE_NOMBRE = "nombre";
  private static final String C_CLIENTE_APELLIDOS = "apellidos";
  private static final String C_CLIENTE_DIRECCION = "direccion";
  private static final String C_CLIENTE_NIF_RECOMENDADO = "nif_recomendado";

  // Manejo de la tabla venta
  private static final String V_VENTA_CODIGO = "codigo";
  private static final String V_VENTA_NIFCLIENTE = "nif_cliente";
  private static final String V_VENTA_REFERENCIAMOTO = "referencia_motocicleta";
  private static final String V_VENTA_FECHA = "fecha";


  // Atributos de la clase
  // Ruta de la base de datos
  private String rutaDb;
  // Fecha actual
  private String fecha = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);

  public ServicioAccesoDatosSQLite(String rutaDb) {
    this.rutaDb = rutaDb;
  }

  @Override
  public void addMotocicleta(Motocicleta motocicleta) {
    // Iniciamos la conexion con la base de datos
    try (Connection conexion = getConexion();
        PreparedStatement sentencia = conexion.prepareStatement(SQL_ADD_MOTOCICLETA)) {

      // Establecer parámetros de la sentencia
      sentencia.setString(1, motocicleta.getReferencia());
      sentencia.setInt(2, motocicleta.getCilindrada());
      sentencia.setString(3, motocicleta.getTipo());
      sentencia.setDouble(4, motocicleta.getPrecio());
      sentencia.setString(5, motocicleta.getFabricante());

      // Ejecutar
      sentencia.executeUpdate();
      sentencia.close();
    } catch (SQLException e) {
      throw new ServicioAccesoDatosException("Error JDBC en addMotocicleta: " + e.getMessage());
    }
  }

  @Override
  public int registrarVenta(String nifCliente, String referenciaMotocicleta) {
    try (Connection conexion = getConexion();
        PreparedStatement sentencia = conexion.prepareStatement(SQL_REGISTRAR_VENTA, Statement.RETURN_GENERATED_KEYS)) {
      // Establecer parámetros
      sentencia.setString(1, nifCliente);
      sentencia.setString(2, referenciaMotocicleta);
      sentencia.setString(3, fecha);

      // Ejecutar y recuperar la clave generada
      ResultSet rs = sentencia.getGeneratedKeys();
      // Iniciamos numero de la venta
      int numeroVenta = 0;
      if (rs.next()) {
        sentencia.executeUpdate();
        numeroVenta = rs.getInt(1);
      }
      // Finaliza y devuelve el codigo de la venta registrada
      return numeroVenta;
    } catch (SQLException e) {
      throw new ServicioAccesoDatosException("Error JDBC en registrarVenta: " + e.getMessage());
    }
  }

  @Override
  public void getAllVentas(VisitadorVentas visitador) {
    // Obtenemos conexión y consulta
    try (Connection conexion = getConexion(); PreparedStatement sentencia = conexion.prepareStatement(SQL_ALL_VENTAS)) {
      // Ejecuta la consulta
      ResultSet rs = sentencia.executeQuery();
      // Inicializamos una lista
      List<String> resultado = new ArrayList<>();
      //El visitador ira pillando analizando si hay ventas dispobibles, y segun el resultado devuelve
      while (visitador.visitaFila(rs)) {
        // Obtiene la venta
        Venta venta = obtenerVentaResult(rs);
        // Lo obtiene y lo almacena en la lista
        resultado.add(obtenerVentaResultString(venta));
      }
      // Cierra el resultset
      rs.close();
    } catch (SQLException e) {
      throw new ServicioAccesoDatosException("Error JDBC en getAllCentro: " + e.getMessage());
    }
  }

  @Override
  public boolean visitaFila(ResultSet resultado) {
    // Obtenemos conexión y consulta
    try (Connection conexion = getConexion(); PreparedStatement sentencia = conexion.prepareStatement(SQL_ALL_VENTAS)) {
      // Ejecuta la consulta
      ResultSet rs = sentencia.executeQuery();
      // Recorremos la consulta
      while (rs.next()) { 
      }
      //Cuando acabe el ciclo detiene el otro
      return false;     
    } catch (SQLException e) {
      throw new ServicioAccesoDatosException("Error JDBC en getAllCentro: " + e.getMessage());
    }
  }

  @Override
  public Cliente getClienteByNif(String nif) {
    // Iniciamos la conexion con la base de datos
    try (Connection conexion = getConexion();
        PreparedStatement sentencia = conexion.prepareStatement(SQL_GET_CLIENTE_BY_CODIGO)) {
      // Establecer parámetros de la sentencia
      sentencia.setString(1, nif);
      // Ejecuta la consulta
      ResultSet rs = sentencia.executeQuery();
      // Inicializamos centro
      Cliente cliente = null;
      // Si se encontró el centro nos obtiene el centro con nuestro metodo especifico
      if (rs.next()) {
        // Lo obtiene
        cliente = obtenerClienteResult(rs);
      }
      // Cierra el ResultSet
      rs.close();
      // Devuelve el cliente
      return cliente;
    } catch (SQLException e) {
      throw new ServicioAccesoDatosException("Error JDBC en getClienteByCodigo: " + e.getMessage());
    }
  }

  @Override
  public void updateCliente(Cliente cliente) {
    // Obtenemos conexión y sentencia
    try (Connection conexion = getConexion();
        PreparedStatement sentencia = conexion.prepareStatement(SQL_UPDATE_CLIENTE)) {

      // Establecer parámetros de la sentencia
      sentencia.setString(1, cliente.getNombre());
      sentencia.setString(2, cliente.getApellidos());
      sentencia.setString(3, cliente.getDireccion());

      // Manejo de null
      if (cliente.getNifRecomendado() == null) {
        sentencia.setNull(4, java.sql.Types.VARCHAR);
      } else {
        sentencia.setString(4, cliente.getNifRecomendado());
      }
      sentencia.setString(5, cliente.getNif());

      // Ejecuta la actualizacion
      if (sentencia.executeUpdate() != 1) {
        throw new ServicioAccesoDatosException(
            "Error en updateCliente. El cliente" + "indicado no existe en la base de datos");
      }
      sentencia.close();
    } catch (SQLException e) {
      throw new ServicioAccesoDatosException("Error JDBC en updateCliente: " + e.getMessage());
    }
  }

  @Override
  public void deleteMotocicleta(String referencia) {
    // Obtenemos conexión y sentencia
    try (Connection conexion = getConexion();
        PreparedStatement sentencia = conexion.prepareStatement(SQL_DELETE_MOTOCICLETA)) {
      // Rellena el codigo de la generated key
      sentencia.setString(1, referencia);
      // Borra la tabla venta si existe dicha motocicleta ahi
      borrarVenta(referencia);
      // Ejecuta la actualizacion
      if (sentencia.executeUpdate() != 1) {
        throw new ServicioAccesoDatosException(
            "Error en deleteMotocicleta. La motocicleta" + "indicado no existe en la base de datos");
      }
    } catch (SQLException e) {
      throw new ServicioAccesoDatosException("Error JDBC en deleteMotocicleta: " + e.getMessage());
    }
  }

  /**
   * Borra la venta relacionada con la motocicleta que se desea borrar
   * 
   * @param referencia
   */
  private void borrarVenta(String referencia) {
    // Obtenemos conexión y sentencia
    try (Connection conexion = getConexion();
        PreparedStatement sentencia = conexion.prepareStatement(SQL_DELETE_VENTA)) {
      // Rellena el codigo de la generated key
      sentencia.setString(1, referencia);
      // Ejecuta la actualizacion
      if (sentencia.executeUpdate() != 1) {
        throw new ServicioAccesoDatosException(
            "Error en borrarVenta. La venta" + "indicado no existe en la base de datos");
      }
      sentencia.close();
    } catch (SQLException e) {
      throw new ServicioAccesoDatosException("Error JDBC en borrarVenta: " + e.getMessage());
    }

  }

  /**
   * Obtiene conexion a la base de datos
   * 
   * @return Conexión a la base de datos
   * @throws SQLException Si ocurre cualquier error accediendo a la base de datos
   */
  private Connection getConexion() throws SQLException {
    // Crea la conexion con la base de datos uniendo las cadenas
    return DriverManager.getConnection(URL_BASE + rutaDb);
  }

  /**
   * Crea un cliente de un ResultSet
   * 
   * @param rest
   * @return Cliente
   * @throws SQLException
   */
  private Cliente obtenerClienteResult(ResultSet rest) throws SQLException {
    // Pilla el nulo y guarda la ultima lectura
    rest.getString(C_CLIENTE_NIF_RECOMENDADO);
    // Ternario para Asignar el valor que sea
    String nifRecomendado = rest.wasNull() ? null : rest.getString(C_CLIENTE_NIF_RECOMENDADO);
    // Crea el cliente y lo devuelve
    return new Cliente(rest.getString(C_CLIENTE_NIF), rest.getString(C_CLIENTE_NOMBRE),
        rest.getString(C_CLIENTE_APELLIDOS), rest.getString(C_CLIENTE_DIRECCION), nifRecomendado);
  }

  /**
   * Crea una venta de un Result
   * 
   * @param rs
   * @return
   * @throws SQLException
   */
  private Venta obtenerVentaResult(ResultSet rest) throws SQLException {
    return new Venta(rest.getInt(V_VENTA_CODIGO), rest.getString(V_VENTA_NIFCLIENTE),
        rest.getString(V_VENTA_REFERENCIAMOTO), rest.getString(V_VENTA_FECHA));
  }

  /**
   * Crea una cadena en base de una venta
   * 
   * @param venta
   * @return
   */
  private String obtenerVentaResultString(Venta venta) {
    return venta.getCodigo() + venta.getNifCliente() + venta.getReferenciaMotocicleta() + venta.getFecha();
  }

}
