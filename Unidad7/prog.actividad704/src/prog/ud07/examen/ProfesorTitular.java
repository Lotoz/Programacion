package prog.ud07.examen;

/**
 * Un profesor titular es aquel que tiene plaza fija en la universidad.
 */
public class ProfesorTitular extends Profesor implements PagoSeguro {

  /**
   * Atributos de la clase
   */
  private double salario = 3000;

  /**
   * Constructor de un profesor
   * 
   * @param nombre
   * @param dni
   * @param anyosAntiguedad
   * @param salario
   */
  public ProfesorTitular(String nombre, String dni, int anyosAntiguedad) {
    super(nombre, dni, anyosAntiguedad);
  }

  /**
   * Profesor tiene un salario que por cada anyo de antiguedad se multiplica por
   * 0.05
   */
  public double getSalario() {
    return salario + aumentoSalarial(salario);
  }

  /**
   * Seguro que paga un profesor titular
   */
  @Override
  public double importeSeguro() {
    return 1500;
  }

  /**
   * Calcula el aumento segun los anyos trabajados
   * @param anyos
   */
  @Override
  protected double anyosCurrados(int anyos) {
    if (anyos > 0) {
      return anyos * 0.05;
    }
    return 1;
  }

  /**
   * Calcula el aumento salarial que se le debe aplicar juntos a los anyos trabajados
   * @param salario
   * @return
   */
  private double aumentoSalarial(double salario) {
    if (anyosAntiguedad > 0) {
      return salario * anyosCurrados(anyosAntiguedad);
    }
    return 0;
  }

}
