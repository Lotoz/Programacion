package prog.unidad04.actividad404.ejercicio06;

import java.util.Scanner;
import prog.unidad04.actividad404.ejercicio04.CalculadorMedia;

/**
 * Programa que calcula la media de una serie de números reales positivos
 * cualesquiera
 */
public class MediaSeriePositivosApp {

  public static void main(String[] args) {
    // Scanner para leer desde teclado
    Scanner sc = new Scanner(System.in);
    
    // Numero leido desde teclado
    double numero = 0;
    // Objeto para calcular la media
    // Se inicia a null porque se crea con el primer número introducido
    CalculadorMedia calculador = null;
    // Lee los números
    do {
      // Lee el número (o por lo menos lo intenta
      try {
        System.out.print("Introduce un número real (negativo para terminar): ");
        numero = Double.parseDouble(sc.nextLine());
        // Si el numero es positivo o cero
        if (numero >= 0) {
          // Si el calculador no esta creado, lo crea con el número
          if (calculador == null) {
            calculador = new CalculadorMedia(numero);
          } else {
            // Si esta creado añade el numero
            calculador.add(numero);
          }
        } 
      } catch (NumberFormatException e) {
        // Mostramos un mensaje
        System.out.println("Lo que se ha introducido no es un número real. Inténtalo de nuevo");
      }
    } while (numero >= 0);
    
    // Si se ha introducido algún numero
    if (calculador != null) {
      // Imprime la media
      System.out.println("La media de los numeros es " + calculador.getMedia());
    } else {
      // Mostramos sólo un mensaje
      System.out.println("No se introdujo ningún número, por lo que no hay resultado");
    }
  }

}
