package prog.unidad03.repeticion;

import java.util.Scanner;

public class CuentaPositivosApp {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    // Muestra la cabecera
    System.out.println("CONTADOR DE POSITIVOS");

    // numero hay que declararlo aqui porque se debe poder usar en while
    int numero;
    // contador hay que declararlo aqui porque se usa en el do-while y despues
    int contador = 0;
    do {
      // Solicita un numero
      System.out.print("Introduce un número entero positivo o cero (negativo para terminar): ");
      numero = Integer.parseInt(sc.nextLine());
      // Si el número es positivo (incluyendo cero)
      if (numero >= 0) {
        // Lo cuenta
        contador++;
      }
    } while (numero >= 0);

    // Muestra el resultado
    System.out.printf("Has introducido %d números positivos%n", contador);
  }

}
