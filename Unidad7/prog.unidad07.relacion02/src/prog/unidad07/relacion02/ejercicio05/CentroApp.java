package prog.unidad07.relacion02.ejercicio05;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Aplicacion de gestión de personal de centro
 */
public class CentroApp {
  
  // Constantes
  // Opciones
  private static final int OPCION_INVALIDA = -1;
  private static final int OPCION_SALIR = 0;
  private static final int OPCION_ALTA = 1;
  private static final int OPCION_BAJA = 2;
  private static final int OPCION_LISTADO = 3;
  private static final int OPCION_NOMINA = 4;
  
  // Atributos
  // Centro
  Centro centro;
  // Scanner para leer desde teclado
  Scanner sc;
  // Interfaces de altas para los distintos tipos de persona
  Map<String, InterfazAltaPersona> interfacesAlta;

  /**
   * Constructor
   * @param centro Centro a emplear
   */
  public CentroApp(Centro centro, Scanner sc) {
    this.centro = centro;
    this.sc = sc;
    interfacesAlta = new HashMap<>();
  }
  
  public static void main(String[] args) {
    // Creamos el scanner de acceso al teclado
    Scanner sc = new Scanner(System.in);

    // Creamos la aplicación con el centro y el scanner
    CentroApp app = new CentroApp(new Centro(), sc);
    // Registramos los interfaces de alta de personas
    app.registraInterfazAltaPersona("est", new InterfazAltaEstudiante("Estudiante", sc));
    app.registraInterfazAltaPersona("pro", new InterfazAltaProfesor("Profesor", sc));
    app.registraInterfazAltaPersona("pas", new InterfazAltaAdministracionServicios("Personal de Administración y Servicios", sc));
    app.run();
  }
  
  /**
   * Registra un nuevo interfaz de alta de persona
   * @param clave cla
   * @param interfaz
   */
  private void registraInterfazAltaPersona(String clave, InterfazAltaPersona interfaz) {
    interfacesAlta.put(clave, interfaz);
  }

  // Método de inicio del interfaz
  private void run() {
    // Hasta que se elija salir
    int opcion = OPCION_SALIR;
    do {
      // Muestra el menu y obtiene la opción elegida
      opcion = muestraMenu();
      // Según la opcíón
      switch (opcion) {
        case OPCION_ALTA:
          operacionAlta();
          break;
        case OPCION_BAJA:
          operacionBaja();
          break;
        case OPCION_LISTADO:
          operacionListado();
          break;
        case OPCION_NOMINA:
          operacionNomina();
          break;
        case OPCION_SALIR:
          // No hace nada
          break;
        default:
          // Opción incorrecta
          System.out.println("Opcion elegida no válida");
          break;
      }
    } while (opcion != OPCION_SALIR);
    System.out.println("Programa terminado");
  }

  private void operacionNomina() {
    // Linea para separar
    System.out.println();
    
    // Imprime la nomina
    centro.imprimirNomina();
  }

  private void operacionListado() {
    // Linea para separar
    System.out.println();
    
    // Imprime la nomina
    centro.imprimir();
  }

  private void operacionBaja() {
    // Muestra el encabezado
    System.out.println();
    System.out.println("BAJA DE PERSONA");
    System.out.println("---------------");
    
    // Solicita el DNI de la persona a eliminar
    System.out.print("Introduzca el DNI de la persona a dar de baja: ");
    String dni = sc.nextLine();
    // Realiza la baja
    centro.baja(dni);
    // Mensaje de confirmación
    System.out.println("Baja realizada con éxito");
  }

  /**
   * Muestra el menú de opciones y obtiene la opción introducida
   * @return Opción elegida
   */
  private int muestraMenu() {
    // Muestra el menu
    System.out.println();
    System.out.println("GESTIÓN DE PERSONAS DEL CENTRO");
    System.out.println("------------------------------");
    System.out.println("1.- Alta de persona");
    System.out.println("2.- Baja de persona");
    System.out.println("3.- Listado de personas");
    System.out.println("4.- Nomina");
    System.out.println("0.- Salir");
    System.out.print("Introduzca la opción: ");
    try {
      // Intenta leer 
      return Integer.parseInt(sc.nextLine());
    } catch (NumberFormatException e) {
      // Devuelve una opción no válida
      return OPCION_INVALIDA;
    }
  }

  /**
   * Operación alta de persona
   */
  private void operacionAlta() {
    // Muestra el menú de seleccion de tipos de persona
    System.out.println();
    System.out.println("ALTA DE PERSONA");
    System.out.println("---------------");
    System.out.println("¿Qué tipo de persona desea dar de alta?");
    for (String clave: interfacesAlta.keySet()) {
      System.out.printf("Para dar de alta un \"%s\" introduzca \"%s\"%n", interfacesAlta.get(clave).getDescripcion(), clave);
    }
    // Solicitamos el tipo
    System.out.print("Introduzca su seleccion: ");
    String tipo = sc.nextLine();
    
    // Obtenemos el interfaz para el tipo introducido
    InterfazAltaPersona interfaz = interfacesAlta.get(tipo);
    
    // Si hay interfaz registrado para el tipo
    if (interfaz != null) {
      // Obtenemos la persona desde el interfaz y la añadimos al centro
      centro.alta(interfaz.solicitaDatosPersona());
    }
    
    // Mensaje de confirmación
    System.out.println("Alta realizada con éxito");
  }

}
