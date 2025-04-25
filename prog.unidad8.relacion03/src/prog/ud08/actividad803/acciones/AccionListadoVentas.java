package prog.ud08.actividad803.acciones;

import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import prog.common.app.consola.AplicacionConsola;
import prog.common.app.consola.Consola;
import prog.ud08.actividad803.data.ServicioAccesoDatosException;
import prog.ud08.actividad803.data.VisitadorVentas;
import prog.ud08.actividad803.modelo.Venta;

/**
 * Accion para listar las ventas
 */
public class AccionListadoVentas extends AccionBase {

  /**
   * Constructor con titulo
   * @param titulo Titulo de la acción
   */
  public AccionListadoVentas(String titulo) {
    super(titulo);
  }

  @Override
  public void ejecutar() {
    // Accedemos a la consola
    Consola consola = Consola.getConsola();
    
    // Titulo
    imprimeTitulo();
    
    // Aqui se almacenan las lineas del listado
    List<String> lineas = new ArrayList<>();
    
    try {
      // Consultar las ventas
      // Para ellos llamamos a getAllVentas y le pasamos este Visitador que toma cada fila, genera
      // la línea de texto con los datos de dicha fila y la añade a la lista
      getServicioAccesoDatos().getAllVentas(new VisitadorVentas() {
        
        @Override
        public boolean visitaFila(ResultSet resultado) {
          try {
            // Formatea la linea con los datos de la fila y la almacena

            // TODO: AÑADE LAS LÍNEAS DE CÓDIGO QUE NECESITES PARA AÑADIR A LA LISTA lineas UNA
            // CADENA CON LA LÍNEA DEL LISTADO CORRESPONDIENTE A LA FILA EN EL RESULTSET
            // Ejecuta la consulta
           
            // Seguimos procesando
            return true;
          } catch (SQLException e) {
            // En caso de excepción, para inmediatamente
            return false;
          }
        }
      });
    } catch (ServicioAccesoDatosException e) {
      // Si Hay algún error muestra mensaje
      consola.escribeLinea("Error accediendo al listado de ventas");
    }

    // Si la lista no está vacía (había ventas)
    if (!lineas.isEmpty()) {
      // Imprime la cabecera
      consola.escribeLinea("NIF       Apellidos,Nombre               Referencia      Fabricante          Cilind.  Precio   Fecha Venta");
      // Y cada línea
      for (String linea: lineas) {
        consola.escribeLinea(linea);
      }
    } else {
      // No hay ventas. Escribe mensaje
      consola.escribeLinea("No hay ventas");
    }
    
  }

}
