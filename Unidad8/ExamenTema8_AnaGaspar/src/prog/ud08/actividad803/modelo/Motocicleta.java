package prog.ud08.actividad803.modelo;

/**
 * Motocicleta Data Object
 */
public class Motocicleta {

  // Atributos
  // Referencia
  private String referencia;
  // Cilindrada
  private int cilindrada;
  // Tipo
  private String tipo;
  // Precio
  private double precio;
  // Fabricante
  private String fabricante;

  /**
   * Constructor con todos los datos
   * @param referencia Referencia única de la motocicleta. No puede ser blanco
   * @param cilindrada Cilindrada en CC de la motocicleta. Debe ser positiva
   * @param tipo Tipo de la motocicleta (cross, deportiva, etc.). No puede ser blanco
   * @param precio Precio de la motocicleta. Debe ser positivo
   * @param fabricante Nombre del fabricante de la motocicleta. No puede ser blanco
   * @throws IllegalArgumentException Si alguno de los campos no cumple las condiciones
   */
  public Motocicleta(String referencia, int cilindrada, String tipo, double precio,
      String fabricante) {
    // Comprobamos los campos
    if (!referencia.isBlank() && cilindrada >= 0 && !tipo.isBlank() && precio >= 0 && !fabricante.isBlank()) {
      // Si todos son correctos los almacenamos
      this.referencia = referencia;
      this.cilindrada = cilindrada;
      this.tipo = tipo;
      this.precio = precio;
      this.fabricante = fabricante;
    } else {
      // Si alguno no es correcto lanzamos excepcion
      throw new IllegalArgumentException("Alguno de los valores proporcionados no es correcto");
    }
  }

  /**
   * Obtiene la referencia
   * @return Referencia
   */
  public String getReferencia() {
    return referencia;
  }

  /**
   * Obtiene la cilindrada
   * @return Cilindrada
   */
  public int getCilindrada() {
    return cilindrada;
  }

  /**
   * Obtiene el tipo
   * @return Tipo
   */
  public String getTipo() {
    return tipo;
  }

  /**
   * Obtiene el precio
   * @return Precio
   */
  public double getPrecio() {
    return precio;
  }

  /**
   * Obtiene el fabricante
   * @return Fabricante
   */
  public String getFabricante() {
    return fabricante;
  }
}

