package prog.unidad04.practica406.libreria;

public class Automovil {
  
  /**
   * Esto es la constante de color azul.
   */
  public static final String COLOR_AZUL = "azul";
  /**
   * Esto es la constante de color blanco.
   */
  public static final String COLOR_BLANCO = "blanco";
  /**
   * Esto es la constante de color negro.
   */
  public static final String COLOR_NEGRO = "negro";
  //Constantes privadas.
  private String matricula;
  private int plazas;
  private String color;
  private String fechaMatriculacion;
  
  
  //RETOCAR CUANDO SE FINALICE CLASE FECHA.
  // Las pruebas de validacion privadas
  //Analizar si falta mas y empezar a agregar comentarios
  //Agregar interfaz.
  //Puede ser hija de vehiculo
  
  /**Constructor.*/
  public Automovil (String matricula, Fecha fechaMatriculacion, String color, int plazas) {
   this.matricula = matricula;
   //FECHA
   this.color = color;
   this.plazas = plazas;
  }
  
  /**
   * Obtiene el color del automovil.
   */
  public String getColor() {
    String color = "";
    if ( color.equals("blanco")) {
      this.color = COLOR_BLANCO;
      return color;
    }else if ( color.equals("azul")) {
      this.color = COLOR_AZUL;
      return color;
    } else if ( color.equals("negro")) {
      this.color = COLOR_NEGRO;
      return color;
    }else {
       return "El color introducido no es valido.";
    }
  }
  
  /**
   * Obtiene el número de plazas del automóvil
   */
  public int getPlazas() {
    return plazas;
  }
  
  /**
   * Obtiene el distintivo ambiental del automovil.
    Si tiene 1 plaza es 0, si tiene de 2 a 3, ECO, si tienen de 
    4 a 5 son A y si tienen más de 5, B
   */
  public String getDistintivo(){
    int plazas = this.plazas;
    if (plazas == 1) {
      return "0";
    } else if  ( plazas == 2 || plazas == 3) {
      return "ECO";
    } else if ( plazas == 4 || plazas == 5) {
       return "A";
    } else if ( plazas > 5) {
      return "B";
    } else {
      return "Plazas incorrectas";
    }
  }
  
  /**
   * Obtiene la representación en texto del automóvil en el formato:
      Matricula: matricula, Fecha Matriculación: dd de mmmmm de aaaa,
       Color: color, Num.
   */
  public String toString() {
    return getMatricula() + getFechaMatriculacion() + getColor() + getPlazas();
  }
  
  //Metodos privados.
  
  //Sirve para obtener la cadena matricula.
  private static String getMatricula() {
    return null;
  }
  //Seguro ha de ser un metodo heredado de la clase fecha.
  private static String getFechaMatriculacion() {
    return null;
  }
}
