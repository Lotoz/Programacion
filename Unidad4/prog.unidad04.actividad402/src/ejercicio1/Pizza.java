package ejercicio1;


public class Pizza {
 

    //debemos poner los tipos como final
    /**
     * The size is medium
     */
    public static final String SIZE_MEDIUM = "medium";
    
    /**
     * The size is big
     */
    public static final String SIZE_BIG= "big";
    
    /**
     * The type margarita
     */
    public static final String TYPE_MARGARITA = "margarita";
    
    /**
     * The type cuatro queso
     */
    public static final String TYPE_CUATRO_QUESOS = "cuatro quesos";
    
    /**
     * Tipo funghi
     */
    public static final String TIPO_FUNGHI = "funghi";
    
    /**
     * Estado pedida
     */
    public static final String STATE_CREATE = "pedida";
    
    /**
     * Estado servida
     */
    public static final String STATE_READY = "servida";

    
    /**
     * Tamaño de las pizzas. Puede ser mediana o familiar. 
     * */
     private String size;
     /**
      * Tipo de pizzas. Puede ser margarita, cuatro queso, funghi 
      * */
    private String type;
    
    /**
     * Estado: pedida o servida
     * */
    private String state;
    /**
     * Numero total de pizzas creadas
     * */
    private static int pizzasCreates;
    /**
     * Numero total de pizzas servidas
     * */
    private static int pizzasReady;
    
    public Pizza (String size, String type) {
     
      this.size = size;
      this.type = type;
      state = STATE_CREATE;
      pizzasCreates++;
      
    }
    public String getsize() {
      return size;
    }
    public String gettype() {
      return type;
    }
    public static int getpizzasReady() {
      return pizzasReady;
    }
    public static int getpizzasCreate() {
      return pizzasCreates;
    }
    public void servir() {
      this.state = STATE_READY;
      pizzasReady ++;
    }
    private String getstate() {
      return state;
    }
    public String toString(){
      return "The sizes is " + getsize()  + " The type is " + gettype()  + " The state is " + getstate();
    }
  }

