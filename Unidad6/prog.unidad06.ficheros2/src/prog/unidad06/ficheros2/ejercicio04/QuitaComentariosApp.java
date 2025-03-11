package prog.unidad06.ficheros2.ejercicio04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Aplicación que quita comentarios de una linea de programas Java
 */
public class QuitaComentariosApp {

  // Constantes
  // Secuencia que indica que comienza un comentario
  private static final String SECUENCIA_COMENTARIO = "//";
  
  // Atributos
  // Ruta al archivo de entrada
  private String rutaEntrada;
  // Ruta al archivo de salida
  private String rutaSalida;
  
  /**
   * Constructor con todos los atributos
   * @param rutaEntrada Ruta al fichero de entrada
   * @param rutaSalida Ruta al fichero de salida
   */
  public QuitaComentariosApp(String rutaEntrada, String rutaSalida) {
    this.rutaEntrada = rutaEntrada;
    this.rutaSalida = rutaSalida;
  }

  /**
   * Punto de inicio de la aplicación
   * @param args Parámetros a la aplicación
   */
  public static void main(String[] args) {
    // Si no se han pasado al menos dos parámetros termina con error
    if (args.length < 2) {
      System.out.println("Se esperan al menos dos parámetros Terminando");
      return;
    }
    
    QuitaComentariosApp app = new QuitaComentariosApp(args[0], args[1]);
    app.run();
  }

  /**
   * Punto de inicio de la instancia
   */
  private void run() {
    // Cabecera
    System.out.printf("Eliminando comentarios de archivo \"%s\". Salida en archivo \"%s\"%n"
        , rutaEntrada, rutaSalida);
    
    // Abrimos los ficheros con recursos para que se auto cierren al terminar
    try (BufferedReader reader = new BufferedReader(new FileReader(rutaEntrada));
         PrintWriter writer = new PrintWriter(rutaSalida);){
      
      // Mientras haya lineas en el archivo de entrada
      String linea = null;
      // Bandera que indica que es la primera línea
      boolean primeraLinea = true;
      // Mientras se lean líneas
      while ((linea = reader.readLine()) != null) {
        // Si la línea no comienza por un comentario.
        if (!linea.trim().startsWith(SECUENCIA_COMENTARIO)) {
          // La escribimos en la salida
          // Si no es la primera línea, termina la anterior con un salto de linea antes de esribir
          // Esto se hace para no añadir una línea en blanco al final del fichero, lo cual ocurre
          // si se generan todas las líneas con println
          if (!primeraLinea) {
            writer.println();
          } else {
            // Si era la primera linea, ya las siguientes no lo serán
            primeraLinea = false;
          }
          // Escribimos la línea en la salida (sin salto de línea, que se incluye antes)
          writer.print(linea);
        }
      }
    } catch (IOException e) {
      // Error en entrada salida
      System.out.printf("Error accediendo a ficheros: %s%n", e.getMessage());
    }
  }
}
