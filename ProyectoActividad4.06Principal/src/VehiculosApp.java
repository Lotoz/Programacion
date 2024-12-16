import java.time.LocalDate;
import java.util.Scanner;

import prog.unidad04.practica406.libreria.*;


public class VehiculosApp {

  public static void main(String[] args) throws Exception {
    // Esta clase sirve para trabajar con la biblioteca .jar
    // y probar, cuando se finalice probar aca.
    //Completar todo

    // Creamos un scan para tomar los datos del usuario.
    Scanner scan = new Scanner(System.in);

    // Cabezal estetico
    System.out.printf("PRÁCTICA DE Zamira Grippi. GESTIÓN VEHÍCULOS.%n");
    System.out.printf("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=%n");

  
     Fecha fechaAuto = null;
    Automovil auto = null;
    boolean salida = false;
    do {
      try {
        // Le pedimos al usario que introduzca la matricula del automovil 
        System.out.printf(
            "Introduce la matrícula del automóvil (4 números, 0 ó más espacios\n" + "y tres letras mayúsculas):%n");
        String matricula1 = scan.next();

        // Pedimos el dia de la fecha de matriculacion 
        System.out.printf("Introduzca el día de la fecha de matriculación del automóvil:%n");
        int dia1 = scan.nextInt();

        // Pedimos el mes de la fecha de matr1iculacion 
        System.out.printf("Introduzca el mes de la fecha de matriculación del automóvil:%n");
        int mes1 = scan.nextInt();

        // Pedimos el año de la fecha de matriculacion 
        System.out.printf("Introduzca el año de la fecha de matriculación del automóvil:%n");
        int anyo1 = scan.nextInt();

        // Pedimos el color 
        System.out.printf("Introduzca el color del automóvil (blanco, negro o azul):%n");
        String color = scan.next();

        // Pedimos el numero de plazas del vehiculo
        System.out.printf("Introduzca el número de plazas del vehículo (1 ó mas):%n");
        int plazas = scan.nextInt();

        fechaAuto = new Fecha(dia1, mes1, anyo1);
        auto = new Automovil(matricula1, fechaAuto, color, plazas);
        salida = true;
      } catch (NullPointerException e) {
        System.out.printf("Fecha invalida,introduce una fecha correcta de nuevo.%n");
      } catch (IllegalArgumentException e) {
        System.out.printf("Los datos del automovil son incorrectos, intenta de nuevo.%n");
      } 
    } while (!salida);
    
    Fecha fechaMoto = null;
    Motocicleta moto = null;
    do {
      try {
        // Pedimos la matricula de la moto 
        System.out.printf(
            "Introduce la matrícula del motocicleta (4 números, 0 ó más espacios " + "y tres letras mayúsculas):%n");
        String matricula2 = scan.next();

        // Pedimos el dia de la fecha de matriculacion0
        System.out.printf("Introduzca el día de la fecha de matriculación de la motocicleta:%n");
        int dia2 = scan.nextInt();
        // Pedimos el mes de la fecha de matriculacion

        System.out.printf("Introduzca el mes de la fecha de matriculación de la motocicleta:%n");
        int mes2 = scan.nextInt();
        // Pedimos el año de la fecha de matriculacion
        System.out.printf("Introduzca el año de la fecha de matriculación de la motocicleta:%n");
        int anyo2 = scan.nextInt();
        // Pedimos las cilindradas
        System.out.printf("Introduzca la cilindrada de la motocicleta (50 ó mas):%n");
        int cilindrada = scan.nextInt();

        fechaMoto = new Fecha(dia2, mes2, anyo2);
        moto = new Motocicleta(matricula2, fechaMoto, cilindrada);
        salida = true;
      } catch (NullPointerException e) {
        System.out.printf("Fecha invalida,introduce una fecha correcta de nuevo.");
      } catch (IllegalArgumentException e) {
        System.out.printf("Los datos de la moto son incorrectos, intenta de nuevo. ");
      } 
    } while (!salida);
  
     //Creamos los objetos
 
    // Con la clase LocalDate obtenemos la fecha actual
    LocalDate fechaActual = LocalDate.now();

    // Extraemos el año, mes y día de la fecha actual
    int anyoActual = fechaActual.getYear();
    int mesActual = fechaActual.getMonthValue();
    int diaActual = fechaActual.getDayOfMonth();
    
    //Creamos un nuevo objeto
    Fecha fechaComparar = new Fecha(diaActual, mesActual, anyoActual);
    
     // Imprimimos los datos del automovil
     System.out.printf("Los datos del automovil son %s%n", auto.toString());
     System.out.printf("Su distintivo ambiental es %s%n", auto.getDistintivo());
     

     // Imprimos los datos de la moto
     System.out.printf("Los datos de la moto son %s%n", moto.toString());
     System.out.printf("Su distintivo ambiental es %s%n", moto.getDistintivo());
         
   // Imprimimos cuanto llevan matriculados
   System.out.printf("El automóvil lleva matriculado %d %n", fechaAuto.diasEntre(fechaComparar));
   System.out.printf("El motocicleta lleva matriculado %d %n", fechaMoto.diasEntre(fechaComparar));

   //Comparar fechas
   int resultado = fechaAuto.compara(fechaMoto);
   System.out.printf("%s%n", comparaVehiculos(resultado));
 
   // Imprimimos los vehiculos existentes
   System.out.printf("Número de vehículos matriculados: %d ", Vehiculo.getVehiculosMatriculados());
    
  }
  
  private static String comparaVehiculos(int resultado) {   
   if (resultado < 0) {
       return "El automovil se matriculo antes que la motocicleta";
   } else if (resultado > 0) {
      return "La motocicleta se matriculo antes que el vehiculo";
   } else {
       return "Son iguales";
   }
 }
  
}
