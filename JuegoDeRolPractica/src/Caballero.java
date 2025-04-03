
public class Caballero extends ConArmadura {

  // Atributos
  private int arma;
  public Caballero(String nombre, int vida, int poder, int armadura, int arma) {
    super(nombre, vida, poder, armadura);
    this.arma = arma;
  }

  @Override
  public int atacar() {
    return 1;
  }

  
}