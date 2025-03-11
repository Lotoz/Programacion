package prog.unidad06.ficheros2.ejercicio01;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Genera archivo con números primos
 */
public class GeneraPrimosTextoApp {

  // Constantes
  // Nombre del fichero
  private static final String FICHERO = "primos.txt";
  // Número de primos a generar
  private static final int TOTAL_PRIMOS = 500;

  /**
   * Punto de entrada de la aplicación
   * @param args Argumentos de la aplicación
   */
  public static void main(String[] args) {
    
    // Generamos una instancia y la ejecutamos
    GeneraPrimosTextoApp app = new GeneraPrimosTextoApp();
    app.run();

  }
  
  /**
   * Método de ejecución de instancia
   */
  private void run() {
    // Abre el archivo de salida
    try (PrintWriter writer = new PrintWriter(FICHERO)){
      // Contador de primos
      int primos = 1;
      // Primo actual
      int primo = 1;
      // Imprime el primer primo
      writer.println(primo);
      // Mientras no haya imprimido los primos requeridos
      while (primos < TOTAL_PRIMOS) {
        // Calcula el siguiente primo
        primo = siguientePrimo(primo);
        // Lo imprime
        writer.printf("%d%n", primo);
        // Y acumula 1
        primos++;
      }
    } catch(FileNotFoundException e) {
      // No se puede crear el fichero
      System.out.printf("Error creando el fichero \"%s\"%n", FICHERO);
    }
  }

  /**
   * Calcula el siguiente número primo
   * @param primo Número primo de partida
   * @return Número primo siguiente al proporcionado
   */
  private int siguientePrimo(int primo) {
    // Hasta que encontremos uno y lo devolvamos
    while (true) {
      // Probamos el siguiente número
      primo++;
      // Si es primo
      if (esPrimo(primo)) {
        // Se devuelve
        return primo;
      }
    }
  }

  /**
   * Testea si el número proporcionado es primo
   * @param numero Número a testear
   * @return true si el número es primo, false en caso contrario
   */
  private boolean esPrimo(int numero) {
    // Probamos todos los divisores desde 2 hasta la mitad del valor.
    // Si alguno de ellos divide terminamos inmediatamente con false
    // Si no se termina al final con true
    for (int i = 2; i <= (numero / 2);i++) {
      if ((numero % i) == 0) {
        return false;
      }
    }
    // No hemos conseguido dividirlo por ninguno
    return true;
  }
}
