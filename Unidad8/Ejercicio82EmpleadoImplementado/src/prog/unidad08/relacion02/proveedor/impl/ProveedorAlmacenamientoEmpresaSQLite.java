package prog.unidad08.relacion02.proveedor.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import prog.unidad08.relacion02.entidades.Centro;
import prog.unidad08.relacion02.entidades.Departamento;
import prog.unidad08.relacion02.entidades.Empleado;
import prog.unidad08.relacion02.proveedor.ProveedorAlmacenamientoEmpresa;
import prog.unidad08.relacion02.proveedor.ProveedorAlmacenamientoEmpresaException;

public class ProveedorAlmacenamientoEmpresaSQLite implements ProveedorAlmacenamientoEmpresa {

//Constantes
 // URL Base para conectar con SQLite
 private static final String URL_BASE = "jdbc:sqlite";

//Sentencias SQL
//Se deben usar cuando deseas hacer una sentencia preparada
 // El ? es donde pondres el dato a usar
 private static final String SQL_GET_CENTRO_BY_CODIGO = "SELECT * FROM centro WHERE numce = ?";
 private static final String SQL_GET_ALL_CENTRO = "SELECT * FROM centro";
 private static final String SQL_GET_ALL_CENTRO_ORDENADO = "SELECT * FROM centro ORDER BY nomce ASC";
 private static final String SQL_ADD_CENTRO = "INSERT INTO centro(nomce) VALUES (?)";
 private static final String SQL_UPDATE_CENTRO = "UPDATE centro SET nomce = ? WHERE numce = ?";
 private static final String SQL_DELETE_CENTRO = "DELETE FROM centro WHERE numce = ?";

 
 //Consultas de la tabla departamento
 private static final String SQL_GET_ALL_DEPARTAMENTO_ORDENADO = "SELECT * FROM departamento ORDER BY nomde ASC";
 private static final String SQL_GET_ALL_DEPARTAMENTO = "SELECT * FROM departamento";
 private static final String SQL_GET_DEPARTAMENTO_BY_CODIGO = "SELECT * FROM departamento WHERE numde = ?";
 private static final String SQL_ADD_DEPARTAMENTO = "INSERT INTO departamento(nomde, numce, direc, tidir, presu, depde) VALUES (?, ?, ?, ?, ?, ?)";
 private static final String SQL_UPDATE_DEPARTAMENTO = "UPDATE departamento SET nomde = ?, numce = ?, direc = ?, tidir = ?, presu = ?, depde = ? where numde = ?";
 private static final String SQL_DELETE_DEPARTAMENTO = "DELETE FROM departamento WHERE numde = ?";

 
 //Consultas de la tabla empleados 
 private static final String SQL_GET_EMPLEADO_BY_CODIGO = "SELECT * FROM empleado WHERE numem = ?";
 
 // Atributos
 // Ruta a la base de datos SQLite
 private String rutaDB;

 // Campos de tabla centro
 private static final String C_CENTRO_CODIGO = "numce";
 private static final String C_CENTRO_NOMBRE = "nomce";

 //Campos de tabla departamento
 private static final String D_DEPARTAMENTO_CODIGO = "numde";
 private static final String D_DEPARTAMENTO_CENTRO = "numce";
 private static final String D_DEPARTAMENTO_DIRECCION = "direc";
 private static final String D_DEPARTAMENTO_NUMERODIRECTOR = "tidir";
 private static final String D_DEPARTAMENTO_PRESUPUESTO = "presu";
 private static final String D_DEPARTAMENTO_DEPENDIENTE = "depde";
 private static final String D_DEPARTAMENTO_NOMBRE = "nomde";
 
 //Campos de la tabla empleados
 private static final String E_EMPLEADO_CODIGO = "numem";
 private static final String E_EMPLEADO_DEPARTAMENTO = "numde";
 private static final String E_EMPLEADO_TELEFONO = "extel";
 private static final String E_EMPLEADO_FECHANACIMIENTO = "fecna";
 private static final String E_EMPLEADO_FECHAINICIO = "fecin";
 private static final String E_EMPLEADO_SALARIO = "salar";
 private static final String E_EMPLEADO_COMISION = "comis";
 private static final String E_EMPLEADO_NUMEROHIJOS = "numhi"; 
 private static final String E_EMPLEADO_NOMBRE = "nomem";

