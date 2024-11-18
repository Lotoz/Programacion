package prog.unidad03.repeticion;

import java.util.Scanner;

public class TablaMultiplicarSimpleApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    // Cabecera
    System.out.println("TABLA DE MULTIPLICAR DE.....");

    // Solicita el número 
    System.out.print("¿De qué número entero quieres mostrar su tabla de multiplicar?: ");
    int tablaDel = Integer.parseInt(sc.nextLine());
    
    // Imprime la cabecera de la tabla
    System.out.printf("Tabla del %d%n", tablaDel);
    // Para cada número de 1 al 10
    for (int i = 1; i <= 10; i++) {
      System.out.printf("%d X %d = %d%n", tablaDel, i, (tablaDel * i));
    }
  }

}
