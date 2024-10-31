import java.util.Locale;
import java.util.Scanner;

public class R01E15 {
  
  //Sabemos que siempre tendra una comision del 10% por ende ya metemos una constante de esto
  
  public static double  COMISION = 0.10 ;
    
  public static void main(String[] args) { 
    
    System.out.println("><~><~><~><~><~><~><~><~><~><");
    System.out.println("Calcula el salario de este mes :D");
    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
    
    //Insertamos un scan para que el pueda ingresar cuantas ventas hizo
   
    Scanner salario = new Scanner(System.in); 
    
   System.out.printf("¿Cuanto es tu salario?");
    
    double salario_base = Double.parseDouble(salario.nextLine());
    
    System.out.printf("¿Cuanto has ganado en ventas?");
    
    Scanner ventas_dinero = new Scanner(System.in); 
    
    double ventas_dinero_ingresado = Double.parseDouble(ventas_dinero.nextLine());
   
    //Luego ese por la cantidad de dinero que tenia
    
    double dinero_extra = ventas_dinero_ingresado * COMISION ;
    
    //Luego aquello se lo sumamos al sueldo
    
    double sueldo_final = dinero_extra + salario_base ;
    
   // Al final imprimimos la salida
    
    System.out.printf(Locale.US, "Tu sueldo de este mes sera de %f pesos argentinos", sueldo_final);
   
  }

}
