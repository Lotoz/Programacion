package prog.unidad05.json.ejercicio03;

/**
 * Subida
 */
public class Subida {

  // Atributos
  // DNI
  private String dni;
  // Subida
  private double importe;
  
  /**
   * Constructor con DNI e importe
   * @param dni DNI del empleado
   * @param importe Importe de la subida
   */
  public Subida(String dni, double importe) {
    this.dni = dni;
    this.importe = importe;
  }

  /**
   * Obtiene el DNI
   * @return DNI de la subida
   */
  public String getDni() {
    return dni;
  }

  /**
   * Obtiene el importe de la subida
   * @return Importe de la subida
   */
  public double getImporte() {
    return importe;
  }
}
