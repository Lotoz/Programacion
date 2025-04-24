package prog.unidad08.relacion01.ejercicio05.generadores;

/**
 * Generador de sentencias para eliminar pueblos cuya extensión sea menor que una especificada
 */
public class GeneradorSentenciaExtensionMenorQue implements GeneradorSentencia {

  // Atributos
  // Extensión minima
  private double extension;
  
  /**
   * Constructor
   * @param extension Extensión minima del pueblo
   */
  public GeneradorSentenciaExtensionMenorQue(double extension) {
    this.extension = extension;
  }

  @Override
  public String generaSentencia() {
    // Crea un DELETE para los pueblos cuya extensión sea menor que la especificada
    return "DELETE FROM pueblos WHERE extension < " + extension;
  }

}
