package prog.unidad02.actividad206;

import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;

import es.iespablopicasso.programacion.bloque02.figuras.Paralelogramo;

public class ParalelogramosApp {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    // Se pide al usuario que ingrese la longitud de los lados horizontales.
    System.out.print("Introduzca la longitud de los lados horizontales:");
    double lado = Double.parseDouble(scan.nextLine());

    // Se pide al usuario que introduzca el limite minimo
    System.out.print("Introduzca el límite mínimo de los posibles valores de la longitud del " + "lado vertical:");
    double limiteMin = Double.parseDouble(scan.nextLine());

    // Se pide al usuario que introduzca el limite maximo
    System.out.print("Introduzca el límite maximo de los posibles valores de la longitud del " + "lado vertical:");
    double limiteMax = Double.parseDouble(scan.nextLine());

    // Conseguimos los numeros con la clase random
    // RandomGenerator ladoVertical = RandomGenerator.of("limiteMin, limiteMax");
    Random random = new Random();
    double ladoVertical = random.nextDouble(limiteMin, limiteMax);

    // Imprimimos por pantalla.
    System.out.printf("La longitud del lado vertical obtenida al azar es de: %f%n", ladoVertical);

    // Convertimos lado vertical a double para poder generar el paralelogramo con
    // los lados double
    // String cadena = String.valueOf(ladoVertical);
    // double ladoVerticalDouble = Double.parseDouble(cadena);

    // Creamos ese paralelogramo
    Paralelogramo paralelogramo = new Paralelogramo(lado, ladoVertical);

    // Obtenemos el perimetro y el area.
    String areaPerimetro = paralelogramo.getAreaPerimetro();

    String perimetro = areaPerimetro.substring(19);
    String area = areaPerimetro.substring(1, 15);
    // Ahora calculamos el area con el constructor de la paquete paralelogramo
    System.out.printf("El área del paralelogramo vale %s y el perimetro vale %s%n", area ,perimetro);

    // Ahora le solicitamos al usuario un valor real de escala.
    System.out.print("Introduzca el factor real positivo por el que quiere ampliar"
      + "(mayor que 1) o reducir (menor que 1) el paralelogramo:");
   double valorReal = Double.parseDouble(scan.nextLine());
   
   //Escalamos
   //No escala xD
   paralelogramo.escala(valorReal);
   
   
   
   //Obtenemos nuevo perimetro y area
   String areaPerimetro2 = paralelogramo.getAreaPerimetro();
   String perimetro2 = areaPerimetro.substring(19);
   String area2 = areaPerimetro.substring(1, 15);
// pantalla
   System.out.printf("El área del paralelogramo vale %s y el perimetro vale %s%n", area ,perimetro);
   
   //Convertimos para la suma
   double areaDouble = Double.parseDouble(area2);
   double perimetroDouble = Double.parseDouble(perimetro2);
   
   double suma = areaDouble + perimetroDouble;
   
   System.out.printf("La suma vale %f%n",suma);
   
   
  }
}