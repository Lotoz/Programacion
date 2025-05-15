package prog.ud08.actividad803.acciones;

import java.io.PrintStream;
import prog.common.app.consola.Accion;
import prog.common.app.consola.AplicacionConsola;
import prog.common.app.consola.Consola;
import prog.ud08.actividad803.data.ServicioAccesoDatos;

/**
 * Clase base para todas las acciones de la aplicacion<br>
 * Añade acceso a la configuración de forma sencilla
 */
public abstract class AccionBase extends Accion {

  /**
   * Constructor
   * @param aplicacion Aplicacion a la que pertenece la accion
   * @param titulo Titulo de la accion
   */
  public AccionBase(AplicacionConsola aplicacion, String titulo) {
    super(aplicacion, titulo);
  }

  /**
   * Constructor con titulo
   * @param titulo Titulo de la aplicacion
   */
  public AccionBase(String titulo) {
    super(titulo);
  }
  
  /**
   * Obtiene el servicio de acceso a datos de la aplicación
   * @return Servicio de acceso a datos de la aplicación
   */
  public ServicioAccesoDatos getServicioAccesoDatos() {
    // Si estamos conectados a una aplicación y el objeto existe en la configuracion
    if (aplicacion != null) {
      Object sad = aplicacion.getConfiguracion("ServicioAccesoDatos");
      // Si el objeto existe
      if (sad != null && sad instanceof ServicioAccesoDatos) {
        // Lo devuelve 
        return (ServicioAccesoDatos)sad;
      } else {
        // Si no existe devuelve null
        return null;
      }
    } else {
      // Si no hay aplicacion devuelve null
      return null;
    }
  }
  
  /**
   * Imprime el titulo de la accion
   */
  protected void imprimeTitulo() {
    // Imprime el titulo
    Consola.getConsola().escribeTitulo(titulo);
  }

}
