package prog.unidad04.atributos;

import java.util.Scanner;

public class PruebaPersona {

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		//Mostramos la cabecera
		
		System.out.println("⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜");
		System.out.println("⁜ PROGRAMA DE MANEJO DE PERSONAS ⁜");
		System.out.println(" ⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜");
		
		System.out.printf("Introduzca la cantidad de personas a crear (1 o mas):%n");
		int personas = Integer.parseInt(sc.nextLine());
		
		//Creamos el bucle de repeticion
		for (int i= 1; i <= personas; i++) {
		//Solicitamos la cantidad de personas a crear
		
		//Ahora debemos crear a la persona, asi se guardaran sus datos.
		Persona persona = new Persona();
		
		//Luego de esto empezaremos a pedir los datos sobre la persona
		System.out.printf("Introduce el nombre de la persona:%n");
		persona.name = sc.nextLine();
		
		System.out.printf("Introduce la edad de la persona (debe ser mayor o igual a cero):%n");
		persona.age = Integer.parseInt(sc.nextLine());
		
		System.out.printf("Introduce el DNI de la persona (debe constar "
				+ "de 8 números y una letra):%n");
		persona.dni = sc.nextLine();
		
		//Iniciamos un bucle para intentar usar la opcion caracter no valido
		boolean salida = false;
		do {
			//En el caso del genero, al ser dos opciones usaremos charAt y opciones
			System.out.printf("Introduce el sexo de la persona (H = Hombre, M = Mujer):%n");
			char gender = sc.nextLine().charAt(0);
			if (gender == 'H') {
				persona.gender = "Hombre";
				salida = true;
			} else if (gender == 'M') {
				persona.gender = "Mujer";
				salida = true;
			} else {
				System.out.printf("Caracter no valido.%n");
			} 
		} while (!salida);
		//Pedimos el peso
		System.out.printf("Introduce el peso de la persona (en kilogramos. "
				+ "Debe ser mayor que cero):%n");
		persona.weight= Double.parseDouble(sc.nextLine());
		
		//Pedimos la altura
		System.out.printf("Introduce la altura de la persona (en metros. "
				+ "Debe ser mayor que cero):%n");
		persona.height= Double.parseDouble(sc.nextLine());
		
		//Imprimimos todo por pantalla
		System.out.printf("Datos de la persona %d%n", i);
		System.out.printf("Nombre: %s%n", persona.name);
		System.out.printf("Edad: %d%n", persona.age);
		System.out.printf("DNI: %s%n", persona.dni);
		System.out.printf("Sexo: %s%n", persona.gender);
		System.out.printf("Peso: %f%n", persona.weight);
		System.out.printf("Altura: %f%n", persona.height);
		}
		//Se podria intentar poner un try por si se introduce un dato mal,
		//Ya que en muchas lineas se pueden poner solo numeros y el programa sigue.
}
}