package prog.unidad03.repeticion;

public class CuadriculaDiezPorDiezApp {

  public static final int COLUMNAS = 10;
  public static final int FILAS = 10;

  public static void main(String[] args) {
    
    // Cabecera
    System.out.println("NÚMEROS DEL 1 AL 100");

    /* Para cada fila (las comenzamos a numerar por cero porque el número
     * de inicio de cada fila debe ser la decena correspondiente y la primera
     * decena es cero
     */
    for (int fila = 0; fila < FILAS; fila++) {
      // Imprime los números de la fila usando otro bucle para los mismos
      for (int i = fila * COLUMNAS + 1; i <= ((fila + 1) * COLUMNAS); i++) {
        System.out.printf("%d\t", i);
      }
      // Imprime una nueva línea para separar las filas
      System.out.println();
    }
  }

}
