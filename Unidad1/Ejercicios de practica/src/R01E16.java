import java.util.Locale;
import java.util.Scanner;

public class R01E16 {

  
  public static void main(String[] args) {
    
  System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
  System.out.println("Cuanto invirtio cada uno en la empresa");
  System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
  System.out.println("");
  
  //Ingresamos un scan para que puedan ingresar los datos de cada inversion
  Scanner scan = new Scanner(System.in); 
  
  System.out.println("Ingresar inversion 1");
  System.out.println("");  
  double inversion_1= Double.parseDouble(scan.nextLine());
  
 
  System.out.print("Ingresar inversion 2");
  System.out.println("");  
  double inversion_2 = Double.parseDouble(scan.nextLine());

  
  System.out.print("Ingresar inversion 3");
  System.out.println(""); 
  double inversion_3 = Double.parseDouble(scan.nextLine());
 
  //Luego con los datos calculados calculamos la inversion total
  
  double inversion_final = inversion_1 + inversion_2 + inversion_3 ;
  //agregar esto 3 veces porcentaje, dinero invertido *100 /tpotal
  
  System.out.printf(Locale.US, "El total invertido es de %f", inversion_final);
   }
}