 /**
  * Constructor
  * 
  * @param rutaDB Ruta a la base de datos a emplear.
  */
 public ProveedorAlmacenamientoEmpresaSQLite(String rutaDB) {
   // Se define esta ruta, no olvidar crear un metodo obtener conexion abajo
   this.rutaDB = rutaDB;
 }

 @Override
 public Centro getCentroByCodigo(int codigo) {
// Obtenemos conexión y consulta
   //Usando el metodo getConexion
   //Como vamos a usar una preparada, usamos PreparedStatement
   try (Connection conexion = getConexion();
        PreparedStatement sentencia = conexion.prepareStatement(SQL_GET_CENTRO_BY_CODIGO)) {
     // Rellenamos los parámetros de la sentencia
     //Los parametros de la sentencia son los ?
     //"SELECT * FROM centro WHERE numce = ?"; Al poner 1, mas codigo, estamos poniendo que sea el default, clave generada
     sentencia.setInt(1, codigo);
     // Ejecuta la consulta
     ResultSet rs = sentencia.executeQuery();
     //Inicializamos centro
     Centro centro = null;
     // Si se encontró el centro nos obtiene el centro con nuestro metodo especifico
     if (rs.next()) {
       // Lo obtiene
       centro = obtenerCentroResult(rs); 
     }
     // Cierra el resultset
     rs.close();
     // Y devuelve el centro (o null) (Se permiten nulos)
     return centro;
   } catch (SQLException e) {
     throw new ProveedorAlmacenamientoEmpresaException("Error JDBC en getCentroByCodigo: "
       + e.getMessage());
   }
 }

 @Override
 public List<Centro> getAllCentro(boolean ordenarPorNombre) {
   // Determinamos el SQL a emplear (ordenando o no)
   //En este ternario se define, que si es true, lo ordenara si no, son todos los centros como vienen
   String sql = ordenarPorNombre ? SQL_GET_ALL_CENTRO_ORDENADO : SQL_GET_ALL_CENTRO;
   
   // Obtenemos conexión y consulta
   try (Connection conexion = getConexion();
        PreparedStatement sentencia = conexion.prepareStatement(sql)) {
     // Ejecuta la consulta
     ResultSet rs = sentencia.executeQuery();
     // Inicializamos una lista
     List<Centro> resultado = new ArrayList<>();
     // y por cada centro 
     //El metodo next funciona de modo que recorriendo, siempre con while
     while (rs.next()) {
       // Lo obtiene y lo almacena en la lista
       resultado.add(obtenerCentroResult(rs));
     }
     // Cierra el resultset
     rs.close();
     // Y devuelve el resultado
     return resultado;
   } catch (SQLException e) {
     throw new ProveedorAlmacenamientoEmpresaException("Error JDBC en getAllCentro: "
       + e.getMessage());
   }
 }

 @Override
 public Centro addCentro(Centro centro) {
// Obtenemos conexión y sentencia
   try (Connection conexion = getConexion();
        PreparedStatement sentencia = conexion.prepareStatement(SQL_ADD_CENTRO
          , Statement.RETURN_GENERATED_KEYS)) {
     // Rellena el nombre (el código se genera automáticamente
     //Ya que estamos usando Statement returned generated keys
     //Poinemos 1 de default y luego nombre del centro que nos de el usuario
     sentencia.setString(1, centro.getNombre());
     // Ejecuta la actualizacion
     sentencia.executeUpdate();
     // Obtenemos la clave de la sentencia propia, que genera ella sola, asi se la asignamos al centro
     ResultSet rs = sentencia.getGeneratedKeys();
     // Si hubo clave lo ira agregando
     if (rs.next()) {
       centro = new Centro(rs.getInt(1), centro.getNombre());
     }
     // Cierra el resultset
     rs.close();
     // Y devuelve el centro
     return centro;
   } catch (SQLException e) {
     throw new ProveedorAlmacenamientoEmpresaException("Error JDBC en addCentro: "
       + e.getMessage());
   }
 }

