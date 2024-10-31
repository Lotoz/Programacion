import java.util.Locale;
import java.util.Scanner;

public class R01E18 {
  
  //Agregamos constantes
  public static final double PORCENTAJE_DE_PROMEDIO = 0.55;
  public static final double CALIFICACION_EXAMEN_PORCENTAJE = 0.30;
  public static final double CLACIFICACIOM_TRABAJO_PORCENTAJE = 0.15;
  
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
   
// Insertamos una cabecera estetica
    
    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
    System.out.println("Calculadora de notas B)");
    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
    
  
    //Pedimos los datos por terminal
    
    System.out.print("Introduzca la nota de la unidad 1: ");
    double notaUnidad1 = Double.parseDouble(sc.nextLine());
    
    System.out.print("Introduzca la nota de la unidad 2: ");
    double notaUnidad2 = Double.parseDouble(sc.nextLine()); 
    
    System.out.print("Introduzca la nota de la unidad 3: ");
    double notaUnidad3 = Double.parseDouble(sc.nextLine()); 
    
    System.out.print("Introduzca la nota del examen final del trimestre: ");
    double notaExamen = Double.parseDouble(sc.nextLine());
    
    System.out.print("Introduzca la nota del trabajo expuesto en clase: ");
    double notaTrabajo = Double.parseDouble(sc.nextLine());
    
    //Insertamos las formulas de calculo para obtener los resultados deseados
    
    double promdioNota = (notaUnidad1 + notaUnidad2 + notaUnidad3) /3 ; 
    double resultadoNotaExamen = notaExamen * CALIFICACION_EXAMEN_PORCENTAJE;
    double resultadoNotaPromedio = promdioNota * PORCENTAJE_DE_PROMEDIO;
    double resultadoNotaTrabajo = notaTrabajo * CLACIFICACIOM_TRABAJO_PORCENTAJE;
    double notaEvaluacion = resultadoNotaTrabajo + resultadoNotaExamen + resultadoNotaPromedio;
    
    //Imprimimos resultado
    
    System.out.printf(Locale.US, "La nota de la evaluacion es de %f", notaEvaluacion);
  }
}
