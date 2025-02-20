package ExceptionPersonalizado;

/**
 * Clase que lanza excepciones personalizadas segun el error de entrada del
 * terminal. Pillado por un try catch
 */
//ANALIZAR SI AGREGAR MAS METODOS A FUTURO
public class ConsolaException {
  /**
   * Imprime un error con un mensaje personalizado.
   * 
   * @param Mensaje
   */
  public static void mostrarError(Exception e) {
      System.err.println("Error inesperado: " + e.getMessage());
  }
  
  /**
   * Lanza una excepcion personalizada cuando un numero no es un entero
   * @param numero
   */
  public static void mostrarError(NumberFormatException e) {
    System.err.println("Error: Entrada no válida. Debe ser un número entero.");
  }
  /**
   *Lanza una excepcion personalizada cuando un numero no es decimal
   * @param numero
   */
  public static void mostrarError(IllegalArgumentException e) {
    System.err.println("Error: Entrada no válida.");
  }
}
