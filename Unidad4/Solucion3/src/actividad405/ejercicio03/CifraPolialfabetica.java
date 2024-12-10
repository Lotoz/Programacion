package prog.unidad04.actividad405.ejercicio03;

public class CifraPolialfabetica implements Cifra {
  
  // Tenemos el alfabeto completo (en español y minúsculas). Estas son las letras
  // que se sustituyen al cifrar
  private static final String ALFABETO = "abcdefghijklmnñopqrstuvwxyz";
  
  // Clave para cifrar. Tiene que consistir en los mismos caracteres de ALFABETO pero en
  // otro orden
  private String clave;
  
  /**
   * Constructor
   * @param clave Clave de cifrado. Debe contener todas las letras minúsculas en español
   */
  public CifraPolialfabetica(String clave) {
    if (chequeaClave(clave)) {
      this.clave = clave;
    } else {
      throw new IllegalArgumentException("Clave no válida. Debe contener todas las letras del abecedario español en minúsculas, en cualquier orden");
    }
  }

  @Override
  public String cifra(String mensaje) {
    // Aqui vamos a ir almacenando el resultado
    String resultado = "";
    // Para cada carácter del mensaje a cifrar
    for (int i = 0; i < mensaje.length(); i++) {
      // Obtenemos el carácter que toca
      char actual = mensaje.charAt(i);
      int posicion;
      // Si está en el alfabeto
      if (ALFABETO.indexOf(actual) >= 0) {
        // Se obtiene la posición del carácter en el alfabeto
        posicion = ALFABETO.indexOf(actual);
        // Y se añade el carácter que ocupe la misma posición en la clave
        // Dicho en otras palabras. Se sustituye cada carácter por el que
        // ocupe en la clave la posición que ocuparía normalmente el carácter
        resultado += clave.substring(posicion, posicion + 1);
      } else {
        // El carácter no está en el alfabeto. Se copia tal cual a la salida
        resultado += actual;
      }
    }
    // Devolvemos la salida
    return resultado;
  }

  @Override
  public String descifra(String mensajeCifrado) {
    // Aqui vamos a ir almacenando el resultado
    String resultado = "";
    // Para cada carácter del mensaje cifradp
    for (int i = 0; i < mensajeCifrado.length(); i++) {
      // Obtenemos el carácter que toca
      char actual = mensajeCifrado.charAt(i);
      // Si está en el alfabeto
      if (ALFABETO.indexOf(actual) >= 0) {
        // Obtenemos la posición
        int posicion = clave.indexOf(actual);
        // Calculamos el carácter traducido
        String nuevoChar = ALFABETO.substring(posicion, posicion + 1);
        // Lo añadimos al resultado
        resultado += nuevoChar;
      } else {
        // Si el carácter no se traduce, se copia tal cual a la salida
        resultado += actual;
      }
    }
    // Se devuelve el resultado
    return resultado;
  }

  /**
   * Comprueba que la clave es correcta
   * @param clave Clave a pobar
   * @return true si la clave es correcta (tiene todas las letras del alfabeto
   * en minúsculas y una sola vez), false en caso contrario.
   */
  private boolean chequeaClave(String clave) {
    // Si la longitud no es correcta
    if (clave.length() != ALFABETO.length()) {
      // No es válida
      return false;
    } else {
      // Comprueba que están todos los caracteres
      return clave.contains("a") && clave.contains("b") && clave.contains("c")
        && clave.contains("d") && clave.contains("e") && clave.contains("f")
        && clave.contains("g") && clave.contains("h") && clave.contains("i")
        && clave.contains("j") && clave.contains("k") && clave.contains("l")
        && clave.contains("m") && clave.contains("n") && clave.contains("ñ")
        && clave.contains("o") && clave.contains("p") && clave.contains("q")
        && clave.contains("r") && clave.contains("s") && clave.contains("t")
        && clave.contains("u") && clave.contains("v") && clave.contains("w")
        && clave.contains("x") && clave.contains("y") && clave.contains("z");
    }
  }

}
