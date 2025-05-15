package prog.ud09.actividad903.database.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.Db4oIOException;
import com.db4o.query.Predicate;

import prog.common.consola.Consola;
import prog.ud09.actividad903.database.BaseDatosTienda;
import prog.ud09.actividad903.database.BaseDatosTiendaException;
import prog.ud09.actividad903.database.ProcesadorVenta;
import prog.unidad09.relacion03.datos.Cliente;
import prog.unidad09.relacion03.datos.Motocicleta;
import prog.unidad09.relacion03.datos.Venta;

/**
 * Clase para acceder a la base de datos y manipular sus datos
 */
public class BaseDatosTiendaDb4o implements BaseDatosTienda {

  // Constante si es necesario concatenarlo con la carpeta o no
  // private static final String CARPETA_BBDD = "db/";

  // Atributos de la clase
  // Ruta del archivo de la base de datos
  private String ficheroBd;
  // Inicia la base de datos para usar en todos los metodos
  private ObjectContainer db = null;
  // Fecha actual
  private String fecha = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
  // Consola usada para pedir al usuario la confirmacion de eliminar moto
  private static Consola consola = Consola.getInstancia();

  public BaseDatosTiendaDb4o(String ficheroBd) {
    this.ficheroBd = ficheroBd;
    // Abrimos la base de datos para que no sea necesaria abrirla en cada proceso y
    // se pueda cerrar con su metodo especifico
    // this.db = Db4o.openFile(ficheroBd);
    abrir();
  }

  @Override
  public void addMotocicleta(Motocicleta motocicleta) {
    // Buscamos si la motocicleta existe en la base de datos
    verificarMotocicletaDuplicados(motocicleta);
    // Verifica que los campos de la motocicleta no esten vacios
    verficarCamposMotocicleta(motocicleta);
    // Si los dos metodos salen bien, se agrega la motocicleta a la base de datos
    try {
      // Agrega la motocicleta
      db.store(motocicleta);
    } catch (Db4oIOException e) {
      System.err.printf("Error al acceder a la base de datos.");
    }
  }

  @Override
  public int addVenta(Cliente cliente, Motocicleta motocicleta) {
    try {
      //Corroboramos si no son nulos
      if (cliente == null ) {
        throw new BaseDatosTiendaException("No se encontró el cliente solicitado.");
      }
      // Si devuelve una venta null, salta excepcion
      if (motocicleta == null) {
        throw new BaseDatosTiendaException("No se encontró la motocicleta con la referencia especificada");
      }
      int nuevoCodigo = generarCodigo();
      // Creamos la nueva venta
      Venta venta = new Venta(nuevoCodigo, fecha, cliente, motocicleta);
      // Añadimos una venta a la base de datos, esta venta devuelve un entero que
      // pertenece al de la nueva venta
      db.store(venta);
      return nuevoCodigo;
    } catch (Db4oIOException e) {
      System.err.printf("Error al acceder a la base de datos.");
    }
    return -1;
  }

  @Override
  public Cliente getClienteByNif(String nif) {
    // Creamos el cliente a devolver
    Cliente clienteADevolver = null;
    try {
      // Realizo una consulta compleja porque no se permite casos de datos nulos o
      // vacios
      ObjectSet<Cliente> clientes = db.query(new Predicate<Cliente>() {
        @Override
        public boolean match(Cliente candidato) {
          return candidato.getNif().equals(nif);
        }
      });
      // Recorremos el object set que no has devuelto una coincidencia
      for (Cliente cliente : clientes) {
        // Creamos el cliente con los datos obtenidos de la base de datos
        clienteADevolver = new Cliente(cliente.getNif(), cliente.getNombre(), cliente.getApellidos(),
            cliente.getDireccion(), cliente.getRecomendadoPor());
      }
    } catch (Db4oIOException e) {
      System.err.printf("Error al acceder a la base de datos.");
    }
    // Devuelve el cliente obtenido
    return clienteADevolver;
  }

