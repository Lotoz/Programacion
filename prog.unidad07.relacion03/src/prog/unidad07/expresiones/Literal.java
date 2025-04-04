package prog.unidad07.expresiones;

/**
 * Literal es un valor expresado en forma de dígitos signos y puntos
 */
public class Literal extends Expresion {

  // Atributos
  // Valor
  private int valor;
  
  /**
   * Constructor
   * @param valor Valor del literal
   */
  public Literal(int valor) {
    this.valor = valor;
  }

  @Override
  public int evaluar() {
    return valor;
  }

}
