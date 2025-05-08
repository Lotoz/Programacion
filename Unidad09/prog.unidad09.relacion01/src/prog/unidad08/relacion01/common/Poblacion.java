package prog.unidad08.relacion01.common;

/**
 * Representa a una población en la base de datos
 */
public class Poblacion {

  // Atributos
  // Código de la poblacióm
  private String codigo;
  // Nombre de la población
  private String nombre;
  // Extensión en km2
  private double extension;
  // Número de hombres que habitan el pueblo
  private int poblacionHombres;
  // Número de mujeres que habitan el pueblo
  private int poblacionMujeres;
  // Número de vehículos del pueblo
  private int vehiculos;
  // Número de líneas telefónicas en el pueblo
  private int lineasTelefonicas;

  /**
   * Constructor
   * @param codigo Código de pueblo. No puede ser null y su longitud debe ser de 5 caracteres.
   * @param nombre Nombre del pueblo
   * @param extension. Extensión del pueblo
   * @param poblacionHombres Número de hombres que habitan el pueblo
   * @param poblacionMujeres Número de mujeres que habitan el pueblo
   * @param vehiculos Número de vehículos que hay en el pueblo
   * @param lineasTelefonicas Número de líneas telefónicas que hay en el pueblo
   */
  public Poblacion(String codigo, String nombre, double extension,
      int poblacionHombres, int poblacionMujeres, int vehiculos, int lineasTelefonicas) {
    setCodigo(codigo);
    setNombre(nombre);
    setExtension(extension);
    setPoblacionHombres(poblacionHombres);
    setPoblacionMujeres(poblacionMujeres);
    setVehiculos(vehiculos);
    setLineasTelefonicas(lineasTelefonicas);
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    if ((codigo == null) || (codigo.length() != 5)) {
      throw new IllegalArgumentException("Codigo debe ser de 5 caracteres");
    } else {
      this.codigo = codigo;
    }
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public double getExtension() {
    return extension;
  }

  public void setExtension(double extension) {
    this.extension = extension;
  }

  public int getPoblacionTotal() {
    return poblacionHombres + poblacionMujeres;
  }

  public int getPoblacionHombres() {
    return poblacionHombres;
  }

  public void setPoblacionHombres(int poblacionHombres) {
    this.poblacionHombres = poblacionHombres;
  }

  public int getPoblacionMujeres() {
    return poblacionMujeres;
  }

  public void setPoblacionMujeres(int poblacionMujeres) {
    this.poblacionMujeres = poblacionMujeres;
  }

  public int getVehiculos() {
    return vehiculos;
  }

  public void setVehiculos(int vehiculos) {
    this.vehiculos = vehiculos;
  }

  public int getLineasTelefonicas() {
    return lineasTelefonicas;
  }

  public void setLineasTelefonicas(int lineasTelefonicas) {
    this.lineasTelefonicas = lineasTelefonicas;
  }
}
