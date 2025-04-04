package prog.ud07.juego;

/**
 * Arquero
 */
public class Arquero extends ConArmadura {
  
  // Constantes
  // Niveles de maestria
  public static final int NIVEL_NOVATO = 0;
  public static final int NIVEL_MEDIO = 1;
  public static final int NIVEL_EXPERTO = 2;
  // Factor de reducción de la letalidad según la maestria (NOVATO, MEDIO, EXPERTO)
  private static final int[] FACTOR_NIVEL = {5, 3, 2};
  
  // Atributos
  // Nivel de maestria
  protected int nivelMaestria;

  /**
   * Constructor
   * @param nombre Nombre del personaje. No puede ser null ni ser vacío o contener sólo blancos
   * @param vidaInicial Vida inicial del personaje. No puede ser menor de 1
   * @param conArmadura true si tiene inicialmente armadura, false si no la tiene
   * @param nivelMaestria Nivel de maestria del personaje. Debe ser uno de NIVEL_NOVATO,
   *   NIVEL_MEDIO, NIVEL_EXPERTO
   * @throws NullPointerException Si nombre es null
   * @throws IllegalArgumentException Si nombre está vacío o vidaInicial es menor de 1 o nivel no
   *   es uno de NIVEL_NOVATO, NIVEL_MEDIO, NIVEL_EXPERTO
   */
  public Arquero(String nombre, int vidaInicial, boolean conArmadura, int nivelMaestria) {
    super(nombre, vidaInicial, conArmadura);
    // Si el nivel de maestria no es válido
    if (nivelMaestria != NIVEL_NOVATO && nivelMaestria != NIVEL_MEDIO && nivelMaestria != NIVEL_EXPERTO) {
      throw new IllegalArgumentException("El nivel de maestría es incorrecto. Debe ser uno de NIVEL_NOVATO, NIVEL_MEDIO o NIVEL_EXPERTO");
    }
    // Almacena el nivel de maestría
    this.nivelMaestria = nivelMaestria;
  }

  @Override
  public int getLetalidad() {

    // Devolvemos la letalidad
    return vida / FACTOR_NIVEL[nivelMaestria];
  }

  /**
   * Sube el nivel del arcquero. Si tenia nivel novato pasa a medio y si tenia medio pasa a experto
   */
  public void subirNivel() {
    // Si es novato
    if (nivelMaestria == NIVEL_NOVATO) {
      // Se sube a medio
      nivelMaestria = NIVEL_MEDIO;
    } else if (nivelMaestria == NIVEL_MEDIO) {
      // Si es medio se sube a experto
      nivelMaestria = NIVEL_EXPERTO;
    }
    // En cualquier otro caso se mantiene
  }
  
}
