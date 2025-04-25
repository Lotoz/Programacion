package prog.common.app.consola;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.Scanner;

/**
 * Aplicación de consola con menu de acciones
 */
public class AplicacionConsolaPorMenu extends AplicacionConsola {
  
  // Constantes
  // Opcion de salir
  private static final int OPCION_SALIR = 0;
  // >Titulo de la opción de salir
  private static final String OPCION_SALIR_TITULO = "Salir";
  
  // Atributos
  // Scanner para el teclado
  private Consola consola;
  // Titulo de la aplicación
  private String titulo;
  // Acciones de menu
  private List<Accion> acciones;
  
  /**
   * Constructor
   * @param titulo Titulo de la aplicación
   */
  public AplicacionConsolaPorMenu(String titulo) {
    // Titulo de la aplicación
    this.titulo = titulo;
    // Acciones de menu
    this.acciones = new ArrayList<>();
    // Consola
    consola = Consola.getConsola();
  }
  
  /**
   * Añade una acción de menu a la aplicación
   * @param accion Acción de menu
   */
  public void addAccion(Accion accion) {
    // Añadimos la acción a la lista de acciones
    acciones.add(accion);
  }

  @Override
  public void inicia() {
    
    // Hasta terminar
    for(;;) {
      // Muestra el menu y obtiene la opción elegida
      int opcion = muestraMenu();
      // Si la opción es cero salimos
      if (opcion == OPCION_SALIR) {
        return;
      }
      // Obtenemos la acción correspondiente y se ejecuta
      // Se resta 1 porque la opción 1 se corresponde con el elemento 0, la 2
      // con el 1 y asi sucesivamente
      acciones.get(opcion - 1).ejecutar();
    }
  }

  private int muestraMenu() {
    // Hasta que se lea una opción correcta
    for (;;) {
      // MOstramos el título
      consola.escribeTitulo(titulo);
      // Para cada elemento del menú
      int opcion = 1;
      for (Accion accion: acciones) {
        consola.escribeLinea(String.format("%d - %s", opcion, accion.getTitulo()));
        opcion++;
      }
      // Por último la opción salir que siempre es la cero
      consola.escribeLinea(String.format("%d - %s", OPCION_SALIR, OPCION_SALIR_TITULO));
      // Y Solicitamos la opción y la devolvemos
      return consola.leeEntero(String.format("Introduzca la opción elegida (0-%d)", opcion - 1), OptionalInt.of(0), OptionalInt.of(opcion - 1));
    }
  }
}
