package prog.unidad07.relacion02.ejercicio03;

/**
 * Persona asociada al centro
 */
public abstract class Persona {

  // Atributos
  // Nombre completo
  protected String nombre;
  // DNI
  protected String dni;
  // Estado civil
  protected String estadoCivil;
  
  /**
   * Constructor
   * @param nombre Nombre y apellidos de la persona
   * @param dni DNI de la persona
   * @param estadoCivil Estado civil de la persona
   */
  protected Persona(String nombre, String dni, String estadoCivil) {
    this.nombre = nombre;
    this.dni = dni;
    this.estadoCivil = estadoCivil;
  }
  
  /**
   * Modifica el estado civil de la persona
   * @param nuevoEstadoCivil Nuevo estado civil
   */
  public void setEstadoCivil(String nuevoEstadoCivil) {
    estadoCivil = nuevoEstadoCivil;
  }
  
  /**
   * Obtiene el DNI de la persona
   * @return DNI de la persona
   */
  public String getDni() {
    return dni;
  }

  @Override
  public String toString() {
    return String.format("Nombre: \"%s\", DNI: %s, Estado Civil: \"%s\"", nombre, dni, estadoCivil);
  }
}
