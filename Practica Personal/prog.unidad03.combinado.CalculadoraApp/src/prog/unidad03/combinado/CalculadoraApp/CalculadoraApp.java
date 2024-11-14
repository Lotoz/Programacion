package prog.unidad03.combinado.CalculadoraApp;

import java.util.Scanner;

public class CalculadoraApp {

	public static void main(String[] args) {
	 
	  
	        Scanner sc;
			int option;
			try {
				sc = new Scanner(System.in);
				System.out.println("Cual opcion deseas usar?: ");
				System.out.println("1.Sumar");
				System.out.println("2.Restar");
				System.out.println("3.Multiplicar");
				System.out.println("4.Dividir");
				System.out.println("5.Mayor o menor");
				System.out.println("6.Es primo o no");
				System.out.println("7.Par o impar");
				System.out.println("8.Posicion en fibonacci");
				System.out.println("9.Salir");
				option = Integer.parseInt(sc.nextLine());
				
				 switch (option) {
			      
			        case 1 : {
			          System.out.println("Primer numero:");
			          double numero1 = Double.parseDouble(sc.nextLine());
			          
			          System.out.println("Segundo numero:");
			          double numero2 = Double.parseDouble(sc.nextLine());
			          
			         double suma = numero1 + numero2;
			         
			         System.out.printf("El resultado es:%f", suma);
			        	
			          break;
			        }
			        case 2 : {
			        	System.out.println("Primer numero:");
				          double numero1 = Double.parseDouble(sc.nextLine());
				          
				          System.out.println("Segundo numero:");
				          double numero2 = Double.parseDouble(sc.nextLine());
				          
				         double resta = numero1 + numero2;
				         
				         System.out.printf("El resultado es:%f", resta);
			        	
			          break;
			        }
			        case 3 : {
			        	System.out.println("Primer numero:");
				          double numero1 = Double.parseDouble(sc.nextLine());
				          
				          System.out.println("Segundo numero:");
				          double numero2 = Double.parseDouble(sc.nextLine());
				          
				         double multiplicar = numero1 * numero2;
				         
				         System.out.printf("El resultado es:%f", multiplicar);
			         
			          break;
			          
			        }
			        case 4 : {
			        	System.out.println("Primer numero:");
				          double numero1 = Double.parseDouble(sc.nextLine());
				          
				          System.out.println("Segundo numero:");
				          double numero2 = Double.parseDouble(sc.nextLine());
				          
				         double division = numero1 / numero2;
				         
				         System.out.printf("El resultado es:%f", division);
			         
			          break;
			        
			        }
			        case 5 : {
			        	double numero1;
						double numero2;
						try {
							System.out.println("Primer numero:");
							numero1 = Double.parseDouble(sc.nextLine());
							  
							System.out.println("Segundo numero:");
							numero2 = Double.parseDouble(sc.nextLine());
							 if (numero1 > numero2) {
						        	
						        	System.out.printf("El mayor es %f", numero1);
						        	
						        }else if(numero2 < numero1) {
						        	
						        	System.out.printf("El mayor es %f", numero2);
						        	
						        }else {
						        	
						        	System.out.printf("Son iguales.");
						 	
						        }
						} catch (NumberFormatException e) {
							System.out.printf("No valido.");
						}
				       
			          break;
			  
			        }
			        case 6 : {
			        	
			        	int numero;
						try {
							System.out.print("Introduce un número entero mayor que 1 para ver si es primo o no:");
							numero = Integer.parseInt(sc.nextLine());
							  if (numero > 0) {
					              int multiplo = 0;
					              
					            for ( int i = multiplo ; i <= numero; i++ ) {
					              if ( numero <= i) {
					                multiplo++; 
					              }else if (numero %i == 0) {
					                
					              System.out.printf("El numero %d es primo ", numero);  
					              }else if (numero % i != 0 ) {
					                System.out.printf("El numero %d no es primo ", numero);
					              } else {
					                System.out.printf("Introduce un valor valido");
					              }
					            }
					           }
						} catch (NumberFormatException a) {
							System.out.println("Introduce un número entero mayor que 1.");
						}
			            
			          
			          break;
			        }
			        case 7 : {
			        	System.out.println("Introduce un numero entero: ");
			            double numero = Double.parseDouble(sc.nextLine());
			            
			            String parImpar = (numero % 2 == 0) ? "par" : "impar";
			            
			            System.out.printf("El numero %f es %s", numero, parImpar);
			          break;
			  
			        }
			        case 8 : {
			  
			        	try {
			        	      System.out.print("Introduce un número entero: ");
			        	      int numero = Integer.parseInt(sc.nextLine());
			        	      
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
			          break;
			  
			        }
			        case 9 : {
			        System.out.println("Fin del programa.");
			          break;
			        }
			      
			    
			}
			} catch (NumberFormatException e) {
				System.out.println("Elige una opcion valida");
			}
		    
	     
}
}
