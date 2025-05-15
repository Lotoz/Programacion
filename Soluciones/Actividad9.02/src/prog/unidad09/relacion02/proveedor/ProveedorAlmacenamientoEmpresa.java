package prog.unidad09.relacion02.proveedor;

import java.util.List;
import prog.unidad09.relacion02.datos.Centro;
import prog.unidad09.relacion02.datos.Departamento;
import prog.unidad09.relacion02.datos.Empleado;

/**
 * Proveedor de almacenamiento para los objetos de la empresa
 */
public interface ProveedorAlmacenamientoEmpresa {

  /**
   * Obtiene un centro a partir de su código
   * @param codigo Código del centro a obtener
   * @return Centro con el código proporcionado o null si no existe un centro con ese código
   * @throws ProveedorAlmacenamientoEmpresaException Si ocurrió algún error accediendo al
   *   almacenamiento
   */
  Centro getCentroByCodigo(int codigo);
  
  /**
   * Obtiene todos los centros almacenados
   * @param ordenarPorNombre true si se desean obtener los centros ordenados por nombre en orden
   *   ascendente. false si no importa el orden en que aparecen los centros en la lista
   * @return Lista con todos los centros almacenados, posiblemente ordenada. Vacía si no hay centros
   * @throws ProveedorAlmacenamientoEmpresaException Si ocurrió algún error accediendo al
   *   almacenamiento
   */
  List<Centro> getAllCentro(boolean ordenarPorNombre);
  
  /**
   * Añade un nuevo centro
   * @param centro Centro a añadir. El código del centro se ignora y se genera uno automáticamente.
   * @return Centro almacenado. El nombre será el mismo que el del centro de entrada pero el código
   *   será el que ha generado el sistema automáticamente. El mismo si no se pudo realizar la
   *   inserción
   * @throws NullPointerException Si centro es null
   * @throws ProveedorAlmacenamientoEmpresaException Si ocurrió algún error accediendo al
   *   almacenamiento.
   */
  Centro addCentro(Centro centro);
  
  /**
   * Actualiza un centro en el almacenamiento
   * @param centro Centro a actualizar. Debe existir previamenteun centro con el mismo código en el
   *   almacenamiento. No puede ser null
   * @throws NullPointerException Si centro es null
   * @throws ProveedorAlmacenamientoEmpresaException Si ocurrió algún error accediendo al
   *   almacenamiento o no existe un centro en el almacenamiento con el código del centro
   *   proporcionado
   */
  void updateCentro(Centro centro);
  
  /**
   * Elimina un centro del almacenamiento a partir de su código
   * @param codigo Código del centro a eliminar del almacenamiento
   * @throws ProveedorAlmacenamientoEmpresaException Si ocurrió algún error accediendo al
   *   almacenamiento o no existe un centro en el almacenamiento con el código proporcionado
   */
  void deleteCentroByCodigo(int codigo);
  
  /**
   * Obtiene todos los departamentos almacenados
   * @param ordenarPorNombre true si los departamentos se deben devolver ordenados por nombre,
   *   false si no es necesario
   * @return Lista con los departamentos. Puede estar vacía
   * @throws ProveedorAlmacenamientoEmpresaException Si ocurrió algún error accediendo al
   *   almacenamiento
   */
  List<Departamento> getAllDepartamento(boolean ordenarPorNombre);
  
  /**
   * Obtiene un departamento a partir de su código
   * @param codigo Código del departamento a obtener
   * @return Departamento con el código especificado o null si no existe un departamento con el
   *   código especificado
   * @throws ProveedorAlmacenamientoEmpresaException Si ocurrió algún error accediendo al
   *   almacenamiento
   */
  Departamento getDepartamentoByCodigo(int codigo);
  
  /**
   * Añade un nuevo departamento
   * @param departamento Departamento a añadir. El código del departamento se ignora y se genera
   *   uno automáticamente.
   * @return Departamento almacenado. Todos los datos serán iguales a los del departamento de
   *   entrada pero el código será el que ha generado el sistema automáticamente. El mismo si no se
   *   pudo realizar la inserción
   * @throws NullPointerException Si departamento es null
   * @throws ProveedorAlmacenamientoEmpresaException Si ocurrió algún error accediendo al
   *   almacenamiento.
   */
  Departamento addDepartamento(Departamento departamento);
  
  /**
   * Actualiza un departamento en el almacenamiento
   * @param departamento Departamento a actualizar. Debe existir previamente un departamento con el
   * mismo código en el almacenamiento. No puede ser null
   * @throws NullPointerException Si departamento es null
   * @throws ProveedorAlmacenamientoEmpresaException Si ocurrió algún error accediendo al
   *   almacenamiento o no existe un departamento en el almacenamiento con el código del
   *   departamento proporcionado
   */
  void updateDepartamento(Departamento departamento);
  
  /**
   * Elimina un departamento del almacenamiento a partir de su código
   * @param codigo Código del departamento a eliminar del almacenamiento
   * @throws ProveedorAlmacenamientoEmpresaException Si ocurrió algún error accediendo al
   *   almacenamiento o no existe un departamento en el almacenamiento con el código proporcionado
   */
  void deleteDepartamentoByCodigo(int codigo);
  
  /**
   * Obtiene un empleado a partir de su código
   * @param codigo Código del empleado a obtener
   * @return Empleado con el código especificado o null si no existe un empleado con el
   *   código especificado
   * @throws ProveedorAlmacenamientoEmpresaException Si ocurrió algún error accediendo al
   *   almacenamiento
   */
  Empleado getEmpleadoByCodigo(int codigo);
  
  /**
   * Cierra la conexión con el proveedor de almacenamiento, liberando los recursos
   */
  void cerrar();
}
