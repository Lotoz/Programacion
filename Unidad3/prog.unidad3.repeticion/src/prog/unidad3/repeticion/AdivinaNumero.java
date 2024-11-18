package prog.unidad3.repeticion;

import java.util.Scanner;
import java.util.Random;

public class AdivinaNumero {

	// Constantes
	  // Limite inferior del rango de números válidos
	  private static final int LIMITE_INFERIOR = 1;
	  // Limite superior
	  private static final int LIMITE_SUPERIOR = 100;
	  // Maximo número de intentos
	  private static final int MAX_INTENTOS = 10;

	  public static void main(String[] args) {
	    
	    // Para leer desde teclado
	    Scanner sc = new Scanner(System.in);
	    
	    // Mostramos cabecera de presentación
	    System.out.println("ADIVINA EL NÚMERO");
	    
	    // Opción introducida por el usuario para otra partida o terminar
	    // Da igual el valor al que se inicialice pero hay que dar alguno
	    char opcion = 'z';
	    
	    // Generador de números aleatorios
	    Random generador = new Random();
	    
	    // Mientras que el usuario elija seguir jugando
	    do {
	      // "Pensamos" el número a adivinar
	      // Al limite superior se le suma 1 porque nextInt devuelve un número
	      // entre los límites pero no incluye el limite superior, por lo que hay
	      // que sumar 1 para que pueda aparecer como número elegido
	      int objetivo = generador.nextInt(LIMITE_INFERIOR, LIMITE_SUPERIOR + 1);
	      
	      // Comenzamos a pedir números al usuario
	      // Número de intento (comenzamos por el primer intento)
	      int intento = 1;
	      // Se ha encontrado el número? Inicialmente no
	      boolean encontrado = false;
	      
	      // Mostramos mensaje de inicio de juego
	      System.out.println();
	      System.out.println("NUEVO JUEGO");
	      System.out.printf("He pensado un número entre %d y %d. Intenta adivinarlo%n", LIMITE_INFERIOR,
	          LIMITE_SUPERIOR);
	      
	      // Hasta que no se agoten los intentos o se encuentre el número (lo que pase antes)
	      do {
	        // Hasta que el usuario introduzca un número en rango
	        // Lo inicializamos a cualquier valor (enseguida lo vamos a sobreescribir)
	        int numero = 0;
	        do {
	          // Solicita el número al usuario
	          System.out.printf("Intento %d. Introduce un número entre %d y %d: ", intento,
	              LIMITE_INFERIOR, LIMITE_SUPERIOR);
	          numero = Integer.parseInt(sc.nextLine());
	          
	          // Si el número no es válido muestra un mensaje
	          if (numero < LIMITE_INFERIOR || numero > LIMITE_SUPERIOR) {
	            System.out.printf("El número %d no está en el rango %d-%d. Inténtalo de nuevo%n",
	                numero, LIMITE_INFERIOR, LIMITE_SUPERIOR);
	          }
	        } while (numero < LIMITE_INFERIOR || numero > LIMITE_SUPERIOR);
	        
	        // Una vez leido el número determinamos si ha acertado o damos una pista
	        if (numero == objetivo) {
	          // Hemos acertado. Mostramos mensaje
	          System.out.printf("Has acertado en %d intento%s. El número era %d%n", intento,
	              (intento > 1) ? "s" : "", objetivo);
	          // E indicamos que hemos terminado
	          encontrado = true;
	        } else {
	          // En caso de que no se haya encontrado
	          // Tenemos que decidir que mostrar la pista adecuada
	          System.out.printf("El número es %s que %d%n",
	              (numero > objetivo) ? "menor": "mayor", numero);          

	          // Sumamos un intento mas
	          intento++;
	        }
	      } while (intento <= MAX_INTENTOS && !encontrado);
	      
	      // La partida ha terminado. Preguntamos si queremos una nueva o no
	      System.out.print("¿Quieres jugar otra partida (s/n)?: ");
	      opcion = sc.nextLine().toLowerCase().charAt(0);
	    } while (opcion == 's');
	    
	    // Mensaje de despedida
	    System.out.println("Me he divertido mucho. Vuelve cuando quieras");
	  }

	}


