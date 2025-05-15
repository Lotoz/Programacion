package prog.common.consola;

import java.util.Locale;
import java.util.Scanner;

/**
 * Clase que representa la consola de texto.<br>
 * Ofrece métodos avanzados para hacer interfaz de usuario de consola
 */
public class Consola {

  // Atributos estáticos
  // La única instancia de la clase
  private static Consola instancia = null;
  
  // Atributos
  // Scanner para leer desde teclado
  Scanner sc;
  
  /**
   * Constructor privado para impedir que se haga new sobre la clase
   */
  private Consola() {
    // Iniciamos el Scanner
    sc = new Scanner(System.in);
  }

  /**
   * Obtenemos una instancia de la clase
   * @return Instancia de la clase
   */
  public static Consola getInstancia() {
    // Si no se ha iniciado la instancia (es la primera llamada)
    if (instancia == null) {
      // La inicia
      instancia = new Consola();
    }
    // Devolvemos la instancia (nueva o ya creada anteriormente)
    return instancia;
  }

  /**
   * Imprime una línea de texto, terminada en \n
   * @param linea Texto a imprimir en la línea
   */
  public void imprimeLinea(String linea) {
    // Imprime el texto
    imprime(linea);
    // Y un salto de línea
    System.out.println();
  }
  
  /**
   * Imprime texto por la consola
   * @param texto Texto a imprimir
   */
  public void imprime(String texto) {
    System.out.print(texto);
  }

  /**
   * Imprime un título por consola.<br>
   * Un título consta de: una línea en blanco, el texto proporcionado, en mayúsculas y una línea
   * de guiones de igual longitud que el título
   * @param titulo Titulo a imprimir
   */
  public void imprimeTitulo(String titulo) {
    // Imprime la línea en blanco
    System.out.println();
    // El título
    imprimeLinea(titulo);
    // Y la línea de guiones
    imprimeLinea("-".repeat(titulo.length()));
  }

  /**
   * Solicita un número entero dentro de un rango determinado
   * @param prompt Prompt a mostrar al usuario para solicitar el valor
   * @param minimo Valor mínimo del rango, incluido
   * @param maximo Valor maximo del rango, incluido
   * @return Valor introducido por el usuario, estando garantizado que es un número y está en el
   * rango
   */
  public int solicitaEntero(String prompt, Integer minimo, Integer maximo) {
    // Hasta que se lea un número que cumpla los requisitos
    for (;;) {
      // Capturamos excepción por si se introduce algo que no sea un entero
      try {
        // Mostramos el prompt
        imprime(prompt);
        // Solicita el número
        int numero = Integer.parseInt(sc.nextLine());
        // Si hay mínimo y el número es mayor
        if (minimo == null || numero >= minimo) {
          // Si hay máximo y el número es menor
          if (maximo == null || numero <= maximo) {
            // El número está en rango
            return numero;
          } else {
            // El número es superior al máximo
            imprimeLinea(String.format("Error. El número introducido (%d) es superior al valor máximo permitido (%d)", numero, maximo));
          }
        } else {
          // El número es inferior al mínimo
          imprimeLinea(String.format("Error. El número introducido (%d) es inferior al valor mínimo permitido (%d)", numero, minimo));
        }
      } catch (NumberFormatException e) {
        // Lo introcido por el usuario no es un número
        imprimeLinea("Error. Debe introducir un número entero");
      }
    }
  }

  /**
   * Solicita un texto al usuario
   * @param prompt Prompt a mostrar para solicitar el texto
   * @param longMinima Longitud mínima de la cadena. null para ninguna longitud mínima
   * @param longMaxima Longitud máxima de la cadena. null para ninguna longitud máxima
   * @param regex Expresión regular a aplicar para validar el texto. null para ninguna
   * @param mensajeError Mensaje de error a mostrar si lo introducido no cumple los filtros
   * @return Cadena introducida ya validada
   */
  public String solicitaTexto(String prompt, Integer longMinima, Integer longMaxima, String regex,
      String mensajeError) {
    // Ciclo infinito. Se sale devolviendo el valor
    for (;;) {
      // Se solicita la cadena
      imprime(prompt);
      String cadena = sc.nextLine().trim();
      // Si no hay longitud minima o la hay y la cumple
      if (longMinima == null || cadena.length() >= longMinima) {
        // Si no hay longitud máxima o la hay y la cumple
        if (longMaxima == null || cadena.length() <= longMaxima) {
          // Por último, si no hay expresión regular o la hay y la cumple
          if (regex == null || cadena.matches(regex)) {
            // La cadena es correcta y la devolvemos
            return cadena;
          }
        }
      }
      // Si llegamos aqui es que la cadena contenía algún error. Mostramos el mensaje
      imprimeLinea(mensajeError);
    }
  }

  /**
   * Solicita un valor real (double ) por teclado al usuario
   * @param prompt Prompt a mostrar
   * @param minimo Valor mínimo que debe tener el valor introducido. null para ningún valor mínimo
   * @param maximo Valor máximo que debe tener el valor introducido. null para ningún valor máximo
   * @return Valor introducido
   */
  public double solicitaDoble(String prompt, Double minimo, Double maximo) {
    // Hasta que se lea un número que cumpla los requisitos
    for (;;) {
      // Capturamos excepción por si se introduce algo que no sea un entero
      try {
        // Mostramos el prompt
        imprime(prompt);
        // Solicita el número
        double numero = Double.parseDouble(sc.nextLine());
        // Si hay mínimo y el número es mayor
        if (minimo == null || numero >= minimo) {
          // Si hay máximo y el número es menor
          if (maximo == null || numero <= maximo) {
            // El número está en rango
            return numero;
          } else {
            // El número es superior al máximo
            imprimeLinea(String.format(Locale.US, "Error. El número introducido (%f) es superior al valor máximo permitido (%f)", numero, maximo));
          }
        } else {
          // El número es inferior al mínimo
          imprimeLinea(String.format(Locale.US, "Error. El número introducido (%f) es inferior al valor mínimo permitido (%f)", numero, minimo));
        }
      } catch (NumberFormatException e) {
        // Lo introcido por el usuario no es un número
        imprimeLinea("Error. Debe introducir un número real");
      }
    }
  }
}
