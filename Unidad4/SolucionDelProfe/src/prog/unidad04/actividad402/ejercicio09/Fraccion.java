package prog.unidad04.actividad402.ejercicio09;

/**
 * Clase que representa un numero racional (fracción)
 */
public class Fraccion {
  
  // Numerador y denominador
  private int numerador;
  private int denominador;
  
  /**
   * Crea una nueva fracción con el numerador y denominador dados
   * @param numerador Numerador de la nueva fracción
   * @param denominador Denominador de la nueva fracción (no puede ser cero)
   */
  public Fraccion(int numerador, int denominador) {
    this.numerador = numerador;
    this.denominador = denominador;
  }
  
  /**
   * Suma a esta fracción la fracción proporcionada. El resultado no estará simplificado
   * @param otra Fracción que vamos a sumar a ésta
   * @return Nueva fracción con el resultado de la suma
   */
  public Fraccion suma(Fraccion otra) {
    Fraccion resultado = new Fraccion((this.numerador * otra.denominador) + (otra.numerador * this.denominador), this.denominador * otra.denominador);
    return resultado;
  }
  
  /**
   * Resta a esta fracción la otra fracción proporcionada. El resultado no estará simplificado
   * @param otra Fracción que vamos a restar de esta
   * @return Nueva fracción con el resultado de la resta
   */
  public Fraccion resta(Fraccion otra) {
    Fraccion resultado = new Fraccion((this.numerador * otra.denominador) - (otra.numerador * this.denominador), this.denominador * otra.denominador);
    return resultado;
  }
  
  /**
   * Multiplica esta fracción por la otra que se proporciona. El resultado no se simplifica
   * @param otra Otra fracción a multiplicar con ésta
   * @return  Nueva fracción con el resultado de la multiplicación
   */
  public Fraccion multiplica(Fraccion otra) {
    Fraccion resultado = new Fraccion(this.numerador * otra.numerador, this.denominador * otra.denominador);
    return resultado;
  }

  /***
   * Divide esta fracción por la otra que se proporciona. El resultado no se simplifica
   * @param otra Otra fracción que dividirá a ésta
   * @return Nueva fracción con el resultado de la división
   */
  public Fraccion divide(Fraccion otra) {
    Fraccion resultado = new Fraccion(this.numerador * otra.denominador, this.denominador * otra.numerador);
    return resultado;
  }
  
  /**
   * Simplifica la fracción. Al terminar la fracción estará reducida a su forma canónica
   */
  public void simplifica() {
    // Vamos probando factores a ver si dividen al numerador y al denominador (a ambos a la vez)
    // Si un factor vale, se volverá a intentar
    
    // Factor por el que comenzamos
    int factor = 2;
    // Mientras el factor sea menor que el numerador y el denominador
    while ((factor <= numerador) && (factor <= denominador)) {
      // Si se pueden dividir ambos por el factor
      if ((numerador % factor == 0) && (denominador % factor == 0)) {
        // Se dividen
        numerador /= factor;
        denominador /= factor;
      } else {
        // Este factor no vale, probamos el siguiente
        factor++;
      }
    }
  }

  /**
   * Obtiene el valor del numerador
   * @return Valor del numerador
   */
  public int getNumerador() {
    return numerador;
  }

  /**
   * Obtiene el valor del denominador
   * @return Valor del denominador
   */
  public int getDenominador() {
    return denominador;
  }
  
  /**
   * Obtiene una cadena con la representación de la fracción en la forma numerador / denominador
   * @return Representacion en cadena de la fraccion
   */
  public String toString() {
    return getNumerador() + " / " + getDenominador(); 
  }
  
}
