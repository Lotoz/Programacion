package prog.unidad04.actividad404.ejercicio03;

import prog.unidad04.actividad404.ejercicio01.TablaMultiplicar;

/**
 * Programa que muestra por consola las tablas de multiplicar
 * de los números del 1 al 10
 */
public class TablasMultiplicarApp {

  public static void main(String[] args) {
    // Para cada número del 1 al 10
    for (int i = 1; i <= 10; i++) {
      // Imprime la cabecera de la tabla
      System.out.println("TABLA DEL " + i);
      // Crea el objeto TablaMultiplicar correspondiente
      TablaMultiplicar tabla = new TablaMultiplicar(i);
      // Y lo imprime
      tabla.imprimeTabla();
    }
  }

}
