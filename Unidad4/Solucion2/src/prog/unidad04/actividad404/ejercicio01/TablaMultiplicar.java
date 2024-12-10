package prog.unidad04.actividad404.ejercicio01;

/**
 * Clase que representa la tabla de multiplicar de un número entero determinado
 */
public class TablaMultiplicar {
  
  // Numero de la tabla
  private int numero;
  
  /**
   * Crea la tabla de multiplicar del número dado
   * @param numero Número de la tabla de multiplicar (tabla del ....). Debe ser mayor que cero
   * @throws IllegalArgumentException Si el número proporcionado es menor o igual a cero
   */
  public TablaMultiplicar(int numero) {
    // Si el número es mayor que cero
    if (numero > 0) {
      // Lo almacena en el atributo
      this.numero = numero;
    } else {
      // Lanza una excepción
      throw new IllegalArgumentException();
    }
  }
  
  /**
   * Imprime la tabla por consola
   * La tabla se imprime en 10 líneas del formato "N x M = R",
   * donde N es el número dado en constructor, M es un número
   * que va cambiando de 1 a 10 y R es el resultado de multiplicar
   * N por M
   */
  public void imprimeTabla() {
    // Para cada número
    for (int i = 1; i <= 10; i++) {
      // Imprime la linea correspondiente
      System.out.println(numero + " x " + i + " = " + (numero * i));
    }
  }

}
