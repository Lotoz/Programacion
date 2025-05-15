package prog.ud08.actividad803.acciones;

import java.io.PrintStream;
import prog.common.app.consola.AplicacionConsola;
import prog.common.app.consola.Consola;
import prog.ud08.actividad803.data.ServicioAccesoDatosException;
import prog.ud08.actividad803.modelo.Cliente;

/**
 * Accion para registro de una venta
 */
public class AccionRegistroVenta extends AccionBase {

  /**
   * Constructor con titulo
   * @param titulo Titulo de la accion
   */
  public AccionRegistroVenta(String titulo) {
    super(titulo);
  }

  @Override
  public void ejecutar() {
    // Accedemos a la consola
    Consola consola = Consola.getConsola();
    
    // Titulo
    imprimeTitulo();
    
    // Solicita los datos de la venta
    // NIF del cliente
    String nif = consola.leeCadena("Introduzca el NIF del cliente (debe ser igual al de un cliente ya existente", "[0-9]{8}[A-Z]");
    String referencia = consola.leeCadena("Introduzca la referencia de la motocicleta (debe ser igual a la de una motocicleta ya existente", null);
    
    try {
      // Intenta almacenar la venta usando el servicio de acceso a datos
      int codigoVenta = getServicioAccesoDatos().registrarVenta(nif, referencia);
      // Si la venta se produjo
      if (codigoVenta >= 0) {
        //  Mensajito
        consola.escribeLinea(String.format("La venta se registró con éxito. El código de la nueva venta es %d", codigoVenta));
      } else {
        // Error
        consola.escribeLinea("No se pudo registrar la venta. Compruebe que el NIF y la referencia son correctos");
      }
    } catch (IllegalArgumentException e) {
      // Alguno de los campos está vacío
      consola.escribeLinea("No se pudo registrar la venta");
    } catch (ServicioAccesoDatosException e) {
      consola.escribeLinea("No se pudo realizar la venta porque no existe cliente con el NIF proporcionado o no existe motocicleta con la referencia proporcionada");
    }
  }

}
