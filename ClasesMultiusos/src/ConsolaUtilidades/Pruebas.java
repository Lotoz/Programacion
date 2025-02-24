package ExceptionPersonalizado;

import java.util.Scanner;

import ExceptionPersonalizado.ConsolaException;

public class Pruebas {

  public static void main(String[] args) {
    boolean salida = false;

    do {
      try {
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("    Cuenta Pares         ");
        System.out.println("        V.1.0            ");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");

        Scanner sc = new Scanner(System.in);
        System.out.print("¿Cuántos pares deseas introducir?: ");
        int pares = Integer.parseInt(sc.nextLine());
        if (pares > 0) {
          int contadorPar = 0;
          do {
            System.out.print("Introduce un numero entero: ");
            int numero = Integer.parseInt(sc.nextLine());

            if (numero % 2 == 0) {
              // hacemos que lo amplifique para agregar mas
              contadorPar++;
            }
            if (pares == contadorPar) {

              System.out.printf("Haz introducido todo :D%n");
            } else {
              System.out.printf("Te faltan %d%n", pares - contadorPar);
            }
          } while (pares > contadorPar);
        }
        salida = true;
      } catch (NumberFormatException e) {
        ConsolaException.mostrarError(e);
      }
    } while (!salida);
  }
}
