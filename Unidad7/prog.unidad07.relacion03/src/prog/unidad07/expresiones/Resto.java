package prog.unidad07.expresiones;

/**
 * Operación que calcula el módulo (resto de la división)
 */
public class Resto extends OperacionBinaria {

  /**
   * Constructor
   * @param operandoIzquierdo Operando izquierdo
   * @param operandoDerecho Operando derecho
   */
  public Resto(Expresion operandoIzquierdo, Expresion operandoDerecho) {
    super(operandoIzquierdo, operandoDerecho);
  }
  
  @Override
  public int evaluar() {
    // Obtenemos el divisor
    int divisor = operandoDerecho.evaluar();
    // Si no es cero
    if (divisor != 0) {
      // Calcula el módulo y lo devuelve
      return operandoIzquierdo.evaluar() % divisor;
    } else {
      // Lanza excepcion
      throw new ExpresionException("Error. Intento de obtener el módulo con divisor cero");
    }
  }

}
