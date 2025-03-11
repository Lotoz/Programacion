package prog.unidad06.ficheros2.ejercicio08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Lee e imprime un archivo binario con los números primos entre 1 y 255
 */
public class ListaPrimosBinarioApp {
  
  // Constantes
  // Nombre del fichero
  private static final String FICHERO = "primos.bin";

  /**
   * Punto de inicio de la apliación
   * @param args Parámetros a la aplicación
   */
  public static void main(String[] args) {
    ListaPrimosBinarioApp app = new ListaPrimosBinarioApp();
    app.run();
  }

  /**
   * Punto de inicio de la instancia
   */
  private void run() {
    // Intenta abrir el fichero para leer
    try (InputStream stream = new FileInputStream(FICHERO)) {
      // Si se pudo acceder al fichero muestra la cabecera (no tiene sentido mostrarla si el fichero
      // no es accesible)
      System.out.printf("Contenido del archivo \"%s\"%n", FICHERO);
      int valor;
      // Mientras haya contenio
      do {
        // Lee byte
        valor = stream.read();
        // Si no es final de fichero
        if (valor != -1) {
          // Lo imprime
          System.out.printf("%d%n", valor);
        }
      } while (valor != -1);
    } catch (FileNotFoundException e) {
      // Fichero no encontrado
      System.out.printf("No se encuentra el archivo \"%s\"%n", FICHERO);
    } catch (IOException e) {
      // Error leyendo del fichero
      System.err.printf("Error leyendo del archivo \"%s\": %s%n", e.getMessage());
    }
    
  }
}
