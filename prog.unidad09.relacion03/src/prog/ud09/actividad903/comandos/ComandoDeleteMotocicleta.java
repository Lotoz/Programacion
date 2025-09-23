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
    String referencia = consola.solicitaTexto("Introduzca la referencia de la motocicleta a eliminar: ", 1, null, null,
        "Error. La referencia no puede ser vacía");
    /**
     * El metodo preguntar al usuario si desea eliminar o no, lo he implementado yo
     */
    // Le consultamos al usuario si desea eliminar la moto
    // Metodo de confirmacion para el usuario
    boolean confirmacion = solicitarConfirmacion(
        "¿Está seguro de que desea eliminar la motocicleta con referencia " + referencia + "? (s/n) ", consola);
    if (!confirmacion) {
      consola.imprimeLinea("Eliminación cancelada.");
    } else {
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
  
  /**
   * Solicita la confirmacion al usuario con consola
   *
   * @param mensaje
   * @return devuelve true si el usuario confirma
   */
  private boolean solicitarConfirmacion(String mensaje, Consola consola) {
    // Uso de la clase consola para pedir la cadena al usuario
    // He limitado que solo pueda meter un caracter, solo pueda ser s o n y en caso
    // de introducirlo incorrecto muestre el mensaje de error
    String respuesta = consola.solicitaTexto(mensaje, 1, 1, "[sSnN]",
        "El caracter introducido no es valido,ingrese (s/n).");
    // Retorna true si la respuesta es 's' o 'S'
    return respuesta.equalsIgnoreCase("s");
  }
}
