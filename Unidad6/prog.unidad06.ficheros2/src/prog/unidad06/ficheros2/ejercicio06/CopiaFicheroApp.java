package prog.unidad06.ficheros2.ejercicio06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Programa que copia un fichero
 */
public class CopiaFicheroApp {
  
  // Atributos
  // Ruta al archivo origen
  private String rutaOrigen;
  // Ruta al archivo destino
  private String rutaDestino;

  /**
   * Constructor con todos los atributos
   * @param rutaOrigen Ruta al archivo origen de la copia
   * @param rutaDestino Ruta al archivo destino de la copia
   */
  public CopiaFicheroApp(String rutaOrigen, String rutaDestino) {
    this.rutaOrigen = rutaOrigen;
    this.rutaDestino = rutaDestino;
  }

  /**
   * Punto de inicio de la aplicación
   * @param args Parámetros a la aplicación
   */
  public static void main(String[] args) {
    
    // Si no se han pasado dos rutas se termina
    if (args.length < 2) {
      System.err.println("Error. Es necesario proporcionar dos rutas al programa. La primera es la del archivo origen y la segunda la del destino");
      return;
    }

    CopiaFicheroApp app = new CopiaFicheroApp(args[0], args[1]);
    app.run();
  }

  /**
   * Punto de inicio de la instancia
   */
  private void run() {
   
    // Muestra lo que va a hacer
    System.out.printf("Copiando fichero \"%s\" a \"%s\"%n", rutaOrigen, rutaDestino);
    
    // Abrimos un archivo para leer y el otro se crea o sobreescribe
    // Ambos en modo binario
    try (InputStream entrada = new FileInputStream(rutaOrigen);
         OutputStream salida = new FileOutputStream(rutaDestino);){
      // Valor leido desde archivo
      int valor;
      // Hacemos la copia
      do {
        // Leemos un valor
        valor = entrada.read();
        // Si no es fin de fichero
        if (valor != -1) {
          // Se almacena en el de salida
          salida.write(valor);
        }
      } while (valor != -1);
      
      // Hemos terminado la copia
      System.out.println("Finalizada la copia");
    } catch (FileNotFoundException e) {
      // Fichero no encontrado
      System.out.printf("Error. No se encuentra el fichero de entrada o no se puede crear el fichero de salida: %s%n", e.getMessage());
    } catch (IOException e) {
      // Error de entrada / salida
      System.out.printf("Error general leyendo o escribiendo ficheros: %s%n", e.getMessage());
    }
  }
}
