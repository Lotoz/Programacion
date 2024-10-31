package prog.unidad3.repeticion;

import java.util.Locale;
import java.util.Scanner;

public class MayorMenorMediaApp {
  public static void main(String[] args) { 
  
    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
    System.out.println("    Mayor o Menor?        ");
    System.out.println("        V.1.0            ");
    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-="); 

    Scanner sc = new Scanner(System.in);
    System.out.print("¿Cuántos números deseas introducir?: ");
    //aqui es int porque no vamos a pedir numeros no enteros.
    int numeros = Integer.parseInt(sc.nextLine());
  
    //Debes empezar con if para poder hacer luego la comparativa.
      if (0 < numeros){
        System.out.print("Introduce el número 1: ");
        double numero = Double.parseDouble(sc.nextLine());
        
        double mayor = numero;
        double menor = numero;
        double suma = numero;
        
        //Ya teniendo lo principal, debemos insertar el bucle 
        for (int i = 2; i <= numeros; i++) {
          
          System.out.printf("Introduce el número %d: ", i);
          numero = Double.parseDouble(sc.nextLine());
          
         //arranca la comparacion del bucle
          
          if (numero > mayor) {
       
            mayor = numero;
          }
        
          else if (numero < menor) {
       
            menor = numero;
          }
        ///se puede hacer aparte porque estamos insertando una operacion pero dentro del bucle.
          suma += numero;
        }
        System.out.printf(Locale.US, "El mayor de los números introducidos ha sido: %f%n", mayor);
        System.out.printf(Locale.US, "El menor de los números introducidos ha sido: %f%n", menor);
        System.out.printf(Locale.US, "La media de todos los números vale: %f%n", (suma / numeros));
      } else {
        
        // Muestra mensaje de error
        System.out.println("Debes introducir por lo menos una cantidad");
      }
  
  
  }
}