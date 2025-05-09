package prog.unidad09.relacion02.app;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import prog.unidad09.relacion02.datos.Centro;
import prog.unidad09.relacion02.datos.Departamento;
import prog.unidad09.relacion02.datos.Empleado;
import prog.unidad09.relacion02.proveedor.ProveedorAlmacenamientoEmpresa;
import prog.unidad09.relacion02.proveedor.ProveedorAlmacenamientoEmpresaException;
import prog.unidad09.relacion02.proveedor.impl.ProveedorAlmacenamientoEmpresaDb4o;

public class GestionDepartamentoApp {
  
  // Constantes
  // Ruta a la base de datos
  private static final String RUTA_DB = "db/empresa.db4o";

  // Opciones del menu
  private static final int OPT_SALIR = 0;
  private static final int OPT_LISTAR_DEPARTAMENTOS = 1;
  private static final int OPT_CONSULTAR_DEPARTAMENTO = 2;
  private static final int OPT_NUEVO_DEPARTAMENTO = 3;
  private static final int OPT_MODIFICAR_DEPARTAMENTO = 4;
  private static final int OPT_ELIMINAR_DEPARTAMENTO = 5;

  // Atributos
  // Proveedor de almacenamiento para persistir los datos
  private ProveedorAlmacenamientoEmpresa proveedorAlmacenamiento;
  // Scanner para leer desde teclado
  private Scanner scanner;
  
  /**
   * Constructor
   * @param servicioAlmacenamiento Servicio de almacenamiento a emplear
   * @param scanner Scanner a emplear para leer desde teclado
   */
  public GestionDepartamentoApp(ProveedorAlmacenamientoEmpresa servicioAlmacenamiento, Scanner scanner) {
    this.proveedorAlmacenamiento = servicioAlmacenamiento;
    this.scanner = scanner;
  }

  /**
   * Punto de entrada de la aplicación 
   * @param args Argumentos (no se usan)
   */
  public static void main(String[] args) {
    // Crea un nuevo objeto de la clase y le proporciona el provedor de almacenamiento y el Scanner
    GestionDepartamentoApp app = new GestionDepartamentoApp(new ProveedorAlmacenamientoEmpresaDb4o(RUTA_DB), new Scanner(System.in));
    // Lanza la instancia
    app.run();
  }
  
  /**
   * Punto de entrada de la instancia
   */
  private void run() {
    // Opción leida desde el usuario
    int opcion;
    do {
      // Muestra el menu y solicita la opción al usuario
      opcion = muestraMenu();
      // Dependiendo de la opción
      switch (opcion) {
        case OPT_LISTAR_DEPARTAMENTOS:
          listarDepartamentos();
          break;
        case OPT_CONSULTAR_DEPARTAMENTO:
          consultarDepartamento();
          break;
        case OPT_NUEVO_DEPARTAMENTO:
          nuevoDepartamento();
          break;
        case OPT_MODIFICAR_DEPARTAMENTO:
          modificarDepartamento();
          break;
        case OPT_ELIMINAR_DEPARTAMENTO:
          eliminarDepartamento();
          break;
        case OPT_SALIR:
          break;
        default:
          System.err.println("Opción elegida incorrecta. Inténtelo de nuevo");
          break;
      }
    } while (opcion != OPT_SALIR);
    // Cerramos el proveedor de almacenamiento para liberar recursos
    proveedorAlmacenamiento.cerrar();
  }

