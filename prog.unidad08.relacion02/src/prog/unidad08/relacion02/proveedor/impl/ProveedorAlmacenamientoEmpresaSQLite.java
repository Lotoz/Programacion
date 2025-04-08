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
import prog.unidad08.relacion02.proveedor.ProveedorAlmacenamientoEmpresa;
import prog.unidad08.relacion02.proveedor.ProveedorAlmacenamientoEmpresaException;

public class ProveedorAlmacenamientoEmpresaSQLite implements ProveedorAlmacenamientoEmpresa {

  //Constantes 
  private static final String URL_BASE = "jdbc:sqlite:";
  // Sentencias SQL
  private static final String SQL_GET_CENTRO_BY_CODIGO = "SELECT * FROM centro WHERE numce = ?";
  private static final String SQL_GET_ALL_CENTRO = "SELECT * FROM centro";
  private static final String SQL_GET_ALL_CENTRO_ORDENADO = "SELECT * FROM centro ORDER BY nomce ASC";
  private static final String SQL_ADD_CENTRO = "INSERT INTO centro(nomce) VALUES (?)";
  private static final String SQL_UPDATE_CENTRO = "UPDATE centro SET nomce = ? WHERE numce = ?";
  private static final String SQL_DELETE_CENTRO = "DELETE FROM centro WHERE numce = ?";
  // Campos de tabla centro
  private static final String C_CENTRO_CODIGO = "numce";
  private static final String C_CENTRO_NOMBRE = "nomce";
  
  //Atributos
  private String rutaDB;
  /**
   * Constructor
   * @param rutaDB - Ruta a la base de datos a emplear.
   */
  public ProveedorAlmacenamientoEmpresaSQLite(String rutaDB) {
    this.rutaDB = rutaDB;
  }

  @Override
  public Centro getCentroByCodigo(int codigo) throws ProveedorAlmacenamientoEmpresaException {
    try (Connection conexion = getConexion();
        PreparedStatement sentencia = conexion.prepareStatement(SQL_GET_CENTRO_BY_CODIGO)) {
      // Rellenamos los parámetros de la sentencia
      sentencia.setInt(1, codigo);
      // Ejecuta la consulta
      ResultSet rs = sentencia.executeQuery();
   // Centro a devolver
      Centro centro = null;
      // Si se encontró el centro
      if (rs.next()) {
        // Lo obtiene, codigo y nombre
        centro = getCentroFromResultSet(rs); 
      }
      // Cierra el resultset
      rs.close();
      // Y devuelve el centro (o null)
      return centro;
    } catch (SQLException e) {
      throw new ProveedorAlmacenamientoEmpresaException("Error JDBC en getCentroByCodigo: " + e.getMessage());
    }
  }

  @Override
  public List<Centro> getAllCentro(boolean ordenarPorNombre) throws ProveedorAlmacenamientoEmpresaException {
    // Determinamos el SQL a emplear (ordenando o no)
    String sql = ordenarPorNombre ? SQL_GET_ALL_CENTRO_ORDENADO : SQL_GET_ALL_CENTRO;
    
    // Obtenemos conexión y consulta
    try (Connection conexion = getConexion();
         PreparedStatement sentencia = conexion.prepareStatement(sql)) {
      // Ejecuta la consulta
      ResultSet rs = sentencia.executeQuery();
      // Lista con los centros
      List<Centro> resultado = new ArrayList<>();
      // Para cada centro
      while (rs.next()) {
        // Lo obtiene y lo almacena
        resultado.add(getCentroFromResultSet(rs));
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
  public Centro addCentro(Centro centro) throws ProveedorAlmacenamientoEmpresaException, NullPointerException {
    // Pilla la conexion y usa la sentencia ya dada en constante
    //El metodo debe agregar el centro y devolver que centro agrego
    try (Connection conexion = getConexion();
         PreparedStatement sentencia = conexion.prepareStatement(SQL_ADD_CENTRO
           , Statement.RETURN_GENERATED_KEYS)) {
      // Rellena el nombre (el código se genera automáticamente
      sentencia.setString(1, centro.getNombre());
      // Ejecuta la actualizacion
      sentencia.executeUpdate();
      // Obtenemos la clave
      ResultSet respuesta = sentencia.getGeneratedKeys();
      // Si hubo clave
      if (respuesta.next()) {
        centro = new Centro(respuesta.getInt(1), centro.getNombre());
      }
      // Cierra el resultset
      respuesta.close();
      // Y devuelve el centro
      return centro;
    } catch (SQLException e) {
      throw new ProveedorAlmacenamientoEmpresaException("Error JDBC en addCentro: "
        + e.getMessage());
    }
   }

  @Override
  public void updateCentro(Centro centro) throws ProveedorAlmacenamientoEmpresaException, NullPointerException {
 // Obtenemos conexión y sentencia
    try (Connection conexion = getConexion();
         PreparedStatement sentencia = conexion.prepareStatement(SQL_UPDATE_CENTRO)) {
      // Rellena el nombre y codigo
      sentencia.setString(1, centro.getNombre());
      sentencia.setInt(2, centro.getCodigo());
      // Ejecuta la actualizacion
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
  public void deleteCentroByCodigo(int codigo) throws ProveedorAlmacenamientoEmpresaException {
 // Obtenemos conexión y sentencia
    try (Connection conexion = getConexion();
         PreparedStatement sentencia = conexion.prepareStatement(SQL_DELETE_CENTRO)) {
      // Rellena el codigo
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
  /**
   * Hace la conexion
   * @return
   * @throws SQLException
   */
  private Connection getConexion() throws SQLException {
    return DriverManager.getConnection(URL_BASE + rutaDB);
  }

  /**
   * Obtiene un centro a partir de un resultset sobre la tabla centro
   * @param rs ResultSet sobre la tabla centro
   * @return Centro con los datos de la fila actual del resultset
   * @throws SQLException Si ocurre cualquier error accediendo a la fila
   */
  private Centro getCentroFromResultSet(ResultSet rs) throws SQLException {
    //Obtiene el centro de la tabla en consulta
    return new Centro(rs.getInt(C_CENTRO_CODIGO), rs.getString(C_CENTRO_NOMBRE));
  }
}
