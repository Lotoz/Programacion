package prog.ud05.actividad511.coleccion;

/**
 * Excepción lanzada por el contenedor de usuarios
 */
public class UsuariosException extends RuntimeException {
  
  /**
   * Constructor con mensaje y cause
   * @param message
   * @param cause
   */
  public UsuariosException(String message, Throwable cause) {
    super(message, cause);
  }

}
