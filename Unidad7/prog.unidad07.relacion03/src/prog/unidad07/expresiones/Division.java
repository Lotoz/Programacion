package prog.unidad07.expresiones;

/**
 * Operación división.
 */
public class Division extends OperacionBinaria {

  /**
   * Constructor
   * @param operandoIzquierdo Operando izquierdo
   * @param operandoDerecho Operando derecho
   */
  public Division(Expresion operandoIzquierdo, Expresion operandoDerecho) {
    super(operandoIzquierdo, operandoDerecho);
  }

  @Override
  public int evaluar() {
    // Evalua el operando derecho
    int valorDerecho = operandoDerecho.evaluar();
    // Si no es cero
    if (valorDerecho != 0) {
      // Evalua el izquierdo y devuelve el resultado
      return operandoIzquierdo.evaluar() / valorDerecho;
    } else {
      throw new ExpresionException("Error. Intento de dividir por cero");
    }
  }

}
