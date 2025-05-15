package prog.ud09.actividad903.comandos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import prog.common.consola.Consola;
import prog.common.ui.Comando;
import prog.ud09.actividad903.database.BaseDatosTienda;
import prog.ud09.actividad903.database.ProcesadorVenta;
import prog.unidad09.relacion03.datos.Venta;

/**
 * Comando para listar las ventas
 */
public class ComandoListVentas extends Comando<BaseDatosTienda> {

  // Procesador de Listados
  ProcesadorListadoVentas procesadorListados;
  
  /**
   * Constructor
   * @param titulo Titulo del comando
   */
  public ComandoListVentas(String titulo, ProcesadorListadoVentas procesadorListados) {
    super(titulo);
    this.procesadorListados = procesadorListados;
  }

  /**
   * Procesa el comando. Lista todas las ventas
   */
  @Override
  public void hacer(Consola consola, BaseDatosTienda modelo) {
    // Mostramos cabecera de comando
    consola.imprimeTitulo(getTitulo().toUpperCase());
    
    // Solicitamos todas las ventas
    List<Venta> ventas = new ArrayList<>();
    
    modelo.getAllVentas(new ProcesadorVenta() {
      @Override
      public void procesaVenta(Venta venta) {
        ventas.add(venta);
      }
    });
    
    // Si hay ventas
    if (ventas.size() > 0) {
      // Ordenamos la lista por fecha en orden descendente. Si las fechas son
      // iguales intentamos por apellido ascendente. Si los apellidos también
      // son iguales ordenamos por nombre asendente
      ventas.sort(new Comparator<Venta>() {
        @Override
        public int compare(Venta o1, Venta o2) {
          // Hacemos la comparación por fecha (descendente)
          int diferencia = o2.getFecha().compareTo(o1.getFecha());
          // Si las fechas no son iguales
          if (diferencia != 0) {
            // Devolvemos el resultado de la comparación
            return diferencia;
          }
          // Si estamos aqui es porque las fechas son iguales
          // Comparamos por apellidos, ascendente
          diferencia = o1.getCliente().getApellidos().compareTo(o2.getCliente().getApellidos());
          // Si los apellidos son distintos
          if (diferencia != 0) {
            // Devolvemos el resultado de la comparación
            return diferencia;
          }
          // Si llegamos aqui es porque tanto la fecha como los apellidos son
          // iguales.
          // En este caso comparamos por nombre ascendente y devolvemos
          // directamente el resultado. Si son iguales ya se apañará el
          // algoritmo de ordenación
          return o1.getCliente().getNombre().compareTo(o2.getCliente().getNombre());
        }
      });
      
      // Imprimimos la cabecera empleando el procesador de listados
      procesadorListados.imprimeCabecera(consola);
      
      // Y las ventas, una a una
      for (Venta venta: ventas) {
        // Imprimimos la línea correspondiente a la venta empleando el
        // procesador de listados
        procesadorListados.imprimeLinea(consola, venta);
      }
    } else {
      // No hay ventas
      consola.imprimeLinea("No hay ventas");
    }
  }
}
