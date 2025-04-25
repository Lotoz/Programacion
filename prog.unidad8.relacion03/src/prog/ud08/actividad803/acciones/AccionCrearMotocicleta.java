package prog.ud08.actividad803.acciones;

import java.io.PrintStream;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

import prog.common.app.consola.AplicacionConsola;
import prog.common.app.consola.Consola;
import prog.ud08.actividad803.data.ServicioAccesoDatosException;
import prog.ud08.actividad803.modelo.Cliente;
import prog.ud08.actividad803.modelo.Motocicleta;

/**
 * Accion Crear Motocicleta
 */
public class AccionCrearMotocicleta extends AccionBase {

  /**
   * Constructor con titulo
   * @param titulo Titulo de la accion
   */
  public AccionCrearMotocicleta(String titulo) {
    super(titulo);
  }

  @Override
  public void ejecutar() {
    // Accedemos a la consola
    Consola consola = Consola.getConsola();
    
    // Titulo
    imprimeTitulo();
    
    // Solicita los datos de la motocicleta
    String referencia = consola.leeCadena("Introduzca la referencia de la motocicleta (no puede ser igual a la de una motocicleta ya existente)", null);
    int cilindrada = consola.leeEntero("Introduzca la cilindrada de la motocicleta, en CC (debe ser mayor o igual a cero)", OptionalInt.of(0), OptionalInt.empty());
    String tipo = consola.leeCadena("Introduzca el tipo de la motocicleta (no puede dejarse vacío o contener sólo blancos)", "[^\\s]+");
    double precio = consola.leeReal("Introduzca el precio de la motocicleta (usar . para separar parte entera y decimal. No negativo)", OptionalDouble.of(0), OptionalDouble.empty(), OptionalInt.of(2));
    String fabricante = consola.leeCadena("Introduzca el fabricante de la motocicleta (no puede dejarse vacío o contener sólo blancos)", "[^\\s]+");

    try {
      // Intenta crear la motocicleta (esto puede lanzar IllegalArgumentException si alguno de los valores no es correcto
      Motocicleta motocicleta = new Motocicleta(referencia, cilindrada, tipo, precio, fabricante);
      
      // Intenta almacenar la motocicleta
      getServicioAccesoDatos().addMotocicleta(motocicleta);
    } catch (IllegalArgumentException e) {
      // Alguno de los campos está vacío
      consola.escribeLinea("Alguno de los valores introducidos no es correcto. Creación de motocicleta abortada");
    } catch (ServicioAccesoDatosException e) {
      consola.escribeLinea("No se puede insertar la motocicleta porque ya existe otra con la misma referencia");
    }
  }

}
