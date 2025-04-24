package prog.unidad07.ejercicio03;

/**
 * Cuenta Abierta. Tiene comisión, interés y penalizaciones
 */
public class CuentaAbierta extends Cuenta {

  // Constantes
  // Interes anual (0 = no tiene interés)
  private static final double INTERES_ANUAL = 0.07;
  // Penalizacion
  private static final double PENALIZACION = 10;
  // Saldo minimo para penalizacion
  private static final double SALDO_MINIMO = 100;
  // Coste de transaccion
  private static final double COSTE_TRANSACCION = 0.1;
  
  // Atributos
  // Si la cuenta está penalizada porque el saldo descendió en algún momento del mínimo
  private boolean penaliza;
  // Número de transacciones en el mes
  private int transacciones;

  /**
   * Constructor. Crea una cuenta abierta con saldo 0
   * @param nombre Nombre del titular de la cuenta
   * @param dni DNI del titular
   */
  public CuentaAbierta(String nombre, String dni) {
    super(nombre, dni, INTERES_ANUAL);
    // Inicialmente NO penalizamos
    this.penaliza = false;
    // Reiniciamos las transacciones
    transacciones = 0;
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
    // Añadimos una nueva transaccion
    transacciones++;
  }
  
  @Override
  public void ingreso(double cantidad) {
    super.ingreso(cantidad);
    // Añadimos una nueva transaccion
    transacciones++;
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
    // Añade coste por transaccion
    comision += COSTE_TRANSACCION * transacciones;
    // Reiniciamos las transacciones
    transacciones = 0;
    
    // Devolvemos la comision
    return comision;
  }

}
