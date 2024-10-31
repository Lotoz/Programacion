package prog.unidad3.seleccion;
import java.util.Scanner;
import java.util.Locale;

public class CalculaIMCApp {
  

  public static void main(String[] args) { 
    
    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
    System.out.println("    Calculadora de IMC  ");
    System.out.println("        V.1.0            ");
    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
    
    //Luego de ingresar el cabezal mas fachero de la historia, introducimos un scan pidiendo los datos
    Scanner scan = new Scanner(System.in);
    
    //Ahora pedimos los datos, el peso sera int y la altura double
    System.out.printf("Introduce tu peso (en kg):%n");
    int peso = Integer.parseInt(scan.nextLine());
    
    System.out.printf("Introduce tu altura (en metros):%n");
    double altura = Double.parseDouble(scan.nextLine());
    
    double imc = peso / (altura*altura);
     
    if (imc < 16) {
      System.out.printf(Locale.US,"Tu IMC es de:%f%n",imc);
      System.out.printf("Bro, has pensado en hacer cosplay de Sans o Papyrus?%n");
      System.out.printf("Ingreso al hospital por infrapeso%n");
    } 
    else if (imc >= 16 && imc < 17 ) {
      System.out.printf(Locale.US,"Tu IMC es de:%f%n",imc);
      System.out.printf("Tu peso es como el inframundo, esta infrapeso (Badampus)%n");
      System.out.printf("Infrapeso%n");
    }
    else if (imc >= 17 && imc < 18) {
      System.out.printf(Locale.US,"Tu IMC es de:%f%n",imc);
      System.out.printf("Peso hobbit, ulala señor frances, Bajo peso.%n");
      System.out.printf("Bajo peso%n");
    }
    else if (imc >= 18 && imc < 25) {
      System.out.printf(Locale.US,"Tu IMC es de:%f%n",imc);
      System.out.printf("Tas bien, sos un normi, es decir, Peso normal %n");
      System.out.printf("Peso normal%n");
    }
    else if (imc >= 25 && imc < 30) {
      System.out.printf(Locale.US,"Tu IMC es de:%f%n",imc);
      System.out.printf("Ya estas medio pachoncho, pero sigues bien, ve considerando dieta%n");
      System.out.printf("Sobrepeso, Obesidad grado I%n");
    }
    else if (imc >= 30 && imc < 35) {
      System.out.printf(Locale.US,"Tu IMC es de:%f%n",imc);
      System.out.printf("La dieta es necesaria.%n");
      System.out.printf("Sobrepeso crónico, Obesidad de grado II%n");
    }
    else if (imc >= 35 && imc < 40) {
      System.out.printf(Locale.US,"Tu IMC es de:%f%n",imc);
      System.out.printf("Bro, has pensado en hacer cosplay de Feminazi? %n");
      System.out.printf("Obesidad premórbida, Obesidad de grado III%n");
    }
    else {
      System.out.printf(Locale.US,"Tu IMC es de:%f%n",imc);
      System.out.printf("Mi pana la vida es corta, pero mas la tuya.");
      System.out.printf("Obesidad mórbida, Obesidad grado IV%n");
    }
  
  }
}