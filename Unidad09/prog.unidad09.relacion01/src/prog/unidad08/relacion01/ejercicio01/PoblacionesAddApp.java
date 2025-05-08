package prog.unidad08.relacion01.ejercicio01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PoblacionesAddApp {
  // Constantes
  // URL de la base de datos
  private static final String URL = "jdbc:sqlite:db/poblaciones.db";

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    // Solicita los datos al usuario
    System.out.println("Introduzca los datos de la nueva población");
    System.out.print("Codigo: ");
    String codigo = sc.nextLine();
    System.out.print("Nombre de la población: ");
    String nombre = sc.nextLine();
    System.out.print("Extensión (en km2): ");
    double extension = Double.parseDouble(sc.nextLine());
    System.out.print("Población (Hombres): ");
    int hombres = Integer.parseInt(sc.nextLine());
    System.out.print("Población (Mujeres): ");
    int mujeres = Integer.parseInt(sc.nextLine());
    System.out.print("Número de vehiculos: ");
    int vehiculos = Integer.parseInt(sc.nextLine());
    System.out.print("Número de líneas telefónicas: ");
    int lineas = Integer.parseInt(sc.nextLine());
    
    // Inserta el registro en la base de datos
    try {
      insertaPoblacion(codigo, nombre, extension, hombres, mujeres, vehiculos, lineas);
    } catch (SQLException e) {
      System.err.println("Ocurrió un error añadiendo la población: " + e);
    }
  }

  /**
   * Inserta la población en la base de datos
   * @param codigo Codigo de poblacion
   * @param nombre Nombre de población
   * @param extension Extensión de poblacion
   * @param hombres Número de hombres de la población
   * @param mujeres Número de mujeres de la población
   * @param vehiculos Número de vehículos de la población
   * @param lineas Número de líneas telefónicas de la población
   * @throws SQLException Si se produce algún problem creando la población
   */
  private static void insertaPoblacion(String codigo, String nombre, double extension, int hombres,
      int mujeres, int vehiculos, int lineas) throws SQLException {
    // Conectamos con la base de datos y creamos la sentencia
    try (Connection conexion = DriverManager.getConnection(URL);
         Statement sentencia = conexion.createStatement();) {
      // Creamos el SQL para la sentencia
      String sql = String.format("INSERT INTO pueblos " 
        + "(codigo, nombre, extension, pob_total, pob_hombres, pob_mujeres, vehiculos, lineas_tel)"
        + " VALUES (%s,%s,%f,%d,%d,%d,%d,%d)", sentencia.enquoteLiteral(codigo)
        , sentencia.enquoteLiteral(nombre), extension, hombres + mujeres, hombres, mujeres
        , vehiculos, lineas);
      // Y la ejecutamos
      sentencia.executeUpdate(sql);
    }
  }
}
