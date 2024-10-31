import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

public class numerosComplejos {
  
  public static void main(String[] args) { 

    
    Scanner scan = new Scanner(System.in);
    System.out.print("Introduce el number");
    double parteReal  = Double.parseDouble(scan.nextLine());
    System.out.print("Introduce el number imagination");
    double parteImaginaria  = Double.parseDouble(scan.nextLine());
    
    System.out.print("Introduce el number");
    double parteReal2  = Double.parseDouble(scan.nextLine());
    System.out.print("Introduce el number imagination");
    double parteImaginaria2  = Double.parseDouble(scan.nextLine());
    
   Complejo complejo1 = new Complejo(parteReal, parteImaginaria);
   Complejo complejo2 = new Complejo(parteReal2, parteImaginaria2);
   
   Complejo dividir =  complejo1.dividir(complejo2);   
   //String resultadoDividir = dividir.toString();
  
   Complejo multiplicar = complejo1.multiplicar(complejo2);
   //String resultadoMultiplicar = multiplicar.toString();
 
   Complejo restar = complejo1.restar(complejo2);
   //String resultadoRestar = restar.toString();
 
  Complejo sumar = complejo1.sumar(complejo2);
  //String resultadoSumar = sumar.toString();
   
   //System.out.printf(Locale.US, "El resultado de tu division es %s, %n el resultado de tu multiplicacion es %s, %n el resultado de tu resta es %s, %n el resultado de tu suma es %s", resultadoDividir, resultadoMultiplicar, resultadoRestar, resultadoSumar);
  System.out.printf(Locale.US, "El resultado de tu division es %s, %n el resultado de tu multiplicacion es %s, %n el resultado de tu resta es %s, %n el resultado de tu suma es %s", dividir, multiplicar, restar, sumar);
    
  }

}