 @Override
 public void updateCentro(Centro centro) {
   // Obtenemos conexión y sentencia
   try (Connection conexion = getConexion();
        PreparedStatement sentencia = conexion.prepareStatement(SQL_UPDATE_CENTRO)) {
     // Rellena el nombre y codigo
     //En este caso ponemos 2 ya para indicar el cambio numerico en la generated key
     sentencia.setString(1, centro.getNombre());
     sentencia.setInt(2, centro.getCodigo());
     // Ejecuta la actualizacion
     //Esta se ejecuta mientras sea distinto de uno, si no, explota
     if (sentencia.executeUpdate() != 1) {
       throw new ProveedorAlmacenamientoEmpresaException("Error en updateCentro. El centro"
         + "indicado no existe en la base de datos");
     }
   } catch (SQLException e) {
     throw new ProveedorAlmacenamientoEmpresaException("Error JDBC en updateCentro: "
       + e.getMessage());
   }
 }

 @Override
 public void deleteCentroByCodigo(int codigo) {
// Obtenemos conexión y sentencia
   try (Connection conexion = getConexion();
        PreparedStatement sentencia = conexion.prepareStatement(SQL_DELETE_CENTRO)) {
     // Rellena el codigo de la generated key
     sentencia.setInt(1, codigo);
     // Ejecuta la actualizacion
     if (sentencia.executeUpdate() != 1) {
       throw new ProveedorAlmacenamientoEmpresaException("Error en deleteCentroByCodigo. El centro"
           + "indicado no existe en la base de datos");
     }
   } catch (SQLException e) {
     throw new ProveedorAlmacenamientoEmpresaException("Error JDBC en deleteCentroByCodigo: "
       + e.getMessage());
   }

 }

  @Override
  public List<Departamento> getDepartamentoAll(boolean ordenarPorNombre) {
 // Determinamos el SQL a emplear (ordenando o no)
    //En este ternario se define, que si es true, lo ordenara si no, son todos los centros como vienen
    String sql = ordenarPorNombre ? SQL_GET_ALL_DEPARTAMENTO_ORDENADO : SQL_GET_ALL_DEPARTAMENTO;
    //String sql = SQL_GET_ALL_DEPARTAMENTO;
    // Obtenemos conexión y consulta
    try (Connection conexion = getConexion();
         PreparedStatement sentencia = conexion.prepareStatement(sql)) {
      // Ejecuta la consulta
      ResultSet rs = sentencia.executeQuery();
      // Inicializamos una lista
      List<Departamento> resultado = new ArrayList<>();
      // y por cada departamento
      //El metodo next funciona de modo que recorriendo, siempre con while
      while (rs.next()) {
        // Lo obtiene y lo almacena en la lista
        resultado.add(obtenerDepartamentoResult(rs));
      }
      // Cierra el resultset
      rs.close();
      // Y devuelve el resultado
      return resultado;
    } catch (SQLException e) {
      throw new ProveedorAlmacenamientoEmpresaException("Error JDBC en getAllCentro: "
        + e.getMessage());
    }
  }

  @Override
  public Departamento getDepartamentoByCodigo(int codigo) {
 // Obtenemos conexión y consulta
    //Usando el metodo getConexion
    //Como vamos a usar una preparada, usamos PreparedStatement
    try (Connection conexion = getConexion();
         PreparedStatement sentencia = conexion.prepareStatement(SQL_GET_DEPARTAMENTO_BY_CODIGO)) {
      // Rellenamos los parámetros de la sentencia
      //Los parametros de la sentencia son los ?
      //"SELECT * FROM centro WHERE numce = ?"; el ? es lo que pone el usuario y lo primero es la posicion
      sentencia.setInt(1, codigo);
      // Ejecuta la consulta
      ResultSet rs = sentencia.executeQuery();
      //Inicializamos centro
      Departamento departamento = null;
      // Si se encontró el centro nos obtiene el centro con nuestro metodo especifico
      if (rs.next()) {
        // Lo obtiene
        departamento = obtenerDepartamentoResult(rs); 
      }
      // Cierra el resultset
      rs.close();
      // Y devuelve el centro (o null) (Se permiten nulos)
      return departamento;
    } catch (SQLException e) {
      throw new ProveedorAlmacenamientoEmpresaException("Error JDBC en getCentroByCodigo: "
        + e.getMessage());
    }
  }

