package ejercicio08;

public class IntervaloTiempo {
	
	//Constante para calculo de cambio unidad
	private static final int SEGUNDOS_POR_MINUTO = 60;
	
	//Atributos
	private int horas;
	private int minutos;
	private int segundos;
	
	public IntervaloTiempo(int horas, int minutos, int segundos) {
		
		//Ajustamos segundos
	    while (segundos > 59) {
	      segundos -= 60;
	      minutos++;
	    }
	    //Ajustamos minutos por el metodo manolo
	    horas += minutos/60;
	    minutos = minutos % 60;
	    
	    this.horas = horas;
	    this.minutos = minutos;
	    this.segundos = segundos;
		
	}
	
	public IntervaloTiempo suma(IntervaloTiempo otro) {
		//Sumamos los segundos
		int segundosTemporales = segundos + otro.segundos;
		//Ajustamos los segundos
		int segundosReales = segundosTemporales % 60;
		//Calculamos los minutos extras
		int minutosExtra = segundosTemporales / 60;
		
		//Hacemos lo mismo con los minutos
		int minutosTemporales = minutos + otro.minutos + minutosExtra;
		int minutosReales = minutosTemporales % 60;
		int horasExtra = minutosTemporales / 60;
		
		//Por ultimo calculamos hora
		int horasReales = horas + otro.horas + horasExtra;
		
		return new IntervaloTiempo ( horasReales , minutosReales, segundosReales);
		
	}
	
	public IntervaloTiempo resta (IntervaloTiempo otro) {
		
		//Restamos los segundos
		int segundosRestados = segundos - otro.segundos;
		int segundosReales = 0;
		int minutoExtra = 0;
		if (segundosRestados < 0) {
			segundosReales = 60 + segundosRestados;
			minutoExtra = 1;
		} else {
			segundosReales = segundosRestados;
		}
		
		//Restamos los minutos
		int minutosRestados = minutos - otro.minutos - minutoExtra;
		int minutosReales = 0;
		int horaExtra = 0;
		if (minutosRestados < 0) {
			minutosReales = 60 + minutosRestados;
			horaExtra = 1;
		} else {
			minutosReales = minutosRestados;
		}
		//Restamos horas 
		int horasReales = horas - otro.horas - horaExtra;
		if (horasReales < 0) {
			System.out.println("Error. El intervalo que se resta es mayor que el original.");
			return null;
		} else {
			return new IntervaloTiempo(horasReales, minutosReales, segundosReales);
		}
	}
	
	public String obtenerCadena() {
		return horas + "h" + minutos + "m" + segundos + "s";
		
	}
}
