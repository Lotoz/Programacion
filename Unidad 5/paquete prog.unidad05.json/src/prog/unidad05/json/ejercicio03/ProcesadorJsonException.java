package prog.unidad05.json.ejercicio03;

@SuppressWarnings("serial")
public class ProcesadorJsonException extends RuntimeException {

  public ProcesadorJsonException(String msg) {
    super(msg);
  }

  public ProcesadorJsonException(String msg, Exception cause) {
    super(msg, cause);
  }

}
