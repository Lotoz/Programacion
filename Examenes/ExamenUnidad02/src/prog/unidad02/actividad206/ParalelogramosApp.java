package prog.unidad02.actividad206;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;


import es.iespablopicasso.programacion.bloque02.figuras.Paralelogramo;

public class ParalelogramosApp {

  public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);
    //Se pide al usuario que ingrese la longitud de los lados horizontales.
    System.out.print("Introduzca la longitud de los lados horizontales:");
    double ladoHorizontal = Double.parseDouble(scan.nextLine());
    
    //Se pide al usuario que introduzca el limite minimo
    System.out.print("Introduzca el límite mínimo de los posibles valores de la longitud del "
        + "lado vertical:");
    double limiteMin = Double.parseDouble(scan.nextLine());
    
    //Se pide al usuario que introduzca el limite maximo
    System.out.print("Introduzca el límite maximo de los posibles valores de la longitud del "
        + "lado vertical:");
    double limiteMax = Double.parseDouble(scan.nextLine());
   
    //Creamos un objeto con la clase Random en java
    Random numeroAleatorio = new Random();
    
    //Genero una variable para introducir el numero random
    double ladoVertical = numeroAleatorio.nextDouble(limiteMin, limiteMax);
    
    //Imprimimos por pantalla este lado aleatorio
    System.out.printf(Locale.US,"La longitud del lado vertical obtenida al azar es de: %f%n", ladoVertical);
    
    //Creo un paralelogramo
    Paralelogramo paralelogramo = new Paralelogramo(ladoHorizontal, ladoVertical);
    
    //Obtenemos el perimetro y el area.
    String areaPerimetro = paralelogramo.getAreaPerimetro();
    
   
    //Separo el perimetro del area y lo guardo
    String cadena2 = (String) areaPerimetro.substring(18);
    double perimetroParalelogramo = Double.parseDouble(cadena2);
    
    //Separo el area del perimetro y lo guardo
    String cadena3 = (String) areaPerimetro.subSequence(0,16);
    double areaParalelogramo = Double.parseDouble(cadena3);
    
    //Ahora calculamos el area con el constructor de la paquete paralelogramo
    System.out.printf(Locale.US,"El área del paralelogramo vale:  %f%n", areaParalelogramo);
    System.out.printf(Locale.US,"El perimetro del paralelogramo vale: %f%n", perimetroParalelogramo);
    
    System.out.print("Introduzca el factor real positivo por el que quiere ampliar"
    + "(mayor que 1) o reducir (menor que 1) el paralelogramo:");
    double valorReal = Double.parseDouble(scan.nextLine());
    
    //Pasamos nuestro paralelogramo a double para poder calcular luego
    //double paralelogramoAmplificar = Double.parseDouble(areaPerimetro);
    //String valorRealCadena = String.valueOf(valorReal);
    double paralelogramo2 = valorReal;
    
    //Hacemos el calculo escalar
  
    
    
    //Convertimos lado vertical a double para poder generar el paralelogramo con los lados double
    //String cadena = String.valueOf(ladoVertical);
    //double ladoVerticalDouble = Double.parseDouble(cadena);
    //Ahora le solicitamos al usuario un valor real de escala.
    //System.out.print("Introduzca el factor real positivo por el que quiere ampliar"
        //+ "(mayor que 1) o reducir (menor que 1) el paralelogramo:");
    //double valorReal = Double.parseDouble(scan.nextLine());
   
    
    //Pasamos nuestro paralelogramo anterior a double y hacemos el calculo con el escalado.
    //String cadena2 = String.valueOf(paralelogramo);
    //double valorParaEscalar = Double.parseDouble(cadena2);
    
    //Calculamos el escalado.
    

    
    
    
    //Paralelogramo paralelogramoEscaldo = new Paralelogra(lado, ladoVerticalDoubn)
    
    
    
    
    
    
}
}