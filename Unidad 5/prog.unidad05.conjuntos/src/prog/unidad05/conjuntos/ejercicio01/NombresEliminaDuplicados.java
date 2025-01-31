package prog.unidad05.conjuntos.ejercicio01;

import java.util.Scanner;

//Import elegido para manipular el conjunto
import java.util.HashSet;

public class NombresEliminaDuplicados {
  /**
   * Atributos
   */
  Scanner scan = new Scanner(System.in);
  String nombre;
  HashSet <String> conjunto = new HashSet<String>() ;
  
  /**
   * Ejecuta la aplicacion
   * @author Zamira Grippi
   * @param args
   */
  public static void main(String[] args) {
    NombresEliminaDuplicados app = new NombresEliminaDuplicados();
    app.run();
  }
  /**
   * Ejecuta el main.
   */
  private void run() {
      System.out.printf("NOMBRES DUPLICADOS I%n");
      addConjunto();
      imprimirConjunto();
  }
  
  private HashSet<String> addConjunto() {
 //Debe añadir el nombre al conjunto y guardarlo SI NO ES DUPLICADO
    do {
      System.out.printf("Introduzca un nombre (vacío para terminar):");
      nombre = scan.nextLine();
      //Añade al conjunto
      conjunto.add(nombre);
    } while (!nombre.equals(""));//Finaliza cuando nombre sea vacio
    return conjunto;
  }

  private void imprimirConjunto() {
    System.out.printf("Los nombres introducidos sin duplicados son:");
    //imprime por pantalla los nombres del conjunto
    for ( String nombre : conjunto) {
      System.out.println(nombre);
    }
  }
  
}

