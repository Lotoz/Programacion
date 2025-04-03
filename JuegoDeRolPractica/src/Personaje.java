/**
 * Un personaje en un videojuego, contiene lo basico de todos
 */
public abstract class Personaje {

  // Atributos
  protected int vida;
  protected String nombre;
  protected int poder;
  protected boolean estadoVivo;
  protected int vidaInicial;

  protected Personaje(String nombre, int vida, int poder) {
    if (verificarNombre() && verificarVida() && verificarPoder()) {
      this.nombre = nombre;
      this.vida = vida;
      this.poder = poder;
      estadoVivo = true;
      this.vidaInicial = vida;
    }
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

  public int getPoder() {
    return poder;
  }

  public void setPoder(int poder) {
    this.poder = poder;
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

  protected boolean verificarPoder() {
    return poder > 0;
  }

  protected void estado() {
    if (!verificarVida()) {
      setEstadoVivo(false);
    }
  }
}
