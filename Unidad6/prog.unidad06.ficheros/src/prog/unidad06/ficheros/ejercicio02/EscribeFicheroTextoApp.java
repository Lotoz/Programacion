package prog.unidad06.ficheros.ejercicio02;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Debe crear o sobreescribir un fichero de texto con las lineas que el usuario
 * introduzca
 */
public class EscribeFicheroTextoApp {

  public static void main(String[] args) {
    // Iniciamos el scan.
    Scanner scan = new Scanner(System.in);

    // Le pedimos al usuario la ruta de salida
    System.out.printf("Introduce la ruta de salida:");
    String ruta = scan.nextLine();

    // Invocamos metodo privado
    EscribeFichero(ruta);

  }

  /**
   * Escribe un fichero de texto
   * 
   * @param ruta del fichero
   */
  private static void EscribeFichero(String ruta) {
    try (PrintWriter flujoSalida = new PrintWriter(new FileWriter(ruta))) {
      //Ver como hacer para crear solo un scan
      Scanner scan = new Scanner(System.in);
      //Ciclo para leer el archivo
      System.out.printf("Fichero iniciado con exito, introduzca  el texto a almacenar línea a línea y una línea vacia para terminar.%n");
      String linea = "";
      
        do {
          System.out.printf("Texto de la linea:");
          linea = scan.nextLine();
          flujoSalida.println(linea);
        } while (!linea.isEmpty());
      
    }catch (IOException e){
      
      System.err.printf("No se puede escribir en el fichero.");

    }

  }

}
