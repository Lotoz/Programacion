package prog.unidad07.ejercicio01;

public class Triangulo extends Figura {

  //Vertice
  private Punto punto1;
  private Punto punto2;
  private Punto punto3;
  
  public Triangulo(Punto punto, Punto punto2, Punto punto3) {
    this.punto1 = punto;
    this.punto2 = punto2;
    this.punto3 = punto3;
  }

  @Override
  public double getArea() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public boolean isRegular() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public double getPerimetro() {
    // TODO Auto-generated method stub
    return 0;
  }

}
