package prog.unidad05.json.ejercicio03;

import java.util.HashMap;
import java.util.Map;

/**
 * Nomina de la empresa. Contiene los empleados de la empresa
 */
public class Nomina {

  // Atributos
  // Mapa de empleados. Se usa mapa para localizarlos rápido por DNI
  private Map<String, Empleado> empleados;
  
  /**
   * Crea una nueva nomina vacía
   */
  public Nomina() {
    empleados = new HashMap<>();
  }
  
  /**
   * Añade un nuevo empleado a la nomina. Si ya existe un empleado con el
   * mismo DNI sustituye al anterior.
   * @param empleado Empleado a añadir. No puede ser nulo
   * @throws NullPointerException Si empleado es null
   */
  public void addEmpleado(Empleado empleado) {
    empleados.put(empleado.getDni(), empleado);
  }
  
  /**
   * Obtiene un empleado por DNI
   * @param dni DNI del empleado a localizar
   * @return Empleado con el DNI dado o null si no se encuentra el empleado
   * @throws NullPointerException Si dni es null
   */
  public Empleado getEmpleadoPorDni(String dni) {
    return empleados.get(dni);
  }
  
  /**
   * Obtiene todos los empleados de la nomina
   * @return Empleados de la nomina. El array puede estar vacío
   */
  public Empleado[] getAll() {
    return empleados.values().toArray(new Empleado[0]);
  }
}
