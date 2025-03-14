package prog.unidad06.ficheros.ejercicio04;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import prog.unidad06.ficheros.utils.PromptFichero;

/**
 * Programa que rellena un fichero con bytes aleatorios
 */
public class FicheroBytesAleatorios {

  /**
   * Punto de entrada
   * @param args Argumentos de la línea de comandos
   */
  public static void main(String[] args) {
    FicheroBytesAleatorios app = new FicheroBytesAleatorios();
    app.run(args);
    
  }


  /**
   * Metodo principal de la aplicación
   * @param args Argumentos de la línea de comandos
   */
  private void run(String[] args) {
    // Scanner para leer desde teclado
    Scanner sc = new Scanner(System.in);
    
    // Solicita la ruta
    String ruta = PromptFichero.obtenerRuta("Introduzca la ruta al archivo a crear: ", args, sc);
    
    // Solicita la longitud del fichero
    System.out.print("Introduzca la longitud del fichero a crear (en bytes): ");
    int longitud = Integer.parseInt(sc.nextLine());
    
    // Solicita el límite inferior del rango de números aleatorios
    System.out.print("Introduzca el límite inferior del rango de extracción de bytes aleatorios (0-255): ");
    int byteInferior = Integer.parseInt(sc.nextLine());
    
    // Y el superior
    System.out.printf("Introduzca el límite superior del rango de extracción de bytes aleatorios (%d-255): ", byteInferior);
    int byteSuperior = Integer.parseInt(sc.nextLine());
    
    // Si el byte Inferior es igual o inferior al superior y ambos son bytes
    if (byteInferior >= 0 && byteInferior <= 255 && byteSuperior >= 0
      && byteSuperior <= 255 && byteInferior <= byteSuperior) {
      // Generador de números aleatorios
      Random random = new Random();
      // Creamos el fichero y abrimos try
      try (FileOutputStream salida = new FileOutputStream(ruta)) {
        // Para cada byte a escribir
        for (int i = 0; i < longitud; i++) {
          // Escribe el byte aleatorio
          salida.write(random.nextInt(byteInferior, byteSuperior + 1));
        }
        System.out.println("Fichero creado");
      } catch (FileNotFoundException e) {
        // Fichero no encontrado
        System.out.printf("Error. No se puede crear el fichero \"%s\"%n", ruta);
      } catch (IOException e) {
        // Error de E/S
        System.out.printf("Error escribiendo en el fichero \"%s\"%n", ruta);
      }
    }
  }
}
