package prog.unidad3.repeticion;

import java.util.Scanner;

public class DetectorPrimosApp {

public static void main(String[] args) { 
    
    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
    System.out.println("    Calculador de Primos ");
    System.out.println("        V.1.0            ");
    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-="); 
    
    Scanner sc = new Scanner(System.in);
    System.out.print("Introduce un número entero mayor que 1 para ver si es primo o no:");
    int numero = Integer.parseInt(sc.nextLine());
    
    if (numero > 0) {
      int multiplo = 0;
      
    for ( int i = multiplo ; i <= numero; i++ ) {
      if ( numero <= i) {
        multiplo++; 
      }else if (numero %i == 0) {
        
      System.out.printf("El numero %d es primo ", numero);  
      }else if (numero % i != 0 ) {
        System.out.printf("El numero %d no es primo ", numero);
      } else {
        System.out.printf("Introduce un valor valido");
      }
     
    }
  }
}
}
