package prog.unidad07.ejercicio03;

/**
 * Cuenta ahorro. Cuenta con buen interés pero penaliza si se hacen retiradas
 */
public class CuentaAhorro extends Cuenta {
  // Constantes
  // Interes anual
  private static final double INTERES_ANUAL = 15.0 / 100.0;
  // Penalizacion
  private static final double PORCENTAJE_PENALIZACION = 20.0 / 100.0;
  // Meses que deben transcurrir entre retiradas para que no se penalice
  private static final int MESES_RETIRADA_SIN_PENALIZAR = 12;
  
  // Atributos
  // Coste de la penalizacion
  private double penalizacion;
  // Meses transcurridos desde la última retirada
  private int mesesDesdeUltimaRetirada;

  /**
   * Constructor
   * @param nombre Nombre del titular
   * @param dni DNI del titular
   */
  protected CuentaAhorro(String nombre, String dni) {
    // Construimos el objeto con el interes prdefinido
    super(nombre, dni, INTERES_ANUAL);
    // No hay penalizacion
    penalizacion = 0;
    // Meses desde la última retirada cero
    mesesDesdeUltimaRetirada = 0;
  }

  @Override
  protected double calculaComisiones() {
    // Obtenemos la comision base
    double comision = super.calculaComisiones();
    // Si había penalizacion
    if (penalizacion > 0) {
      // Añade a la comisión la penalización
      comision += penalizacion;
      // Reiniciamos la penalizacion
      penalizacion = 0;
    } else {
      // Anotamos otro mes sin retiradas
      mesesDesdeUltimaRetirada++;
    }
    // Devolvemos la comision
    return comision;
  }

  @Override
  public void retirada(double cantidad) {
    // Anotamos el saldo ANTES de retirar
    double saldo = getSaldo();
    // Hacemos la retirada
    super.retirada(cantidad);
    
    // Si no han pasado al menos el número de meses exigido
    if (mesesDesdeUltimaRetirada < MESES_RETIRADA_SIN_PENALIZAR) {
      // Calcula la penalizacion
      penalizacion = PORCENTAJE_PENALIZACION * saldo;
    }
    // Reiniciamos el número de meses desde la última retirada
    mesesDesdeUltimaRetirada = 0;
  }

  
}
