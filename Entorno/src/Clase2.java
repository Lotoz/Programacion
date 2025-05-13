import java.util.Scanner;

public class Clase2 {
  
  public static void main(String[] args) {
    boolean salida = false;
    Scanner scan = new Scanner(System.in);
    System.out.printf("Ingresa un numero = ");
    int numero = Integer.parseInt(scan.nextLine());
    
    do {
      System.out.printf("Ingresa otro numero = ");
      int numero2 = Integer.parseInt(scan.nextLine());
      
      int suma = numero + numero2;
      if (suma == 30) {
        System.out.printf("Adivinaste");
        salida = true;
      }else {
        System.out.printf("No has advinado, tu numero actual es %f", suma);
      }
    }while (!salida);
  }
}
