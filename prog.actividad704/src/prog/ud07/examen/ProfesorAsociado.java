package prog.ud07.examen;

/**
 * Un profesor asociado es aquel que no tiene plaza fija y cubre un puesto de
 * forma temporal.
 */
public class ProfesorAsociado extends Profesor implements PagoSeguro {

  /**
   * Atributos de la clase
   */
  private double salario = 2500;

  /**
   * Constructor de un profesor asociado
   * 
   * @param nombre
   * @param dni
   * @param anyosAntiguedad
   * @param salario
   */
  public ProfesorAsociado(String nombre, String dni, int anyosAntiguedad) {
    super(nombre, dni, anyosAntiguedad);

  }

  /**
   * Profesor tiene un salario que por cada anyo de antiguedad + 100
   */
  public double getSalario() {
    return salario + anyosCurrados(anyosAntiguedad);
  }

  /**
   * Seguro que paga un profesor asociado
   */
  @Override
  public double importeSeguro() {
    return 1500;
  }

  /**
   * Metodo que calcula cuanto es el aumento por anyos trabajados.
   * 
   * @param anyos
   * @return porcentaje de aumento
   */
  @Override
  protected double anyosCurrados(int anyos) {
    if (anyos < 0) {
      return anyos;
    }
    return anyos * 100;
  }
}
