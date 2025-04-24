package prog.unidad06.examen.ejercicio02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Procesa dos archivos de empleados y genera un nuevo con ambos mezclados
 */
public class MezclaEmpleadosApp {
//Atributos

  private String fichero1;

  private String fichero2;

  private String ficheroSalida;

  /**
   * Constructor con todo los atributos
   * 
   * @param rutaEntrada1 Ruta al primer fichero de entrada
   * @param rutaEntrada2 Ruta al segundo fichero de entrada
   * @param rutaSalida   Ruta al fichero de salida
   */
  public MezclaEmpleadosApp(String fichero1, String fichero2, String ficheroSalida) {
    this.fichero1 = fichero1;
    this.fichero2 = fichero2;
    this.ficheroSalida = ficheroSalida;
  }

  public static void main(String[] args) {
    // Controla que esten los tres archivos
    if (args.length < 3) {
      System.out.println("Faltan archivos. Se deben proporcionar 3.");
      return;
    }

    // Accedemos a los tres primeros parámetros y construimos la aplicación
    MezclaEmpleadosApp app = new MezclaEmpleadosApp(args[0], args[1], args[2]);
    app.run();

  }

  private void run() {
    System.out.printf(
        "Procesando los archivos de entrada \"%s\" y \"%s\" para" + "generar el archivo de salida \"%s\"%n", fichero1,
        fichero2, ficheroSalida);
    // Inicia una lista para guardar los datos
    List<Empleado> listaEmpleados = new ArrayList<>();
    leerDataEmpleado(fichero1, fichero2);

    // Ordena la lista
    listaEmpleados.sort(null);
    // Escribe en el nuevo archivo
    escribirNuevoArchivo(ficheroSalida, listaEmpleados);
  }

  private void leerDataEmpleado(String fichero1, String fichero2) {
    // Abrimos los dos archivos de entrada y creamos el de salida
    try (DataInputStream entrada1 = new DataInputStream(new FileInputStream(fichero1));
        DataInputStream entrada2 = new DataInputStream(new FileInputStream(fichero2))) {

      // Lista para guardar los datos
      List<Empleado> listaEmpleados = new ArrayList<>();

      // Lee el size de la primera entrada
      int cantidadPersona1 = entrada1.readInt();
      int cantidadPersona2 = entrada2.readInt();
      for (int i = 0; i < cantidadPersona1; i++) {

        String nombre = entrada1.readUTF();
        String apellidos = entrada1.readUTF();
        String dni = entrada1.readUTF();
        int edad = entrada1.readInt();
        double salario = entrada1.readDouble();
        boolean casado = entrada1.readBoolean();
        Empleado empleado = new Empleado(nombre, apellidos, dni, edad, salario, casado);
        listaEmpleados.add(empleado);

      }
      // Lee el segundo dat
      for (int i = 0; i < cantidadPersona2; i++) {
        String nombre = entrada2.readUTF();
        String apellidos = entrada2.readUTF();
        String dni = entrada2.readUTF();
        int edad = entrada2.readInt();
        double salario = entrada2.readDouble();
        boolean casado = entrada2.readBoolean();
        // Crea un nuevo empleado y lo agrega
        Empleado empleado = new Empleado(nombre, apellidos, dni, edad, salario, casado);
        listaEmpleados.add(empleado);
      }

    } catch (IOException e) {
      System.out.printf("Error accediendo a los archivos: %s%n", e.getMessage());
    }
  }

  // No escribe los datos correctamente, ver luego de interfaz
  private void escribirNuevoArchivo(String ficheroSalida, List<Empleado> listaEmpleados) {
    try (DataOutputStream salida = new DataOutputStream(new FileOutputStream(ficheroSalida))) {
      // Busca los datos en la lista y escribe
      for (Empleado empleado : listaEmpleados) {
        // Escribe los datos del empleado
        salida.writeUTF(empleado.getNombre());
        salida.writeUTF(empleado.getApellidos());
        salida.writeUTF(empleado.getDni());
        salida.writeInt(empleado.getEdad());
        salida.writeDouble(empleado.getSalario());
        salida.writeBoolean(empleado.isCasado());
      }

    } catch (Exception e) {
    }

  }

}
