package prog.unidad06.ficheros2.ejercicio09;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Genera un fichero cremallera binario a partir de otros dos ficheros binarios
 */
public class GeneraCremalleraBinarioApp {
  // Atributos
  // Ruta del primer fichero de entrada
  private String rutaEntrada1;
  // Ruta del segundo fichero de entrada
  private String rutaEntrada2;
  // Ruta al fichero de salida
  private String rutaSalida;
  
  /**
   * Constructor con todos los atributos
   * @param rutaEntrada1 Ruta al primer fichero de entrada
   * @param rutaEntrada2 Ruta al segundo fichero de entrada
   * @param rutaSalida Ruta al fichero de salida
   */
  public GeneraCremalleraBinarioApp(String rutaEntrada1, String rutaEntrada2, String rutaSalida) {
    this.rutaEntrada1 = rutaEntrada1;
    this.rutaEntrada2 = rutaEntrada2;
    this.rutaSalida = rutaSalida;
  }

  /**
   * Punto de inicio de la aplicación
   * @param args Parámetros a la aplicación
   */
  public static void main(String[] args) {
    // Si no se proporcionaron los tres argumentos neesarios
    if (args.length < 3) {
      // Mostramos un error y terminamos
      System.out.println("Faltan rutas de archivo. Se deben proporcionar 3 (dos rutas "
          + "correspondientes a los archivos de entrada y la ruta del archivo de salida)");
      return;
    }
    
    GeneraCremalleraBinarioApp app = new GeneraCremalleraBinarioApp(args[0], args[1], args[2]);
    app.run();
  }

  /**
   * Punto de inicio de la instancia
   */
  private void run() {
    // Mensaje de progreso
    System.out.printf("Creando archivo cremallera \"%s\" a partir de los ficheros \"%s\" y \"%s\"%n"
        , rutaEntrada1, rutaEntrada2, rutaSalida);
    
    // Abre los tres archivos
    try (InputStream entrada1 = new FileInputStream(rutaEntrada1);
         InputStream entrada2 = new FileInputStream(rutaEntrada2);
         OutputStream salida = new FileOutputStream(rutaSalida);) {

      int valor1 = -1;
      int valor2 = -1;
      do {
        // Intenta leer un byte de cada fichero
        // El que esté agotado devolverá el valor especial -1
        valor1 = entrada1.read();
        valor2 = entrada2.read();
        // Si se consiguió leer algo del primer archivo
        if (valor1 >= 0) {
          // Lo escribimos en la salida
          salida.write(valor1);
        }
        // Hacemos exactamente igual con el valor del segundo archivo
        if (valor2 >= 0) {
          salida.write(valor2);
        }
        // Seguimos mientras se consiga leer al menos de uno de los dos archivos (o de ambos)
      } while (valor1 != -1 || valor2 != -1);
      
      // Hemos terminado
      System.out.println("Terminada la fusión de los archivos");
      
    } catch (IOException e) {
      // Ocurrio algún error de E/S
      System.out.printf("Error accediendo a los archivos: %s%n", e.getMessage());
    }
  }
}
