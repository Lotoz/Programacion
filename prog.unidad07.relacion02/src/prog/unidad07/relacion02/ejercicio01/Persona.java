package prog.unidad07.relacion02.ejercicio01;

public abstract class Persona {

  //Atributos 
  protected String nombre;
  protected String dni;
  protected String estadoCivil;
  
  /**
   * Crea una persona
   * @param nombre
   * @param dni
   * @param estadoCivil
   */
  public Persona(String nombre, String dni, String estadoCivil) {
    if(!validarNombre(nombre) && !validarDni(dni) && !validarEstadoCivil(estadoCivil)) {
      
    }
  }

  

  public String getNombre() {
    return nombre;
  }

  public String getDni() {
    return dni;
  }

  public String getEstadoCivil() {
    return estadoCivil;
  }
  
  //Crear un metodo validar dni
  protected void validarDni(String dni) {
    
  }

  //Crear un metodo validar nombre
  /**
   * @throws
   * @param nombre
   */
  protected void validarNombre(String nombre) {
   
  }

  //Crear un metodo validar estado civil
  protected void validarEstadoCivil(String estado) {
  
  }
}
