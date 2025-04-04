package prog.unidad07.expresiones;

/**
 * Operación cambio de signo
 */
public class CambioSigno extends OperacionUnaria {

  /**
   * Constructor
   * @param operandoIzquierdo Operando izquierdo
   * @param operandoDerecho Operando derecho
   */
  public CambioSigno(Expresion operando) {
    super(operando);
  }

  @Override
  public int evaluar() {
    // Evalua el operando y le cambia el signo
    return -operando.evaluar();
  }

}
