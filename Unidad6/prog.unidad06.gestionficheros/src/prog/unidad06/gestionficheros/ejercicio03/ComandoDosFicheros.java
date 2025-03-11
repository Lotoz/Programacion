package prog.unidad06.gestionficheros.ejercicio03;

import java.util.Scanner;

/**
 * Comando que opera sobre dos ficheros<br>
 * Contiene las "cosas" comunes a todos los comandos que necesitan rutas a dos
 * ficheros. No se debe instanciar directamente esta clase
 */
public class ComandoDosFicheros {

  /**
   * Constructor protegido para que no se puedan crear instancias desde clases
   * externas
   */
  protected ComandoDosFicheros() {
    
  }
  
  /**
   * Solicita la ruta a un archivo de origen y otro de destino de una operación
   * @param scanner Scanner a usar para leer desde teclado
   * @return Array con dos cadenas. La primera contiene la ruta al archivo de 
   *   origen y la segunda la ruta al archivo de destino
   */
  protected String[] solicitaRutas(Scanner scanner) {

    // Array de resultados
    String[] resultado = new String[2];
    
    // Solicitamos y almacenamos las dos rutas
    System.out.print("Introduzca la ruta al archivo de origen: ");
    resultado[0] = scanner.nextLine();
    System.out.print("Introduzca la ruta al archivo de destino: ");
    resultado[1] = scanner.nextLine();
    // Y las devolvemos
    return resultado;
  }
}
