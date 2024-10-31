package prog.unidad3.repeticion;

import java.util.Scanner;

public class TablaMultiplicarSimpleApp {

  public static void main(String[] args) { 
    
    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
    System.out.println("    Mayor o Menor?        ");
    System.out.println("        V.1.0            ");
    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-="); 
    
    Scanner sc = new Scanner(System.in);
    System.out.print("¿De qué número entero quieres mostrar su tabla de multiplicar? ");
    int numeroTabla = Integer.parseInt(sc.nextLine());

    System.out.printf("Tabla del %d%n", numeroTabla);
    
    for (int i = 1; i <= numeroTabla; i++) {
      System.out.printf("%d X %d = %d%n", numeroTabla, i, (numeroTabla * i));
    }
  }
}

