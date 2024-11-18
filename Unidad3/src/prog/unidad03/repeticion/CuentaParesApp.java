package prog.unidad03.repeticion;

import java.util.Scanner;

public class CuentaParesApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    // Cabecera
    System.out.println("CUENTA PARES");
    
    // Solicita la cantidad de números pares a introducir
    System.out.print("¿Cuántos números pares deseas introducir?: ");
    int cantidadPares = Integer.parseInt(sc.nextLine());
    
    // Inicia la cuenta de los pares
    int paresHastaAhora = 0;
    
    // Mientras no se hayan introducido los pares especificados
    while (paresHastaAhora < cantidadPares) {
      // Solicita un número
      System.out.print("Introduce un número entero: ");
      int numero = Integer.parseInt(sc.nextLine());
      // Si es par
      if (numero % 2 == 0) {
        // Lo cuenta
        paresHastaAhora++;
        // Muestra el mensaje adecuado según hayamos llegado al límite establecido o no
        if (paresHastaAhora < cantidadPares) {
          System.out.printf("Te quedan %d números pares por introducir%n", (cantidadPares - paresHastaAhora));
        } else {
          System.out.printf("¡Ya has introducido %d números pares!%n", cantidadPares);
        }
      }
    }
  }

}
