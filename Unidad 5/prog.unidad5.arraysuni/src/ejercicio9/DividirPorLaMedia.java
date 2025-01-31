package ejercicio9;

import java.util.Random;

public class DividirPorLaMedia {
    private String numero;
  public static void main (String[] args) {
    
  int[] notas = new int[50];

  Random elAzar = new Random();
  
  //Se genera array random.
  for (int i = 0; i < notas.length ; i++) {
    notas[i] = elAzar.nextInt(0, 10);
  }
}
}
