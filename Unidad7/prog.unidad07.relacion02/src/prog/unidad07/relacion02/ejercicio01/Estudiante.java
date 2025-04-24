package prog.unidad07.relacion02.ejercicio01;

/**
 * Estudiante del centro
 */
public class Estudiante extends Persona {

  // Atributos
  // Curso
  private String curso;

  /**
   * Constructor
   * @param nombre Nombre y apellidos del estudiante
   * @param dni DNI del estudiante
   * @param estadoCivil estado civil del estudiante
   * @param curso Curso en que se encuentra matriculado el estudiante
   */
  public Estudiante(String nombre, String dni, String estadoCivil, String curso) {
    super(nombre, dni, estadoCivil);
    this.curso = curso;
  }
  
  /**
   * Matricula al estudiante en un nuevo curso
   * @param curso Nuevo curso en el que matricular al estudiante
   */
  public void setCurso(String curso) {
    this.curso = curso;
  }

  @Override
  public String toString() {
    return super.toString() + String.format(", Curso: \"%s\"", curso);
  }
  
  
}
