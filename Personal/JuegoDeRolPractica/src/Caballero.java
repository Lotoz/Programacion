
public class Caballero extends ConArmadura {

  // Atributos
  private int arma;
  public Caballero(String nombre, int vida, int armadura, int arma) {
    super(nombre, vida, armadura);
    this.arma = arma;
  }

  @Override
  public int atacar() {
    return 1;
  }

  
}