package Ejercicio01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * Clase que sirve para trabajar con la base de datos, implementa una interfaz
 */
public class PoblacionDB implements BaseDatosPoblacion {

  // URL basico para conectarse con la base de datos
  private static final String URL_BASE = "jdbc:sqlite:db/poblaciones.db";

//Sentencia para la consulta
  private static final String SQL_CONSULTA = "SELECT * FROM pueblos WHERE nombre LIKE ? AND pob_total >= ? AND pob_total <= ?";
  // Nombres de los campos en la base de datos
  private static final String C_CODIGO = "codigo";
  private static final String C_NOMBRE = "nombre";
  private static final String C_EXTENSION = "extension";
  private static final String C_POB_HOMBRES = "pob_hombres";
  private static final String C_POB_MUJERES = "pob_mujeres";
  private static final String C_VEHICULOS = "vehiculos";
  private static final String C_LINEAS_TEL = "lineas_tel";

  // Ruta a la base de datos SQLite
  private String rutaBD;

  /**
   * Constructor con la ruta
   */
  public PoblacionDB(String rutaBD) {
    this.rutaBD = URL_BASE;
  }

  @Override
  public void addPoblacion(Poblacion poblacion) throws SQLException {
    // Iniciamos la conexion con la base de datos
    try (Connection conexion = DriverManager.getConnection(rutaBD);
        Statement sentencia = conexion.createStatement();) {
      // Creamos el SQL para la sentencia
      // Este es un SQL preparado
      String sql = String.format(
          "INSERT INTO pueblos "
              + "(codigo, nombre, extension, pob_total, pob_hombres, pob_mujeres, vehiculos, lineas_tel)"
              + " VALUES (%s,%s,%f,%d,%d,%d,%d,%d)",
          sentencia.enquoteLiteral(poblacion.getCodigo()), sentencia.enquoteLiteral(poblacion.getNombrePoblacion()),
          poblacion.getExtension(), poblacion.getPoblacionTotal(), poblacion.getHombres(), poblacion.getMujeres(),
          poblacion.getVehiculos(), poblacion.getTelefonos());
      // Y la ejecutamos
      sentencia.executeUpdate(sql);
    }
  }

  @Override
  public List<Poblacion> consultaPoblacion(String nombre, int MinPob, int MaxPob) throws SQLException {
    //  Preparamos la conexió y la consulta
    try (Connection conexion = DriverManager.getConnection(URL_BASE);
         PreparedStatement sentencia = conexion.prepareStatement(SQL_CONSULTA);) {
      // Añadimos los valores de búsqueda a la sentencia
      // Primero el nombre (Como vamos a buscar que CONTENGA el nombre, hay que rodear el mismo
      // por %
      sentencia.setString(1, "%" + nombre + "%");
      // Después la poblacion minima
      sentencia.setInt(2, MinPob);
      // Y por ultimo la poblacion maxima
      sentencia.setInt(3, MaxPob);
      // Lanzamos la consulta
      ResultSet resultado = sentencia.executeQuery();
      // Iniciamos la lista con la salida
      List<Poblacion> salida = new ArrayList<>();
      while (resultado.next()) {
        Poblacion poblacion = new Poblacion(resultado.getString(C_CODIGO),
          resultado.getString(C_NOMBRE), resultado.getDouble(C_EXTENSION),
          resultado.getInt(C_POB_HOMBRES), resultado.getInt(C_POB_MUJERES),
          resultado.getInt(C_VEHICULOS), resultado.getInt(C_LINEAS_TEL));
        salida.add(poblacion);
      }
      resultado.close();
      // Devuelve el resultado
      return salida;
    }
  }

  @Override
  public List<Poblacion> consultaPoblacionOrdn(String nombre, int MinPob, int MaxPob) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void modificaPoblacion(Poblacion poblacion) {
    // TODO Auto-generated method stub

  }

  @Override
  public void eliminaPoblaciones(String opcion) {
    // TODO Auto-generated method stub

  }

  /**
   * Imprime una lista de poblaciones en forma de columnas. El formato es<br>
   * <code>CODIGO NOMBRE EXT P_TOT P_HOM P_MUJ VEHIC LINEAS</code>
   * 
   * @param poblaciones Lista con las poblaciones a imprimir
   */
  private static void imprimePoblaciones(List<Poblacion> poblaciones) {
    System.out.println("Poblaciones encontradas");
    System.out.println("CODIGO           NOMBRE             EXT   P_TOT  P_HOM  P_MUJ VEHIC LINEAS");
    System.out.println("--------------------------------------------------------------------------");
    for (Poblacion poblacion : poblaciones) {
      System.out.printf("%5s %-28s %5.1f %6d %6d %6d %5d %6d", poblacion.getCodigo(), poblacion.getNombrePoblacion(),
          poblacion.getExtension(), poblacion.getPoblacionTotal(), poblacion.getHombres(), poblacion.getMujeres(),
          poblacion.getVehiculos(), poblacion.getTelefonos());
      System.out.println();
    }
  }
}
