package prog.ud07.juego;

/**
 * Guerrero. Lleva armadura y usa una de dos armas
 */
public class Guerrero extends ConArmadura {
  
  // Constantes
  // Armas
  public static final int ARMA_ESPADA = 0;
  public static final int ARMA_MAZA = 1;
  
  // Atributos
  private int arma;

  /**
   * Constructor
   * @param nombre Nombre del personaje. No puede ser null ni ser vacío o contener sólo blancos
   * @param vidaInicial Vida inicial del personaje. No puede ser menor de 1
   * @param conArmadura true si tiene inicialmente armadura, false si no la tiene
   * @param armaInicial Arma inicial del guerrero. Debe ser una de ARMA_ESPADA o ARMA_MAZA
   * @throws NullPointerException Si nombre es null
   * @throws IllegalArgumentException Si nombre está vacío, vidaInicial es menor de 1 o arma no es
   *   ni ARMA_ESPADA o ARMA_MAZA
   */
  public Guerrero(String nombre, int vidaInicial, boolean conArmadura, int armaInicial) {
    super(nombre, vidaInicial, conArmadura);
    if (armaInicial != ARMA_ESPADA && armaInicial != ARMA_MAZA) {
      throw new IllegalArgumentException("El arma que se ha proporcionado es ilegal. Debe ser uno de ARMA_ESPADA o ARMA_MAZA");
    }
    // Almacena el arma
    arma = armaInicial;
  }

  @Override
  public int getLetalidad() {
    // Si el arma es una espada
    if (arma == ARMA_ESPADA) {
      // El ataque tiene la mitad de la vida
      return vida / 2;
    } else {
      // Si es maza es tan fuerte como la vida
      return vida;
    }
  }

  @Override
  public void recibeCuracion(int poder) {
    // Duplica el poder 
    super.recibeCuracion(poder * 2);
  }
  
}
