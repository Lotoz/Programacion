package prog.unidad04.practica406.libreria;


import prog.unidad04.practica406.libreria.Fecha;
/**
 * Clase que representa a un vehículo.
 */
public class Vehiculo {

	// Metodos privados para usos concretos en la construccion del objeto en la
	// clase
	private String matricula;
	private Fecha fechaMatriculacion;
	private static int contadorVehiculos = 0;

	/**
   * Constructor
   * 
   * @param matricula Matrícula del vehiculo. Debe tener un formato válido NNNN AAA donde NNNN son 4 dígitos y AAA son tres letras MAYÚSCULAS. Entre ellas puede haber cuantos espacios se quiera (incluido ninguno).
   * @param fechaMatriculacion Fecha de matriculación del vehiculo. No puede ser null.
   * @throws NullPointerException - Si matricula o fechaMatriculacion es null.
   * @throws IllegalArgumentException - Si alguno de los parametros no es válido.
   */
	protected Vehiculo(String matricula, Fecha fechaMatriculacion) {
	  if (validadorMatricula(matricula)) {
      this.matricula = matricula;
    } else {
      throw new IllegalArgumentException("La matricula introducida es incorrecta. Revise los valores e intentelo de nuevo.");
    }
      if (fechaMatriculacion  == null) {
        throw new NullPointerException("La fecha introducida es incorrecta. Revise los valores e intentelo de nuevo.");
      } else {
        this.fechaMatriculacion = fechaMatriculacion;
      }
   //Contador al crear un nuevo vehículo
    contadorVehiculos++; 

	}


	 /**
   * Obtiene la matricula.
   * 
   * @return Devuelve la matricula
   */
	public String getMatricula() {
			return matricula;
	}

	 /**
   * Valida la matricula
   * @param matricula Matrícula del vehiculo. Debe tener un formato válido NNNN AAA donde NNNN son 4 dígitos y AAA son tres letras MAYÚSCULAS. Entre ellas puede haber cuantos espacios se quiera (incluido ninguno).
   * @return Devuelve si la matricula es valida
   */
  private boolean validadorMatricula(String matricula) {
       
    //Verificamos que la longitud sea 7 después de eliminar espacios
    if (matricula.length() != 7) {
     
      return false; // La matrícula no es válida
    }

    String numeros = matricula.substring(0, 4); // Primeros 4 caracteres
    String letras = matricula.substring(4, 7); // Últimos 3 caracteres

    //Verificamos que los primeros 4 caracteres sean dígitos
    for (int i = 0; i < 4; i++) {
        if (!Character.isDigit(numeros.charAt(i))) {
            return false; 
        }
    }

    //Verificamos que los últimos 3 caracteres sean letras mayúsculas
    for (int i = 0; i < 3; i++) {
        if (!Character.isUpperCase(letras.charAt(i))) {
            return false; 
        }
    }

    return true; 
}

  /**
   * Obtiene la fecha de matriculación del vehículo.
   * 
   * @return Fecha de matriculacion del vehículo.
   */
	public Fecha getFechaMatriculacion() {
	  return fechaMatriculacion;
	}
  /**
   * Obtiene la cantidad de vehiculos creados.
   * 
   * @return Cantidad de vehiculos creados vehículo.
   */
	 public static int getVehiculosMatriculados() {
	//Devuelve el contador
     return contadorVehiculos; 
 }
	 /**
	   * Obtiene la representación en texto del vehiculo en formato:
	   * Matricula: matricula, Fecha Matriculación: dd de mmmmm de aaaa.
	   */
	public String toString() {
		return getMatricula() + getFechaMatriculacion().toString();
	}

}
