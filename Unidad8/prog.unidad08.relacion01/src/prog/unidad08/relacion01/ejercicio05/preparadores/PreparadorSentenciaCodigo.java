package prog.unidad08.relacion01.ejercicio05.preparadores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Prepara una sentencia para eliminar una población por su codigo
 */
public class PreparadorSentenciaCodigo implements PreparadorSentencia {

  // Constantes
  // Plantilla SQL
  private static final String SQL = "DELETE FROM pueblos WHERE codigo = ?";
  
  // Atibutos
  // Código d poblacion
  private String codigo;
  
  /**
   * Constructor
   * @param codigo Codigo de la poblacion a eliminar
   */
  public PreparadorSentenciaCodigo(String codigo) {
    this.codigo = codigo;
  }
  
  @Override
  public PreparedStatement preparaSentencia(Connection conexion) throws SQLException {
    // Prepara la sentencia y añade el código
    PreparedStatement resultado = conexion.prepareStatement(SQL);
    resultado.setString(1, codigo);
    
    // La devuelve
    return resultado;
  }

}
