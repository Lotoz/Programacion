package prog.unidad05.json.ejercicio1;

public class DiccionarioSpanishEnglishException extends RuntimeException {

  /**
   * Constructor con mensaje y causa
   * @param message - Mensaje de la excepción
   * @param cause - Causa original de la excepción (null si no hay causa)
   */
  public DiccionarioSpanishEnglishException(String message, Throwable cause) {
    super(message, cause); 
  }
}
