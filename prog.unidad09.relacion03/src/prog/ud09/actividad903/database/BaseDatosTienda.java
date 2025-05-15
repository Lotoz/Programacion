package prog.ud09.actividad903.database;

import prog.unidad09.relacion03.datos.Cliente;
import prog.unidad09.relacion03.datos.Motocicleta;

public interface BaseDatosTienda {

  /**
   * Añade una nueva motocicleta
   * @param motocicleta Motocicleta a añadir. Su referencia no puede coincidir con la de otra
   * motocicleta ya existente en la base de datos y ninguno de sus campos de texto puede ser null
   * o estar vacíos o contener sólo blancos
   * @throws BaseDatosTiendaException Si ya existe alguna motocicleta con la misma referencia o 
   * alguno de los campos no cumple los requisitos
   */
  void addMotocicleta(Motocicleta motocicleta);

  /**
   * Añade una nueva venta
   * @param cliente Cliente al que se le vende la motocicleta
   * @param motocicleta Motocicleta que se vende
   * @return Código de la nueva venta
   * @throws BaseDatosTiendaException Si alguno de los datos no es null
   */
  int addVenta(Cliente cliente, Motocicleta motocicleta);

  /**
   * Obtiene un cliente a partir de su nif
   * @param nif NIF del cliente
   * @return Cliente con el NIF proporcionado o null si no se encontró
   */
  Cliente getClienteByNif(String nif);

  /**
   * Busca una motocicleta a partir de su referencia
   * @param referencia Referencia de la motocicleta a encontrar. No puede ser null
   * @return Motocicleta con la referencia dada o null si no se encontró
   */
  Motocicleta getMotocicletaByReferencia(String referencia);

  /**
   * Obtiene todas las ventas, sin orden específico
   * @param procesadorVenta Procesador de ventas que se llamará para cada venta
   */
  void getAllVentas(ProcesadorVenta procesador);

  /**
   * Actualiza un cliente 
   * @param cliente Cliente a actualizar
   * @throws BaseDatosTiendaException Si el cliente no existe previamente o alguno de los datos no
   * es válido
   */
  void updateCliente(Cliente cliente);

  /**
   * Elimina una motocicleta a partir de la referencia
   * @param referencia Referencia de la motocicleta a eliminar
   * @throws BaseDatosTiendaException Si no existe motocicleta con la referencia especificada
   */
  void deleteMotocicletaByReferencia(String referencia);

  /**
   * Cierra la conexión con la base de datos
   */
  void cerrar();

  
}