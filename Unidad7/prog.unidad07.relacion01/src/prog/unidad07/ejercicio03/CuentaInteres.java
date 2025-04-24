package prog.unidad07.ejercicio03;

public class CuentaInteres extends Cuenta {
  // Constantes
  // Interes anual
  private static final double INTERES_ANUAL = 7.0 / 100.0;

  /**
   * Constructor
   * @param nombre Nombre del titular
   * @param dni DNI del titular
   */
  protected CuentaInteres(String nombre, String dni) {
    // Construimos el objeto con el interes prdefinido
    super(nombre, dni, INTERES_ANUAL);
  }

}
