package prog.unidad04.practica406.libreria;

/**
 * Clase que representa un automovil. Es un vehiculo de cuatro ruedas con un color y un número de plazas.
 */
public class Automovil extends Vehiculo implements MaquinaConDistintivoAmbiental{

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
  // Constantes privadas.
  private String matricula;
  private int plazas;
  private String color;
  private Fecha fechaMatriculacion;

  
  /**
   * Constructor
   * 
   * @param matricula Matrícula del vehiculo. Debe tener un formato válido NNNN AAA donde NNNN son 4 dígitos y AAA son tres letras MAYÚSCULAS. Entre ellas puede haber cuantos espacios se quiera (incluido ninguno).
   * @param fechaMatriculacion Fecha de matriculación del vehiculo. No puede ser null.
   * @param color Color del vehículo. Sólo se permite uno de COLOR_BLANCO, COLOR_NEGRO, COLOR_AZUL.
   * @param plazas Número de plazas del vehiculo. Debe ser mayor que 0 (por lo menos tiene que tener una para el conductor.
   * @throws NullPointerException Si fechaMatriculacion o color son null.
   * @throws IllegalArgumentException Si la matricula, el color o el número de plazas no son válidos.
   */
  private Automovil(String matricula, Fecha fechaMatriculacion)  {
    super(matricula, fechaMatriculacion);
  }

  /**
   * Constructor
   * 
   * @param matricula Matrícula del vehiculo. Debe tener un formato válido NNNN AAA donde NNNN son 4 dígitos y AAA son tres letras MAYÚSCULAS. Entre ellas puede haber cuantos espacios se quiera (incluido ninguno).
   * @param fechaMatriculacion Fecha de matriculación del vehiculo. No puede ser null.
   * @param color Color del vehículo. Sólo se permite uno de COLOR_BLANCO, COLOR_NEGRO, COLOR_AZUL.
   * @param plazas Número de plazas del vehiculo. Debe ser mayor que 0 (por lo menos tiene que tener una para el conductor.
   * @throws NullPointerException Si fechaMatriculacion o color son null.
   * @throws IllegalArgumentException Si la matricula, el color o el número de plazas no son válidos.
   */
  public Automovil(String matricula, Fecha fechaMatriculacion, String color, int plazas) {
    super(matricula, fechaMatriculacion);
    if (color == null) {
      throw new NullPointerException("El color introducido es incorrecto. Revise los valores e intentelo de nuevo.") ;
    } else if ( plazas == 0){
      throw new IllegalArgumentException("La plaza introducida es incorrecta. Revise los valores e intentelo de nuevo.");
    } else if (!validarColor(false)) {
      throw new IllegalArgumentException ("El color introducido es incorrecto. Revise los valores e intentelo de nuevo.");
    } else {
      this.color = color;
      this.plazas = plazas;
    }
  }

  /**
   * Obtiene el color del automovil.
   * 
   * @return Color del automovil.
   */
  public String getColor() {
    String color = this.color;
    switch (color) {
    case COLOR_BLANCO ->{
      this.color = "blanco";
      return color;
    }
    case COLOR_AZUL -> {
      this.color = "azul";
      return color;
      }
    case COLOR_NEGRO -> {
      this.color = "negro";
      return color;
    }
    }
    return null;
  }
  /**
   * Ve si color es valido
   * 
   * @return Validacion del color del automovil.
   */
private boolean validarColor(boolean b) {
  if (color == null || color == "") {
    return true;
  } else {
    return false;
  }
}
  /**
   * Obtiene el número de plazas del automóvil
   * @return numero de plazas.
   */
  public int getPlazas() {
    return plazas;
  }

  /**
   * Obtiene el distintivo ambiental del automovil. Si tiene 1 plaza es 0, si
   * tiene de 2 a 3, ECO, si tienen de 4 a 5 son A y si tienen más de 5, B
   * @return Distintivo ambiental de la máquina (0, ECO, A, B).
   */
  public String getDistintivo() {
    int plazas = this.plazas;
    if (plazas == 1) {
      return "0";
    } else if (plazas == 2 || plazas == 3) {
      return "ECO";
    } else if (plazas == 4 || plazas == 5) {
      return "A";
    } else if (plazas > 5) {
      return "B";
    } else {
      return "Plazas incorrectas";
    }
  }

  /**
   * Obtiene la representación en texto del automóvil en el formato: Matricula:
   * matricula, Fecha Matriculación: dd de mmmmm de aaaa, Color: color, Num.
   */
  public String toString() {
    return "Matricula: " + getMatricula() + " Fecha de matriculacion: " + getFechaMatriculacion().toString() + " Color: " + getColor() + " Plazas: " + getPlazas();
  }

}
