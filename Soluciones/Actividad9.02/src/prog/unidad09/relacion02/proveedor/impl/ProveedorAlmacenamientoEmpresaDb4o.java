package prog.unidad09.relacion02.proveedor.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import prog.unidad09.relacion02.datos.Centro;
import prog.unidad09.relacion02.datos.Departamento;
import prog.unidad09.relacion02.datos.Empleado;
import prog.unidad09.relacion02.proveedor.ProveedorAlmacenamientoEmpresa;
import prog.unidad09.relacion02.proveedor.ProveedorAlmacenamientoEmpresaException;

/**
 * Proveedor de almacenamiento para la empresa en base de datos SQLite
 */
public class ProveedorAlmacenamientoEmpresaDb4o implements ProveedorAlmacenamientoEmpresa {

  // Atributos
  // Base de datos DB4o
  private ObjectContainer db;
  
  /**
   * Constructor
   * @param rutaDB Ruta a la base de datos a emplear.
   */
  public ProveedorAlmacenamientoEmpresaDb4o(String rutaDB) {
    this.db = Db4o.openFile(rutaDB);
  }
  
  @Override
  public Centro getCentroByCodigo(int codigo) {
    try {
      // Empleamos consulta por ejemplo ya que queremos que el codigo sea exactamente el indicado
      Centro centro = new Centro(codigo, null);
      // Consultamos
      ObjectSet<Centro> centros = db.queryByExample(centro);
      // Si hay centro
      if (centros.size() > 0) {
        // Lo devolvemos
        return centros.get(0);
      } else {
        // Devolvemos null
        return null;
      }
    } catch (Exception e) {
      throw new ProveedorAlmacenamientoEmpresaException("Error de consulta en getCentroByCodigo: "
        + e.getMessage());
    }
  }

  @Override
  public List<Centro> getAllCentro(boolean ordenarPorNombre) {
    try {
      // Según si hay que ordenar o no crea un comparador u otro
      Comparator<Centro> comparador = ordenarPorNombre ?
        new Comparator<Centro>() {
          @Override
          public int compare(Centro o1, Centro o2) {
            return o1.getNombre().compareTo(o2.getNombre());
          }
      } :
        new Comparator<Centro>() {
          @Override
          public int compare(Centro o1, Centro o2) {
            return 0;
          }
      };
      
      // Empleamos consulta con predicado para poder ordenar (el predicado admite todos
      // los centros
      ObjectSet<Centro> centros = db.query(new Predicate<Centro>() {
        @Override
        public boolean match(Centro candidate) {
          return true;
        }
      }, comparador);
      // Creamos la salida
      List<Centro> salida = new ArrayList<Centro>();
      // Copiamos los resultados a la salida
      for (Centro centro: centros) {
        salida.add(centro);
      }
      // Devolvemos el resultado
      return salida;
    } catch (Exception e) {
      throw new ProveedorAlmacenamientoEmpresaException("Error de consulta en getAllCentro: "
        + e.getMessage());
    }
  }

  @Override
  public Centro addCentro(Centro centro) {
    try {
      // Consultamos todos los centros
      ObjectSet<Centro> centros = db.query(Centro.class);
      // Calculamos el número mayor
      int mayorNumero = -1;
      for (Centro centroTemporal: centros) {
        if (centroTemporal.getNumero() > mayorNumero) {
          mayorNumero = centroTemporal.getNumero();
        }
      }
      // Creamos un nuevo centro igual que el de entrada pero con el nuevo código
      // El nuevo código será el máximo + 1
      Centro nuevoCentro = new Centro(mayorNumero + 1, centro.getNombre());
      // Lo almacenamos
      db.store(nuevoCentro);
      // Devolvemos el resultado (el nuevo centro)
      return nuevoCentro;
    } catch (Exception e) {
      throw new ProveedorAlmacenamientoEmpresaException("Error de consulta en addCentro: "
        + e.getMessage());
    }
  }

