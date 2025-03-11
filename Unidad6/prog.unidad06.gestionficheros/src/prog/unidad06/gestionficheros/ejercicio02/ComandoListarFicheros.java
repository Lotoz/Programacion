package prog.unidad06.gestionficheros.ejercicio02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import prog.unidad06.gestionficheros.comun.Comando;

/**
 * Comando Listar Ficheros<br>
 * Solicita una ruta, que debe ser de una carpeta, y lista los contenidos
 */
public class ComandoListarFicheros implements Comando {

  // Constantes
  // Descripción del comando (se mostrará en el menu)
  private static final String DESCRIPCION = "Listar Ficheros";

  @Override
  public boolean ejecutar(Scanner scanner) {
    // Solicitamos la ruta
    System.out.print("Introduzca la ruta a la carpeta a listar: ");
    String ruta = scanner.nextLine();

    // Si el fichero existe y es una carpeta
    Path path = Path.of(ruta);
    if (Files.exists(path) && Files.isDirectory(path)) {
      // Obtiene el listado
      try {
        List<Path> ficheros = Files.list(path).collect(Collectors.toList());
        for (Path fichero: ficheros) {
          // Imprime el inicio de la línea dependiendo de si es fichero regular
          // o carpeta
          if (Files.isDirectory(fichero)) {
            System.out.print("Carpeta: ");
          } else {
            System.out.print("Fichero: ");
          }
          /// Y a continuación el nombre
          System.out.println(fichero.getFileName());
        }
      } catch (IOException e) {
        // Error de entrada / salida (saltamos el archivo y seguimos)
        System.out.println("Error accediendo a la carpeta");
      }
    } else {
      // No hay nada en la ruta o lo que hay no es una carpeta
      System.out.println("La ruta no existe o no es una carpeta");
    }
    // Devolvemos false ya que no es el comando para salir
    return false;
  }

  @Override
  public String getDescripcion() {
    return DESCRIPCION;
  }

}
