package prog.unidad06.gestionficheros.comun;

import java.util.Scanner;

/**
 * Interfaz que implementan todos los comandos del programa
 */
public interface Comando {
  
  /**
   * Obtiene la descripción del comando
   * @return Descripcion del comando
   */
  String getDescripcion();
  
  /**
   * Ejecuta la acción del comando
   * @param scanner Scanner a usar para leer desde teclado, si se necesita
   * @return true si la aplicación debe terminar tras ejecutar el comando. false en caso contrario
   */
  boolean ejecutar(Scanner scanner);

}
