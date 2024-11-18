package prog.unidad03.examen;

import java.util.Locale;
import java.util.Scanner;

public class SuperEstadisticaApp {

private static final int RANGO_MINIMO = -11;
private static final int RANGO_MAXIMO = 20;
public static void main(String[] args) { 

	//Esto es un cabezal estetico.
    System.out.println("EXAMEN DE Zamira Grippi. CALCULO DE MEDIA.");
    System.out.println("--------------------------------");
    //Scan para leer desde el teclado
    Scanner scan = new Scanner(System.in);
    //Exponemos fuera de los bucles las variables para luego poder usarlas
    int numeroEntero = 0;
    int cantidadNumeroMedia = 0;
    int suma = 0;
    double media = 0;
	boolean salida = false;
    do {
	try {
		do {
		  //Le pedimos los datos al usuario
		  System.out.println("Introduce un numero entero (0 para terminar): ");
		  numeroEntero = Integer.parseInt(scan.nextLine());
		
		  //Hacemos las condiciones de los mensajes a mostrar
		  //Se ha el numero par, impar, negativo o positivo
		  //Condicion de numero par
		  if (numeroEntero % 2 == 0 ) {
		  //Condicion si es positivo o negativo
		  if (numeroEntero > 0) {
			  
		    System.out.printf("El numero %d es positivo y par%n", numeroEntero);
		    
		  }else if(numeroEntero < 0){
			System.out.printf("El numero %d es negativo y par%n", numeroEntero); 
		  }
		  //Condicion numero impar
		  }else if (numeroEntero % 2 != 0) {
		  //hacemos un bucle para poder contar cuantos numeros cumpliran la condicion de la media.
		    do {
		    //condicion si es negativo o positivo
		        if (numeroEntero > 0 ) {
		          System.out.printf("El numero %d es positivo y impar%n", numeroEntero);
		         //ponemos la condicion de si entra en el calculo de la media
		         //condicion si entra en la media o no
		        if ( numeroEntero >= RANGO_MINIMO || numeroEntero < RANGO_MAXIMO || numeroEntero == -1 ||numeroEntero == 3) {
		         System.out.printf("El numero %d entra en el calculo%n", numeroEntero);
		         cantidadNumeroMedia++;
		    //suma = numeroEntero + numeroEntero;
		        }
		        }else if (numeroEntero < 0) {
		    System.out.printf("El numero %d es negativo y impar%n", numeroEntero);
		    //condicion de si entra en el calculo de la media
			    if ( numeroEntero >= RANGO_MINIMO || numeroEntero < RANGO_MAXIMO || numeroEntero == -1 ||numeroEntero == 3) {
		    System.out.printf("El numero %d entra en el calculo%n", numeroEntero);
		    //suma = numeroEntero + numeroEntero;
		    cantidadNumeroMedia++;

		        }
		        }

		} while (numeroEntero == 0);
		 //hacemos la media de los numeros que cumplen la condicion divido su cantidad
		 //media = suma % cantidadNumeroMedia;  

		  }
		} while (numeroEntero != 0);
		//System.out.printf(Locale.US,"La media de los números que cumplen la condición vale: 0"); 
		System.out.printf("La cantidad de números que cumplen la condición es"
				+ " de %d%n", cantidadNumeroMedia);
		salida = true;
	} catch (NumberFormatException e) {
		System.out.printf("El dato introducido no es un número entero válido.%n"); 
	} 
    } while (!salida);
 
  }
}

