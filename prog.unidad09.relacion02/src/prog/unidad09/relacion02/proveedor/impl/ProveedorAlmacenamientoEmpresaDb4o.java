package prog.unidad09.relacion02.proveedor.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.Db4oIOException;
import com.db4o.query.Predicate;


import prog.unidad09.relacion02.datos.Centro;
import prog.unidad09.relacion02.datos.Departamento;
import prog.unidad09.relacion02.datos.Empleado;
import prog.unidad09.relacion02.proveedor.ProveedorAlmacenamientoEmpresa;

public class ProveedorAlmacenamientoEmpresaDb4o implements ProveedorAlmacenamientoEmpresa {
  
  //Atributos
  private String rutaDb;
  private ObjectContainer db = null;
  
  public ProveedorAlmacenamientoEmpresaDb4o(String rutaDb) {
    rutaDb = this.rutaDb;
  }

  @Override
  public Centro getCentroByCodigo(int codigo) {
    //Iniciamos la base de datos.
    ObjectContainer db = iniciarBaseD();
     try {
      //Haremos la busqueda por prototipo
       Centro prototipoCodigo = new Centro(codigo, null);
       ObjectSet<Centro> centros = db.queryByExample(prototipoCodigo);
       for (Centro centro : centros) {
         if (centro.getNumero() == codigo) {
            return centro;
         }
       }  
    } catch (Exception e) {
      System.err.printf("Error en el metodo obtener codigo." + e);
    }finally {
      cerrar(db);
    }  
    return null;
  }



  @Override
  public List<Centro> getAllCentro(boolean ordenarPorNombre) {
    //Iniciamos base de datos
    List<Centro> centro = new ArrayList<Centro>();
    ObjectContainer db = iniciarBaseD();
    try {
      //Si el ordenarPorNombre es true, se ordena
      if (ordenarPorNombre == true) {
        ObjectSet<Centro> centros = db.query(Centro.class);
          centros.sort(new Comparator<Centro>() {
            @Override
            public int compare(Centro o1, Centro o2) {
              // Ordenamos por orden ascendente
              return o1.getNombre().compareToIgnoreCase(o2.getNombre());
            }
          });
          centro = centros;
          return centro;
      } else {
        //Si no se devuelve lo que venga
        ObjectSet<Centro> centros = db.query(Centro.class);
        centro = centros;
        return centro;
      }
      //Consulta general de clase
      
    } catch (Db4oIOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      cerrar(db);
    }
    return centro;
  }

  @Override
  public Centro addCentro(Centro centro) {
    
    return null;
  }

  @Override
  public void updateCentro(Centro centro) {
    // TODO Auto-generated method stub

  }

  @Override
  public void deleteCentroByCodigo(int codigo) {
    // TODO Auto-generated method stub

  }

  @Override
  public List<Departamento> getDepartamentoAll(boolean ordenarPorNombre) {
    //Iniciamos base de datos
    iniciarBase();
    List<Departamento> centro = new ArrayList<Departamento>();
    try {
      //Si el ordenarPorNombre es true, se ordena
      if (ordenarPorNombre == true) {
        //Si no se devuelve lo que venga
        ObjectSet<Departamento> centros = db.query(Departamento.class);
        for (Departamento departamento : centros) {
          centro.add(departamento);
        }
       
      } else {
       
        ObjectSet<Departamento> centros = db.query(Departamento.class);
        centros.sort(new Comparator<Departamento>() {
         @Override
         public int compare(Departamento o1, Departamento o2) {
           // Ordenamos por orden ascendente
           return o1.getNombre().compareToIgnoreCase(o2.getNombre());
         }
       });
        for (Departamento departamento : centros) {
         centro.add(departamento);
       }
       
      }
      //Consulta general de clase
      
    } catch (Db4oIOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      cerrar();
    }
    return centro;
  }

  @Override
  public Departamento getDepartamentoByCodigo(int codigo) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Departamento addDepartamento(Departamento departamento) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void updateDepartamento(Departamento departamento) {
    // TODO Auto-generated method stub

  }

  @Override
  public void deleteDepartamentoByCodigo(int codigo) {
    // TODO Auto-generated method stub

  }

  @Override
  public Empleado getEmpleadoByCodigo(int codigo) {
    // TODO Auto-generated method stub
    return null;
  }
  
  @Override
  public void cerrar() {
    try {
      db.close();
    } catch (Db4oIOException e) {
      System.err.printf("Error al cerrar a la base de datos.");
    } 
  }

  @Override
  public List<Departamento> getAllDepartamento(boolean b) {
    // TODO Auto-generated method stub
    return null;
  }
  /**
   * Cierra la base de datos
   * 
   * @param db
   */
  private void iniciarBaseD() {
 // iniciamos la base de datos
    ObjectContainer db = null;
    try {
      db = Db4o.openFile(rutaDb); 
    } catch (Db4oIOException e) {
      System.err.printf("Error al acceder a la base de datos.");
    }
  }

}
