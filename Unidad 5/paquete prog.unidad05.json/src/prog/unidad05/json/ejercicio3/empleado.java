package prog.unidad05.json.ejercicio3;

public class empleado {

  /**
   * Atributos
   */
  private String nombre;
  private String apellido;
  private String dni;
  
  public empleado(String nombre, String apellido, String dni){
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
  }
  
  
  //Ver si estos metodos son necesarios.
  /**
   * Verificar si el dni es valido
   * @param dni
   * @return
   */
  private String verificaDni(String dni) {
    return dni;
  }
  /**
   * Verifica si una cadena es valida y si no es null
   * @param cadena
   * @return
   */
  private String cadenaValida(String cadena) {
    return cadena;
  }
}
