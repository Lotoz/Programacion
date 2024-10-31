import java.util.Locale;
import java.util.Scanner;
public class r01e08 {
  public static void main(String[] args) {
  
  //ingresamos un scanner para que el usuario anexe las cifras que desea calcular
  Scanner numero1 = new Scanner(System.in); 
  System.out.printf("Insertar largo");
 
  //agregamos la variable del numero que representa el largo
  double valor1 = Integer.parseInt(numero1.nextLine());;
  
  //agregamos ahora lo mismo, pero en base de la altura
 Scanner numero2 = new Scanner(System.in); 
  System.out.printf("Insertar altura");
  double valor2 = Integer.parseInt(numero2.nextLine());;
      
//insertamos el calculo
  double area = valor1 * valor2;
  
 //sacamos la salida del resultado
  
  System.out.printf(Locale.US,"El area del rectangulo es %f", area);
  
  }
}
