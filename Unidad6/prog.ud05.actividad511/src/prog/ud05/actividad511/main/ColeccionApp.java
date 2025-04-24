package prog.ud05.actividad511.main;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import prog.ud05.actividad511.coleccion.Cliente;
import prog.ud05.actividad511.coleccion.ProveedorUsuariosException;
import prog.ud05.actividad511.coleccion.TarjetaClaves;
import prog.ud05.actividad511.coleccion.Usuario;
import prog.ud05.actividad511.coleccion.Usuarios;
import prog.ud05.actividad511.proveedores.ProveedorUsuariosArchivoJSON;

/**
 * Programa principal
 */
public class ColeccionApp {
  // Constantes
  // Archivo JSON con los datos
  private static final String ARCHIVO = "biblioteca.json";
  // Opción salir del programa
  private static final int OPCION_SALIR = 0;
  // Opción Listar libros
  private static final int OPCION_LISTAR = 1;
  // Opción Buscar por titulo
  private static final int OPCION_BUSCAR_NOMBRE = 2;
  // Opcion Buscar por autor
  private static final int OPCION_BUSCAR_APELLIDOS = 3;
  // Opción Buscar por año de publicación
  private static final int OPCION_BUSCAR_DNI = 4;
  // Opción Buscar por año de publicación
  private static final int OPCION_BUSCAR_EDAD = 5;
  // Opciones minima y maxima (para comprobar los rangos)
  private static final int OPCION_MINIMA = OPCION_SALIR;
  private static final int OPCION_MAXIMA = OPCION_BUSCAR_EDAD;
  // Constantes agregadas por mi
  private static int MAYOR_VACIO = 0;

  // Atributos
  // Contenedor de usuarios
  private Usuarios usuarios;
  // Scanner para leer desde teclado
  private Scanner sc;
  // Usuario autenticado
  Usuario usuario;

  /**
   * Constructor del objeto<br>
   * Recibe un contenedor de usuarios y crea el scanner para acceder al teclado
   * 
   * @param usuarios Contenedor de usuarios
   */
  public ColeccionApp(Usuarios usuarios) {
    this.usuarios = usuarios;
    sc = new Scanner(System.in);
    usuario = null;
  }

  /**
   * Main. Punto de entrada de la aplicación
   * 
   * @param args Argumentos de la línea de comandos
   */
  public static void main(String[] args) {

    // Obtenemos los usuarios
    try {
      Usuarios usuarios = new ProveedorUsuariosArchivoJSON(ARCHIVO).obtieneUsuarios();
      // Creamos un objeto de la clase
      ColeccionApp app = new ColeccionApp(usuarios);
      // Y lanzamos el interfaz
      app.run();
    } catch (ProveedorUsuariosException e) {
      // Si no se puede obtener la información de usuarios y libros terminamos
      System.err.printf("Error procesando el fichero JSON. Causa original: %s%n", e.getCause().getMessage());
    }
  }

  /**
   * Método principal del interfaz
   */
  private void run() {
    // Lo primero es autenticar al usuario
    usuario = autenticarUsuario();
    // Si se pudo hacer
    if (usuario != null) {
      // Muestra el menú repetidamente hasta que se elija la opción Salir
      int opcionElegida = OPCION_SALIR;
      do {
        // Muestra el menú y obtiene una elección
        opcionElegida = mostrarMenu();
        // Según la opción elegida
        switch (opcionElegida) {
        case OPCION_LISTAR:
          comandoListarClientes();
          break;
        case OPCION_BUSCAR_NOMBRE:
          comandoBuscarNombre();
          break;
        case OPCION_BUSCAR_APELLIDOS:
          comandoBuscarApellidos();
          break;
        case OPCION_BUSCAR_DNI:
          comandoBuscarDni();
          break;
        case OPCION_BUSCAR_EDAD:
          comandoBuscarEdad();
          break;
        case OPCION_SALIR:
          break;
        default:
          // No se debe llegar aqui
          System.out.println("Error. Opción incorrecta.");
        }
      } while (opcionElegida != OPCION_SALIR);
    } else {
      // No se pudo autenticar al usuario. Termina
      System.out.println("Error de autenticación. Terminando programa");
    }
  }

