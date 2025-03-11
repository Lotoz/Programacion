package prog.unidad06.gestionficheros.ejercicio02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import prog.unidad06.gestionficheros.comun.Comando;
import prog.unidad06.gestionficheros.comun.Interfaz;

/**
 * Primera versión de la aplicación de gestión de ficheros
 */
public class GestionFicheros1App {

  /**
   * Punto de entrada de la aplicación
   * @param args
   */
  public static void main(String[] args) {
    // Scanner global a usar para todos los comandos
    Scanner sc = new Scanner(System.in);
    
    // Creamos el mapa de comandos (con dos comandos: Salir y Listar Ficheros)
    // Para ver lo que hace cada uno hay que revisar la clase del comando
    Map<Character, Comando> comandos = new HashMap<>();
    comandos.put('0', new ComandoSalir());
    comandos.put('1', new ComandoListarFicheros());
    
    // Creamos el interfaz con los dos comandos y lo ejecutamos
    Interfaz interfaz = new Interfaz(comandos, sc);
    interfaz.run();
  }

}
