package prog.unidad03.repeticion;

import java.util.Scanner;

public class NumerosParesImparesEntreApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    // Muestra la cabecera
    System.out.println("PARES O IMPARES EN UN INTERVALO");
    
    // Solicita los dos números
    System.out.print("Introduce el número de comienzo del intervalo: ");
    int numeroInicio = Integer.parseInt(sc.nextLine());
    System.out.print("Introduce el número de fin del intervalo: ");
    int numeroFin = Integer.parseInt(sc.nextLine());
    
    // Si el número de inicio es menor o igual al de fin
    if (numeroInicio <= numeroFin) {
      // Para cada número del intervalo
      for (int i = numeroInicio; i <= numeroFin; i++) {
        // Si es par o impar imprime el mensaje correspondiente
        if (i % 2 == 0) {
          System.out.printf("El número %d es par%n", i);
        } else {
          System.out.printf("El número %d es impar%n", i);
        }
      }
    } else {
      // El numero de inicio del intervalo no es menor o igual al de fin
      // Muestra mensaje de error
      System.out.printf("Error. El número de inicio (%d) debe ser menor o igual al de final (%d)%n"
        , numeroInicio, numeroFin);
    }
  }
}
