package prog.ud05.actividad511.coleccion;

public class TarjetaClaves {

  /**
   * Atributos de Tarjeta Claves
   */
  private static int filas;
  private static int columnas;
  private static int clave = 000;
  private int [][] tarjeta;
  /**
   * Crea una tarjeta de claves con las filas y columnas indicadas Inicialmente
   * las claves son todas 000
   * 
   * @param filas                    - Número de filas de la tarjeta. Debe ser
   *                                 mayor que cero
   * @param columnas                 - Número de columnas de la tarjeta. Debe ser
   *                                 mayor que cero
   * @param IllegalArgumentException - Si filas o columnas o ambos no son mayores
   *                                 que cero
   * @throws IllegalArgumentException - Si filas o columnas o ambos no son mayores
   *                                  que cero
   * @author Zamira
   */
  public TarjetaClaves(int filas, int columnas) {
    if(verificaNumero(filas) || verificaNumero(columnas)) {
      
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

    return false;
  }
  
  /**
   * Metodos privados
   */
  /**
   * Verifica si no es menor de 0
   * @param numero
   * @return True si esta todo bien
   */
  private boolean verificaNumero(int numero) {
    if(numero < 0) {
      return false;
    }else {
      return true;
    }
  }

}
