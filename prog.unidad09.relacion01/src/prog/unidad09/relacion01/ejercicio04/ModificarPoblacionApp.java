package prog.unidad09.relacion01.ejercicio04;

import java.util.Scanner;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.Db4oIOException;

import prog.unidad09.relacion01.datos.Poblacion;

public class ModificarPoblacionApp {

//Constantes
//URL de la base de datos
  private static final String RUTA_ARCHIVO = "db/poblaciones.db4o";
  private static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {
      try {

        // Solicita los datos al usuario
        System.out.println("Introduzca el codigo de la poblacion a modificar.");
        System.out.printf("Codigo:");
        String codigo = scan.nextLine();

        if (!codigo.isBlank()) {
          inicia(codigo);
        }
       
      } catch (Exception e) {
        // Procesa error al acceder al archivo
        System.err.printf("Se ha ingresado un valor duplicado11.%n");
      }
  }

  private static void inicia(String codigo) {
    // iniciamos la base de datos
    ObjectContainer db = null;
    try {
      db = Db4o.openFile(RUTA_ARCHIVO);
      busca(db, codigo);
    } catch (Db4oIOException e) {
      System.err.printf("Error al acceder a la base de datos.");
    } finally {
      cerrarBaseDatos(db);
    }
  }

  private static void busca(ObjectContainer db, String codigo) {
    // Buscamos el codigo
    // Para ello accedemos a la base de datos con una consulta de ejemplo
    // Creamos el objeto prototipo CODIGO
    Poblacion prototipoCodigo = new Poblacion(codigo, null, 0, 0, 0, 0, 0, 0);
    ObjectSet<Poblacion> poblaciones = db.queryByExample(prototipoCodigo);
    //Busca
    for (Poblacion poblacion : poblaciones) {
      //si encunetr
      if (poblacion.getCodigo().equals(codigo)) {
        // Si lo encuentro continua
        System.out.printf("%n¿Quiere modificar el número de vehiculos (v) o el de líneas telefónicas (l)?:");
        String opcion = scan.nextLine();
        //Si la opcion es distinto de nada, lo realiza
        if (!opcion.isBlank()) {
          System.out.printf("%nIntroduzca el nuevo valor para el campo vehiculos:");
          int cambio = Integer.parseInt(scan.nextLine());
          switch (opcion.toLowerCase()) {
          case "l":
            poblacion.setExtension(cambio);
            db.store(poblacion);
            System.out.printf("%n El cambio fue exitoso");
            break;
          case "v":
            poblacion.setVehiculos(cambio);
            db.store(poblacion);
            System.out.printf("%n El cambio fue exitoso");
            break;
          }
        }
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
