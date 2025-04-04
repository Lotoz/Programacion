package prog.unidad07.relacion02.ejercicio05;

import java.util.Scanner;

/**
 * Interfaz de usuario que da de alta a un profesor
 */
public class InterfazAltaProfesor extends InterfazAltaPersona {

  /**
   * Constructor
   * @param descripcion Descripcion del interfaz
   * @param sc Scanner a usar para leer desde el teclado
   */
  public InterfazAltaProfesor(String descripcion, Scanner sc) {
    super(descripcion, sc);
  }

  @Override
  public Persona solicitaDatosPersona() {
    // Solicita los datos
    System.out.print("Introduzca el nombre del profesor: ");
    String nombre = sc.nextLine();
    System.out.print("Introduzca el DNI del profesor: ");
    String dni = sc.nextLine();
    System.out.print("Introduzca el estado civil del profesor: ");
    String estadoCivil = sc.nextLine();
    System.out.print("Introduzca el año en que se incorporó al centro el profesor: ");
    int anyoIncorporacion = Integer.parseInt(sc.nextLine());
    System.out.print("Introduzca el despacho asignado al profesor: ");
    String despacho = sc.nextLine();
    System.out.print("Introduzca el departamento al que pertenece el profesor: ");
    String departamento = sc.nextLine();
    System.out.print("Introduzca el salario del profesor: ");
    double salario = Double.parseDouble(sc.nextLine());
    
    // Devolvemos el profesor
    return new Profesor(nombre, dni, estadoCivil, anyoIncorporacion, despacho, departamento, salario);
  }

}
