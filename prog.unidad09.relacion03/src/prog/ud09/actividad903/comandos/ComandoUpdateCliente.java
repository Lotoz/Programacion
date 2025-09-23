package prog.ud09.actividad903.comandos;

import prog.common.consola.Consola;
import prog.common.ui.Comando;
import prog.ud09.actividad903.database.BaseDatosTienda;
import prog.unidad09.relacion03.datos.Cliente;

/**
 * Comando para actualizar un cliente
 */
public class ComandoUpdateCliente extends Comando<BaseDatosTienda> {

  /**
   * Constructor
   * @param titulo Titulo del comando
   */
  public ComandoUpdateCliente(String titulo) {
    super(titulo);
  }

  /**
   * Procesa el comando. Actualiza un cliente
   */
  @Override
  public void hacer(Consola consola, BaseDatosTienda modelo) {
    // Mostramos cabecera de comando
    consola.imprimeTitulo(getTitulo().toUpperCase());
    
    // Solicitamos el nif del cliente
    String nif = consola.solicitaTexto("Introduzca el NIF del cliente a modificar: ", 9, 9, "[0-9]{8}[A-Z]", "ERROR. NIF incorrecto. Debe constar de 8 números y una letra mayúscula, sin espacios");
    
    // Intenta localizar al cliente
    Cliente cliente = modelo.getClienteByNif(nif);
    
    // Si se encontró
    if (cliente != null) {
      // Solicita los nuevos datos del cliente
      String nombre = consola.solicitaTexto(String.format("Introduzca el nuevo nombre del cliente (nombre actual: %s): ", cliente.getNombre()),
          1, null, ".*\\S.*", "ERROR: El nombre no puede dejarse en blanco");
      String apellidos = consola.solicitaTexto(String.format("Introduzca los nuevos apellidos del cliente (apellidos actuales: %s): ", cliente.getApellidos()),
          1, null, ".*\\S.*", "ERROR: Los apellidos no pueden dejarse en blanco");
      String direccion = consola.solicitaTexto(String.format("Introduzca la nueva dirección del cliente (dirección actual: %s): ", cliente.getDireccion()),
          1, null, ".*\\S.*", "ERROR: La dirección no pueden dejarse en blanco");
      // Obtenemos el NIF del recomendado actual
      String nifRecomendadoActual = cliente.getRecomendadoPor() == null ? "(Ninguno)" : cliente.getRecomendadoPor().getNif();
      String nifRecomendado = consola.solicitaTexto(String.format("Introduzca el NIF del cliente que recomendó a éste (NIF actual %s). Vacío para ninguno): ", nifRecomendadoActual),
          0, 9, "([0-9]{8}[A-Z])?", "ERROR. NIF incorrecto. Debe dejarse en blanco o constar de 8 números y una letra mayúscula, sin espacios");
      // Intentamos acceder al cliente recomendado, si se ha proporcionado
      Cliente clienteRecomendado = null;
      if (nifRecomendado.length() > 0) {
        clienteRecomendado = modelo.getClienteByNif(nifRecomendado);
        // Si no existe
        if (clienteRecomendado == null) {
          // Error
          consola.imprimeLinea(String.format("ERROR: No se encuentra al cliente recomendado con NIF %s", nifRecomendado));
          return;
        }
      }
      // Actualizamos el cliente
      cliente.setNombre(nombre);
      cliente.setApellidos(apellidos);
      cliente.setDireccion(direccion);
      cliente.setRecomendadoPor(clienteRecomendado);
      modelo.updateCliente(cliente);
      consola.imprimeLinea("El cliente se actualizo con éxito.");
    } else {
      // No se encontró cliente con el NIF proporcionado
      consola.imprimeLinea(String.format("No existe cliente con el NIF proporcionado (%s)", nif));
    }
  }

}
