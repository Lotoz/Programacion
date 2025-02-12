package prog.unidad06.consola.ejercicio03;

import java.util.Random;

import prog.unidad06.consola.ejercicio03.ImpresorTablaReal;

public class ImpresorTablaRealApp {

  public static void main(String[] args) {
    imprimirCabecera("Imprime por pantalla un conjunto de numeros");
    Double[][] tabla = new Double[3][3]; // Crear un array 3x3
    llenarTabla(tabla); // Llenar el array con números decimales
    // Llamo al método imprimeTabla de la clase ImpresorTablaReal
    ImpresorTablaReal.imprimeTabla(tabla);
  }

  private static void llenarTabla(Double[][] tabla) {
    Random random = new Random();
    for (int i = 0; i < tabla.length; i++) {
      for (int j = 0; j < tabla[i].length; j++) {
        // Genera un numero decimal entre 1 y 200
        double numeroDecimal = 1 + (200 - 1) * random.nextDouble();
        tabla[i][j] = numeroDecimal;//Metemos el numero
      }
    }
  }

  // Imprimir cabecera
  private static void imprimirCabecera(String msg) {
    System.out.println();
    System.out.println(msg.toUpperCase());
    System.out.println("-".repeat(10));
    System.out.println();
  }
}