  @Override
  public Departamento addDepartamento(Departamento departamento) {
    try (Connection conexion = getConexion();
        PreparedStatement sentencia = conexion.prepareStatement(SQL_ADD_DEPARTAMENTO, Statement.RETURN_GENERATED_KEYS)) {
     
     // Establecer parámetros
     sentencia.setString(1, departamento.getNombre());
     sentencia.setInt(2, departamento.getCodigoCentro());
     sentencia.setString(3, departamento.getDireccion());
     sentencia.setInt(4, departamento.getCodigoDirector());
     sentencia.setDouble(5, departamento.getPresupuesto());

     // Manejo de depde null
     if (departamento.getCodigoDepartamentoSuperior() == null) {
       sentencia.setNull(6, java.sql.Types.INTEGER);
     } else {
       sentencia.setInt(6, departamento.getCodigoDepartamentoSuperior());
     }
     
     
     // Ejecutar y recuperar la clave generada
     sentencia.executeUpdate();
     ResultSet rs = sentencia.getGeneratedKeys();
     //Integer depde =  departamento.getCodigoDepartamentoSuperior();
     
     if (rs.next()) {
       departamento = new Departamento(
         rs.getInt(1),
         departamento.getNombre(),
         departamento.getCodigoCentro(),
         departamento.getDireccion(),
         departamento.getCodigoDirector(),
         departamento.getPresupuesto(),
         departamento.getCodigoDepartamentoSuperior()
       );
     }

     rs.close();
     return departamento;

   } catch (SQLException e) {
     throw new ProveedorAlmacenamientoEmpresaException("Error JDBC en addDepartamento: " + e.getMessage());
   }
  }

  @Override
  public void updateDepartamento(Departamento departamento) {
    // Obtenemos conexión y sentencia
    try (Connection conexion = getConexion();
         PreparedStatement sentencia = conexion.prepareStatement(SQL_UPDATE_DEPARTAMENTO)) {
      // Rellena el nombre y codigo
      //En este caso ponemos 2 ya para indicar el cambio numerico en la generated key
      sentencia.setString(1, departamento.getNombre());
      sentencia.setInt(2, departamento.getCodigoCentro());
      sentencia.setString(3, departamento.getDireccion());
      sentencia.setInt(4, departamento.getCodigoDirector());
      sentencia.setDouble(5, departamento.getPresupuesto());
   // Manejo de depde null
      if (departamento.getCodigoDepartamentoSuperior() == null) {
        sentencia.setNull(6, java.sql.Types.INTEGER);
      } else {
        sentencia.setInt(6, departamento.getCodigoDepartamentoSuperior());
      }
      sentencia.setInt(7, departamento.getCodigo());
      
      // Ejecuta la actualizacion
      //Esta se ejecuta mientras sea distinto de uno, si no, explota
      if (sentencia.executeUpdate() != 1) {
        throw new ProveedorAlmacenamientoEmpresaException("Error en updateCentro. El centro"
          + "indicado no existe en la base de datos");
      }
    } catch (SQLException e) {
      throw new ProveedorAlmacenamientoEmpresaException("Error JDBC en updateCentro: "
        + e.getMessage());
    }
  }

  @Override
  public void deleteDepartamentoByCodigo(int codigo) {
 // Obtenemos conexión y sentencia
    try (Connection conexion = getConexion();
         PreparedStatement sentencia = conexion.prepareStatement(SQL_DELETE_DEPARTAMENTO)) {
      // Rellena el codigo de la generated key
      sentencia.setInt(1, codigo);
      // Ejecuta la actualizacion
      if (sentencia.executeUpdate() != 1) {
        throw new ProveedorAlmacenamientoEmpresaException("Error en deleteCentroByCodigo. El centro"
            + "indicado no existe en la base de datos");
      }
    } catch (SQLException e) {
      throw new ProveedorAlmacenamientoEmpresaException("Error JDBC en deleteCentroByCodigo: "
        + e.getMessage());
    }
  }

