package prog.unidad07.relacion02.ejercicio05;

import java.util.Scanner;

/**
 * Interfaz de usuario que solicita los datos de alta de una persona de administración y servicios
 */
public class InterfazAltaAdministracionServicios extends InterfazAltaPersona {

  /**
   * Constructor
   * @param descripcion Descripcion del interfaz
   * @param sc Scanner para acceder al teclado
   */
  public InterfazAltaAdministracionServicios(String descripcion, Scanner sc) {
    super(descripcion, sc);
  }

  @Override
  public Persona solicitaDatosPersona() {
    // Solicita los datos
    System.out.print("Introduzca el nombre del empleado: ");
    String nombre = sc.nextLine();
    System.out.print("Introduzca el DNI del empleado: ");
    String dni = sc.nextLine();
    System.out.print("Introduzca el estado civil del empleado: ");
    String estadoCivil = sc.nextLine();
    System.out.print("Introduzca el año en que se incorporó al centro el empleado: ");
    int anyoIncorporacion = Integer.parseInt(sc.nextLine());
    System.out.print("Introduzca el despacho asignado al empleado: ");
    String despacho = sc.nextLine();
    System.out.print("Introduzca la sección a la que está asignado el empleado: ");
    String seccion = sc.nextLine();
    System.out.print("Introduzca el número de horas mensuales que trabaja el empleado: ");
    int horas = Integer.parseInt(sc.nextLine());
    
    // Devolvemos el empleado de administración y servicios
    return new AdministracionServicios(nombre, dni, estadoCivil, anyoIncorporacion, despacho, seccion, horas);
  }

}
