package prog.unidad3.seleccion;

import java.util.Locale;
import java.util.Scanner;

public class MayorDeTresApp {

 public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Introduce el primer número:");
    double numero1 = Double.parseDouble(sc.nextLine());
    System.out.println("Introduce el segundo número:");
    double numero2 = Double.parseDouble(sc.nextLine());
    System.out.println("Introduce el tercer número:");
    double numero3 = Double.parseDouble(sc.nextLine());
    
    double numeroMayor = (numero1 >= numero2) ? numero1 : numero2;
    double numeroMayorFin = (numeroMayor >= numero3) ? numeroMayor : numero3; 
  
    System.out.printf(Locale.US,"El numero es mayor a %f.", numeroMayorFin);
 }
}

