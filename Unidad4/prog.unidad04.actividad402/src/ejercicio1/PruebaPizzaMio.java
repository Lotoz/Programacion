package ejercicio1;
import java.util.Scanner;

public class PruebaPizzaMio {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);

    // Mostramos la cabecera
    System.out.println(" ⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜");
    System.out.println("⁜ PROGRAMA DE MANEJO DE PIZZAS ⁜");
    System.out.println(" ⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜");

    //creamos los objetos
    Pizza pizza1 = new Pizza("medium", "margarita");
    Pizza pizza2 = new Pizza("big", "funghi");
    
    pizza2.servir();
    
    Pizza pizza3 = new Pizza("mediana", "cuatro quesos");
    
    System.out.printf("Pizza 1. %s%n", pizza1);
    System.out.printf("Pizza 2. %s%n",  pizza2);
    System.out.printf("Pizza 3. %s%n", pizza3);
}
}