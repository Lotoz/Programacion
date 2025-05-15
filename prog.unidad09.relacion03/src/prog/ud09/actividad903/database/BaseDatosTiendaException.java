package prog.ud09.actividad903.database;

/**
 * Excepción de base de datos
 */
@SuppressWarnings("serial")
public class BaseDatosTiendaException extends RuntimeException {

  public BaseDatosTiendaException() {
  }

  public BaseDatosTiendaException(String message) {
    super(message);
  }

  public BaseDatosTiendaException(String message, Throwable cause) {
    super(message, cause);
  }
}
