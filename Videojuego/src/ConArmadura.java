
public abstract class ConArmadura extends Personaje {

  // Atributo
  protected String armadura;

  protected ConArmadura(String nombre, int vida, String armadura) {
    super(nombre, vida);
    this.armadura = armadura;
  }

  
  public String getArmadura() {
    return armadura;
  }


  public void setArmadura(String armadura) {
    this.armadura = armadura;
  }


  public boolean tieneArmadura(String armadura) {
    if (armadura.isBlank()) {
      throw new IllegalArgumentException();
    }
    if (armadura.isEmpty()) {
      return false;
    } else {
      return true;
    }
  }

}
