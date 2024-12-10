package prog.unidad04.actividad404.ejercicio04;

/**
 * Esta clase calcula la media de una serie de números
 * Un ejemplo de uso sería:<br>
 * <pre>
 * CalculadorMedia calculador = new CalculadorMedia(8.3);
 * calculador.add(7.2);
 * System.out.println("Media actual: " + calculador.getMedia());
 * calculador.add(10.2);
 * System.out.println("Media actual: " + calculador.getMedia());
 * </pre>
 */
public class CalculadorMedia {

  // Valor actual de la suma
  private double suma;
  // Número de valores introducidos hasta el momento
  private int longitud;
  
  /**
   * Construye el objeto con el primer valor de la seria
   * @param valorInicial Primer valor de la serie (y de la media)
   */
  public CalculadorMedia(double valorInicial) {
    // Iniciamos la suma a este valorInicial
    suma = valorInicial;
    // Y la longitud es 1
    longitud = 1;
  }
  
  /**
   * Añade un nuevo número a la serie
   * @param numero Nuevo número a añadir a la serie
   */
  public void add(double numero) {
    // Añade el número a la suma
    suma += numero;
    // Incrementa la longitud
    longitud++;
  }
  
  /**
   * Obtiene el valor actual de la media, correspondiente a la media de los
   * números añadidos hasta el momento.
   * @return Valor actual de la media
   */
  public double getMedia() {
    return suma / longitud;
  }
}
