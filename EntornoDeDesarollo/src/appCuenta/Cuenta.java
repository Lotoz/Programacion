package appCuenta;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Cuenta {
	//Ejercicio del libro buscarlo.
	  private String numero;
	  private float saldo;
	
	  public Cuenta(String string, int i) {
		// TODO Auto-generated constructor stub
	}

	public void Cuenta (String numero, float saldo) {
	      this.numero = numero;
	      this.saldo = saldo;
	  }
	  
	  public String getNumero() {
	    return numero;
	  }

	  public void setNumero(String numero) {
	    this.numero = numero;
	  }

	  public float getSaldo() {
	    return saldo;
	  }

	  public void setSaldo(float saldo) {
	    this.saldo = saldo;
	  }

	  public void ingresarDinero(float importe) {
	    saldo += importe;
	  }
	  
	  public void estraerDinero(float importe) {
	    saldo -= importe;
	    
	  }
	  
	  public void mostrarCuenta() {
		  System.out.println("N de cuenta:" + this.getNumero());
		  System.out.println("N de cuenta:" + this.getSaldo() +  "€");
		 
	  } 
  }
class cuentaTest {

	  /**
	   * Test method for {@link appCuenta.cuenta#getSaldo()}.
	   */
	  @Test
	  void testGetSaldo() {
	    Cuenta cuenta1 = new Cuenta("ccc-01",1000);
	    float saldo = cuenta1.getSaldo();
	    assertEquals(1000, saldo);
	  }

	  /**
	   * Test method for {@link appCuenta.cuenta#setSaldo(float)}.
	   */
	  @Test
	  void testSetSaldo() {
	    fail("Not yet implemented");
	  }

	  /**
	   * Test method for {@link appCuenta.cuenta#Cuenta(java.lang.String, float)}.
	   */
	  @Test
	  void testCuenta() {
	    fail("Not yet implemented");
	  }

	  /**
	   * Test method for {@link appCuenta.cuenta#ingresarDinero(float)}.
	   */
	  @Test
	  void testIngresarDinero() {
	    fail("Not yet implemented");
	  }

	  /**
	   * Test method for {@link appCuenta.cuenta#estraerDinero(float)}.
	   */
	  @Test
	  void testEstraerDinero() {
	    fail("Not yet implemented");
	  }

	}