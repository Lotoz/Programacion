package prog.unidad03.excepciones;

import java.util.Scanner;

public class NumeroSeguroCansinoApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    // Mostramos cabecera
    System.out.println("INTRODUCCIÓN DE NÚMERO SEGURA CANSINA");

    // Bandera que nos indica si el número introducido ya es válido o no
    // Inicialmente no lo es (porque no se ha introducido nada aún)
    boolean numeroValido = false;
    
    // Hay que declarar el número aqui porque se usa tras el do-while
    // Hay que inicializarlo a algo. Lo hacemos a cero pero se modificará antes
    // de salir del do-while
    int numero = 0;
    
    // Ciclo mientras el número no sea válido
    do {
      // Capturamos excepciones dentro del bloque siguiente
      try {
        // Intentamos leer el número
        System.out.print("Introduce un número entero: ");
        numero = Integer.parseInt(sc.nextLine());
        // Si llega hasta aqui, es que lo introducido se ha posido convertir a número
        //  Modificamos la bandera para indicar que ya tenemos número válido
        numeroValido = true;
      } catch (NumberFormatException e) {
        // Esta excepción se lanza en Integer.parseInt() si lo que se le pasa no es un número
        // En caso de excepción mostramos el mensaje y la bandera se queda como está (número no válido)
        System.out.println("El dato introducido no es un número válido");
      }
    } while (!numeroValido);

    // Cuando llegamos hasta aqui es porque el número es válido
    // Lo mostramos y acabamos
    System.out.printf("El número introducido es %d%n", numero);
  }

}
