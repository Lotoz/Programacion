package prog.unidad03.repeticion;

import java.util.Scanner;

public class DetectorPrimosApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    // Cabecera
    System.out.println("DETECTOR DE NUMEROS PRIMOS");

    // Solicita el número
    System.out.print("Introduce un número entero mayor que 1 para ver si es primo o no: ");
    int numero = Integer.parseInt(sc.nextLine());
    
    // Si el número es mayor que 1
    if (numero > 1) {
      // Contador de número de divisores
      int divisores = 0;
      
      // Para cada número desde 2 hasta el número objetivo (sin incluirlo porque un número siempre es divisor de si mismo)
      for (int i = 2; i < numero; i++) {
        // Si este número divide al objetivo
        if (numero % i == 0) {
          // Hemos encontrado otro divisor. Lo contamos
          divisores++;
        }
      }
      
      // Si se ha encontrado algún divisor
      if (divisores > 0) {
        // El número NO es primo
        System.out.printf("El número %d NO es primo%n", numero);
      } else {
        // Si no hay ningún divisor, SI es primo
        System.out.printf("El número %d es primo%n", numero);
      }
    } else {
      // Si el número objetivo no era mayor que 1 muestra un mensaje de error
      System.out.println("ERROR: Debes introducir un número mayor que 1");
    }
  }

}
