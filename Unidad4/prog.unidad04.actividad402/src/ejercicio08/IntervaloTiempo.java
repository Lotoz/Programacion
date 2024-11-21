package ejercicio08;

public class IntervaloTiempo {
	
	//Atributos
	private int horas;
	private int minutos;
	private int segundos;
	
	public IntervaloTiempo(int horas, int minutos, int segundos) {
		
		//error revisar
		minutos += minutos % 60;
		horas = minutos / 60;
		
		
		segundos += segundos % 60;
		minutos = segundos / 60;
		
		/**Por ciclo
		* (while (segundos > 59){
		* segundos-= 60;
		* minutos ++;
		**/
		this.horas = horas;
		this.minutos = minutos;
		this.segundos = segundos;
	}
	
	public IntervaloTiempo suma(IntervaloTiempo otro) {
		return null;
	}
	
	public IntervaloTiempo resta(IntervaloTiempo otro) {
		return null;
	}
	
	public String obtenerCadena() {
		return horas + "h" + minutos + "m" + segundos + "s";
		
	}
}
