package prog.ud05.actividad511.coleccion.diccionario;

import java.util.HashMap;
import java.util.Map;

import prog.ud05.actividad511.coleccion.TarjetaClaves;
import prog.ud05.actividad511.coleccion.Usuario;

public class Diccionario<V> {
  // Revisar clase

  /**
   * Atributos
   */
  private Map<String, V> diccionario;

  /**
   * Constructor. Crea un diccionario vacío
   */
  public Diccionario() {
    diccionario = new HashMap<>();
  }

  /**
   * Comprueba si existe una entrada en el diccionario con el nombre dado
   * 
   * @param nombre - Nombre de la entrada a comprobar
   * @return true si existe en el diccionario una entrada con el nombre
   *         proporcionado. false si no existe
   */
  public boolean contieneNombre(String nombre) {
    if (nombre != null) {
      return diccionario.containsKey(nombre);
    } else {
      return false;
    }
  }

  /**
   * Añade una nueva entrada al diccionario
   * 
   * @param nombre - Nombre de la entrada a añadir. No puede ser null ni coincidir
   *               con el nombre de una entrada ya existente en el diccionario
   * @param valor  - Valor a almacenar en la entrada. No puede ser null
   * @throws DiccionarioException - Si ya existe previamente una entrada con el
   *                              nombre proporcionado en el diccionario
   * @throws NullPointerException - Si el nombre o valor son null
   */
  public void add(String nombre, V valor) {
    if (validarNombre(nombre)) {
      if(valor == null) {
        throw new NullPointerException("El nombre es null");
      } else {
        diccionario.put(nombre, valor);
      }
    } 
  }

  /**
   * Obtiene el valor almacenado en una entrada del diccionario a partir de su
   * nombre
   * 
   * @param nombre - Nombre de la entrada a recuperar.
   * @return Valor almacenado en la entrada con el nombre proporcionado. Si no
   *         existe una entrada con dicho nombre devuelve null
   */
  public V getEntrada(String nombre) {
    return diccionario.get(nombre);
  }

  /**
   * Metodos privados
   */
  private boolean validarNombre(String nombre) {
    //valida nombre
    if (nombre != null) {
      if (contieneNombre(nombre)) {
        throw new DiccionarioException(
            "Ya existe previamente una entrada con el nombre proporcionado en el diccionario");
      } else {
        return true;
      }
    } else {
      throw new NullPointerException("El nombre es null");
    }
  }
}
