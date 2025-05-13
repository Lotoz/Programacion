
public class Clase1 {

  // Atributos de la clase
  private static int i;
  private static int j;
  private static int cociente;
  private static int resto;
  private static int paso;

  /**
   * Cuenta del 1 al 8 y dice si es par o impar
   * 
   * @param args
   */
  public static void main(String[] args) {
    i = 0;
    paso = 0;

    do {

      j = 1;
      paso = paso + 1;

      while (j <= 8) {
        cociente = (i + j) / 2;
        resto = (i + j) - cociente * 2;
        if (resto == 0) {
          // Si es par
          System.out.println("Negro" + "  " + "PAR");
        } else {
          // Si es impar
          System.out.println("Blanco" + "  " + "IMPAR");
        }
        j++;
      }
      i++;
    } while (i > 8);
    System.out.println(paso);
  }
}
