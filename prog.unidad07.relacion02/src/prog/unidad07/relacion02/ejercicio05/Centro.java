package prog.unidad07.relacion02.ejercicio05;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa al centro educativo
 */
public class Centro {

  // Atributos
  // Colección de personas
  private Map<String, Persona> personas;
  
  /***
   * Constructor. Crea el centro vacío, sin personas
   */
  public Centro() {
    // Crea el mapa
    personas = new HashMap<>();
  }
  
  /**
   * Da de alta una persona
   * @param persona Persona a dar de alta. Si existe una persona con el mismo DNI la sobreescribe
   */
  public void alta(Persona persona) {
    personas.put(persona.getDni(), persona);
  }

  /**
   * Da de baja a una persona en el centro
   * @param dni DNI de la persona a dar de baja. Si está dada de alta se eliminará. Si no lo
   *   está no se hace nada
   */
  public void baja(String dni) {
    // Lo da de baja en el mapa
    personas.remove(dni);
  }
  
  /**
   * Imprime todas las personas relacionadas con el centro por pantalla
   */
  public void imprimir() {
    // Para cada persona
    System.out.println("Personas");
    System.out.println("---------");
    for (Persona persona: personas.values()) {
      // Lo imprime
      System.out.println(persona);
    }
  }

  /**
   * Imprime la nomina del centro
   */
  public void imprimirNomina() {
    // Cabecera
    System.out.println("Nomina");
    System.out.println("------");
    // Para cada persona
    for (Persona persona: personas.values()) {
      // Si es un empleado
      if (persona instanceof Empleado) {
        // Lo "convertimos"
        Empleado empleado = (Empleado)persona;
        // Lo imprime
        System.out.printf("%s: %.2f%n", empleado.getNombre(), empleado.getSalario());
      }
    }
  }
}
