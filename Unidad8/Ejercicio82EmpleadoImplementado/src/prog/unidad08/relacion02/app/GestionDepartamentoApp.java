package prog.unidad08.relacion02.app;

import java.util.List;
import java.util.Scanner;
import prog.unidad08.relacion02.entidades.Centro;
import prog.unidad08.relacion02.entidades.Departamento;
import prog.unidad08.relacion02.entidades.Empleado;
import prog.unidad08.relacion02.proveedor.ProveedorAlmacenamientoEmpresa;
import prog.unidad08.relacion02.proveedor.ProveedorAlmacenamientoEmpresaException;
import prog.unidad08.relacion02.proveedor.impl.ProveedorAlmacenamientoEmpresaSQLite;

public class GestionDepartamentoApp {

  private static final String RUTA_DB = ":db/empresa_orig.db";

  private static final int OPT_SALIR = 0;
  private static final int OPT_LISTAR_DEPARTAMENTOS = 1;
  private static final int OPT_CONSULTAR_DEPARTAMENTO = 2;
  private static final int OPT_NUEVO_DEPARTAMENTO = 3;
  private static final int OPT_MODIFICAR_DEPARTAMENTO = 4;
  private static final int OPT_ELIMINAR_DEPARTAMENTO = 5;
  private static final int OPT_CONSULTAR_EMPLEADO = 6;
  private static final int OPT_NUEVO_EMPLEADO = 7;
  private static final int OPT_MODIFICAR_EMPLEADO = 8;
  private static final int OPT_ELIMINAR_EMPLEADO = 9;
  private static final int OPT_LISTAR_EMPLEADO = 10;
  
  private ProveedorAlmacenamientoEmpresa proveedorAlmacenamiento;
  private Scanner scanner;

  public GestionDepartamentoApp(ProveedorAlmacenamientoEmpresa servicioAlmacenamiento, Scanner scanner) {
    this.proveedorAlmacenamiento = servicioAlmacenamiento;
    this.scanner = scanner;
  }

  public static void main(String[] args) {
    GestionDepartamentoApp app = new GestionDepartamentoApp(new ProveedorAlmacenamientoEmpresaSQLite(RUTA_DB),
        new Scanner(System.in));
    app.run();
  }

