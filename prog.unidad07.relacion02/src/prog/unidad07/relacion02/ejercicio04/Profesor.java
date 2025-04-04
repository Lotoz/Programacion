package prog.unidad07.relacion02.ejercicio04;

/**
 * Profesor del centro
 */
public class Profesor extends Empleado {

  // Atributos
  // Departamento del profesor
  private String departamento;
  // Salario mensual
  private double salario;

  /**
   * Constructor
   * @param nombre Nombre del profesor
   * @param dni DNI del profesor
   * @param estadoCivil Estado civil del profesor
   * @param anyoIncorporacion Año de incorporación al centro
   * @param despacho Despacho asignado
   * @param departamento Departamento al que pertenece
   * @param salario Salario mensual del profesor
   */
  public Profesor(String nombre, String dni, String estadoCivil, int anyoIncorporacion,
      String despacho, String departamento, double salario) {
    super(nombre, dni, estadoCivil, anyoIncorporacion, despacho);
    this.departamento = departamento;
    this.salario = salario;
  }
  
  /**
   * Asigna un nuevo departamento al profesor
   * @param departamento Nuevo departamento del profesor
   */
  public void setDepartamento(String departamento) {
    this.departamento = departamento;
  }

  @Override
  public String toString() {
    return "(Profesor): " + super.toString() + String.format(", Departamento: \"%s\"", departamento);
  }

  @Override
  public double getSalario() {
    // Devuelve simplemente el salario
    return salario;
  }
  
}
