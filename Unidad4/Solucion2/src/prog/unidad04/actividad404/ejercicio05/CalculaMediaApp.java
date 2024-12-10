package prog.unidad04.actividad404.ejercicio05;

import java.util.Scanner;
import prog.unidad04.actividad404.ejercicio04.CalculadorMedia;

/**
 * Programa que calcula la media de una cantidad cualquiera de números enteros
 */
public class CalculaMediaApp {

  public static void main(String[] args) {
    
    // Creamos el Scanner para leer desde teclado
    Scanner sc = new Scanner(System.in);
    
    // Solicita la cantidad de números
    // Se debe hacer hasta que se introduzca un número entero correcto mayor que cero
    // Bandera que indica si el número es correcto. Inicialmente no lo es
    boolean bCorrecto = false;
    int cantidad = 0;
    do {
      // Solicitamos el número
      try {
        System.out.print("Introduce la cantidad de números que vas a introducir (uno o mas): ");
        cantidad = Integer.parseInt(sc.nextLine());
        // Si la cantidad es 1 o mas
        if (cantidad >= 1) {
          // Correcto
          bCorrecto = true;
        } else {
          System.out.println("El número debe ser mayor que cero. Inténtalo de nuevo");
        }
      } catch (NumberFormatException e) {
        // Mostramos un mensaje
        System.out.println("Lo que se ha introducido no es un número entero. Inténtalo de nuevo");
      }
    } while (!bCorrecto);
    
    // Solicitamos el primer número
    // Se hace fuera del ciclo porque aqui se construye el objeto CalcularMedia
    int numero = 0;
    bCorrecto = false;
    do {
      // Solicitamos el número
      try {
        System.out.print("Introduce el número (1): ");
        numero = Integer.parseInt(sc.nextLine());
        // Es correcto
        bCorrecto = true;
      } catch (NumberFormatException e) {
        // Mostramos un mensaje
        System.out.println("Lo que se ha introducido no es un número entero. Inténtalo de nuevo");
      }
    } while (!bCorrecto);
    
    // Crea el calculador de la media con el primer numero
    CalculadorMedia calculador = new CalculadorMedia(numero);
    
    // Solicita la cantidad de numeros pedidos menos el primero que ya se ha pedido
    for (int i = 1; i < cantidad; i++) {
      bCorrecto = false;
      do {
        // Solicitamos el número
        try {
          System.out.print("Introduce el número (" + (i + 1)  + "): ");
          numero = Integer.parseInt(sc.nextLine());
          // Es correcto
          bCorrecto = true;
        } catch (NumberFormatException e) {
          // Mostramos un mensaje
          System.out.println("Lo que se ha introducido no es un número entero. Inténtalo de nuevo");
        }
      } while (!bCorrecto);
      // Añadimos el número a la serie
      calculador.add(numero);
    }
    // Calcula e imprime la media
    System.out.println("La media de los números introducidos es " + calculador.getMedia());
  }
}
