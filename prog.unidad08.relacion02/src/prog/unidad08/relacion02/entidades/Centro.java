package prog.unidad08.relacion02.entidades;

/**
 * Centro de trabajo
 */
public class Centro {

  
  /**
   * Atributos de la clase
   */
  private int codigo;
  private String nombre;
  
  /**
   * Constructor
   * @param codigo
   * @param nombre
   * @throws NullPointerException - Si nombre es null
   * @throws IllegalArgumentException - Si nombre es vacío o contiene sólo blancos
   */
  public Centro(int codigo, String nombre) {
      validaCadena(nombre);
      this.codigo = codigo;
      this.nombre = nombre; 
  }

  /**
   * Obtiene el código del centro
   * @return Código del centro
   */
  public int getCodigo() {
    return codigo;
  }



  /**
   * Obtiene el nombre del centro
   * @return Nombre del centro
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Verifica cadena
   * @param cadena
   */
  private void validaCadena(String cadena) {
    if (cadena.isBlank()) {
      throw new IllegalArgumentException("Cadena no valida.");
    }
  }
}
