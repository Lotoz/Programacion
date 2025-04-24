package prog.unidad07.expresiones;

/**
 * Operación potencia
 */
public class Potencia extends OperacionBinaria {

  /**
   * Constructor
   * @param operandoIzquierdo Operando izquierdo
   * @param operandoDerecho Operando derecho
   */
  public Potencia(Expresion operandoIzquierdo, Expresion operandoDerecho) {
    super(operandoIzquierdo, operandoDerecho);
  }

  @Override
  public int evaluar() {
    // Obtenemos el exponente
    int exponente = operandoDerecho.evaluar();
    int resultado = 1;
    // Si el exponente es positivo
    if (exponente > 0) {
      // Hacemos un ciclo y multiplicamos la base por si misma tantas veces como diga el exponente
      int base = operandoIzquierdo.evaluar();
      resultado = base;
      for (int i = 1; i < exponente; i++) {
        resultado *= base;
      }
    } else if (exponente == 0) {
      // Si el exponente es 0 el resultado es 1 (independientemente de la base)
      resultado = 1;
    } else {
      // Si el exponente es negativo lanza excepcion
      throw new ExpresionException("Error. Las potencias no pueden tener exponentes negativos");
    }
    return resultado;
  }

}
