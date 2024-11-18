package prog.unidad03.combinado;

import java.util.Scanner;

public class PrimoSumaDigitosApp {
	
	 public static void main(String[] args) { 
		 
		 Scanner scan = new Scanner(System.in);
		 System.out.println("Dame un numero entero ");
		 int numero = Integer.parseInt(scan.nextLine());
		 
		 if (numero > 1) {
		        // Contador de número de divisores
		        int divisores = 0;
		        
		        // Para cada número desde 2 hasta el número objetivo (sin incluirlo porque un número siempre es divisor de si mismo)
		        for (int i = 2; i < numero; i++) {
		          // Si este número divide al objetivo
		          if (numero % i == 0) {
		            // Hemos encontrado otro divisor. Lo contamos
		            divisores++;
		          }
		        }
		        
		        // Si se ha encontrado algún divisor
		        if (divisores > 0) {
		          // El número NO es primo
		          System.out.printf("El número %d no es primo%n", numero);
		        } else {
		          // Si no hay ningún divisor, SI es primo
		          System.out.printf("El número %d es primo%n", numero);
		        }
		      } else {
		        // Si el número objetivo no era mayor que 1 muestra un mensaje de error
		        System.out.println("ERROR: Debes introducir un número mayor que 1");
		      }
		  }
	 }
}
