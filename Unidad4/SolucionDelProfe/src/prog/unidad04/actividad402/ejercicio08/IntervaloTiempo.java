package prog.unidad04.actividad402.ejercicio08;

/**
 * Representa un intervalo de tiempo en horas, minutos y segundos
 */
public class IntervaloTiempo {

  // Número de segundos por minuto y por hora
  private static final int SEGUNDOSPORMINUTO = 60;
  private static final int SEGUNDOSPORHORA = 3600;
  
  // Segundos del intervalo (solo guardamos los segundos porque el resto se puede calcular a partir de los mismos
  private int segundos;
  
  /**
   * Constructor que toma hora minutos y segundos
   * @param horas Horas del intervalo
   * @param minutos Minutos del intervalo. Si se indican más de 59 puede sumar una o más horas al intervalo
   * @param segundos segundos del intervalo. Si se indican más de 59 puede sumar uno o más minutos al intervalo, incluso horas
   */
  public IntervaloTiempo(int horas, int minutos, int segundos) {
    this(segundos + minutos * SEGUNDOSPORMINUTO + horas * SEGUNDOSPORHORA);
  }
  
  /**
   * Constructor sólo con segundos. Convierte automáticamente el exceso de 59 segundos en minutos y horas
   * @param segundos Número de segundos del intervalo
   */
  private IntervaloTiempo(int segundos) {
    this.segundos = segundos;
  }
  
  /**
   * Suma a este intervalo otro y devuelve la suma de ambos
   * @param otro Otro intervalo a sumar a éste
   * @return Nuevo IntervaloTiempo con la suma de ambos intervalos
   */
  public IntervaloTiempo suma(IntervaloTiempo otro) {
    return new IntervaloTiempo(this.segundos + otro.segundos);
  }

  /**
   * Resta de este intervalo el intervalo proporcionado y devuelve la diferencia
   * @param otro Otro intervalo a restar de éste
   * @return Nuevo IntervaloTiempo con la difeencia o null si no se puede hacer la resta porque
   *         el primer intervalo es menor que el otro
   */
  public IntervaloTiempo resta(IntervaloTiempo otro) {
    // Si se puede hacer la resta
    if (this.segundos >= otro.segundos) {
      // La hace
      return new IntervaloTiempo(this.segundos - otro.segundos);
    } else {
      // No se puede hacer la resta porque no se permiten intervalos negativos
      return null;
    }
  }

  /**
   * Obtiene una cadena con la representacion del intervalo en formato
   * AAh BBm CCs, donde AA son las horas, BB los minutos y CC los segundos
   * @return Cadena con la representación del intervalo
   */
  public String toString() {
    // Obtenemos el númetos de horas
    int horas = this.segundos / SEGUNDOSPORHORA;
    // Estos son los segundos que no caben exactamente en una hora
    int segundos = this.segundos % SEGUNDOSPORHORA;
    // Con estos segundos obtenemos los minutos
    int minutos = segundos / SEGUNDOSPORMINUTO;
    // Y el resto son los segundos restantes que no caben exactamente en un minuto
    segundos %= SEGUNDOSPORMINUTO;
    
    // Creamos la cadena y la devolvemos
    return horas + "h " + minutos + "m " + segundos + "s";
  }

}
