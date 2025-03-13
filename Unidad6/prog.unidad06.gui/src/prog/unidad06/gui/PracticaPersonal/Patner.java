package prog.unidad06.gui.PracticaPersonal;

/**
 * Compadre de clase que se agrega a la agenda
 */
public class Patner {

	//Atributos
	private String nombre;
	private int telefono;
	private String genero;

	
	
	public Patner(String nombre, int telefono, String genero) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.genero = genero;

	}

	public String getNombre() {
		return nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public String getGenero() {
		return genero;
	}

	

	@Override
	public String toString() {
		return getNombre();
	}
	

}
