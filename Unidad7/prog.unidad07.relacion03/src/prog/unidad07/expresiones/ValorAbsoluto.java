package prog.unidad07.expresiones;

/**
 * Operación valor absoluto. Obtiene el valor quitando el signo, si lo tuviera
 */
public class ValorAbsoluto extends OperacionUnaria {

  /**
   * Constructor
   * @param operando Operando 
   */
  public ValorAbsoluto(Expresion operando) {
    super(operando);
  }

  @Override
  public int evaluar() {
    // Evaluamos el operando
    int valor = operando.evaluar();
    // Si es negativo
    if (valor < 0) {
      // Cambiamos el signo
      valor = -valor;
    }
    // Devolvemos el resultado
    return valor;
  }

}
