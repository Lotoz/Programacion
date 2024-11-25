package prog.unidad04.actividad402.ejercicio04;

/**
 * Clase que representa una lavadora
 */
public class Lavadora {

  // Colores válidos
  public static final String COLOR_BLANCO = "blanco";
  public static final String COLOR_NEGRO = "negro";
  public static final String COLOR_ROJO = "rojo";
  public static final String COLOR_AZUL = "azul";
  public static final String COLOR_GRIS = "gris";
  
  // Letra mínima y máxima de consumo
  private static final char CONSUMO_MINIMO = 'A';
  private static final char CONSUMO_MAXIMO = 'F';
  
  // Valores por defecto
  private static final double DEFECTO_PRECIO_BASE = 200;
  private static final String DEFECTO_COLOR = COLOR_BLANCO;
  private static final char DEFECTO_CONSUMO_ENERGETICO = CONSUMO_MAXIMO;
  private static final double DEFECTO_PESO = 15;
  private static final double DEFECTO_CARGA = 5;
  
  // Plus de precio por consumo energetico
  private static final double PRECIO_CONSUMO_A = 100;
  private static final double PRECIO_CONSUMO_B = 80;
  private static final double PRECIO_CONSUMO_C = 60;
  private static final double PRECIO_CONSUMO_D = 50;
  private static final double PRECIO_CONSUMO_E = 30;
  private static final double PRECIO_CONSUMO_F = 10;
  
  // Tramos de peso y el plus de precio de cada uno
  private static final double PESO_TRAMO_1 = 20;
  private static final double PESO_TRAMO_2 = 50;
  private static final double PESO_TRAMO_3 = 80;
  private static final double PRECIO_PESO_TRAMO_1 = 10;
  private static final double PRECIO_PESO_TRAMO_2 = 50;
  private static final double PRECIO_PESO_TRAMO_3 = 80;
  private static final double PRECIO_PESO_TRAMO_4 = 100;

  // Limite de carga y el plus de precio 
  private static final double LIMITE_CARGA = 30;
  private static final double PRECIO_EXCESO_CARGA = 50;
  
  // Precio base 
  private double precioBase;
  // Color
  private String color;
  // Consumo energético
  private char consumoEnergetico;
  // Peso
  private double peso;
  // Carga maxima
  private double carga;
  
  /**
   * Constructor por defecto. Usa los valores por defecto:<br>
   * <ul>
   * <li>precioBase = 200</li>
   * <li>color = "blanco"</li>
   * <li>consumoEnergetico = 'F'</li>
   * <li>peso = 15</li>
   * <li>carga = 5</li>
   * </ul>
   */
  public Lavadora() {
    this(DEFECTO_PRECIO_BASE, DEFECTO_COLOR, DEFECTO_CONSUMO_ENERGETICO, DEFECTO_PESO, DEFECTO_CARGA);
  }

  /**
   * Constructor con precio y peso<br>
   * Para el resto usa los valores por defecto:
   * <ul>
   * <li>color = "blanco"</li>
   * <li>consumoEnergetico = 'F'</li>
   * <li>carga = 5</li>
   * </ul>
   * @param precioBase Precio base de la nueva lavadora (no debería ser menor de cero)
   * @param peso Peso de la nueva lavadora (no debería ser cero o menor)
   */
  public Lavadora(double precioBase, double peso) {
    this(precioBase, DEFECTO_COLOR, DEFECTO_CONSUMO_ENERGETICO, peso, DEFECTO_CARGA);
  }

  /**
   * Constructor con todos los valores
   * @param precioBase Precio base. No debería ser menor de cero
   * @param color Color. Debería ser uno de "blanco", "negro", "azul", "rojo", "gris"
   * @param consumoEnergetico Consumo energético. Debería ser una letra entre la 'A' y la 'F', ambas incluidas
   * @param peso Peso. Debería ser mayor de cero
   * @param carga Carga máxima de la lavadora. Debería ser mayor de cero
   */
  public Lavadora(double precioBase, String color, char consumoEnergetico, double peso, double carga) {
    if (precioBase < 0) {
      System.out.println("Error. Precio base no válido");
    }
    this.precioBase = precioBase;
    if (!color.equals(COLOR_BLANCO) && !color.equals(COLOR_NEGRO) && !color.equals(COLOR_ROJO)
        && !color.equals(COLOR_AZUL) && !color.equals(COLOR_GRIS)) {
      System.out.println("Error. El color proporcionado no es válido");
    }
    this.color = comprobarColor(color);
    if ((consumoEnergetico < CONSUMO_MINIMO) || (consumoEnergetico > CONSUMO_MAXIMO)) {
      System.out.println("Error. Consumo energético no válido");
    }
    this.consumoEnergetico = comprobarConsumo(consumoEnergetico);
    if (peso <= 0) {
      System.out.println("Error. Peso es cero o menor");
    }
    this.peso = peso;
    if (carga <= 0) {
      System.out.println("Error. Carga es cero o menor");
    }
    this.carga = carga;
  }

