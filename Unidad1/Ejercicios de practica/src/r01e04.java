
public class r01e04 {
  public static void main(String[] args) {
    //Se coloca un numero comun
    int numero = 73;
    
    //Es par si se puede dividir por 2, por ende hacemos eso
    boolean par = (numero % 2) == 0;
    
    //imprimimos el resultado
    System.out.printf("¿Es el número %d par?: %b%n", numero, par);
    
  }
}
