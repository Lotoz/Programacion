import java.util.Locale;

public class r01e03 {
  
  public static final double IVA = 0.21;
  
  public static void main(String[] args) {
  double precio = 12.13 ;
 double factura = precio * (1 + IVA);
 
 System.out.printf(Locale.US, "Al aplicar un IVA del %f a la base %f obtenemos un total de %f%n", (IVA * 100), precio, factura);

  }
}
