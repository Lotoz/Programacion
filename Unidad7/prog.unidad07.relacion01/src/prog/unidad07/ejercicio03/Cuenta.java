package prog.unidad07.ejercicio03;

/**
 * Cuenta base de todas las cuentas
 */
public abstract class Cuenta {

  // Porcentaje de comision
  private static final double COMISION_PORCENTAJE = 10.0 / 100.0;
  // Comision Máxima
  private static final double COMISION_MAXIMA = 10;
  
  // Atributos comunes a todas las cuentas
  // Nombre
  private String nombre;
  // DNI
  private String dni;
  // Saldo
  private double saldo;
  // Interes anual
  private double interesAnual;
  
  /**
   * Constructor. La cuenta se crea con saldo 0
   * @param nombre Nombre del titular
   * @param dni DNI del titular
   */
  protected Cuenta(String nombre, String dni, double interesAnual) {
    this.nombre = nombre;
    this.dni = dni;
    this.interesAnual = interesAnual;
    setSaldo(0);
  }

  /**
   * Obtiene el interes anual de la cuenta
   * @return Interes anual de la cuenta
   */
  public double getInteresAnual() {
    return interesAnual;
  }

  /**
   * Obtiene el nombre del titular
   * @return Nombre del titular de la cuenta
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Obtiene el DNI del titular de la cuenta
   * @return DNI del titular de la cuenta
   */
  public String getDni() {
    return dni;
  }

  /**
   * Obtiene el saldo de la cuenta
   * @return Saldo de la cuenta
   */
  public double getSaldo() {
    return saldo;
  }
  
  /**
   * Ingresa una cantidad de dinero en la cuenta
   * @param cantidad Cantidad a ingresar. Debe ser mayor que cero
   * @throws IllegalArgumentException Si la cantidad es cero o negativa
   */
  public void ingreso(double cantidad) {
    // Si la cantidad es mayor que cero
    if (cantidad > 0) {
      // Actualiza el saldo
      setSaldo(saldo + cantidad);
    } else {
      // Si la cantidad es cero o negativa no actualiza el saldo y lanza excepción
      throw new IllegalArgumentException("No se puede ingresar una cantidad negativa o cero");
    }
  }
  
  /**
   * Retira una cantidad de dinero de la cuenta
   * @param cantidad Cantidad a retirar. Debe ser mayor que cero y menor o igual al saldo actual
   *   de la cuenta.
   * @throws IllegalArgumentException Si la cantidad es cero o menor o superior al saldo actual de
   *   la cuenta
   */
  public void retirada(double cantidad) {
    // Si la cantidad es mayor que cero y menor o igual al saldo
    if (cantidad > 0 && cantidad <= saldo) {
      // Actualiza el saldo
      setSaldo(saldo - cantidad);
    } else {
      // Si la cantidad es cero o negativa o superior al saldo no actualiza el mismo y lanza excepcion
      throw new IllegalArgumentException("No se puede ingresar una cantidad negativa o cero o superior al saldo");
    }
  }
  
  /**
   * Actualizacion mensual del saldo de la cuenta. Aplica los intereses y las comisiones de la
   * misma
   */
  public void actualizacionMensual() {
    // Actualiza el saldo añadiendo los intereses generados y descontando las comisiones
    setSaldo(saldo + calculaIntereses() - calculaComisiones());
  }
  
  /**
   * Calcula los intereses mensuales de la cuenta
   * @return Intereses mensuales de la cuenta. Siempre son positivos o cero, esto es, una cuenta
   *   con saldo negativo no genera intereses.
   */
  protected double calculaIntereses() {
    // Calculamos el interés mensual a partir del anual
    double interesMensual = interesAnual / 12.0;
    // Obtenemos el interes provisional
    double interes = saldo * interesMensual;
    // Devuelve el interes calculado sólo si es positivo. Si no devuelve cero
    return interes > 0 ? interes : 0;
  }
  
  /**
   * Calcula las comisiones mensuales de la cuenta
   * @return Comisiones mensuales de la cuenta. Siempre son positivos o cero.
   */
  protected double calculaComisiones() {
    // Primero calculamos la comision en porcentaje del saldo
    double comision = Math.round(getSaldo() * COMISION_PORCENTAJE * 100) / 100.0;
    // Si la comision es mayor que la comision máxima, la dejamos en la comisión máxima
    if (comision > COMISION_MAXIMA) {
      comision = COMISION_MAXIMA;
    }
    return comision;
  }
  
  /**
   * Modifica el saldo de la cuenta
   * @param saldo Nuevo saldo de la cuenta
   */
  protected void setSaldo(double saldo) {
    // Redondea el saldo y lo almacena
    this.saldo = Math.round(saldo * 100.0) / 100.0;
  }

  
}
