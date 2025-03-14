package prog.unidad06.ficheros.ejercicio06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import prog.unidad06.ficheros.ejercicio05.Disco;

/**
 * Aumenta en un porcentaje los precios de todos los discos de un fichero
 */
public class AumentaPrecioDiscosApp {

  // Constantes
  // Ruta por defecto si no se proporciona una
  private static final String RUTA_DEFECTO = "discos.dat";
  // Porcentaje por defecto si no se proporciona uno
  private static final double PORCENTAJE_DEFECTO = 0.15;
  
  // Atributos
  // Scanner para leer desde teclado
  private Scanner sc;
  // Ruta al fichero
  private String ruta;
  // Porcentaje
  private double porcentaje;
  
  public AumentaPrecioDiscosApp(String[] args) {
    sc = new Scanner(System.in);
    procesaParametros(args);
  }

  /**
   * Punto de entrada de la aplicación
   * @param args
   */
  public static void main(String[] args) {
    AumentaPrecioDiscosApp app = new AumentaPrecioDiscosApp(args);
    app.run();
  }

  /**
   * Procesa la línea de comandos y extrae los parámetros o emplea los valores por defecto
   * si no hay parametros
   * @param args Parámetros a la aplicación
   */
  private void procesaParametros(String[] args) {
    // Si se proporcionó la ruta la toma, si no toma la por defecto
    ruta = args.length > 0 ? args[0] : RUTA_DEFECTO;
    // Si se proporcionó el porcentaje lo toma, si no el porcentaje por defecto
    try {
      porcentaje = args.length > 1 ? Double.parseDouble(args[1]) : PORCENTAJE_DEFECTO;
    } catch (NumberFormatException e) {
      // Si no se puede procesar el parámetro tomamos el valor por defecto
      porcentaje = PORCENTAJE_DEFECTO;
    }
  }
  
  /**
   * Metodo principal de la aplicación
   */
  private void run() {
    // Lee todos los discos desde el fichero
    List<Disco> discos = leeFichero();
    // Aumenta el precio
    aumentaPrecio(discos);
    // Almacena los discos en el fichero
    escribeFichero(discos);
    // Mensaje
    System.out.printf("Fichero \"%s\" procesado correctamente%n", ruta);
  }
  
  /**
   * Lee los discos desde fichero
   * @return Lista con los discos leidos. Vacío si no se encuentra el fichero
   *   o no se puede leer
   */
  private List<Disco> leeFichero() {
    // Resultado
    List<Disco> salida = new ArrayList<>();
    
    // Abre el fichero
    try (DataInputStream entrada = new DataInputStream(new FileInputStream(ruta))) {
      // Al inicio del fichero hay un número entero que indica la cantidad de discos que hay
      // guardados a continuación
      int cantidadDiscos = entrada.readInt();
      // Para cada disco a leer
      for (int disco = 0; disco < cantidadDiscos; disco++) {
        // Lee los datos del disco, lo crea y lo añade a la salida
        String titulo = entrada.readUTF();
        String artista = entrada.readUTF();
        int anyoPublicacion = entrada.readInt();
        double precio = entrada.readDouble();
        boolean cd = entrada.readBoolean();
        Disco nuevoDisco = new Disco(titulo, artista, anyoPublicacion, precio, cd);
        salida.add(nuevoDisco);
      }
    } catch (Exception e) {
      // Si ocurre algún error limpia la lista (para evitar leer unos datos si y otros no)
      // Y la devuelve
      salida.clear();
    }
    // Devuelve el resultado
    return salida;
  }
  
  /**
   * Almacena los discos en fichero
   * @param discos Lista con los discos a guardar
   * @param nuevoDisco Nuevo disco a añadir al final
   */
  private void escribeFichero(List<Disco> discos) {
    // Crea o sobreescribe el fichero
    try (DataOutputStream salida = new DataOutputStream(new FileOutputStream(ruta))) {
      // Escribe primero un entero con el número de discos que se van a guardar a continuación en el
      // fichero (los que hay en la lista mas uno, el nuevo)
      salida.writeInt(discos.size());
      // Para cada disco a escribir
      for (Disco disco: discos) {
        // Escribe los datos del disco en el stream
        salida.writeUTF(disco.getTitulo());
        salida.writeUTF(disco.getArtista());
        salida.writeInt(disco.getAnyoPublicacion());
        salida.writeDouble(disco.getPrecio());
        salida.writeBoolean(disco.isCd());
      }
    } catch (Exception e) {
      // En caso de excepción no hace nada (la ignora)
    }
  }

  /**
   * Aumenta el precio a todos los discos de la lista
   * @param discos Lista con los discos
   */
  private void aumentaPrecio(List<Disco> discos) {
    // Para cada disco
    for (Disco disco: discos) {
      // Aumenta el precio del disco en el porcentaje indicado
      double precio = disco.getPrecio();
      precio += precio * porcentaje;
      disco.setPrecio(precio);
    }
  }

}
