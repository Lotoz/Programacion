package prog.unidad3.repeticion;

import java.util.Scanner;

public class CuentaParesImparesApp {

public static void main(String[] args) { 
    
    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
    System.out.println("    Impar o Par           ");
    System.out.println("        V.1.0            ");
    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-="); 
    
    Scanner scan = new Scanner(System.in);
    System.out.printf("Cuantos numeros quieres comparar?");
   
    System.out.print("¿Cuántos números deseas introducir?: ");
    int numeros = Integer.parseInt(scan.nextLine());
    
    // Contadores inicializados a cero
    int contadorPares = 0;
    int contadorImpares = 0;
    
    // Para tantos números como se haya especificado
    for (int i = 1; i <= numeros; i++) {
      // Solicita el número
      System.out.printf("Introduce el número %d: ", i);
      int numero = Integer.parseInt(scan.nextLine());
      
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
