package prog.unidad07.relacion02.ejercicio02;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa al centro educativo
 */
public class Centro {

  // Atributos
  // Colección de estudiantes
  private Map<String, Estudiante> estudiantes;
  // Colección de profesores
  private Map<String, Profesor> profesores;
  // Colección de PAS
  private Map<String, AdministracionServicios> pas;
  
  /***
   * Constructor. Crea el centro vacío, sin personas
   */
  public Centro() {
    // Crea los mapas
    estudiantes = new HashMap<>();
    profesores = new HashMap<>();
    pas = new HashMap<>();
  }
  
  /**
   * Da de alta un estudiante
   * @param estudiante Estudiante a dar de alta. Si existe un estudiante con el mismo DNI lo sobreescribe
   */
  public void alta(Estudiante estudiante) {
    estudiantes.put(estudiante.getDni(), estudiante);
  }

  /**
   * Da de alta un profesor
   * @param profesor Profesor a dar de alta. Si existe un profesor con el mismo DNI lo sobreescribe
   */
  public void alta(Profesor profesor) {
    profesores.put(profesor.getDni(), profesor);
  }

  /**
   * Da de alta un empleado de administración y servicios
   * @param personal Persona de administración y servicios a dar de alta. Si existe una con el mismo DNI lo sobreescribe
   */
  public void alta(AdministracionServicios personal) {
    pas.put(personal.getDni(), personal);
  }
  
  /**
   * Da de baja a una persona en el centro
   * @param dni DNI de la persona a dar de baja. Si está dada de alta se eliminará. Si no lo
   *   está no se hace nada
   */
  public void baja(String dni) {
    // Lo da de baja en las tres colecciones (por si las moscas)
    estudiantes.remove(dni);
    profesores.remove(dni);
    pas.remove(dni);
  }
  
  /**
   * Imprime todas las personas relacionadas con el centro por pantalla
   */
  public void imprimir() {
    // Para cada estudiante
    System.out.println("Estudiantes");
    System.out.println("-----------");
    for (Estudiante estudiante: estudiantes.values()) {
      // Lo imprime
      System.out.println(estudiante);
    }

    // Para cada profesor
    System.out.println();
    System.out.println("Profesores");
    System.out.println("----------");
    for (Profesor profesor: profesores.values()) {
      // Lo imprime
      System.out.println(profesor);
    }

    // Para cada PAS
    System.out.println();
    System.out.println("Personal de Administración y Servicios");
    System.out.println("--------------------------------------");
    for (AdministracionServicios personal: pas.values()) {
      // Lo imprime
      System.out.println(personal);
    }

  }
}
