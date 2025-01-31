package ejercicio1;

import java.util.Arrays;
import java.util.Scanner;

public class Array8App {

  //constante
private static final int TAM_ARRAY =8;
  
 public static void main (String[] args) {
   
   //Creamos un Scanner para leer teclado
   Scanner scan = new Scanner(System.in);
   
   //Creamos el array
   double [] numeros = new double[TAM_ARRAY];
   //Pedimos datos
   System.out.printf("Operaciones varias sobre un array de 8 elementos.%n");
   System.out.printf("A continuacion se van a solicitar 8 numeros reales:%n");
   
   //Usamos for clasico
   for(int i = 0; i < numeros.length ; i++) {
   System.out.printf("Introduce el numero %d: %n", i+1);
   numeros[i] = scan.nextDouble();
   }
   //Resultados
   
   System.out.printf("La suma de todos los elementos vale %f%n", sumaTotal(numeros));
   System.out.printf("La suma de los elementos mayores de 36 vale %f%n", sumaMayor36(numeros));
   System.out.printf("La cantidad de elementos mayores a 50 es de  %d%n", sumaMayor50(numeros));
   System.out.printf("La media de los %d elementos comprendidos entre 10 y 30 vale %f%n", contadorMediaEntre10Y30(numeros),calculaMediaEntre10Y30(numeros));
   System.out.printf("Fin del programa.");
   
   
 }
 //Hacemos la suma
 private static double  sumaTotal(double[] numeros) {
   double suma = 0;
   for (double numero: numeros) {
     suma += numero;
   }
 return suma;
}
 //Suma mayor 36
 private static double sumaMayor36(double [] numeros) {
   double suma = 0;
   for (double numero: numeros) {
     if (numero > 36) {
     suma += numero;
     return suma;
   }
   } 
   return 0;
 }
 
 //Suma mayor 50
 private static int sumaMayor50(double [] numeros) {
   int contador = 0;
   for (double numero: numeros) {
     if (numero > 50) {
     contador ++;
     return contador;
   }
   } 
   return 0;
 }
 
 //Suma media entre 10 y 30
 private static double calculaMediaEntre10Y30(double [] numeros) {
   int contador = contadorMediaEntre10Y30(numeros);
   double suma = 0;
   for (double numero: numeros) {
     if (numero >= 10 && numero <= 30) {
       suma += numero;
       return suma / contador;
     } 
   }   
   return 0;
 }
 
 private static int contadorMediaEntre10Y30(double [] numeros){
   int contador = 0;
   for (double numero: numeros) {
     if (numero >= 10 && numero <= 30) {
     contador ++;
     return contador;
   }
   } 
   return 0;
 }
}
 




