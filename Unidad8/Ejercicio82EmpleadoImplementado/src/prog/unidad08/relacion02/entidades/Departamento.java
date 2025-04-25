package prog.unidad08.relacion02.entidades;

/**
 * Departamento de la empresa
 */
public class Departamento {

  // Atributos
  // Código del departamento
  private int codigo;
  // Nombre del departamento
  private String nombre;
  // Código del centro en el que está situado el departamento
  private int codigoCentro;
  // Dirección del departamento (oficina, calle, etc.)
  private String direccion;
  // Código del empleado que es el director del departamento
  private int codigoDirector;
  // Presupuesto anual del departamento
  private double presupuesto;
  // Código del departamento del que depende este departamento (null si no depende de otro
  // departamento)
  private Integer codigoDepartamentoSuperior;
  
  /**
   * Constructor
   * @param codigo Código del departamento
   * @param nombre Nombre del departamento
   * @param codigoCentro Código del centro en el que se encuentra ubicado el departamento
   * @param direccion Dirección del departamento (oficina o planta o algo asi)
   * @param codigoDirector Código del empleado que dirige el departamento
   * @param presupuesto Presupuesto anual en euros del departamento
   * @param codigoDepartamentoSuperior Código del departamento del que depende (null si no depende
   *   de otro departamento)
   */
  public Departamento(int codigo, String nombre, int codigoCentro, String direccion,
    int codigoDirector, double presupuesto, Integer codigoDepartamentoSuperior) {
    this.codigo = codigo;
    this.nombre = nombre;
    this.codigoCentro = codigoCentro;
    this.direccion = direccion;
    this.codigoDirector = codigoDirector;
    this.presupuesto = presupuesto;
    this.codigoDepartamentoSuperior = codigoDepartamentoSuperior;
 }

  public int getCodigo() {
    return codigo;
  }

  public String getNombre() {
    return nombre;
  }

  public int getCodigoCentro() {
    return codigoCentro;
  }

  public String getDireccion() {
    return direccion;
  }

  public int getCodigoDirector() {
    return codigoDirector;
  }

  public double getPresupuesto() {
    return presupuesto;
  }

  public Integer getCodigoDepartamentoSuperior() {
    return codigoDepartamentoSuperior;
  }
}
