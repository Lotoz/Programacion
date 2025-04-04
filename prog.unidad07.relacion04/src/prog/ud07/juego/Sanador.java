package prog.ud07.juego;

/**
 * Sanador
 */
public class Sanador extends Personaje {

  /**
   * Constructor. Crea al personaje con el nombre y vida dados
   * @param nombre Nombre del personaje. No puede ser null ni ser vacío o contener sólo blancos
   * @param vidaInicial Vida inicial del personaje. No puede ser menor de 1
   * @throws NullPointerException Si nombre es null
   * @throws IllegalArgumentException Si nombre está vacío o vidaInicial es menor de 1
   */
  public Sanador(String nombre, int vidaInicial) {
    super(nombre, vidaInicial);
  }

  @Override
  public int getPoderCuracion() {
    // Tiene tanto poder de curación como la mitad de la vida
    return vida / 2;
  }

  @Override
  public void recibeCuracion(int poder) {
    // Aumenta el poder de curación en un tercio
    super.recibeCuracion(poder + (poder / 3));
  }

  
}
