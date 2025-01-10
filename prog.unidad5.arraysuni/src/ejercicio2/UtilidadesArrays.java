package ejercicio2;

import java.util.Random;
import java.util.Scanner;

public class UtilidadesArrays {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    System.out.printf("Da numero%n");
    int longitud = scan.nextInt();

    System.out.printf("Da numero minimo%n");
    int valorMinimo = scan.nextInt();

    System.out.printf("Da numero maximo%n");
    int valorMaximo = scan.nextInt();

    System.out.printf("El array es:");

    int[] array = new int[longitud];

    Random elAzar = new Random();

    for (int i = 0; i < array.length; i++) {
      array[i] = elAzar.nextInt(valorMinimo, valorMaximo);
    }

    for (int i = 0; i < array.length; i++) {
      System.out.printf("%d", array[i]);
    }

  }

  private int[] generaArrayEnteroAleatorio(int longitud, int valorMinimo, int valorMaximo) {
    Random elAzar = new Random();

    int[] resultado = new int[longitud];

    return resultado;
  }

  private int mostrarEnPantalla(int longitud) {
    return 0;
  }
}
