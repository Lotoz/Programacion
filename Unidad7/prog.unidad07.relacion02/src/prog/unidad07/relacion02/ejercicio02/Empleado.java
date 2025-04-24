package prog.unidad07.relacion02.ejercicio02;

/**
 * Empleado del centro
 */
public abstract class Empleado extends Persona {

  // Atributos
  // Año de incorporación al centro
  protected int anyoIncorporacion;
  // Código de despacho
  protected String despacho;

  /**
   * Constructor
   * @param nombre Nombre completo del empleado
   * @param dni DNI del empleado
   * @param estadoCivil Estado civil del empleado
   * @param anyoIncorporacion Año de incorporación del empleado
   * @param despacho Despacho que usa el empleado
   */
  protected Empleado(String nombre, String dni, String estadoCivil, int anyoIncorporacion,
      String despacho) {
    super(nombre, dni, estadoCivil);
    this.anyoIncorporacion = anyoIncorporacion;
    this.despacho = despacho;
  }
  
  /**
   * Asigna al empleado a un nuevo despacho
   * @param despacho Nuevo despacho asignado al empleado
   */
  public void setDespacho(String despacho) {
    this.despacho = despacho;
  }

  @Override
  public String toString() {
    return super.toString() + String.format(", Año de incorporación: %d, Despacho: %s"
      , anyoIncorporacion, despacho);
  }
  
  
}
