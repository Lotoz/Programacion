package prog.ud07.juego;

/**
 * Personaje del juego.<br>
 * Todos los personajes tienen un nombre y una vida inicial
 */
public abstract class Personaje {
  
  // Atributos
  // Nombre
  protected String nombre;
  // Puntos de vida actuales
  protected int vida;
  // Vida inicial del personaje
  protected int vidaInicial;
  
  /**
   * Constructor. Crea al personaje con el nombre y vida dados
   * @param nombre Nombre del personaje. No puede ser null ni ser vacío o contener sólo blancos
   * @param vidaInicial Vida inicial del personaje. No puede ser menor de 1
   * @throws NullPointerException Si nombre es null
   * @throws IllegalArgumentException Si nombre está vacío o vidaInicial es menor de 1
   */
  protected Personaje(String nombre, int vidaInicial) {

    // Chequea los parámetros
    if (nombre == null ) {
      throw new NullPointerException("El nombre no puede ser nulo");
    }
    if (nombre.isBlank()) {
      throw new IllegalArgumentException("El nombre no puede ser vacío o contener sólo blancos");
    }
    if (vidaInicial < 1) {
      throw new IllegalArgumentException("La vida inicial debe ser mayor o igual a 1");
    }
    this.nombre = nombre;
    // Tanto la vida como la vida inicial se hacen con el valor dado
    this.vidaInicial = vidaInicial;
    this.vida = vidaInicial;
  }
  
  /**
   * Obtiene el nombre del personaje
   * @return Nombre del personaje
   */
  public String getNombre() {
    return nombre;
  }
  
  /**
   * Obtiene la vida del personaje
   * @return Vida del personaje
   */
  public int getVida() {
    return vida;
  }
  
  /**
   * Determina si el personaje está vivo o no
   * @return true si el personaje está vivo o false en caso contrario
   */
  public boolean estaVivo() {
    return vida > 0;
  }
  
  /**
   * Obtiene la letalidad con la que ataca el personaje
   * @return Letalidad con la que ataca el personaje
   */
  public int getLetalidad() {
    // Por defecto tenemos letalidad 0
    return 0;
  }
  
  /**
   * Obtiene el poder de curación del personaje
   * @return Poder de curación del personaje
   */
  public int getPoderCuracion() {
    // Por defecto tenemos poder de curación cero
    return 0;
  }

  /**
   * Recibe un ataque
   * @param letalidad Letalidad del ataque
   */
  public void recibeAtaque(int letalidad) {
    if (letalidad >= 0) {
      // Resta la letalidad de la vida
      vida -= letalidad;
      
      // Si la vida es menor que cero
      if (vida < 0) {
        // Pone la vida a cero (muerto)
        vida = 0;
      }
    } else {
      throw new IllegalArgumentException("Error. Ataque recibido con letalidad negativa");
    }
  }
  
  /**
   * Recibe una curación
   * @param poder Poder de curación
   */
  public void recibeCuracion(int poder) {
    // Si el poder es positivo
    if (poder >= 0) {
      // Si está vivo
      if (estaVivo()) {
        // Le suma el poder
        vida += poder;
        // Si hemos obtenido más vida que la inicial
        if (vida > vidaInicial) {
          // La recortamos
          vida = vidaInicial;
        }
      }
    } else {
      throw new IllegalArgumentException("Error. Curación recibida con poder negativo");
    }
  }
}
