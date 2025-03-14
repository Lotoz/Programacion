package prog.unidad06.ficheros.ejercicio03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import prog.unidad06.ficheros.utils.PromptFichero;

/**
 * Cuenta la cantidad de ocurrencias de un byte en un archivo binario
 */
public class CuentaBytesEnArchivoApp {
  
  /**
   * Punto de entrada
   * @param args Argumentos
   */
  public static void main(String[] args) {
    CuentaBytesEnArchivoApp app = new CuentaBytesEnArchivoApp();
    app.run(args);
  }

  /**
   * Ejecuta la aplicación
   * @param args Argumentos de la línea de comandos
   */
  private void run(String[] args) {
    // Scanner para leer desde teclado
    Scanner sc = new Scanner(System.in);
    
    // Accede a la ruta del fichero
    String ruta = PromptFichero.obtenerRuta("Introduzca el nombre del fichero a acceder: ", args, sc);
    
    // Solicita el valor de byte
    System.out.print("Introduzca el valor del byte a contabilizar: ");
    int valor = Integer.parseInt(sc.nextLine());
    
    // Si el valor es válido
    if (valor >= 0 && valor <= 255) {
      // Intenta acceder al fichero
      try (FileInputStream entrada = new FileInputStream(ruta)) {
        // Byte leido
        int leido = -1;
        // Apariciones
        int apariciones = 0;
        do {
          // Lee un byte
          leido = entrada.read();
          // Si es el buscado
          if (leido == valor) {
            // Lo cuenta
            apariciones++;
          }
        // Hasta fin de fichero
        } while (leido != -1);
        // Imprime el resultado
        System.out.printf("El byte %d aparece %d veces en el fichero %s%n", valor, apariciones, ruta);
      } catch (FileNotFoundException e) {
        // Fichero no encontrado
        System.out.printf("Error. No se encuentra el fichero \"%s\"%n", ruta);
      } catch (IOException e) {
        // Error de entrada / salida
        System.out.printf("Error accediendo al fichero \"%s\"%n", ruta);
      }
    } else {
      // Valor no válido de byte
      System.out.println("Error. El valor introducido no es un byte válido (0-255)");
    }
  }
}
