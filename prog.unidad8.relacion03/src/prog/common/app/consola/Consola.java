package prog.common.app.consola;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Scanner;

/**
 * Consola de terminal<br>
 * Proporciona servicio de entrada por teclado y salida por pantalla
 */
public class Consola {
  
  // Atributos
  // Única instancia de la consola
  private static Consola instancia = null;
  
  // Scanner para la lectura desde teclado
  private Scanner scanner;
  
  /**
   * Constructor privado para prevenir la construcción de otras instancias
   */
  private Consola() {
    // Inicializamos el Scanner para la lectura desde teclado
    scanner = new Scanner(System.in);
  }

  /**
   * Obtiene la consola
   * @return Consola
   */
  public static Consola getConsola() {
    // Si no se ha iniciado aún la instancia
    if (instancia == null) {
      // La iniciamos
      instancia = new Consola();
    }
    
    // Devolvemos la instancia
    return instancia;
  }
  
  /**
   * Lee una cadena desde teclado mostrando un prompt.<br>
   * La cadena se valida frente a una expresión regular y si no es válida se
   *   sigue pidiendo hasta que lo sea
   * @param prompt Texto a mostrar al usuario. Se añade al final el separador
   *   ":" y un espacio
   * @param validacion Expresión regular a emplear para determinar si la cadena
   *   leida es válida o no. Si es null no se valida la cadena leida y
   *   cualquiera es correcta
   * @return Texto leido desde el teclado
   */
  public String leeCadena(String prompt, String validacion) {
    // Indefinidamente
    for (;;) {
      // Mostramos el prompt y el separador
      escribe(prompt + ": ");
      // Lee la cadena
      String cadena = scanner.nextLine();
      // Si no hay que validarla (validacion == null) o valida correctamente
      if (validacion == null || cadena.matches(validacion)) {
        // Se devuelve
        return cadena;
      } else {
        // Si no valida correctamente muestra error
        escribeLinea("La cadena introducida no es correcta. Inténtelo de nuevo");
      }
    }
      
  }
  
  /**
   * Intenta leer un número entero desde teclado mostrando un prompt<br>
   * El número se continúa solicitando hasta que se introduce un número correcto
   * y está comprendido entre los límites especificados
   * @param prompt Prompt a mostrar al usuario. Se añade al final el separador : y un espacio
   * @param valorMinimo Valor mínimo del entero a leer. Si se proporciona,
   *   cualquier número leido debe ser superior o igual al especificado. Si no
   *   se espcifica no hay valor mínimo
   * @param valorMaximo Valor máximo del entero a leer. Si se proporciona,
   *   cualquier número leido debe ser inferior o igual al especificado. Si no 
   *   se especifica no hay valor maximo
   * @return valor leido
   */
  public int leeEntero(String prompt, OptionalInt valorMinimo, OptionalInt valorMaximo) {
    // El ciclo se termina por las bravas devolviendo valor
    for(;;) {
      // Lee valor en formato texto
      String valor = leeCadena(prompt, null);
      // Intenta convertirlo a entero
      try {
        int valorLeido = Integer.parseInt(valor);
        // Si hay un valor minimo, debe ser mayor o igual que éste
        if (valorMinimo.isEmpty() || valorLeido >= valorMinimo.getAsInt() && valorMaximo.isEmpty() || valorLeido <= valorMaximo.getAsInt()) {
          return valorLeido;
        } else {
          escribeLinea("Error. El valor introducido no está incluido entre los límites especificados");
        }
      } catch (NumberFormatException e) {
        escribeLinea("Error. El valor introducido no es un entero válido. Debe constar de signo (+ o -, opcional) y sólo dígitos");
      }
    }
  }

  /**
   * Intenta leer un número real desde teclado mostrando un prompt<br>
   * El número se continúa solicitando hasta que se introduce un número correcto
   * y está comprendido entre los límites especificados
   * @param prompt Prompt a mostrar al usuario. Se añade al final el
   *   separador : y un espacio
   * @param valorMinimo Valor mínimo del número a leer. Si se proporciona,
   *   cualquier número leido debe ser superior o igual al especificado. Si no
   *   se espcifica no hay valor mínimo
   * @param valorMaximo Valor máximo del número a leer. Si se proporciona,
   *   cualquier número leido debe ser inferior o igual al especificado. Si no 
   *   se especifica no hay valor maximo
   * @param digitosDecimales Redondea el número para que tenga, como máximo,
   *   tantos decimales como se indica. Si no se especifica el número se queda
   *   con los decimales introducidos
   * @return valor leido
   */
  public double leeReal(String prompt, OptionalDouble valorMinimo, OptionalDouble valorMaximo, OptionalInt digitosDecimales) {
    // El ciclo se termina por las bravas devolviendo valor
    for(;;) {
      // Lee valor en formato texto
      String valor = leeCadena(prompt, null);
      // Intenta convertirlo a real
      try {
        double valorLeido = Double.parseDouble(valor);
        // Intentamos limitar los decimales tal y como se nos indica en digitosDecimales
        if (digitosDecimales.isPresent()) {
          double potenciaDecimal = Math.pow(10, digitosDecimales.getAsInt());
          valorLeido = Math.round(valorLeido * potenciaDecimal) / potenciaDecimal;
        }
        // Si hay un valor minimo, debe ser mayor o igual que éste. Lo mismo con el máximo
        if (valorMinimo.isEmpty() || valorLeido >= valorMinimo.getAsDouble() && valorMaximo.isEmpty() || valorLeido <= valorMaximo.getAsDouble()) {
          return valorLeido;
        } else {
          escribeLinea("Error. El valor introducido no está incluido entre los límites especificados");
        }
      } catch (NumberFormatException e) {
        escribeLinea("Error. El valor introducido no es un real válido. Debe constar de signo (+ o -, opcional) y sólo dígitos o un sólo punto (.) para separar la parte entera de la decimal");
      }
    }
  }

  /**
   * Intenta leer un carácter desde teclado
   * @param prompt Prompt a mostrar al usuario. Se añade al final el separador : y un espacio
   * @return valor leido
   */
  public char leeCaracter(String prompt) {
    // El ciclo se termina por las bravas devolviendo valor o lanzando excepción
    for(;;) {
      // Lee valor en formato texto
      String valor = leeCadena(prompt, null);
      // Si el valor tiene al menos un carácter
      if (valor.length() > 0) {
        // Devuelve el primero
        return valor.charAt(0);
      } else {
        // No se ha introducido nada. Error y reintento
        System.out.println("Error. Debe introducir al menos un carácter");
      }
    }
  }

  /**
   * Escribe un texto por pantalla y a continuación un salto de línea
   * @param linea Línea de texto a imprimir
   */
  public void escribeLinea(String linea) {
    System.out.println(linea);
  }

  /**
   * Escribe texto por pantalla
   * @param texto Texto a imprimir
   */
  public void escribe(String texto) {
    System.out.print(texto);
  }

  /**
   * Escribe un titulo por pantalla. El título se escribe con una linea en
   *   blanco antes, en mayúsculas y con una línea de guiones después
   * @param titulo Titulo a imprimir
   */
  public void escribeTitulo(String titulo) {
    System.out.println();
    System.out.println(titulo.toUpperCase());
    System.out.println("-".repeat(titulo.length()));
  }


}
