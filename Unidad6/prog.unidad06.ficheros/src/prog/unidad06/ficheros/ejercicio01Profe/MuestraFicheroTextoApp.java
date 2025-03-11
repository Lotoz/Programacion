package prog.unidad06.ficheros.ejercicio01Profe;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import prog.unidad06.ficheros.utils.PromptFichero;

/**
 * Muestra el contenido de un fichero de texto por pantalla
 */
public class MuestraFicheroTextoApp {
  
  
  /**
   * Punto de entrada
   * @param args Argumentos
   */
  public static void main(String[] args) {
    MuestraFicheroTextoApp app = new MuestraFicheroTextoApp();
    app.run(args);
  }
  
  private void run(String[] args) {

    String ruta = PromptFichero.obtenerRuta("Introduce la ruta al archivo a mostrar: ", args);
    
    // Abre el archivo
    try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
      
      // Cabecera
      System.out.printf("Contenidos del fichero \"%s\"%n", ruta);
      
      // Para cada línea
      String linea = null;
      do {
        // La lee
        linea = reader.readLine();
        // Si no es null, la imprime
        if (linea != null) {
          System.out.println(linea);
        }
      } while (linea != null);
    } catch (FileNotFoundException e) {
      // El archivo no se encuentra
      System.out.printf("Error. No se encuentra el fichero \"%s\"%n", ruta);
    } catch (IOException e) {
      // Error accediendo al archivo (raro)
      System.out.printf("Error accediendo al fichero \"%s\"%n", ruta);
    }
  }
}
