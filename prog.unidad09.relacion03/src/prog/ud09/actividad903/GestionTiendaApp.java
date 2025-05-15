package prog.ud09.actividad903;

import prog.common.ui.AplicacionConsolaMenu;
import prog.ud09.actividad903.comandos.ComandoAddMotocicleta;
import prog.ud09.actividad903.comandos.ComandoAddVenta;
import prog.ud09.actividad903.comandos.ComandoDeleteMotocicleta;
import prog.ud09.actividad903.comandos.ComandoListVentas;
import prog.ud09.actividad903.comandos.ComandoUpdateCliente;
import prog.ud09.actividad903.comandos.impl.ProcesadorListadosVentasExamen;
import prog.ud09.actividad903.database.BaseDatosTienda;
import prog.ud09.actividad903.database.impl.BaseDatosTiendaDb4o;

/**
 * Clase principal de la aplicación
 */
public class GestionTiendaApp {
  
  // Fichero de base de datos
  private static final String FICHERO_BD = "tienda.db4o";
  // Titulo de la aplicación
  private static final String TITULO_APP = "Gestion Tienda Motocicletas";
  // Titulos de los comandos
  private static final String TITULO_COMANDO_ADD_MOTOCICLETA = "Crear motocicleta";
  private static final String TITULO_COMANDO_ADD_VENTA = "Registrar venta";
  private static final String TITULO_COMANDO_LISTAR_VENTAS = "Listado de ventas";
  private static final String TITULO_COMANDO_UPDATE_CLIENTE = "Actualizar cliente";
  private static final String TITULO_COMANDO_REMOVE_MOTOCICLETA = "Eliminar motocicleta";

  /**
   * Punto de entrada de la aplicación
   * @param args Argumentos de la línea de comandos (no empleado)
   */
  public static void main(String[] args) {
    
    // Crea el modelo para la aplicación de consola
    BaseDatosTienda db = new BaseDatosTiendaDb4o(FICHERO_BD);
    // Creamos la aplicación de consola
    AplicacionConsolaMenu<BaseDatosTienda> app = new AplicacionConsolaMenu<>(TITULO_APP, db);
    // Añadimos los comandos
    app.addComando(new ComandoAddMotocicleta(TITULO_COMANDO_ADD_MOTOCICLETA));
    app.addComando(new ComandoAddVenta(TITULO_COMANDO_ADD_VENTA));
    app.addComando(new ComandoListVentas(TITULO_COMANDO_LISTAR_VENTAS, new ProcesadorListadosVentasExamen()));
    app.addComando(new ComandoUpdateCliente(TITULO_COMANDO_UPDATE_CLIENTE));
    app.addComando(new ComandoDeleteMotocicleta(TITULO_COMANDO_REMOVE_MOTOCICLETA));
    // Y la lanza
    app.run();
    // Cierra la base de datos
    db.cerrar();
  }

}
