package prog.common.ui;

import java.util.ArrayList;
import java.util.List;

import prog.common.consola.Consola;

/**
 * Aplicación de consola con menu<br>
 * Es una aplicación que funciona en un ciclo en el que muestra un menu con comandos y realiza
 * el seleccionado hasta que se elige el comando de terminar. Las operaciones se realizan sobre
 * un modelo de datos que depende de la aplicación y que se debe proporcionar a la aplicación y
 * que esta, a su vez, proporciona a los comandos.<br>
 * La aplicación añade la opción de salir automáticamente al menu de forma que no hay que
 * proporcionarla<br>
 * Una forma típica de funcionar sería:
 * <ol>
 * <li>Crea la aplicación, proporcionando un título y modelo</li>
 * <li>Proporciona uno o más objetos que hereden de Comando empleando el método add()</li>
 * <li>Lanza la aplicación empleando el método run()</li>
 * </ol>
 *  
 * @param T Tipo del modelo de la aplicación
 */
public class AplicacionConsolaMenu<T> {
  
  // Constantes
  // Opción de salir
  private static final int OPCION_SALIR = 0;
  // Texto de salir
  private static final String TITULO_SALIR = "Salir";

  // Atributos
  // Titulo de la aplicación
  private String titulo;
  // Modelo de la aplicación (datos de la aplicación)
  private T modelo;
  // Comandos de la aplicación
  private List<Comando<T>> comandos;
  // Consola para la interación con el usuario
  Consola consola;
  
  /**
   * Constructor
   * @param titulo Título de la aplicación. No debe ser null. Este título se mostrará en el menú de
   * la aplicación
   * @param modelo Modelo de la aplicación sobre el que trabajan los comandos. Este modelo se le
   * proporcionará a todos los comandos cuando se invoque y los comandos operan sobre él.
   */
  public AplicacionConsolaMenu(String titulo, T modelo) {
    this.titulo = titulo;
    this.modelo = modelo;
    // Inicializamos la lista de comandos a no comandos
    comandos = new ArrayList<>();
    // Y obtenemos la consola
    consola = Consola.getInstancia();
  }
  
  /**
   * Añade un nuevo comando a la aplicación
   * @param comando Comando a añadir a la aplicación
   */
  public void addComando(Comando<T> comando) {
    comandos.add(comando);
  }
  
  /**
   * Lanza la aplicación. La aplicación realiza un ciclo en el que muestra el menu y realiza el
   * comando requerido, terminando cuando se selecciona la opción de salir 
   */
  public void run() {
    // Iniciamos la opción (el valor se va a modificar)
    int opcion = OPCION_SALIR;
    do {
      // Mostramos el menú y leemos la opción elegida
      opcion = mostrarMenu();
      // Si no es la opción de salir
      if (opcion != OPCION_SALIR) {
        // Lanzamos el comando asociado a la opción elegida, pasando el modelo
        comandos.get(opcion - 1).hacer(consola, modelo);
      }
    } while (opcion != OPCION_SALIR);
  }

  /**
   * Muestra el menu y devuelve la opción elegida. Si la opción elegida no es correcta vuelve a
   * intentarlo hasta que se introduce una opción correcta
   * @return Opción elegida 
   */
  private int mostrarMenu() {
    // Ciclo infinito. Se sale por return
    for (;;) {
      // Imprimimos el título
      consola.imprimeTitulo(titulo);
      // Imprimimos el menu
      // Número de la opción
      int numeroOpcion = 1;
      // Para cada comando
      for (Comando<T> comando: comandos) {
        // Imprimimos la línea
        consola.imprimeLinea(String.format("%d - %s", numeroOpcion++, comando.getTitulo()));
      }
      // Añadimos la opción de salir
      consola.imprimeLinea(String.format("%d - %s", OPCION_SALIR, TITULO_SALIR));
      // Solicitamos la opción
      int opcion = consola.solicitaEntero(String.format("Introduzca la opción seleccionada (0-%d): ", numeroOpcion - 1), 0, numeroOpcion - 1);
      // Devuelve la opción seleccionada
      return opcion;
    }
  }

}
