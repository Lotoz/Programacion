package prog.unidad07.ejercicio02;

public class EmpleadoFijo extends Empleado {

  // Atributos
  // Salario fijo
  private double salario;

  /**
   * Constructor
   * @param nombre Nombre del empleado. No puede ser null
   * @param dni DNI del empleado. No puede ser null
   * @param telefono Telefono del empleado. No puede ser null
   * @param salario Salario mensual del empleado. No puede ser negativo
   * @throws NullPointerException Si nombre, dni o telefono son null
   * @throws IllegalArgumentException Si el salario es negativo
   */
  protected EmpleadoFijo(String nombre, String dni, String telefono, double salario) {
    super(nombre, dni, telefono);
    if (salario >= 0) {
      this.salario = redondea2Decimales(salario);
    } else {
      throw new IllegalArgumentException("salario no puede ser negativo");
    }
  }

  @Override
  public double getSalario() {
    // Simplemente devuelve el salario
    return salario;
  }

}
