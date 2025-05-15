package prog.ud08.actividad803;

import prog.common.app.consola.Accion;
import prog.common.app.consola.AplicacionConsolaPorMenu;
import prog.ud08.actividad803.acciones.AccionActualizacionCliente;
import prog.ud08.actividad803.acciones.AccionCrearMotocicleta;
import prog.ud08.actividad803.acciones.AccionEliminaMotocicleta;
import prog.ud08.actividad803.acciones.AccionListadoVentas;
import prog.ud08.actividad803.acciones.AccionRegistroVenta;
import prog.ud08.actividad803.data.ServicioAccesoDatos;
import prog.ud08.actividad803.data.impl.ServicioAccesoDatosSQLite;

/**
 * Aplicación de gestión de tienda de motocicletas
 */
public class GestionTiendaApp {
  // Constantes
  private static final String RUTA_DB = "db/tienda.db";

  /**
   * Punto de entrada a la aplicación
   * @param args Argumentos de la línea de comandos
   */
  public static void main(String[] args) {
    // Creamos una aplicacion de consola por menu
    AplicacionConsolaPorMenu app = new AplicacionConsolaPorMenu("Gestion Tienda Motocicletas");
    // Añadimos las acciones
    // Crear motocicleta
    Accion accion = new AccionCrearMotocicleta("Crear Motocicleta");
    accion.setAplicacion(app);
    app.addAccion(accion);
    // Registrar venta
    accion = new AccionRegistroVenta("Registrar Venta");
    accion.setAplicacion(app);
    app.addAccion(accion);
    // Listado de ventas
    accion = new AccionListadoVentas("Listado de ventas");
    accion.setAplicacion(app);
    app.addAccion(accion);
    // Actualización de cliente
    accion = new AccionActualizacionCliente("Actualizar cliente");
    accion.setAplicacion(app);
    app.addAccion(accion);
    // Eliminación de motocicleta
    accion = new AccionEliminaMotocicleta("Eliminar motocicleta ");
    accion.setAplicacion(app);
    app.addAccion(accion);
    
    // Añadimos un objeto de servicio para acceso a datos
    // En este caso vamos a usar SQLite asi que creamos un objeto para SQLite

    ServicioAccesoDatos servicio = new ServicioAccesoDatosSQLite(RUTA_DB);
    app.addConfiguracion("ServicioAccesoDatos", servicio);
    
    // Iniciamos la aplicación. Cuando termine volverá y terminaremos
    app.inicia();
  }

}
