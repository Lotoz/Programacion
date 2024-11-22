package ejercicio08;

import ejercicio08.IntervaloTiempo;

public class PruebaIntervaloTiempo {

  public static void main(String[] args) {
    // Insertamos los intervalos
    PruebaIntervaloTiempo prueba = new PruebaIntervaloTiempo();
    prueba.run();
  }

  private void imprimeIntervalo(IntervaloTiempo intervalo) {
    System.out.println(intervalo.obtenerCadena());
  }

  private void run() {
    IntervaloTiempo intervalo = new IntervaloTiempo(1, 30, 40);
    IntervaloTiempo intervalo2 = new IntervaloTiempo(2, 20, 30);
    // Realizo la operacion suma
    IntervaloTiempo sumaSalida = intervalo.suma(intervalo2);
    // Realizo la operacion resta
    IntervaloTiempo restaSalida = intervalo.resta(intervalo2);

    // imprimimos los resultados
    imprimeIntervalo(intervalo);
    imprimeIntervalo(intervalo2);
    System.out.println("La suma vale :" + sumaSalida.obtenerCadena());
    System.out.println("La resta vale :" + restaSalida.obtenerCadena());
//Agregar amplificar intervalos y agregar pasar solo a minuto, pasar solo hora.
//Agregar pasar a dia.
    //Darle espaciado 2/2 en format code style.
  }
}
