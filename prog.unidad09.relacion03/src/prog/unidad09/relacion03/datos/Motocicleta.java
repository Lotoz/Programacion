/**
 * 
 */
package prog.unidad09.relacion03.datos;

/**
 * Motocicleta
 */
public class Motocicleta {

  // Atributos
  // Referencia
  private String referencia;
  // Cilindrada
  private int cilindrada;
  // Tipo de motocicleta
  private String tipo;
  // Precio
  private double precio;
  // Fabricante
  private String fabricante;

  /**
   * Constructor con toda la información.
   * @param referencia Referencia única de la motocicleta
   * @param cilindrada Cilindrada de la motocicleta, en c.c.
   * @param tipo Tipo de motocicleta (cross, carretera, etc.)
   * @param precio Precio de la motocicleta, en euros
   * @param fabricante Fabricante de la motocicleta
   */
  public Motocicleta(String referencia, int cilindrada, String tipo, double precio,
      String fabricante) {
    setReferencia(referencia);
    setCilindrada(cilindrada);
    setTipo(tipo);
    setPrecio(precio);
    setFabricante(fabricante);
  }

  /**
   * Obtiene la referencia
   * @return Referencia
   */
  public String getReferencia() {
    return referencia;
  }

  /**
   * Modifica la referencia
   * @param referencia Nueva referencia
   */
  public void setReferencia(String referencia) {
    // Lo almacena
    this.referencia = referencia;
  }

  /**
   * Obtiene la cilindrada
   * @return Cilindrada
   */
  public int getCilindrada() {
    return cilindrada;
  }

  /**
   * Modifica la cilindrada
   * @param cilindrada Nueva cilindrada
   */
  public void setCilindrada(int cilindrada) {
    this.cilindrada = cilindrada;
  }

  /**
   * Obtiene el tipo
   * @return Tipo (cross, carretera, etc.)
   */
  public String getTipo() {
    return tipo;
  }

  /**
   * Modifica el tipo de la motocicleta
   * @param tipo Nuevo tipo
   */
  public void setTipo(String tipo) {
    // Lo almacena
    this.tipo = tipo;
  }

  /**
   * Obtiene el precio
   * @return Precio
   */
  public double getPrecio() {
    return precio;
  }

  /**
   * Modifica el precio
   * @param precio Nuevo precio
   */
  public void setPrecio(double precio) {
    this.precio = precio;
  }

  /**
   * Obtiene el fabricante
   * @return Fabricante
   */
  public String getFabricante() {
    return fabricante;
  }

  /**
   * Modifica el fabricante
   * @param fabricante Nuevo fabricante
   */
  public void setFabricante(String fabricante) {
    // Lo almacena
    this.fabricante = fabricante;
  }
}
