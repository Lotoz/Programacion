import java.util.Locale;
public class Euro_a_peseta {
 
  public static double  PESETAS_POR_EURO = 166.386;
  
  public static void main(String[] args) { 
    
    //cantidad de euros que tenemos
    double euros =65;
    
    //hacemos nuestra conversion
    double pesetas = euros * PESETAS_POR_EURO; 
    
    //imprimimos el resultado
    System.out.printf(Locale.US, "La cantidad es %f en euros equivale a %f", euros, pesetas);
    
  }
}
