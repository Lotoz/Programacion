
public abstract class ConArmadura extends Personaje {

  // Atributo
  protected int armadura;
  protected boolean estadoArmadura;

  protected ConArmadura(String nombre, int vida,int poder, int armadura) {
    super(nombre, vida, poder);
    this.armadura = armadura;
    estadoArmadura = false;
  }

  
  public int getArmadura() {
    return armadura;
  }


  public void setArmadura(int armadura) {
    this.armadura = armadura;
  }
  
  public boolean isEstadoArmadura() {
    return estadoArmadura;
  }


  public void setEstadoArmadura(boolean estadoArmadura) {
    this.estadoArmadura = estadoArmadura;
  }

  public boolean verificarArmadura(){
    return armadura > 0;
  }

  protected abstract int atacar();
  
}
