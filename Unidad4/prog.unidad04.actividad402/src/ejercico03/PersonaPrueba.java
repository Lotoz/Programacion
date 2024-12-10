package ejercico03;

public class PersonaPrueba {

  public static void main(String[] args) {
    
    Persona persona1 = new Persona();
    
    System.out.println("Persona 1: "  + persona1.Stringto());
    
    Persona persona2 = new Persona("Jose", 20, 'H');
    System.out.println("Persona 2: " + persona2.Stringto());
    
    //Persona persona3 = new Persona("Maria", 24, 'M', 75.6, 1.55);
    //System.out.println("Persona 3: " + persona3.Stringto());
    
    System.out.println("IMC DE LAS TRES PERSONAS");
    System.out.println("IMC Persona 1: " + persona1.getIMC());
    System.out.println("IMC Persona 2: " + persona2.getIMC());
    //System.out.println("IMC Persona 3: " + persona3.getIMC());
    
    System.out.println("Imprimimos si los pesos de las personas es correcto o no.");
    System.out.println("Peso correcto Persona1: " + persona1.getPesoCorrecto());
    System.out.println("Peso correcto Persona2: " + persona2.getPesoCorrecto());
   // System.out.println("Peso correcto Persona3: " + persona3.getPesoCorrecto());

    System.out.println("Son las personas mayores de edad?");

    System.out.println("Persona 1: " + persona1.esMayorDeEdad(20));
    //System.out.println("Persona 3: " + persona3.esMayorDeEdad());
  }
}
//perder miedo a los booleanos xd