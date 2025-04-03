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

    Caballero lord = new Caballero("Overlord",120,20,60,"Mazo");
    lord.verificarArmadura();
    System.out.printf("Estado de vida: %b %n Estado Armadura: %b",lord.estadoVivo , lord.estadoArmadura);
    
    
  }
  

}
