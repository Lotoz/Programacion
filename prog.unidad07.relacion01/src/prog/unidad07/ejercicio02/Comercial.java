package prog.unidad07.ejercicio02;

/**
 * Comercial. Cobra mixto entre comisión y salario fijo mínimo
 */
public class Comercial extends EmpleadoFijo {

  // Constantes
  private static final double SALARIO_MINIMO = 300;
  
  // Atributos
  protected double ventas;

  /**
   * @param nombre Nombre del comercial. No puede ser null
   * @param dni DNI del comercial. No puede ser null
   * @param telefono Telefono del comercial. No puede ser null
   * @param ventas Ventas del mes. Debes ser positivo
   * @throws NullPointerException Si nombre, dni o telefono son null
   * @throws IllegalArgumentException Si ventas no es válido
   */
  protected Comercial(String nombre, String dni, String telefono, double ventas) {
    super(nombre, dni, telefono, SALARIO_MINIMO);
    if (ventas >= 0) {
      this.ventas = ventas;
    } else {
      throw new IllegalArgumentException("Ventas no puede ser negativo");
    }
  }

  @Override
  public double getSalario() {
    // Calcula las comisiones
    double comisiones = getComisiones();
    // Si son mayores que el salario, devuelve las comisiones, sino el salario
    return super.getSalario() > comisiones ? super.getSalario() : comisiones;
  }

  /**
   * Obtiene las comisiones del comercial
   * @return Comisiones del comercial
   */
  private double getComisiones() {
    // Si las ventas son de menos de 10000 euros
    if (ventas <= 10000) {
      // Devuelve el 5%
      return redondea2Decimales(ventas * 0.05);
      // Si son entre 10000 y 300000
    } else if (ventas >= 10001 && ventas <= 30000) {
      // Devuelve el 8%
      return redondea2Decimales(ventas * 0.08);
    } else {
      // Si son superiores devuelve el 10%
      return redondea2Decimales(ventas * 0.1);
    }
  }
}
