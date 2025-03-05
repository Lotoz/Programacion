package Main;

import CLIUtilidades.ImprimirCLI;
import ConsolaUtilidades.ConsolaException;
import ConsolaUtilidades.ConsolaScan;

/**
 * Primer main de asclepiasApp, por ahora se plantea su funcion en CLI
 */
public class AsclepiasApp {

  private static final int OPCION_SALIR = 0;

  private static final int OPCION_HISTORIAL = 1;

  private static final int OPCION_BUSCAR_PERIODOS = 2;

  private static final int OPCION_CALCULAR_PROXIMO = 3;

  private static ImprimirCLI impresor = ImprimirCLI.getInstance();
  private static ConsolaScan consola = ConsolaScan.getInstance();

  public AsclepiasApp() {
  }

  public static void main(String[] args) {

    // Obtenemos los usuarios
    try {
      // Creamos el objeto de la clase
      // A futuro debera tener algun contenedor funcional
      AsclepiasApp app = new AsclepiasApp();
      app.run();
    } catch (Exception e) {
      ConsolaException.mostrarError(e);
    }
  }

  private void run() {
    // interfaz cli por medio de switch
    int opcionElegida = OPCION_SALIR;
    do {
      // Muestra el menú y obtiene una elección
      opcionElegida = mostrarMenu();
      // Según la opción elegida
      switch (opcionElegida) {
      case OPCION_HISTORIAL -> periodosGuardados();
      case OPCION_BUSCAR_PERIODOS -> buscarPeriodos();
      case OPCION_CALCULAR_PROXIMO -> calcularProximo();
      case OPCION_SALIR -> {
      }
      default -> // No Deberia llegar aqui
        System.out.println("Error. Opción incorrecta.");
      }
    } while (opcionElegida != OPCION_SALIR);
  }

  private int mostrarMenu() {
   impresor.imprimirUpper("ASCLEPIAS V1.");
   impresor.imprimir("Elige una opcion.");
   impresor.imprimir("1.Periodos guardados.");
   impresor.imprimir("2.Buscar Periodos");
   impresor.imprimir("3.Calcular Proximo Periodo.");
   int opcion = consola.leerInt();
   return opcion;
   
  }

  private Object periodosGuardados() {
    // TODO Auto-generated method stub
    return null;
  }

  private Object buscarPeriodos() {
    // TODO Auto-generated method stub
    return null;
  }

  private Object calcularProximo() {
    // TODO Auto-generated method stub
    return null;
  }

}
