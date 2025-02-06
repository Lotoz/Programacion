package prog.ud05.actividad511.coleccion.diccionario;

public class DiccionarioException extends RuntimeException  {
  
  public DiccionarioException(String message) {
    super(message);
  }

  public DiccionarioException(String message, Throwable cause) {
    super(message, cause);
  }
}
