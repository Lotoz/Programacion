package ejercicio2;

import java.util.Random;

public class UtilidadesArrays {
  
  public static int[] generaArrayEnteroAleatorio(int longitud, int valorMinimo, int valorMaximo) throws IllegalArgumentException {
    
   //Creamos un array con la longitud dada por el usuario.
    int[] array = new int[longitud];
    
    //Iniciamos el random
    Random elAzar = new Random();
    
    //iniciamos un if para poder declarar si generar el array o marcar error
    if (valorMinimo >=  0 || valorMinimo < valorMaximo || longitud > 0  &&  valorMaximo !=  0) {
      for (int i = 0; i < array.length; i++) {
        array[i] = elAzar.nextInt(valorMinimo, valorMaximo);
      } 
    } else {
      throw new IllegalArgumentException();
    }
   
    return array;
  
  }
}
