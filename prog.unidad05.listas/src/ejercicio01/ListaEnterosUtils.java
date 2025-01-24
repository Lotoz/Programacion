package ejercicio01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ListaEnterosUtils {

  /**
   * Genera una lista de longitud aleatoria de números enteros también aleatorios.
   * 
   * @param longitudMin - Longitud mínima de la lista. Debe ser mayor o igual a
   *                    cero
   * @param longitudMax - Longitud máxima de la lista. Debe ser igual o mayor a la
   *                    longitud mínima
   * @param valorMin    - Valor mínimo del rango desde el que se elegirán los
   *                    números aleatorio que formarán la lista
   * @param valorMax    - Valor máximo del rango. Debe ser igual o mayor que el
   *                    mínimo
   * @return Lista con los enteros aleatorios. La longitud de la lista estará en el rango especificado
   * @throws IllegalArgumentException - Si longitudMin es mayor que longitudMax o valorMin es mayor que valorMax
   */
  public static List<Integer> generaListaEnterosAleatorios(int longitudMin, int longitudMax, int valorMin,
      int valorMax) throws Exception {
    List<Integer> lista = new ArrayList<>();
    Random elAzar = new Random();
    if (longitudMin > 0 && longitudMax >= longitudMin) {
    int longitud = elAzar.nextInt(longitudMin, longitudMax);
    if (valorMin < valorMax) {
    for (int i = 0 ; i <= longitud ; i++) {
      int valor = elAzar.nextInt(valorMin, valorMax);
      lista.add(valor);
      i++;
    }
    return lista;  
    }
    } else { 
      throw new IllegalArgumentException("Es incorrecto.");
    }
    return "";
  }

  /**
   * Obtiene una representación textual de una lista de enteros
   * Si la lista es null, devuelve una cadena vacía
   * Si la lista está vacía devuelve ()
   * Si la lista no está vacía devuelve (valor1, valor2, ...., valorn)
   * @param lista - Lista a convertir a texto
   * @return Cadena con la representacion de la lista
   */
  public static String generaCadena(List<Integer> lista) {
    int[] array = new int[lista.size()];
    for(int i = 0; i < lista.size(); i++) {
      array[i] = lista.get(i);
    }
    String cadena = null;
    for (int i = 0; i < array.length; i++) {
      cadena =""+ array[i];
    }
    return"("+ cadena + ")";
    }
  }
  