  /**
   * Obtiene el precio base de la lavadora
   * @return Precio base de la lavadora
   */
  public double getPrecioBase() {
    return precioBase;
  }

  /**
   * Obtiene el color de la lavadora
   * @return color de la lavadora
   */
  public String getColor() {
    return color;
  }

  /**
   * Obtiene el consumo energético de la lavadora
   * @return Consumo energético de la lavadora
   */
  public char getConsumoEnergetico() {
    return consumoEnergetico;
  }

  /**
   * Obtiene el peso de la lavadora
   * @return Peso de la lavadora
   */
  public double getPeso() {
    return peso;
  }

  /**
   * Obtiene la carga máxima de la lavadora
   * @return Carga máxima de la lavadora
   */
  public double getCarga() {
    return carga;
  }
  
  /**
   * Obtiene el precio final de la lavadora.<br>
   * El precio final se obtiene sumando al precio base un plus según el consumo
   * energético, el peso y la carga máxima
   * @return Precio final de la lavadora
   */
  public double getPrecioFinal() {
    // Precio inicial es el precio base
    double precio = precioBase;
    // Añadimos el plus por el consumo energético
    switch (consumoEnergetico) {
      case 'A':
        precio += PRECIO_CONSUMO_A;
        break;
      case 'B':
        precio += PRECIO_CONSUMO_B;
        break;
      case 'C':
        precio += PRECIO_CONSUMO_C;
        break;
      case 'D':
        precio += PRECIO_CONSUMO_D;
        break;
      case 'E':
        precio += PRECIO_CONSUMO_E;
        break;
      case 'F':
        precio += PRECIO_CONSUMO_F;
        break;
      default:
        System.out.printf("Error. Consumo energético no válido (%c)%n", consumoEnergetico);
        break;
    }
    
    // Añadimos el plus por peso
    if (peso < PESO_TRAMO_1) {
      precio += PRECIO_PESO_TRAMO_1;
    } else if ((peso >= PESO_TRAMO_1) && (peso < PESO_TRAMO_2)) {
      precio += PRECIO_PESO_TRAMO_2;
    } else if ((peso >= PESO_TRAMO_2) && (peso < PESO_TRAMO_3)) {
      precio += PRECIO_PESO_TRAMO_3;
    } else {
      precio += PRECIO_PESO_TRAMO_4;
    }
    
    // Y por último añadimos plus por carga
    if (carga > LIMITE_CARGA) {
      precio += PRECIO_EXCESO_CARGA;
    }
    
    // Devuelve el precio final
    return precio;
  }
  
  /**
   * Comprueba que la letra correspondiente al consumo sea válida y si no
   * lo es devuelve la letra por defecto
   * @param letra Letra correspondiente al consumo 
   * @return La misma letra, si es válida o la letra 'F' (por defecto) si no lo es
   */
  private char comprobarConsumo(char letra) {
    // Si es válida (sin incluir al valor por defecto)
    if ((letra >= 'A') && (letra <= 'E')) {
      // Devuelve la misma letra
      return letra;
    } else {
      // Si no es válida o el valor por defecto, devuelve el valor por defecto
      return DEFECTO_CONSUMO_ENERGETICO;
    }
  }
  
  /**
   * Comprueba que el color proporcionado es un color válido
   * @param color Color a comprobar
   * @return El mismo color, si es válido o el color por defecto, si no lo es
   */
  private String comprobarColor(String color) {
    // Si es uno de los no por defecto
    if (color.equals(COLOR_NEGRO) || color.equals(COLOR_AZUL) || color.equals(COLOR_ROJO)
        || color.equals(COLOR_GRIS)) {
      // Lo devuelve porque es correcto
      return color;
    } else {
      // En cualquier otro caso devuelve el color por defecto
      return DEFECTO_COLOR;
    }
  }
}
