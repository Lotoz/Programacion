package prog.unidad04.actividad405.ejercicio03;

/**
 * Implementa el algoritmo Cesar de cifrado
 */
public class CifraCesar implements Cifra {

  // Cadena con los carácteres en español para las sustituciones
  private static final String ABECEDARIO = "abcdefghijklmnñopqrstuvwxyz";

  // Clave del algoritmo (Número de posiciones que se mueve el caracter)
  private int clave;

  /**
   * Constructor
   * @param clave Clave de la cifra. Debe ser entre -27 y 27 (ambos incluidos)
   * @throws IllegalArgumentException Si la clave no tiene un valor válido
   */
  public CifraCesar(int clave) {
    if ((clave >= -ABECEDARIO.length()) && (clave <= ABECEDARIO.length())) {
      this.clave = clave;
    } else {
      throw new IllegalArgumentException("Valor de clave no válido");
    }
  }
  
  @Override
  public String cifra(String mensaje) {
    // Llama a sustituye sumando
    return sustituye(mensaje, +1);
  }

  @Override
  public String descifra(String mensajeCifrado) {
    // Llama a sustituye restando
    return sustituye(mensajeCifrado, -1);
  }

  /**
   * Obtiene un mensaje sustituyendo cada letra por la situada en la posicion
   * clave * signo
   * @param mensaje Mensaje de entrada
   * @param signo Signo por el que se multiplicará la clave
   * @return Mensaje con las letras sustituidas
   */
  private String sustituye(String mensaje, int signo) {
    // Iniciamos la salida a la cadena vacía
    String salida = "";
    // Para cada carácte del mensaje
    for (int i = 0; i < mensaje.length(); i++) {
      // Obtenemos el carácter
      String caracter = mensaje.substring(i, i + 1);
      // Iniciamos cambiarPor al mismo caracter (por ahora)
      String cambiarPor = caracter;
      // Obtenemos la posición del carácter en el abecedario
      int newPos = ABECEDARIO.indexOf(caracter);
      // Si el carácter está en el abecedario (es una letra)
      if (newPos >= 0) {
        // Intentamos obtener la posición del carácter por el que lo vamos a cambiar
        newPos += clave * signo;
        // Si es negatica
        if (newPos < 0) {
          // Le sumamos la longitud para que vuelva a estar en el rango correcto (da la vuelta)
          newPos += ABECEDARIO.length();
        } else if (newPos >= ABECEDARIO.length()) {
          // Si está más allá del final damos la vuelta pero hacia abajo
          newPos = newPos % ABECEDARIO.length();
        }
        // Obtenemos el carácter por el que vamos a sustituir
        // Si es que se sustituye
        cambiarPor = ABECEDARIO.substring(newPos, newPos + 1);
      }
      // Cambiamos el carácter por el sustituto o lo dejamos tal y como está
      // Dependiendo de si era una letra minúscula o no
      salida += cambiarPor;
    }
    // Devuelve el mensaje con las letras sustituidas
    return salida;
  }
}