  /**
   * Autentifica al usuario
   * 
   * @return Usuario si la autenticación tuvo éxito. null si no lo tuvo
   */
  private Usuario autenticarUsuario() {
    // Solicitamos el nombre del usuario
    System.out.println("Autenticación");
    System.out.print("Introduzca el nombre de usuario: ");
    String nombreUsuario = sc.nextLine();
    // Accede al usuario en el contenedor
    Usuario usuario = usuarios.getUsuarioPorNombreUsuario(nombreUsuario);
    // Si no es null
    if (usuario != null) {
      // Accedemos a la tarjeta
      TarjetaClaves tarjeta = usuario.getTarjeta();
      // Obtenemos el número de filas y columnas de la tarjeta
      int filas = tarjeta.getFilas();
      int columnas = tarjeta.getColumnas();

      // Obtenemos un valor aleatorio de fila y columna
      Random random = new Random();
      int fila = random.nextInt(1, filas + 1);
      int columna = random.nextInt(1, columnas - 1);

      // Lo mostramos al usuario
      System.out.printf("Introduzca la clave en las coordenadas (%d, %d): ", fila, columna);
      int clave = 1000;
      try {
        clave = Integer.parseInt(sc.nextLine());
      } catch (NumberFormatException e) {
        // Autenticación incorrecta. terminamos
        System.out.println("Autenticación incorrecta");
        return null;
      }
      // Si el usuario autentica correctamente
      if (tarjeta.validarClave(fila, columna, clave)) {
        // Mostramos un mensaje y devolvemos el usuario
        System.out.println("Autenticación correcta.");
        return usuario;
      } else {
        // Autenticación incorrecta
        System.out.println("Autenticación incorrecta");
        return null;
      }
    } else {
      // Usuario no encontrado
      System.out.println("Autenticación incorrecta");
      return null;
    }
  }

  /**
   * Muestra el menú y elige la opción
   * 
   * @return Opción elegida. Se comprueba que es correcta y está en rango
   */
  private int mostrarMenu() {
    // Inicializamos la opción elegida a un valor invalido
    int opcion = OPCION_MINIMA - 1;
    // Mientras no se elija una opción correcta
    for (;;) {
      // Mostramos el menu
      System.out.println();
      System.out.println("MENU PRINCIPAL");
      System.out.println("--------------");
      System.out.println("1. Listar clientes");
      System.out.println("2. Buscar clientes por nombre de pila");
      System.out.println("3. Buscar clientes por apellidos");
      System.out.println("4. Buscar clientes por DNI");
      System.out.println("5. Buscar clientes por edad");
      System.out.println("0. Salir del programa");
      System.out.printf("Elija una opción (%d-%d): ", OPCION_MINIMA, OPCION_MAXIMA);
      try {
        opcion = Integer.parseInt(sc.nextLine());
        // Si la opción está en rango se devuelve. Si no se muestra error y se da otra
        // vuelta
        if (opcion >= OPCION_MINIMA && opcion <= OPCION_MAXIMA) {
          return opcion;
        } else {
          System.out.printf("Opción elegida incorrecta. Debe introducir un número comprendido entre" + " %d y %d%n",
              OPCION_MINIMA, OPCION_MAXIMA);
        }
      } catch (NumberFormatException e) {
        System.out.printf("Opción elegida incorrecta. Debe introducir un número" + " comprendido entre %d y %d%n",
            OPCION_MINIMA, OPCION_MAXIMA);
      }
    }
  }

  /**
   * Lista los clientes del usuario
   */
  private void comandoListarClientes() {
    // Extraemos la lista de usuarios
    List<Cliente> clientes = usuario.getClientes();

    // Ordenar la lista de clientes por apellidos
    // Utilizando el compareTo de clientes
    Collections.sort(clientes);

    // Imprimir la lista ordenada
    for (Cliente cliente : clientes) {
      imprimirCliente(cliente);
    }
  }

