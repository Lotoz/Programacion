package prog.unidad06.ficheros2.ejercicio07;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Genera un fichero binario con números primos
 */
public class GeneraPrimosBinarioApp {

  // Constantes
  // Valor máximo
  private static final int MAX_PRIMO = 255;
  // Nombre del fichero de salida
  private static final String FICHERO = "primos.bin";

  /**
   * Punto de inicio de la aplicación
   * @param args Parámetros a la aplicación
   */
  public static void main(String[] args) {
    GeneraPrimosBinarioApp app = new GeneraPrimosBinarioApp();
    app.run();
  }

  /**
   * Punto de inicio de la instanacia
   */
  private void run() {
    // Mensaje de progreso
    System.out.printf("Generando fichero de salida \"%s\"%n", FICHERO);
    
    // Creamos el fichero de salida
    try (OutputStream stream = new FileOutputStream(FICHERO)){
      // Primo actual
      int primo = 1;
      // Almacena el primer primo
      stream.write(primo);
      // Mientras no lleguemos al máximo
      while (primo < MAX_PRIMO) {
        // Calcula el siguiente primo
        primo = siguientePrimo(primo);
        // Si es menor al maximo
        if (primo < MAX_PRIMO) {
          // Lo almacena
          stream.write(primo);
        }
      }
      // Mensaje de progreso
      System.out.printf("Fichero \"%s\" generado%n", FICHERO);

    } catch(FileNotFoundException e) {
      // No se puede crear el fichero
      System.out.printf("Error creando el fichero \"%s\": %s%n", FICHERO, e.getMessage());
    } catch (IOException e) {
      // Error escribiendo en el fichero
      System.out.printf("Error escribiendo en el fichero \"%s\": %s%n", FICHERO, e.getMessage());
    }
  }

  /**
   * Obtiene el siguiente primo
   * @param primo Primo de partida
   * @return Número primo siguiente al proporcionado
   */
  private int siguientePrimo(int primo) {
    // Hasta que encontremos uno y lo devolvamos
    while (true) {
      // Prueba el siguiente
      primo++;
      // Si es primo hemos terminado
      if (esPrimo(primo)) {
        // Se devuelve
        return primo;
      }
    }
  }

  /**
   * Testea si un número entero es o no primo
   * @param numero Número a testear
   * @return true si el número es primo. false si no lo es
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
