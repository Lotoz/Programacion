package prog.unidad08.relacion02.proveedor.impl;

import static org.junit.jupiter.api.Assertions.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog.unidad08.relacion02.entidades.Centro;
import prog.unidad08.relacion02.proveedor.ProveedorAlmacenamientoEmpresa;
import prog.unidad08.relacion02.proveedor.ProveedorAlmacenamientoEmpresaException;

class TestProveedorAlmacenamientoEmpresaMariaDB {
  // Constantes
  private static final String URL = "jdbc:mariadb://%s:%d/%s?user=%s&password=%s";
  private static final String HOST = "tu_host_aqui";
  private static final int PORT = 3306;
  private static final String ESQUEMA = "tu_esquema_aqui";
  private static final String USUARIO = "tu_usuario_aqui";
  private static final String PASSWORD = "tu_password_aqui";
  private static final String DELETE_BACKUP_CENTRO = "DROP TABLE IF EXISTS backup_centro";
  private static final String CREATE_BACKUP_CENTRO = "CREATE TABLE backup_centro AS (SELECT * FROM centro)";
  private static final String RESTORE_CENTRO1 = "DELETE FROM centro";
  private static final String RESTORE_CENTRO2 = "INSERT INTO centro SELECT * FROM backup_centro";

  // Atributos
  // Proveedor correcto
  private ProveedorAlmacenamientoEmpresa proveedor;
  // Proveedor con datos de conexión incorrectos
  private ProveedorAlmacenamientoEmpresa proveedorMalo;
  
  
  private static Connection getConexion() throws Exception {
    return DriverManager.getConnection(String.format(URL, HOST, PORT, ESQUEMA, USUARIO, PASSWORD));
  }

  @BeforeAll
  static void setupAll() throws Exception {
    // Este método se llama ANTES de todas las pruebas
    // Haremos una copia de seguridad de la tabla centro
    try (Connection conexion = getConexion();
         Statement sentencia = conexion.createStatement();) {
      sentencia.executeUpdate(DELETE_BACKUP_CENTRO);
      sentencia.executeUpdate(CREATE_BACKUP_CENTRO);
    } 
  }
  @BeforeEach
  void setUp() throws Exception {
    // Y creamos un servicio
    proveedor = new ProveedorAlmacenamientoEmpresaMariaDB(HOST, PORT, ESQUEMA, USUARIO, PASSWORD);
    // Y otro que no conecta (porque los datos no son correctos)
    proveedorMalo = new ProveedorAlmacenamientoEmpresaMariaDB("", 91, "nose", "uno", "12345");
  }

  @AfterEach
  void tearDown() throws Exception {
    // Este método se llama después de cada prueba para restaurar la base de datos a como estaba
    // Restauraremos la tabla centro desde la copia para "deshacer" los cambios que hayamos podido
    // hacer sobre la tabla en las pruebas
    try (Connection conexion = getConexion();
        Statement sentencia = conexion.createStatement();) {
      sentencia.executeUpdate(RESTORE_CENTRO1);
      sentencia.executeUpdate(RESTORE_CENTRO2);
   } 
  }

  @AfterAll
  static void finishTest() throws Exception {
    // Este método se llama después de todas las pruebas
    // Eliminaremos la copia de seguridad puesto que ya no es necesaria
    
    // Eliminamos la copia de seguridad de la tabla centro
    try (Connection conexion = getConexion();
         Statement sentencia = conexion.createStatement();) {
      sentencia.executeUpdate(DELETE_BACKUP_CENTRO);
    } 
  }
  
  @Test
  void testBuscaCentroPorCodigoOk() {
    // Buscamos un centro con un código existente (1 = Malaga)
    Centro centro = proveedor.getCentroByCodigo(1);
    // El centro no debe ser null
    assertNotNull(centro);
    // El centro debe tener codigo 1 y nombre Malaga
    assertEquals(1, centro.getCodigo());
    assertEquals("Malaga", centro.getNombre());
  }

  @Test
  void testBuscaCentroPorCodigoInexistente() {
    // Buscamos un centro con un código inexistente (1000000)
    Centro centro = proveedor.getCentroByCodigo(100000);
    // El centro debe ser null
    assertNull(centro);
  }

  @Test
  void testBuscaCentroPorCodigoError() {
    // Buscamos un centro con un código existente (1 = Malaga) (da igual)
    // Debe lanzar una excepcion al hacer la llamada
    assertThrows(ProveedorAlmacenamientoEmpresaException.class, () -> proveedorMalo.getCentroByCodigo(1));
  }