  @Override
  public Empleado getEmpleadoByCodigo(int codigo) {
 // Obtenemos conexión y consulta
    //Usando el metodo getConexion
    //Como vamos a usar una preparada, usamos PreparedStatement
    try (Connection conexion = getConexion();
         PreparedStatement sentencia = conexion.prepareStatement(SQL_GET_EMPLEADO_BY_CODIGO)) {
      // Rellenamos los parámetros de la sentencia
      //Los parametros de la sentencia son los ?
      //"SELECT * FROM centro WHERE numce = ?"; Al poner 1, mas codigo, estamos poniendo que sea el default, clave generada
      sentencia.setInt(1, codigo);
      // Ejecuta la consulta
      ResultSet rs = sentencia.executeQuery();
      //Inicializamos centro
      Empleado empleado = null;
      // Si se encontró el centro nos obtiene el centro con nuestro metodo especifico
      if (rs.next()) {
        // Lo obtiene
        empleado = obtenerEmpleadoResult(rs); 
      }
      // Cierra el resultset
      rs.close();
      // Y devuelve el centro (o null) (Se permiten nulos)
      return empleado;
    } catch (SQLException e) {
      throw new ProveedorAlmacenamientoEmpresaException("Error JDBC en getCentroByCodigo: "
        + e.getMessage());
    }
  }
  
  @Override
  public void updateEmpleado(Empleado empleado) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void deleteEmpleadoByCodigo(int codigo) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public Empleado addEmpleado(Empleado empleado) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Empleado> getEmpleadoAll(boolean ordenarPorNombre) {
    // TODO Auto-generated method stub
    return null;
  }

  
  /**
   * Obtiene conexion a la base de datos
   * 
   * @return Conexión a la base de datos
   * @throws SQLException Si ocurre cualquier error accediendo a la base de datos
   */
  private Connection getConexion() throws SQLException {
    // Crea la conexion con la base de datos uniendo las cadenas
    return DriverManager.getConnection(URL_BASE + rutaDB);
  }

  /**
   * Obtiene un centro de resultSet
   * 
   * @param ResultSet
   * @throws SQLException
   */
  private Centro obtenerCentroResult(ResultSet respuesta) throws SQLException {
    return new Centro(respuesta.getInt(C_CENTRO_CODIGO), respuesta.getString(C_CENTRO_NOMBRE));
  }
  /**
   * Obtiene un departamento de resultSet
   * @param respuesta
   * @return
   * @throws SQLException
   */
  private Departamento obtenerDepartamentoResult(ResultSet respuesta) throws SQLException {
    int depdeInt = respuesta.getInt(D_DEPARTAMENTO_DEPENDIENTE);
    //PORQUE SE PERMITEN VALORES NULOS
    Integer depde = respuesta.wasNull() ? null : depdeInt;

    return new Departamento(
      respuesta.getInt(D_DEPARTAMENTO_CODIGO),
      respuesta.getString(D_DEPARTAMENTO_NOMBRE),
      respuesta.getInt(D_DEPARTAMENTO_CENTRO),
      respuesta.getString(D_DEPARTAMENTO_DIRECCION),
      respuesta.getInt(D_DEPARTAMENTO_NUMERODIRECTOR),
      respuesta.getDouble(D_DEPARTAMENTO_PRESUPUESTO),
      depde
    );
  }
  
  /**
   * Obtiene un empleado de un resultSet
   * @param respuesta
   * @return
   * @throws SQLException
   */
  private Empleado obtenerEmpleadoResult(ResultSet respuesta) throws SQLException{
    return new Empleado(respuesta.getInt(E_EMPLEADO_CODIGO), respuesta.getString(E_EMPLEADO_NOMBRE), respuesta.getInt(E_EMPLEADO_DEPARTAMENTO), respuesta.getString(E_EMPLEADO_TELEFONO), respuesta.getString(E_EMPLEADO_FECHANACIMIENTO), respuesta.getString(E_EMPLEADO_FECHAINICIO),respuesta.getDouble(E_EMPLEADO_SALARIO), respuesta.getDouble(E_EMPLEADO_COMISION), respuesta.getInt(E_EMPLEADO_NUMEROHIJOS));
  }

 
}
