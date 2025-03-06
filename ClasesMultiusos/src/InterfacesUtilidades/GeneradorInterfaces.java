package InterfacesUtilidades;

/**
 * Constructor de interfaces con metodos capaces de generar rapidamente una
 * interfaz simple para el usuario Funciona por un metodo singleton
 */
public class GeneradorInterfaces {

  /** Instancia única de GeneradorInterfaces */
  private static GeneradorInterfaces generadorGUI = null;

  /**
   * Constructor privado para evitar la instanciación externa.
   */
  private GeneradorInterfaces() {
  }

  /**
   * Método para obtener la instancia única de GeneradorInterfaces. Si la
   * instancia no existe, se crea una nueva.
   *
   * @return La instancia única de ConsolaScan.
   */
  public static GeneradorInterfaces getInstance() {
    String cadena = "GeneradorInterfaces";
    if (generadorGUI == null) {
      // Crea una nueva instancia de GeneradorInterfaces
      generadorGUI = new GeneradorInterfaces();
    } else {
      try {
        generadorGUI.clone();
      } catch (CloneNotSupportedException e) {
        System.err.println("No se pueden crear dos instancias.");
      }
    }
    return generadorGUI;
  }

  /**
   * Método que evita la clonación de la instancia de GeneradorInterfaces. Lanza
   * una excepción CloneNotSupportedException si se intenta clonar.
   *
   * @return null, ya que la clonación no está permitida.
   */
  @Override
  public GeneradorInterfaces clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException();
  }

  /*
   * Creacion de metodos de generacion de interfaces
   */
  /*
   * Primero hacer las actividades y entorno a eso, ver lo mas repetitivo y crear metodos aqui
   * Metodos a crear. Lista
   * Creacion de ventanas de estas seguro
   * controlar listas 
   * Cambiar seleccion,
   * Mostrar nombres
   * Clases que se usan JoptionPaint creo
   * Botonos de eliminacion
   * Analizar la documentacion de Swing
   * Los mensajes de error son por label, Se podria plantear la creacion de una clase como consolaException pero para imprimir errores por interfaz
   * El pequeño problema al generar ventanas es como carajo controlamos los problemas o errores de usuario. Ya que no hay tanto control
   * Te quedas a la espera del usuario
   */
}
