package prog.unidad06.gestionficheros.ejercicio03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import prog.unidad06.gestionficheros.comun.Comando;

/**
 * Comando que copia un fichero
 */
public class ComandoCopiarFichero extends ComandoDosFicheros implements Comando {
  
  // Constantes
  // Descripcion del comando
  private static final String DESCRIPCION = "Copiar Ficheros";

  @Override
  public boolean ejecutar(Scanner scanner) {
    // Solicita las rutas aprovechando la funcionalidad heredada de
    // ComandoDosFicheros
    String[] rutas = solicitaRutas(scanner);
    // Intenta hacer la copia y muestra el mensaje correspondiente al resultado
    if (trasladaArchivos(rutas[0], rutas[1])) {
      System.out.println("Operación realizada con éxito");
    } else {
      System.out.println("No se pudo realizar la operación");
    }
    
    // Devuelve false para que la aplicación continue
    return false;
  }

  @Override
  public String getDescripcion() {
    return DESCRIPCION;
  }

  /**
   * Copia un archivo
   * @param rutaOrigen Ruta del archivo origen
   * @param rutaDestino Ruta del archivo destino
   * @return true si la operación tuvo éxito. false en caso contrario
   */
  private boolean trasladaArchivos(String rutaOrigen, String rutaDestino) {
    Path origen = Path.of(rutaOrigen);
    Path destino = Path.of(rutaDestino);
    // Intenta la copia
    try {
      Files.copy(origen, destino);
      // Si se llega aqui es que tuvo exito
      return true;
    } catch (IOException e) {
      // En caso de error devuelve false
      return false;
    }
  }
}
