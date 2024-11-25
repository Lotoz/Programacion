package prog.unidad04.actividad402.ejercicio06.pruebas;

import prog.unidad04.actividad402.ejercicio06.Circulo;
import prog.unidad04.actividad402.ejercicio06.Punto;
import prog.unidad04.actividad402.ejercicio06.Rectangulo;
import prog.unidad04.actividad402.ejercicio06.Triangulo;
import java.util.Locale;

/**
 * Prueba Circulo, Triangulo, Rectangulo (y Punto)
 */
public class PruebaFiguras {
  public static void main(String[] args) {
    
    // Cabecera
    System.out.println("PROGRAMA DE PRUEBA DE FIGURAS");
    
    // Creamos un triángulo 
    Triangulo triangulo = new Triangulo(new Punto(0,0), new Punto(0, 1), new Punto(1, 0));

    // Circulo
    Circulo circulo = new Circulo(new Punto(0,0), 2.5);
    
    // Y dos rectángulos. El segundo es en realidad un cuadrado
    Rectangulo rectangulo = new Rectangulo(new Punto(0, 0), new Punto(2, 3));
    Rectangulo cuadrado = new Rectangulo(new Punto(0, 0), new Punto(2, 2));
    
    // Calculamos área y perímetro de todas las figuras
    // Para los rectángulos usamos además el método esCuadrado
    System.out.printf(Locale.US, "Area triangulo = %f%n", triangulo.area());
    System.out.printf(Locale.US, "Perimetro triangulo = %f%n", triangulo.perimetro());
    System.out.printf(Locale.US, "Area circulo = %f%n", circulo.area());
    System.out.printf(Locale.US, "Perimetro circulo (circunferencia) = %f%n", circulo.perimetro());
    System.out.printf(Locale.US, "Area rectángulo no cuadrado = %f%n", rectangulo.area());
    System.out.printf(Locale.US, "Perimetro rectángulo no cuadrado = %f%n", rectangulo.perimetro());
    System.out.printf(Locale.US, "Area rectángulo cuadrado = %f%n", cuadrado.area());
    System.out.printf(Locale.US, "Perimetro rectángulo cuadrado = %f%n", cuadrado.perimetro());
    System.out.printf("El primer rectángulo es cuadrado?: %s%n", (rectangulo.esCuadrado() ? "si" : "no"));
    System.out.printf("El segundo rectángulo es cuadrado?: %s%n", (cuadrado.esCuadrado() ? "si" : "no"));
  }

}
