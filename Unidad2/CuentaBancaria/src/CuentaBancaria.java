import java.util.Locale;
import java.util.Scanner;

public class CuentaBancaria {
  
  
  public static void main(String[] args) {
    
    CuentaCorriente cuenta = new CuentaCorriente ("11111");

    cuenta.ingresar(1000);
    System.out.printf(Locale.US, "El saldo es de %f%n", cuenta.getSaldo());
    
    cuenta.retirar(1100);
    System.out.printf(Locale.US, "El saldo es de %f%n", cuenta.getSaldo());
    
    cuenta.retirar(900);
    System.out.printf(Locale.US, "El saldo es de %f%n", cuenta.getSaldo());
    cuenta.retirar(100);
    System.out.printf(Locale.US, "El saldo es de %f%n", cuenta.getSaldo());
    cuenta.ingresar(350);
    System.out.printf(Locale.US, "El saldo es de %f%n", cuenta.getSaldo());
    cuenta.retirar(450);
     System.out.printf(Locale.US, "El saldo es de %f", cuenta.getSaldo());
    
     
    
    
  }
}
