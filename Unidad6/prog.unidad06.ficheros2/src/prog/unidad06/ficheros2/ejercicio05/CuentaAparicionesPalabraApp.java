package prog.unidad06.ficheros2.ejercicio05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Cuenta las apariciones de una palabra en un fichero
 */
public class CuentaAparicionesPalabraApp {
  
  // Atributos
  // Ruta al fichero
  private String rutaFichero;
  // Palabra
  private String palabra;
  

  /**
   * Constructor con todos los atributos
   * @param rutaFichero Ruta al fichero con las palabras
   * @param palabra Palabra a buscar en el fichero
   */
  public CuentaAparicionesPalabraApp(String rutaFichero, String palabra) {
    this.rutaFichero = rutaFichero;
    this.palabra = palabra;
  }

  /**
   * Punto de inicio de la aplicación
   * @param args Parámetros a la aplicación
   */
  public static void main(String[] args) {
    // Si no hay al menos dos argumentos termina con error
    if (args.length < 2) {
      System.out.println("Faltan argumentos. Se necesitan 2, la ruta al fichero y la palabra");
      return;
    }
    
    CuentaAparicionesPalabraApp app = new CuentaAparicionesPalabraApp(args[0], args[1]);
    app.run();
  }

  /**
   * Punto de inicio dde la instancia
   */
  private void run() {
    // Cabecera
    System.out.printf("Contando las apariciones de la palabra \"%s\" en el "
      + "fichero \"%s\"%n", palabra, rutaFichero);
    
    // Abre el archivo
    try (BufferedReader reader = new BufferedReader(new FileReader(rutaFichero));) {
      
      // Inicia la cuenta
      int palabras = 0;
      String linea = null;
      // Para cada linea
      do {
        // Lee la linea
        linea = reader.readLine();
        // Si no es null
        if (linea != null) {
          // La dividimos en palabras (separada por espacios, comas, puntos y comas y puntos
          String[] palabrasLinea = linea.split("[ ,;.]");
          // Para cada palabra
          for (String p: palabrasLinea) {
            // Si es la buscada
            if (p.equalsIgnoreCase(palabra)) {
              // La contamos
              palabras++;
            }
          }
        }
      } while (linea != null);
      System.out.printf("La palabra \"%s\" aparece %d veces en el archivo \"%s\"%n", palabra, palabras, rutaFichero);
    } catch (IOException e) {
      // Error general accediendo al archivo
      System.out.printf("Error accediendo al archivo: %s%n", e.getMessage());
    }
  }
}
