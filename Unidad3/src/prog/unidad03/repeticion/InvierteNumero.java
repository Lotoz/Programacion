package prog.unidad03.repeticion;

import java.util.Scanner;

public class InvierteNumero {

  public static void main(String[] args) {
    // Para leer desde teclado
    Scanner sc = new Scanner(System.in);
    
    // Cabecera
    System.out.println("INVERSIÓN DE NÚMEROS");
    
    // Solicita el número
    System.out.print("Introduce un número entero positivo: ");
    int numero = Integer.parseInt(sc.nextLine());
    
    // Inicia el resultado (a cero)
    int resultado = 0;
    // Inicia el resto (al valor del numero)
    int resto = numero;
    
    /* El proceso básicamente consiste en extraer repetídamente el dígito menos significativo
     * del número (empleando el resto entre 10) y añadirlo al resultado. Para que se mantengan
     * los dígitos ya extraidos se multiplica en cada vuelta el resultado por 10 a fin de hacer
     * "hueco" para el dígito nuevo. El proceso termina cuando nos quedamos sin dígitos (el
     * número llega a cero)
     */
    while (resto > 0) {
      // Extraemos el último dígito y actualizamos el resto
      int digito = resto % 10;
      resto /= 10;
      
      // Lo añadimos al resultado, multiplicando este por 10 para hacer hueco por la derecha del
      // nuevo dígito
      resultado = resultado * 10 + digito;
    }
    // Ya tenemos el resultado. Se imprime
    System.out.printf("El resultado de invertir el número %d es %d%n", numero, resultado);
  }

}
