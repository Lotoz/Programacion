package prog.ud09.actividad903.comandos.impl;

import prog.common.consola.Consola;
import prog.ud09.actividad903.comandos.ProcesadorListadoVentas;
import prog.unidad09.relacion03.datos.Venta;
/**
 * terminar los comentarios de titulo de cada clase y terminar de implentar el imprimir
 */
public class ProcesadorListadosVentasExamen implements ProcesadorListadoVentas {

  @Override
  public void imprimeCabecera(Consola consola) {
   //Creamos la cabecera con StringFormat
    //String cabecera = String.format("%9s1 %10s %41s %57s %77s %s %s", "NIF","Apellidos,Nombre", "Referencia", "Fabricante", "Cilind", 
    // "Precio", "Fecha Venta");
    //consola.imprime(cabecera);
  }

  @Override
  public void imprimeLinea(Consola consola, Venta venta) {
    // TODO Auto-generated method stub

  }

}
