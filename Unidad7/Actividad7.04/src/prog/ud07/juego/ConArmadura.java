package prog.ud07.juego;

/**
 * ConArmadura es un personaje que tiene armadura
 */
public abstract class ConArmadura extends Personaje {
  
  // Atributos
  // Tiene armadura?
  protected boolean conArmadura;

  /**
   * Constructor
   * @param nombre Nombre del personaje. No puede ser null ni ser vacío o contener sólo blancos
   * @param vidaInicial Vida inicial del personaje. No puede ser menor de 1
   * @param conArmadura true si tiene inicialmente armadura, false si no la tiene
   * @throws NullPointerException Si nombre es null
   * @throws IllegalArgumentException Si nombre está vacío o vidaInicial es menor de 1
   */
  protected ConArmadura(String nombre, int vidaInicial, boolean conArmadura) {
    super(nombre, vidaInicial);
    this.conArmadura = conArmadura;
  }

  /**
   * Recibe una armadura, si es que no la tenía ya
   */
  public void recibeArmadura() {
    // Actualiza la armadura
    conArmadura = true;
  }

  @Override
  public void recibeAtaque(int letalidad) {
    // Si tiene armadura
    if (conArmadura) {
      // La pierde
      conArmadura = false;
      // Y recibe el ataque con la mitad de la letalidad
      super.recibeAtaque(letalidad / 2);
    } else {
      // Si no tiene armadura
      // Recibe el ataque completo
      super.recibeAtaque(letalidad);
    }
  }
  
  /**
   * Determina si el personaje tiene o no armadura
   * @return true si el personaje tiene armadura. false si no
   */
  public boolean tieneArmadura() {
    return conArmadura;
  }

}
