package prog.unidad08.relacion02.proveedor.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import prog.unidad08.relacion02.entidades.Centro;
import prog.unidad08.relacion02.proveedor.ProveedorAlmacenamientoEmpresa;

/**
 * Clase para consultar la base de datos
 */
public class ProveedorAlmacenamientoEmpresaSQLite implements ProveedorAlmacenamientoEmpresa {

  // Constantes
  // URL Base para conectar con SQLite
  private static final String URL_BASE = "jdbc:sqlite:";


  //Atributos
  // Ruta a la base de datos SQLite
  private String rutaDB;
  
  // Campos de tabla centro
  private static final String C_CENTRO_CODIGO = "numce";
  private static final String C_CENTRO_NOMBRE = "nomce";
  
  /**
   * Constructor
   * 
   * @param rutaDB Ruta a la base de datos a emplear.
   */
  public ProveedorAlmacenamientoEmpresaSQLite(String rutaDB) {
    this.rutaDB = rutaDB;
  }

  @Override
  public Centro getCentroByCodigo(int codigo) {
    // TODO Auto-generated method stub
    return null;
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
   * Obtiene conexion a la base de datos
   * 
   * @return Conexión a la base de datos
   * @throws SQLException Si ocurre cualquier error accediendo a la base de datos
   */
  private Connection getConexion() throws SQLException {
    //Crea la conexion con la base de datos uniendo las cadenas
    return DriverManager.getConnection(URL_BASE + rutaDB);
  }
  /**
   * Obtiene un centro de resultSet
   * @param ResultSet
   * @throws SQLException 
   */
  private Centro obtenerCentroResult(ResultSet respuesta) throws SQLException{
    return new Centro(respuesta.getInt(C_CENTRO_CODIGO), respuesta.getString(C_CENTRO_NOMBRE));
  }

}
