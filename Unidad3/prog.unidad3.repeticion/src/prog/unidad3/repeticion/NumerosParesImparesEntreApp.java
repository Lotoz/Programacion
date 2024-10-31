package prog.unidad3.repeticion;

import java.util.Scanner;

public class NumerosParesImparesEntreApp {

  public static void main(String[] args) { 
    
    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
    System.out.println("    Impar o Par           ");
    System.out.println("        V.1.0            ");
    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-="); 
    
    Scanner sc = new Scanner(System.in);
    
    
    System.out.print("¿Cuántos números deseas introducir?: ");
    int numeros = Integer.parseInt(sc.nextLine());
    
    
    int contadorPares = 0;
    int contadorImpares = 0;
    
   
    for (int i = 1; i <= numeros; i++) {
    
      System.out.printf("Introduce el número %d: ", i);
      int numero = Integer.parseInt(sc.nextLine());
      
     
      if (numero % 2 == 0) {
        System.out.printf("El número %d es par%n", numero);
        contadorPares++;
      } else {
        System.out.printf("El número %d es impar%n", numero);
        contadorImpares++;
      }
    }
    

    System.out.printf("Se han introducido %d números pares y %d números impares%n", contadorPares, contadorImpares);
    System.out.println("Fin del programa");
    
  }
}