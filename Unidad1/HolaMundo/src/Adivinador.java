import java.util.Scanner;
public class Adivinador {
 public static void main(String[] args) { 
    
   System.out.println("Soy adivinador");
   
    Scanner sc = new Scanner(System.in); 
    System.out.printf("En que animal piensas?");
        //leemos el nombre desde el teclado
        String nombre = sc.nextLine();
       //lo imprimimos
        System.out.printf("Tu animal es %s", nombre);
 }
}
