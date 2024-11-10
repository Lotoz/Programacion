package prog.unidad3.repeticion;

import java.util.Iterator;
import java.util.Scanner;

public class InvierteNumero {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Introduce un numero entero positivo: ");
    int numeroIntroducido = Integer.parseInt(sc.nextLine());
    int numeroInvertido = 0;
    int resto = numeroIntroducido;
    
    while (resto > 0) {

      int digito = resto % 10;
      
      resto /= 10;
      
      numeroInvertido = numeroInvertido * 10 + digito;
    }
    System.out.printf("El resultado de invertir el número %d es %d", numeroIntroducido, numeroInvertido);
  }
}
