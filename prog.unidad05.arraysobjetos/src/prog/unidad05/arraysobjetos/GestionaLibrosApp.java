package prog.unidad05.arraysobjetos;

import java.util.Scanner;

public class GestionaLibrosApp {

  public static void main(String[] args) {

    // Declaracion de variables
    boolean salida = false;
    int opcionMenu = 0;
    String titulo = "";
    String autor = "";
    int anyoPublicacion = 0;
    Scanner scan = new Scanner(System.in);
 
    Libro[] libros = new Libro[1]; 

    // Comienzo del ciclo
    do {

      // Primercabezal
      System.out.println("GESTIÓN DE LIBROS");
      System.out.println("- - - - - - - - - -");
      System.out.println("(1) Agregar libro");
      System.out.println("(2) Mostrar todos los libros");
      System.out.println("(3) Buscar libro por título");
      System.out.println("(4) Buscar libro por año de publicación");
      System.out.println("(0) Salir de la aplicion");
      System.out.println("Introduzca una opcion (0-4): ");
      opcionMenu = Integer.parseInt(scan.nextLine());
      switch (opcionMenu) {

      case 0:

        // Salida del ciclo
        salida = true;

        break;

      case 1:

        // Segundo cabezal
        System.out.println("AGREGAR LIBRO");
        System.out.println("- - - - - - - - - -");
        System.out.println("Introduzca el titulo del libro: ");
        titulo = scan.nextLine();
        System.out.println("Introduzca el nombre del autor del libro: ");
        autor = scan.nextLine();
        System.out.println("Introduzca el año de publicación del libro: ");
        anyoPublicacion = Integer.parseInt(scan.nextLine());
        Libro libro = new Libro(titulo, autor, anyoPublicacion);
        libros[0] = libro;

        break;

      case 2:
        System.out.printf("MOSTRAR LIBROS. %n");
        System.out.printf("---------------------");
        mostrarLibros(libros);
        
        break;

      case 3:
        System.out.printf("BUSCAR LIBRO POR TITULO");
        System.out.printf("--------------------------");
        System.out.printf("Introduzca el texto de búsqueda (no puede dejarse en blanco):%n");
        titulo = scan.nextLine();
        mostrarLibros(libros);
   
        break;

      case 4:
        System.out.printf("BUSCAR LIBRO POR TITULO");
        System.out.printf("--------------------------");
        System.out.printf("Introduzca el año a buscar: %n");
        anyoPublicacion = scan.nextInt();
        mostrarLibros(libros);
        
        break;

      default:

        System.out.println("Introduce un numero del 0 al 4");
        break;
      }
    } while (!salida);
  }
  
  private static Libro[] agregarLibro(Libro libros []){
    int contador = 0;
    Libro[] nuevo = new Libro[contador]; 
    for (int i = 0; i < libros.length ; i++) {
      nuevo = libros;
      contador ++;
    }
    return nuevo;
  }
  
  private static void mostrarLibros(Libro[] libros){
    for( int i = 0 ; i < libros.length ; i ++) {
      System.out.println("" + libros[i]);
    }
  }
  private Libro[] buscarLibros(Libro libros [], String titulo){
    int contador = 0;
    Libro[] nuevo = new Libro[contador];
    for(Libro l : libros){
      if (l.getTitulo().equals(titulo)) {
        nuevo [contador] = l;
        contador++;
      }
    }
    return nuevo;
  }
  
  private Libro[] buscarLibros(Libro libros [], int anyoPublicacion){
    int contador = 0;
    Libro[] nuevo = new Libro[contador];
    for(Libro l : libros){
      if (l.getAnyoPublicacion() == anyoPublicacion) {
        nuevo [contador] = l;
        contador++;
      }
    }
    return nuevo;
  }
  
}
