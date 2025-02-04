package prog.ud05.actividad511.coleccion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente implements Comparable<Cliente> {
  // Pendiente de revisar
  // DNI METODO VALIDAR
  // COMPARE
  // EDAD
  //NO PRUEBAS.

  /**
   * Atributos de la clase
   */
  private String nombre;
  private String apellidos;
  private String dni;
  private static int edad;

  /**
   * Constructor
   * 
   * @param nombre-   Nombre de pila de la persona. No puede ser null o vacío o
   *                  contener sólo espacios
   * @param apellidos - Apellidos de la persona. No puede ser null o vacío o
   *                  contener sólo espacios
   * @param dni-      DNI de la persona. No puede ser null y debe constar de 8
   *                  números y una letra. La letra debe ser mayúscula y válida
   *                  según las normas del DNI
   * @param edad-     Edad de la persona. Debe ser 0 ó superior
   * @throws NullPointerException     - Si alguno de los parámetros es null
   * @throws IllegalArgumentException - Si alguno de los parámetros no es correcto
   * @author Zamira
   */
  public Cliente(String nombre, String apellidos, String dni, int edad) {
    // Constructor de cliente.
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.dni = dni;
    this.edad = edad;
  }

  /**
   * Obtiene el nombre de pila del cliente
   * 
   * @return Nombre de pila del cliente
   */
  public String getNombre() {
    // Obtiene nombre y verifica si es valido
    validaCadena(nombre);
    return nombre;

  }

  /**
   * Obtiene los apellidos del cliente
   * 
   * @return Apellidos del cliente
   */
  public String getApellidos() {
    // Obtiene apellidos si es valido
    validaCadena(apellidos);
    return null;

  }

  /**
   * Obtiene el DNI del cliente
   * 
   * @return DNI del cliente
   */
  public String getDni() {
    verificaDni(dni);
    return null;

  }

  /**
   * Obtiene la edad del cliente
   * 
   * @return Edad del cliente
   */
  public int getEdad() {
    verificaEdad(edad);
    return edad;

  }

  @Override
  // Sirve para ordenar. Segun el apellido Devuelve un entero.
  public int compareTo(Cliente o) {
    return 0;
  }

  /**
   * METODOS PRIVADOS
   */

  /**
   * Valida si nombre es valido
   * 
   * @param cadena
   * @throws NullPointerException     Si nombre es null
   * @throws IllegalArgumentException Si nombre tiene espacios en blanco o esta
   *                                  vacio
   */
  private String validaCadena(String cadena) {
    // Debe validar nombre
    // Revisar si los metodos isBlank y isEmpty se podian usar
    if (cadena != null && !cadena.isBlank() && !cadena.isEmpty()) {
      return cadena;
    } else if (cadena == null) { // Si es null devuelve esta excepcion
      throw new NullPointerException("La cadena es invalida. NULL");
    } else { // Si es otra de las dos devuelve esta
      throw new IllegalArgumentException("La cadena es invalida. ESPACIO BLANCO//ESTA VACIA");
    }
  }

  /**
   * Valida dni
   * 
   * @param dni
   * @return devuelve un dni valido
   * @throws IllegalArgumentException Si es invalido
   */
  private String verificaDni(String dni) {
    // Evalua con expresiones regulares si dni es valido
    Pattern verificador = Pattern.compile("[0-9]{7,8}[A-Z]");
    Matcher verificado = verificador.matcher(dni);
    // Revisar si se podia usar y si era de MatchResult
    if (verificado.hasMatch()) {
      return dni;
    } else {
      throw new IllegalArgumentException("dni invalido.");
    }
  }

  /**
   * Valida edad
   * 
   * @param edad
   * @return IllegalArgumentException Si es invalido
   */
  private int verificaEdad(int edad) {
    // Ver si habia alguna especificacion de limite edad
    if (edad < 0 && edad > 99) {
      return edad;
    } else {
      throw new IllegalArgumentException("edad invalida");
    }
  }
}
