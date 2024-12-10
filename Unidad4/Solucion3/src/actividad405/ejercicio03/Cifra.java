package prog.unidad04.actividad405.ejercicio03;

/**
 * Interfaz que implementan los algoritmos de cifrado
 */
public interface Cifra {

  /**
   * Cifra el mensaje. Sólo se cifrarán las letras minúsculas
   * @param mensaje Mensaje a cifrar
   * @return Mensaje cifrado
   */
  String cifra(String mensaje);
  
  /**
   * Descifra el mensaje. Sólo se descrifrarán las letras minúsculas
   * @param mensajeCifrado Mensaje cifrado a descifrar
   * @return Mensaje descifrado
   */
  String descifra(String mensajeCifrado);
    
}
