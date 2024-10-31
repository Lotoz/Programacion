import java.util.Locale;
import java.util.Scanner;

public class r01e13 {
	
//insertamos la constantes de MB a KB y de KB a MB
	
	public static double  MB_A_KB = 1024;
	
	//Esta constante esta puesta en referencia de que un kilobyte vale 0.001 megabyte
  
  public static void main(String[] args) { 
    
    //ingresamos un cabezal estetico
    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
   
    System.out.println("Calculadora de MB a KB");
    
    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
    
    //Insertamos un scanner para que el usuario pueda ingresar la cantidad que desea transformar
    
    Scanner megabyte = new Scanner(System.in); 
    
    System.out.printf("¿Cuanto es la cantidad de MB que desea calcular?");
    
    //La siguiente linea de print es para mover el numero ingresado por el usuario y que se vea mas estetico
    
    System.out.println(" ");
    
    //la siguiente linea toma el valor ingresado por el usuario y lo convierte en una variable 
    
    double megabyte_valor = Double.parseDouble(megabyte.nextLine());
    
    //Ingresamos la ecuacion de conversion que debe realizar el programa para dar el resultado
    
    double megabyte_a_kilobyte  = megabyte_valor * MB_A_KB ;
    
    //imprimimos el resultado
    
    System.out.printf(Locale.US, "Tus megabytes %f a kilobyte son %f", megabyte_valor, megabyte_a_kilobyte);
    
  }
    
}
