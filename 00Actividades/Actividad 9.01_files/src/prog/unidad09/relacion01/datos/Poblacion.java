package prog.unidad09.relacion01.datos;

/**
 * Clase de datos de una población. Solo datos
 */
public class Poblacion {
  
  // Codigo de la población (5 dígitos)
  private String codigo;
  // Nombre
  private String nombre;
  // Extensión en km.
  private double extension;
  // Población total. Debe ser igual a la de hombres + la de mujeres
  private int poblacionTotal;
  // Población sólo de hombres
  private int poblacionHombres;
  // Población sólo de mujeres
  private int poblacionMujeres;
  // Número de vehiculos matriculados en la población
  private int vehiculos;
  // Número de líneas telefónicas fijas disponibles en la población
  private int lineasTelefonicas;

  /**
   * Constructor con todos los  datos
   * @param codigo
   * @param nombre
   * @param extension
   * @param poblacionTotal
   * @param poblacionHombres
   * @param poblacionMujeres
   * @param vehiculos
   * @param lineasTelefonicas
   */
  public Poblacion(String codigo, String nombre, double extension, int poblacionTotal,
      int poblacionHombres, int poblacionMujeres, int vehiculos, int lineasTelefonicas) {
    this.codigo = codigo;
    this.nombre = nombre;
    this.extension = extension;
    this.poblacionTotal = poblacionTotal;
    this.poblacionHombres = poblacionHombres;
    this.poblacionMujeres = poblacionMujeres;
    this.vehiculos = vehiculos;
    this.lineasTelefonicas = lineasTelefonicas;
  }

  /**
   * Modifica el código
   * @param codigo
   */
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  /**
   * Modifica el nombre
   * @param nombre
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * Modifica la extensión
   * @param extension
   */
  public void setExtension(double extension) {
    this.extension = extension;
  }

  /**
   * Modifica el número de hombres de la población. Actualiza también la población total
   * @param poblacionHombres
   */
  public void setPoblacionHombres(int poblacionHombres) {
    this.poblacionHombres = poblacionHombres;
    // Actualiza también la población total
    this.poblacionTotal = this.poblacionHombres + this.poblacionMujeres;
  }

  /**
   * Modifica el número de mujeres de la población. Actualiza también la población total
   * @param poblacionMujeres
   */
  public void setPoblacionMujeres(int poblacionMujeres) {
    this.poblacionMujeres = poblacionMujeres;
    // Actualiza también la población total
    this.poblacionTotal = this.poblacionHombres + this.poblacionMujeres;
  }

  /**
   * Modifica el número de vehiculos
   * @param vehiculos
   */
  public void setVehiculos(int vehiculos) {
    this.vehiculos = vehiculos;
  }

  /**
   * Modifica el número de líneas telefónicas
   * @param lineasTelefonicas
   */
  public void setLineasTelefonicas(int lineasTelefonicas) {
    this.lineasTelefonicas = lineasTelefonicas;
  }

  /**
   * Obtiene el código
   * @return
   */
  public String getCodigo() {
    return codigo;
  }

  /**
   * Obtiene el nombre
   * @return
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Obtiene la extensión
   * @return
   */
  public double getExtension() {
    return extension;
  }

  /**
   * Obtiene la población total
   * @return
   */
  public int getPoblacionTotal() {
    return poblacionTotal;
  }

  /**
   * Obtiene la población de hombres
   * @return
   */
  public int getPoblacionHombres() {
    return poblacionHombres;
  }

  /**
   * Obtiene la población de mujeres
   * @return
   */
  public int getPoblacionMujeres() {
    return poblacionMujeres;
  }

  /**
   * Obtiene el número de vehiculos
   * @return
   */
  public int getVehiculos() {
    return vehiculos;
  }

  /**
   * Obtiene el número de lineas telefónicas
   * @return
   */
  public int getLineasTelefonicas() {
    return lineasTelefonicas;
  }

}
