package prog.unidad07.ejercicio01;

public class Rectangulo extends Figura {

  //Atributos
  //Esquina superior izquierda
  private Punto punto1;
  //Esquina inferior derecha 
  private Punto punto2;
  
  
  public Rectangulo(Punto punto1, Punto punto2) {
    punto1 = this.punto1;
    punto2 = this.punto2;
  }


  @Override
  public double getArea() {
    double ladoHorizontal = getLadoHorizontal(punto1,punto2);
    double ladoVertical = getLadoVertical(punto1,punto2);
  double area = ladoHorizontal * ladoVertical;
    return area;
  }


  @Override
  public boolean isRegular() {
    //Probar hacer ternario
    return false;
  }


  @Override
  public double getPerimetro() {
 
    double ladoHorizontal = getLadoHorizontal(punto1,punto2);
    double ladoVertical = getLadoVertical(punto1,punto2);
    double perimetro = (ladoHorizontal*2) + (ladoVertical*2);
    return perimetro;
  }
  
  private double getLadoHorizontal(Punto punto1, Punto punto2) {
    return  punto1.getX() - punto2.getX();
  }

  private double getLadoVertical(Punto punto1, Punto punto2) {
    return  punto1.getY() - punto2.getY();
  }
}
