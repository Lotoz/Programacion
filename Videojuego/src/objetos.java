
public abstract class objetos {

  //Atributos
  protected String nombre;
  protected int valor;
  protected boolean estado;
  
  protected objetos(String nombre, int valor, boolean estado) {
    
    this.nombre = nombre;
    this.valor = valor;
    this.estado = estado;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getValor() {
    return valor;
  }

  public void setValor(int valor) {
    this.valor = valor;
  }

  public boolean isEstado() {
    return estado;
  }

  public void setEstado(boolean estado) {
    this.estado = estado;
  }

  
}
