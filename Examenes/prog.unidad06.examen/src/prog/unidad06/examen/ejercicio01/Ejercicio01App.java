package prog.unidad06.examen.ejercicio01;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import prog.unidad06.examen.ejercicio01.util.Empleado;
import prog.unidad06.examen.ejercicio01.util.Empleados;

/**
 * Se debe imprimir por pantalla empleados generados de forma aleatoria
 */
public class Ejercicio01App {

  // Atributo, lista de empleados

  public static void main(String[] args) {
    // Iniciamos la lista de empleados
    List<Empleado> listaEmpleados = new ArrayList<Empleado>();

    // Iniciamos el generador de empleados
    Empleados empleado = new Empleados();
    empleado.reiniciar();

    //Ciclo para guardar empleados hasta que encuentre el siguiente null
    do {
      //Este if esta por error que guardaba un empleado null
      if (empleado.siguiente() != null) { 
        listaEmpleados.add(empleado.siguiente());
      }
    } while (empleado.siguiente() != null);

    //Cabezal
    System.out.println("LISTADO DE EMPLEADOS");

    System.out.printf("%s" + "%27s" + "%13s" + "%6s" + "%8s %n", "DNI", "APELLIDOS,NOMBRE", "ED", "SAL.", "EC");
    System.out.println("---------------------------------------------------------------");

    // Para cada empleado
    for (Empleado persona : listaEmpleados) {
      String apellidosNombre = persona.getApellidos() + " " + persona.getNombre();
      System.out.printf(Locale.US, "%9s %-30s %2d %4.4f  %b %n", persona.getDni(), apellidosNombre, persona.getEdad(),
          persona.getSalario(), persona.isCasado());
    }

  }

}
