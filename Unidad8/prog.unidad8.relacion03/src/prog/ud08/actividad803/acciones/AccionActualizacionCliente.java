package prog.ud08.actividad803.acciones;

import java.io.PrintStream;

import prog.common.app.consola.Consola;
import prog.ud08.actividad803.data.ServicioAccesoDatos;
import prog.ud08.actividad803.data.ServicioAccesoDatosException;
import prog.ud08.actividad803.modelo.Cliente;

/**
 * Accion Actualizar cliente
 */
public class AccionActualizacionCliente extends AccionBase {

  /**
   * Constructor con titulo
   * @param titulo Titulo de la acción
   */
  public AccionActualizacionCliente(String titulo) {
    super(titulo);
  }

  @Override
  public void ejecutar() {
    // Accedemos a la consola
    Consola consola = Consola.getConsola();
    
    // Titulo
    imprimeTitulo();
    
    // Servicio de acceso a datos
    ServicioAccesoDatos servicio = getServicioAccesoDatos();
    
    // Solicita el nif del cliente
    String nif = consola.leeCadena("Introduzca el NIF del cliente a modificar", "[0-9]{8}[A-Z]");
    // Obtiene el cliente
    Cliente cliente = servicio.getClienteByNif(nif);
    
    // Si existe
    if (cliente != null) {
      // Solicita los datos del cliente
      String prompt = String.format("Introduzca el nuevo nombre del cliente (nombre actual: %s)", cliente.getNombre());
      String nombre = consola.leeCadena(prompt, null);
      prompt = String.format("Introduzca los nuevos apellidos del cliente (apellidos actuales: %s)", cliente.getApellidos());
      String apellidos = consola.leeCadena(prompt, null);
      prompt = String.format("Introduzca la nueva dirección del cliente (dirección actual: %s)", cliente.getDireccion());
      String direccion = consola.leeCadena(prompt, null);
      prompt = String.format("Introduzca nuevo NIF del cliente que recomendó a este del cliente (NIF actual: %s. Vacío para ninguno)", (cliente.getNifRecomendado() == null ? "(Ninguno)" : cliente.getNifRecomendado()));
      String nifRecomendado = consola.leeCadena(prompt, null);
      nifRecomendado = nifRecomendado.isEmpty() ? null : nifRecomendado;
      
      try {
        // Intenta crear el cliente (esto puede lanzar IllegalArgumentException si alguno de los valores no es correcto
        cliente = new Cliente(nif, nombre, apellidos, direccion, nifRecomendado);
        
        // Intenta actualizar el cliente usando el servicio de acceso a datos
        getServicioAccesoDatos().updateCliente(cliente);
      } catch (IllegalArgumentException e) {
        // Alguno de los campos está vacío
        consola.escribeLinea("Alguno de los valores introducidos no es correcto. Actualizaciónn de cliente abortada");
      } catch (ServicioAccesoDatosException e) {
        consola.escribeLinea("No se puede actualizar el cliente porque no existe el NIF del cliente recomendado especificado");
      }
    } else {
      // El cliente no existe. Mensaje y terminamos
      consola.escribeLinea(String.format("No existe cliente con el NIF proporcionado (%s)", nif));
    }
  }

}
