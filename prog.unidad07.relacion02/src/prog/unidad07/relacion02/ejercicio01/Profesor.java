package prog.unidad07.relacion02.ejercicio01;

/**
 * Profesor del centro
 */
public class Profesor extends Empleado {

  // Atributos
  // Departamento del profesor
  private String departamento;

  /**
   * Constructor
   * @param nombre Nombre del profesor
   * @param dni DNI del profesor
   * @param estadoCivil Estado civil del profesor
   * @param anyoIncorporacion Año de incorporación al centro
   * @param despacho Despacho asignado
   * @param departamento Departamento al que pertenece
   */
  public Profesor(String nombre, String dni, String estadoCivil, int anyoIncorporacion,
      String despacho, String departamento) {
    super(nombre, dni, estadoCivil, anyoIncorporacion, despacho);
    this.departamento = departamento;
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
    return super.toString() + String.format(", Departamento: \"%s\"", departamento);
  }
  
}
