package prog.unidad06.gestionficheros.ejercicio03;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import prog.unidad06.gestionficheros.comun.Comando;
import prog.unidad06.gestionficheros.comun.Interfaz;
import prog.unidad06.gestionficheros.ejercicio02.ComandoListarFicheros;
import prog.unidad06.gestionficheros.ejercicio02.ComandoSalir;

/**
 * Segunda versión de a aplicación de gestión de ficheros
 */
public class GestionFicheros2App {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    // Creamos el mapa de comandos
    // Incluimos además de los dos anteriores (que usamos directamente del
    // ejercicio anterior), los comandos Copiar Fichero y Mover Fichero
    Map<Character, Comando> comandos = new HashMap<>();
    comandos.put('0', new ComandoSalir());
    comandos.put('1', new ComandoListarFicheros());
    comandos.put('2', new ComandoCopiarFichero());
    comandos.put('3', new ComandoMoverFichero());
    
    // Creamos el interfaz y lo lanzamos
    Interfaz interfaz = new Interfaz(comandos, sc);
    interfaz.run();
  }
}
