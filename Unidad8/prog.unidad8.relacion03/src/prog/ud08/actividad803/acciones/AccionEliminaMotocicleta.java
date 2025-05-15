package prog.ud08.actividad803.acciones;

import java.io.PrintStream;
import prog.common.app.consola.Consola;
import prog.ud08.actividad803.data.ServicioAccesoDatos;
import prog.ud08.actividad803.data.ServicioAccesoDatosException;
import prog.ud08.actividad803.modelo.Cliente;

/**
 * Accion eliminar motocicleta
 */
public class AccionEliminaMotocicleta extends AccionBase {

  /**
   * Constructor con titulo
   * @param titulo Titulo de la acción
   */
  public AccionEliminaMotocicleta(String titulo) {
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
    
    // Solicita la referencia de la motocicleta a eliminar
    String referencia = consola.leeCadena("Introduzca la referencia de la motocicleta a eliminar", null);

    try {
      // Intenta eliminar la motocicleta usando el servicio de acceso a datos
      getServicioAccesoDatos().deleteMotocicleta(referencia);
    } catch (ServicioAccesoDatosException e) {
      consola.escribeLinea("No se puede actualizar la motocicleta porque no existe en la base de datos");
    }
  }

}
