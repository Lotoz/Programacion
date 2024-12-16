package prog.unidad04.practica406.libreria;

public class Motocicleta extends Vehiculo {

  private int cilindrada;
  private String matricula;
  private Fecha fechaMatriculacion;

  private Motocicleta(String matricula, Fecha fechaMatriculacion) throws Exception {
    super(matricula, fechaMatriculacion);
  }

  // Hija de vehiculo
  public Motocicleta(String matricula, Fecha fechaMatriculacion, int cilindrada) throws Exception {
    super(matricula, fechaMatriculacion);
      if (cilindrada == 0) {
        throw new NullPointerException();
      } else {
        this.cilindrada = cilindrada;
      }
  }

  public int getCilindrada() {
    return cilindrada;

  }

  public String getDistintivo() {

    if (cilindrada < 75) {

      return "0";

    } else if (cilindrada >= 75 && cilindrada <= 125) {

      return "ECO";

    } else if (cilindrada > 125 && cilindrada <= 500) {

      return "A";

    } else {

      return "B";

    }
   
  }

  public String toString() {

    return " Matricula: " + getMatricula() + " Fecha Matriculacion: " + getFechaMatriculacion() + " Cilindrada: " + cilindrada;

  }
}
