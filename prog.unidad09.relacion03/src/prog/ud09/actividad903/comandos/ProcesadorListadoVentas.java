package prog.ud09.actividad903.comandos;

import prog.common.consola.Consola;
import prog.unidad09.relacion03.datos.Venta;

/**
 * Genera un listado de ventas por pantalla
 */
public interface ProcesadorListadoVentas {

  /**
   * Imprime la línea de cabecera del listado
   * @param consola Consola en la que se imprime la salida
   */
  void imprimeCabecera(Consola consola);
  
  /**
   * Imprime una línea del listado correspondiente a una venta
   * @param consola Consola en la que se imprime el listado
   * @param venta Venta de la que se quiere generar la línea
   */
  void imprimeLinea(Consola consola, Venta venta);
 
}
