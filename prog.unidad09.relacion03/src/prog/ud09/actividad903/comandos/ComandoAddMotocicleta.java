package prog.ud09.actividad903.comandos;

import prog.common.consola.Consola;
import prog.common.ui.Comando;
import prog.ud09.actividad903.database.BaseDatosTienda;
import prog.ud09.actividad903.database.BaseDatosTiendaException;
import prog.unidad09.relacion03.datos.Motocicleta;

/**
 * Comando para añadir motocicleta
 */
public class ComandoAddMotocicleta extends Comando<BaseDatosTienda> {

  /**
   * Constructor
   * @param titulo Titulo del comando
   */
  public ComandoAddMotocicleta(String titulo) {
    super(titulo);
  }

  /**
   * Procesa el comando. Añade una motocicleta al modelo, solicitando la información al usuario
   */
  @Override
  public void hacer(Consola consola, BaseDatosTienda modelo) {
    // Mostramos cabecera de comando
    consola.imprimeTitulo(getTitulo().toUpperCase());
    
    // Solicitamos los datos
    String referencia = consola.solicitaTexto("Introduzca la referencia de la motocicleta (no puede ser igual a la de una motocicleta ya existente): ", 1, null, null, "ERROR. La referencia no puede estar vacía");
    int cilindrada = consola.solicitaEntero("Introduzca la cilindrada de la motocicleta, en CC (debe ser mayor a cero): ", 1, null);
    String tipo = consola.solicitaTexto("Introduzca el tipo de la motocicleta (no puede dejarse vacío o contener sólo blancos): ", 1, null, null, "ERROR. El tipo de la motocicleta no pude dejarse vacío o contener sólo blancos");
    double precio = consola.solicitaDoble("Introduzca el precio de la motocicleta (usar . para separar parte entera y decimal. No negativo): ", 0.0, null);
    String fabricante = consola.solicitaTexto("Introduzca el fabricante de la motocicleta (no puede dejarse vacío o contener sólo blancos): ", 1, null, null, "ERROR. El tipo de la motocicleta no pude dejarse vacío o contener sólo blancos");
    // Intenta crear e insertar la motocicleta
    try {
      modelo.addMotocicleta(new Motocicleta(referencia, cilindrada, tipo, precio, fabricante));
      // Mensaje de insercion correcta
      consola.imprimeLinea("La motocicleta se insertó con éxito");
    } catch (BaseDatosTiendaException e) {
      consola.imprimeLinea("No se puede insertar la motocicleta porque ya existe una con la misma referencia");
    }
  }

}
