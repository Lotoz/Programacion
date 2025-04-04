package prog.unidad07.expresiones;

/**
 * Operación que toma dos operandos y devuelve un resultado
 */
public abstract class OperacionBinaria extends Operacion {

  // Atributos
  // Operando izquierdo
  protected Expresion operandoIzquierdo;
  // Operando derecho
  protected Expresion operandoDerecho;

  /**
   * Constructor
   * @param operandoIzquierdo Operando izquierdo de la operación
   * @param operandoDerecho Operando derecho de la operación
   */
  protected OperacionBinaria(Expresion operandoIzquierdo, Expresion operandoDerecho) {
    this.operandoIzquierdo = operandoIzquierdo;
    this.operandoDerecho = operandoDerecho;
  }
}
