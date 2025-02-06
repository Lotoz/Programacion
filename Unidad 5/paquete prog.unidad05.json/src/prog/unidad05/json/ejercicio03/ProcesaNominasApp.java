package prog.unidad05.json.ejercicio03;

/**
 * Aplicacion que procesa nominas de la empresa
 */
public class ProcesaNominasApp {

  // Constantes
  // Fichero con la nomina
  private static final String FICHERO_NOMINA = "nomina.json";
  // Fichero con las subidas
  private static final String FICHERO_SUBIDAS = "subidas.json";
  // Fichero de salida
  private static final String FICHERO_SALIDA = "salida.json";
  
  public static void main(String[] args) {
    ProcesaNominasApp app = new ProcesaNominasApp();
    app.run();
  }
  
  private void run() {
    // Se procesa el fichero de nomina y se extraen los empleados
    Nomina nomina = ProcesadorJson.procesaNomina(FICHERO_NOMINA);
    
    // Se procesa el fichero de subidas
    Subida[] subidas = ProcesadorJson.procesaSubidas(FICHERO_SUBIDAS);
    
    // Para cada subida
    for (Subida subida: subidas) {
      // Se localiza el empleado
      Empleado empleado = nomina.getEmpleadoPorDni(subida.getDni());
      // Si se obtuvo
      if (empleado != null) {
        // Se actualiza la nomina
        empleado.aumentaSalario(subida.getImporte());
      }
    }
    
    // Almacena el fichero
    ProcesadorJson.generaSalida(nomina, FICHERO_SALIDA);
  }

}
