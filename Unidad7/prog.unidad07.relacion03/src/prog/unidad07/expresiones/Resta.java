package prog.unidad07.expresiones;

/**
 * Operación que representa la resta del operando derecho del izquierdo
 */
public class Resta extends OperacionBinaria {

  /**
   * Constructor
   * @param operandoIzquierdo Operando izquierdo
   * @param operandoDerecho Operando derecho
   */
  public Resta(Expresion operandoIzquierdo, Expresion operandoDerecho) {
    super(operandoIzquierdo, operandoDerecho);
  }

  @Override
  public int evaluar() {
    // Evalua los operandos y obtiene la resta
    return operandoIzquierdo.evaluar() - operandoDerecho.evaluar();
  }

}
