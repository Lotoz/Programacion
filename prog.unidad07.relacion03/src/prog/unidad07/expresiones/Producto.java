package prog.unidad07.expresiones;

/**
 * Operacion producto. Calcula el producto de sus operandos
 */
public class Producto extends OperacionBinaria {

  /**
   * Constructor
   * @param operandoIzquierdo Operando izquierdo
   * @param operandoDerecho Operando derecho
   */
  public Producto(Expresion operandoIzquierdo, Expresion operandoDerecho) {
    super(operandoIzquierdo, operandoDerecho);
    // TODO Auto-generated constructor stub
  }

  @Override
  public int evaluar() {
    // Evalua ambos operandos y devuelve el producto
    return operandoIzquierdo.evaluar() * operandoDerecho.evaluar();
  }
}
