package prog.unidad09.relacion02.datos;

public class Centro {

  // Número de centro
  private int numero;
  // Nombre del centro
  private String nombre;

  public Centro(int numero, String nombre) {
    this.numero = numero;
    this.nombre = nombre;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  
}
