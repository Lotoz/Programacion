package Ejercicio01;

import java.sql.SQLException;
import java.util.List;

/**
 * Una interfaz que maneja diversos metodos entorno a la base de datos poblacion
 * Son 5 metodos
 * Añadir poblacion
 * Dos para listar
 * Modificar
 * Eliminar
 */
public interface BaseDatosPoblacion {

  /**
   * Añade una poblacion a la base de datos
   * @param poblacion
   * @return
   * @throws SQLException 
   */
  public void addPoblacion(Poblacion poblacion) throws SQLException;
  
  /**
   * Obtiene todas las poblaciones creadas
   * Basado en el filtro, nombre, minPob y MaxPob
   * @return list
   * @throws SQLException 
   */
  public List<Poblacion> consultaPoblacion(String nombre, int MinPob, int MaxPob) throws SQLException;
  
  /**
   * Obtiene todas las poblaciones creada ordenadas por un valor seleccionado por el usuario
   * @param String orden
   * @return list
   */
  public List<Poblacion> consultaPoblacionOrdn(String nombre, int MinPob, int MaxPob);
  
  /**
   * Modifica la base de datos
   */
  public void modificaPoblacion(Poblacion poblacion);
  
  /**
   * Eliminar poblaciones
   */
  public void eliminaPoblaciones(String opcion);
}
