package prog.unidad07.ejercicio01;

/**
 * Un circulo es una figura que contiene un punto y un radio
 */
public class Circulo extends Figura {
  //Atributos
  private Punto punto;
  private double radio;
  
  /**
   * Un circulo
   * @param punto
   * @param radio
   */
  public Circulo(Punto punto, double radio){
    punto = this.punto;
    radio = this.radio;
  }

  /**
   * Obtiene el area de un circulo
   * @param radio
   * @return
   */
  @Override
  public double getArea() {
    return (radio * 2) * Math.PI;
  }

  @Override
  public boolean isRegular() {
    return true;
  }
  
  /**
   * Obtiene el perimetro de un circulo
   * @param radio
   * @return
   */
  @Override
  public double getPerimetro() {
    return 2 * Math.PI * radio;
  }
  
 
}
