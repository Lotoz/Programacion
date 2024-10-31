package prog.unidad3.seleccion;

import java.util.Locale;
import java.util.Scanner;

public class CalculaImporteApp {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Introduce el valor de la compra:");
    double compra = Double.parseDouble(sc.nextLine());
    
    if ( compra >= 100) {
      
      double compraConDescuento = compra*0.2; 
      double descuentoAplicado =  compra - compraConDescuento;
      System.out.printf(Locale.US,"Su compra de %f, es valida, se le aplica un descuento de: %f%n.",compra, compraConDescuento);
      System.out.printf(Locale.US,"Por ende su precio final es: %f%n.",descuentoAplicado );
      
    } else if ( compra < 100) {
      
      System.out.printf(Locale.US,"Su compra no es valida para el descuento, su importe sigue siendo %f.",compra);
      
    } else {
      
      System.out.print("Has introducido un valor invalido.");
    }
  
  }
}