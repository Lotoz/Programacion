package prog.unidad04.actividad405.ejercicio02;

/**
 * Interfaz que define las operaciones comunes a todas las figuras
 */
public interface Figura {

  /**
   * Obtiene el área de la figura
   * @return Área de la figura
   */
  double area();
  
  /**
   * Obtiene el perímetro de la figura
   * @return Perímetro de la figura
   */
  double perimetro();
  
  /**
   * Determina si la figura es o no regular. Una figura es regular si todos sus lados
   * son iguales (o es circular)
   * @return true si la figura es regular. false en caso contrario
   */
  boolean esRegular();
}
