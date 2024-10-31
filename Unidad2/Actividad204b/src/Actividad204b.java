import java.util.Scanner;
import paquete1.Fraccion;
import paquete2.*;

public class Actividad204b {

  public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);
    System.out.print("Introduce el numerador");
    int numerador1  = Integer.parseInt(scan.nextLine());
    System.out.print("Introduce el denominador");
    int denominador1  = Integer.parseInt(scan.nextLine());
    
    System.out.print("Introduce el numerador");
    int numerador2  = Integer.parseInt(scan.nextLine());
    System.out.print("Introduce el denominador");
    int denominador2  = Integer.parseInt(scan.nextLine());

    Fraccion fraccion1 = new Fraccion(numerador1, denominador1);
   
    Fraccion fraccion2 = new Fraccion(numerador2, denominador2);
    
    Fraccion suma = fraccion1.suma(fraccion2);
    Fraccion resta = fraccion1.resta(fraccion2);
    Fraccion division = fraccion1.division(fraccion2);
    Fraccion producto = fraccion1.producto(fraccion2);
    
    System.out.println("///////////////////////");
    System.out.println("Resultados de calculos:");
    
    System.out.printf("La suma es: %d/%d%n", suma.getNumerador(), suma.getDenominador());
    System.out.printf("La resta es: %d/%d%n", resta.getNumerador(), resta.getDenominador());
    System.out.printf("La division es: %d/%d", division.getNumerador(), division.getDenominador());
    System.out.printf("La producto es: %d/%d%n", producto.getNumerador(), producto.getDenominador());
    
    int sumaNumerador = suma.getNumerador();
    int sumaDenominador = suma.getNumerador();
    
    paquete2.Fraccion sumaSimplificar = new paquete2.Fraccion(sumaNumerador, sumaDenominador).simplifica();
    
    int restaNumerador = resta.getNumerador();
    int restaDenominador = resta.getDenominador();
    
    paquete2.Fraccion restaSimplificar = new paquete2.Fraccion(restaNumerador, restaDenominador).simplifica();
    
    
    int divisionNumerador = division.getNumerador();
    int divisionDenominador = division.getDenominador();
    
    paquete2.Fraccion divisionSimplificar = new paquete2.Fraccion(divisionNumerador, divisionDenominador).simplifica();
    
   
    int productoNumerador = producto.getNumerador();
    int productoDenominador = producto.getDenominador();
    
    paquete2.Fraccion productoSimplificar = new paquete2.Fraccion(productoNumerador, productoDenominador).simplifica();
    
   
    System.out.println("///////////////////////");
    System.out.println("Simplificacion:");
    
    System.out.printf("La suma simplificada es: %d/%d%n", sumaSimplificar.getNum(), sumaSimplificar.getDen());
    System.out.printf("La resta simplificada es: %d/%d%n", restaSimplificar.getNum(), restaSimplificar.getDen());
    System.out.printf("La division simplificada es: %d/%d%n", divisionSimplificar.getNum(), divisionSimplificar.getDen());
    System.out.printf("La producto simplificada es: %d/%d%n", productoSimplificar.getNum(), productoSimplificar.getDen());
    
  }
}