  /**
   * Busca los clientes del usuario cuyo nombre de pila contiene un texto
   * determinado
   */
  private void comandoBuscarNombre() {
    // Este metodo busca nombres en el archivo JSON
    // Extraemos la lista de usuarios
    List<Cliente> clientes = usuario.getClientes();

    // Y la ordenamos
    Collections.sort(clientes);

    // Imprimimos la cabecera
    imprimirCabecera("buscar cliente por nombre de pila");
    System.out.print("¿Buscar por nombre completo o parte del nombre? (c=nombre completo, p=parte del nombre): ");
    char letra = sc.nextLine().charAt(0);

    // Hacemos un switch con las opciones
    switch (letra) {
    case 'c': {
      // Pedimos los datos
      System.out.print("Introcuzca el texto a buscar en el nombre del cliente: ");
      String nombrePedido = sc.nextLine();
      if (validaCadena(nombrePedido)) {// Verificamos que el valor sea valido
        System.out.println("El valor introducido es erroneo");
      }
      // Creo un boolean para controlar que si no los encuentra imprima un mensaje de
      // que no los encontro
      boolean encontrado = false;
      for (Cliente cliente : clientes) {
        if (nombrePedido.equals(cliente.getNombre())) {
          // Imprimimos a los clientes
          System.out.println("Los clientes del usuario que contienen " + nombrePedido + " en el nombre de pila son: ");
          imprimirCliente(cliente);
          encontrado = true;
        }
      }
      if (!encontrado) { // Si no lo encuentra lanza excepcion
        System.out.println("No se encontro cliente");
      }
      break;
    }
    case 'p': {
      // Pedimos los datos
      System.out.print("Introduzca el texto a buscar en el nombre del cliente: ");
      String nombrePedido = sc.nextLine();
      if (validaCadena(nombrePedido)) { // Verificamos que el valor sea valido
        System.out.println("El valor introducido es erroneo");
      }
      // Creo un boolean para controlar que si no los encuentra imprima un mensaje de
      // que no los encontro
      boolean encontrado = false;
      for (Cliente cliente : clientes) {
        if (cliente.getNombre().contains(nombrePedido)) {
          // Imprimimos los clientes encontrados
          System.out.println("Los clientes del usuario que contienen " + nombrePedido);
          imprimirCliente(cliente);
          encontrado = true;
        }
      }
      if (!encontrado) { // Si no lo encuentra lanza excepcion
        System.out.println("No se encontro cliente");
      }
      break;
    }
    default: // Si el caracter introducido es invalido devuelve
      System.out.println("La opción elegida no es válida. Debe ser c o p.");
    }
  }

  /**
   * Busca los clientes del usuario cuyos apellidos contienen un texto determinado
   */
  private void comandoBuscarApellidos() {
    // Extraemos la lista de usuarios
    List<Cliente> clientes = usuario.getClientes();
    // Y la ordenamos
    Collections.sort(clientes);
    // Uso el metodo para imprimir la cabecera
    imprimirCabecera("buscar cliente por apellidos");

    // Pedimos los datos
    System.out.println("¿Buscar por apellidos o parte del apellido? (c=apellidos completos, p=parte de los apellidos)");
    char letra = sc.nextLine().charAt(0);

    // Genero un switch para manejar cada opcion
    switch (letra) {
    case 'c': {
      // Pido los datos
      System.out.println("Introcuzca el texto a buscar en los apellidos de los clientes del usuario: ");
      String apellidoPedido = sc.nextLine();
      if (validaCadena(apellidoPedido)) {// Verificamos que el valor sea valido
        System.out.println("El texto introducido no puede estar en blanco o solo tener espacios");
      }
      // Creo un boolean para controlar que si no los encuentra imprima un mensaje de
      // que no los encontro
      boolean encontrado = false;
      for (Cliente cliente : clientes) {

        // Comparamos apellidos
        if (apellidoPedido.equals(cliente.getApellidos())) {
          // Si se encuentra se imprime cliente
          System.out.println("Los clientes del usuario que contienen " + apellidoPedido);
          imprimirCliente(cliente);
          encontrado = true;
        }
      }
      if (!encontrado) { // Si no se encuentra

        System.out.println("Ningun usuario coincide con el texto introducido");
      }
      break;
    }

    case 'p': {
      // Pedimos los datos
      System.out.print("Introcuzca el texto a buscar en los apellidos de los clientes del usuario: ");
      String apellidoPedido = sc.nextLine();
      if (validaCadena(apellidoPedido)) {// Verificamos que el valor sea valido
        System.out.println("El texto introducido no puede estar en blanco o solo tener espacios");
      }
      // Creo un boolean para controlar que si no los encuentra imprima un mensaje de
      // que no los encontro
      boolean encontrado = false;
      for (Cliente cliente : clientes) {
        // Valido si la cadena otorgada tiene algo en comun con el apellido de algun
        // cliente
        if (cliente.getApellidos().contains(apellidoPedido)) {
          // Imprimo al cliente o los clientes si es asi
          System.out.println("Los clientes del usuario que contienen " + apellidoPedido);
          imprimirCliente(cliente);
          encontrado = true;
        }
      }
      if (!encontrado) { // Si no se encuentra

        System.out.println("Ningun usuario coincide con el texto introducido");
      }
      break;
    }
    default: // Si el caracter introducido es invalido devuelve

      System.out.println("La opción elegida no es válida. Debe ser una de c, p");
    }
  }

