package prog.ud09.actividad903.comandos.impl;

import java.util.Locale;

import prog.common.consola.Consola;
import prog.ud09.actividad903.comandos.ProcesadorListadoVentas;
import prog.unidad09.relacion03.datos.Venta;

/**
 * Imprime un listado de ventas por pantalla, implementando Procesador de ventas
 * y usando la clase consola
 */
public class ProcesadorListadosVentasExamen implements ProcesadorListadoVentas {

  @Override
  public void imprimeCabecera(Consola consola) {
      // Creamos la cabecera con StringFormat
      String cabecera = String.format("%-9s %-31s %-16s %-20s %9s %9s %12s%n", "NIF", "Apellidos, Nombre", "Referencia",
          "Fabricante", "Cilind.", "Precio", "Fecha Venta");
      //Con la clase consola imprimo la cabecera
      consola.imprime(cabecera);
  }

  @Override
  public void imprimeLinea(Consola consola, Venta venta) {
      // Creamos el nombre completo de la persona para imprimirlo con mayor comodidad
      String nombreCompleto = venta.getCliente().getApellidos() + ", " + venta.getCliente().getNombre();

      // Creamos un string format para imprimir la venta
      String linea = String.format(Locale.US,"%-9s %-31s %-16s %-20s %9d %10.2f %10s%n", 
          venta.getCliente().getNif(),
          nombreCompleto, 
          venta.getMotocicleta().getReferencia(), 
          venta.getMotocicleta().getFabricante(),
          venta.getMotocicleta().getCilindrada(), 
          venta.getMotocicleta().getPrecio(), 
          venta.getFecha());
      // Imprimimos la linea
      consola.imprime(linea);
  }
}
