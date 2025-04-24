package prog.ud07.examen;

/**
 * Un estudiante de pregrado es aquel que aun no ha finalizado un grado.
 */
public class EstudiantePregrado extends Estudiante {

  /**
   * Contructor de un estudiante de pregrado
   * 
   * @param nombre
   * @param dni
   * @param calificacionMedia
   */
  public EstudiantePregrado(String nombre, String dni, double calificacionMedia) {
    super(nombre, dni, calificacionMedia);

  }

  /**
   * Solo puede titular si su calificacionMedia es superior o igual a 5
   * 
   * @param calificacion
   * @return true - si titula
   * @return false - si no titula
   */
  @Override
  public boolean esTitular() {
    return calificacionMedia >= 5 ? true : false;
  }

}
