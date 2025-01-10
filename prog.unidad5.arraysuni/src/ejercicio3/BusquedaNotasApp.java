package ejercicio3;

import java.util.Random;
import java.util.Scanner;

public class BusquedaNotasApp {

 public static void main (String[] args) {
   
   Scanner scan = new Scanner(System.in);
   
   int[] array = new int[30];

   Random elAzar = new Random();

   for (int i = 0; i < array.length; i++) {
     array[i] = elAzar.nextInt(0, 10);
   }
 }
 }