package CLIUtilidades;

import ConsolaUtilidades.ConsolaException;
import ConsolaUtilidades.ConsolaScan;

public class Prueba {
  private static ImprimirCLI impresor = ImprimirCLI.getInstance();
  private static ConsolaScan consola = ConsolaScan.getInstance();
  

  public static void main(String[] args) {
    boolean salida = false;

    do {

      try {

        impresor.imprimirUpper("Cuenta Pares");
       impresor.printOffJump("¿Cuántos pares deseas introducir?: ");
     
        int pares = consola.leerInt();
        if (pares > 0) {
          int contadorPar = 0;
          do {
            System.out.print("Introduce un numero entero: ");
            int numero = consola.leerInt();

            if (numero % 2 == 0) {
              // hacemos que lo amplifique para agregar mas
              contadorPar++;
            }
            if (pares == contadorPar) {

              System.out.printf("Haz introducido todo :D%n");
            } else {
              System.out.printf("Te faltan %d%n", pares - contadorPar);
            }
          } while (pares > contadorPar);
        }
        salida = true;
      } catch (NumberFormatException e) {
        ConsolaException.mostrarError(e);
      }
    } while (!salida);
  }

}
