package prog.unidad08.relacion01.ejercicio04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Permite modificar el número de vehiculos o lineas empleando sentencias preparadas
 */
public class ModificarPoblacionPreparadaApp {

  // URL de conexion a la base de datos
  private static final String URL_DB = "jdbc:sqlite:db/poblaciones.db";

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    // Solicita los datos al usuario
    System.out.println("Introduzca los datos para la modificación");
    System.out.print("Código del pueblo a modificar: ");
    String codigo = sc.nextLine();
    System.out.print("¿Quiere modificar el número de vehiculos (v) o el de líneas telefónicas (l)?: ");
    char campo = sc.nextLine().toLowerCase().charAt(0);
    // Solicita el nuevo valor del campo
    // Primero muestra el prompt correspondiente al campo elegido o un error si la elección fue invalida
    if (campo == 'v') {
      System.out.print("Introduzca el nuevo valor para el campo vehiculos: ");
    } else if (campo == 'l') {
      System.out.print("Introduzca el nuevo valor para el campo líneas telefónicas: ");
    } else {
      // El campo no es válido. Terminamos
      System.err.println("Selección de campo inválida. Terminando");
      return;
    }
    // Y ahora solicita el valor
    int nuevoValor = Integer.parseInt(sc.nextLine());
    
    // Intenta actualizar
    try {
      // Actualiza el valor del campo. Si se encontro?
      if (actualizaPoblacion(codigo, campo, nuevoValor)) {
        System.out.println("El registro se actualizó con éxito");
      } else {
        System.err.println("No existe ninguna población con código " + codigo);
      }
    } catch (SQLException e) {
      // Si ocurrió error lo muestra
      System.err.println("Ocurrió un error actualizando la fila: " + e);
    }
  }

  /**
   * Actualiza el valor de un campo (numero de vehiculos o de lineas) de una población
   * @param codigo Código de a población a actualizar
   * @param campo Campo a actualizar ('v' para vehiculos y 'l' para lineas.
   * @param nuevoValor Nuevo valor para el campo
   * @return true si existe la población con el código dado o false si no existe
   * @throws SQLException Si ocurre cualquier problema con la consulta
   */
  private static boolean actualizaPoblacion(String codigo, char campo, int nuevoValor) throws SQLException {
    // Creamos la sentencia según el campo
    String sql = "UPDATE pueblos SET ";
    if (campo == 'v') {
      sql += "vehiculos = ";
    } else {
      sql += "lineas_tel = ";
    }
    sql += "? WHERE codigo = ?";
    
    // Obtenemos la conexion y la sentencia
    try (Connection conexion = DriverManager.getConnection(URL_DB);
         PreparedStatement sentencia = conexion.prepareStatement(sql)) {
      
      // Rellenamos los parámetros
      // El primero siempre es entero sea cual sea la elección de campo
      sentencia.setInt(1, nuevoValor);
      // El segundo es el código
      sentencia.setString(2, codigo);

      // Ejecutamos la sentencia
      int resultado = sentencia.executeUpdate();

      // Devolvemos el resultado (debe haber devuelto 1 si ha actualizado una fila)
      return resultado == 1;
    }
  }

}
