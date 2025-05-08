package prog.unidad08.relacion01.ejercicio05.generadores;

/**
 * Genera una sentencia SQL para eliminar una población por su código
 */
public class GeneradorSentenciaCodigo implements GeneradorSentencia {
  
  // Atributos
  // Código de la población
  private String codigo;
  
  /**
   * Constructor
   * @param codigo Código de la población a eliminar
   */
  public GeneradorSentenciaCodigo(String codigo) {
    this.codigo = codigo;
  }

  @Override
  public String generaSentencia() {
    // Genera la sentencia DELETE para eliminar a la población con el código especificado
    return "DELETE FROM pueblos WHERE codigo = '" + codigo + "'";
  }

}
