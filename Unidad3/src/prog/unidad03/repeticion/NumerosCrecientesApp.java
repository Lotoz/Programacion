package prog.unidad03.repeticion;

import java.util.Scanner;

public class NumerosCrecientesApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    // Cabecera
    System.out.println("NÚMEROS CRECIENTES");

    // Solicita el primer número
    // Se hace fuera del ciclo porque tiene un tratamiento especial, como número inicial
    System.out.print("Introduce un número entero: ");
    int numero = Integer.parseInt(sc.nextLine());
    
    // En esta variable almacenamos el último número introducido
    int numeroAnterior;
    
    do {
      // Almacena el número actual
      numeroAnterior = numero;
      // Y solicita el siguiente número
      System.out.printf("Introduce ahora un número mayor que %d (Introduce un número menor o igual para terminar): ", numeroAnterior);
      numero = Integer.parseInt(sc.nextLine());
      // Si el número no es creciente
      if (numero <= numeroAnterior) {
        // Muestra el mensaje de fin
        System.out.printf("El número %d no es mayor que el número anterior %d. Terminando%n", numero, numeroAnterior);
      }
    } while (numero > numeroAnterior);
  }

}
