package prog.unidad03.repeticion;

import java.util.Scanner;

public class PositivoNegativoApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    // Muestra la cabecera
    System.out.println("NÚMEROS POSITIVOS Y NEGATIVOS");

    // numero hay que declararlo aqui porque se debe poder usar después en while
    int numero;
    // Solicita números hasta que se introduzca cero
    do {
      System.out.print("Introduce un número entero (0 para terminar): ");
      numero = Integer.parseInt(sc.nextLine());
      // Si es positivo
      if (numero > 0) {
        // Se imprime el mensaje correspondiente
        System.out.printf("El número %d es positivo%n", numero);
      } else {
        // Si es negativo
        if (numero < 0) {
          // Lo mismo
          System.out.printf("El número %d es negativo%n", numero);
        }
      }
    } while (numero != 0);
  }
}
