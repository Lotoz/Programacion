package prog.unidad07.ejercicio01;

/**
 * Las figuras tienen un punto
 */
public class Punto {

  //Atributos
  //coordena x
  private double x;
  //coordena y
  private double y;
  
  public Punto(double x, double y) {
   this.x = x;
   this.y = y;
  }

  public double getX() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
  }

  public double getY() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }
 
}
