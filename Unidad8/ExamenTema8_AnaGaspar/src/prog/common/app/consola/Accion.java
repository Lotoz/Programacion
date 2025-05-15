package prog.common.app.consola;

/**
 * Accion de menu para aplicación de consola<br>
 * Las acciones reales deben heredar de esta clase e implementar sus propias interacciones
 */
public abstract class Accion {
  
  // Atributos
  // Titulo de la acción
  protected String titulo;
  // Aplicacion a la que pertenece la accion
  protected AplicacionConsola aplicacion;

  /**
   * Constructor con aplicacion y titulo
   * @param aplicacion Aplicacion en la que se ejecuta la acción
   * @param titulo Titulo de la accion
   */
  public Accion(AplicacionConsola aplicacion, String titulo) {
    this.aplicacion = aplicacion;
    this.titulo = titulo;
  }
  
  /**
   * Constructor con titulo
   * @param titulo Titulo de la aplicacion
   */
  public Accion(String titulo) {
    this(null, titulo);
  }
  
  /**
   * Obtiene el titulo
   * @return Titulo
   */
  public String getTitulo() {
    return titulo;
  }
  
  /**
   * Obtiene la aplicación a la que pertenece la accion
   * @return Aplicación a la que pertenece la acción o null si no pertenece a ninguna aplicacion
   */
  public AplicacionConsola getAplicacion() {
    return aplicacion;
  }

  /**
   * Asigna la aplicación a la que pertenece la accion
   * @param aplicacion Aplicacion a la que pertenece la accion. Puede ser null para que la accion
   *   no pertenezca a ninguna aplicaicon
   */
  public void setAplicacion(AplicacionConsola aplicacion) {
    this.aplicacion = aplicacion;
  }

  /**
   * Ejecuta la accion. Realiza las acciones de interfaz necesarias para realizar la accion
   */
  public abstract void ejecutar();

}
