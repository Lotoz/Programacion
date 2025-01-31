package ejercicio3;

import java.util.Random;
import java.util.Scanner;

public class BusquedaNotasApp {

 public static void main (String[] args) {
   
   Scanner scan = new Scanner(System.in);
   
   int[] notas = new int[30];

   Random elAzar = new Random();
   
   //Se genera array random.
   for (int i = 0; i < notas.length ; i++) {
     notas[i] = elAzar.nextInt(0, 10);
   }
   
     System.out.println("BÚSQUEDA DE CALIFICACIONES");
   
       int  busqueda = 0;
        //Contador de notas.
       int contador = 0;
       //Array para contar las notas

     
            do {
              try {
              System.out.println("Introduzca la calificación a buscar (0 a 10, negativa para terminar): ");
              busqueda = Integer.parseInt(scan.nextLine());
              contador = 0;
              for (int nota : notas) {
                  if (notas[nota] == busqueda) {
                    contador++;
                  }
                }
              if (busqueda <= 10 && busqueda >= 0) {
                System.out.printf("Con la calificacion %d se han encontrado %d alumnos.%n", busqueda, contador);
                contador = 0;
              } else if ( busqueda > 10) {
                System.out.printf("Ingrese un numero comprendido entre 0 y 10.%n");
              } 
            } catch (NumberFormatException e) {
              System.out.printf("Ingresa un numero, porfavor.%n");
            } 
            } while (busqueda >= 0);
            System.out.printf("Fin.");

       }
 }
 
 