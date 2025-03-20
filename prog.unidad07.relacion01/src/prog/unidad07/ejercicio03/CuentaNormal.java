package prog.unidad07.ejercicio03;

public class CuentaNormal extends Cuenta {
  // Constantes
  // Interes anual (0 = no tiene interés)
  private static final double INTERES_ANUAL = 0;
  // Penalizacion
  private static final double PENALIZACION = 10;
  // Saldo minimo para penalizacion
  private static final double SALDO_MINIMO = 500;
  
  // Atributos
  // Si la cuenta está penalizada porque el saldo descendió en algún momento del mínimo
  private boolean penaliza;

  /**
   * Constructor
   * @param nombre Nombre del titular
   * @param dni DNI del titular
   */
  public CuentaNormal(String nombre, String dni) {
    super(nombre, dni, INTERES_ANUAL);
    // La cuenta no está penalizada inicialmente
    penaliza = false;
  }

  @Override
  public void retirada(double cantidad) {
    // Retiramos el dinero
    super.retirada(cantidad);
    // Si el saldo ha quedado por debajo del mínimo
    if (getSaldo() < SALDO_MINIMO) {
      // La cuenta penalizará en la próxima actualizacion
      penaliza = true;
    }
  }

  @Override
  protected double calculaComisiones() {
    // Obtenemos la comision base
    double comision = super.calculaComisiones();
    // Y añadimos la penalización, si la tiene
    if (penaliza) {
      // Elimina la penalización
      penaliza = false;
      // Y añade a la comisión la penalización
      comision += PENALIZACION;
    }
    // Devolvemos la comision
    return comision;
  }
}
