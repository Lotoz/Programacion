package examenSimulacion.ficheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Un gestor de ficheros
 */
public class gestorFicherosApp {

  private static final int OPCION_SALIR = 0;
  private static final int OPCION_ESCRIBIR = 1;
  private static final int OPCION_CREMALLERA = 2;
  private static final int OPCION_MOSTRAR = 3;
  private static final int OPCION_COPIAR = 4;
  private static final int OPCION_GENERA_BYTES = 5;
  private static final int OPCION_CUENTA_BYTES = 6;
  private static final int OPCION_MOSTRAR_BYTES = 7;
  
  private String ficheroRuta;
  private Scanner scan = new Scanner(System.in);
  
  /**
   * Constructor con la ruta del fichero a usar.
   * 
   */
  public gestorFicherosApp() {
  }
  
  /**
   * Main visual CLI
   */
  public static void main(String[] args) {
    gestorFicherosApp app  = new gestorFicherosApp();
    app.run();
  }
  
  /**
   * Run de la aplicacion.
   */
  private void run() {
    System.out.printf("Gestor Ficheros App%n");
    System.out.printf("------------------%n");
    System.out.printf("1) Escribir fichero.%n"
        + "2) Genera Cremallera. %n"
        + "3) Mostrar contenidos del fichero.%n"
        + "4) Copiar fiechero.%n"
        + "5) Genera bytes.%n"
        + "6) Cuenta bytes.%n"
        + "7) Muestra bytes.%n"
        + "Para salir ingrese 0.%n"
        + "Opcion:");
    int opcionElegida = Integer.parseInt(scan.nextLine());
    do {
      // Muestra el menú y obtiene una elección
      
      // Según la opción elegida
      switch (opcionElegida) {
      case OPCION_ESCRIBIR:
        comandoEscribir();
        break;
      case OPCION_CREMALLERA:
        comandoCremallera();
        break;
      case OPCION_MOSTRAR:
        comandoMostrar();
        break;
      case OPCION_COPIAR:
        comandoCopiar();
        break;
      case OPCION_GENERA_BYTES:
        comandoGeneraBytes();
        break;
      case OPCION_CUENTA_BYTES:
        comandoCuentaBytes();
        break;
      case OPCION_MOSTRAR_BYTES:
        comandoMostarBytes();
        break;
      case OPCION_SALIR:
        break;
      default:
        // No se debe llegar aqui
        System.out.println("Error. Opción incorrecta.");
      }
    } while (opcionElegida != OPCION_SALIR);
  }

  /**
   * Escribir un txt. con lo que ingrese el usuario.
   */
  private void comandoEscribir() {
      System.out.printf("Introduce la ruta de salida:");
      ficheroRuta = scan.nextLine();

      // Invocamos metodo privado
      EscribeFichero(ficheroRuta);
  }

  private void EscribeFichero(String ruta) {
    try (PrintWriter flujoSalida = new PrintWriter(new FileWriter(ruta))) {
      //Ver como hacer para crear solo un scan
      Scanner scan = new Scanner(System.in);
      //Ciclo para leer el archivo
      System.out.printf("Fichero iniciado con exito, introduzca  el texto a almacenar línea a línea y una línea vacia para terminar.%n");
      String linea = "";
      
        do {
          System.out.printf("Texto de la linea:");
          linea = scan.nextLine();
          flujoSalida.println(linea);
        } while (!linea.isEmpty());
      
    }catch (IOException e){
      
      System.err.printf("No se puede escribir en el fichero.%n");

    }
    
  }

  private void comandoCremallera() {

    
  }

  private void comandoMostrar() {
    //Pedimos el fichero por el terminal
    System.out.printf("Introduce la ruta del archivo a mostrar:");
    String rutaFichero = scan.nextLine();
    
    //Invocamos el metodo privado, lee fichero
    leerFichero(rutaFichero);
    
  }

  private void leerFichero(String ruta) {
    try (BufferedReader flujoEntrada = new BufferedReader(new FileReader(ruta))){
      String linea = null;
      System.out.printf("Contenidos del fichero: %s%n", ruta);
       while (linea == null) {
         linea = flujoEntrada.readLine();
         if(linea !=null) {
           System.out.printf("%s", linea);
         }
       }
     }catch (IOException e){
       System.err.printf("Error al leer el fichero %s%n",ruta);
     }
    
  }

  private void comandoCopiar() {
    
    
  }

  private void comandoGeneraBytes() {
    
    
  }

  private void comandoCuentaBytes() {
    
    
  }

  private void comandoMostarBytes() {
   
    
  }

}
