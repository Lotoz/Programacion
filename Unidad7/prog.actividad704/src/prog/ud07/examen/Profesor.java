package prog.ud07.examen;

/**
 * Representa un profesor
 */
public abstract class Profesor extends Persona {

  /**
   * Atributos de la clase
   */
  // anyos que ha trabajado un profesor
  protected int anyosAntiguedad;

  /**
   * Constructor de un profesor
   * 
   * @param nombre
   * @param dni
   * @param anyosAntiguedad
   * @param salario
   */
  protected Profesor(String nombre, String dni, int anyosAntiguedad) {
    super(nombre, dni);
    validaAnyos(anyosAntiguedad);
    this.anyosAntiguedad = anyosAntiguedad;
  }

  /**
   * Obtiene anyos de antiguedad
   * 
   * @return
   */
  public int getAnyosAntiguedad() {
    return anyosAntiguedad;
  }

  /**
   * valida si los anyos son positivos, ya que no puede haber anyos negativos
   * 
   * @param anyosAntiguedad
   * @throws IllegalArgumentException
   */
  protected void validaAnyos(int anyos) {
    if (anyos <= -1) {
      throw new IllegalArgumentException("Anyos invalidos");
    }
  }

  /**
   * Metodo que calcula cuanto es el aumento por anyos trabajados.
   * 
   * @param anyos
   * @return porcentaje de aumento
   */
  protected abstract double anyosCurrados(int anyos);

}
