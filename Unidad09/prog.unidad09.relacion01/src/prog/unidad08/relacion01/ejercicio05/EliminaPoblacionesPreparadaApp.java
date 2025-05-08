package prog.unidad08.relacion01.ejercicio05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import prog.unidad08.relacion01.ejercicio05.generadores.GeneradorSentencia;
import prog.unidad08.relacion01.ejercicio05.generadores.GeneradorSentenciaCodigo;
import prog.unidad08.relacion01.ejercicio05.generadores.GeneradorSentenciaExtensionMenorQue;
import prog.unidad08.relacion01.ejercicio05.generadores.GeneradorSentenciaPoblacionMayorQue;
import prog.unidad08.relacion01.ejercicio05.preparadores.PreparadorSentencia;
import prog.unidad08.relacion01.ejercicio05.preparadores.PreparadorSentenciaCodigo;
import prog.unidad08.relacion01.ejercicio05.preparadores.PreparadorSentenciaExtension;
import prog.unidad08.relacion01.ejercicio05.preparadores.PreparadorSentenciaPoblacion;

/**
 * Elimina poblaciones según criterios determinados. Utiliza sentencias no preparadas
 */
public class EliminaPoblacionesPreparadaApp {

  // Constantes
  // URL de conexion a la base de datos
  private static final String URL_DB = "jdbc:sqlite:db/poblaciones.db";

  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    // Solicita los datos al usuario
    System.out.println("Eliminación de pueblos");
    System.out.print("¿Desea eliminar por código(c), extensión(e) o población total(p)?: ");
    char campo = sc.nextLine().toLowerCase().charAt(0);
    int poblaciones;
    if (campo == 'c') {
      System.out.print("Código del pueblo a eliminar: ");
      String codigo = sc.nextLine();
      try {
        poblaciones = eliminaPorCodigo(codigo);
      } catch (SQLException e) {
        System.err.println("Error eliminando por código");
        return;
      }
    } else if (campo == 'e') {
      System.out.print("Extensión máxima de los pueblos a eliminar (los pueblos con una extensión por debajo de ésta serán eliminados): ");
      double extension = Double.parseDouble(sc.nextLine());
      try {
        poblaciones = eliminaPorExtension(extension);
      } catch (SQLException e) {
        System.err.println("Error eliminando por extensión");
        return;
      }
    } else if (campo == 'p') {
      System.out.print("Población mínima de los pueblos a eliminar (los pueblos con una población por encima de ésta serán eliminados): ");
      int poblacion = Integer.parseInt(sc.nextLine());
      try {
        poblaciones = eliminaPorPoblacion(poblacion);
      } catch (SQLException e) {
        System.err.println("Error eliminando por población");
        return;
      }
    } else {
      // El campo no es válido. Terminamos
      System.err.println("Selección de campo inválida. Terminando");
      return;
    }
    // Imprime las poblaciones eliminadas
    System.out.println("Se eliminaron " + poblaciones + " poblaciones");
  }

  /**
   * Elimina poblaciones por su código
   * @param codigo Código de la población a eliminar
   * @return Número de poblaciones eliminadas (debe ser 0 ó 1)
   * @throws SQLException Si se produce algún error accediendo a la base de datos
   */
  private static int eliminaPorCodigo(String codigo) throws SQLException {
    PreparadorSentencia preparador = new PreparadorSentenciaCodigo(codigo);
    return eliminaConPreparador(preparador);
  }

  private static int eliminaPorExtension(double extension) throws SQLException{
    PreparadorSentencia preparador = new PreparadorSentenciaExtension(extension);
    return eliminaConPreparador(preparador);
  }

  private static int eliminaPorPoblacion(int poblacion) throws SQLException {
    PreparadorSentencia preparador = new PreparadorSentenciaPoblacion(poblacion);
    return eliminaConPreparador(preparador);
  }


  private static int eliminaConPreparador(PreparadorSentencia preparador) throws SQLException {
    // Obtenemos la conexion y la sentencia
    try (Connection conexion = DriverManager.getConnection(URL_DB);
         PreparedStatement sentencia = preparador.preparaSentencia(conexion)) {
      // Lanzamos la actualizacion obteniendo la sentencia del generador
      int resultado = sentencia.executeUpdate();
      // Devolvemos el resultado
      return resultado;
    }
  }
  
}
