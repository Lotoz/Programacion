package prog.unidad06.gestionficheros.ejercicio04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import prog.unidad06.gestionficheros.comun.Comando;

/**
 * Comando Borrar fichero<br>
 * Solicita la ruta al fichero o carpeta a eliminar y lo elimina
 */
public class ComandoBorrarFichero implements Comando {
  
  // Constantes
  // Descripcion
  private static final String DESCRIPCION = "Borrar Fichero";

  @Override
  public boolean ejecutar(Scanner scanner) {
    // Solicitamos la ruta
    System.out.print("Introduzca la ruta al fichero o carpeta a eliminar: ");
    String ruta = scanner.nextLine();
    // Si el fichero existe y es una carpeta
    Path path = Path.of(ruta);
    // Si existe
    if (Files.exists(path)) {
      try {
        // Intenta eliminarlo
        Files.delete(path);
        // Muestra mensaje OK
        System.out.println("Fichero o carpeta eliminado con éxito");
      } catch (IOException e) {
        // Muestra mensaje KO
        System.out.println("No se puede eliminar el archivo. Compruebe que "
            + "tiene permisos y que si es una carpeta está vacía");
      }
    } else {
      // El fichero no existe
      System.out.println("El fichero indicado no existe");
    }
    
    // Devuelve false para que la aplicación continúe
    return false;
  }

  @Override
  public String getDescripcion() {
    return DESCRIPCION;
  }

}
