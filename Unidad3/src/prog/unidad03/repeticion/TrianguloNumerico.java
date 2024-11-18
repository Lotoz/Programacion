package prog.unidad03.repeticion;

import java.util.Scanner;

public class TrianguloNumerico {

  public static void main(String[] args) {
    // Para solicitar por teclado
    Scanner sc = new Scanner(System.in);
    
    // Cabecera
    System.out.println("TRIÁNGULO DE NÚMEROS");
    
    // Solicita la altura
    System.out.print("Introduce la altura del triángulo (entero mayor que cero): ");
    int altura = Integer.parseInt(sc.nextLine());
    
    // Si la altura es válida
    if (altura > 0) {
      // Para cada piso del triángulo
      for (int piso = 1; piso <= altura; piso++) {
        // Primero imprimimos espacios
        // Tantos como la altura menos el piso
        for (int j = 0; j < altura - piso; j++) {
          System.out.print(" ");
        }
        // Después imprimimos la secuencia hacia arriba (incluyendo el número central del piso)
        for (int j = 1; j <= piso; j++) {
          System.out.print(j);
        }
        // Después la secuencia inversa (desde el anterior al piso hasta 1)
        for (int j = piso - 1; j > 0; j--) {
          System.out.print(j);
        }
        // Por último otra vez los espacios
        for (int j = 0; j < altura - piso; j++) {
          System.out.print(" ");
        }
        
        // Después de cada piso un salto de linea
        System.out.println();
      }
    } else {
      // Muestra error
      System.out.println("La altura especificada no es válida");
    }

  }

}
