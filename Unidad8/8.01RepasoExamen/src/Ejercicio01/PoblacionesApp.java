package Ejercicio01;

import java.nio.file.FileSystemNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import Ejercicio01.PoblacionDB;
import Ejercicio01.Poblacion;

/**
 * Esta clase sirve para añadir poblaciones a la base de datos. Esta es el main
 */
public class PoblacionesApp {

  //Constantes
  /**
   * Opciones del switch principal de programa
   */
  private static final int OPCION_ADD= 1;
  private static final int OPCION_LISTAR= 2;
  
  /**
   * Opciones del switch de enlistar
   */
  private static final int LISTAR_SIN_ORDEN = 1;
  private static final int LISTAR_ORDEN = 2;
  // Scanner
  Scanner scan = new Scanner(System.in);
  // Salida del ciclo
  private boolean salida = false;
  
  //Creacion del objeto poblacion con su ruta
  private PoblacionDB baseConexion = new PoblacionDB("db/poblaciones.db");
  /**
   * Constructor de la aplicacion
   */
  public PoblacionesApp() {
  }

  /**
   * Main del sistema
   * 
   * @param args
   */
  public static void main(String[] args) {
    PoblacionesApp app = new PoblacionesApp();

    app.run();
  }

  private void run() {
    int opcion;
    do {
      System.out.println("Base de datos poblaciones");
      System.out.println("Selecciona un opcion");
      System.out.println("-".repeat(20));
      System.out.println("1.Añadir poblacion.");
      System.out.println("2.Mostrar poblaciones.");
      System.out.println("0.Finalizar aplicacion.");
      opcion = Integer.parseInt(scan.nextLine());
      switch (opcion) {
      case OPCION_ADD:
        agregaPoblacion();
        break;
      case OPCION_LISTAR:
        listaPoblacion();
        break;
      }
    }while(opcion != 0);
  }

  /**
   * Metodo del switch añadir poblacion
   */
  private void agregaPoblacion() {
    // Inicio un ciclo para repetir los datos
    do {
      try {
        // Pedimos los datos al usuario
        System.out.printf("Introduzca los datos de la nueva poblacion.%n");
        System.out.printf("Codigo:");
        String codigo = scan.nextLine();
        System.out.printf("%nNombre de la poblacion:");
        String nombrePoblacion = scan.nextLine();
        System.out.printf("%nExtension (en km2):");
        double extension = Double.parseDouble(scan.nextLine());
        System.out.printf("%nPoblacion (Hombres):");
        int hombres = Integer.parseInt(scan.nextLine());
        System.out.printf("%nPoblacion (Mujeres):");
        int mujeres = Integer.parseInt(scan.nextLine());
        System.out.printf("%nNumero de vehiculos:");
        int vehiculos = Integer.parseInt(scan.nextLine());
        System.out.printf("%nNumero de lineas telefonicas:");
        int telefonos = Integer.parseInt(scan.nextLine());
        Poblacion poblacion = new Poblacion(codigo, nombrePoblacion, extension, hombres, mujeres, vehiculos, telefonos);
        baseConexion.addPoblacion(poblacion);
        salida = true;
      } catch (Exception e) {
        System.err.printf("Los datos introducidos no son correctos.",e);
      }
    } while (!salida);
  }
  
  /**
   * Le pregunta al usuario como desea listar la poblacion
   * @throws SQLException 
   */
  private void listaPoblacion() {
    System.out.printf("Como deseas listar la poblacion.%n");
    System.out.printf("Elige una opcion");
    System.out.println("-".repeat(20));
    System.out.println("1.Mostrar todas.");
    System.out.println("2.Mostrar por orden.");
    int opcion = Integer.parseInt(scan.nextLine());
    switch (opcion) {
    case LISTAR_SIN_ORDEN:
      listarSinOrden();
      break;
    case LISTAR_ORDEN:
      listarConOrden();
      break;
    }
    
  }
  
  private void listarSinOrden() {
    System.out.printf("Ingresa el nombre a buscar:");
    String nombre = scan.nextLine();
    System.out.printf("%nInserta poblacion minima:");
    int MinOP = Integer.parseInt(scan.nextLine());
    System.out.printf("%nInserta poblacion maxima:");
    int MaxOP = Integer.parseInt(scan.nextLine());
    //usamos el metodo de enlista
    try {
      baseConexion.consultaPoblacion(nombre, MinOP, MaxOP);
    } catch (SQLException e) {
      System.err.printf("Ha sucedido un error al enlistar la base de datos");
    }    
  }
  private void listarConOrden() {
    System.out.printf("Ingresa el nombre a buscar:");
    String nombre = scan.nextLine();
    System.out.printf("%nInserta poblacion minima:");
    int MinOP = Integer.parseInt(scan.nextLine());
    System.out.printf("%nInserta poblacion maxima:");
    int MaxOP = Integer.parseInt(scan.nextLine());
    //usamos el metodo de enlista con orden
    baseConexion.consultaPoblacionOrdn(nombre, MinOP, MaxOP);
    
  }
  
  
}
