

	import java.util.Scanner;
	import java.util.Locale;
public class R01E14 {

 public static void main(String[] args) {
	    
	  // Hacemos una cabecera estetica
	 
	   System.out.println("><~><~><~><~><~><~><~><~><~><");
	   
	    System.out.println("Calcula la nota que te salvara el trimestre :D");
	    		
	    System.out.println("><~><~><~><~><~><~><~><~><~><");
	    
	 
	    // Insertamos un scanner para tomar lo que ingrese el usuario
	    
	    Scanner scan = new Scanner(System.in);

	    // Solicitamos  las notas del primer examen y la nota que se desearia obetener de media, todo por scan.
	    
	    System.out.print("Cual es la nota de tu primer examen? ");
	    
	    double nota_primer_examen= Double.parseDouble(scan.nextLine());
	    
	    System.out.print("Cual es la nota que deseas obtener de media?");
	    
       double nota_deseada = Double.parseDouble(scan.nextLine());
	    
	    // Calcula la nota necesaria que deberia  obetener en el siguiente examen
	    
	    double segundo_examen_nota = nota_deseada * 2 - nota_primer_examen;
	    
	    // Reflejamos el resultado por pantalla
	    
	    System.out.printf(Locale.US, "Para obtener la media de %f, tendrias que tener de nota en el segundo examen un %f", nota_deseada, segundo_examen_nota);
	 
 
 		}
	}

