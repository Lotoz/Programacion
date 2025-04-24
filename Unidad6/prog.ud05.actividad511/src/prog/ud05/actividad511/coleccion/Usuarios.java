package prog.ud05.actividad511.coleccion;

import java.util.HashMap;
import java.util.Map;

import prog.ud05.actividad511.coleccion.diccionario.Diccionario;

/**
 * Contenedor de los usuarios del sistema La clase Usuarios se encarga de
 * almacenar y recuperar los usuarios que forman el sistema
 */
public class Usuarios {

  // Atributos de la clase
  private Diccionario<Usuario> usuarios;

  /**
   * Constructor. Inicializa el contenedor
   */
  public Usuarios() {
    usuarios = new Diccionario<>();
  }

  /**
   * Añade un nuevo usuario al contenedor.
   * 
   * @param usuario - Usuario a añadir. No puede ser null Falla si ya hay un
   *                usuario con el mismo nombre de usuario
   * @throws IllegalArgumentException - Si el usuario es null
   * @throws UsuariosException        - Si ya existe un usuario en el contenedor
   *                                  con el mismo nombre de usuario que el que se
   *                                  está intentando añadir
   */
  public void addUsuario(Usuario usuario) {
    // Debe agregar el usuario
    if (usuarios == null) {

      throw new IllegalArgumentException("El usuario es null");

    } else if (usuarios.contieneNombre(usuario.getNombreUsuario())) {

      throw new UsuariosException(
          "Ya existe un usuario en el contenedor con el mismo nombre de usuario que el que se está intentando añadir",
          null);
    }
    // Si no salta ninguna excepcion agrega el usuario
    usuarios.add(usuario.getNombreUsuario(), usuario);

  }

  /**
   * Localiza un usuario por su nombre de usuario
   * 
   * @param nombreUsuario - Nombre de usuario del usuario a localizar
   * @return usuario si se encontró. null si no se encontró
   */
  public Usuario getUsuarioPorNombreUsuario(String nombreUsuario) {
    return usuarios.getEntrada(nombreUsuario);
  }
}
