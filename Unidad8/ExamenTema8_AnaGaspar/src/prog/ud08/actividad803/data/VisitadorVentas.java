package prog.ud08.actividad803.data;

import java.sql.ResultSet;

/**
 * Visitador para cada fila de las ventas
 */
@FunctionalInterface
public interface VisitadorVentas {

  /**
   * Visita una fila del resultado
   * @param resultado Resultado de la consulta. Debe contener todas las columnas de todas las tablas
   * @return true si se debe seguir el proceso o false para abortar el listado
   */
  boolean visitaFila(ResultSet resultado);
}