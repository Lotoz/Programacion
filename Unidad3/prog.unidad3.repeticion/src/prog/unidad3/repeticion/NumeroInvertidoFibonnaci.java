package prog.unidad3.repeticion;

import java.util.Scanner;

public class NumeroInvertidoFibonnaci {
public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Introduce un numero entero: ");
    int numero = Integer.parseInt(sc.nextLine());
    int resto = numero;
    while (numero != 0) {
       if (numero > 0 ) {
         int digito = resto % 10;
         
         resto /= 10;
         
         //int numeroInvertido = numeroInvertido * 10 + digito;
       }else if (numero < 0 ) {
         
       }
    }
}
}
