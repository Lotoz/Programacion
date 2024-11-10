package prog.unidad03.combinado.CuadradoFactorialApp;

import java.util.Scanner;

public class CuadradoFactorialApp {

	public static void main(String[] args) {
	    
	System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
	System.out.println("    CuadradoFactorialApp ");
	System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-="); 
	    
	//Creamos un try para poder emitir el mensaje de error.
	Scanner scan = new Scanner(System.in);
		
	try {
		System.out.print("Introduce un número entero: ");
		int numero = Integer.parseInt(scan.nextLine());
//Ahora haremos el if para definir si el numero es positivo, negativo o cero.
		if (numero == 0) {
			System.out.printf("El numero introducido es cero.%n");
	//Sabemos que a logica el factorial de cero sera 1
			System.out.printf("Su factorial es 1");
		}else if (numero < 0) {
			System.out.printf("El numero introducido es negativo.%n");
//Sabemos que si el numero es negativo, no debera tener factorial por ende imprimimos
			System.out.printf("El número introducido no tiene un factorial definido.");
		}else if (numero >= 0){
			System.out.printf("El numero introducido es positivo.%n");
		//Procedemos  a calcular su cuadrado
		int cuadrado = numero * numero;
		//Imprimimos este resultado
		System.out.printf("El cuadrado del numero es %d.%n", cuadrado);
		//Calculamos su factorial
		//Creamos la variable factorial para luego imprimirla.
		int factorial = 1;
		for (int i = 1; i <= numero; i++ ) {
		//Porque esto? porque aqui le estamos diciendo que multiplique la amplificacion de i, y 
			//hemos puesto que el limite sea numero
			factorial *= i;
		}
		System.out.printf("Su factorial es %d", factorial);
		}
	}catch (NumberFormatException e) {
		System.out.print("Entrada no valida. Debe introducir un número entero.");
		}
	}
}
//unico problema, no es capaz de calcular numeros mayores a tres cifras,Seguro usando long o una variable mas grande podria
//Lo revisare luego