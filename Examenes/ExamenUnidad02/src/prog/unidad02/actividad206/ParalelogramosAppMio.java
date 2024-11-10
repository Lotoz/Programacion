package prog.unidad02.actividad206;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;


import es.iespablopicasso.programacion.bloque02.figuras.Paralelogramo;

public class ParalelogramosAppMio {

  public static void main(String[] args) {
    
    //Encabezado estetico
    System.out.printf("EXAMEN DE Zamira Grippi. PROPIEDADES DE LOS PARALELOGRAMOS%n");  
        
      Scanner scan = new Scanner(System.in);
      //Se pide al usuario que ingrese la longitud de los lados horizontales.
      System.out.printf("Introduzca la longitud de los lados horizontales:%n");
      double ladoHorizontal = Double.parseDouble(scan.nextLine());
      
      //Se pide al usuario que introduzca el limite minimo
      System.out.printf("Introduzca el límite mínimo de los posibles valores de la longitud del "
          + "lado vertical:%n");
      double limiteMin = Double.parseDouble(scan.nextLine());
      
      //Se pide al usuario que introduzca el limite maximo
      System.out.printf("Introduzca el límite maximo de los posibles valores de la longitud del "
          + "lado vertical:%n");
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
      String cadena1 = (String) areaPerimetro.substring(18);
      double perimetroParalelogramo = Double.parseDouble(cadena1);
      
      //Separo el area del perimetro y lo guardo
      String cadena2 = (String) areaPerimetro.subSequence(0,16);
      double areaParalelogramo = Double.parseDouble(cadena2);
      
      //Ahora calculamos el area con el constructor de la paquete paralelogramo
      System.out.printf(Locale.US,"El área del paralelogramo vale:  %f%n", areaParalelogramo);
      System.out.printf(Locale.US,"El perimetro del paralelogramo vale: %f%n", perimetroParalelogramo);
      
      System.out.print("Introduzca el factor real positivo por el que quiere ampliar"
      + "(mayor que 1) o reducir (menor que 1) el paralelogramo:");
      double valorReal = Double.parseDouble(scan.nextLine());
      
      //Creamos un nuevo paralelogramo
      Paralelogramo paralelogramo2 = new Paralelogramo(ladoHorizontal, ladoVertical);
      
      //Escalamos nuestro paralelogramo
      paralelogramo2.escala(valorReal);
      
      //Obtenemos el perimetro y el area.
      String areaPerimetroEscalado = paralelogramo2.getAreaPerimetro();
      
      //Separo el perimetro del area y lo guardo
      String cadena3 = (String) areaPerimetroEscalado.substring(18);
      double perimetroParalelogramoEscalado= Double.parseDouble(cadena3);
      
      //Separo el area del perimetro y lo guardo
      String cadena4 = (String) areaPerimetroEscalado.subSequence(0,16);
      double areaParalelogramoEscalado = Double.parseDouble(cadena4);
      
      //Imprimimos los resultados por pantalla
      System.out.printf(" Depués del escalado, el área del paralelogramo vale ahora %f y "
          + "el perimetro %f%n",perimetroParalelogramoEscalado, areaParalelogramoEscalado);
      
      //Realizamos la suma del area y el perimetro.
      double suma = perimetroParalelogramo + areaParalelogramo;
      
      //Imprimimos
      System.out.printf("La suma del área y el perímetro es %f", suma);
}
}