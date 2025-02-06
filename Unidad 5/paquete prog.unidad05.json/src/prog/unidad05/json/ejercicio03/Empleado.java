package prog.unidad05.json.ejercicio03;

/**
 * Informacion de un empleado
 */
public class Empleado {

  // Atributos
  // DNI del empleado
  private String dni;
  // Nombre del empleado
  private String nombre;
  // Apellidos del empleado
  private String apellidos;
  // Salario del empleado
  private double salario;

  /**
   * Constructor
   * @param dni DNI del empleado
   * @param nombre Nombre del empleado
   * @param apellidos Apellidos del empleado
   * @param salario Salario del empleado
   */
  Empleado(String dni, String nombre, String apellidos, double salario) {
    this.dni = dni;
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.salario = salario;
  }

  /**
   * Obtiene el DNI
   * @return DNI del empleado
   */
  public String getDni() {
    return dni;
  }

  /**
   * Obtiene el nombre del empleado
   * @return Nombre del empleado
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Obtiene los apellidos del empleado
   * @return Apellidos del empleado
   */
  public String getApellidos() {
    return apellidos;
  }

  /**
   * Obtiene el salario del empleado
   * @return Salario del empleado
   */
  public double getSalario() {
    return salario;
  }
  
  /**
   * Aumenta el salario del empleado por un importe determinado
   * @param importe Importe por el que se va a aumentar el salario del empleado
   */
  public void aumentaSalario(double importe) {
    salario += importe;
  }
}
