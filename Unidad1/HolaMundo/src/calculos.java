import java.util.Scanner;

public class calculos {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in); 
    System.out.printf("Tu name");
        
    //leemos el nombre desde el teclado
    String nombre = sc.nextLine();
       
    //lo imprimimos
       
    System.out.printf("Hola %s", nombre);
  
    System.out.println("");
    System.out.println("");
      
      
    Scanner tecla = new Scanner(System.in);
    System.out.println("Introduce tu edad");
    
    //Insertamos el numero 
    int edad = Integer.parseInt(tecla.nextLine());
       
    //lo imprimimos
     System.out.printf("Tienes %d", edad);
  }

}
