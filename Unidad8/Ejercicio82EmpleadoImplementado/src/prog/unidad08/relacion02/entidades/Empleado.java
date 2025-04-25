package prog.unidad08.relacion02.entidades;

/**
 * Empleado de la empresa
 */
public class Empleado {
  
  // Atributos
  // Codigo del empleado
  private int codigo;
  // Nombre
  private String nombre;
  // Codigo del departamento al que pertenece
  private int codigoDepartamento;
  // Extensión telefónica
  private String extension;
  // Fecha de nacimiento
  private String fechaNacimiento;
  // Fecha de ingreso en la empresa
  private String fechaIngreso;
  // Salario
  private double salario;
  // Comisiones
  private double comisiones;
  // Número de hijos
  private int numeroHijos;
  
  
  public Empleado(int codigo, String nombre, int codigoDepartamento, String extension, String fechaNacimiento
    , String fechaIngreso, double salario, double comisiones, int numeroHijos) {
    
    this.codigo = codigo;
    this.nombre = nombre;
    this.codigoDepartamento = codigoDepartamento;
    this.extension = extension;
    this.fechaNacimiento = fechaNacimiento;
    this.fechaIngreso = fechaIngreso;
    this.salario = salario;
    this.comisiones = comisiones;
    this.numeroHijos = numeroHijos;
  }

  public int getCodigo() {
    return codigo;
  }

  public String getNombre() {
    return nombre;
  }

  public int getCodigoDepartamento() {
    return codigoDepartamento;
  }

  public String getExtension() {
    return extension;
  }

  public String getFechaNacimiento() {
    return fechaNacimiento;
  }

  public String getFechaIngreso() {
    return fechaIngreso;
  }

  public double getSalario() {
    return salario;
  }

  public double getComisiones() {
    return comisiones;
  }

  public int getNumeroHijos() {
    return numeroHijos;
  }
}
