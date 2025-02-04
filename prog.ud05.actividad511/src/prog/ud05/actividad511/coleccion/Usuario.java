package prog.ud05.actividad511.coleccion;

import java.util.List;

public class Usuario {

  // PENDIENTE DE REVISAR LA CLASE
  // NO PRUEBAS.

  /**
   * Atributos de la clase
   */
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
    this.nombreUsuario = nombreUsuario;
    this.nombreCompleto = nombreCompleto;
    this.tarjeta = tarjeta;
    this.clientes = clientes;
  }

  /**
   * Devuelve el nombre de usuario del usuario
   * 
   * @return Nombre de Usuario del usuario
   */
  public String getNombreUsuario() {
    validaNombreUsuario(nombreUsuario);
    return nombreUsuario;
  }

  /**
   * Obtiene el nombre y apellidos del usuario
   * 
   * @return Nombre y apellidos del usuario
   */
  public String getNombreCompleto() {
    validaNombreCompleto(nombreCompleto);
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
   * METODOS PRIVADOS
   */

  /**
   * Valida nombre de usuario
   * 
   * @param nombreUsuario
   */
  private String validaNombreUsuario(String nombreUsuario) {
    return nombreUsuario;
  }

  private String validaNombreCompleto(String nombreCompleto) {
    if (nombreCompleto != null && !nombreCompleto.isEmpty()) {
      return nombreCompleto;
    } else if (nombreCompleto == null) {
      throw new NullPointerException("El nombre es invalido. NULL");
    } else {
      throw new IllegalArgumentException("El nombre es invalido.ESTA VACIA");
    }
  }
}