  @Test
  void testBuscaCentroTodosDesordenado() {
    // Obtenemos la lista con todos los centros
    List<Centro> centros = proveedor.getAllCentro(false);

    // La lista debe tener 5 elementos
    assertEquals(5, centros.size());
  }

  @Test
  void testBuscaCentroTodosOrdenado() {
    // Obtenemos la lista con todos los centros
    List<Centro> centros = proveedor.getAllCentro(true);

    // La lista debe tener 5 elementos
    assertEquals(5, centros.size());
    
    // El primero debe ser Barcelona con codigo 4
    assertEquals(4, centros.get(0).getCodigo());
    assertEquals("Barcelona", centros.get(0).getNombre());
    // El segundo debe ser Granada con codigo 5
    assertEquals(5, centros.get(1).getCodigo());
    assertEquals("Granada", centros.get(1).getNombre());
    // El tercero debe ser Madrid con codigo 3
    assertEquals(3, centros.get(2).getCodigo());
    assertEquals("Madrid", centros.get(2).getNombre());
    // El cuarto debe ser Malaga con codigo 1
    assertEquals(1, centros.get(3).getCodigo());
    assertEquals("Malaga", centros.get(3).getNombre());
    // El ultimo debe ser Sevilla con codigo 2
    assertEquals(2, centros.get(4).getCodigo());
    assertEquals("Sevilla", centros.get(4).getNombre());
  }

  @Test
  void testBuscaCentroTodosError() {
    // Debe lanzar una excepcion al hacer la llamada
    assertThrows(ProveedorAlmacenamientoEmpresaException.class, () -> proveedorMalo.getAllCentro(false));
  }

  @Test
  void testInsertaCentroOk() {
    // Insertamos un nuevo centro (Antequera)
    Centro centro = new Centro(0, "Antequera");
    // Obtenemos el nuevo centro (el código será el del nuevo centro)
    Centro centro2 = proveedor.addCentro(centro);
    // Busca el centro y debe encontrarlo
    Centro centro3 = proveedor.getCentroByCodigo(centro2.getCodigo());
    assertEquals(centro2.getCodigo(), centro3.getCodigo());
    assertEquals(centro2.getNombre(), centro3.getNombre());
  }

  @Test
  void testInsertaCentroError() {
    // Insertamos un nuevo centro (Antequera) (da igual)
    Centro centro = new Centro(0, "Antequera");
    // Debe lanzar una excepcion al hacer la llamada
    assertThrows(ProveedorAlmacenamientoEmpresaException.class, () -> proveedorMalo.addCentro(centro));
  }


  @Test
  void testActualizaCentroOk() {
    // Actualizamos el centro de Malaga a Malaga Sur
    Centro centro = new Centro(1, "Malaga Sur");
    assertDoesNotThrow(() -> proveedor.updateCentro(centro));
    // Busca el centro y debe encontrarlo
    Centro centro2 = proveedor.getCentroByCodigo(centro.getCodigo());
    // Sus campos deben ser iguales a los del actualizado
    assertEquals(centro.getCodigo(), centro2.getCodigo());
    assertEquals(centro.getNombre(), centro2.getNombre());
  }

  @Test
  void testActualizaCentroNoExiste() {
    // Modificamos un centro inexistente
    Centro centro = new Centro(10000, "Malaga Norte");
    // Debe lanzar una excepcion al hacer la llamada
    assertThrows(ProveedorAlmacenamientoEmpresaException.class, () -> proveedor.updateCentro(centro));
  }

  @Test
  void testActualizaCentroError() {
    // Actualizamos cualquier centro (da igual)
    Centro centro = new Centro(0, "Antequera");
    // Debe lanzar una excepcion al hacer la llamada
    assertThrows(ProveedorAlmacenamientoEmpresaException.class, () -> proveedorMalo.updateCentro(centro));
  }

  @Test
  void testEliminaCentroOk() {
    // Eliminamos el centro de Malaga (1)
    assertDoesNotThrow(() -> proveedor.deleteCentroByCodigo(1));
    
    // Intentamos acceder a ese centro (nos tiene que dar null porque no existe)
    assertNull(proveedor.getCentroByCodigo(1));
  }

  @Test
  void testEliminaCentroInexistente() {
    // Eliminamos un centro inexistente (1000000)
    assertThrows(ProveedorAlmacenamientoEmpresaException.class, () -> proveedor.deleteCentroByCodigo(1000000));
  }

  @Test
  void testEliminaCentroError() {
    // Debe lanzar una excepcion al hacer la llamada
    assertThrows(ProveedorAlmacenamientoEmpresaException.class, () -> proveedorMalo.deleteCentroByCodigo(1));
  }
}
