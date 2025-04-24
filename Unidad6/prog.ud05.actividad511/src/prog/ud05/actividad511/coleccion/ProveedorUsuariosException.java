package prog.ud05.actividad511.coleccion;

/**
 * Excepción general que lanzan todos los ProveedoresUsuarios cuando ocurre
 * algún error
 */
public class ProveedorUsuariosException extends RuntimeException {

  /**
   * Constructor con mensaje
   * 
   * @param message
   */
  public ProveedorUsuariosException(String message) {
    super(message);
  }

  /**
   * Constructor con mensaje y causa
   * 
   * @param message
   * @param cause
   */
  public ProveedorUsuariosException(String message, Throwable cause) {
    super(message, cause);
  }

}
