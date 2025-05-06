package Entidades;
/**
 * Fecha de una tarea
 * Date of the task
 */
public class Fecha {

  //Atributos
  /**
   * Es un dia
   * Is a day
   */
  private Integer dia;
  /**
   * Un mes
   * A month
   */
  private Integer mes;
  /**
   * Es año 
   * Is the year
   */
  private Integer year;
  
  /**
   * Constructor de la clase
   * Constructor of the class
   */
  public Fecha(Integer dia, Integer mes, Integer year){
    
    if(validarMes() && validarYear()) {
      throw new IllegalArgumentException("Fecha no valida / Daten't ");
    }
    this.dia = dia;
    this.mes = mes;
    this.year = year;
  }
}
