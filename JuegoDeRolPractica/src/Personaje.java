/**
 * Un personaje en un videojuego, contiene lo basico de todos
 */
public abstract class Personaje {

  // Atributos
  protected int vida;
  protected String nombre;
  protected boolean estadoVivo;
  protected int vidaInicial;
  protected int letalidad;

  protected Personaje(String nombre, int vida) {
    if (verificarNombre() && verificarVida()) {
      this.nombre = nombre;
      this.vida = vida;
      estadoVivo = true;
      this.vidaInicial = vida;
      this.letalidad = 0;
    }
  }

  public int getLetalidad() {
    return letalidad;
  }

  public void setLetalidad(int letalidad) {
    this.letalidad = letalidad;
  }

  public String getNombre() {
    return nombre;
  }

  public int getVida() {
    return vida;
  }

  public boolean isEstadoVivo() {
    return estadoVivo;
  }

  public void setEstadoVivo(boolean estadoVivo) {
    this.estadoVivo = estadoVivo;
  }


  public void setVida(int vida) {
    this.vida = vida;
  }
  protected boolean verificarVida() {
    return vida > 0;
  }

  protected boolean verificarNombre() {
    return nombre.isBlank();
  }

  
  protected void estado() {
    if (!verificarVida()) {
      setEstadoVivo(false);
    }
  }
}
