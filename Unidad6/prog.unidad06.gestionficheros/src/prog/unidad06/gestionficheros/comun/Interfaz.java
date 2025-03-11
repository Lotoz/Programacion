package prog.unidad06.gestionficheros.comun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Interfaz de usuario de la aplicación<br>
 * Contiene la lógica común a todos los comandos (mostrar menu y elegir el comando adecuado a la opción elegida)
 */
public class Interfaz {
  
  // Atributos
  // Scanner para poder leer desde teclado
  private final Scanner scanner;
  // Mapa con los comandos. La clave es la tecla de acceso al comando y el valor es el comando en si
  private final Map<Character, Comando> comandos;

  /**
   * Constructor con todos los parámetros
   * @param comandos Mapa con los comandos que va a soportar la aplicación
   * @param scanner Scanner para leer desde teclado
   */
  public Interfaz(Map<Character, Comando> comandos, Scanner scanner) {
    // Almacena ambos parámetros
    this.comandos = comandos;
    this.scanner = scanner;
  }
  
  /**
   * Ciclo principal de la aplicación<br>
   * Muestra el menu a partir del mapa de comandos, obtiene opción desde el usuario y ejecuta el comando adecuado según la opción elegida
   */
  public void run() {
    // Imprime Cabecera
    System.out.println("Gestión de ficheros");
    
    // Ciclo principal
    // Opción elegida por el usuario
    char opcion;
    // Flag que indica que el usuario ha seleccionado salir de la aplicación
    boolean salir = true;
    do {
      // Muestra el menu
      muestraMenu();
      
      // Solicita la opción al usuario
      System.out.print("Seleccione opción: ");
      opcion = scanner.nextLine().charAt(0);
      
      // Busca el comando en el mapa
      Comando comando = comandos.get(opcion);

      // Si se encontró
      if (comando != null) {
        // Lo ejecuta. El comando debe devolver true si es un comando que hace que la aplicación finalice
        salir = comando.ejecutar(scanner);
      } else {
        // Muestra un error porque la opción no está en el mapa de comandos
        System.out.println("Error. Opción incorrecta");
      }
    } while (!salir);
    // Mostramos un mensaje de fin de aplicación
    System.out.println();
    System.out.println("Terminando");
  }

  /**
   * MUestra el menu por pantalla a partir del mapa de comandos
   */
  private void muestraMenu() {
    // Obtenemos las claves del mapa de comandos y las ordenamos en orden alfabético
    List<Character> opciones = new ArrayList<>(comandos.keySet());
    Collections.sort(opciones);
    
    // Imprimimos el menu por pantalla
    System.out.println();
    System.out.println("MENU");
    for (char opcion: opciones) {
      System.out.printf("%c) %s%n", opcion, comandos.get(opcion).getDescripcion());
    }
  }
}
