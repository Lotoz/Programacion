package appCuenta;



import org.junit.jupiter.api.Test;

public class Cuenta {
	// Ejercicio del libro buscarlo.
	private String numero;
	private float saldo;

	public Cuenta(String string, int i) {
		// TODO Auto-generated constructor stub
	}

	public void Cuenta(String numCta, float saldoCta) {
		numero = numCta;
		saldo = saldoCta;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numCta) {
		numero = numCta;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldoCta) {
		saldo = saldoCta;
	}

	public void ingresarDinero(float importe) {
		saldo = saldo + importe;
	}

	public void estraerDinero(float importe) {
		if (saldo -importe < 0) {
			throw new java.lang.ArithmeticException("Saldo negativo");
		}else {
			saldo = saldo - importe;
		}
	}

	public void mostrarCuenta() {
		System.out.println("N de cuenta:" + getNumero());
		System.out.println("N de cuenta:" + getSaldo() + "€");

	}
}


