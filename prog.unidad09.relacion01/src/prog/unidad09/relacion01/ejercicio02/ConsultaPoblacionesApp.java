package prog.unidad09.relacion01.ejercicio02;

import java.util.List;
import java.util.Scanner;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.Db4oIOException;
import com.db4o.query.Predicate;

import prog.unidad09.relacion01.datos.Poblacion;

public class ConsultaPoblacionesApp {

//Constantes
//URL de la base de datos
  private static final String RUTA_ARCHIVO = "db/poblaciones.db4o";

  public static void main(String[] args) {
    boolean salida = false;
    do {
      try {
        Scanner scan = new Scanner(System.in);
        // Solicita los datos al usuario
        System.out.println("Introduzca los datos de la nueva población");
        System.out.print("Nombre: ");
        String nombre = scan.nextLine();
        System.out.print("Poblacion minima: ");
        double pobMin = Double.parseDouble(scan.nextLine());
        System.out.print("Poblacion maxima: ");
        double pobMax = Double.parseDouble(scan.nextLine());

        // Inicia la base de datos
        lectorBaseDatos(nombre, pobMin, pobMax);
        //Imprimir la bases de datos encontradas
       
        // Si todo ha salido bien termina
        salida = true;
      } catch (Exception e) {
        // Procesa error al acceder al archivo
        System.err.printf("Se ha ingresado un valor duplicado.%n");
      }
    } while (!salida);
  }

  /**
   * Lee los datos dados en la base de datos
   * 
   * @param codigo
   * @param pobMin
   * @param pobMax
   */
  private static void lectorBaseDatos(String nombre, double pobMin, double pobMax) {
    // iniciamos la base de datos
    ObjectContainer db = null;
    try {
      db = Db4o.openFile(RUTA_ARCHIVO);
      busca(nombre, pobMin, pobMax, db);
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
  private static void busca(String nombre, double pobMin, double pobMax, ObjectContainer db) {
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
        return candidato.getNombre().contains(nombre) && candidato.getPoblacionTotal() >= pobMin && candidato.getPoblacionTotal() <= pobMax;
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
        return  candidato.getPoblacionTotal() >= pobMin && candidato.getPoblacionTotal() <= pobMax;
      }
    });
    imprimePoblaciones(poblaciones);
  }

  /**
   * Imprime una lista de poblaciones en forma de columnas. El formato es<br>
   * <code>CODIGO NOMBRE EXT P_TOT P_HOM P_MUJ VEHIC LINEAS</code>
   * @param poblaciones Lista con las poblaciones a imprimir
   */
  private static void imprimePoblaciones(ObjectSet<Poblacion> poblaciones) {
    System.out.println("Poblaciones encontradas");
    System.out.println("CODIGO           NOMBRE             EXT   P_TOT  P_HOM  P_MUJ VEHIC LINEAS");
    System.out.println("--------------------------------------------------------------------------");
    for (Poblacion poblacion: poblaciones) {
      System.out.printf("%5s %-28s %5.1f %6d %6d %6d %5d %6d",
        poblacion.getCodigo(), poblacion.getNombre(), poblacion.getExtension(),
        poblacion.getPoblacionTotal(), poblacion.getPoblacionHombres(), poblacion.getPoblacionMujeres(),
        poblacion.getVehiculos(), poblacion.getLineasTelefonicas());
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
