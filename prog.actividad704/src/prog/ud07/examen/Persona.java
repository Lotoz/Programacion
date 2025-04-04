package prog.ud07.examen;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Representa a una persona con sus caracteristicas basicas
 */
public abstract class Persona {

  // Atributos de la clase
  protected String nombre;
  protected String dni;

  /**
   * Constructor de una persona
   * 
   * @param nombre
   * @param dni
   */
  protected Persona(String nombre, String dni) {
    verificarCadena(nombre);
    verificarDni(dni);
    this.dni = dni;
    this.nombre = nombre;
  }

  /**
   * Obtiene nombre de persona
   * 
   * @return
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Obtiene un dni de una persona
   * 
   * @return
   */
  public String getDni() {
    return dni;
  }

  /**
   * Analiza si una cadena esta vacia o solo espacios blancos o si es nulo
   * @param cadena
   */
  protected void verificarCadena(String cadena) {
    if (cadena.isBlank()) {
      throw new IllegalArgumentException("Cadena invalida");
    }
  }

  /**
   * Verifica si un dni es valido
   * @param dni
   */
  protected void verificarDni(String dni) {
    //Si dni es nulo o vacio, o espacios blancos. Salta excepcion
    if (dni.isBlank()) {
      throw new IllegalArgumentException("Cadena invalida");
    }
    // Aquí se valida el formato del DNI
    Pattern verificador = Pattern.compile("[0-9]{8}[A-Z]");
    Matcher verificado = verificador.matcher(dni);

    // Verificamos si el verificado coincide con la expresion regular
    //Si no coincide, salta la excepcion (Solo verficamos que sean 8 numeros y una letra)
    if (!verificado.matches()) {
      throw new IllegalArgumentException("Dni invalido");
    }
  }
}
