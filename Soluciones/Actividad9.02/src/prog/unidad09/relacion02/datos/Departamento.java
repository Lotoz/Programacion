package prog.unidad09.relacion02.datos;

public class Departamento {

  // Número
  private int numero;
  // Nombre
  private String nombre;
  // Direccion
  private String direccion;
  // Presupuesto
  private double presupuesto;
  // Centro en el que está
  private Centro centro;
  // Director del departamento
  private Empleado director;
  // Departamento del que depende
  private Departamento dependeDe;

  public Departamento(int numero, String nombre, String direccion, double presupuesto,
      Centro centro, Empleado director, Departamento dependeDe) {
    this.numero = numero;
    this.nombre = nombre;
    this.direccion = direccion;
    this.presupuesto = presupuesto;
    this.centro = centro;
    this.director = director;
    this.dependeDe = dependeDe;
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

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public double getPresupuesto() {
    return presupuesto;
  }

  public void setPresupuesto(double presupuesto) {
    this.presupuesto = presupuesto;
  }

  public Centro getCentro() {
    return centro;
  }

  public void setCentro(Centro centro) {
    this.centro = centro;
  }

  public Empleado getDirector() {
    return director;
  }

  public void setDirector(Empleado director) {
    this.director = director;
  }

  public Departamento getDependeDe() {
    return dependeDe;
  }

  public void setDependeDe(Departamento dependeDe) {
    this.dependeDe = dependeDe;
  }
}
