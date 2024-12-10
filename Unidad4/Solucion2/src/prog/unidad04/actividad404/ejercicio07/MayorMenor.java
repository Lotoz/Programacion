package prog.unidad04.actividad404.ejercicio07;

/**
 * Permite calcular el mayor y menor de una serie de números enteros
 */
public class MayorMenor {

  // Mayor número observado hasta el momento
  private int mayor;
  // Menor número observado hasta el momento
  private int menor;
  
  /**
   * Construye un nuevo objeto con el primer número de la serie
   * @param numero Primer número de la serie
   */
  public MayorMenor(int numero) {
    // El número es por ahora el mayor y el menor (y el único)
    mayor = numero;
    menor = numero;
  }
  
  /**
   * Añade un número a la serie
   * @param numero Nuevo número a añadir a la serie
   */
  public void add(int numero) {
    // Si el número es mayor que el mayor actual
    if (numero > mayor) {
      // Lo almacenamos como nuevo mayor actual
      mayor = numero;
    }
    
    // Si el número es menor que el menor actual
    if (numero < menor) {
      // Lo almacenamos como nuevo menor actual
      menor = numero;
    }
  }
  
  /**
   * Obtiene el mayor número visto en la serie hasta el momento
   * @return Mayor número visto hasta el momento
   */
  public int getMayor() {
    return mayor;
  }
  
  /**
   * Obtiene el menor número visto en la serie hasta el momento
   * @return Menor número visto hasta el momento
   */
  public int getMenor() {
    return menor;
  }
}
