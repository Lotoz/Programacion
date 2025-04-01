import java.util.Locale;

public class MazmorraApp {
  
  //Atributo
  private String nombre;
  private int nivel;

  public MazmorraApp(String nombre, int nivel) {
    this.nombre = nombre;
    this.nivel = nivel;
  }
  
  public static void main (String[] args) {
    MazmorraApp app = new MazmorraApp("Cueva de la vida", 1);
    app.run();
  }
  
  private void run() {
    Arquero arquero = new Arquero("Legolas",100,"","Mil Llantos");
    Caballero caballero = new Caballero("Arturo", 110, "Letal","Mazo");
    
    //Imprime vida antes de arquero
    System.out.printf(Locale.US,"La vida del arquero es %d%n", arquero.getVida()); 
    caballero.aplicaLetalidad(arquero, 40);
    System.out.printf(Locale.US,"La vida ahora del arquero es %d%n", arquero.getVida()); 
    //Controlar la vida con metodos privados
    PocionVida pocion = new PocionVida("Cura Basica", 20, false);
    //rquero.curarVida(pocion);
    System.out.printf(Locale.US,"La vida ahora del arquero es %d%n", arquero.getVida()); 
  }
  

}
