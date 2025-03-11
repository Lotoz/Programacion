package prog.unidad06.consola.ejercicio04;

import java.util.Locale;

/**
 * Producto
 */
public class Producto {

  // Atributos
  // Código de producto
  private int codigo;
  // Nombre del producto
  private String nombre;
  // Precio de una unidad del producto
  private double precioUnitario;
  
  /**
   * Constructor con todos los valores
   * @param codigo Código del producto. Debe ser un número superior a cero
   * @param nombre Nombre del producto. No puede ser null ni vacío ni contener sólo blancos
   * @param precioUnitario Precio por unidad del producto. Debe ser superior a cero
   * @throws NullPointerException Si nombre es null
   * @throws IllegalArgumentException Si codigo es cero o menor, nombre está vacío o contiene sólo
   *   blancos o el precio unitario es cero o inferior.
   */
  public Producto(int codigo, String nombre, double precioUnitario) {
    if (nombre != null) {
      if (codigo > 0) {
        if (!nombre.isBlank()) {
          if (precioUnitario > 0) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.precioUnitario = precioUnitario;
          } else {
            throw new IllegalArgumentException("precioUnitario no puede ser cero o inferior");
          }
        } else {
          throw new IllegalArgumentException("El nombre está vacío o contiene sólo blancos");
        }
      } else {
        throw new IllegalArgumentException("El código no puede ser cero o inferior");
      }
    } else {
      throw new NullPointerException("nombre es null");
    }
  }

  /**
   * Obtiene el código
   * @return código del producto
   */
  public int getCodigo() {
    return codigo;
  }

  /**
   * Obtiene el nombre del producto
   * @return Nombre del producto
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Obtiene el precio unitario
   * @return Precio unitario
   */
  public double getPrecioUnitario() {
    return precioUnitario;
  }
}
