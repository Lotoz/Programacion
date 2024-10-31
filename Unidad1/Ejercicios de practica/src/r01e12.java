import java.util.Locale;
import java.util.Scanner;

public class r01e12 {

  //ingresamos la constante de pi
public static double  PI = 3.14;
  
  public static void main(String[] args) { 
    
  //ingresamos un cabezal estetico
  System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
  
  System.out.println("Calculadora de volumen");
  
  System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
  
  //ingresamos un scan para el valor altura
  Scanner altura = new Scanner(System.in); 
  
  System.out.printf("¿Cuanto es la altura?");
  
  double altura_valor = Double.parseDouble(altura.nextLine());
  
//ingresamos un scan para el valor altura
  Scanner radio = new Scanner(System.in); 
  
  System.out.printf("¿Cuanto es el radio?");
  
  double radio_valor = Double.parseDouble(radio.nextLine());
  
  //ingresamos la formula
  double volumen =  (PI * ( radio_valor*radio_valor ) * altura_valor)/3 ;
  
  //Imprimo la salida
  System.out.printf(Locale.US, "Tu volumen es %f", volumen);
  
   //mas estetica
  System.out.println("");
  
  System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
  }
}
