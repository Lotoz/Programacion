package prog.unidad07.expresiones;

/**
 * Operacion Suma. Obtiene la suma de los dos operandos
 */
public class Suma extends OperacionBinaria {

  /**
   * Constructor
   * @param operandoIzquierdo Operando izquierdo 
   * @param operandoDerecho Operando derecho
   */
  public Suma(Expresion operandoIzquierdo, Expresion operandoDerecho) {
    super(operandoIzquierdo, operandoDerecho);
  }

  @Override
  public int evaluar() {
    // Evalua los operandos y calcula la suma
    return operandoIzquierdo.evaluar() + operandoDerecho.evaluar();
  }

}
