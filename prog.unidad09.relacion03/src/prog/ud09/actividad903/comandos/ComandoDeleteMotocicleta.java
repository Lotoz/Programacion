package prog.ud09.actividad903.comandos;

import prog.common.consola.Consola;
import prog.common.ui.Comando;
import prog.ud09.actividad903.database.BaseDatosTienda;
import prog.ud09.actividad903.database.BaseDatosTiendaException;

/**
 * Comando para eliminar una motocicleta
 */
public class ComandoDeleteMotocicleta extends Comando<BaseDatosTienda> {

  /**
   * Constructor
   * @param titulo Titulo del comando
   */
  public ComandoDeleteMotocicleta(String titulo) {
    super(titulo);
  }

  /**
   * Procesa el comando. Elimina una motocicleta
   */
  @Override
  public void hacer(Consola consola, BaseDatosTienda modelo) {
    // Mostramos cabecera de comando
    consola.imprimeTitulo(getTitulo().toUpperCase());
    
    // Solicita la referencia de la motocicleta a eliminar
    String referencia = consola.solicitaTexto("Introduzca la referencia de la motocicleta a eliminar: ", 1, null, null, "Error. La referencia no puede ser vacía");
    
    // Y la intenta eliminar
    try {
      modelo.deleteMotocicletaByReferencia(referencia);
      consola.imprimeLinea("Se eliminó la motocicleta correctamente");
    } catch (BaseDatosTiendaException e) {
      // Error
      consola.imprimeLinea("No se encuentra la motocicleta con la referencia especificada");
    }
  }

}
