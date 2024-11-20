package prog.unidad04.atributos;

import java.util.Scanner;

public class PruebaLavadora {

	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		//Mostramos la cabecera
		
		System.out.println("⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜");
		System.out.println("⁜ PROGRAMA DE MANEJO DE LAVADORAS ⁜");
		System.out.println(" ⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜");
		
		boolean error1 = false;
		do {
		try {
			System.out.printf("Introduzca la cantidad de lavadoras a crear (1 o 10):%n");
			int lavadoras = Integer.parseInt(sc.nextLine());
			//Ponemos una condicion para parchear errores
			if (lavadoras < 0) {
				System.out.println("Introduce un valor positivo");
			} else if (lavadoras == 0) {
				System.out.println("Que haces? Digo, has decidido crear cero lavadoras.");
			} else if (lavadoras > 0 && lavadoras < 10) {
			//Abrimos el ciclo de repeticion
			for (int i= 1; i <= lavadoras; i++) {
				//Creamos el objeto lavadora
				Lavadora lavadora = new Lavadora();
				
				//Creamos un boolean para pedir replicacion de datos en caso de
				//errores de usuario
				boolean salida = false;
				//Empezamos a pedir los datos de la lavadora
				do {
					//Pedimos el precio de la lavadora
					try {
						System.out.printf("Introduce el precio base de la lavadora:%n");
						lavadora.precio= Double.parseDouble(sc.nextLine());
						salida = true;
					} catch (NumberFormatException e) {
						System.out.printf("Introduce un valor valido.%n");
					}
					
				} while (!salida);
				do {
					
					//Pedimos que se seleccione un color.
					System.out.printf("Elige un color para la lavadora:%n");
					System.out.printf("1.Blanco.%n");
					System.out.printf("2.Negro.%n");
					System.out.printf("3.Rojo.%n");
					System.out.printf("4.Azul.%n");
					System.out.printf("5.Gris.%n");
					char color = sc.nextLine().charAt(0);
					//Probar a switch
					if (color == '1') {
						lavadora.color = "Blanco";
						salida = true;
					} else if (color == '2') {
						lavadora.color = "Negro";
						salida = true;
					} else if (color == '3') {
						lavadora.color = "Rojo";
						salida = true;
					} else if (color == '4') {
						lavadora.color = "Azul";
						salida = true;
					} else if (color == '5') {
						lavadora.color = "Gris";
						salida = true;
					} else {
						System.out.printf("Caracter no valido.%n");
					} 
				} while (!salida);
				//Hacemos ahora la calificacion energetica es muy parecido a color
				do {
					
					//Pedimos que se seleccione un color.
					System.out.printf("Elige la calificación energética de la lavadora: %n");
					System.out.printf("1.A.%n");
					System.out.printf("2.B.%n");
					System.out.printf("3.C.%n");
					System.out.printf("4.D.%n");
					System.out.printf("5.E.%n");
					System.out.printf("6.F.%n");
					char calificacionEnergetica = sc.nextLine().charAt(0);
					if (calificacionEnergetica == '1') {
						lavadora.calificacionEnergetica = "A";
						salida = true;
					} else if (calificacionEnergetica== '2') {
						lavadora.calificacionEnergetica = "B";
						salida = true;
					} else if (calificacionEnergetica == '3') {
						lavadora.calificacionEnergetica = "C";
						salida = true;
					} else if (calificacionEnergetica == '4') {
						lavadora.calificacionEnergetica = "D";
						salida = true;
					} else if (calificacionEnergetica == '5') {
						lavadora.calificacionEnergetica = "E";
						salida = true;
					}  else if (calificacionEnergetica == '6') {
						lavadora.calificacionEnergetica = "F";
						salida = true;
					} else {
						System.out.printf("Caracter no valido.%n");
					} 
				} while (!salida);
				//Hacemos ahora el peso
				do {
					//Pedimos el peso de la lavadora
					try {
						System.out.printf("Introduce el peso de la lavadora (en kilogramos. "
								+ "Debe ser mayor que cero):%n");
						double peso = Double.parseDouble(sc.nextLine());
						if (peso > 0) {
						peso = lavadora.pesoLavadora;
						salida = true;
						} else if (peso < 0) {
						System.out.printf("Introduce un valor valido.%n");
						}
					} catch (NumberFormatException e) {
						System.out.printf("Introduce un valor valido.%n");
					}	
				} while (!salida);
				//Hacemos la carga
				do {
					//Pedimos la carga de la lavadora
					try {
						System.out.printf("Introduce la carga de la lavadora (en kilogramos. "
								+ "Debe ser mayor que cero):%n");
						double carga = Double.parseDouble(sc.nextLine());
						if (carga > 0) {
						carga = lavadora.carga;
						salida = true;
						} else if (carga < 0) {
						System.out.printf("Introduce un valor valido.%n");
						}
					} catch (NumberFormatException e) {
						System.out.printf("Introduce un valor valido.%n");
					}	
				} while (!salida);
				System.out.printf("Datos de la lavadora %d%n", i);
				System.out.printf("Precio: %f%n", lavadora.precio);
				System.out.printf("Color: %s%n", lavadora.color);
				System.out.printf("Calificacion Energetica: %s%n", lavadora.calificacionEnergetica);
				System.out.printf("Peso: %f%n", lavadora.pesoLavadora);
				System.out.printf("Carga Maxima: %f%n", lavadora.carga);
			}
			}
			error1 = true;
		} catch (NumberFormatException e) {
			System.out.printf("Introduce un valor valido.%n");
		}
	} while (!error1);
	}
}
