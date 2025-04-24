package prog.unidad07.expresiones;

/**
 * Expresion
 */
public abstract class Expresion {
  
  /**
   * Evalua la expresión y obtiene su valor
   * @return valor de la expresión
   * @throws ExpresionException Si no se puede evaluar la expresión
   */
  public abstract int evaluar();
}
