package prog.ud05.actividad511.coleccion;

/**
 * Interface que implementan las clases que proveen (obtienen) la información de
 * los usuarios desde una fuente externa (archivo, base de datos, etc.)
 */
public interface ProveedorUsuarios {

  /**
   * Obtiene los usuarios desde la fuente de datos
   * 
   * @return Contenedor con los usuarios si todo fue OK. Vacío o incompleto en
   *         caso de error
   * @throws ProveedorUsuariosException Si hay algún error obteniendo la
   *                                    información
   */
  Usuarios obtieneUsuarios() throws ProveedorUsuariosException;
}
