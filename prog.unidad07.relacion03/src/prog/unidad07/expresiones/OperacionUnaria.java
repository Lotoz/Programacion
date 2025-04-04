package prog.unidad07.expresiones;

/**
 * Operación que toma un operando y devuelve un valor
 */
public abstract class OperacionUnaria extends Operacion {

  // Atributos
  // Operando
  protected Expresion operando;
  
  /**
   * Constructor
   * @param operando Operando de la operación
   */
  protected OperacionUnaria(Expresion operando) {
    this.operando = operando;
  }
}
