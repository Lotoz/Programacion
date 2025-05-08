package prog.unidad08.relacion01.ejercicio05.generadores;

/**
 * Generador para sentencias que eliminan pueblos cuya población sea superior a una especificada
 */
public class GeneradorSentenciaPoblacionMayorQue implements GeneradorSentencia {

  // Atributos
  // Poblacion maxima
  private int poblacion;
  
  /**
   * Constructor
   * @param poblacion Poblacion maxima 
   */
  public GeneradorSentenciaPoblacionMayorQue(int poblacion) {
    this.poblacion = poblacion;
  }

  @Override
  public String generaSentencia() {
    // Genera un DELETE para todos los pueblos cuya población sea superior a la maxima
    return "DELETE FROM pueblos WHERE pob_total > " + poblacion;
  }

}
