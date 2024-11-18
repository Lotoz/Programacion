package prog.unidad03.repeticion;

import java.util.Scanner;

public class CalculaDivisoresApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    // Cabecera
    System.out.println("DIVISORES DE UN NÚMERO");

    // Solicita el número
    System.out.print("Introduce un número entero para que calcule sus divisores: ");
    int numero = Integer.parseInt(sc.nextLine());
    
    // Para 1 hasta el número
    for (int i = 1; i <= numero; i++) {
      
      // Si el número es divisible por el actual
      if (numero % i == 0) {
        // Lo imprimimos por consola
        System.out.printf("Es divisible por %d%n", i);
      }
    }
  }

}