  @Override
  public Motocicleta getMotocicletaByReferencia(String referencia) {

    // Creamos la motocicleta a devolver
    Motocicleta motoADevolver = null;
    try {
      // Realizo una consulta compleja porque no se permite casos de datos nulos o
      // vacios
      ObjectSet<Motocicleta> motos = db.query(new Predicate<Motocicleta>() {
        @Override
        public boolean match(Motocicleta candidato) {
          return candidato.getReferencia().equals(referencia);
        }
      });
      // Recorremos el object set que no has devuelto una coincidencia
      for (Motocicleta moto : motos) {
        // Creamos la motocicleta con los datos obtenidos de la base de datos
        motoADevolver = new Motocicleta(moto.getReferencia(), moto.getCilindrada(), moto.getTipo(), moto.getPrecio(),
            moto.getFabricante());
      }
    } catch (Db4oIOException e) {
      System.err.printf("Error al acceder a la base de datos.");
    }
    return motoADevolver;
  }

  @Override
  public void getAllVentas(ProcesadorVenta procesador) {
    try {
      // Obtenemos todas las ventas de la base de datos
      ObjectSet<Venta> ventas = db.query(Venta.class);
      // Recorremos las ventas obtenidas y se la pasamos al procesador
      for (Venta venta : ventas) {
        procesador.procesaVenta(venta);
      }
    } catch (Db4oIOException e) {
      System.err.printf("Error al acceder a la base de datos.");
    }
  }

  @Override
  public void updateCliente(Cliente cliente) {
    // Debemos hacer que la base de datos realice una consulta del nif del cliente
    // para encontrarlo, ya que este no se puede repetir
    try {
      // Debemos realizar una consulta compleja
      ObjectSet<Cliente> clientes = db.query(new Predicate<Cliente>() {
        @Override
        public boolean match(Cliente candidato) {
          return candidato.getNif().equals(cliente.getNif());
        }
      });
      // Recorremos el object set que no has devuelto buscando coincidencias, si se
      // encuentra, el programa debe fallar
      for (Cliente clienteBuscado : clientes) {
        if (!clienteBuscado.getNif().equals(cliente.getNif())) {
          throw new BaseDatosTiendaException("No existe cliente.");
        }
        // Valida los datos del cliente dados
        validarCliente(clienteBuscado);
        // Si son iguales modificamos el cliente obtenido.
        // Cambiamos su apellido
        clienteBuscado.setApellidos(cliente.getApellidos());
        // Cambiamo su dirrecion
        clienteBuscado.setDireccion(cliente.getDireccion());
        // Cambiamos su nombre
        clienteBuscado.setNombre(cliente.getNombre());
        // Cambiamos su recomendado
        clienteBuscado.setRecomendadoPor(cliente.getRecomendadoPor());
        // Si todo esta bien lo actualiza
        db.store(clienteBuscado);
      }
    } catch (Db4oIOException e) {
      System.err.printf("Error al acceder a la base de datos.");
    }
  }

  @Override
  public void deleteMotocicletaByReferencia(String referencia) throws BaseDatosTiendaException {
    // Verifica si la motocicleta existe
    Motocicleta moto = getMotocicletaByReferencia(referencia);
    if (moto == null) {
      throw new BaseDatosTiendaException("No se encontró la motocicleta con la referencia especificada");
    }

    // Metodo de confirmacion para el usuario
    boolean confirmacion = solicitarConfirmacion(
        "¿Está seguro de que desea eliminar la motocicleta con referencia " + referencia + "? (s/n)");
    if (!confirmacion) {
      consola.imprimeLinea("Eliminación cancelada.");
    } else {
      // Si el usuario confirma, procede a eliminar
      try {
        eliminarVenta(moto);
        db.delete(moto);
      } catch (Db4oIOException e) {
        System.err.printf("Error al acceder a la base de datos.");
      }
    }
  }

  @Override
  public void cerrar() {
    try {
      db.close();
    } catch (Db4oIOException e) {
      System.err.printf("Error al cerrar la base de datos.");
    }
  }

  // Metodos privados

  /**
   * Abrir la base de datos
   * 
   * @throws Si no se abre, falla. o crea una nueva.
   */
  private void abrir() {
    try {
      this.db = Db4o.openFile(ficheroBd);
    } catch (Db4oIOException e) {
      System.err.printf("Error al acceder a la base de datos.");
      cerrar();
    }
  }

