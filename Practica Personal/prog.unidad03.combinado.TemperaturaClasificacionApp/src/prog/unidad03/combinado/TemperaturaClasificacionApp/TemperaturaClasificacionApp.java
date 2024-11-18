package prog.unidad03.combinado.TemperaturaClasificacionApp;

import java.util.Locale;
import java.util.Scanner;

public class TemperaturaClasificacionApp {

	public static void main(String[] args) { 
		
		boolean salida = false;
		do {
			try {
				Scanner sc = new Scanner(System.in);
				
				System.out.println("Introduce la temperatura:");
				double temperatura = Double.parseDouble(sc.nextLine());

				if (temperatura < 0) {
					System.out.printf("La temperatura es fria.%n");
				} else if (temperatura < 15) {
					System.out.printf("La temperatura es fresca.%n");
				} else if (temperatura < 25) {
					System.out.printf("Es templado.%n");
				} else {
					System.out.printf("Hace calo'.%n");
				}
				
				double fahrenheit = temperatura * 59 + 32;
				System.out.printf(Locale.US,"La temperatura introducida es %f y en fahrenheit es %f.%n", temperatura, fahrenheit);
				
				salida = true;
			} catch (NumberFormatException e) {
				System.out.printf("Error.%n");
				
			} 
		} while (!salida);
	} 
}