  @Override
  public void updateCentro(Centro centro) {
    try {
      // Intentamos acceder al centro
      Centro modelo = new Centro(centro.getNumero(), null);
      // Consultamos a ver si existe
      ObjectSet<Centro> centros = db.queryByExample(modelo);
      // Si existe
      if (centros.size() == 1) {
        // Obtenemos el centro
        Centro aModificar = centros.get(0);
        aModificar.setNumero(centro.getNumero());
        aModificar.setNombre(centro.getNombre());
        // Actualizamos
        db.store(aModificar);
      } else {
        // NO existe. Lanza excepción
        throw new ProveedorAlmacenamientoEmpresaException("Error en updateCentro. El centro"
            + " indicado no existe en la base de datos");
      }
    } catch (Exception e) {
      throw new ProveedorAlmacenamientoEmpresaException("Error de consulta en updateCentro: "
        + e.getMessage());
    }
  }

  @Override
  public void deleteCentroByCodigo(int codigo) {
    try {
      // Empleamos consulta por ejemplo ya que queremos que el codigo sea exactamente el indicado
      Centro centro = new Centro(codigo, null);
      // Consultamos
      ObjectSet<Centro> centros = db.queryByExample(centro);
      // Si hay centro
      if (centros.size() > 0) {
        // Se elimina
        db.delete(centros.get(0));
      } else {
        throw new ProveedorAlmacenamientoEmpresaException("Centro inexistente en deleteCentroByCodigo");
      }
    } catch (Exception e) {
      throw new ProveedorAlmacenamientoEmpresaException("Error de consulta en getCentroByCodigo: "
        + e.getMessage());
    }
  }

  @Override
  public List<Departamento> getAllDepartamento(boolean ordenarPorNombre) {
    try {
      // Según si hay que ordenar o no crea un comparador u otro
      Comparator<Departamento> comparador = ordenarPorNombre ?
        new Comparator<Departamento>() {
          @Override
          public int compare(Departamento o1, Departamento o2) {
            return o1.getNombre().compareTo(o2.getNombre());
          }
      } :
        new Comparator<Departamento>() {
          @Override
          public int compare(Departamento o1, Departamento o2) {
            return 0;
          }
      };
      
      // Empleamos consulta con predicado para poder ordenar (el predicado admite todos
      // los centros
      ObjectSet<Departamento> departamentos = db.query(new Predicate<Departamento>() {
        @Override
        public boolean match(Departamento candidate) {
          return true;
        }
      }, comparador);
      // Creamos la salida
      List<Departamento> salida = new ArrayList<Departamento>();
      // Copiamos los resultados a la salida
      for (Departamento departamento: departamentos) {
        salida.add(departamento);
      }
      // Devolvemos el resultado
      return salida;
    } catch (Exception e) {
      throw new ProveedorAlmacenamientoEmpresaException("Error de consulta en getAllDepartamento: "
        + e.getMessage());
    }
  }

  @Override
  public Departamento getDepartamentoByCodigo(int codigo) {
    try {
      // Empleamos consulta por ejemplo ya que queremos que el codigo sea exactamente el indicado
      Departamento departamento = new Departamento(codigo, null, null, 0, null, null, null);
      // Consultamos
      ObjectSet<Departamento> departamentos = db.queryByExample(departamento);
      // Si hay departamento
      if (departamentos.size() > 0) {
        // Lo devolvemos
        return departamentos.get(0);
      } else {
        // Devolvemos null
        return null;
      }
    } catch (Exception e) {
      throw new ProveedorAlmacenamientoEmpresaException("Error de consulta en getDepartamentoByCodigo: "
        + e.getMessage());
    }
  }

