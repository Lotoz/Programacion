package TaskManagerGeneraTask;

public class Task {
  /**
   * Atributos
   */
  private String titulo;
  private String descripcion;
  private Fecha fecha;
  private boolean estado = false;
  
  /**
   * 
   * @param titulo
   * @param descripcion
   * @param fecha
   * @param estado
   */
  public Task(String titulo, String descripcion, Fecha fecha, boolean estado) {
    if (verificaString(titulo) && verificaString(descripcion) && verificaFecha(fecha) && verificaBoolean(estado)) {
      
    }else {
      throw new TaskException("Error al crear el objeto Task, algun parametro es invalido.");
    }
  }
  private boolean verificaString(String cadena) {
    //Debe verificar si es valido.
    boolean salida = false;
    
    return salida;
  }
  private boolean verificaFecha(Fecha fecha) {
    boolean salida = false;
    return salida;
  }
  private boolean verificaBoolean(Boolean estado) {
    
    return estado;
  }
}
