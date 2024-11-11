package prog.unidad04.atributos;

import java.util.Scanner;

public class PruebaPizza {
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		//Mostramos la cabecera
		
		System.out.println(" ⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜");
		System.out.println("⁜ PROGRAMA DE MANEJO DE PIZZAS ⁜");
		System.out.println(" ⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜");
		
		//Solicitamos la cantidad de pizzas a crear
		System.out.println("Introduzca la cantidad de pizzas a crear (1 o mas):");
		int pizzas = Integer.parseInt(sc.nextLine());
		
		//Para cada pizza
		for (int i= 1; i <= pizzas; i++) {
			//Creamos la pizza
			Pizza pizza = new Pizza();
			Pizza.pizzasCreates ++;
			
			//Pedimos los datos de la pizza
			
			//Aqui pedimos el size
			System.out.printf("Introduce el tamaño de la pizza %d (mediana / familiar)", i);
			pizza.size = sc.nextLine();
			
			//Aqui pedimos el tipo
			System.out.printf("Introduce el tipo de la pizza %d (margarita / cuatro quesos / funghi)", i);
			pizza.type = sc.nextLine();
			
			//Aqui decimos si servir o no
			System.out.printf("¿Servir la pizza? (s/n)");
			char estadoPizza = sc.nextLine().charAt(0);
			if (estadoPizza == 's') {
				pizza.state = "servida";
				Pizza.pizzasReady ++;
			}else {
				pizza.state = "pedida";
			}
			//Imprimimos los datos de la pizza
			System.out.printf("Datos de la pizza %d%n", i);
			System.out.printf("Tamaño: %s%n", pizza.size);
			System.out.printf("Tipo: %s%n", pizza.type);
			System.out.printf("Estado: %s%n", pizza.state);
			System.out.printf("Creadas: %d%n", pizza.pizzasCreates);
			System.out.printf("Pedidas: %d%n", pizza.pizzasReady);
						
		}
	}
}

