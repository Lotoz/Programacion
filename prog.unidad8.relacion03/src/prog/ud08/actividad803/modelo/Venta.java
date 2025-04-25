package prog.ud08.actividad803.modelo;

/**
 * Venta DO
 */
public class Venta {

  // Atributos
  // Codigo
  private int codigo;
  // NIF del cliente
  private String nifCliente;
  // Referencia de la motocicleta
  private String referenciaMotocicleta;
  // Fecha de la venta
  private String fecha;

  /**
   * Constructor con todos los parámetros
   * @param codigo Código de la venta
   * @param nifCliente NIF del cliente al que se vendió la motocicleta
   * @param referenciaMotocicleta Motocicleta que se vendió
   * @param fecha Fecha en que ocurrió la venta
   */
  public Venta(int codigo, String nifCliente, String referenciaMotocicleta, String fecha) {
    this.codigo = codigo;
    this.nifCliente = nifCliente;
    this.referenciaMotocicleta = referenciaMotocicleta;
    this.fecha = fecha;
  }

  /**
   * Obtiene el codigo
   * @return Codigo
   */
  public int getCodigo() {
    return codigo;
  }

  /**
   * Obtiene el NIF del cliente
   * @return NIF del cliente
   */
  public String getNifCliente() {
    return nifCliente;
  }

  /**
   * Obtiene la referencia a la motocicleta
   * @return Referencia a la motocicleta
   */
  public String getReferenciaMotocicleta() {
    return referenciaMotocicleta;
  }

  /**
   * Obtiene la fecha de la venta
   * @return Fecha de la venta
   */
  public String getFecha() {
    return fecha;
  }
}
