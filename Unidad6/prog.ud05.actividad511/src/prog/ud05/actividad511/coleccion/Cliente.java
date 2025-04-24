package prog.ud05.actividad511.coleccion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Un cliente de la empresa
 */
public class Cliente implements Comparable<Cliente> {

  //Atributos de la clase
  private String nombre;
  private String apellidos;
  private String dni;
  private int edad;

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
   */
  public Cliente(String nombre, String apellidos, String dni, int edad) {
    // Constructor de cliente.
    if (validaCadena(nombre) && validaCadena(apellidos) && verificaDni(dni) && verificaEdad(edad)) {
      this.nombre = nombre;
      this.apellidos = apellidos;
      this.dni = dni;
      this.edad = edad;
    }
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
    return apellidos;

  }

  /**
   * Obtiene el DNI del cliente
   * 
   * @return DNI del cliente
   */
  public String getDni() {
    return dni;
  }

  /**
   * Obtiene la edad del cliente
   * 
   * @return Edad del cliente
   */
  public int getEdad() {
    return edad;

  }

  @Override
  // Sirve para ordenar. Segun el apellido Devuelve un entero.
  public int compareTo(Cliente o) {
    return this.apellidos.compareTo(o.apellidos);
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
  private boolean validaCadena(String cadena) {
    // Revisar si los metodos isBlank y isEmpty se podian usar
    if (cadena == null) {
      throw new NullPointerException("La cadena es invalida. NULL");
    } else if (cadena.isBlank() || cadena.isEmpty()) {
      // Si es otra de las dos devuelve esta
      throw new IllegalArgumentException("La cadena es invalida. ESPACIO BLANCO//ESTA VACIA");
    }
    return true;
  }

  /**
   * Valida dni
   * 
   * @param dni
   * @return devuelve un dni valido
   * @throws IllegalArgumentException Si es invalido
   */
  private boolean verificaDni(String dni) {
    // Aquí se valida el formato del DNI
    Pattern verificador = Pattern.compile("[0-9]{8}[A-Z]");
    Matcher verificado = verificador.matcher(dni);
    
    //Verificamos si el verificado coincide con la expresion regular
    if (verificado.matches()) {
      //Si coincide comprobamos si la letra del dni es valida para sus numeros
      String numeroDni = dni.substring(0, 8);
      char letraDni = dni.charAt(8);

      if (letraDni != verificaLetraDni(numeroDni)) {
        //Si no lo es lanza excepcion
        throw new IllegalArgumentException("DNI inválido.");
      } else {
        return true;
      }
    } else {
      throw new IllegalArgumentException("DNI inválido.");
    }
  }

  private char verificaLetraDni(String dni) {
    int dniEnNumero = Integer.parseInt(dni);
    // Para calcular la letra
    int porcentaje = dniEnNumero % 23;
    // Obtiene el numero que debe verficar con su respectiva letra
    switch (porcentaje) {
    case 0:
      return 'T';
    case 1:
      return 'R';
    case 2:
      return 'W';
    case 3:
      return 'A';
    case 4:
      return 'G';
    case 5:
      return 'M';
    case 6:
      return 'Y';
    case 7:
      return 'F';
    case 8:
      return 'P';
    case 9:
      return 'D';
    case 10:
      return 'X';
    case 11:
      return 'B';
    case 12:
      return 'N';
    case 13:
      return 'J';
    case 14:
      return 'Z';
    case 15:
      return 'S';
    case 16:
      return 'Q';
    case 17:
      return 'V';
    case 18:
      return 'H';
    case 19:
      return 'L';
    case 20:
      return 'C';
    case 21:
      return 'K';
    case 22:
      return 'E';
    default:
      return 'A';
    }
  }

  /**
   * Valida edad
   * 
   * @param edad
   * @return IllegalArgumentException Si es invalido
   */
  private boolean verificaEdad(int edad) {
    // Verifica la edad
    if (edad < 0) {
      throw new IllegalArgumentException("edad invalida");
    } else {
      return true;
    }
  }
}
