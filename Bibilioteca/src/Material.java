
public abstract class Material {

  //Atributos
  protected String titulo;
  protected String autor;
  protected boolean estado;
  
  public Material(String titulo, String autor, boolean estado) {
    this.autor = autor;
    this.titulo = titulo;
    this.estado = estado;
  }
  
  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public boolean isEstado() {
    return estado;
  }

  public void setEstado(boolean estado) {
    this.estado = estado;
  }

  protected String suEstado(boolean estado) {
    if(estado) {
      return "No disponible.";
    }else {
      return "Disponible.";
    }
  }
  //metodo para mostrar la informacion por una cadena
  protected abstract String mostrarInfo();
  
  //metodo para cambiar el estado del objeto a disponible o prestado
  protected abstract boolean cambiarEstado();
 
}
