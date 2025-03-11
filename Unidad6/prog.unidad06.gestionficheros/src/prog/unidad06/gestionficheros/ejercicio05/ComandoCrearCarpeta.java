package prog.unidad06.gestionficheros.ejercicio05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import prog.unidad06.gestionficheros.comun.Comando;

/**
 * Comando Crear nueva carpeta<br>
 * Solicita la ruta a la carpeta y la crea
 */
public class ComandoCrearCarpeta implements Comando {

  // Constantes
  // Descripcion del comando
  private static final String DESCRIPCION = "Crear Carpeta";

  @Override
  public boolean ejecutar(Scanner scanner) {
    // Solicitamos la ruta
    System.out.print("Introduzca la ruta a la carpeta a crear: ");
    String ruta = scanner.nextLine();

    // Intenta crearla
    Path path = Path.of(ruta);
    try {
      Files.createDirectories(path);
      System.out.println("Carpeta creada con éxito");
    } catch (IOException e) {
      // Algo salió mal creando la carpeta. Mostramos mensaje
      System.out.println("No se puede crear la carpeta. Compruebe que tiene "
          + "permisos y que la ruta es correcta");
    }
    // Devuelve false para que continúe el programa
    return false;
  }

  @Override
  public String getDescripcion() {
    return DESCRIPCION;
  }
}
