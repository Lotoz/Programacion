package prog.unidad06.consola.ejercicio03;

import java.util.Locale;
import java.util.Random;

/**
 * Impeime una tabla de numero reales y el numero de decimales y la imprime por
 * pantalla mostrando los numeros decimales especificado.
 */
public class ImpresorTablaReal {

  public static void imprimeTabla(Double[][] tabla) {
    // Imprime el array
    for (int i = 0; i < tabla.length; i++) {
      for (int j = 0; j < tabla[i].length; j++) {
        System.out.printf(Locale.US, "%7.2f", tabla[i][j]);
      }
      System.out.println();
    }
  }
}
