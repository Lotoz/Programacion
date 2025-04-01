
public class Libro extends Material {

  //Atributo
  private int isbn;
  
  public Libro(String titulo, String autor, boolean estado, int isbn) {
    super(titulo, autor, estado);
    this.isbn = isbn;
  }

  public int getIsbn() {
    return isbn;
  }

  public void setIsbn(int isbn) {
    this.isbn = isbn;
  }

  @Override
  protected String mostrarInfo() {  
    return "Titulo: " + getTitulo() +"%n Autor: " + getAutor() + " Estado: " + suEstado(isEstado()) + "ISBN: " + getIsbn();
  }

  @Override
  protected boolean cambiarEstado() {
    return false;
  }

}
