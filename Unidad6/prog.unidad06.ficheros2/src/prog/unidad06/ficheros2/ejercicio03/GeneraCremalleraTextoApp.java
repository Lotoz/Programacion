package prog.unidad06.ficheros2.ejercicio03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Genera un archivo cremallera de texto a partir de otros dos
 */
public class GeneraCremalleraTextoApp {
  // Atributos
  // Ruta del primer fichero de entraada
  private String rutaEntrada1;
  // Ruta del segundo fichero de entrada
  private String rutaEntrada2;
  // Ruta del fichero de salida
  private String rutaSalida;
  
  /**
   * Constructor con todo los atributos
   * @param rutaEntrada1 Ruta al primer fichero de entrada
   * @param rutaEntrada2 Ruta al segundo fichero de entrada
   * @param rutaSalida Ruta al fichero de salida
   */
  public GeneraCremalleraTextoApp(String rutaEntrada1, String rutaEntrada2, String rutaSalida) {
    this.rutaEntrada1 = rutaEntrada1;
    this.rutaEntrada2 = rutaEntrada2;
    this.rutaSalida = rutaSalida;
  }

  /**
   * Punto de entrada a la aplicación
   * @param args Argumentos de la aplicación
   */
  public static void main(String[] args) {
    // Si no se han proporcionado los tres parámetros
    if (args.length < 3) {
      // Mostramos error y terminamos
      System.out.println("Faltan rutas de archivo. Se deben proporcionar 3");
      return;
    }
    
    // Accedemos a los tres primeros parámetros y construimos la aplicación
    GeneraCremalleraTextoApp app = new GeneraCremalleraTextoApp(args[0],  args[1], args[2]);
    app.run();
    
  }

  /**
   * Punto de inicio de la instancia
   */
  private void run() {
    // Cabecera informativa
    System.out.printf("Procesando los archivos de entrada \"%s\" y \"%s\" para"
      + "generar el archivo de salida \"%s\"%n", rutaEntrada1, rutaEntrada2
      , rutaSalida);
    
    // Abrimos los dos archivos de entrada y creamos el de salida
    try (
      BufferedReader reader1 = new BufferedReader(new FileReader(rutaEntrada1));
      BufferedReader reader2 = new BufferedReader(new FileReader(rutaEntrada2));
      PrintWriter writer = new PrintWriter(rutaSalida);) {
      
      // Inicializamos las líneas (si no no se pueden emplear en while)
      String linea1 = null;
      String linea2 = null;
      // Hasta que no se hayan terminado LOS DOS archivos
      do {
        // Intenta leer una línea de cada fichero
        linea1 = reader1.readLine();
        linea2 = reader2.readLine();
        
        // Si el primer archivo no ha terminado aun
        if (linea1 != null) {
          // Escribimos la linea en el fichero de salida
          writer.println(linea1);
        }
        // Y lo mismo hacemos con la línea proveniente del segundo archivo
        if (linea2 != null) {
          writer.println(linea2);
        }
      } while (linea1 != null || linea2 != null);
      // Mensaje de fin
      System.out.println("Terminado");
    } catch (IOException e) {
      // En caso de error, mensaje y terminamos
      System.out.printf("Error accediendo a los archivos: %s%n", e.getMessage());
    }
  }
}
