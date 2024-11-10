package prog.unidad03.combinado;

import java.util.Scanner;

public class ParImparFibonacciApp {

  public static void main(String[] args) {
    
    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
    System.out.println("    Ejercicio Combinado  ");
    System.out.println("      V.SolucionProfe    ");
    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-="); 
    
    //Luego de insertar un encabezado debemos pedir los numeros por pantalla.
    
    //hacer comentario de lo que deberemos hacer.
    
    //Solicita un numero sin lazar excepcion si no es correcto
    
    //Solicita el numero.
    
    Scanner scan = new Scanner(System.in);
 
    //Ahora vamos a solicitar un try.
    
    try {
      System.out.print("Introduce un número entero: ");
      int numero = Integer.parseInt(scan.nextLine());
      
      //Determina si el numero es par o impar
      if (numero % 2 == 0) {
        System.out.printf("Es un numero par.%n");  
      } else {
        System.out.printf("Es un numero impar.%n");
      }
      //Determina si el numero es positivo o negativo 
      //Si siempre es codigo de se hace y no se hace, es una condicion
      if (numero >= 0) {
        System.out.printf("Es un numero positivo.%n");  
      } else {
        System.out.printf("Es un numero negativo.%n");  
      }
      //Debemos considerar que es una condicion, si es fibonacci o no, dicho eso lo plateamos
      if (numero < 1) {
        System.out.printf("El número introducido no se corresponde con un elemento de la\r\n"
            + "sucesión de Fibonacci");
      } else { 
        if (numero == 1) {
          System.out.printf("El número introducido corresponde con un 0 de la sucesión de "
              + "Fibonacci.%n"); 
        } else if (numero == 2) {
          System.out.printf("El número introducido corresponde con un 1 de la sucesión de "
              + "Fibonacci.%n"); 
        } else {
          //Calcula la secuencia de Fibonacci hasta el numero
          int primero = 1;
          int segundo = 0;
          int fibonacci = primero + segundo;
          for (int x = 3; x <=numero; x++) {
            primero = segundo;
            segundo = fibonacci;
            fibonacci = primero + segundo;   
          } //Imprimimos fuera para que solo salga uno y no toda la cadena.
          //En la solucion suya el pone el resultado aqui
          System.out.printf("El número introducido corresponde con un %d de la sucesión de "
                + "Fibonacci.%n", fibonacci);
        }
      }
    } catch (NumberFormatException e) {
      System.out.print("Entrada no valida. Debe introducir un número entero.");
    }    
  }
}
