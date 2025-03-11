package prog.unidad06.ficheros.ejercicio05;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Lee, lista, añade y almacena un fichero de discos
 */
public class CreceDiscosApp {
  
  // Constantes
  // Nombre del archivo
  private static final String RUTA_FICHERO = "discos.dat";
  
  // Atributos
  // Scanner para leer desde teclado
  private Scanner sc;
  
  public CreceDiscosApp() {
    sc = new Scanner(System.in);
  }

  /**
   * Punto de entrada de la aplicación
   * @param args
   */
  public static void main(String[] args) {
    CreceDiscosApp app = new CreceDiscosApp();
    app.run();
  }

  /**
   * Metodo principal de la aplicación
   */
  private void run() {
    // Lee el archivo desde disco
    List<Disco> discos = leeFichero(RUTA_FICHERO);
    
    // Imprime el contenido
    listaDiscos(discos);
    
    // Solicita los datos de un nuevo disco
    Disco nuevoDisco = solicitaDatosDisco();
    
    // Almacena el array y el nuevo disco
    guardaFichero(RUTA_FICHERO, discos, nuevoDisco);
  }
  
  /**
   * Lee los discos desde fichero
   * @param rutaFichero Ruta al fichero.
   * @return Lista con los discos leidos. Vacía si no se encuentra el fichero
   *   o no se puede leer
   */
  private List<Disco> leeFichero(String rutaFichero) {
    // Resultado
    List<Disco> salida = new ArrayList<>();
    
    // Abre el fichero
    try (DataInputStream entrada = new DataInputStream(new FileInputStream(rutaFichero))) {
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
   * Muestra la lista de discos por pantalla
   * @param discos Lista de discos a mostrar
   */
  private void listaDiscos(List<Disco> discos) {
    // Si hay discos
    if (discos.size() > 0) {
      // Cabecera
      System.out.printf("Listado de discos (%d)%n", discos.size());
      for (Disco disco: discos) {
        System.out.println(disco);
      }
    } else {
      // No hay discos
      System.out.println("La colección está vacía");
    }
  }


  /**
   * Solcita los datos de un disco y lo devuelve
   * @return Disco con los datos introducidos
   * @throws IllegalArgumentException Si alguno de los datos introducidos no es correcto
   */
  private  Disco solicitaDatosDisco() {
    // Solicita los datos del disco
    System.out.println("Introduce los datos del nuevo disco");
    System.out.print("Introduce el título del disco (no puede dejarse en blanco): ");
    String titulo = sc.nextLine();
    System.out.print("Introduce el nombre del autor del disco (no puede dejarse en blanco): ");
    String artista = sc.nextLine();
    System.out.print("Introduce el año de publicación del disco (entero positivo): ");
    int anyoPublicacion = Integer.parseInt(sc.nextLine());
    System.out.print("Introduce el precio del disco (real positivo): ");
    double precio = Double.parseDouble(sc.nextLine());
    System.out.print("¿Es el disco un CD? (s/n): ");
    boolean cd = sc.nextLine().toLowerCase().charAt(0) == 's';
    // Creamos y devolvemos el disco
    return new Disco(titulo, artista, anyoPublicacion, precio, cd);
  }

  /**
   * Almacena los discos en fichero
   * @param rutaFichero Ruta al fichero donde se van a guardar los discos
   * @param discos Lista con los discos a guardar
   * @param nuevoDisco Nuevo disco a añadir al final
   */
  private void guardaFichero(String rutaFichero, List<Disco> discos, Disco nuevoDisco) {
    // Crea o sobreescribe el fichero
    try (DataOutputStream salida = new DataOutputStream(new FileOutputStream(rutaFichero))) {
      // Escribe primero un entero con el número de discos que se van a guardar a continuación en el
      // fichero (los que hay en la lista mas uno, el nuevo)
      salida.writeInt(discos.size() + 1);
      // Para cada disco a escribir
      for (Disco disco: discos) {
        // Escribe los datos del disco
        escribeDisco(salida, disco);
      }
      // Escribe ahora los datos del nuevo disco
      escribeDisco(salida, nuevoDisco);
    } catch (Exception e) {
      // En caso de excepción no hace nada (la ignora)
    }
  }

  /**
   * Escribe los datos del disco al stream de salida
   * @param stream Stream de datos donde se va a almacenar el disco
   * @param disco Disco a almacenar
   * @throws IOException Si se produce algún error escribiendo
   */
  private  void escribeDisco(DataOutputStream stream, Disco disco) throws IOException {
    // Escribe los datos del disco en el stream
    stream.writeUTF(disco.getTitulo());
    stream.writeUTF(disco.getArtista());
    stream.writeInt(disco.getAnyoPublicacion());
    stream.writeDouble(disco.getPrecio());
    stream.writeBoolean(disco.isCd());
  }

}
