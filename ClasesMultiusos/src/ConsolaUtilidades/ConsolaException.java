package ExceptionPersonalizado;

/**
 * Clase que lanza excepciones personalizadas segun el error de entrada del
 * terminal. Pillado por un try catch
 */
//ANALIZAR SI AGREGAR MAS METODOS A FUTURO
//Sigle town, debe pedir los datos por terminal y escanearlos. Esta clase puede ser complento
public class ConsolaException {
  /**
   * Imprime un error con un mensaje personalizado.
   * 
   * @param e
   */
  public static void mostrarError(Exception e) {
    System.err.println("Error inesperado");
  }

  /**
   * Lanza una excepcion personalizada cuando un numero no es un entero
   * 
   * @param e
   */
  public static void mostrarError(NumberFormatException e) {
    System.err.println("Error: Entrada no válida. Debe ser un número entero.");
  }

  /**
   * Lanza una excepcion personalizada cuando un numero no es decimal
   * 
   * @param e
   */
  public static void mostrarError(IllegalArgumentException e) {
    System.err.println("Error: Entrada no válida.");
  }

}
