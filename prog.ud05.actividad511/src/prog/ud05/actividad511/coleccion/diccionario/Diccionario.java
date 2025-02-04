package prog.ud05.actividad511.coleccion.diccionario;

public class Diccionario <V> {

  /**
   * Constructor. Crea un diccionario vacío
   */
  public Diccionario() {
    
  }

  /**
   * Comprueba si existe una entrada en el diccionario con el nombre dado
   * @param nombre - Nombre de la entrada a comprobar
   * @return
   */
  public boolean contieneNombre(String nombre) {
    return false;
    
  }
  /**
   * Añade una nueva entrada al diccionario
   * @param nombre - Nombre de la entrada a añadir. No puede ser null ni coincidir con el nombre de una entrada ya existente en el diccionario
   * @param valor - Valor a almacenar en la entrada. No puede ser null
   * @throws DiccionarioException - Si ya existe previamente una entrada con el nombre proporcionado en el diccionario
   * @throws NullPointerException - Si el nombre o valor son null
   */
  public void add(String nombre, V valor) {
    
  }
  /**
   * Obtiene el valor almacenado en una entrada del diccionario a partir de su nombre
   * @param nombre - Nombre de la entrada a recuperar.
   * @return Valor almacenado en la entrada con el nombre proporcionado. Si no existe una entrada con dicho nombre devuelve null
   */
  public V getEntrada(String nombre) {
    return null;
  }
}
