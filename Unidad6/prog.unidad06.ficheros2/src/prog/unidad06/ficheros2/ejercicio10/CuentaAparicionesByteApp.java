package prog.unidad06.ficheros2.ejercicio10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Programa que cuenta las apariciones de un valor dentro de un fichero binario
 */
public class CuentaAparicionesByteApp {
  
  // Atributos
  // Ruta al fichero
  private String ruta;
  // Valor buscado
  private int valorBuscado;

  /**
   * Constructor con valores para todos los atributos
   * @param ruta Ruta al fichero
   * @param valorBuscado Valor buscado
   */
  public CuentaAparicionesByteApp(String ruta, int valorBuscado) {
    this.ruta = ruta;
    this.valorBuscado = valorBuscado;
  }

  public static void main(String[] args) {
    // Si no se pasaron al menos dos parámetros muestra un mensaje y termina
    if (args.length < 2) {
      System.out.println("Error. Se debeb proporcionar dos parámetros. ruta al archivo y el valor hexadecimal del byte a contar (solo dos digitos)");
      return;
    }
    
    // Crea instancia de la aplicación con los parámetros y la inicia
    // Como el segundo parámetro es un byte en hexadecimal hay que utilizar una forma alternativa
    // de Integer.parseInt que admite valores en bases distintas de base 10
    CuentaAparicionesByteApp app = new CuentaAparicionesByteApp(args[0]
        , Integer.parseInt(args[1], 16));
    app.run();
  }

  /**
   * Punto de inicio de la instancia
   */
  private void run() {
    // Contador de apariciones
    int apariciones = 0;
    
    // InputStream para leer el fichero
    try (InputStream entrada = new FileInputStream(ruta)) {
      
      // Mientras que no lleguemos al final del archivo
      int valor;
      do {
        // Lee un byte
        valor = entrada.read();
        // Si no hemos llegado al final del fichero
        if (valor != -1) {
          // Si es el valor buscado
          if (valor == valorBuscado) {
            // Contamos otra aparicion
            apariciones++;
          }
        }
      } while (valor != -1);
      
      // Mostramos el resultado
      System.out.printf("El byte %X aparece %d veces en el fichero \"%s\"%n"
          , valorBuscado, apariciones, ruta);
    } catch (FileNotFoundException e) {
      // Fichero no encontrado
      System.out.printf("No se encuentra el fichero \"%s\"%n", ruta);
    } catch (IOException e) {
      // Error leyendo del archivo
      System.out.printf("Error generalleyendo del archivo: %s%n", e.getMessage());
    }
  }
}
