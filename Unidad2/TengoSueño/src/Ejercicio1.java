import java.util.Locale;

public class Ejercicio1 {

  public static void main(String[] args) {

    // Insertamos un encabezado estetico
    System.out.println("Ejercicio 1 de personas");
    System.out.printf("=-=-=-=-=-=-=-=-=-=-=-=%n");

    // Insertamos el objeto persona1 e ingresamos los valores usando las librerias
    // dadas por el profesor
    Persona persona1 = new Persona();
    persona1.edad = 25;
    persona1.peso = 75.4;
    persona1.numeroHijos = 0;

    // Insertamos el objeto persona2 e ingresamos los valores usando las librerias
    // dadas por el profesor
    Persona persona2 = new Persona();
    persona2.edad = 65;
    persona2.edad = 65;
    persona2.numeroHijos = 3;
    
    //insertamos un boolean para ver si son el mismo objeto
    boolean dondeApuntanVariables = persona1 == persona2;

    // Imprimimos la salida de cada persona
    System.out.printf(Locale.US, "Persona tiene %d años. pesa %f y tiene %d hijos%n", persona1.edad, persona1.peso,
        persona1.numeroHijos);
    System.out.printf(Locale.US, "Persona tiene %d años. pesa %f y tiene %d hijos %n", persona2.edad, persona2.peso,
        persona2.numeroHijos);
    System.out.printf("Apuntan al mismo objeto? %b", dondeApuntanVariables);
    
    //Creamos otra persona
    Persona persona3 = new Persona();
    persona3.edad = 33;
    persona3.peso = 80.43;
    persona3.numeroHijos = 1;
    persona3.peso = 79.65; 
    
    System.out.printf(Locale.US, "Persona tiene %d años. pesa %f y tiene %d hijos %n", persona2.edad, persona2.peso,
        persona2.numeroHijos);
  }

}
