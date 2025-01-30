package prog.unidad05.json.ejercicio2;
import java.util.Scanner;

import prog.unidad05.json.ejercicio1.DiccionarioSpanishEnglishFromFile;
/**
 * Permite al usuario traducir palabras del inglés al español
 */

public class TraductorSpanishEnglishFromFile {

  public static void main(String[] args) {
    // Scanner para leer desde teclado
    Scanner sc = new Scanner(System.in);
    
    // Diccionario para traducir las palabras
    DiccionarioSpanishEnglishFromFile diccionario = new DiccionarioSpanishEnglishFromFile("JSON/diccionario.json");
    
    // Cabecera
    System.out.println("TRADUCCIÓN ESPAÑOL - INGLÉS");
    
    // Palabra
    String palabra = "";
    // Mientras no se introduzca una palabra vacía
    do {
      // Lee la palabra desde teclado
      System.out.print("Introduzca una palabra a traducir al inglés (vacía para terminar): ");
      palabra = sc.nextLine();
      // Busca la palabra en el diccionario
      String traduccion = diccionario.traducir(palabra);
      // Si no es vacía
      if (!palabra.isBlank()) {
        // Si hay traducción
        if (traduccion != null) {
          // La muestra por pantalla
          System.out.printf("La palabra española \"%s\" significa \"%s\" en inglés%n", palabra, traduccion);
        } else {
          // La palabra no está en el diccionario. Muestra mensaje al usuario
          System.out.printf("Lo siento. La palabra \"%s\" no se encuentra en nuestro diccionario%n", palabra);
        }
      }
    } while (!palabra.isBlank());
  }

}


