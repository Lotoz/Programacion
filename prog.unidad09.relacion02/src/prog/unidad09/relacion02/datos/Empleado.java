package prog.unidad09.relacion02.datos;

public class Empleado {
  
  // Número
  private int numero;
  // Nombre
  private String nombre;
  // Extensión telefónica
  private String extension;
  // Fecha de nacimiento
  private String fechaNacimiento;
  // Fecha de incorporacion
  private String fechaIncorporacion;
  // Salario
  private double salario;
  // Comisiones
  private double comisiones;
  // Número de hijos
  private int numeroHijos;
  // Departamento al que pertenece
  private Departamento departamento;

  public Empleado(int numero, String nombre, String extension, String fechaNacimiento,
      String fechaIncorporacion, double salario, double comisiones, int numeroHijos,
      Departamento departamento) {
    this.numero = numero;
    this.nombre = nombre;
    this.extension = extension;
    this.fechaNacimiento = fechaNacimiento;
    this.fechaIncorporacion = fechaIncorporacion;
    this.salario = salario;
    this.comisiones = comisiones;
    this.numeroHijos = numeroHijos;
    this.departamento = departamento;
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

  public String getExtension() {
    return extension;
  }

  public void setExtension(String extension) {
    this.extension = extension;
  }

  public String getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(String fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public String getFechaIncorporacion() {
    return fechaIncorporacion;
  }

  public void setFechaIncorporacion(String fechaIncorporacion) {
    this.fechaIncorporacion = fechaIncorporacion;
  }

  public double getSalario() {
    return salario;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }

  public double getComisiones() {
    return comisiones;
  }

  public void setComisiones(double comisiones) {
    this.comisiones = comisiones;
  }

  public int getNumeroHijos() {
    return numeroHijos;
  }

  public void setNumeroHijos(int numeroHijos) {
    this.numeroHijos = numeroHijos;
  }

  public Departamento getDepartamento() {
    return departamento;
  }

  public void setDepartamento(Departamento departamento) {
    this.departamento = departamento;
  }
}
