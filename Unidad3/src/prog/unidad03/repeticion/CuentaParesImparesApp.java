package prog.unidad03.repeticion;

import java.util.Scanner;

public class CuentaParesImparesApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    // Cabecera
    System.out.println("CUENTA PARES O IMPARES");
    
    // Solicita la cantidad de números a introducir
    System.out.print("¿Cuántos números deseas introducir?: ");
    int numeros = Integer.parseInt(sc.nextLine());
    
    // Contadores inicializados a cero
    int contadorPares = 0;
    int contadorImpares = 0;
    
    // Para tantos números como se haya especificado
    for (int i = 1; i <= numeros; i++) {
      // Solicita el número
      System.out.printf("Introduce el número %d: ", i);
      int numero = Integer.parseInt(sc.nextLine());
      
      // Si es par o impar imprime el mensaje correspondiente
      if (numero % 2 == 0) {
        System.out.printf("El número %d es par%n", numero);
        contadorPares++;
      } else {
        System.out.printf("El número %d es impar%n", numero);
        contadorImpares++;
      }
    }
    
    // Muestra los resultados
    System.out.printf("Se han introducido %d números pares y %d números impares%n", contadorPares, contadorImpares);
    System.out.println("Fin del programa");
  }

}
