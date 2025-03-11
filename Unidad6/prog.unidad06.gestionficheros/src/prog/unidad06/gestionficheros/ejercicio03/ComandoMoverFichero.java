package prog.unidad06.gestionficheros.ejercicio03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import prog.unidad06.gestionficheros.comun.Comando;

/**
 * Comando que mueve un fichero de una localización a otra (o a la misma con
 * otro nombre)
 */
public class ComandoMoverFichero extends ComandoDosFicheros implements Comando {
  
  // Constantes
  // Descripcion del comando
  private static final String DESCRIPCION = "Mover Ficheros";

  @Override
  public String getDescripcion() {
    return DESCRIPCION;
  }

  @Override
  public boolean ejecutar(Scanner scanner) {
    // Solicita las rutas
    String[] rutas = solicitaRutas(scanner);
    // Intenta hacer el movimiento
    if (trasladaArchivos(rutas[0], rutas[1])) {
      System.out.println("Operación realizada con éxito");
    } else {
      System.err.println("No se pudo realizar la operación");
    }
    
    // Devuelve false para que la aplicación continúe
    return false;
  }

  /**
   * Realiza el movimiento del archivo origen al destino.<br>
   * El archivo se copia desde origen a destino y se elimina origen
   * @param rutaOrigen Ruta del archivo origen de la operación
   * @param rutaDestino Ruta del archivo destino de la operación
   * @return true si la operación tuvo éxito, false en caso contrario
   */
  private boolean trasladaArchivos(String rutaOrigen, String rutaDestino) {
    // Obtiene las rutas a los archivos a partir de las cadenas
    Path origen = Path.of(rutaOrigen);
    Path destino = Path.of(rutaDestino);
    try {
      // Intenta mover el fichero
      Files.move(origen, destino);
      // Si se llega aqui es que se tuvo éxito
      return true;
    } catch (IOException e) {
      // Error. Se devuelve false
      return false;
    }
  }
}
