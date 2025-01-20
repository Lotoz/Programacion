package prog.unidad05.arraysobjetos;

import java.util.Scanner;

public class GestionaLibrosApp {

  private Libro[] libros;
  Scanner scan = new Scanner(System.in);
  // Constantes de opciones menu
  private static final int OPCION_SALIR = 0;
  private static final int OPCION_AGREGAR = 1;
  private static final  int OPCION_MOSTRAR = 2;
  private static final int OPCION_TITULO = 3;
  private static final int OPCION_ANYO = 4;

  // Main con run de aplicaciones
  public static void main(String[] args) {
    GestionaLibrosApp app = new GestionaLibrosApp();
    app.run();

  }

  private void run() {
    // Declaracion de variables
    int opcionMenu = 0;
    String titulo = "";
    String autor = "";
    int anyo = 0;

    Libro[] libros = new Libro[0];

    // Comienzo del ciclo
    do {
      opcionMenu = mostrarMenu();
      switch (opcionMenu) {
      case OPCION_SALIR -> {
      }
      case OPCION_AGREGAR -> agregarLibro();
      case OPCION_MOSTRAR -> mostrarLibro();
      case OPCION_TITULO -> buscarPorTitulo();
      case OPCION_ANYO -> buscarAnyo();
      }
    } while (opcionMenu != OPCION_SALIR);
  }

  private void agregarLibro() {
    Libro nuevoLibro = solicitaLibro();
    addLibro(nuevoLibro);

  }

  private void addLibro(Libro nuevoLibro) {
    // Hacemos espacio para el nuevo libro
    ampliaArrray();
    //Añadir libro
    libros[libros.length -1 ] = nuevoLibro;
  }

  private void ampliaArrray() {
 // Crea un array alternativo con un elemento mas
    Libro[] nuevo = new Libro[libros.length + 1];
    // Copia los elementos del array antiguo al nuevo
    for (int i = 0; i < libros.length; i++) {
      nuevo[i] = libros[i];
    }
    // Por último guarda el nuevo array en el atributo
    libros = nuevo;
  }

  private Libro solicitaLibro() {
    imprimirTitulo("agregar libro");
    System.out.println("Introduzca el titulo del libro: ");
   String titulo = scan.nextLine();
    System.out.println("Introduzca el nombre del autor del libro: ");
    String autor = scan.nextLine();
    System.out.println("Introduzca el año de publicación del libro: ");
    int anyo = Integer.parseInt(scan.nextLine());
     
    return new Libro(titulo, autor, anyo);
  }

  private void mostrarLibro() {
    //Muestras los libros en el array
    for (Libro libro : libros) {
      System.out.println(libro);
    }
  }

  private void buscarPorTitulo() {
    //Buscar por titulo. Le das un texto y busca si esta en el titulo.
    //Imprimir cabecera
    imprimirTitulo("buscar libro por titulo.");
    //Solicitar titulo
    System.out.print("Introduzca el texto que busca, no puede dejarse en blaco:");
    String textoABuscar = scan.nextLine();
    if (!textoABuscar.isEmpty()) {
      //Listar los libros con el titulo dado
      int encontrados = 0;
      for (Libro libro : libros) {
        if (libro.getTitulo().contains(textoABuscar)) {
        System.out.println(libro);
        encontrados ++;
      }
      }
      System.out.println("Se encontraron" + encontrados + "tantas coincidencias" );
      }else {
      System.out.print("No puede blanco." );
    }
  }
  private void buscarAnyo() {
    //Imprimir cabecera
    imprimirTitulo("buscar libro por año.");
    //Solicitar titulo
    System.out.print("Introduzca el año a buscar.");
    int anyo = scan.nextInt();
      //Listar los libros con el titulo dado
      int encontrados = 0;
      for (Libro libro : libros) {
        if (libro.getAnyoPublicacion() == anyo) {
        System.out.println(libro);
        encontrados ++;
      }
      System.out.println("Se encontraron" + encontrados + "tantas coincidencias" );
      }
  }

  private  int mostrarMenu() {
    // Primercabezal
    // Con un array generar un menu general, aunque se deberia pasar un salir
    // aparte.
    try {
      System.out.println("===============");
      System.out.println("GESTIÓN DE LIBROS");
      System.out.println("===============");
      System.out.println("(1) Agregar libro");
      System.out.println("(2) Mostrar todos los libros");
      System.out.println("(3) Buscar libro por título");
      System.out.println("(4) Buscar libro por año de publicación");
      System.out.println("(0) Salir de la aplicion");
      System.out.println("Introduzca una opcion (0-4): ");
      
    } catch (NumberFormatException e) {
      System.out.printf("Inserta un valor valido");
    }
    return Integer.parseInt(scan.nextLine());
  }
  private void imprimirTitulo(String titulo) {
    System.out.println();
    System.out.println(titulo.toUpperCase());
    for (int i = 0 ; i < titulo.length() ; i++) {
      System.out.printf("- ");
      i++;
    }
    System.out.println("");
  }
  }

