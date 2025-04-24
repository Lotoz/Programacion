package prog.unidad08.relacion01.ejercicio05.preparadores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Preparador de sentencia que elimina los pueblos cuya extensión sea menor que una mínima
 */
public class PreparadorSentenciaExtension implements PreparadorSentencia {

  // Constantes
  // Plantilla SQL
  private static final String SQL = "DELETE FROM pueblos WHERE extension < ?";
  
  // Atributos
  // Extensión minima de la población
  private double extension;
  
  /**
   * Constructor
   * @param extension Extensión mínima de la poblacion
   */
  public PreparadorSentenciaExtension(double extension) {
    this.extension = extension;
  }
  @Override
  public PreparedStatement preparaSentencia(Connection conexion) throws SQLException {
    // Prepara y rellena la sentencia
    PreparedStatement resultado = conexion.prepareStatement(SQL);
    resultado.setDouble(1, extension);
    // La devuelve
    return resultado;
  }

}
