package prog.unidad04.actividad404.ejercicio09;

import java.util.Scanner;
import prog.unidad04.actividad404.ejercicio07.MayorMenor;

/**
 * Programa que determina los valores mayor y menor de una
 * serie de números positivos enteros leidos desde teclado
 */
public class MayorMenorPositivosApp {

  public static void main(String[] args) {
    // Scanner para leer desde teclado
    Scanner sc = new Scanner(System.in);
    
    // Numero leido desde teclado
    int numero = 0;
    // Objeto para calcular el mmayor y el menor
    // Se inicia a null porque se crea con el primer número introducido
    MayorMenor mayorMenor = null;
    // Lee los números
    do {
      // Lee el número (o por lo menos lo intenta
      try {
        System.out.print("Introduce un número entero (negativo para terminar): ");
        numero = Integer.parseInt(sc.nextLine());
        // Si el numero es positivo o cero
        if (numero >= 0) {
          // Si el analizador no esta creado, lo crea con el número
          if (mayorMenor == null) {
            mayorMenor = new MayorMenor(numero);
          } else {
            // Si esta creado añade el numero
            mayorMenor.add(numero);
          }
        } 
      } catch (NumberFormatException e) {
        // Mostramos un mensaje
        System.out.println("Lo que se ha introducido no es un número entero. Inténtalo de nuevo");
      }
    } while (numero >= 0);
    
    // Si se ha introducido algún numero
    if (mayorMenor != null) {
      // Imprime la media
      System.out.println("El mayor de los numeros es " + mayorMenor.getMayor()
        + " y el menor es " + mayorMenor.getMenor());
    } else {
      // Mostramos sólo un mensaje
      System.out.println("No se introdujo ningún número, por lo que no hay resultado");
    }
  }

}
