import java.util.Locale;
import java.util.Scanner;

public class R01E11 {

  //Ingresamos el valor constante de la hora
  public static double  VALOR_HORA = 12;
  
  public static void main(String[] args) { 
   
    //ingresamos un cabezal estetico
    System.out.println("Calculadora de salario");
    System.out.println("");
    
    //ingresamos un ingreso para que pueda ingresar las horas
    Scanner hora = new Scanner(System.in); 
    System.out.printf("¿Cuantas horas has trabajado?");
    double cantidad_hora = Double.parseDouble(hora.nextLine());
     
    double sueldo = cantidad_hora * VALOR_HORA;
    
    //ingresamos el sueldo
    
    System.out.printf(Locale.US, "Tu sueldo es %f", sueldo);
    
  }
  
}
