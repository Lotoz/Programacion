package prog.unidad03.repeticion;

import java.util.Scanner;
import java.util.Locale;

public class MediaPositivosApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    // Mostramos la cabecera
    System.out.println("CÁLCULO DE LA MEDIA");

    // Declaramos las variables
    // Numero que se lee desde teclado
    double numero;
    // Suma de los números leidos hasta el momento
    double suma = 0;
    // Contador de los números leídos
    int contador = 0;
    
    do {
      System.out.print("Introduce un número real positivo o cero (negativo para terminar): ");
      numero = Double.parseDouble(sc.nextLine());
      if (numero >= 0) {
        suma += numero;
        contador++;
      }
    } while (numero >= 0);
    
    // Si se ha introducido al menos algún número
    if (contador > 0) {
      // Se calcula la media y se muestra el resultado
      System.out.printf(Locale.US, "La media de los %d números introducidos vale %f%n", contador, (suma / contador));
    } else {
      System.out.println("No se ha introducido ningún número por lo que la media es cero");
    }

  }

}
