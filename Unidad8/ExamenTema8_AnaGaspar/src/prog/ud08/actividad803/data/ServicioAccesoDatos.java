package prog.ud08.actividad803.data;

import prog.ud08.actividad803.modelo.Cliente;
import prog.ud08.actividad803.modelo.Motocicleta;

/**
 * Servicio de acceso a datos
 */
public interface ServicioAccesoDatos {
  
  /**
   * Almacena una nueva motocicleta
   * @param motocicleta Motocicleta a almacenar
   * @throws ServicioAccesoDatosException Si se produce algún error en el acceso a la base de datos
   */
  void addMotocicleta(Motocicleta motocicleta);
  
  /**
   * Registra una nueva venta en la fecha actual
   * @param nifCliente NIF del cliente que compra. Debe existir un cliente con este NIF
   * @param referenciaMotocicleta Referencia a la moto que se vende. Debe existir una moto con esta
   *   referencia
   * @return Código de la nueva venta, si todo tuvo éxito
   * @throws ServicioAccesoDatosException Si no se pudo realizar la creación porque ocurrió algún
   *   error accediendo a la base de datos, no se puede obtener el código o no existe el cliente
   *   con el NIF proporcionado o la motocicleta con la referencia proporcionada
   */
  int registrarVenta(String nifCliente, String referenciaMotocicleta);
  
  /**
   * Obtiene todas las ventas
   * @param visitador Visitador que se llamará una vez por cada fila de la tabla. Se invocará el
   * método visitaFila del objeto una vez por cada fila del resultado. Este método debe devolver un
   * booleano que indica que se debe continuar con el proceso (true) o abortar (false). El proceso
   * termina en cualquier caso cuando no hay más resultados
   * @throws ServicioAccesoDatosException Si ocurre algún error accediendo a la base de datos
   */
  void getAllVentas(VisitadorVentas visitador);
  
  /**
   * Obtiene un cliente a partir de su NIF
   * @param nif NIF del cliente a buscar
   * @return Cliente con el NIF indicado, si existe. null si no se encuentra un cliente con el NIF proporcionado
   * @throws ServicioAccesoDatosException Si ocurrió cualquier error accediendo a la base de datos
   */
  Cliente getClienteByNif(String nif);

  /**
   * Actualiza el cliente cuyos datos se proporcionan
   * @param cliente Cliente a actualizar. El NIF debe corresponder con el de un cliente ya existente
   * @throws ServicioAccesoDatosException Si no existe un cliente con el NIF dado, el NIF del
   *   cliente recomendado no es NULL y no existe ningún cliente con dicho NIF o se produjo un error
   *   accediendo a la base de datos
   */
  void updateCliente(Cliente cliente);
  
  /**
   * Elimina una motocicleta por su referencia. También elimina todas las ventas en las que participa esta motocicleta
   * @param referencia Referencia de la motocicleta a eliminar
   * @throws ServicioAccesoDatosException Si no existe ninguna motocicleta con la referencia
   *   proporcionada u ocurrió un error accediendo a la base de datos
   */
  void deleteMotocicleta(String referencia);
  
}