  /**
   * Solicita la confirmacion al usuario con consola
   * 
   * @param mensaje
   * @return devuelve true si el usuario confirma
   */
  private boolean solicitarConfirmacion(String mensaje) {
    // Uso de la clase consola para pedir la cadena al usuario
    //He limitado que solo pueda meter un caracter, solo pueda ser s o n y en caso de introducirlo incorrecto muestre el mensaje de error
    String respuesta = consola.solicitaTexto(mensaje, 1, 1, "^[sSnN]$", "El caracter introducido no es valido.");
    // Retorna true si la respuesta es 's' o 'S'
    return respuesta.equalsIgnoreCase("s");
  }

  /**
   * Verifica si se repite en la base de datos la referencia de una motocicleta,
   * si se repite, falla
   * 
   * @param motocicleta
   */
  private void verificarMotocicletaDuplicados(Motocicleta motocicleta) {
    //if(motocicleta.getReferencia() != null) {
    try {
      // Debemos realizar una consulta compleja, ya que por prototipo no se puede
      // Debido que debemos impedir que se agregue una moto sin datos
      ObjectSet<Motocicleta> motocicletas = db.query(new Predicate<Motocicleta>() {
        @Override
        public boolean match(Motocicleta candidato) {
          return candidato.getReferencia().equals(motocicleta.getReferencia());
        }
      });
      // Recorremos el object set que no has devuelto buscando coincidencias, si se
      // encuentra, el programa debe fallar
      for (Motocicleta moto : motocicletas) {
        if (moto.getReferencia().equals(motocicleta.getReferencia())) {
          throw new IllegalArgumentException("Motocicletas duplicadas");
        }
      }
      // Si no falla, no existe duplicado
    } catch (Db4oIOException e) {
      System.err.printf("Error al acceder a la base de datos.");
    }
   // }
    //return;
  }

  /**
   * Verifica que los de una motocicleta no esten vacios a la hora de agregarla a
   * la base de datos. Si estan vacios falla
   * 
   * @param motocicleta
   */
  private void verficarCamposMotocicleta(Motocicleta motocicleta) {
    // Verificamos campo por campo
    if (motocicleta.getCilindrada() < 0 && motocicleta.getFabricante().isBlank() && motocicleta.getTipo().isBlank()
        && motocicleta.getPrecio() < 0) {
      throw new BaseDatosTiendaException("Los campos introducidos en la motocicleta son incorrectos.");
    }
  }

  /**
   * Elimina una o muchas ventas que tenga la moto
   * 
   * @param moto
   */
  private void eliminarVenta(Motocicleta moto) {
    // Buscamos en ventas la moto que coinciada con esa
    // Realizo una consulta compleja porque no se permite casos de datos nulos o
    // vacios
    ObjectSet<Venta> ventas = db.query(new Predicate<Venta>() {
      @Override
      public boolean match(Venta candidato) {
        return candidato.getMotocicleta().getReferencia().equals(moto.getReferencia());
      }
    });
    for (Venta venta : ventas) {
      // Eliminamos todas las ventas encontradas
      db.delete(venta);
    }
  }

  /**
   * Genera un codigo a partir de las ventas existentes en la base de datos
   * 
   * @return
   */
  private int generarCodigo() {
    // Hacemos una consulta a la base de datos y obtenemos todas las ventas
    ObjectSet<Venta> ventas = db.query(Venta.class);
    // Inicia en -1 por si es la primera venta que se le mete a la base de datos, ya
    // que le sumaremos 1
    int codigo = -1;
    // Por cada venta que recorre le va sumando 1
    for (Venta venta : ventas) {
      // Ve cual es el mas grande, cuando recorra todo devolvera el mas grande
      if (venta.getCodigo() > codigo) {
        codigo = venta.getCodigo();
      }
    }
    // Le sumamos 1 para amplificarlo asi es la venta nueva mas reciente
    return codigo + 1;
  }

  /**
   * Comprueba si los datos de un cliente son validos
   * 
   * @param cliente para corroborar que sus datos son validos
   */
  private void validarCliente(Cliente cliente) {
    if (cliente.getNombre().isBlank() && cliente.getApellidos().isBlank() && cliente.getDireccion().isBlank()) {
      throw new IllegalArgumentException("Los datos del cliente no son validos.");
    }
  }
}
