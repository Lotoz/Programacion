package prog.ud09.actividad903.comandos;

import prog.common.consola.Consola;
import prog.common.ui.Comando;
import prog.ud09.actividad903.database.BaseDatosTienda;
import prog.ud09.actividad903.database.BaseDatosTiendaException;
import prog.unidad09.relacion03.datos.Cliente;
import prog.unidad09.relacion03.datos.Motocicleta;

/**
 * Comando para registrar una venta
 */
public class ComandoAddVenta extends Comando<BaseDatosTienda> {

  /**
   * Constructor
   * @param titulo Titulo del comando
   */
  public ComandoAddVenta(String titulo) {
    super(titulo);
  }

  /**
   * Procesa el comando. Añade una venta al modelo, solicitando los datos de cliente y vehiculo
   */
  @Override
  public void hacer(Consola consola, BaseDatosTienda modelo) {
    // Mostramos cabecera de comando
    consola.imprimeTitulo(getTitulo().toUpperCase());
    
    // Solicitamos los datos
    String nif = consola.solicitaTexto("Introduzca el NIF del cliente (debe ser igual al de un cliente ya existente ya existente): ", 1, null, null, "ERROR. El NIF no puede estar vacío");
    String referencia = consola.solicitaTexto("Introduzca la referencia de la motocicleta (debe ser igual al de una motocicleta ya existente ya existente): ", 1, null, null, "ERROR. La referencia no puede estar vacía");
    
    // Localiza el cliente y la motocicleta
    Cliente cliente = modelo.getClienteByNif(nif);
    Motocicleta motocicleta = modelo.getMotocicletaByReferencia(referencia);
    
    // Intenta crear e insertar la venta
    try {
      int codigo = modelo.addVenta(cliente, motocicleta);
      // Mensaje de insercion correcta
      consola.imprimeLinea(String.format("La motocicleta se insertó con éxito. El código de la nueva venta es %d", codigo));
    } catch (BaseDatosTiendaException e) {
      consola.imprimeLinea("No se puede insertar la venta");
    }
  }

}
