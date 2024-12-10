package ejercico03;

import java.util.Locale;
import java.util.Random;

public class Persona {
  
  //Ponemos el final para la opcion del char.
  
  
  /** Sexo mujer*/
  public static final char SEXO_MUJER= 'M';
 
  /** Generador limites*
   */
 private static final int LIMITE_INFERIOR = 10000000;
 private static final int LIMITE_SUPERIOR = 99999999;
 /**  Atributo de nombre*/
  private String nombre;
  
  /**  Atributo de edad*/
  private static int edad;
  
  /**  Atributo de sexo*/
  private char sexo;
  
  /**  Atributo de peso*/
  private static double peso;
  
  /**  Atributo de altura*/
  private static double altura;
  
  private String dni;
  
  /**Metodo persona */
 
  private String getDniRamdon() {
    Random generador = new Random();
    int dniNumeros = generador.nextInt(LIMITE_INFERIOR, LIMITE_SUPERIOR);
    char letra = (char)(generador.nextInt(65, 90));
    //String dniNumerosCadena = dniNumeros + "";
   // String letraCadena = letra + "";
    //String dni = dniNumerosCadena + letra;
    return dni = "" + dniNumeros + letra;
  }
  public Persona() {
    this.nombre = "";
    this.sexo = SEXO_MUJER;
    
   
  }
  public Persona(String nombre, int edad, char sexo) {
    this.nombre = nombre;
    this.edad = edad;
    this.sexo = sexo;
  }
  
  public Persona(String nombre, int edad, char sexo, double peso, double altura) {
    this.nombre = nombre;
    this.edad = edad;
    this.sexo = sexo;
    this.peso = peso;
    this.altura = altura;
  }
  
  /** Metodo nombre */
  public String getNombre() {
    return nombre;
  }
  public static int getEdad() {
    return edad;
  }
  public char getSexo() {
     char sexo = this.sexo;
    if (sexo != 'M') {
      sexo = 'H';
      return sexo;
    } else {
      return sexo;
    }
   
  }
  public static double getPeso() {
    return peso;
  }
  public static double getAltura() {
    return altura;
  }
  public double getIMC() {
    double imc = peso / (altura*altura);
    return imc;
  }
  public int getPesoCorrecto() {
    double imc = peso / (altura*altura);
    if (imc >= 17 && imc < 18) {
      int bajoPeso = -1;
      return bajoPeso;
    } else if ( imc >= 18 && imc < 25) {
      int pesoNormal = 0;
      return pesoNormal;
    } else {
      int pesoSuperior = 1;
      return pesoSuperior;
    }
  }
  public boolean esMayorDeEdad(int edad) {
    return edad >=18;
  }
  public String Stringto() {
   return "Nombre: " + getNombre() + ", Edad: " + getEdad() + ", Sexo: " + getSexo() + ", Peso: " + getPeso()  + 
  ", Altura: " + getAltura()+ ", DNI: " + getDniRamdon();
   //+ "\n" salto de linea
  }
}
