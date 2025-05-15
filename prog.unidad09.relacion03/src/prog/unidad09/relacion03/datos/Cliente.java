package prog.unidad09.relacion03.datos;

/**
 * Cliente de la empresa
 */
public class Cliente {

  // Atributos
  // NIF único del cliente
  private String nif;
  // Nombre de pila
  private String nombre;
  // Apellidos
  private String apellidos;
  // Dirección postal
  private String direccion;
  // Cliente existente que recomendó a éste
  private Cliente recomendadoPor;

  /**
   * Contructor con toda la información 
   * @param nif NIF del cliente.
   * @param nombre Nombre de pila.
   * @param apellidos Apellidos.
   * @param direccion Dirección postal.
   * @param recomendadoPor Otro cliente que recomendo a éste.
   */
  public Cliente(String nif, String nombre, String apellidos, String direccion,
      Cliente recomendadoPor) {
    setNif(nif);
    setNombre(nombre);
    setApellidos(apellidos);
    setDireccion(direccion);
    setRecomendadoPor(recomendadoPor);
  }

  /**
   * Obtiene el NIF del cliente
   * @return nif del cliente
   */
  public String getNif() {
    return nif;
  }

  /**
   * Modifica el NIF
   * @param Nuevo nif.
   */
  public void setNif(String nif) {
    // Lo almacena
    this.nif = nif;
  }

  /**
   * Obtiene el nombre de pila
   * @return Nombre de pila
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Modifica el nombre de pila
   * @param nombre Nuevo nombre de pila
   */
  public void setNombre(String nombre) {
      // Lo almacena
      this.nombre = nombre;
  }

  /**
   * Obtiene los apellidos
   * @return Apellidos del cliente
   */
  public String getApellidos() {
    return apellidos;
  }

  /**
   * Modifica los apellidos
   * @param apellidos Nuevo valor de apellidos
   */
  public void setApellidos(String apellidos) {
    // Lo almacena
    this.apellidos = apellidos;
  }

  /**
   * Obtiene la dirección
   * @return Dirección del cliente
   */
  public String getDireccion() {
    return direccion;
  }

  /**
   * Modifica la dirección del cliente
   * @param direccion Nueva dirección del cliente
   */
  public void setDireccion(String direccion) {
    // Lo almacena
    this.direccion = direccion;
  }

  /**
   * Obtiene el cliente que recomendó a este
   * @return Cliente que recomendó a éste o null si no lo recomendó nadie
   */
  public Cliente getRecomendadoPor() {
    return recomendadoPor;
  }

  /**
   * Modifica el cliente que recomendó a éste
   * @param Nuevo cliente que recomendó a éste
   */
  public void setRecomendadoPor(Cliente recomendadoPor) {
    this.recomendadoPor = recomendadoPor;
  }
}
