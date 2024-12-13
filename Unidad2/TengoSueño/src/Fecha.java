
public class Fecha {

  public int dia;
  public int mes;
  public int anyo;

  public Fecha(int dia, int mes, int anyo) {

    this.anyo = anyo;
    this.mes = mes;
    this.dia = dia;
  }

  public static void main(String[] args) {

  }

  public static int getVehiculosMatriculados(int vehiculo) {
    int contador = 0;
    for (int i = 0; i <= vehiculo; i++) {
      contador = contador + i;
      i++;
    }
    return contador;
  }
}
