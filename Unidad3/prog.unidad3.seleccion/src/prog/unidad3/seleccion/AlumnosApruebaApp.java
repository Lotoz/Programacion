package prog.unidad3.seleccion;

import java.util.Locale;
import java.util.Scanner;

public class AlumnosApruebaApp {
 public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Introduce la clasificacion de la primera evaluacion:");
    double nota1 = Double.parseDouble(sc.nextLine());
    System.out.println("Introduce la clasifcacion de la segunda evaluacion:");
    double nota2 = Double.parseDouble(sc.nextLine());
    System.out.println("Introduce la clasificacion de la tercera evaluacion:");
    double nota3 = Double.parseDouble(sc.nextLine());
 
    double notafinal = (nota1+nota2+nota3)/3;
    
    if ( notafinal >= 5) {
      
      System.out.printf(Locale.US,"El alumno ha aprobado con una media de %f.%n",notafinal);
      
    } else {
      
      System.out.printf(Locale.US,"El alumno ha suspendido con una media de %f.%n",notafinal);
      
    }
  }
}
