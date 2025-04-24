package prog.unidad08.relacion01.ejercicio05.preparadores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Crea sentencias preparadas
 */
public interface PreparadorSentencia {
  
  /**
   * Obtiene una sentencia preparada sobre la conexión indicada
   * @param conexion Conexion sobre la que preparar la sentencia
   * @return Sentencia preparada
   * @throws SQLException Si ocurre cualquier problema
   */
  PreparedStatement preparaSentencia(Connection conexion) throws SQLException;

}
