
public class Arquero extends ConArmadura {

  //Constantes
  protected static final int VIDA_MAXIMA = 110;

  // Atributos
  private String arco;

  public Arquero(String nombre, int vida, String armadura, String arco) {
    super(nombre, vida, armadura);
    this.arco = arco;
  }

  public String getArco() {
    return arco;
  }

  public void setArco(String arco) {
    this.arco = arco;
  }

  @Override
  public void curarVida(PocionVida pocion) {
   int curacion = getVida() +  pocion.getValor();
    if (curacion > 110) {
      setVida(110); 
 } else {
   setVida(curacion);
 }
    
  }

  
}
