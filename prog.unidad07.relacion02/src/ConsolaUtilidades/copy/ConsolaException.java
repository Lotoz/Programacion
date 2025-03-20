package ConsolaUtilidades.copy;

/**
 * Clase que lanza excepciones personalizadas segun el error de entrada del
 * terminal. Pillado por un try catch
 */
//ANALIZAR SI AGREGAR MAS METODOS A FUTURO
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

  /**
   * Método para mostrar un mensaje de error cuando se intenta clonar una instancia.
   * Este método imprime un mensaje de error en la salida de error estándar.
   *
   * @param e La excepción CloneNotSupportedException que se ha lanzado al intentar clonar.
   */
  public static void mostrarError(CloneNotSupportedException e) {
    System.err.println("Error: No puedes clonar la instancia generada.");
  }
}
