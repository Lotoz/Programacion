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
  protected Persona(String nombre, String dni, String estadoCivil) {
    //Hacer validadores validos luego
    if(nombre != null && dni != null && estadoCivil != null) {
      this.nombre = nombre;
      this.dni = dni;
      this.estadoCivil = estadoCivil;
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
  

}
