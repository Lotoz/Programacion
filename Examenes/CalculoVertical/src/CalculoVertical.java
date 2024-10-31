import java.util.Locale;
import java.util.Scanner;


public class CalculoVertical {

//Agregamos las constantes que vamos a utilizar

public static final double GRAVEDAD = 9.8;
public static final double METRO_A_PIES = 3.28;

public static void main(String[] args) { 
  
//Insertamos una cabecera estetica

System.out.println("EXAMEN DE Zamira Grippi. CALCULO DE LANZAMIENTO VERTICAL");
System.out.println("--------------------------------------------------------");

//Este print es meramente estetico, es para dejar un espacio y que no se acople todo
System.out.println("");

//Insertamos un scanner para poder solicitarle los datos al usuario

Scanner sc = new Scanner(System.in);

//Le solicitamos al usuario que inserte la velocidad inicial

System.out.print("Introduzca la velocidad inicial del objeto (en m/s):");
double velocidadInicial = Double.parseDouble(sc.nextLine());

//Calculamos el tiempo por medio de la siguiente formula

double tiempo = velocidadInicial / GRAVEDAD;

//Calculamos la altura con la siguiente formula

double altura = velocidadInicial * tiempo - ((GRAVEDAD * tiempo * tiempo) /2);

//Insertamos una salida para que el usuario puede ver la altura calculada

System.out.printf(Locale.US, "La altura máxima en metros es de %f", altura);

//Calculamos la conversion

double conversionPies = altura * METRO_A_PIES; 

//Debemos pasar el double a int para que se vuelva decimal a entero

int pies = (int) (conversionPies); 

//Este print es meramente estetico, es para dejar un espacio y que no se acople todo
System.out.println("");

//Imprimimos el resultado

System.out.printf(Locale.US, "Esta altura equivale a %d pies", pies);

//Este print es meramente estetico, es para dejar un espacio
System.out.println("");

//E imprimimos el tiempo ya previamente calculado

System.out.printf(Locale.US, "El tiempo necesario es %f segundos", tiempo);
  
  }  
}
