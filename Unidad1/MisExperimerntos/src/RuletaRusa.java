import java.util.Scanner;

public class RuletaRusa {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in); 
    int ufa = Integer.parseInt(sc.nextLine());
    
    while (ufa < 6) {
      System.out.printf("Vamos de nuevo");
      
      if ( ufa == 6) {
         while (ufa==6) {
           System.out.printf("Explota");
         }
      }
    }
    
  } 
}
