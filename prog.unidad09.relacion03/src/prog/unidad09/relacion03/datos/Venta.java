package prog.unidad09.relacion03.datos;

/**
 * Venta de una motocicleta a un cliente
 */
public class Venta {

  // Atributos
  // Codigo
  private int codigo;
  // Fecha de la venta
  private String fecha;
  // Cliente al que se le ha vendido la motocicleta
  private Cliente cliente;
  // Motocicleta que se ha vendido
  private Motocicleta motocicleta;

  /**
   * Constructor con todos los valores
   * @param codigo Código de la venta.
   * @param fecha Fecha de la venta en formato 'aaaa-mm-dd'.
   * @param cliente Cliente que ha comprado la motocicleta
   * @param motocicleta Motocicleta que se ha vendido
   */
  public Venta(int codigo, String fecha, Cliente cliente, Motocicleta motocicleta) {
    setCodigo(codigo);
    setFecha(fecha);
    setCliente(cliente);
    setMotocicleta(motocicleta);
  }

  /**
   * Obtiene el código
   * @return Código
   */
  public int getCodigo() {
    return codigo;
  }

  /**
   * Modifica el código
   * @param codigo Nuevo código
   */
  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  /**
   * Obtiene la fecha de la venta
   * @return Fecha de la venta en formato 'aaaa-mm-dd'
   */
  public String getFecha() {
    return fecha;
  }

  /**
   * Modifica la fecha de la venta
   * @param fecha Nueva fecha de la venta, en formato 'aaaa-mm-dd'
   */
  public void setFecha(String fecha) {
    // La almacena
    this.fecha = fecha;
  }

  /**
   * Obtiene el cliente que participa en la venta
   * @return Cliente que participa en la venta
   */
  public Cliente getCliente() {
    return cliente;
  }

  /**
   * Modifica el cliente que participa en la venta
   * @param cliente Cliente que participa en la venta
   */
  public void setCliente(Cliente cliente) {
      // Lo almacena
      this.cliente = cliente;
  }

  /**
   * Obtiene la motocicleta
   * @return Motocicleta que participa en la venta
   */
  public Motocicleta getMotocicleta() {
    return motocicleta;
  }

  /**
   * Modifica la motocicleta que participa en la venta
   * @param motocicleta Motocicleta que participa en la venta
   */
  public void setMotocicleta(Motocicleta motocicleta) {
    // Lo almacena
    this.motocicleta = motocicleta;
  }
}
