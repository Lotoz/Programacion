package prog.ud08.actividad803.modelo;

/**
 * Cliente Data Object
 */
public class Cliente {

  // Atributos
  // NIF del cliente
  private String nif;
  // Nombre del cliente
  private String nombre;
  // Apellidos
  private String apellidos;
  // Direccion
  private String direccion;
  // NIF del cliente que lo recomendo
  private String nifRecomendado;
  
  
  /**
   * Consstructor con todos los campos
   * @param nif NIF del cliente. No puede ser vacío o tener todo blancos
   * @param nombre Nombre del cliente No puede ser vacio o tener todo blancos
   * @param apellidos Apellidos del cliente No puede ser vacio o tener todo blancos
   * @param direccion Direccion del cliente. No puede ser vacío o tener todo blancos
   * @param nifRecomendado NIF del cliente que recomendó a este. Puede ser null o si tiene contenido
   *   no puede ser vacío o todo blancos
   * @throws IllegalArgumentException Si alguno de los campos no cumple las condiciones
   */
  public Cliente(String nif, String nombre, String apellidos, String direccion,
      String nifRecomendado) {
    // Si ninguno de los campos está en blanco
    if (!nif.isBlank() && !nombre.isBlank() && !apellidos.isBlank() && !direccion.isBlank()) {
      // Los almacena
      this.nif = nif;
      this.nombre = nombre;
      this.apellidos = apellidos;
      this.direccion = direccion;
    } else {
      // Si alguno está en blanco lanza excepcion
      throw new IllegalArgumentException("Alguno de los campos era vacío o tenía todo blancos");
    }
    // El NIF recomendado debe ser nulo o no ser blanco
    if (nifRecomendado == null || !nifRecomendado.isBlank()) {
      // Si es correcto lo guarda
      this.nifRecomendado = nifRecomendado;
    } else {
      // Si no lanza excepcion
      throw new IllegalArgumentException("El campo NIF recomendado debe ser null o contener algo que no sean blancos");
    }
  }
  
  /**
   * Obtiene el NIF
   * @return NIF
   */
  public String getNif() {
    return nif;
  }
  
  /**
   * Obtiene el nombre
   * @return Nombre
   */
  public String getNombre() {
    return nombre;
  }
  
  /**
   * Obtiene los apellidos
   * @return Apellidos
   */
  public String getApellidos() {
    return apellidos;
  }
  
  /**
   * Obtiene la direccion
   * @return Direccion
   */
  public String getDireccion() {
    return direccion;
  }
  
  /**
   * Obtiene el NIF del cliente que recomendo
   * @return NIF del cliente que recomendó a éste o null si no lo recomendó nadie
   */
  public String getNifRecomendado() {
    return nifRecomendado;
  }
}
