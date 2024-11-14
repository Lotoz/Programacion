package prog.unidad03.excepciones;

import java.util.Scanner;

public class NumeroSeguroApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    // Mostramos cabecera
    System.out.println("INTRODUCCIÓN DE NÚMERO SEGURA");
    
    // Capturamos excepciones dentro del bloque siguiente
    try {
      // Intentamos leer el número
      System.out.print("Introduce un número entero: ");
      int numero = Integer.parseInt(sc.nextLine());
      // Si llega hasta aqui, es que lo introducido se ha posido convertir a número
      // Mostramos el mensaje
      System.out.printf("El número introducido es %d%n", numero);
    } catch (NumberFormatException e) {
      // Esta excepción se lanza en Integer.parseInt() si lo que se le pasa no es un número
      // Mostramos un mensaje
      System.out.println("El dato introducido no es un número válido");
    }
  }

}
