package prog.unidad06.ficheros.ejercio01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 * Solicita desde teclado la ruta del fichero y devuelve su contenido
 */
public class MuestraFicheroTextoApp {

  public static void main(String[] args) {
    //Generamos un scan
    Scanner scan = new Scanner(System.in);
    
    //Pedimos el fichero por el terminal
    System.out.printf("Introduce la ruta del archivo a mostrar:");
    String rutaFichero = scan.nextLine();
    
    //Invocamos el metodo privado, lee fichero
    leerFichero(rutaFichero);
    
  }
  private static void leerFichero(String nombre) {
    try (BufferedReader flujoEntrada = new BufferedReader(new FileReader(nombre))){
     String linea = null;
     System.out.printf("Contenidos del fichero: %s%n", nombre);
      while (linea == null) {
        linea = flujoEntrada.readLine();
        if(linea !=null) {
          System.out.printf("%s", linea);
        }
      }
    }catch (IOException e){
      System.err.printf("Error al leer el fichero %s",nombre);
    }
  }

}