  @Override
  public Departamento addDepartamento(Departamento departamento) {
    try {
      // Consultamos todos los departamento
      ObjectSet<Departamento> departamentos = db.query(Departamento.class);
      // Calculamos el número mayor
      int mayorNumero = -1;
      for (Departamento departamentoTemporal: departamentos) {
        if (departamentoTemporal.getNumero() > mayorNumero) {
          mayorNumero = departamentoTemporal.getNumero();
        }
      }
      // Creamos un nuevo departamento igual que el de entrada pero con el nuevo código
      // El nuevo código será el máximo + 1
      Departamento nuevoDepartamento = new Departamento(mayorNumero + 1, departamento.getNombre(),
          departamento.getDireccion(), departamento.getPresupuesto(), departamento.getCentro(),
          departamento.getDirector(), departamento.getDependeDe());
      // Lo almacenamos
      db.store(nuevoDepartamento);
      // Devolvemos el resultado (el nuevo departamento)
      return nuevoDepartamento;
    } catch (Exception e) {
      throw new ProveedorAlmacenamientoEmpresaException("Error de consulta en addDepartamento: "
        + e.getMessage());
    }
  }

  @Override
  public void updateDepartamento(Departamento departamento) {
    try {
      // Intentamos acceder al departamento
      Departamento modelo = new Departamento(departamento.getNumero(), null, null, 0, null, null,
          null);
      // Consultamos a ver si existe
      ObjectSet<Departamento> departamentos = db.queryByExample(modelo);
      // Si existe
      if (departamentos.size() == 1) {
        // Obtenemos el departamento
        Departamento aModificar = departamentos.get(0);
        aModificar.setNumero(departamento.getNumero());
        aModificar.setNombre(departamento.getNombre());
        aModificar.setDireccion(departamento.getDireccion());
        aModificar.setPresupuesto(departamento.getPresupuesto());
        aModificar.setCentro(departamento.getCentro());
        aModificar.setDirector(departamento.getDirector());
        aModificar.setDependeDe(departamento.getDependeDe());
        // Actualizamos
        db.store(aModificar);
      } else {
        // NO existe. Lanza excepción
        throw new ProveedorAlmacenamientoEmpresaException("Error en updateDepartamento. El "
            + "departamento indicado no existe en la base de datos");
      }
    } catch (Exception e) {
      throw new ProveedorAlmacenamientoEmpresaException("Error de consulta en updateDepartamento: "
        + e.getMessage());
    }
  }

  @Override
  public void deleteDepartamentoByCodigo(int codigo) {
    try {
      // Empleamos consulta por ejemplo ya que queremos que el codigo sea exactamente el indicado
      Departamento departamento = new Departamento(codigo, null, null, 0, null, null, null);
      // Consultamos
      ObjectSet<Departamento> departamentos = db.queryByExample(departamento);
      // Si hay departamento
      if (departamentos.size() > 0) {
        // Se elimina
        db.delete(departamentos.get(0));
      } else {
        throw new ProveedorAlmacenamientoEmpresaException("Centro inexistente en deleteDepartamentosByCodigo");
      }
    } catch (Exception e) {
      throw new ProveedorAlmacenamientoEmpresaException("Error de consulta en getDepartamentoByCodigo: "
        + e.getMessage());
    }
  }

  @Override
  public Empleado getEmpleadoByCodigo(int codigo) {
    try {
      // Empleamos consulta por ejemplo ya que queremos que el codigo sea exactamente el indicado
      Empleado empleado = new Empleado(codigo, null, null, null, null, 0, 0, 0, null);
      // Consultamos
      ObjectSet<Empleado> empleados = db.queryByExample(empleado);
      // Si hay empleado
      if (empleados.size() > 0) {
        // Lo devolvemos
        return empleados.get(0);
      } else {
        // Devolvemos null
        return null;
      }
    } catch (Exception e) {
      throw new ProveedorAlmacenamientoEmpresaException("Error de consulta en getEmpleadoByCodigo: "
        + e.getMessage());
    }
  }

  @Override
  public void cerrar() {
    try {
      db.close();
    } catch (Exception e) {}
  }
}
