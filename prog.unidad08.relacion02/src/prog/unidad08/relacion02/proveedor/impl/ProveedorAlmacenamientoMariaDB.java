package prog.unidad08.relacion02.proveedor.impl;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.mariadb.jdbc.MariaDbConnection;
import org.mariadb.jdbc.MariaDbPooledConnection;

import prog.unidad08.relacion02.entidades.Centro;
import prog.unidad08.relacion02.proveedor.ProveedorAlmacenamientoEmpresa;
import prog.unidad08.relacion02.proveedor.ProveedorAlmacenamientoEmpresaException;

/**
 * Ahora para mariaDB
 */
public class ProveedorAlmacenamientoMariaDB implements ProveedorAlmacenamientoEmpresa {

  //Constantes 
  private static final String URL_BASE = "jdbc:mariaDB:";
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
   * @param String rutaDB
   */
  public ProveedorAlmacenamientoMariaDB(String rutaDB) {
    this.rutaDB = rutaDB;
  }

  @Override
  public Centro getCentroByCodigo(int codigo) {
    try (Connection conexion = conexion();
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
        centro = obtenerCentroResultSet(rs); 
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
  public List<Centro> getAllCentro(boolean ordenarPorNombre) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Centro addCentro(Centro centro) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void updateCentro(Centro centro) {
    // TODO Auto-generated method stub

  }

  @Override
  public void deleteCentroByCodigo(int codigo) {
    // TODO Auto-generated method stub

  }
  /**
   * Hace la conexion
   * @return
   * @throws SQLException
   */
  private MariaDbConnection conexion() throws SQLException {
    return MariaDb(URL_BASE + rutaDB);
  }

  /**
   * Obtiene un centro a partir de un resultset sobre la tabla centro
   * @param rs ResultSet sobre la tabla centro
   * @return Centro con los datos de la fila actual del resultset
   * @throws SQLException Si ocurre cualquier error accediendo a la fila
   */
  private Centro obtenerCentroResultSet(ResultSet res) throws SQLException {
    //Obtiene el centro de la tabla en consulta
    return new Centro(res.getInt(C_CENTRO_CODIGO), res.getString(C_CENTRO_NOMBRE));
  }

}
