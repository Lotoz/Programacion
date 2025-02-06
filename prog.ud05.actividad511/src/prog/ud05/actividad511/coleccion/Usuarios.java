package prog.ud05.actividad511.coleccion;

import java.util.HashMap;
import java.util.Map;

import prog.ud05.actividad511.coleccion.diccionario.Diccionario;

public class Usuarios {

  //Corregir, falta diccionario
  /**
   * Atributos de la clase
   */
  private Usuario usuario;
  private String nombreUsuario;
  private Map<Usuario, TarjetaClaves> usuarios;
  private TarjetaClaves tarjeta;
  /**
   * Constructor. Inicializa el contenedor
   */
  public Usuarios() {
    usuarios = new HashMap<>();
  }

  /**
   * Añade un nuevo usuario al contenedor.
   * @param usuario - Usuario a añadir. No puede ser null
   * Falla si ya hay un usuario con el mismo nombre de usuario
   * @throws IllegalArgumentException - Si el usuario es null
   * @throws UsuariosException - Si ya existe un usuario en el contenedor con el mismo nombre de usuario que el que se está intentando añadir 
   */
  public void addUsuario(Usuario usuario) {
    //Debe agregar el usuario

    
  }
  /**
   * Localiza un usuario por su nombre de usuario
   * @param nombreUsuario - Nombre de usuario del usuario a localizar
   * @return usuario si se encontró. null si no se encontró
   */
  public Usuario getUsuarioPorNombreUsuario(String nombreUsuario) {
    //Debe devolver el usuario
    //Debe recorrer el mapa de usuario y ver si esta ese usuario
    if(usuarios.containsKey(nombreUsuario)) {
    return usuario;
    } else {
      return null;
    }
    
  }
}
