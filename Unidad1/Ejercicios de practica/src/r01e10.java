import java.util.Scanner;
import java.util.Locale;

public class r01e10 {

  public static void main(String[] args) { 
    
    //Insertamos un scanner para poder permitir ingresar las cosas
    Scanner base = new Scanner(System.in); 
    System.out.printf("¿Cual es la base que deseas ingresar?");
   
  //creamos su variable
    double base_variable = Double.parseDouble(base.nextLine());;
    
    //Ahora creamos un ingreso para el IVA
    Scanner iva = new Scanner(System.in); 
    System.out.printf("¿Cual es el IVA que deseas ingresar?");
    
    //creamos su variable
    double iva_variable = Double.parseDouble(iva.nextLine());;
     
    //Creamos la ecuacion para calcular el IVA que se le aplica a cierto producto
    
    double factura = base_variable * ( 1 + iva_variable/100);
    
    //imprimimos la salida
    System.out.printf(Locale.US, "Su IVA agregado sera %f", factura);
 
    //pide hacerlo mas estetico y funcional en la solucio, mirarla y modificar.
  }
}
