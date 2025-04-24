package prog.unidad07.ejercicio02;

/**
 * Empleado fijo que además lleva comisión de las ventas
 */
public class Comisionista extends EmpleadoFijo {

  // Atributos
  // Porcentaje de comisión
  protected double porcentaje;
  // Ventas del mes
  protected double ventas;

  /**
   * Constructor
   * @param nombre Nombre del comisionista. No puede ser null
   * @param dni DNI del comisionista. No puede ser null
   * @param telefono Telefono del comisionista. No puede ser null
   * @param salario Salario del comisionista. No puede ser negativo
   * @param porcentaje Porcentaje de las ventas que se lleva el comisionista. Debe valer entre 0 y 1
   * @param ventas Ventas del mes del comisionista. No puede ser negativo
   * @throws NullPointerException Si nombre, dni o telefono son null
   * @throws IllegalArgumentException Si salario, porcentaje o ventas no son válidos
   */
  protected Comisionista(String nombre, String dni, String telefono, double salario,
      double porcentaje, double ventas) {
    super(nombre, dni, telefono, salario);
    if (porcentaje >= 0 && porcentaje <= 1) {
      this.porcentaje = porcentaje;
    } else {
      throw new IllegalArgumentException("Porcentaje no válido. Debe ser un número real entre 0 y 1, ambos incluidos");
    }
    if (ventas >= 0) {
      this.ventas = ventas;
    } else {
      throw new IllegalArgumentException("Ventas no válidas. Deben ser un número positivo o cero");
    }
  }

  @Override
  public double getSalario() {
    // Obtiene el salario del padre y le adjunta las ventas
    return redondea2Decimales(super.getSalario() + porcentaje * ventas);
  }
}
