package prog.ud09.actividad903.database.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.Db4oIOException;
import com.db4o.query.Predicate;

import prog.ud09.actividad903.database.BaseDatosTienda;
import prog.ud09.actividad903.database.ProcesadorVenta;
import prog.unidad09.relacion03.datos.Cliente;
import prog.unidad09.relacion03.datos.Motocicleta;
import prog.unidad09.relacion03.datos.Venta;

/**
 * COSAS POR HACER
 * ENCAPSULAR EL METODO BUSCAR REFERENCIA MOTO, SE REPITE MUCHAS VECES Y SE PODRIA REALIZAR UN METODO PARA 3.
 * VER COMO HACER.
 * REFINAR LOS METODOS.
 * REVISAR GENERAR CODIGO
 * Hacer pruebas para ver si cada dato es introducido
 * Generar un proyecto aparte para leer la base de datos entera desde terminal
 * Falta terminar StringFormat de ProcesadorListadosVentasExamen
 */
public class BaseDatosTiendaDb4o implements BaseDatosTienda {

  
  //Atributos de la clase
  //Ruta del archivo de la base de datos
  private String ficheroBd;
  //Inicia la base de datos para usar en todos los metodos
  private ObjectContainer db = Db4o.openFile(ficheroBd);
  // Fecha actual
  private String fecha = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
  
  public BaseDatosTiendaDb4o(String ficheroBd) {
    ficheroBd = this.ficheroBd;
  }

  @Override
  public void addMotocicleta(Motocicleta motocicleta) {
    //Buscamos si la motocicleta existe en la base de datos
    verificarMotocicletaDuplicados(motocicleta);
    //Verifica que los campos de la motocicleta no esten vacios
    verficarCamposMotocicleta(motocicleta);
    //Si los dos metodos salen bien, se agrega la motocicleta a la base de datos
    try {
      //Agrega la motocicleta
      db.store(motocicleta);
    } catch (Db4oIOException e) {
      System.err.printf("Error al acceder a la base de datos.");
    }
  }

  @Override
  public int addVenta(Cliente cliente, Motocicleta motocicleta) {
    //Añadimos una venta a la base de datos, esta venta devuelve un entero que pertenece al de la nueva venta
    int nuevoCodigo = generarCodigo();
    Motocicleta motoExiste;
    Cliente clienteExiste;
    try {
      //Revisamos que los nif y motocicleta referencia existan
      //Si existen deberian ser devueltos sin dificultad
     motoExiste = getMotocicletaByReferencia(motocicleta.getReferencia());
     clienteExiste = getClienteByNif(cliente.getNif());
     //Por las dudas verificacion por si devolvio un cliente nulo ((NO DEBERIA VERIFICAR LUEGO))
     if (!motoExiste.getReferencia().isBlank() && !clienteExiste.getNif().isBlank()) {
       //Creamos la nueva venta
       Venta venta = new Venta(nuevoCodigo, fecha, clienteExiste, motoExiste);
       //Agregamos la venta a la base de datos
       db.store(venta);
     }
    } catch (Db4oIOException e) {
      System.err.printf("Error al acceder a la base de datos.");
    }
    return nuevoCodigo;
  }


  @Override
  public Cliente getClienteByNif(String nif) {
  //Creamos el cliente a devolver
    Cliente clienteADevolver = null;
    try {
      
      //Realizo una consulta compleja porque no se permite casos de datos nulos o vacios
      ObjectSet<Cliente> clientes = db.query(new Predicate<Cliente>() {
        @Override
        public boolean match(Cliente candidato) {
          return candidato.getNif().equals(nif);
        }
      });
      //Recorremos el object set que no has devuelto una coincidencia
      for (Cliente cliente : clientes) {
        //Creamos el cliente con los datos obtenidos del cliente de la base de datos, para asi devolver al cliente
        clienteADevolver = new Cliente(cliente.getNif(),cliente.getNombre(),cliente.getApellidos(),cliente.getDireccion(),cliente.getRecomendadoPor());
      }
    } catch (Db4oIOException e) {
      System.err.printf("Error al acceder a la base de datos.");
    }
    //Devuelve el cliente obtenido
    return clienteADevolver;
  }

  @Override
  public Motocicleta getMotocicletaByReferencia(String referencia) {
  //Creamos la motocicleta a devolver
    Motocicleta motoADevolver = null;
    try {
      //Realizo una consulta compleja porque no se permite casos de datos nulos o vacios
      ObjectSet<Motocicleta> motos = db.query(new Predicate<Motocicleta>() {
        @Override
        public boolean match(Motocicleta candidato) {
          return candidato.getReferencia().equals(referencia);
        }
      });
      //Recorremos el object set que no has devuelto una coincidencia
      for (Motocicleta moto : motos) {
        //Creamos el cliente con los datos obtenidos del cliente de la base de datos, para asi devolver al cliente
        motoADevolver = new Motocicleta(moto.getReferencia(),moto.getCilindrada(),moto.getTipo(),moto.getPrecio(),moto.getFabricante());
      }
    } catch (Db4oIOException e) {
      System.err.printf("Error al acceder a la base de datos.");
    } 
    return motoADevolver;
  }

  @Override
  public void getAllVentas(ProcesadorVenta procesador) {
    //Obtenemos todas las ventas de la base de datos
    ObjectSet<Venta> ventas = db.query(Venta.class);
    for (Venta venta : ventas) {
      procesador.procesaVenta(venta);
    }
  }

