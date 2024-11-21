import java.util.Scanner;
import java.util.Random;

public class RuletaRusa {

  public static void main(String[] args) {
    
	System.out.println("Ruleta rusa.");
	System.out.println("-----------.");
	
	 // Generador de números aleatorios
	boolean error = false;
	
	do {
    try {
		Random generador = new Random();
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Quieres jugar? S/N");
		char opcion = sc.nextLine().toLowerCase().charAt(0);
		if (opcion == 'S') {
			//Usar el ramdon donde vaya del 1-6 y cuando, hacer un contador de intentos.
		}else {
			error = true;
		}
	} catch (Exception e) {
		
	}
	}while (!error);
  } 
}
