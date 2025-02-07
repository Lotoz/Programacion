package prog.ud05.actividad511.coleccion;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase que representa a un Usuario Un Usuario tiene un identificador único, un
 * nombre completo, una tarjeta de claves y una lista de clientes
 */
public class Usuario {

  // Atributos de la clase
  private String nombreUsuario;
  private String nombreCompleto;
  private TarjetaClaves tarjeta;
  private List<Cliente> clientes;

  /**
   * Crea un usuario
   * 
   * @param nombreUsuario  - Nombre de usuario único del usuario. No puede ser
   *                       null y debe tener entre 2 y 8 caracteres alfanuméricos
   *                       MAYUSCULA O MINUSCULA, siendo el primero una letra.
   * @param nombreCompleto - Nombre y apellidos. No puede ser null ni vacío.
   * @param tarjeta        - Tarjeta de claves del usuario. No puede ser null
   * @param clientes-      Lista de clientes del usuario. No puede ser null aunque
   *                       puede estar vacía.
   * @throws NullPointerException    - Si alguno de los parámetros es null
   * @throws llegalArgumentException - Si alguno de los parámetros no es correcto
   * @author Zamira
   */
  public Usuario(String nombreUsuario, String nombreCompleto, TarjetaClaves tarjeta, List<Cliente> clientes) {
    // Valida si usuario puede generarse
    if (validaNombreCompleto(nombreCompleto) && validaNombreUsuario(nombreUsuario) && verificaTarjetaClave(tarjeta)
        && verificaListaCliente(clientes)) {
      this.nombreUsuario = nombreUsuario;
      this.nombreCompleto = nombreCompleto;
      this.tarjeta = tarjeta;
      this.clientes = clientes;
    }
  }

  /**
   * Devuelve el nombre de usuario del usuario
   * 
   * @return Nombre de Usuario del usuario
   */
  public String getNombreUsuario() {
    return nombreUsuario;
  }

  /**
   * Obtiene el nombre y apellidos del usuario
   * 
   * @return Nombre y apellidos del usuario
   */
  public String getNombreCompleto() {
    return nombreCompleto;
  }

  /**
   * Obtiene la tarjeta de coordenadas del usuario
   * 
   * @return Tarjeta de coordenadas del usuario
   */
  public TarjetaClaves getTarjeta() {
    return tarjeta;
  }

  /**
   * Obtiene la lista de clientes del usuario
   * 
   * @return Lista de clientes del usuario
   */
  public List<Cliente> getClientes() {
    return clientes;
  }

  /**
   * Valida nombre de usuario
   * 
   * @param nombreUsuario
   * @return true
   * @throws NullPointerException     si es null
   * @throws IllegalArgumentException si es invalido
   */
  private boolean validaNombreUsuario(String nombreUsuario) {
    // Valida el nombre de usuario usando expresiones regulares
    // Generamos la expresion regular
    Pattern validador = Pattern.compile("[a-zA-Z][a-zA-Z0-9]{1,7}");
    Matcher comprueba = validador.matcher(nombreUsuario);
    if (nombreUsuario == null) { // Validamos si es diferente de null si no, salta excepcion
      throw new NullPointerException("Nombre de usuario invalido. NULL");
    } else {
      if (comprueba.matches()) { // Validamos si cumple la expresion regular
        return true; // Si la cumple devuelve true
      } else {
        throw new IllegalArgumentException("Nombre de usuario invalido.VALIDACION NO CUMPLIDA");
      }
    }
  }

  /**
   * Valida si nombre es valido
   * 
   * @param nombreCompleto
   * @return true
   * @throws NullPointerException     si es null
   * @throws IllegalArgumentException si es invalido
   */
  private boolean validaNombreCompleto(String nombreCompleto) {
    // Valida si el nombre completo es invalido
    if (nombreCompleto == null) {
      throw new NullPointerException("El nombre es invalido. NULL");
    } else if (nombreCompleto.isEmpty()) {
      throw new IllegalArgumentException("El nombre es invalido.ESTA VACIA");
    }
    return true;
  }

  /**
   * 
   * @param cliente
   * @return true
   * @throws NullPointerException si la lista es null
   */
  private boolean verificaListaCliente(List<Cliente> cliente) {
    // Debe validar si lista clientes no es null
    if (cliente == null) {
      throw new NullPointerException("Lista invalida. NULL");
    }
    return true;
  }

  /**
   * Verifica si TarjetaClaves es valida
   * 
   * @param tarjeta
   * @return true
   * @throws NullPointerException si es null
   */
  private boolean verificaTarjetaClave(TarjetaClaves tarjeta) {
    // Debe verificar si tarjeta no es null
    if (tarjeta != null) {
      return true;
    } else {
      throw new NullPointerException("Lista invalida. NULL");
    }
  }

}
