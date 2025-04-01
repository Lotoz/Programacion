
public class MainPruebas {

  //Atributos
  private String nombre;
  public MainPruebas(String nombre) {
    this.nombre = nombre;
  }
  
  public static void main (String[] args) {
    MainPruebas app = new MainPruebas("Bibloteca");
    app.run();
  }

  private void run() {
   
    Libro libro = new Libro("Duck","Deadpool", false, 1234);
    System.out.printf("%s", libro.mostrarInfo());
  }
  

}
