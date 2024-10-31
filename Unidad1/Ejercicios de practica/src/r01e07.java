import java.util.Locale;
import java.util.Scanner;

public class r01e07 {
 public static double  EURO_POR_PESETA = 166.386;
  
  public static void main(String[] args) { 
  //ingresamos un scanner para que el usuario pueda agregar las cifras
    Scanner pesetas = new Scanner(System.in);
    System.out.printf("insertar cantidad de pesetas");
    
    //cantidad de euros que tenemos
    double valor1 = Integer.parseInt(pesetas.nextLine());;
    
    //hacemos nuestra conversion
    double euros = valor1 / EURO_POR_PESETA; 
    
    //imprimimos el resultado
    System.out.printf(Locale.US, "La cantidad es %f en euros equivale a %f", valor1, euros);
}
}