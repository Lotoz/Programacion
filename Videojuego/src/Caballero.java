
public class Caballero extends ConArmadura {

  // Atributos
  private String arma;

  public Caballero(String nombre, int vida, String armadura, String arma) {
    super(nombre, vida, armadura);
    this.arma = arma;

  }

  public String getArma() {
    return arma;
  }

  public void setArma(String arma) {
    this.arma = arma;
  }

  @Override
  public void curarVida(PocionVida pocion) {
    int curacion = getVida() + pocion.getValor();
    if (curacion > 110) {
      setVida(110);
    } else {
      setVida(curacion);
    }

  }

}
