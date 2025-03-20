package prog.unidad07.ejercicio02;

/**
 * Empleado de la empresa
 */
public abstract class Empleado {

  // Atributos
  // Nombre
  protected String nombre;
  // DNI
  protected String dni;
  // Telefono
  protected String telefono;
  
  /**
   * Constructor
   * @param nombre Nombre del empleado. No puede ser null
   * @param dni DNI del empleado. No puede ser null
   * @param telefono Telefono del empleado. No puede ser null
   * @throws NullPointerException Si alguno de los parámetros es null
   */
  protected Empleado(String nombre, String dni, String telefono) {
    if (nombre == null || dni == null || telefono == null) {
      throw new NullPointerException("Alguno de los parámetros es null");
    } else {
      this.nombre = nombre;
      this.dni = dni;
      this.telefono = telefono;
    }
  }

  /**
   * Obtiene el Nombre del empleado
   * @return Nombre del empleado
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Obtiene el DNI del empleado
   * @return DNI del empleado
   */
  public String getDni() {
    return dni;
  }

  /**
   * Obtiene el teléfono del empleado
   * @return Teléfono del empleado
   */
  public String getTelefono() {
    return telefono;
  }
  
  /**
   * Obtiene el salario mensual del empleado
   * @return Salario mensual del empleado
   */
  public abstract double getSalario();
  
  protected double redondea2Decimales(double cantidad) {
    return Math.round(cantidad * 100.0) / 100.0;
  }
  
}
