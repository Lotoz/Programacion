package prog.unidad3.seleccion;

import java.util.Locale;
import java.util.Scanner;

public class SituacionAlumnoApp {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Introduce la clasificacion de Matemáticas:");
    double nota1 = Double.parseDouble(sc.nextLine());
    System.out.println("Introduce la clasifcacion de Lengua:");
    double nota2 = Double.parseDouble(sc.nextLine());
    
    if ( nota1 < 5 && nota2 < 5) {
      
      System.out.printf(Locale.US,"El alumno no ha aprobado y no promociona.");
      
    } else if ( nota1 >= 5 && nota2 >= 5)  {
      
      System.out.printf(Locale.US,"El alumno ha aprobado y promociona");
    
    } else if (  nota1 >= 5 || nota2 >= 5) { 
      
      System.out.printf(Locale.US,"El alumno promociona con una asignatura pendiente.");
      
    }
  }
}
