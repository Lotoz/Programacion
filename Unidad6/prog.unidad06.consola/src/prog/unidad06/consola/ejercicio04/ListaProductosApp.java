package prog.unidad06.consola.ejercicio04;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Aplicación que lista productos
 */
public class ListaProductosApp {

  // Atributos
  // Lista de productos
  List<Producto> productos;
  
  /**
   * Construvtor
   * Inicia la lista de productos
   */
  private ListaProductosApp () {
    productos = new ArrayList<>();
    productos.add(new Producto(1, "Frigorífico américano", 897.88));
    productos.add(new Producto(103, "Mesa cocina", 329.65));
    productos.add(new Producto(1456, "Estantería 180cm.", 269.43));
    productos.add(new Producto(43, "Cafetera Dolce Musto", 49.99));
  }

  /**
   * Punto de entrada de la aplicación
   * @param args Argumentos de la aplicación
   */
  public static void main(String[] args) {
    // Crea un objeto de la clase y lo lanza
    ListaProductosApp app = new ListaProductosApp();
    app.run();
  }

  
  private void run() {
    // Mostramos la cabecera
    System.out.println("LISTADO DE PRODUCTOS");
    //System.out.println("COD.  NOMBRE                     PRECIO");
    System.out.printf("%-5s %-30s %10s%n", "COD.", "NOMBRE", "PRECIO");
    // Para cada producto
    for (Producto producto: productos) {
      System.out.printf(Locale.US,"%-5d %-30s %10.2f%n", producto.getCodigo(), producto.getNombre(), producto.getPrecioUnitario());
    }
  }

}
