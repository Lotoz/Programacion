package prog.unidad09.relacion01.ejercicio03;

import java.util.Comparator;
import java.util.Scanner;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.Db4oIOException;
import com.db4o.query.Predicate;

import prog.unidad09.relacion01.datos.Poblacion;

public class ConsultaPoblacionesConOrdenApp {

//Constantes
//URL de la base de datos
  private static final String RUTA_ARCHIVO = "db/poblaciones.db4o";

  public static void main(String[] args) {
    boolean salida = false;
    do {
      ObjectContainer db = null;
      try {
        // Scanner
        Scanner scan = new Scanner(System.in);
        System.out.println("Buscar base de datos por filtro.");
        // Solicita los datos al usuario
        System.out.println("Introduzca los datos de la poblacion a buscar");
        System.out.print("Nombre: ");
        String nombre = scan.nextLine();
        System.out.print("Poblacion minima: ");
        double pobMin = Double.parseDouble(scan.nextLine());
        System.out.print("Poblacion maxima: ");
        double pobMax = Double.parseDouble(scan.nextLine());

        // Inicio la base de datos
        db = Db4o.openFile(RUTA_ARCHIVO);

        if (nombre.isBlank()) {
          sinOrden(db, nombre, pobMin, pobMax);
        } else {
          System.out.printf("Elegi el orden de la busqueda.");
          System.out.printf("0.Sin orden.%n");
          System.out.printf("1.Con orden ascendente por nombre.%n");
          System.out.printf("2.Con orden descendente por nombre.%n");
          int opcion = Integer.parseInt(scan.nextLine());
          // Segun la opcion aplica el siguiente metodo
          switch (opcion) {
          case 0 -> sinOrden(db, nombre, pobMin, pobMax);
          case 1 -> ordenarPorNombreAs(db, nombre, pobMin, pobMax);
          case 2 -> ordenarPorDs(db, nombre, pobMin, pobMax);
          default -> throw new IllegalArgumentException("Unexpected value: " + opcion);
          }
        }
        salida = true;
      } catch (Db4oIOException e) {
        System.err.printf("Error al acceder a la base de datos.");
      } finally {
        cerrarBaseDatos(db);
      } 
    } while (!salida);

  }

  /**
   * Buscar en la base de datos con los filtros
   * 
   * @param nombre
   * @param pobMin
   * @param pobMax
   * @param db
   */
  private static void sinOrden(ObjectContainer db, String nombre, double pobMin, double pobMax) {
    // Busca primero por nombre, permite poner un nombre nulo
    // Para ello primero analizamos si el nombre es nulo
    if (nombre.isBlank()) {
      // Buscamos por el rango de la poblacion
      buscarRangoPoblacion(pobMin, pobMax, db);
    } else {
      // Si el nombre no es nulo, busca por todo
      ObjectSet<Poblacion> poblaciones = db.query(new Predicate<Poblacion>() {
        @Override
        public boolean match(Poblacion candidato) {
          return candidato.getNombre().contains(nombre) && candidato.getPoblacionTotal() >= pobMin
              && candidato.getPoblacionTotal() <= pobMax;
        }
      });
      imprimePoblaciones(poblaciones);
    }
  }

  /**
   * Busca por el rango de poblacion
   * 
   * @param pobMin
   * @param pobMax
   * @param db
   */
  private static void buscarRangoPoblacion(double pobMin, double pobMax, ObjectContainer db) {
    // Busca por el rango de poblacion dado
    // Usando query
    ObjectSet<Poblacion> poblaciones = db.query(new Predicate<Poblacion>() {
      @Override
      public boolean match(Poblacion candidato) {
        return candidato.getPoblacionTotal() >= pobMin && candidato.getPoblacionTotal() <= pobMax;
      }
    });
    imprimePoblaciones(poblaciones);
  }

  /**
   * Buscar en la base de datos con los filtros
   * 
   * @param nombre
   * @param pobMin
   * @param pobMax
   * @param db
   */
  private static void ordenarPorNombreAs(ObjectContainer db, String nombre, double pobMin, double pobMax) {
    // Busca primero por nombre, permite poner un nombre nulo
    // Para ello primero analizamos si el nombre es nulo
    if (nombre.isBlank()) {
      // Buscamos por el rango de la poblacion
      buscarRangoPoblacion(pobMin, pobMax, db);
    } else {
      // Si el nombre no es nulo, busca por todo
      ObjectSet<Poblacion> poblaciones = db.query(new Predicate<Poblacion>() {
        @Override
        public boolean match(Poblacion candidato) {
          return candidato.getNombre().contains(nombre) && candidato.getPoblacionTotal() >= pobMin
              && candidato.getPoblacionTotal() <= pobMax;
        }
      }, new Comparator<Poblacion>() {
        @Override
        public int compare(Poblacion o1, Poblacion o2) {
          // Ordenamos por orden ascendente
          return o1.getNombre().compareToIgnoreCase(o2.getNombre());
        }
      });

      imprimePoblaciones(poblaciones);

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
  private static void ordenarPorDs(ObjectContainer db, String nombre, double pobMin, double pobMax) {
    // Busca primero por nombre, permite poner un nombre nulo
    // Para ello primero analizamos si el nombre es nulo
    if (nombre.isBlank()) {
      // Buscamos por el rango de la poblacion
      buscarRangoPoblacion(pobMin, pobMax, db);
    } else {
      // Si el nombre no es nulo, busca por todo
      ObjectSet<Poblacion> poblaciones = db.query(new Predicate<Poblacion>() {
        @Override
        public boolean match(Poblacion candidato) {
          return candidato.getNombre().contains(nombre) && candidato.getPoblacionTotal() >= pobMin
              && candidato.getPoblacionTotal() <= pobMax;
        }
      }, new Comparator<Poblacion>() {
        @Override
        public int compare(Poblacion o1, Poblacion o2) {
          // Ordenamos por orden descendente
          return -(o1.getNombre().compareToIgnoreCase(o2.getNombre()));
        }
      });
      imprimePoblaciones(poblaciones);
    }
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
