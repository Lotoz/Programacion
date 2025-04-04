package prog.unidad07.relacion02.ejercicio05;

import java.util.Scanner;

/**
 * Interfaz de usuario para dar de alta a un estudiante
 */
public class InterfazAltaEstudiante extends InterfazAltaPersona {

  /**
   * Constructor
   * @param descripcion Descripcion del interfaz
   * @param sc Scanner a usar para leer desde el teclado
   */
  protected InterfazAltaEstudiante(String descripcion, Scanner sc) {
    super(descripcion, sc);
  }

  @Override
  public Persona solicitaDatosPersona() {
    // Solicita los datos
    System.out.print("Introduzca el nombre del estudiante: ");
    String nombre = sc.nextLine();
    System.out.print("Introduzca el DNI del estudiante: ");
    String dni = sc.nextLine();
    System.out.print("Introduzca el estado civil del estudiante: ");
    String estadoCivil = sc.nextLine();
    System.out.print("Introduzca el curso en el que está matriculado el estudiante: ");
    String curso = sc.nextLine();
    
    // Devolvemos el estudiante
    return new Estudiante(nombre, dni, estadoCivil, curso);
  }
}
