package prog.unidad09.ejercicio01;

import java.util.Scanner;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseFileLockedException;
import com.db4o.ext.DatabaseReadOnlyException;
import com.db4o.ext.Db4oException;
import com.db4o.ext.Db4oIOException;
import com.db4o.ext.IncompatibleFileFormatException;
import com.db4o.ext.OldFormatException;

import prog.unidad09.relacion01.datos.Poblacion;

/**
 * Menu para añadir personas
 */
public class PoblacionesAddApp {

//Constantes
// URL de la base de datos
  private static final String RUTA_ARCHIVO = "db/poblaciones.db4o";

  public static void main(String[] args) {
    boolean salida = false;
    do {
      try {
        Scanner scan = new Scanner(System.in);
        // Solicita los datos al usuario
        System.out.println("Introduzca los datos de la nueva población");
        System.out.print("Codigo: ");
        String codigo = scan.nextLine();
        System.out.print("Nombre de la población: ");
        String nombre = scan.nextLine();
        System.out.print("Extensión (en km2): ");
        double extension = Double.parseDouble(scan.nextLine());
        System.out.print("Población (Hombres): ");
        int hombres = Integer.parseInt(scan.nextLine());
        System.out.print("Población (Mujeres): ");
        int mujeres = Integer.parseInt(scan.nextLine());
        System.out.print("Número de vehiculos: ");
        int vehiculos = Integer.parseInt(scan.nextLine());
        System.out.print("Número de líneas telefónicas: ");
        int lineas = Integer.parseInt(scan.nextLine());

        // Calculo de la poblacion total
        int poblacionTotal = hombres + mujeres;

        insertaPoblacion(codigo, nombre, extension, poblacionTotal, hombres, mujeres, vehiculos, lineas);

        // Si todo ha salido bien termina
        salida = true;
      } catch (Exception e) {
        // Procesa error al acceder al archivo
        System.err.printf("Se ha ingresado un valor duplicado.%n");
      }
    } while (!salida);
  }

  /**
   * Inserta la población en la base de datos
   * 
   * @param codigo    Codigo de poblacion
   * @param nombre    Nombre de población
   * @param extension Extensión de poblacion
   * @param hombres   Número de hombres de la población
   * @param mujeres   Número de mujeres de la población
   * @param vehiculos Número de vehículos de la población
   * @param lineas    Número de líneas telefónicas de la población
   * @throws SQLException Si se produce algún problem creando la población
   */
  private static void insertaPoblacion(String codigo, String nombre, double extension, int poblacionTotal, int hombres,
      int mujeres, int vehiculos, int lineas) {
    ObjectContainer db = null;
    try {
      db = Db4o.openFile(RUTA_ARCHIVO);
      comprobarDuplicados(codigo, nombre, db);
      // Si todo sale bien
      // Deberia agregarlo sin problema
      Poblacion poblacion = new Poblacion(codigo, nombre, extension, poblacionTotal, poblacionTotal, poblacionTotal,
          vehiculos, lineas);
      db.store(poblacion);
    } catch (Db4oIOException e) {
      System.err.printf("Error al acceder a la base de datos.");
    } finally {
      cerrarBaseDatos(db);
    }
  }

  /**
   * Comprueba que no existen duplicados en la poblacion
   * 
   * @param codigo
   * @param nombre
   * @param db
   */
  private static void comprobarDuplicados(String codigo, String nombre, ObjectContainer db) {
    // Comprobamos en la base de datos si ya hiciste un objeto con el mismo codigo o
    // nombre por
    // Para ello accedemos a la base de datos con una consulta de ejemplo
    // Creamos el objeto prototipo CODIGO
    Poblacion prototipoCodigo = new Poblacion(codigo, null, 0, 0, 0, 0, 0, 0);
    ObjectSet<Poblacion> poblaciones = db.queryByExample(prototipoCodigo);
    for (Poblacion poblacion : poblaciones) {
      if (poblacion.getCodigo().equals(codigo)) {
        System.out.println("CODIGO REPETIDO");
        throw new IllegalArgumentException("No pueden coincidir los codigos");
      }
    }
    // Ahora lo hacemos por nombre
    Poblacion prototipoNombre = new Poblacion(null, nombre, 0, 0, 0, 0, 0, 0);
    ObjectSet<Poblacion> poblaciones2 = db.queryByExample(prototipoNombre);
    for (Poblacion poblacion : poblaciones2) {
      if (poblacion.getNombre().equals(nombre)) {
        System.out.println("NOMBRE REPETIDO");
        throw new IllegalArgumentException("No pueden coincidir los nombres");
      }
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
