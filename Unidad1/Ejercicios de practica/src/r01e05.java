import java.util.Scanner;

public class r01e05 {
  public static void main (String[] args) {
    
    //agregamos antes de todo el import de scanner, luego el scanner para que se puegreeasr el numero
    Scanner numero1 = new Scanner(System.in); 
    System.out.printf("insertar numero");
     //agregamos la variable para analizar tal numero
    int valor1 = Integer.parseInt(numero1.nextLine());
    //repetimos para numero 2
    Scanner numero2 = new Scanner(System.in);
    System.out.printf("insertar numero");
    //agregamos la variable para analizar tal numero
   int valor2 = Integer.parseInt(numero2.nextLine());
   
   //realizamos las operaciones
   int suma = valor1 + valor2;
   System.out.println(suma);
   //imprimimos un espacio por mera estetica
   System.out.println("");
   //insertamos la resta e imprimimos
   int resta = valor1 - valor2;
   System.out.println(resta);
   
   System.out.println("");
   //insertamos el producto e imprimimos
   int producto = valor1 * valor2; 
   System.out.println(producto);
   
   System.out.println("");
   
   int cociente = valor1 / valor2;
   System.out.println(cociente);
   
   System.out.println("");
   
   int modulo = valor1 % valor2;
   System.out.println(modulo);
    
  }
}
