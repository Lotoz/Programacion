package prog.unidad04.practica406.libreria;

import java.util.Random;

import prog.unidad04.practica406.libreria.Fecha;

public class Vehiculo {

  // Metodos privados para usos concretos en la construccion del objeto en la
  // clase
  private String matricula;
  private Fecha fechaMatriculacion;

  // Constructor privado de la clase, tiene importado el constructor fecha
  protected Vehiculo(String matricula, Fecha fechaMatriculacion) {
    this.matricula = matricula;
    this.fechaMatriculacion = fechaMatriculacion;

  }

  // Sirve para obtener la matricula del vehiculo
  public String getMatricula() {
    // La matricula debe estar conformada por 4 numeros y 3 letras
    // Usar mi metodo de DNI truco, ya que debe por los 4 primeros numeros definir
    // las 3 letras que saldran.Por ende contador.

    return matricula;
  }
  // Validador de matricula

  private String validadorMatricula(String matricula) {
    Random generador = new Random();
    int numerosMatricula = generador.nextInt();
    char letra = (char) (generador.nextInt(65, 90));
    return matricula = "" + letra;
  }

  // Sirve para obtener la fecha del vehiculo desde cuando fue matriculado
  public Fecha getFechaMatriculacion(Fecha fechaMatriculacion) {

    return fechaMatriculacion;

  }

  // Contador de vehiculos, cuenta cuantos hay creados.
  public static int getVehiculosMatriculados(int vehiculo) {
    int contador = 0;
    for (int i = 0; i <= vehiculo; i++) {
      contador = contador + i;
      i++;
    }
    return contador;
  }

  public String toString() {
    return getMatricula() + getFechaMatriculacion(fechaMatriculacion);
  }
}
