import java.util.Locale;
import java.util.Scanner;

public class R01E17 {

  //ingresamos las constantes de porcentaje
  
  public static double  GINECOLOGIA = 0.40 ;
  public static double  PEDIATRIA = 0.35 ;
  public static double  TRAUMATOLOGIA = 0.25 ;
  
  public static void main(String[] args) { 
    
    System.out.println("><~><~><~><~><~><~><~><~><~><");
    System.out.println("Presupuesto del hospital");
    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
    
    Scanner presupuesto = new Scanner(System.in); 
    
    System.out.printf("¿Cuanto es el presupuesto?");
     
     double presupuest_base = Double.parseDouble(presupuesto.nextLine());
     
     double ginecologia = presupuest_base * GINECOLOGIA ;
     double pediatria = presupuest_base * PEDIATRIA ;
     double traumatologia = presupuest_base * TRAUMATOLOGIA ;
     
     System.out.printf(Locale.US, "El presupuesto sera para ginecologia de %f, para pediatria de %f y "
         + "para traumatologia de %f", ginecologia, pediatria, traumatologia);
     
  }
  
}
