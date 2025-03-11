package prog.unidad06.gestionficheros.ejercicio01;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Muestra información sobre ficheros 
 */
public class InformacionFicherosApp {

  /**
   * Punto de entrada de la aplicación
   * @param args Parámetros de línea de comandos
   */
  public static void main(String[] args) {

    // Scanner para leer desde teclado
    Scanner sc = new Scanner(System.in);
    
    // Solicita rutas hasta que se introduzca una vacia
    String ruta = "";
    do {
      // Lee la ruta
      System.out.print("Introduzca la ruta a un archivo (en blanco para acabar): ");
      ruta = sc.nextLine();
      // Si no está vacía
      if (!ruta.isEmpty()) {
        // Si la ruta existe
        Path path = Path.of(ruta);
        if (Files.exists(path)) {
          // Muestra la información sobre lo que hay en la ruta especificada
          // (existe o no y si es una carpeta o un fichero regular)
          System.out.printf("El archivo \"%s\" existe y es %s%n"
              , ruta
              , Files.isDirectory(path) ? "una carpeta" : "un fichero regular");
        } else {
          // No hay nada en la ruta especificada
          System.out.printf("El archivo \"%s\" no existe%n", ruta);
        }
      }
    } while (!ruta.isEmpty());
  }

}
