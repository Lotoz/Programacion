package prog.ud05.actividad511.proveedores;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import prog.ud05.actividad511.coleccion.Cliente;
import prog.ud05.actividad511.coleccion.ProveedorUsuarios;
import prog.ud05.actividad511.coleccion.ProveedorUsuariosException;
import prog.ud05.actividad511.coleccion.TarjetaClaves;
import prog.ud05.actividad511.coleccion.Usuario;
import prog.ud05.actividad511.coleccion.Usuarios;

/**
 * Implementación de ProveedorUsuarios que obtiene la información desde un
 * archivo JSON
 */
public class ProveedorUsuariosArchivoJSON implements ProveedorUsuarios {

  // Atributos
  private String nombreFichero;

  /**
   * Constructor con archivo
   * 
   * @param archivo Archivo JSON con la información de los usuarios
   */
  public ProveedorUsuariosArchivoJSON(String archivo) {

    nombreFichero = archivo;
  }

  /**
   * Obtiene los usuarios desde la fuente de datos
   * 
   * @return Contenedor con los usuarios si todo fue OK. Vacío o incompleto en
   *         caso de error
   * @throws ProveedorUsuariosException Si hay algún error obteniendo la
   *                                    información
   */
  public Usuarios obtieneUsuarios() {

    return leerJson();
  }

  private Usuarios leerJson() {

    try {
      // Leemos el JSON
      JsonElement raiz = JsonParser.parseReader(new FileReader(nombreFichero));
      // Inicializamos el contenedor de usuarios
      Usuarios usuarios = new Usuarios();

      // Comprobamos si es un array
      if (raiz.isJsonArray()) {
        // Si es lo extraemos
        JsonArray arrayRaiz = raiz.getAsJsonArray();
        // Iniciamos un objeto usuario
        Usuario usuario;

        // Buscamos en el array recorriendolo con un for each
        for (JsonElement jsonElement : arrayRaiz) {
          // Si encuentra un objeto continua si no, salta excepcion
          if (jsonElement.isJsonObject()) {
            // Si ha encontrado un objeto lo extraemos
            JsonObject objetoUsuario = jsonElement.getAsJsonObject();
            // de ese objeto extraemos la cadenas String
            String nombreUsuario = objetoUsuario.get("id").getAsString();
            String nombreCompleto = objetoUsuario.get("nombre").getAsString();

            // Inicializamos un objeto TarjetaClave
            TarjetaClaves tarjeta;

            // Inicializamos una lista
            List<Cliente> clientes = new ArrayList<>();

            // Obtenemos un array del array
            // Este array son las filas de tarjeta
            JsonArray arrayTarjeta1 = objetoUsuario.getAsJsonArray("tarjetaClaves");
            // Extraemos otro array para poder anexar los datos de las columnas
            JsonArray arrayTarjeta2 = arrayTarjeta1.get(0).getAsJsonArray();

            // Tomamos los tamaños del array para poder crear luego la tarjeta
            int longitudTarjeta1 = arrayTarjeta1.size();
            int longitudTarjeta2 = arrayTarjeta2.size();

            // inicializamos la clave
            int clave = 000;
            // Inicializamos un contador para contar la posicion del array
            // Este debe iniciar en 1 ya que el array cuenta desde 0 y se necesita que el
            // conteo sea desde 1
            int i = 1;

            // Creamos el objeto tarjeta con la variable de los tamaños
            tarjeta = new TarjetaClaves(longitudTarjeta1, longitudTarjeta2);

            // Recorremos en el array sus posiciones para asi poder almacenar la posicion
            // del segundo array
            for (JsonElement jsonElement2 : arrayTarjeta1) {
              // inicializamos contador del segundo array
              // Este debe iniciar en 1 ya que el array cuenta desde 0 y se necesita que el
              // conteo sea desde 1
              int j = 1;

              // Recorremos en el array ahora de las columnas para ir agregando cada clave a
              // ellas
              for (JsonElement jsonElement3 : jsonElement2.getAsJsonArray()) {
                // Decimos que clave vale el entero que se encuentre en esa posicion
                clave = jsonElement3.getAsInt();
                // ingresamos esa clave al array
                tarjeta.setClave(i, j, clave);
                j++;
              }
              i++;
            }
            // Extraemos el array de clientes
            JsonArray arrayClientes = objetoUsuario.getAsJsonArray("clientes");
            // Inicializamos sus atributos
            String nombreCliente = "";
            String apellidosCliente = "";
            String dniCliente = "";
            int edadCliente = 0;
            // Recorremos ese array para ver cada cliente
            for (JsonElement jsonElement2 : arrayClientes) {
              // Extraemos un objeto cliente
              JsonObject objetoCliente = jsonElement2.getAsJsonObject();
              // Verificamos que dentro de ese array hay un objeto cliente
              if (objetoCliente.isJsonObject()) {
                // Extraemos cada atributo de cliente
                nombreCliente = objetoCliente.get("nombre").getAsString();
                apellidosCliente = objetoCliente.get("apellidos").getAsString();
                dniCliente = objetoCliente.get("dni").getAsString();
                edadCliente = objetoCliente.get("edad").getAsInt();
                // Creamos el cliente
                Cliente cliente = new Cliente(nombreCliente, apellidosCliente, dniCliente, edadCliente);
                // Lo añadimos a la lista
                clientes.add(cliente);

              } else {

                throw new ProveedorUsuariosException("El ARRAY CLIENTES no contiene OBJECTO.");
              }
            }
            // Añadimos todos los datos al usuario
            usuario = new Usuario(nombreUsuario, nombreCompleto, tarjeta, clientes);
            // Añadimos el usuario a usuario
            usuarios.addUsuario(usuario);

          } else {

            throw new ProveedorUsuariosException("El JSONARRAY no tiene objeto.");
          }
        }

      } else {

        throw new ProveedorUsuariosException("El archivo JSON no contiene un array.");
      }
      // Devolvemos el contendor usuarios
      return usuarios;

    } catch (Exception e) {

      throw new ProveedorUsuariosException("Error procesando el fichero", e);
    }
  }
}
