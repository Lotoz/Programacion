/**
 * 
 */
package appCuenta;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * LIBRERIA PARA HACER PRUEBAS, SE USA JUNIT PARA ESTO
 */
class CuentaTest {

	/**
	 * Test method for {@link appCuenta.Cuenta#Cuenta(java.lang.String, float)}.
	 */
	@Test
	void testCuenta() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link appCuenta.Cuenta#getNumero()}.
	 */
	@Test
	void testGetNumero() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link appCuenta.Cuenta#setNumero(java.lang.String)}.
	 */
	@Test
	void testSetNumero() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link appCuenta.Cuenta#getSaldo()}.
	 */
	@Test
	void testGetSaldo() {
		Cuenta cuenta1 = new Cuenta ("ES21290192091039229822313", 100);
		float saldo = cuenta1.getSaldo();
		
		//Esto es lo que se espera que salga al realizar las acciones
		assertEquals (100, saldo);
	}/**
	*El assertEquals se usa para probar los errores en Junit, estos erros 
	*Se veran mostrados ahi.
	*/

	/**
	 * Test method for {@link appCuenta.Cuenta#setSaldo(float)}.
	 */
	@Test
	void testSetSaldo() {
		Cuenta cuenta1 = new Cuenta ("ES21290192091039229822313", 100);
		cuenta1.setSaldo(100);
		assertEquals (100, cuenta1.getSaldo());
	}

	/**
	 * Test method for {@link appCuenta.Cuenta#ingresarDinero(float)}.
	 */
	@Test
	void testIngresarDinero() {
		Cuenta cuenta1 = new Cuenta ("ES21290192091039229822313", 100);
		cuenta1.ingresarDinero(400);
		assertEquals (500, cuenta1.getSaldo());
	}

	/**
	 * Test method for {@link appCuenta.Cuenta#estraerDinero(float)}.
	 */
	@Test
	void testEstraerDinero() {
		try {
			Cuenta cuenta1 = new Cuenta ("ES21290192091039229822313", 100);
			cuenta1.estraerDinero(120);
			fail ("Error. Deberia saltar el control de l excepcion. ");
			/**recurso de Junit para lanzar un error
			 * 
			 */
		} catch (ArithmeticException ae) {
			//Prueba superada
			assertEquals ("Saldo negativo", ae.getMessage());
			
		}
	}
			/** assertEquals (Resultado esperado, Resultado Obetenido);
			 *
			 */
		
	/**
	 * Test method for {@link appCuenta.Cuenta#mostrarCuenta()}.
	 */
	@Test
	void testMostrarCuenta() {
		fail("Not yet implemented");
	}

}
