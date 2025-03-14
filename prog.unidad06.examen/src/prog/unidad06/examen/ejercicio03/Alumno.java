package prog.unidad06.examen.ejercicio03;

/**
 * Información sobre un alumno
 */
public class Alumno {
  
  // Constantes publicas
  /**
   * Curso primero de bachillerato
   */
  public static final int CURSO_1_BACH = 0;
  /**
   * Curso segundo de bachillerato
   */
  public static final int CURSO_2_BACH = 1;
  /**
   * Curso primero de grado superior
   */
  public static final int CURSO_1_GS = 2;
  /**
   * Curso segundo de grado superior
   */
  public static final int CURSO_2_GS = 3;

  // Constantes privadas
  // Edad mínima de los alumnos
  private static final int EDAD_MINIMA = 0;
  
  // Atributos privados
  // Nombre del alumno
  private String nombre;
  // Edad del alumno
  private int edad;
  // Usa o no usa servicio de comedor?
  private boolean usaComedor;
  // Curso en el que está matriculado
  private int curso;
  
  /**
   * Constructor con todos los datos del alumno
   * @param nombre Nombre del alumno. No puede ser null ni estar vacío o contener sólo blancos
   * @param edad Edad del alumno. Debe ser mayor que cero
   * @param usaComedor Usa (true) o no usa (false) el servicio de comedor
   * @param curso Curso en el que está matriculado. Debe ser uno de
   * <ul>
   * <li>CURSO_1_BACH</li>
   * <li>CURSO_2_BACH</li>
   * <li>CURSO_1_GS</li>
   * <li>CURSO_2_GS</li>
   * </ul>
   * @throws NullPointerException Si nombre es null
   * @throws IllegalArgumentException Si alguno de los parámetros no es válido
   */
  public Alumno(String nombre, int edad, boolean usaComedor, int curso) {
    // Asigna los 
    setNombre(nombre);
    setEdad(edad);
    setUsaComedor(usaComedor);
    setCurso(curso);
  }

  /**
   * Obtiene el nombre del alumno
   * @return nombre
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Obtiene la edad del alumno
   * @return edad
   */
  public int getEdad() {
    return edad;
  }

  /**
   * Obtiene si el alumno usa o o no servicio de comedor
   * @return true si usa el servicio de comedor. false si no
   */
  public boolean isUsaComedor() {
    return usaComedor;
  }

  /**
   * Obtiene el curso en el que está el alumno
   * @return curso. Uno de CURSO_1_BACH, CURSO_2_BACH, CURSO_1_GS, CURSO_2_GS
   */
  public int getCurso() {
    return curso;
  }

  /**
   * Modifica el nombre del alumno
   * @param nombre Nuevo nombre del alumno No debe ser null ni ser vacío o consistir sólo de blancos
   * @throws NullPointerException Si el nombre es null
   * @throws IllegalArgumentException Si el nombre está vacío o consta sólo de blancos
   */
  public void setNombre(String nombre) {
    if (nombre.isBlank()) {
      throw new IllegalArgumentException("El nombre está vacío o consta sólo de blancos");
    }
    this.nombre = nombre;
  }

  /**
   * Modifica la edad del alumno
   * @param edad Nueva edad del alumno. Debe ser superior a cero
   * @throws IllegalArgumentException Si la edad es menor o igual a cero
   */
  public void setEdad(int edad) {
    if (edad <= EDAD_MINIMA) {
      throw new IllegalArgumentException("La edad es menor o igual a cero");
    }
    this.edad = edad;
  }

  /**
   * Modifica si el alumno usa o no el servicio de comedor
   * @param usaComedor true si el alumno va a usar el servicio de comedor. false si no.
   */
  public void setUsaComedor(boolean usaComedor) {
    this.usaComedor = usaComedor;
  }

  /**
   * Modifica el curso que cursa el alumno
   * @param curso Nuevo curso que cursa el alumno. Debe ser uno de CURSO_1_BACH, CURSO_2_BACH,
   * CURSO_1_GS, CURSO_2_GS
   * @throws IllegalArgumentException Si el curso no es uno de los especificados 
   */
  public void setCurso(int curso) {
    if (curso != CURSO_1_BACH && curso != CURSO_2_BACH && curso != CURSO_1_GS
        && curso != CURSO_2_GS) {
      throw new IllegalArgumentException("El valor proporcionado de curso no es válido");
    }
    this.curso = curso;
  }

  @Override
  public String toString() {
    return String.format("%s", nombre);
  }
  
  
  
}
