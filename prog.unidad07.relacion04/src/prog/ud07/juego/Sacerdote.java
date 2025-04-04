package prog.ud07.juego;

/**
 * Sacerdote
 */
public class Sacerdote extends Personaje {
  // Atributos
  // Tiene reliquia?
  protected boolean tieneReliquia;

  /**
   * Contructor
   * @param nombre Nombre del personaje. No puede ser null ni ser vacío o contener sólo blancos
   * @param vidaInicial Vida inicial del personaje. No puede ser menor de 1
   * @param tieneReliquia true si el sacerdote tiene inicialmente una reliquia. false si no
   * @throws NullPointerException Si nombre es null
   * @throws IllegalArgumentException Si nombre está vacío o vidaInicial es menor de 1
   */
  public Sacerdote(String nombre, int vidaInicial, boolean tieneReliquia) {
    super(nombre, vidaInicial);
    this.tieneReliquia = tieneReliquia;
  }

  @Override
  public int getPoderCuracion() {
    // Si tiene reliquia cura con el mismo poder que la vida. Si no la tiene por la mitad
    return tieneReliquia ? vida : (vida / 2);
  }

  @Override
  public void recibeAtaque(int letalidad) {
    // Si tiene la reliquia
    if (tieneReliquia) {
      // La pierde pero no pierde vida
      tieneReliquia = false;
    } else {
      // Si no la tiene tenemos el comportamiento por defecto
      super.recibeAtaque(letalidad);
    }
  }

  @Override
  public void recibeCuracion(int poder) {
    // Si tiene reliquia recibe un 50% más de curacion
    if (tieneReliquia) {
      super.recibeCuracion(poder + (poder / 2));
    } else {
      // Recibe la curación normal
      super.recibeCuracion(poder);
    }
  }

  /**
   * Proporciona una reliquia al sacerdote, si no la tenía ya. Si la tenía sigue teniendo sólo una
   */
  public void recibeReliquia() {
    tieneReliquia = true;
  }
  /**
   * Determina si el sacerdote tiene o no reliquia
   * @return true si el sacerdote tiene reliquia. false si no la tiene
   */
  public boolean tieneReliquia() {
    return tieneReliquia;
  }
}
