package prog.unidad07.relacion02.ejercicio05;

import java.util.Scanner;

/**
 * Clase que representa un interfaz de usuario para dar de alta un tipo de persona
 */
public abstract class InterfazAltaPersona {

  // Atributos
  // Descripcion del interfaz
  protected String descripcion;
  // Scanner para acceder al teclado
  protected Scanner sc;
  
  /**
   * Constructor
   * @param descripcion Descripcion del interfaz
   * @param sc Scanner a usar para leer desde teclado
   */
  protected InterfazAltaPersona(String descripcion, Scanner sc) {
    this.descripcion = descripcion;
    this.sc = sc;
  }
  
  /**
   * Obtiene la descripción del interfaz
   * @return
   */
  public String getDescripcion() {
    return descripcion;
  }
  
  /**
   * Solicita los datos de una persona
   * @return Persona leida (de una de las subclases de Persona)
   */
  public abstract Persona solicitaDatosPersona();
}