  @Override
  public void updateCliente(Cliente cliente) {
    //Debemos hacer que la base de datos realice una consulta del nif del cliente para encontrarlo, ya que este no se puede repetir
    try {
      //Debemos realizar una consulta compleja
      ObjectSet<Cliente> clientes = db.query(new Predicate<Cliente>() {
        @Override
        public boolean match(Cliente candidato) {
          return candidato.getNif().equals(cliente.getNif());
        }
      });
      //Recorremos el object set que no has devuelto buscando coincidencias, si se encuentra, el programa debe fallar
      for (Cliente clienteBuscado : clientes) {
        if(!clienteBuscado.getNif().equals(cliente.getNif())) {
          throw new IllegalArgumentException("No existe cliente.");
        }else {
          if (cliente.getApellidos().isBlank() && cliente.getNombre().isBlank() && cliente.getDireccion().isBlank()) {
            //Si son iguales modificamos el cliente obtenido.
            //Cambiamos su apellido
            clienteBuscado.setApellidos(cliente.getApellidos());
            //Cambiamo su dirrecion
            clienteBuscado.setDireccion(cliente.getDireccion());
            //Cambiamos su nombre
            clienteBuscado.setNombre(cliente.getNombre());
            
            //Revisar si funciona
            if(cliente.getRecomendadoPor() == null) {
              db.store(clienteBuscado);
            }else {
              clienteBuscado.setRecomendadoPor(cliente.getRecomendadoPor());
              db.store(clienteBuscado);
            }
          } 
        }
      }
    } catch (Db4oIOException e) {
      System.err.printf("Error al acceder a la base de datos.");
    }
  }

  @Override
  public void deleteMotocicletaByReferencia(String referencia) {
    //Buscamos la motocicleta, si se encuentra se elimina
    try {
      //Realizo una consulta compleja porque no se permite casos de datos nulos o vacios
      ObjectSet<Motocicleta> motos = db.query(new Predicate<Motocicleta>() {
        @Override
        public boolean match(Motocicleta candidato) {
          return candidato.getReferencia().equals(referencia);
        }
      });
      //Si la encuentra, debemos tambien eleminar la venta relacionada con este motocicleta
      for(Motocicleta moto : motos) {
        //Si encuentra una moto, debemos eliminar su moto y venta
        eliminarVenta(moto);
        //Eliminamos la moto
        db.delete(moto);
      }
    } catch (Db4oIOException e) {
      System.err.printf("Error al acceder a la base de datos.");
    } 
  }

  @Override
  public void cerrar() {
    try {
      db.close();
    }catch(Db4oIOException e) {
      System.err.printf("Error al cerrar la base de datos.");
    } 
  }
  
  //Metodos privados

  /**
   * Verifica si se repite en la base de datos la referencia de una motocicleta, si se repite, falla
   * @param motocicleta
   */
  private void verificarMotocicletaDuplicados(Motocicleta motocicleta) { 
    try {
      //Debemos realizar una consulta compleja, ya que por prototipo no se puede
      //Debido que debemos impedir que se agregue una moto sin datos
      ObjectSet<Motocicleta> motocicletas = db.query(new Predicate<Motocicleta>() {
        @Override
        public boolean match(Motocicleta candidato) {
          return candidato.getReferencia().equals(motocicleta.getReferencia());
        }
      });
      //Recorremos el object set que no has devuelto buscando coincidencias, si se encuentra, el programa debe fallar
      for (Motocicleta moto : motocicletas) {
        if(moto.getReferencia().equals(motocicleta.getReferencia())) {
          throw new IllegalArgumentException("Motocicletas duplicadas");
        }
      }
      //Si no falla, no existe duplicado
    } catch (Db4oIOException e) {
      System.err.printf("Error al acceder a la base de datos.");
    }
  }

  /**
   * Verifica que los de una motocicleta no esten vacios a la hora de agregarla a la base de datos.
   * Si estan vacios falla
   * @param motocicleta
   */
  private void verficarCamposMotocicleta(Motocicleta motocicleta) {
    //Verificamos campo por campo
    if(motocicleta.getCilindrada() <= 0 && motocicleta.getFabricante().isBlank() && motocicleta.getTipo().isBlank() && motocicleta.getPrecio() <= 0) {
      throw new IllegalArgumentException("Los campos introducidos en la motocicleta son incorrectos.");
    }
  }
  
  /**
   * Elimina una o muchas ventas que tenga la moto
   * @param moto
   */
  private void eliminarVenta(Motocicleta moto) {
    //Buscamos en ventas la moto que coinciada con esa
  //Realizo una consulta compleja porque no se permite casos de datos nulos o vacios
    ObjectSet<Venta> ventas = db.query(new Predicate<Venta>() {
      @Override
      public boolean match(Venta candidato) {
        return candidato.getMotocicleta().getReferencia().equals(moto.getReferencia());
      }
    });
    for (Venta venta : ventas) {
      //Eliminamos todas las ventas encontradas
      db.delete(venta);
    }
  }

  
  //Revisar si estaba bien
  /**
   * Genera un codigo a partir de las ventas existentes en la base de datos
   * @return
   */
  private int generarCodigo() {
    //Hacemos una consulta a la base de datos y obtenemos todas las ventas
    ObjectSet<Venta> ventas = db.query(Venta.class);
    int codigo = 0;
    //Por cada venta que recorre devuelve 1
    for (Venta venta : ventas) {
      codigo ++;
    }
    return codigo;
  }
}
