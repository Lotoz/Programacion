package prog.unidad06.ficheros.utils;

import java.util.Scanner;

/**
 * Clase que ofrece utilidad para obtener ruta a fichero
 */
public class PromptFichero {

  /**
   * Obtiene la ruta al archivo o bien desde argumentos (si hay alguno) o desde teclado
   * (si no se ha pasado por argumentos)
   * @param prompt Mensaje a mostrar al usuario si hay que leer la ruta desde teclado
   * @param args Argumentos al programa
   * @param sc Scanner para leer desde teclado
   * @return Ruta al archivo obtenida por el medio que sea
   */
  public static String obtenerRuta(String prompt, String[] args, Scanner sc) {
    // Si no se ha especificado la ruta por parámetros
    if (args.length == 0) {
      // Se solicita por teclado y se devuelve
      System.out.print(prompt);
      return sc.nextLine();
    } else {
      // La ruta es el primer parámetro
      return args[0];
    }
  }
  
  /**
   * Obtiene la ruta al archivo o bien desde argumentos (si hay alguno) o desde teclado
   * (si no se ha pasado por argumentos)
   * @param prompt Mensaje a mostrar al usuario si hay que leer la ruta desde teclado
   * @param args Argumentos al programa
   * @return Ruta al archivo obtenida por el medio que sea
   */
  public static String obtenerRuta(String prompt, String[] args) {
    // Creamos un Scanner para acceder al teclado
    Scanner sc = new Scanner(System.in);
    return obtenerRuta(prompt, args, sc);
  }
}
