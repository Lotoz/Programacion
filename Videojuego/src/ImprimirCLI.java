

/**
 * Clase que proporciona un objeto para imprimir mensajes en la consola. Esta
 * clase implementa el patrón Singleton, lo que significa que solo se puede
 * crear una instancia de esta clase.
 */
public class ImprimirCLI {

  /** Instancia única de ImprimirCLI. */
  private static ImprimirCLI impresor = null;

  /**
   * Constructor privado para evitar la instanciación externa. Inicializa el
   * objeto ImprimirCLI.
   */
  private ImprimirCLI() {
  }

  /**
   * Método para obtener la instancia única de ImprimirCLI. Si la instancia no
   * existe, se crea una nueva.
   *
   * @return La instancia única de ImprimirCLI.
   * @throws CloneNotSupportedException 
   */
  public static ImprimirCLI getInstance(){
    String cadena = "Impresor";
    if (impresor == null) {
      impresor = new ImprimirCLI();
    } else {
     try {
      impresor.clone();
    } catch (CloneNotSupportedException e) {
      System.err.println("No se pueden crear dos instancias.");
    }
    }
    return impresor;
  }

  /**
   * Método que evita la clonación de la instancia de ImprimirCLI. Lanza una
   * excepción CloneNotSupportedException si se intenta clonar.
   * @return 
   * @throws CloneNotSupportedException 
   */
  @Override
  public ImprimirCLI clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException();
  }

  /**
   * Imprime la cadena proporcionada en la consola.
   *
   * @param cadena La cadena que se desea imprimir.
   */
  public void imprimir(String cadena) {
    System.out.println(cadena);
  }

  /**
   * Imprime la cadena proporcionada en la consola utilizando printf.
   *
   * @param cadena La cadena que se desea imprimir.
   */
  public void printOffJump(String cadena) {
    System.out.printf(cadena);
  }

  /**
   * Imprime la cadena proporcionada en la consola, eliminando todos los espacios
   * en blanco.
   *
   * @param cadena La cadena que se desea imprimir.
   */
  public void printOffSpace(String cadena) {
    String imprimir = cadena.replaceAll("\\s+", "");
    System.out.printf(imprimir);
  }

  /**
   * Imprime la cadena proporcionada en la consola, eliminando los espacios en
   * blanco al inicio y al final.
   *
   * @param cadena La cadena que se desea imprimir.
   */
  public void printTrim(String cadena) {
    String imprimir = cadena.trim();
    System.out.printf(imprimir);
  }

  /**
   * Imprime una cabecera en la consola, seguida de una línea de caracteres "=-"
   * que se repite según la longitud de la cadena.
   *
   * @param cadena La cadena que se desea imprimir como cabecera.
   */
  public void imprimirCabecera(String cadena) {
    System.out.println();
    System.out.println(cadena);
    for (int i = 0; i < cadena.length(); i++) {
      System.out.print("=-");
    }
    System.out.println("");
  }

  /**
   * Imprime una cadena en la consola en mayúsculas, seguida de una línea de
   * caracteres "=-" que se repite según la longitud de la cadena.
   *
   * @param cadena La cadena que se desea imprimir en mayúsculas.
   */
  public void imprimirUpper(String cadena) {
    System.out.println();
    System.out.println(cadena.toUpperCase());
    for (int i = 0; i < cadena.length(); i++) {
      System.out.print("=-");
    }
    System.out.println("");
  }

}
