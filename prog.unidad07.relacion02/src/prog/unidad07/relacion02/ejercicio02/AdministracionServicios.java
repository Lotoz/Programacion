package prog.unidad07.relacion02.ejercicio02;

/**
 * Personal de administración y servicios del centro
 */
public class AdministracionServicios extends Empleado {

  // Atributos
  // Sección del centro asignada
  private String seccion;

  /**
   * Constructor
   * @param nombre Nombre del personal
   * @param dni DNI del personal
   * @param estadoCivil Estado civil
   * @param anyoIncorporacion Año de incorporación al centro
   * @param despacho Despacho asignado
   * @param seccion Sección en la que trabaja
   */
  public AdministracionServicios(String nombre, String dni, String estadoCivil, int anyoIncorporacion,
      String despacho, String seccion) {
    super(nombre, dni, estadoCivil, anyoIncorporacion, despacho);
    this.seccion = seccion;
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
    return super.toString() + String.format(", Seccion: %s", seccion);
  }
  
  
}
