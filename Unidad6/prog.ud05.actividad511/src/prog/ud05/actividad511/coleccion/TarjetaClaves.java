package prog.ud05.actividad511.coleccion;

/**
 * Tarjeta de clave de un usuario Una tarjeta de claves contiene una tabla con
 * claves numéricas enteras
 */
public class TarjetaClaves {

  // Atributos de la clase
  private int filas;
  private int columnas;
  private int clave = 000;
  private int[][] tarjeta;
  private static int CERO = 0;
  private static int MAX_CLAVE = 999;

  /**
   * Crea una tarjeta de claves con las filas y columnas indicadas Inicialmente
   * las claves son todas 000
   * 
   * @param filas    - Número de filas de la tarjeta. Debe ser mayor que cero
   * @param columnas - Número de columnas de la tarjeta. Debe ser mayor que cero
   * @throws IllegalArgumentException - Si filas o columnas o ambos no son mayores
   *                                  que cero
   * @author Zamira
   */
  public TarjetaClaves(int filas, int columnas) {
    // comprobamos que filas y columnas sean mayores de cero, si no lo son, que de
    // una excepcion
    if (filas <= CERO || columnas <= CERO) {

      throw new IllegalArgumentException("Las filas o columnas son menores de cero.");
    }
    // Insertamos los datos en el array
    this.tarjeta = new int[filas][columnas];
    // Colocamos el largo de la fila con un for clasico
    for (int i = 0; i < tarjeta.length; i++) {
      // Colocalos el largo de la columnas con un for clasico
      for (int j = 0; j < tarjeta.length; j++) {
        this.tarjeta[i][j] = this.clave;
        this.filas = filas;
        this.columnas = columnas;
      }
    }
  }

  /**
   * Obtiene el número de filas que tiene la tabla de claves de la tarjeta
   * 
   * @return Número de filas de la tabla de claves
   */
  public int getFilas() {
    return filas;
  }

  /**
   * Obtiene el número de columnas que tiene la tabla de claves de la tarjeta
   * 
   * @return Número de columnas de la tabla de claves
   */
  public int getColumnas() {

    return columnas;
  }

  /**
   * Modifica el valor de una clave
   * 
   * @param fila    - Fila donde está la clave. Debe valer entre 1 y el total de
   *                filas de la tarjeta
   * @param columna - Columna donde está la clave. Debe valer entre 1 y el total
   *                de columnas de la tarjeta
   * @param clave   - Nuevo valor de la clave. Debe estar comprendido entre 0 y
   *                999, ambos incluidos
   * @throws IllegalArgumentException - Si fila, columna o clave son incorrectos
   */
  public void setClave(int fila, int columna, int clave) {
    // Debe restar para calcular la posicion en el array, ya que contamos desde cero
    fila -= 1;
    columna -= 1;
    // Comprobamos que fila y columna se puedan usar en el array
    // Y si la clave es posible
    if (compruebaFilaColumna(fila, columna) && clave >= CERO && clave <= MAX_CLAVE) {
      // Si se cumple se agrega al array
      tarjeta[fila][columna] = clave;

    } else {

      throw new IllegalArgumentException("Los valores fila o columna o clave no son validos.");
    }

  }

  /**
   * Valida que la clave es correcta
   * 
   * @param fila    - Número de fila de la clave. Debe valer desde 1 hasta el
   *                número de filas de la tarjeta
   * @param columna - Número de columna de la clave. Debe valer desde 1 hasta el
   *                número de columnas de la tarjeta
   * @param clave   - Valor de clave a validar
   * @return true si la clave es válida. false si no lo es
   * @throws IllegalArgumentException - Si fila o columna no son válidos
   */
  public boolean validarClave(int fila, int columna, int clave) {
    // Debe restar para calcular la posicion en el array, ya que contamos desde cero
    fila -= 1;
    columna -= 1;
    // Comprobamos que fila y columna se puedan usar en el array
    if (compruebaFilaColumna(fila, columna)) {
//comprobamos si clave existe en esa posicion
      if (clave == tarjeta[fila][columna]) {

        return true;
      }
      return false;
    }
    throw new IllegalArgumentException("Clave no valida.");
  }

  /**
   * Verifica si no es menor de 0 Si fila es menor que filas del array Si columna
   * es menor que columnas en el array
   * 
   * @param fila
   * @param columna
   * @return True si esta todo bien
   */
  private boolean compruebaFilaColumna(int fila, int columna) {

    if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {

      return true;
    }
    return false;
  }

}