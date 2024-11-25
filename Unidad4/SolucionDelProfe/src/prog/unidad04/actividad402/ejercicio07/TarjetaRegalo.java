package prog.unidad04.actividad402.ejercicio07;

import java.util.Random;

/**
 * Representa una tarjeta de regalo de Manego
 */
public class TarjetaRegalo {
  
  // Saldo de la tarjeta
  private double saldo;
  
  // Número identificativo
  private String numeroIdentificativo;
  
  /**
   * Crea una nueva tarjeta con el saldo indicado y un nuevo número identificativo
   * @param saldo Saldo de la nueva tarjeta
   */
  public TarjetaRegalo(double saldo) {
    // Almacenamos el saldo
    this.saldo = saldo;
    // Generamos el nuevo número identificativo
    this.numeroIdentificativo = generaNumeroIdentificativo();
  }
  
  /**
   * Gasta la cantidad indicada de la tarjeta regalo, si es que hay saldo suficiente<br>
   * Si no hay saldo suficiente se muestra un error y no se hace nada.
   * @param cantidad Cantidad a gastar
   */
  public void gasta(double cantidad) {
    // Si la cantidad es menor o igual que el saldo
    if (cantidad <= saldo) {
      // Actualiza el saldo restando la cantidad gastada
      saldo -= cantidad;
    } else {
      // Si el saldo es insuficiente
      // No hace nada y muestra un error
      System.out.println("Error. No se puede gastar ese importe porque la tarjeta tiene un saldo inferior");
    }
  }
  
  /**
   * Crea una nueva tarjeta regalo fusionando dos existentes.<br>
   * Las tarjetas existentes se quedan a saldo cero.
   * @param otra Otra tarjeta a fusionar con ésta
   * @return Nueva tarjeta cuyo saldo es la suma del de las dos tarjetas
   */
  public TarjetaRegalo fusionaCon(TarjetaRegalo otra) {
    // Creamos la nueva tarjeta con nuevo número y saldo combinado
    TarjetaRegalo nueva = new TarjetaRegalo(saldo + otra.saldo);
    // Ponemos los saldos de las dos tarjetas fusionadas a cero
    saldo = 0;
    otra.saldo = 0;
    // Devolvemos la nueva tarjeta
    return nueva;
  }
  
  /**
   * Obtiene una representación imprimible del contenido de la tarjeta en formato<br>
   * <code>Tarjeta nº NNNNN - Saldo DDDDD€</code><br>
   * donde <code>NNNNNN</code> es el número identificativo de la tarjeta y <code>DDDD</code> el saldo
   * @return Representación imprimible de la tarjeta
   */
  public String toString() {
    return "Tarjeta nº " + numeroIdentificativo + " - Saldo " + saldo + "€";
  }

  /**
   * Genera un nuevo número identificativo de cinco dígitos
   * @return Nuevo número identificativo de 5 dígitos
   */
  private String generaNumeroIdentificativo() {
    // Usamos un generador Random
    Random generador = new Random();
    int numero = generador.nextInt(0, 100000);
    // Devolvemos el número convertido en cadena usando String.format
    return String.format("%05d", numero);
  }

}
