package prog.unidad04.practica406.libreria;

/**
 * Motocicleta. Es un vehiculo con cilindrada.
 */

public class Motocicleta extends Vehiculo implements MaquinaConDistintivoAmbiental{

  private int cilindrada;
  private String matricula;
  private Fecha fechaMatriculacion;
  
  /**
   * Constructor.
   * 
   * @param matricula Matrícula del vehiculo. Debe tener un formato válido NNNN AAA donde NNNN son 4 dígitos y AAA son tres letras MAYÚSCULAS. Entre ellas puede haber cuantos espacios se quiera (incluido ninguno).
   * @param fechaMatriculacion Fecha de matriculación del vehiculo. No puede ser null.
   * @param cilindrada Cilindrada de la motocicleta (debe ser superior o igual a 50).
   * @throws NullPointerException - Si matricula o fechaMatriculacion es null.
   * @throws IllegalArgumentException - Si alguno de los parametros no es válido.
   */
  private Motocicleta(String matricula, Fecha fechaMatriculacion)  {
    super(matricula, fechaMatriculacion);
  }

  /**
   * Constructor.
   * 
   * @param matricula Matrícula del vehiculo. Debe tener un formato válido NNNN AAA donde NNNN son 4 dígitos y AAA son tres letras MAYÚSCULAS. Entre ellas puede haber cuantos espacios se quiera (incluido ninguno).
   * @param fechaMatriculacion Fecha de matriculación del vehiculo. No puede ser null.
   * @param cilindrada Cilindrada de la motocicleta (debe ser superior o igual a 50).
   * @throws NullPointerException - Si matricula o fechaMatriculacion es null.
   * @throws IllegalArgumentException - Si alguno de los parametros no es válido.
   */
  public Motocicleta(String matricula, Fecha fechaMatriculacion, int cilindrada)  {
    super(matricula, fechaMatriculacion);
      if (cilindrada == 0) {
        throw new NullPointerException("La cilindrada introducida es incorrecta. Revise los valores e intentelo de nuevo.");
      } else {
        this.cilindrada = cilindrada;
      }
  }
  /**
   * Obtiene la cilindrada de la motocicleta.
   * 
   * @return Cilindrada de la motocicleta.
   */
  public int getCilindrada() {
    return cilindrada;

  }
  /**
   * Obtiene el distintivo de la motocicleta.
   * Si la cilindrada es menor a 75 será 0, si está entre 75 y 125, ambas incluidas, será ECO, si está entre 125 (no incluida) y 500 (incluida) será A y si tiene más de 500 será B.
   * @return Distintivo ambiental de la máquina (0, ECO, A, B).
   */
  public String getDistintivo() {

    if (cilindrada < 75) {

      return "0";

    } else if (cilindrada >= 75 && cilindrada <= 125) {

      return "ECO";

    } else if (cilindrada > 125 && cilindrada <= 500) {

      return "A";

    } else {

      return "B";

    }
   
  }
  /**
   * Obtiene la representación en texto de la motocicleta en el formato:
   * Matricula: matricula, Fecha Matriculación: dd de mmmmm de aaaa, Cilindrada: cilindradas.
   */
  public String toString() {

    return " Matricula: " + getMatricula() + " Fecha Matriculacion: " + getFechaMatriculacion().toString() + " Cilindrada: " + cilindrada;

  }
}