  /**
   * Busca los clientes del usuario cuyos DNI es el proporcionado
   */
  private void comandoBuscarDni() {
    // Extraemos la lista de usuarios
    List<Cliente> clientes = usuario.getClientes();
    // Y la ordenamos
    Collections.sort(clientes);
    // Imprimimos cabecera
    imprimirCabecera("Buscar por DNI");
    // Pido el dni a buscar
    System.out.println("Introduzca el dni a buscar (Introducir completo):");
    String buscado = sc.nextLine();
    // Creo un boolean para controlar que si no lo encuentra imprima un mensaje de
    // que no lo encontro
    boolean encontrado = false;
    for (Cliente cliente : clientes) {
      if (buscado.equals(cliente.getDni())) { // Compara el dni valido con los dni clientes
        if (!encontrado) { // Si lo encontro imprime cliente
          System.out.println("El cliente con el dni " + "" + cliente.getDni());
          imprimirCliente(cliente);
          encontrado = true;
        }
      }
    }
    if (!encontrado) { // Si no lo encuentra imprime el siguiente mensaje
      System.out.println("No existe un cliente con el DNI proporcionado.");
    }
  }

  /**
   * Busca los clientes del usuario por su edad
   */
  private void comandoBuscarEdad() {
    // Si el usuario ingresa letras en vez de numero, termina el metodo y especifica
    // su error
    try {
      // Extraemos la lista de usuarios
      List<Cliente> clientes = usuario.getClientes();
      // Y la ordenamos
      Collections.sort(clientes);
      // Imprimimos cabecera
      imprimirCabecera("Buscar por año");
      System.out.println("¿Buscar clientes cuya edad será mayor o igual a? (vacío para cualquiera):");
      String numero1 = sc.nextLine(); // Es nextLine para permitir una entrada vacia
      System.out.println("¿Buscar clientes cuya edad será menor o igual a? (vacío para cualquiera):");
      String numero2 = sc.nextLine(); // Es nextLine para permitir una entrada vacia
      // Constantes
      // Considero que edad no puede ser menor que cero

      // Los dos ternarios analizan si la entrada es vacia, si es, toman las
      // constantes
      // Si no es vacia, transforma la cadena a un numero entero
      int mayor = numero1.isEmpty() ? MAYOR_VACIO : Integer.parseInt(numero1);

      if (numero2.isEmpty()) {
        System.out.println("Los clientes encontrados son:");
        for (Cliente cliente : clientes) {
          imprimirCliente(cliente); // Imprimir cada cliente que cumple con las condiciones
        }
      } else if (!numero2.isEmpty()) {
        int menor = Integer.parseInt(numero2);
        boolean encontrado = false; // Variable para controlar si se encontró algún cliente

        for (Cliente cliente : clientes) {

          if (cliente.getEdad() >= mayor && cliente.getEdad() <= menor) {

            if (!encontrado) {

              System.out.println("Los clientes encontrados son:");
              encontrado = true; // Se encontró al menos un cliente
              // Imprimir cada cliente que cumple con las condiciones
              imprimirCliente(cliente);
            }
          }
        }
        // Si no se encuentran ninguno se imprime los siguientes
        if (!encontrado) {
          System.out.println("No se encontraron clientes que cumplan con las condiciones.");
        }
      }
    } catch (NumberFormatException e) {
      System.out.println("Debes introducir numeros enteros.");
    }
  }

  // Metodos privados a agregados por mi
  /**
   * Sirve para imprimir una cadena en mayuscula
   * 
   * @param msg
   */
  private void imprimirCabecera(String cadena) {
    System.out.println();
    System.out.println(cadena.toUpperCase());
    for (int i = 0; i < cadena.length(); i++) {
      System.out.print("-");
    }
    System.out.println();
  }

  /**
   * Sirve para imprimir un cliente
   * 
   * @param cliente
   */
  private void imprimirCliente(Cliente cliente) {
    System.out.println(cliente.getApellidos() + ", " + cliente.getNombre() + "." + " DNI: " + cliente.getDni() + "."
        + " Edad: " + cliente.getEdad() + ".");
  }

  /**
   * Comprueba si la cadena esta vacia o es blanca
   * 
   * @param nombre
   * @return
   */
  private boolean validaCadena(String cadena) {
    if (cadena.isEmpty() || cadena.isBlank()) {
      return true;
    }
    return false;
  }

}
