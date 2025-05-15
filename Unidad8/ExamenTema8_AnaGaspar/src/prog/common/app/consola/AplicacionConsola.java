package prog.common.app.consola;

import java.util.HashMap;
import java.util.Map;

/**
 * Aplicacion de Consola general
 */
public abstract class AplicacionConsola {
  
  // Atributos
  // Información configuración
  protected Map<String, Object> configuracion;
  
  /**
   * Constructor
   */
  public AplicacionConsola() {
    configuracion = new HashMap<>();
  }
  
  /**
   * Añade información de configuración a la aplicacion
   * @param nombre Nombre del parámetro de configuración
   * @param informacion Información del parámetro
   */
  public void addConfiguracion(String nombre, Object informacion) {
    configuracion.put(nombre, informacion);
  }
  
  /**
   * Obtiene el objeto de configuracion con el nombre dado
   * @param nombre Nombre del objeto de configuracion a obtener
   * @return Objeto de configuración con el nombre dado o null si no hay ninguno
   */
  public Object getConfiguracion(String nombre) {
    return configuracion.get(nombre);
  }
  
  /**
   * Inicia la aplicación
   */
  public abstract void inicia();

}