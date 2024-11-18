package prog.unidad03.repeticion;

import java.util.Scanner;

public class CalculaFactorialApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    // Cabecera
    System.out.println("CÁLCULO DE FACTORIAL");
    
    // Solicita el número del que se quiere calcular el factorial
    System.out.print("Introduce un número entero mayor que cero para calcular su factorial: ");
    int numero = Integer.parseInt(sc.nextLine());
    
    if (numero > 0) {
      // Inicializamos el factorial (usamos un long porque pueden salir números muy grandes rápidamente)
      long factorial = 1;

      // Desde 1 hasta el número indicado
      for (int i = 1; i <= numero; i++) {
        // Multiplicamos el factorial que llevamos por el número
        factorial *= i;
      }
      
      // Mostramos el resultado
      System.out.printf("El factorial de %d vale %d%n", numero, factorial);
    }
  }
}
