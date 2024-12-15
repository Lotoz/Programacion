package prog.unidad04.practica406.libreria;

import java.util.Random;
import prog.unidad04.practica406.libreria.FechaException;
import prog.unidad04.practica406.libreria.Fecha;

public class Vehiculo {

	// Metodos privados para usos concretos en la construccion del objeto en la
	// clase
	private String matricula;
	private Fecha fechaMatriculacion;
	private static int contadorVehiculos = 0;

	// Constructor privado de la clase, tiene importado el constructor fecha
	protected Vehiculo(String matricula, Fecha fechaMatriculacion) throws FechaException {
	  if (validadorMatricula(matricula)) {
      this.matricula = matricula;
    } else {
      throw new FechaException("No se pudo crear el automóvil. Revise los datos para comprobar que\n"
          + "todos son correctos.");
    }
		
		this.fechaMatriculacion = fechaMatriculacion;
		contadorVehiculos++; // Incrementar el contador al crear un nuevo vehículo

	}

	// Sirve para obtener la matricula del vehiculo
	public String getMatricula() {
		if (validadorMatricula(matricula)) {
			return matricula;
		} else {
			return null;
		}
	}

	// Validador de matricula
  private boolean validadorMatricula(String matricula) {
    // Eliminar espacios en blanco
    matricula = matricula.trim();

    // Verificar que la longitud sea 7 después de eliminar espacios
    if (matricula.length() != 7) {
        return false; // La matrícula no es válida
    }

    String numeros = matricula.substring(0, 4); // Primeros 4 caracteres
    String letras = matricula.substring(4, 7); // Últimos 3 caracteres

    // Verificar que los primeros 4 caracteres sean dígitos
    for (int i = 0; i < 4; i++) {
        if (!Character.isDigit(numeros.charAt(i))) {
            return false; // No es un dígito
        }
    }

    // Verificar que los últimos 3 caracteres sean letras mayúsculas
    for (int i = 0; i < 3; i++) {
        if (!Character.isUpperCase(letras.charAt(i))) {
            return false; // No es una letra mayúscula
        }
    }

    return true; // La matrícula es válida
}

	// Sirve para obtener la fecha del vehiculo desde cuando fue matriculado
	public String getFechaMatriculacion() {
	  return this.fechaMatriculacion.toString();
	}
	// Contador de vehiculos, cuenta cuantos hay creados.
	 public static int getVehiculosMatriculados() {
     return contadorVehiculos; // Devolver el contador
 }

	public String toString() {
		return getMatricula() + getFechaMatriculacion();
	}

}
