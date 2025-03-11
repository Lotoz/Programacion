package prog.unidad06.ficheros2.ejercicio02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Imprime un archivo con números primos por pantalla
 */
public class ListaPrimosTextoApp {

  // Ruta al fichero con los primos
  private static final String FICHERO = "primos.txt";

  /**
   * Punto de entrada de la aplicación
   * @param args Argumentos de la aplicación
   */
  public static void main(String[] args) {
    ListaPrimosTextoApp app = new ListaPrimosTextoApp();
    app.run();
  }

  /**
   * Punto de entrada de la instancia
   */
  private void run() {
    // Abre el fichero
    try (BufferedReader reader = new BufferedReader(new FileReader(FICHERO))) {
      // Cabecera
      System.out.printf("Contenido del archivo \"%s\"%n", FICHERO);
      // Mientras haya lineas
      String linea;
      while ((linea = reader.readLine()) != null) {
        // La imprime
        System.out.println(linea);
      }
    } catch (FileNotFoundException e) {
      // Fichero no encontrado
      System.out.printf("No se encuentra el archivo \"%s\"%n", FICHERO);
    } catch (IOException e) {
      // Error accediendo al fichero
      System.out.printf("Error leyendo del archivo \"%s\"%n", FICHERO);
    }
  }
}
