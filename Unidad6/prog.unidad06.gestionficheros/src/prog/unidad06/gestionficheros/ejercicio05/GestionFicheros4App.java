package prog.unidad06.gestionficheros.ejercicio05;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import prog.unidad06.gestionficheros.comun.Comando;
import prog.unidad06.gestionficheros.comun.Interfaz;
import prog.unidad06.gestionficheros.ejercicio02.ComandoListarFicheros;
import prog.unidad06.gestionficheros.ejercicio02.ComandoSalir;
import prog.unidad06.gestionficheros.ejercicio03.ComandoCopiarFichero;
import prog.unidad06.gestionficheros.ejercicio03.ComandoMoverFichero;
import prog.unidad06.gestionficheros.ejercicio04.ComandoBorrarFichero;

/**
 * Version 4 y última de la aplicación de gestión de ficheros
 */
public class GestionFicheros4App {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    // Creamos el mapa de comandos
    // Añadimos el comando de crear carpeta
    Map<Character, Comando> comandos = new HashMap<>();
    comandos.put('0', new ComandoSalir());
    comandos.put('1', new ComandoListarFicheros());
    comandos.put('2', new ComandoCopiarFichero());
    comandos.put('3', new ComandoMoverFichero());
    comandos.put('4', new ComandoBorrarFichero());
    comandos.put('5', new ComandoCrearCarpeta());

    // Creamos el interfaz y la lanzamos
    Interfaz interfaz = new Interfaz(comandos, sc);
    interfaz.run();
  }

}
