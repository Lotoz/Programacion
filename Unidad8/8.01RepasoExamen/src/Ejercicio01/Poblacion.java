package Ejercicio01;

/**
 * Representa una poblacion
 */
public class Poblacion {

  /**
   * El codigo de una poblacion
   */
  private String codigo;
  
  /**
   * El nombre de la poblacion
   */
  private String nombrePoblacion;
  
  /**
   * La extension de la poblacion
   */
  private double extension;
  
  /**
   * Los hombres de una poblacion
   */
  private int hombres;
  
  /**
   * Las mujeres de una poblacion
   */
  private int mujeres;
  
  /**
   * Los vehiculos de una poblacion
   */
  private int vehiculos;
  
  /**
   * Los telefonos de una poblacion
   */
  private int telefonos;

  public Poblacion(String codigo, String nombrePoblacion, double extension, int hombres, int mujeres, int vehiculos,
      int telefonos) {
    this.codigo = codigo;
    this.nombrePoblacion = nombrePoblacion;
    this.extension = extension;
    this.hombres = hombres;
    this.mujeres = mujeres;
    this.vehiculos = vehiculos;
    this.telefonos = telefonos;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getNombrePoblacion() {
    return nombrePoblacion;
  }

  public void setNombrePoblacion(String nombrePoblacion) {
    this.nombrePoblacion = nombrePoblacion;
  }

  public double getExtension() {
    return extension;
  }

  public void setExtension(double extension) {
    this.extension = extension;
  }

  public int getHombres() {
    return hombres;
  }

  public void setHombres(int hombres) {
    this.hombres = hombres;
  }

  public int getMujeres() {
    return mujeres;
  }

  public void setMujeres(int mujeres) {
    this.mujeres = mujeres;
  }
 
  public int getPoblacionTotal() {
    return getHombres() + getMujeres();
  }

  public int getVehiculos() {
    return vehiculos;
  }

  public void setVehiculos(int vehiculos) {
    this.vehiculos = vehiculos;
  }

  public int getTelefonos() {
    return telefonos;
  }

  public void setTelefonos(int telefonos) {
    this.telefonos = telefonos;
  }
}
