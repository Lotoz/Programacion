package prog.unidad3.repeticion;

import java.util.Scanner;

public class TrianguloNumerico {

public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Introduce la altura del triánguilo (entero mayor que cero) : ");
    int numero = Integer.parseInt(sc.nextLine());
   
    // Debemos insertar un if para insertar una condicion de altura
    
    if (numero > 0) {
      
      // Para cada piso del triángulo definimos
      
      for (int piso = 1; piso <= numero; piso++) {
        
        // Primero imprimimos espacios
        // Tantos como la altura menos el piso
        
        for (int j = 0; j < numero - piso; j++) {
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
        
        for (int j = 0; j < numero - piso; j++) {
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