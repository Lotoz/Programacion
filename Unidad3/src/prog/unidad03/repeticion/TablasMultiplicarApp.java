package prog.unidad03.repeticion;

public class TablasMultiplicarApp {

  public static final int TABLAINICIO = 1;
  public static final int TABLAFIN = 10;

  public static void main(String[] args) {
    
    // Muestra la cabecera
    System.out.println("TABLAS DE MULTIPLICAR");

    // Para cada tabla
    for (int tablaDel = TABLAINICIO; tablaDel <= TABLAFIN; tablaDel++) {
      // Imprime la cabecera de la tabla
      System.out.printf("%nTabla del %d%n", tablaDel);
      System.out.println("------------");
      
      // Y ahora se imprime el cuerpo de la tabla usando otro ciclo anidado
      for (int i = TABLAINICIO; i <= TABLAFIN; i++) {
        System.out.printf("%d X %d = %d%n", tablaDel, i, (tablaDel * i));
      }
    }
  }

}
