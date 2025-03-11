package prog.unidad06.ficheros.ejercicio02Profe;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import prog.unidad06.ficheros.utils.PromptFichero;

/**
 * Escribe líneas leídas desde teclado en un fichero de texto
 */
public class EscribeFicheroTextoApp {
  

  /**
   * Enfoque híbrido. Intenta obtener la ruta desde los argumentos y si
   * no puede la solicita por teclado
   * @param args
   */
  public static void main(String[] args) {
    
    EscribeFicheroTextoApp app = new EscribeFicheroTextoApp();
    app.run(args);
  }
  
  /**
   * Ejecuta la aplicación
   * @param args Argumentos
   */
  private void run(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    // Obtenemos la ruta
    String ruta = PromptFichero.obtenerRuta("Introduce la ruta al archivo a crear: ", args, sc);
    
    // Intentamos abrir el archivo para escribir
    try (PrintWriter writer = new PrintWriter(ruta)) {
      // Mientras que el usuario no introduzca vacio
      System.out.println("Fichero iniciado con éxito. Introduzca el texto a almacenar línea a línea y una línea vacía para terminar");
      String linea = null;
      do {
        // Lee la linea desde teclado
        System.out.print("Texto de la línea: ");
        linea = sc.nextLine();
        // Si no es vacía
        if (!linea.isEmpty()) {
          // Almacena la linea
          writer.println(linea);
        }
      } while (!linea.isEmpty());
    } catch (FileNotFoundException e) {
      // Archivo no se puede crear
      System.out.printf("Error. No se puede crear el fichero \"%s\"%n", ruta);
    }
  }
}
