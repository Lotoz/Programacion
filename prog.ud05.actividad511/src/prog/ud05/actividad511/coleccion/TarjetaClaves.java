package prog.ud05.actividad511.coleccion;

public class TarjetaClaves {
  // Revisar luego
  /**
   * Atributos de Tarjeta Claves
   */
  private int filas;
  private int columnas;
  private int clave = 000;
  private int[][] tarjeta;

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

    if (filas <= 0 || columnas <= 0) {

      throw new IllegalArgumentException("Las filas o columnas no son mayores a 0");
    }

    this.tarjeta = new int[filas][columnas];

    for (int i = 0; i < tarjeta.length; i++) {

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

    fila -= 1;
    columna -= 1;

    if (comprobarFilaColumna(fila, columna) && clave >= 0 && clave <= 999) {

      tarjeta[fila][columna] = clave;
    } else {

      throw new IllegalArgumentException("La fila, columna o claves no son correctos");
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

    fila -= 1;
    columna -= 1;

    if (comprobarFilaColumna(fila, columna)) {

      if (clave == tarjeta[fila][columna]) {

        return true;
      }
      return false;
    }
    throw new IllegalArgumentException("La fila o la columna no son validos");
  }

  /**
   * Metodos privados
   */

  /**
   * Verifica si no es menor de 0
   * 
   * @param numero
   * @return True si esta todo bien
   */
  private boolean comprobarFilaColumna(int fila, int columna) {

    if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {

      return true;
    }
    return false;
  }

}
