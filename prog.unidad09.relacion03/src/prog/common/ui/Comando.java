package prog.common.ui;

import prog.common.consola.Consola;

/**
 * Comando de aplicación
 * @param T Tipo del modelo de la aplicación
 */
public abstract class Comando<T> {

  // Atributos
  // Titulo del comando
  private String titulo;
  
  
  /**
   * Constructor con titulo
   * @param titulo Titulo del comando
   */
  public Comando(String titulo) {
    this.titulo = titulo;
  }
  
  /**
   * Obtiene el titulo del comando
   * @return Titulo del comando
   */
  public String getTitulo() {
    return titulo;
  }
  
  /**
   * Realiza el comando
   * @param consola Consola sobre la que se debe trabajar
   * @param T modelo. Modelo sobre el que trabaja el comando
   */
  public abstract void hacer(Consola consola, T modelo);

}
