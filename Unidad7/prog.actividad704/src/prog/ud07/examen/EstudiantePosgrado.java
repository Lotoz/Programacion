package prog.ud07.examen;

/**
 * Un estudiante de posgrado ya ha terminado un grado pero está realizando
 * estudios posterios (ej:doctorado, master)
 */
public class EstudiantePosgrado extends Estudiante implements PagoSeguro {

  /**
   * Constructor de un estudiante de Posgrado
   * 
   * @param nombre
   * @param dni
   * @param calificacionMedia
   */
  public EstudiantePosgrado(String nombre, String dni, double calificacionMedia) {
    super(nombre, dni, calificacionMedia);
  }

  /**
   * Metodo para que un estudiante pague un seguro de postgrado Paga 2000 euros
   */
  @Override
  public double importeSeguro() {
    return 2000;
  }

  /**
   * Metodo para saber si por su calificacion media el estudiante titula Titula
   * con 7.5
   * 
   * @param calificacion
   * @return true - si titula
   * @return false - si no titula
   */
  @Override
  public boolean esTitular() {
    return calificacionMedia >= 7.5 ? true : false;
  }

}
