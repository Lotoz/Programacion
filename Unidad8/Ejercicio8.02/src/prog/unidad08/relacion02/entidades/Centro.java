package prog.unidad08.relacion02.entidades;
/**
 * Centro de trabajo
 */
public class Centro {
  // Atributos
  // Codigo del centro
  private int codigo;
  // Nombre del centro
  private String nombre;
  
  /**
   * Constructor
   * @param codigo Código del centro
   * @param nombre Nombre del centro. No puede ser null ni vacío ni contener sólo blancos
   * @throws NullPointerException Si nombre es null
   * @throws IllegalArgumentException Si nombre es vacío o contiene sólo blancos
   */
  public Centro(int codigo, String nombre) {
    if (!nombre.isBlank()) {
      this.codigo = codigo;
      this.nombre = nombre;
    } else {
      throw new IllegalArgumentException("nombre no puede ser vacío o contener sólo blancos");
    }
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
}
