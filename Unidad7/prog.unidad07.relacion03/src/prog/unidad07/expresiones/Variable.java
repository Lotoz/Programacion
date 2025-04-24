package prog.unidad07.expresiones;

/**
 * Variable. Una variable almacena un valor bajo un nombre
 */
public class Variable extends Expresion {

  // Atributos
  // Nombre
  private String nombre;
  // Valor
  private int valor;
  
  public Variable(String nombre, int valor) {
    this.nombre = nombre;
    this.valor = valor;
  }
  
  @Override
  public int evaluar() {
    return valor;
  }

}
