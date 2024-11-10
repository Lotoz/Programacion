package prog.unidad3.repeticion;

import java.util.Scanner;
import java.util.Random;

public class AdivinaNumero {

  public static void main(String[] args) { 
    
    //insertamos un scan para tomar los numeros que va a introducir el usuario
    Scanner scan = new Scanner(System.in);
    //Insertamos el random
    Random aleatorio = new Random();
    
    //creamos la variable random y la convertimos a int
    int numeroAleatorio = aleatorio.nextInt(1,100);
    
    System.out.printf("He pensado un numero entre 1 y 100. Quieres jugar? Y / N");
    if ( )
    //Tenemos que empezar a descontar numeros
    int intento = 0; 
    //Le decimos que empiece
    System.out.printf("Tienes 10 intentos, empieza con tu primer intento:%n");
    int numero = Integer.parseInt(scan.nextLine());
    for (int contador = 0 ; numero == numeroAleatorio; contador++){
      if( numero == numeroAleatorio) {
        System.out.printf("Lo has adivinado, tremendo.");
      }else if (numero != numeroAleatorio){ 
    //empieza el ciclo de intentos funcional
    for (int i = intento; intento < 10  ; intento++) {
      System.out.printf("Intento %d. Prueba de nuevo.", intento);
      boolean numero2 = Integer.parseInt(scan.nextLine()) == numero;     
      }
     }
    //Ahora debemos agregar el contador de que en cuantos intentos los has hecho y debemos agregar un reintento.
  }
 }   
}


