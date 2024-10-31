	import java.util.Scanner;
	import java.util.Locale;

public class R01E29Remaster {

	  // Colocamos los rangos como constantes que van a definir nuestros limites
  
	  public static final int RANGO_MINIMO = 20;
	  public static final int RANGO_MAXIMO = 30;
	  
	  public static void main(String[] args) {
		  
	    Scanner scan = new Scanner(System.in);

	    // Cabecera
	    
	    System.out.println("Intentando hacer que ande int");
	    System.out.println("-------------------------------------------------------------------------------------");
	    
	    // Solicitamos un numero
	    
	    System.out.print("Give me a number,  please be a number entero");
	    int numero  = Integer.parseInt(scan.nextLine());
	    
	    // Comprobamos que este en el rango pedido
	    
	    boolean rango = numero>= RANGO_MINIMO && numero <= RANGO_MAXIMO;
	    
	    // imprimimos el resultado
	    
	    System.out.printf(Locale.US, "¿Está el número %d comprendido entre %d y %d (sin incluir %d)?: %b%n", numero, RANGO_MINIMO, RANGO_MAXIMO, RANGO_MAXIMO, rango);
	  
	    //SOLUCION DEL ERROR SI USAS INT SI O SI %d , SI ES DOUBLE %f 
	  }
}

