package prog.unidad04.actividad402.ejercicio03.pruebas;

import java.util.Locale;
import prog.unidad04.actividad402.ejercicio03.Persona;

public class PruebaPersona {

  public static void main(String[] args) {
    
    // Cabecera
    System.out.println("PERSONAS");
    
    // Creamos una por defecto, otra con pocos y otra con muchos parámetros
    Persona persona1 = new Persona();
    Persona persona2 = new Persona("Paco", 17, 'H');
    Persona persona3 = new Persona("Paqui", 26, 'M', 76.6, 1.67);
    
    // Imprimimos las tres personas
    System.out.println("Imprimimos las tres personas");
    System.out.println(persona1);
    System.out.println(persona2);
    System.out.println(persona3);
    
    // Imprimimos los IMCs de las tres personas
    System.out.println("Imprimimos los IMCs de las tres personas");
    System.out.printf(Locale.US, "IMC Persona 1 = %f%n", persona1.getIMC());
    System.out.printf(Locale.US, "IMC Persona 2 = %f%n", persona2.getIMC());
    System.out.printf(Locale.US, "IMC Persona 3 = %f%n", persona3.getIMC());

    // Imprimimos si los pesos son correctos
    System.out.println("Imprimimos si los pesos de las personas es correcto o no");
    System.out.printf("Peso correcto Persona 1 = %d%n", persona1.getPesoCorrecto());
    System.out.printf("Peso correcto Persona 2 = %d%n", persona2.getPesoCorrecto());
    System.out.printf("Peso correcto Persona 3 = %d%n", persona3.getPesoCorrecto());

    // Imprimimos si las personas son o no mayores de edad
    System.out.println("Son las personas mayores de edad?");
    System.out.printf("Persona 1: %s%n", (persona1.esMayorDeEdad() ? "si" : "no"));
    System.out.printf("Persona 2: %s%n", (persona2.esMayorDeEdad() ? "si" : "no"));
    System.out.printf("Persona 3: %s%n", (persona3.esMayorDeEdad() ? "si" : "no"));
  }

}
