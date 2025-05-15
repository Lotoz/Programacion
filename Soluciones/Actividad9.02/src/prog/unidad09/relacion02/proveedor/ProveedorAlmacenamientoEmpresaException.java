package prog.unidad09.relacion02.proveedor;

/**
 * Excepcion del paquete
 */
@SuppressWarnings("serial")
public class ProveedorAlmacenamientoEmpresaException extends RuntimeException {

  /**
   * Constructor con mensaje
   * @param string Mensaje de la excepción
   */
  public ProveedorAlmacenamientoEmpresaException(String msg) {
    super(msg);
  }
}
