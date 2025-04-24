package prog.ud07.examen;

/**
 * Es un estudiante, hereda de persona caracteristicas basicas
 */
public abstract class Estudiante extends Persona {

  /**
   * Atributos
   */
  protected double calificacionMedia;

  /**
   * Crea un estudiante
   * 
   * @param nombre
   * @param dni
   * @param calificacionMedia
   */
  protected Estudiante(String nombre, String dni, double calificacionMedia) {
    super(nombre, dni);
    validaCalificacionMedia(calificacionMedia);
    this.calificacionMedia = calificacionMedia;
  }

  /**
   * Obtiene la calificacion media
   * 
   * @return
   */
  public double getCalificacionMedia() {
    return calificacionMedia;
  }

  /**
   * Califica si titulo o no
   * 
   * @param calificacion
   * @return true - si titula
   * @return false - si no titula
   */
  protected abstract boolean esTitular();

  /**
   * Valida la calificacion media de un estudiante, esta debe estar entre 0 y 10
   * ambas inclusive
   * 
   * @param calificacion
   */
  protected void validaCalificacionMedia(double calificacion) {
    if (calificacion > 10 || calificacion <= -1) {
      throw new IllegalArgumentException("calificacion invalida");
    }
  }

}
