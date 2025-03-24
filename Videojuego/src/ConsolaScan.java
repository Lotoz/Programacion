

import java.util.Scanner;


/***
 * Clase que proporciona un objeto Scanner para leer datos desde la consola.
 * Esta clase implementa el patrón Singleton,lo que significa que solo se puede
 * crear una instancia de esta clase.
 */

/*
 * COSAS PARA AGREGAR
 * 1.Mensaje para poner al pedir
 * 2.Control de genericos
 * 3.Control de largo de la linea
 * 4.Control de rango 
 * 5.Pensar
 */
public class ConsolaScan {
  // Atributos
  /** Instancia única de ConsolaScan. */
  private static ConsolaScan scanUnico = null;

  /** Objeto Scanner para leer datos de la consola. */
  private Scanner scan;

  /**
   * Constructor privado para evitar la instanciación externa. Inicializa el
   * objeto Scanner.
   */
  private ConsolaScan() {
    scan = new Scanner(System.in);
  }

  /**
   * Método para obtener la instancia única de ConsolaScan. Si la instancia no
   * existe, se crea una nueva.
   *
   * @return La instancia única de ConsolaScan.
   */
  public static ConsolaScan getInstance() {
    String cadena = "ConsolaScan";
    if (scanUnico == null) {
      // Crea una nueva instancia de ConsolaScan
      scanUnico = new ConsolaScan();
    } else {
      try {
        scanUnico.clone();
      } catch (CloneNotSupportedException e) {
        System.err.println("No se pueden crear dos instancias.");
      }
    }
    return scanUnico;
  }
  /**
   * Método que evita la clonación de la instancia de ConsolaScan. Lanza una
   * excepción CloneNotSupportedException si se intenta clonar.
   *
   * @return null, ya que la clonación no está permitida.
   */
  @Override
  public ConsolaScan clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException();
  }

  /**
   * Método para leer una línea de entrada desde la consola.
   *
   * @return La línea de texto introducida por el usuario.
   */
  public String leerString() {
    System.out.printf("Ingrese la linea de texto:");
    return scan.nextLine();
  }

  /**
   * Método para leer un número entero desde la consola.
   *
   * @return El número entero introducido por el usuario.
   * @throws NumberFormatException Si la entrada no es un número entero válido.
   */
  public int leerInt() {
    System.out.printf("Introduzca un numero:");
    return Integer.parseInt(scan.nextLine());
  }

  /**
   * Método para leer un número decimal desde la consola.
   *
   * @return El número de punto flotante introducido por el usuario.
   * @throws NumberFormatException Si la entrada no es un número de punto flotante
   *                               válido.
   */
  public double leerDouble() {
    System.out.printf("Introduzca un numero:");
    return Double.parseDouble(scan.nextLine());
  }

  /**
   * Método para leer un número float desde la consola.
   *
   * @return El número de punto flotante introducido por el usuario.
   * @throws NumberFormatException Si la entrada no es un número de punto flotante
   *                               válido.
   */
  public float leerFloat() {
    System.out.printf("Introduzca un numero:");
    return Float.parseFloat(scan.nextLine());
  }
}
