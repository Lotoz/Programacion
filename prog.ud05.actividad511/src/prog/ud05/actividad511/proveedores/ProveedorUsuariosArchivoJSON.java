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
 * Implementación de ProveedorUsuarios que obtiene la información desde un archivo JSON
 */
public class ProveedorUsuariosArchivoJSON implements ProveedorUsuarios{

  private String nombreFichero;
  
  /**
   * Constructor con archivo
   * 
   * @param archivo  Archivo JSON con la información de los usuarios
   */
  public ProveedorUsuariosArchivoJSON(String archivo) {
    
    nombreFichero = archivo;
  }

  /**
   * Obtiene los usuarios desde la fuente de datos
   * 
   * @return Contenedor con los usuarios si todo fue OK. Vacío o incompleto en caso de error
   * @throws ProveedorUsuariosException Si hay algún error obteniendo la información
   */
  public Usuarios obtieneUsuarios() throws ProveedorUsuariosException{
    
    return leerJson();
  }
  
  private Usuarios leerJson() throws ProveedorUsuariosException {
    
    try {
      JsonElement raiz = JsonParser.parseReader(new FileReader(nombreFichero));
      Usuarios usuarios = new Usuarios();
      
      if (raiz.isJsonArray()) {
        // Lo proceso
        JsonArray arrayRaiz = raiz.getAsJsonArray();
        Usuario usuario;
        for (JsonElement jsonElement : arrayRaiz) {
          
          if (jsonElement.isJsonObject()) {
           
            JsonObject objetoUsuario = jsonElement.getAsJsonObject();
            String nombreUsuario = objetoUsuario.get("id").getAsString();
            String nombreCompleto = objetoUsuario.get("nombre").getAsString();
            TarjetaClaves tarjeta;
            List<Cliente> clientes = new ArrayList<>();
            JsonArray arrayTarjeta1 = objetoUsuario.getAsJsonArray("tarjetaClaves");
            JsonArray arrayTarjeta2 = arrayTarjeta1.get(0).getAsJsonArray();
            int longitudTarjeta1 = arrayTarjeta1.size();
            int longitudTarjeta2 = arrayTarjeta2.size();
            int clave = 000;
            int i = 1;
            
            tarjeta = new TarjetaClaves(longitudTarjeta1,longitudTarjeta2);
            
            for (JsonElement jsonElement2 : arrayTarjeta1) {
              
              int j = 1;
              
              for (JsonElement jsonElement3 : jsonElement2.getAsJsonArray()) {
                
                clave = jsonElement3.getAsInt();
                tarjeta.setClave(i, j, clave);
                j++;
              }
              i ++;
            }
            JsonArray arrayClientes = objetoUsuario.getAsJsonArray("clientes");
            String nombreCliente = "";
            String apellidosCliente = "";
            String dniCliente = "";
            int edadCliente = 0;
            for (JsonElement jsonElement2 : arrayClientes) {
              
              JsonObject objetoCliente = jsonElement2.getAsJsonObject();
              if (objetoCliente.isJsonObject()) {
                
                nombreCliente = objetoCliente.get("nombre").getAsString();
                apellidosCliente = objetoCliente.get("apellidos").getAsString();
                dniCliente = objetoCliente.get("dni").getAsString();
                edadCliente = objetoCliente.get("edad").getAsInt();
                Cliente cliente = new Cliente(nombreCliente, apellidosCliente, dniCliente, edadCliente);
                clientes.add(cliente);
                
              } else {
                
                throw new ProveedorUsuariosException("Hay algún error obteniendo la información");
              }
            }
            usuario = new Usuario(nombreUsuario, nombreCompleto, tarjeta, clientes);
            usuarios.addUsuario(usuario);
            
          } else {
            
            throw new ProveedorUsuariosException("Hay algún error obteniendo la información");
          }
        }
        
      } else {
        
        throw new ProveedorUsuariosException("Hay algún error obteniendo la información");
      }
      
      return usuarios;
      
    } catch (Exception e) {
      
      throw new ProveedorUsuariosException("Error procesando el fichero", e);
    }
  }
}


