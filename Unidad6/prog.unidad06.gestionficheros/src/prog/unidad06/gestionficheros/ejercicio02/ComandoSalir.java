package prog.unidad06.gestionficheros.ejercicio02;

import java.util.Scanner;

import prog.unidad06.gestionficheros.comun.Comando;

/**
 * Comando Salir del Programa<br>
 * No hace nada más que indicar que hay que salir del programa
 */
public class ComandoSalir implements Comando {

  // Constantes
  // Descripción del comando (se mostrará en el menu)
  private static final String DESCRIPCION = "Salir";
  
  @Override
  public String getDescripcion() {
    return DESCRIPCION;
  }

  @Override
  public boolean ejecutar(Scanner scanner) {
    // No hace nada excepto devolver true para terminar la aplicación
    return true;
  }

}
