package prog.unidad3.seleccion;
import java.util.Locale;
import java.util.Scanner;

public class MayorDeDosApp {
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Introduce el primer número:");
    double numero1 = Double.parseDouble(sc.nextLine());
    System.out.println("Introduce el segundo número:");
    double numero2 = Double.parseDouble(sc.nextLine());
    
    if ( numero1 > numero2 ) {
      
      System.out.printf(Locale.US,"Numero %f es mayor que %f.%n", numero1, numero2);
      
    } else if ( numero1 < numero2 )  {
      
      System.out.printf(Locale.US,"Numero %f es mayor que %f.%n", numero2, numero1);
    } else if ( numero1 == numero2 ) {
      
      System.out.printf(Locale.US,"Ambos numeros son iguales.");
    } else {
      System.out.print("Bro, porfa escribime y dime como rompiste este programa x_x.");
    }
  }
}
