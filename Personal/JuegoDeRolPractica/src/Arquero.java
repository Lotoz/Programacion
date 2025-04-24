
public class Arquero extends ConArmadura {

  // Atributos
 

  public Arquero(String nombre, int vida,int poder, int armadura, String arco) {
    super(nombre, vida,poder, armadura, arco);
    
  }

  public int atacar() {
    return 1;
  }

   
  
}
