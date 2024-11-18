import java.util.Scanner;

public class MedidorDeRiesgo {
  
  public static void main(String[] args) { 
	  
	    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
	    System.out.println("    Medidor de riesgo    ");
	    System.out.println("    V.3.4                 ");
	    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
	  
    Scanner scan = new Scanner(System.in);
    
    System.out.printf("Introduce 1 si tu riesgo esta relacionado con IP:%n");
    System.out.printf("Introduce 2 si tu riesgo esta relacionado con Entorno de desarollo:%n");
    System.out.printf("Introduce 3 si tu riesgo esta relacioando con Programacion.%n");
    System.out.printf("Introduce 4 si tu riesgo esta relacionado con Sistemas Informaticos.%n");
    System.out.printf("Introduce 5 si tu riesgo esta relacionado con Base de Datos.%n");
    System.out.printf("Introduce 6 si tu riesgo esta relacionado con Sostenibilidad.%n");
    System.out.printf("Introduce 7 si tu riesgo esta relacionado con Digitalizacion.%n");
    System.out.printf("Introduce 8 si tu riesgo esta relacionado con Lenguaje de Marcas.%n");

    int riesgo1  = Integer.parseInt(scan.nextLine());
    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
     
    //Cambiar esto por switch, pero aqui estan las opciones
    if ( riesgo1 == 1) {
      
      System.out.println("Has elegido IP");
      
      } 
    
     else if ( riesgo1 == 2) {
       
      System.out.printf("Has elegido Entorno de desarollo.%n");
      
    }
  if ( riesgo1 == 3) {
      
      System.out.printf("Has elegido Programacion.%n");
      
      } 
  else if ( riesgo1 == 4) {
    
    System.out.printf("Has elegido Sistemas Informaticos.%n");
    
    } 
  if ( riesgo1 == 5) {
    
    System.out.printf("Has elegido Base de Datos.%n");
    
    } 
  else if ( riesgo1 == 6) {
    
    System.out.printf("Has elegido Sostenibilidad.%n");
    
    } 
  if ( riesgo1 == 7) {
    
    System.out.printf("Has elegido Digitalizacion.%n");
    
    } 
  else if ( riesgo1 == 8) {
    
    System.out.printf("Has elegido Lenguaje de Marcas.%n");
    
    } 
  
   //Riesgos pa. Agregar limitador de numeros por si alguien esta loco
  
    System.out.println("Dime de cuanto es tu riesgo: Del 1 al 10");
    int nivel1  = Integer.parseInt(scan.nextLine());
    System.out.println("Analizando el riesgo...");
    
   if ( nivel1 <= 3) {
     System.out.println("El riesgo es soportable.");
   } 
   else if (nivel1 <=4) { 
     System.out.println("El riesgo es moderado.");  
   } 
   else if ( nivel1 <= 7) {
     System.out.println("El riesgo es consideradamente alto.");  
   } if ( nivel1 == 10) {
     System.out.println("El riesgo es demasiado alto, abandona soldado.");
   } 
   else { 
     System.out.println("Systax error. El riesgo es demasiado.");
     System.out.println("Ejecutando autodestruccion...3..2..1...");
   }
   System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
  }
}
