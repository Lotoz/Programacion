package prog.unidad04.actividad402.ejercicio01;

/**
 * Clase que representa a una pizza
 */
public class Pizza {
  
  /**
   * Tamaño mediana
   */
  public static final String TAMANYO_MEDIANA = "mediana";
  
  /**
   * Tamaño familiar
   */
  public static final String TAMANYO_FAMILIAR = "familiar";
  
  /**
   * Tipo margarita
   */
  public static final String TIPO_MARGARITA = "margarita";
  
  /**
   * Tipo cuatro quesos
   */
  public static final String TIPO_CUATRO_QUESOS = "cuatro quesos";
  
  /**
   * Tipo funghi
   */
  public static final String TIPO_FUNGHI = "funghi";
  
  /**
   * Estado pedida
   */
  public static final String ESTADO_PEDIDA = "pedida";
  
  /**
   * Estado servida
   */
  public static final String ESTADO_SERVIDA = "servida";

  /**
   * Tamaño de la pizza. Puede ser uno de mediana o familiar
   */
  private String tamanyo;
  /**
   * Tipo de la pizza. Puede ser margarita, cuatro quesos o funghi
   */
  private String tipo;
  /**
   * Estado de la pizza. pedida o servida
   */
  private String estado; 
  /**
   * Número total de pizzas creadas
   */
  private static int pizzasCreadas;
  /**
   * Numero total de pizzas servidas
   */
  private static int pizzasServidas;

  /**
   * Constructor. Imprime error si alguno de los parámetros no son correctos
   * @param tamanyo Tamaño de la pizza. Debe ser "mediana" o "familiar"
   * @param tipo Tipo de la pizza. Debe ser uno de "margarita", "cuatro quesos" o "funghi"
   */
  public Pizza(String tamanyo, String tipo) {
    // Si el tamaño es uno de los admitidos
    if ((tamanyo.equals(TAMANYO_MEDIANA)) || (tamanyo.equals(TAMANYO_FAMILIAR))) {
      // Si el tipo es uno de los admitidos
      if ((tipo.equals(TIPO_MARGARITA)) || (tipo.equals(TIPO_CUATRO_QUESOS)) || (tipo.equals(TIPO_FUNGHI))) {
        // Iniciamos los atributos
        this.tamanyo = tamanyo;
        this.tipo = tipo;
        // El estado a pedida
        estado = ESTADO_PEDIDA;
        // Una nueva pizza creada
        pizzasCreadas++;
      } else {
        System.out.printf("El parámetro tipo no es correcto. Debe ser uno de \"%s\", \"%s\" o \"%s\"%n"
            , TIPO_MARGARITA, TIPO_CUATRO_QUESOS, TIPO_FUNGHI);
      }
    } else {
      System.out.printf("El parámetro tamanyo no es correcto. Debe ser uno de \"%s\" o \"%s\"%n"
          , TAMANYO_MEDIANA, TAMANYO_FAMILIAR);
    }
  }

  /**
   * Obtiene el tamaño de la pizza
   * @return Tamaño de la pizza. Puede ser uno de mediana o familiar
   */
  public String getTamanyo() {
    return tamanyo;
  }

  /**
   * Obtiene el tipo de la pizza
   * @return Tipo de la pizza. Puede ser uno de margarita, cuatro quesos o funghi
   */
  public String getTipo() {
    return tipo;
  }

  /**
   * Obtiene el estado de la pizza
   * @return Estado de la pizza. Puede ser uno de pedida o servida
   */
  public String getEstado() {
    return estado;
  }


  /**
   * Obtiene el número de pizzas creadas hasta el momento
   * @return Número de pizzas creadas hasta el momento
   */
  public static int getPizzasCreadas() {
    return pizzasCreadas;
  }

  /**
   * Obtiene el número de pizzas servidas hasta el momento
   * @return Número de pizzas servidas hasta el momento
   */
  public static int getPizzasServidas() {
    return pizzasServidas;
  }
  
  /**
   * Sirve la pizza. Imprime error si la pizza ya está servida
   */
  public void sirve() {
    if (estado.equals(ESTADO_PEDIDA)) {
      // Cambia el estado a servida
      estado = ESTADO_SERVIDA;
      // Una nueva pizza servida
      pizzasServidas++;
    } else {
      System.out.println("Error. Esta pizza ya se ha servido");
    }
  }
  
  /**
   * Devuelve una representación en cadena de la pizza de la forma<br>
   * <code>Tamaño: &lt;tamaño&gt;, Tipo: &lt;tipo&gt;, Estado: &lt;estado&gt;</code>
   * @return Representacion en formato de cadena de la pizza con el formato especificado
   */
  public String toString() {
    return "Tamaño: " + getTamanyo() + ", Tipo: " + getTipo() + ", Estado: " + getEstado();
  }
}
