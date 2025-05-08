package prog.unidad08.relacion01.ejercicio05.preparadores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Preparador de sentencias que eliminan poblaciones cuya población es superior a un máximo
 */
public class PreparadorSentenciaPoblacion implements PreparadorSentencia {

  // Constantes
  // Plantilla SQL
  private static final String SQL = "DELETE FROM pueblos WHERE pob_total > ?";
  
  // Atributos
  // Población máxima
  private int poblacion;
  
  /**
   * Constructor
   * @param poblacion Población máxima
   */
  public PreparadorSentenciaPoblacion(int poblacion) {
    this.poblacion = poblacion;
  }

  @Override
  public PreparedStatement preparaSentencia(Connection conexion) throws SQLException {
    // Prepara y rellena la sentencia
    PreparedStatement resultado = conexion.prepareStatement(SQL);
    resultado.setInt(1, poblacion);
    
    // Devuelve el resultado
    return resultado;
  }

}
