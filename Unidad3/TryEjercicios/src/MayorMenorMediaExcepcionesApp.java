import java.util.Locale;
import java.util.Scanner;

public class MayorMenorMediaExcepcionesApp {

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
	    // Cabecera
	    System.out.println("MAYOR, MENOR Y MEDIA (A PRUEBA DE USUARIOS MALICIOSOS)");

	    boolean valorCorrecto = false;
	    int numeros = 0;
	    
	    // Mientras el valor leido no sea correcto
	    do {
	      try {
	        // Solicita la cantidad de números a introducir
	        System.out.print("¿Cuántos números deseas introducir?: ");
	        numeros = Integer.parseInt(sc.nextLine());
	        // Si se llega aqui es que se ha podido leer el número correctamente
	        // Lo indicamos
	        valorCorrecto = true;
	      } catch (NumberFormatException e) {
	        // El número introducido no es correcto
	        // Muestra mensaje
	        System.out.println("El valor introducido no es un número entero correcto. Inténtelo de nuevo");
	      }
	    } while (!valorCorrecto);

	    // La cantidad debe ser al menos 1
	    if (numeros > 0) {
	      // Solicita el primer número
	      // Lo hacemos aparte porque hay que inicializar el minimo y el máximo a este valor
	      // Operacion similar a antes
	      valorCorrecto = false;
	      double numero = 0;
	      do {
	        try {
	          // Solicita el primer número
	          System.out.print("Introduce el número 1: ");
	          numero = Double.parseDouble(sc.nextLine());
	          // Si se llega aqui es que se ha podido leer el número correctamente
	          // Lo indicamos
	          valorCorrecto = true;
	        } catch (NumberFormatException e) {
	          // El número introducido no es correcto
	          // Muestra mensaje
	          System.out.println("El valor introducido no es un número real correcto. Inténtelo de nuevo");
	        }
	      } while (!valorCorrecto);

	      
	      // Inicializa el mayor, menor y suma
	      double mayor = numero;
	      double menor = numero;
	      double suma = numero;
	      
	      // Después leemos los siguients números
	      // Para tantos números como se haya especificado menos el primero
	      for (int i = 2; i <= numeros; i++) {
	        // Operacion similar a antes
	        valorCorrecto = false;
	        numero = 0;
	        do {
	          try {
	            // Solicita el numero i-esimo
	            System.out.printf("Introduce el número %d: ", i);
	            numero = Double.parseDouble(sc.nextLine());
	            // Si se llega aqui es que se ha podido leer el número correctamente
	            // Lo indicamos
	            valorCorrecto = true;
	          } catch (NumberFormatException e) {
	            // El número introducido no es correcto
	            // Muestra mensaje
	            System.out.println("El valor introducido no es un número real correcto. Inténtelo de nuevo");
	          }
	        } while (!valorCorrecto);
	        
	        // Si es mayor que el maximo actual
	        if (numero > mayor) {
	          // Ahora es el nuevo maximo
	          mayor = numero;
	        }
	        // Si es menor que el minimo actual
	        if (numero < menor) {
	          // Ahora es el nuevo minimo
	          menor = numero;
	        }
	        // En cualquier caso lo añade a la suma
	        suma += numero;
	      }
	      
	      // Muestra los resultados
	      System.out.printf(Locale.US, "El mayor de los números introducidos ha sido: %f%n", mayor);
	      System.out.printf(Locale.US, "El menor de los números introducidos ha sido: %f%n", menor);
	      System.out.printf(Locale.US, "La media de todos los números vale: %f%n", (suma / numeros));
	    } else {
	      // Muestra mensaje de error
	      System.out.println("La cantidad de números a introducir debe ser al menos uno");
	    }
	  }
}
