package prog.unidad07.relacion02.ejercicio05;

/**
 * Personal de administración y servicios del centro
 */
public class AdministracionServicios extends Empleado {

  // Constantes
  // Salario por hora
  private static final double SALARIO_POR_HORA = 15;
  
  // Atributos
  // Sección del centro asignada
  private String seccion;
  // Número de horas que se trabaja por mes
  private int horas;

  /**
   * Constructor
   * @param nombre Nombre del personal
   * @param dni DNI del personal
   * @param estadoCivil Estado civil
   * @param anyoIncorporacion Año de incorporación al centro
   * @param despacho Despacho asignado
   * @param seccion Sección en la que trabaja
   * @param horas Horas trabajadas en el mes
   */
  public AdministracionServicios(String nombre, String dni, String estadoCivil, int anyoIncorporacion,
      String despacho, String seccion, int horas) {
    super(nombre, dni, estadoCivil, anyoIncorporacion, despacho);
    this.seccion = seccion;
    this.horas = horas;
  }
  
  /**
   * Asigna una nueva sección el empleado de administración y servicios
   * @param seccion Nueva sección
   */
  public void setSeccion(String seccion) {
    this.seccion = seccion;
  }

  @Override
  public String toString() {
    return "(PAS): " + super.toString() + String.format(", Seccion: %s", seccion);
  }

  @Override
  public double getSalario() {
    // Calcula el salario multiplicando las horas por el salario por hora
    return horas * SALARIO_POR_HORA;
  }
  
  
}
