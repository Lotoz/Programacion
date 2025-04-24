package prog.unidad07.relacion01.ejercicio03;

public abstract class Cuenta {
  
  //Porcentaje de la comision
  private static final double PORCENTAJE_COMISION = 0.10;
  //Comision maxima
  private static final double COMISION_MAX = 10;
  //Atributos
  //Nombre
  protected String nombre;
  //DNI
  protected String dni;
  //Saldo
  protected double saldo;

  /**
   * Constructor
   * @param nombre
   * @param dni
   * @param saldo
   */
  public Cuenta(String nombre, String dni) {
    this.nombre = nombre;
    this.dni = dni;
    this.saldo = 0;
  }

  public void ingresa(double cantidad) {
    if(cantidad > 0 ) {
      saldo += cantidad;
    }
  }
  
  public void retiraDinero(double cantidad) {
    if (cantidad > 0 ) {
      saldo -= cantidad;
    }
  }
  
  public void actualizar() {
    double interes = getInteres();
    double comision = getComision();
    double penalizacion = getPenalizacion();
    
    saldo += interes - comision - penalizacion;
  }
  
  public double getComision () {
    double porcentaje = saldo * PORCENTAJE_COMISION;
    if(porcentaje <= COMISION_MAX) {
      return porcentaje;
    } else {
      return COMISION_MAX;
    }
  }
  
  public abstract double getInteres();
  public abstract double getPenalizacion();
  
}
