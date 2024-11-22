package ejercicio08A;

public class IntervaloTiempo {

	private static final int SEGUNDOS_POR_MINUTO = 60;
	private static final int SEGUNDOS_POR_HORA = 3600;
	
	private int segundos;
	
	/**
	 * 
	 * @param segundos no puede ser mayor de 59
	 * @author Zamira
	 * <h1>Pocoyo</h1>
	 * 
	 */
		private IntervaloTiempo (int segundos) {
			this.segundos = segundos;
		}
		public IntervaloTiempo(int horas, int minutos, int segundos) {
			
			this.segundos = horas * SEGUNDOS_POR_HORA + minutos * SEGUNDOS_POR_MINUTO + segundos;
		}
		
		public IntervaloTiempo suma(IntervaloTiempo otro) {
			
			int resultado = this.segundos + otro.segundos;
			return new IntervaloTiempo(resultado, resultado, resultado);
		}
		
		public IntervaloTiempo resta(IntervaloTiempo otro) {
		
			int resultado = this.segundos - otro.segundos;
			if (resultado < 0) {
				System.out.println("Error");
				return null;
			}else {
				return new IntervaloTiempo(resultado, resultado, resultado);
			}
		}
		
		public String obtenerCadena() {
			int seg = segundos % 60;
			int minutosTemporales = segundos / 60;
			int min = minutosTemporales % 60;
			int horas = minutosTemporales / 60;
			
			return horas + "h" + min + "m" + seg + "s";
			
		}
	}