  private void run() {
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
      case OPT_CONSULTAR_EMPLEADO:
        consultarEmpleado();
        break;
      default:
        System.err.println("Opción elegida incorrecta. Inténtelo de nuevo");
        break;
      }
    } while (opcion != OPT_SALIR);
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
    System.out.println("6.- Consultar empleado");
    System.out.println("0.- Salir de la aplicación");
    // Iniciamos la opcion a un valor incorrecto
    int opcion = -1;
    do {
      // Solicitamos la opción. Capturamos la excepción para el caso de que se
      // introduzca algo que no sea un entero
      System.out.print("Elija su opción (0-6): ");
      try {
        opcion = Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {
        // Si se introduce algo que no es entero asignamos un valor no vaĺido para
        // volver a solicitarlo
        opcion = -1;
      }
      // Si la opción no es válida
      if (opcion < 0 || opcion > 6) {
        // Error
        System.err.println("Opción incorrecta. Inténtelo de nuevo");
      }
    } while (opcion < 0 || opcion > 6);
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
      List<Departamento> departamentos = proveedorAlmacenamiento.getDepartamentoAll(true);

      System.out.println("Hay " + departamentos.size() + " departamentos: ");
      System.out.println("COD\tNOMBRE");

      for (Departamento departamento : departamentos) {
        System.out.println(departamento.getCodigo() + "\t" + departamento.getNombre());
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
        System.err.println("Departamento con código " + codigo + " no encontrado");
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
    System.out.print("Introduzca la dirección del departamento: ");
    String direccion = scanner.nextLine();
    System.out.print("Introduzca el codigo del empleado que es director del departamento: ");
    int codigoDirector = Integer.parseInt(scanner.nextLine());
    System.out.print("Introduzca el presupuesto del departamento: ");
    double presupuesto = Double.parseDouble(scanner.nextLine());
    System.out.print(
        "Si el departamento depende de otro, introduzca el código de ese departamento. Si no deje este campo en blanco: ");
    String departamentoSuperior = scanner.nextLine();
    Integer codigoDepartamentoSuperior = null;
    if (!departamentoSuperior.isEmpty()) {
      codigoDepartamentoSuperior = Integer.parseInt(departamentoSuperior);
    }

    // Creamos el objeto departamento
    Departamento departamento = new Departamento(0, nombre, codigoCentro, direccion, codigoDirector, presupuesto,
        codigoDepartamentoSuperior);
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
      System.out.println("Valores actuales del departamento con codigo: " + codigo);
      imprimeDepartamento(departamento);

      // Solicita la información del nuevo departamento (excepto el código)
      System.out.print("Introduzca el nuevo nombre del departamento (vacio para mantener el actual \""
          + departamento.getNombre() + "\"): ");
      String valor = scanner.nextLine();
      String nombreDepartamento = actualONuevo(valor, departamento.getNombre());
      System.out.print(
          "Introduzca el codigo del nuevo centro al que pertenecerá el departamento (vacio para mantener el actual \""
              + departamento.getCodigoCentro() + "\"): ");
      valor = scanner.nextLine();
      int codigoCentro = actualONuevo(valor, departamento.getCodigoCentro());
      System.out.print("Introduzca la nueva dirección del departamento (vacio para mantener la actual \""
          + departamento.getDireccion() + "\"): ");
      valor = scanner.nextLine();
      String direccionCentro = actualONuevo(valor, departamento.getDireccion());
      System.out.print("Introduzca el codigo del nuevo director del departamento (vacio para mantener el actual \""
          + departamento.getCodigoDirector() + "\"): ");
      valor = scanner.nextLine();
      int codigoDirectorCentro = actualONuevo(valor, departamento.getCodigoDirector());
      System.out.print("Introduzca el nuevo presupuesto del departamento (vacio para mantener el actual \""
          + departamento.getPresupuesto() + "\"): ");
      valor = scanner.nextLine();
      double presupuestoCentro = actualONuevo(valor, departamento.getPresupuesto());
      System.out.print(
          "Si el departamento depende de otro, introduzca el código de ese departamento. Si no deje este campo en blanco (el valor actual es \""
              + departamento.getCodigoDepartamentoSuperior() + "\"): ");
      valor = scanner.nextLine();
      Integer codigoDepartamentoSuperior = valor.isEmpty() ? null : Integer.parseInt(valor);
      // Almacenamos los cambios
      try {
        proveedorAlmacenamiento.updateDepartamento(new Departamento(departamento.getCodigo(), nombreDepartamento,
            codigoCentro, direccionCentro, codigoDirectorCentro, presupuestoCentro, codigoDepartamentoSuperior));
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
      System.out.println("Valores actuales del departamento con codigo: " + codigo);
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
  private void consultarEmpleado() {
    System.out.println();
    System.out.println("CONSULTA DE EMPLEADO");
    System.out.println("--------------------");

    try {
      System.out.print("Introduzca el código del empleado a consultar: ");
      int codigo = Integer.parseInt(scanner.nextLine());

      Empleado empleado = proveedorAlmacenamiento.getEmpleadoByCodigo(codigo);

      if (empleado != null) {
        imprimeEmpleado(empleado);
      } else {
        System.err.println("Empleado con código " + codigo + " no encontrado");
      }
    } catch (ProveedorAlmacenamientoEmpresaException e) {
      System.err.println("Error accediendo al servicio de almacenamiento");
    } catch (NumberFormatException e) {
      System.err.println("El código debe ser un número");
    }
  }


  private void imprimeEmpleado(Empleado empleado) {
    if (empleado == null) {
      System.out.println("Empleado no encontrado.");
      return;
    }

    System.out.println("Datos del empleado");
    System.out.println("Código: " + empleado.getCodigo());
    System.out.println("Nombre: " + empleado.getNombre());
    System.out.println("Extension Telefonica: " + empleado.getExtension());
    System.out.println("Fecha de Nacimiento: " + empleado.getFechaNacimiento());
    System.out.println("Salario: " + empleado.getSalario());
    System.out.println("Código Departamento: " + empleado.getCodigoDepartamento());
  }

  
  private void imprimeDepartamento(Departamento departamento) {
      Centro centro = proveedorAlmacenamiento.getCentroByCodigo(departamento.getCodigoCentro());
      Empleado empleado = proveedorAlmacenamiento.getEmpleadoByCodigo(departamento.getCodigoDirector());

      String nombreCentro = centro != null ? centro.getNombre() : "[Centro no encontrado]";
      String nombreDirector = empleado != null ? empleado.getNombre() : "[Empleado no encontrado]";

      String nombreSuperior = "Ninguno";
      if (departamento.getCodigoDepartamentoSuperior() != null) {
        Departamento superior = proveedorAlmacenamiento.getDepartamentoByCodigo(departamento.getCodigoDepartamentoSuperior());
        if (superior != null) {
          nombreSuperior = superior.getNombre();
        } else {
          nombreSuperior = "[Departamento superior no encontrado]";
        }
      }

      System.out.println("Datos del departamento");
      System.out.println("Código: " + departamento.getCodigo());
      System.out.println("Nombre: " + departamento.getNombre());
      System.out.println("Centro en el que se ubica: " + nombreCentro);
      System.out.println("Direccion: " + departamento.getDireccion());
      System.out.println("Director: " + nombreDirector);
      System.out.println("Presupuesto: " + departamento.getPresupuesto());
      System.out.println("Nombre de departamento al que pertenece: " + nombreSuperior);
  }

  /**
   * Determina que valor emplear: el existente o el proporcionado por el usuario.
   * Se toma el proporcionado por el usuario si no está vacío o el existente si lo
   * está
   * 
   * @param nuevo  Valor proporcionado por el usuario
   * @param actual Valor actual del campo
   * @return valor nuevo si no es vacío. Valor actual en caso contrario
   */
  private String actualONuevo(String nuevo, String actual) {
    return nuevo.isEmpty() ? actual : nuevo;
  }

  /**
   * Determina que valor emplear: el existente o el proporcionado por el usuario.
   * Se toma el proporcionado por el usuario si no está vacío o el existente si lo
   * está
   * 
   * @param nuevo  Valor proporcionado por el usuario
   * @param actual Valor actual del campo
   * @return valor nuevo si no es vacío. Valor actual en caso contrario
   */
  private int actualONuevo(String nuevo, int actual) {
    return nuevo.isEmpty() ? actual : Integer.parseInt(nuevo);
  }

  /**
   * Determina que valor emplear: el existente o el proporcionado por el usuario.
   * Se toma el proporcionado por el usuario si no está vacío o el existente si lo
   * está
   * 
   * @param nuevo  Valor proporcionado por el usuario
   * @param actual Valor actual del campo
   * @return valor nuevo si no es vacío. Valor actual en caso contrario
   */
  private double actualONuevo(String nuevo, double actual) {
    return nuevo.isEmpty() ? actual : Double.parseDouble(nuevo);
  }
}
