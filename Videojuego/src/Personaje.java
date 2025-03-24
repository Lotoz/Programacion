/**
 * Un personaje en un videojuego, contiene lo basico de todos
 */
public abstract class Personaje {

  //Atributos
  protected int vida;
  protected String nombre;
  
  
  protected Personaje(String nombre, int vida) {
    this.nombre = nombre;
    this.vida = vida;
  }

  public String getNombre() {
    return nombre;
  }

  public int getVida() {
    return vida;
  }

  public void esValidaLetalidad(int letalidad) {
    if(letalidad < 0) {
      throw new IllegalArgumentException("Letalidad invalida.");
    }
  }
  
  public void aplicaLetalidad(Personaje personaje, int letalidad) {
    int vida = personaje.getVida();
    esValidaLetalidad(letalidad);
    int painAplicado = vida - letalidad;
  }

}
