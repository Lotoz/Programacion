import java.util.Locale;
import java.util.Scanner;

public class r01e09 {
public static void main(String[] args) {
  
  //Ingresamos el scanner para que se puedan ingresar los datos
  Scanner numero1 = new Scanner(System.in); 
  System.out.printf("Insertar Lado");
  
  //agregamos el numero
  double valor1 = Double.parseDouble(numero1.nextLine());;
  
  //lo repetimos con altura
  Scanner numero2 = new Scanner (System.in);
  System.out.printf("Insertar Altura");
  double valor2 = Double.parseDouble(numero2.nextLine());
  
  
  //Agregamos la ecucacion
  double area =  valor1 * valor2  / 2;
  System.out.printf(Locale.US, "El area es %f", area);
  
  }
}