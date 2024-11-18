package prog.unidad03.repeticion;

import java.util.Scanner;

public class FactoresPrimosApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Muestra la cabecera
    System.out.println("CALCULO DE FACTORES PRIMOS");

    // Solicita el número
    System.out.print("Introduce un número entero mayor que 1 para descomponerlo en factores primos: ");
    int numero = Integer.parseInt(sc.nextLine());

    // Si es mayor que 1
    if (numero > 1) {
      // Vamos probando los factores desde 2 hasta el número
      int factor = 2;

      // Mientras que no lleguemos a 1
      while (numero > 1) {
        // Si el número es divisible por el factor
        if (numero % factor == 0) {
          // Mostramos el factor primo encontrado
          System.out.printf("%d es un factor primo%n", factor);
          // Dividimos el número por el factor para ver los siguientes divisores
          numero /= factor;
          // OJO: No pasamos al siguiente factor sino que en la siguiente repetición intentaremos probar el mismo
        } else {
          // Si no es un factor, pasamos al siguiente número
          factor++;
        }
      }
    } else {
      // El número no es mayor que uno. No hacemos la descomposición y mostramos un mensaje
      System.out.println("ERROR: Debes introducir un número mayor que 1");
    }
  }

}
