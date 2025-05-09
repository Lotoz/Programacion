package prog.unidad09.relacion01.consultaGeneral;

import java.util.Scanner;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.Db4oIOException;

import prog.unidad09.relacion01.datos.Poblacion;

public class ConsultaBaseEntera {

//Constantes
//URL de la base de datos
  private static final String RUTA_ARCHIVO = "db/poblaciones.db4o";

  public static void main(String[] args) {

    System.out.println("Base de datos entera.");
    System.out.println("----------------------------------------------------");
    // Inicia la base de datos
    lectorBaseDatos();

  }

  /**
   * Lee los datos dados en la base de datos
   * 
   * @param codigo
   * @param pobMin
   * @param pobMax
   */
  private static void lectorBaseDatos() {
    // Iniciamos la base de datos
    ObjectContainer db = null;
    try {
      db = Db4o.openFile(RUTA_ARCHIVO);
      busca(db);
    } catch (Db4oIOException e) {
      System.err.printf("Error al acceder a la base de datos.");
    } finally {
      cerrarBaseDatos(db);
    }
  }

  /**
   * Buscar en la base de datos con los filtros
   * 
   * @param nombre
   * @param pobMin
   * @param pobMax
   * @param db
   */
  private static void busca(ObjectContainer db) {

    ObjectSet<Poblacion> poblaciones = db.query(Poblacion.class);
    imprimePoblaciones(poblaciones);

  }

  /**
   * Imprime una lista de poblaciones en forma de columnas. El formato es<br>
   * <code>CODIGO NOMBRE EXT P_TOT P_HOM P_MUJ VEHIC LINEAS</code>
   * 
   * @param poblaciones Lista con las poblaciones a imprimir
   */
  private static void imprimePoblaciones(ObjectSet<Poblacion> poblaciones) {
    System.out.println("Poblaciones encontradas");
    System.out.println("CODIGO           NOMBRE             EXT   P_TOT  P_HOM  P_MUJ VEHIC LINEAS");
    System.out.println("--------------------------------------------------------------------------");
    for (Poblacion poblacion : poblaciones) {
      System.out.printf("%5s %-28s %5.1f %6d %6d %6d %5d %6d", poblacion.getCodigo(), poblacion.getNombre(),
          poblacion.getExtension(), poblacion.getPoblacionTotal(), poblacion.getPoblacionHombres(),
          poblacion.getPoblacionMujeres(), poblacion.getVehiculos(), poblacion.getLineasTelefonicas());
      System.out.println();
    }
  }

  /**
   * Cierra la base de datos
   * 
   * @param db
   */
  private static void cerrarBaseDatos(ObjectContainer db) {
    try {
      db.close();
    } catch (Db4oIOException e) {
      System.err.printf("Error al cerrar a la base de datos.");
    }
  }
}
