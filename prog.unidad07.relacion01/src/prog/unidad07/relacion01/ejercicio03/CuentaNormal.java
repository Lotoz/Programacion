package prog.unidad07.relacion01.ejercicio03;

public class CuentaNormal extends Cuenta {

  //Constantes
  private static final double PENALIZACION = 10;
  private static final double SALDO_MINIMO = 500;
  //Atributo
  private boolean penaliza;
  
  /**
   * Cuenta normal constructor
   * @param nombre
   * @param dni
   */
  public CuentaNormal(String nombre, String dni) {
    super(nombre, dni);
    penaliza = false;
    
  }

  /**
   * Obtiene el interes
   */
  @Override
  public double getInteres() {
    return 0;
  }

  /**
   * Obtiene penalizacion
   */
  @Override
  public double getPenalizacion() {
   return penaliza ? PENALIZACION : 0;
  }

  /**
   * retira dinero
   */
  @Override
  public void retiraDinero(double cantidad) {
   super.retiraDinero(cantidad);
   if(saldo < SALDO_MINIMO) {
     penaliza = true;
   }
  }

  /**
   * Actualiza el metodo
   */
  @Override
  public void actualizar() {
    super.actualizar();
    if(saldo < SALDO_MINIMO) {
      penaliza = true;
    } else {
      penaliza = false;
    }
  }

}
