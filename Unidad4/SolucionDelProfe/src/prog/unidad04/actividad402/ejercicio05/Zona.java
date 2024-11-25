package prog.unidad04.actividad402.ejercicio05;

/**
 * Zona de asientos en un teatro
 */
public class Zona {

  // Número de entradas por vender en la zona
  private int entradasPorVender;
  
  /**
   * Crea una zona con el número de entradas por vender especificado
   * @param entradasIniciales Número inicial de entradas por vender
   */
  public Zona(int entradasIniciales) {
    entradasPorVender = entradasIniciales;
  }
  
  /**
   * Obtiene el número de entradas por vender
   * @return Número de entradas por vender en la zona
   */
  public int getEntradasPorVender() {
    return entradasPorVender;
  }
  
  /**
   * Intenta vender el número de entradas indicado. Si no hay suficientes entradas
   * para satisfacer la venta, esta no se realiza
   * @param entradas Número de entradas a vender
   * @return Número de entradas vendidas. Será igual al número de entradas solicitadas si se pudo hacer
   *   la venta o 0 si no se pudo realizar ésta
   */
  public int vender(int entradas) {
    // Si hay entradas suficientes
    if (entradasPorVender >= entradas) {
      // Restamos las que vendemos
      entradasPorVender -= entradas;
      // Y las devolvemos
      return entradas;
    } else {
      // No hay suficientes entradas
      return 0;
    }
  }
}
