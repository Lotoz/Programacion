package ejercicio4;

import java.util.Random;

public class UtilidadesArrays {

  public static int[] generaArrayEnteroAleatorio(int longitud, int valorMinimo, int valorMaximo){
    if (longitud < 1 || valorMinimo > valorMaximo) {
      throw new IllegalArgumentException("Error");
    }
    int[] array = new int[longitud];
    Random elAzar = new Random();
    for (int i = 0; i < longitud; i++) {
      array[i] = elAzar.nextInt(valorMinimo,  valorMaximo);
      }
    return array;
  }
  
 public static int getMinimoArrayEntero(int[] array) {
  int  contador = 0;
   for (int numero : array ) {
       if (array[numero] <  numero) {
         contador++;
       }
     }
  return contador; 
 }

  public static int getMaximoArrayEntero(int[] array) {
    int  contador = 0;
    for (int numero : array ) {
        if (array[numero] >  numero) {
          contador++;
        }
      }
   return contador; 
   }

   public static int enteroApareceEnArrayEntero(int[] array, int valor) {
     int  contador = 0;


      for (int numero : array) {
        if (array[numero] == valor) {
          contador++;
        }
      } 

    return contador;
   }

}
