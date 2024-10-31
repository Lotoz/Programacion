package prog.unidad3.seleccion;

import java.util.Locale;
import java.util.Scanner;

public class MayorDeDosAppV1 {

 public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Introduce el primer número:");
    double numero1 = Double.parseDouble(sc.nextLine());
    System.out.println("Introduce el segundo número:");
    double numero2 = Double.parseDouble(sc.nextLine());
    
    double numeroMayor = (numero1 >= numero2) ? numero1 : numero2;
    
    System.out.printf(Locale.US,"El numero es mayor a %f.", numeroMayor);
 }
}