  private int muestraMenu() {
    // Muestra el menu
    System.out.println();
    System.out.println("GESTION DE DEPARTAMENTOS");
    System.out.println("------------------------");
    System.out.println("1.- Listar departamentos");
    System.out.println("2.- Consultar departamento");
    System.out.println("3.- Añadir departamento");
    System.out.println("4.- Modificar departamento");
    System.out.println("5.- Eliminar departamento");
    System.out.println("0.- Salir de la aplicación");
    // Iniciamos la opcion a un valor incorrecto
    int opcion = -1;
    do {
      // Solicitamos la opción. Capturamos la excepción para el caso de que se introduzca algo que no sea un entero
      System.out.print("Elija su opción (0-5): ");
      try {
        opcion = Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {
        // Si se introduce algo que no es entero asignamos un valor no vaĺido para volver a solicitarlo
        opcion = -1;
      }
      // Si la opción no es válida
      if (opcion < 0 || opcion > 5) {
        // Error
        System.err.println("Opción incorrecta. Inténtelo de nuevo");
      }
    } while (opcion < 0 || opcion > 5);
    // Se devuelve la opción seleccionada
    return opcion;
  }

  private void listarDepartamentos() {
    
    // Cabecera
    System.out.println();
    System.out.println("LISTADO DE DEPARTAMENTOS");
    System.out.println("------------------------");
    
    try {
      // Solicitamos la lista de departamentos al servicio (ordenada)
      List<Departamento> departamentos = proveedorAlmacenamiento.getAllDepartamento(true);
      
      System.out.printf("Hay %d departamentos: %n", departamentos.size());
      System.out.println("COD\tNOMBRE");
      
      for (Departamento departamento: departamentos) {
        System.out.printf("%d\t%s%n", departamento.getNumero(), departamento.getNombre());
      }
    } catch (ProveedorAlmacenamientoEmpresaException e) {
      System.err.println("Error accediendo al listado de departamentos");
    }
    
  }

  private void consultarDepartamento() {
    // Cabecera
    System.out.println();
    System.out.println("CONSULTA DE DEPARTAMENTO");
    System.out.println("------------------------");
    
    try {
      // Solicita el codigo del departamento al usuario
      System.out.print("Introduzca el código del departamento a consultar: ");
      int codigo = Integer.parseInt(scanner.nextLine());
      
      // Solicitamos el departamento al servicio
      Departamento departamento = proveedorAlmacenamiento.getDepartamentoByCodigo(codigo);
      
      // Si se encontro
      if (departamento != null) {
        imprimeDepartamento(departamento);
      } else {
        // Departamento no encontrado
        System.err.printf("Departamento con código %d no encontrado%n", codigo);
      }
      
    } catch (ProveedorAlmacenamientoEmpresaException e) {
      System.err.println("Error accediendo al servicio de almacenamiento");
    }
  }

  private void nuevoDepartamento() {
    // Cabecera
    System.out.println();
    System.out.println("NUEVO DEPARTAMENTO");
    System.out.println("------------------");
    
    // Solicita la información del nuevo departamento (excepto el código)
    System.out.print("Introduzca el nombre del departamento: ");
    String nombre = scanner.nextLine();
    System.out.print("Introduzca el codigo del centro en el que está ubicado el departamento: ");
    int codigoCentro = Integer.parseInt(scanner.nextLine());
    // Obtenemos el centro a partir del código
    Centro centro = proveedorAlmacenamiento.getCentroByCodigo(codigoCentro);
    System.out.print("Introduzca la dirección del departamento: ");
    String direccion = scanner.nextLine();
    System.out.print("Introduzca el codigo del empleado que es director del departamento: ");
    int codigoDirector = Integer.parseInt(scanner.nextLine());
    // Obtenemos el empleado director a partir del código
    Empleado director = proveedorAlmacenamiento.getEmpleadoByCodigo(codigoDirector);
    System.out.print("Introduzca el presupuesto del departamento: ");
    double presupuesto = Double.parseDouble(scanner.nextLine());
    System.out.print("Si el departamento depende de otro, introduzca el código de ese departamento. Si no deje este campo en blanco: ");
    String codigoDepartamentoSuperior = scanner.nextLine();
    // En principio no hay departamento superior (suponemos que no se ha especificado)
    Departamento departamentoSuperior = null;
    // Si se ha especificado...
    if (!codigoDepartamentoSuperior.isEmpty()) {
      // Accedemos al departamento
      departamentoSuperior = proveedorAlmacenamiento.getDepartamentoByCodigo(Integer.parseInt(codigoDepartamentoSuperior));
    }
    
    // Creamos el objeto departamento
    Departamento departamento = new Departamento(0, nombre, direccion, presupuesto, 
      centro, director, departamentoSuperior);
    // Y lo insertamos
    try {
      proveedorAlmacenamiento.addDepartamento(departamento);
    } catch (ProveedorAlmacenamientoEmpresaException e) {
      System.err.println("Ocurrió un error almacenando el departamento");
    }
  }

  private void modificarDepartamento() {
    // Cabecera
    System.out.println();
    System.out.println("MODIFICAR DEPARTAMENTO");
    System.out.println("----------------------");
    
    // Solicita el código del departamento para recuperarlo
    System.out.print("Introduzca el código del departamento a modificar: ");
    int codigo = Integer.parseInt(scanner.nextLine());
    // Recupera el departamento
    Departamento departamento = proveedorAlmacenamiento.getDepartamentoByCodigo(codigo);
    // Si se encontro
    if (departamento != null) {
      // Lo imprime
      System.out.printf("Valores actuales del departamento con codigo: %d%n", codigo);
      imprimeDepartamento(departamento);

      // Solicita la información del nuevo departamento (excepto el código)
      System.out.printf("Introduzca el nuevo nombre del departamento (vacio para mantener el actual \"%s\"): ", departamento.getNombre());
      String valor = scanner.nextLine();
      // Actualizamos con el nuevo valor o el existente dependiendo de si se ha introducido un blanco o no
      departamento.setNombre(actualONuevo(valor, departamento.getNombre()));
      System.out.printf("Introduzca el codigo del nuevo centro al que pertenecerá el departamento [vacio para mantener el actual (%d) \"%s\"]: ", departamento.getCentro().getNumero(), departamento.getCentro().getNombre());
      valor = scanner.nextLine();
      // Obtenemos el centro a partir del código. Puede ser un nuevo centro o el existente
      int codigoCentro = actualONuevo(valor, departamento.getCentro().getNumero());
      departamento.setCentro(proveedorAlmacenamiento.getCentroByCodigo(codigoCentro));
      System.out.printf("Introduzca la nueva dirección del departamento (vacio para mantener la actual \"%s\"): ", departamento.getDireccion());
      valor = scanner.nextLine();
      departamento.setDireccion(actualONuevo(valor, departamento.getDireccion()));
      System.out.printf("Introduzca el codigo del nuevo director del departamento [vacio para mantener el actual (%d) \"%s\"]: ", departamento.getDirector().getNumero(), departamento.getDirector().getNombre());
      valor = scanner.nextLine();
      int codigoDirectorCentro = actualONuevo(valor, departamento.getDirector().getNumero());
      // Accede al director
      departamento.setDirector(proveedorAlmacenamiento.getEmpleadoByCodigo(codigoDirectorCentro));
      System.out.printf("Introduzca el nuevo presupuesto del departamento (vacio para mantener el actual (%f): ", departamento.getPresupuesto());
      valor = scanner.nextLine();
      departamento.setPresupuesto(actualONuevo(valor, departamento.getPresupuesto()));
      System.out.printf("Si el departamento depende de otro, introduzca el código de ese departamento. Si no deje este campo en blanco [el valor actual es (%d) \"%s\"]: ", departamento.getDependeDe().getNumero(), departamento.getDependeDe().getNombre());
      valor = scanner.nextLine();
      Integer codigoDepartamentoSuperior = valor.isEmpty() ? null : Integer.parseInt(valor);
      // Si no es null
      if (codigoDepartamentoSuperior != null) {
        // Accedemos al departamento superior
        departamento.setDependeDe(proveedorAlmacenamiento.getDepartamentoByCodigo(codigoDepartamentoSuperior));
      }
      // Almacenamos los cambios
      try {
        proveedorAlmacenamiento.updateDepartamento(departamento);
      } catch (ProveedorAlmacenamientoEmpresaException e) {
        // Error
        System.err.println("No se pudieron almacenar los cambios.");
      }
    } else {
      System.err.println("No existe departamento con ese código. Abortando operacion");
    }
  }

  private void eliminarDepartamento() {
    // Cabecera
    System.out.println();
    System.out.println("ELIMINAR DEPARTAMENTO");
    System.out.println("---------------------");
    
    // Solicita el código del departamento para eliminar
    System.out.print("Introduzca el código del departamento a eliminar: ");
    int codigo = Integer.parseInt(scanner.nextLine());
    // Recupera el departamento
    Departamento departamento = proveedorAlmacenamiento.getDepartamentoByCodigo(codigo);
    // Si se encontro
    if (departamento != null) {
      // Lo imprime
      System.out.printf("Valores actuales del departamento con codigo: %d%n", codigo);
      imprimeDepartamento(departamento);

      // Solicita confirmación
      System.out.print("¿Está seguro de que desea eliminarlo (s/n)?: ");
      char respuesta = scanner.nextLine().toLowerCase().charAt(0);
      // Si es s (si)
      if (respuesta == 's') {
        try {
          proveedorAlmacenamiento.deleteDepartamentoByCodigo(codigo);
        } catch (ProveedorAlmacenamientoEmpresaException e) {
          // Error
          System.err.println("No se pudo eliminar el departamento.");
        }
      }
    } else {
      System.err.println("No existe departamento con ese código. Abortando operacion");
    }
  }

  private void imprimeDepartamento(Departamento departamento) {
    // Busca el centro en el que se ubica
    Centro centro = departamento.getCentro();
    // Los datos del empleado
    Empleado empleado = departamento.getDirector();
    // Calculamos el nombre del departamento del que depende este departamento (si es null será Ninguno)
    String nombreSuperior = "Ninguno";
    Departamento superior = departamento.getDependeDe();
    if (superior != null) {
      nombreSuperior = superior.getNombre();
    }
    // Imprime los datos
    System.out.println("Datos del departamento");
    System.out.printf("Código: %d%n", departamento.getNumero());
    System.out.printf("Nombre: %s%n", departamento.getNombre());
    System.out.printf("Centro en el que se ubica: %s%n", centro.getNombre());
    System.out.printf("Direccion: %s%n", departamento.getDireccion());
    System.out.printf("Director: %s%n", empleado.getNombre());
    System.out.printf(Locale.US, "Presupuesto: %f%n", departamento.getPresupuesto());
    System.out.printf("Nombre de departamento al que pertenece: %s%n", nombreSuperior);
  }

  /**
   * Determina que valor emplear: el existente o el proporcionado por el usuario. Se toma el
   * proporcionado por el usuario si no está vacío o el existente si lo está
   * @param nuevo Valor proporcionado por el usuario
   * @param actual Valor actual del campo
   * @return valor nuevo si no es vacío. Valor actual en caso contrario
   */
  private String actualONuevo(String nuevo, String actual) {
    return nuevo.isEmpty() ? actual : nuevo;
  }

  /**
   * Determina que valor emplear: el existente o el proporcionado por el usuario. Se toma el
   * proporcionado por el usuario si no está vacío o el existente si lo está
   * @param nuevo Valor proporcionado por el usuario
   * @param actual Valor actual del campo
   * @return valor nuevo si no es vacío. Valor actual en caso contrario
   */
  private int actualONuevo(String nuevo, int actual) {
    return nuevo.isEmpty() ? actual : Integer.parseInt(nuevo);
  }

  /**
   * Determina que valor emplear: el existente o el proporcionado por el usuario. Se toma el
   * proporcionado por el usuario si no está vacío o el existente si lo está
   * @param nuevo Valor proporcionado por el usuario
   * @param actual Valor actual del campo
   * @return valor nuevo si no es vacío. Valor actual en caso contrario
   */
  private double actualONuevo(String nuevo, double actual) {
    return nuevo.isEmpty() ? actual : Double.parseDouble(nuevo);
  }
}
