package prog.ud09.actividad903.database;

import prog.unidad09.relacion03.datos.Venta;

/**
 * Procesa ventas
 */
public interface ProcesadorVenta {

  /**
   * Procesa una venta
   * @param venta Venta a procesar
   */
  void procesaVenta(Venta venta);
}
