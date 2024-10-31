package prog.unidad3.seleccion;
import java.lang.Math;
import java.util.Locale;
import java.util.Scanner;

public class EcuacionesDeSegundoGradoApp {

public static void main(String[] args) { 
    
    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
    System.out.println("Calculadora de segundo grado");
    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
    
    Scanner scan = new Scanner(System.in);
    
    System.out.printf("Introduce el valor del coeficiente a:%n");
    double coeficienteA = Double.parseDouble(scan.nextLine());
    System.out.printf("Introduce el valor del coeficiente b:%n");
    double coeficienteB = Double.parseDouble(scan.nextLine());
    System.out.printf("Introduce el valor del coeficiente c:%n");
    double coeficienteC= Double.parseDouble(scan.nextLine());
    
    double resultado = (coeficienteB*coeficienteB) - 4 * coeficienteA * coeficienteC;
      
      if (resultado < 0 ) {
        
        System.out.printf(Locale.US,"No tiene soluciones reales%n");
        
      } 
      else if (resultado == 0) {
        
        System.out.printf(Locale.US,"Tiene una solucion real y es: %f%n", -coeficienteB/ (2*coeficienteA));
      
      }
      else if (resultado > 0 ) {
      
        System.out.printf(Locale.US,"Tiene una solucion reales de la raiz 1 es: %f%n", (-coeficienteB - Math.sqrt(resultado))/2*coeficienteA);
        System.out.printf(Locale.US,"Tiene una solucion reales de la raiz 2 es: %f", (-coeficienteB + Math.sqrt(resultado))/2*coeficienteA);
      }
   //1,6,2
   }
}


