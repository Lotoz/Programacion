package prog.unidad06.consola.ejercicio01;

import java.util.Locale;
import java.util.Scanner;

public class TablasMultiplicarApp {
  
  public static void main(String[] args) { 
    //Para pillar si el usuario no metes numeros
    try {
      //Iniciamos scanner
      Scanner  scan = new Scanner(System.in);
      
      //Pedimos la datos
      System.out.printf("Tablas de multiplicar.%n");
      System.out.printf("Dame el primer numero(Define de que tabla sera).%n");
      int numero1 = Integer.parseInt(scan.nextLine());
      System.out.printf("Dame el segundo numero.(Define desde donde empieza a multiplicar)%n");
      int numero2 = Integer.parseInt(scan.nextLine());
      
      //Imprimimos la tabla
      System.out.printf("La tabla del %1d %n", numero1);
      //La imprime 10 veces
      for(int i = 0; i < 10; i++) {
        int resultado = numero1 * numero2;
      System.out.printf(Locale.US,"%2d X %2d = %2d %n",numero1, numero2, resultado);
      numero2++;
      }
    } catch (Exception e) {
      System.out.printf(Locale.US,"Deben ser numeros enteros");
    }
  }
}
    

