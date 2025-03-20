package prog.unidad07.ejercicio02;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import prog.unidad07.ejercicio02.Comercial;
import prog.unidad07.ejercicio02.Empleado;

class TestComercial {

  //Fail es que la prueba falla siempre
  @Test
  void testNombreNull() {
    // Caso: Crear un comercial con todos los datos correctos
    //       excepto nombre que es null
    // RE  : El comercial no se crea y se lanza NullPointerException
    assertThrows(NullPointerException.class, () -> new Comercial(null, "11111111A", "666666666", 1000));
  }

  @Test
  void testDNINull() {
    // Caso: Crear un comercial con todos los datos correctos
    //       excepto dni que es null
    // RE  : El comercial no se crea y se lanza NullPointerException
    assertThrows(NullPointerException.class, () -> new Comercial("Paco", null, "666666666", 1000));
  }

  @Test
  void testTelefonoNull() {
    // Caso: Crear un comercial con todos los datos correctos
    //       excepto telefono que es null
    // RE  : El comercial no se crea y se lanza NullPointerException
    assertThrows(NullPointerException.class, () -> new Comercial("Paco", "11111111A", null, 1000));
  }

  @Test
  void testVentasNegativas() {
    // Caso: Crear un comercial con todos los datos correctos
    //       excepto ventas que es -1000
    // RE  : El consultor no se crea y se lanza IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Comercial("Paco", "11111111A", "666666666", -1000));
  }

  @Test
  void testVentasCero() {
    // Caso: Crear un comercial con datos correctos, ventas 0
    // RE  : El comercial se crea correctamente y su salario es de 300 euros
    Empleado empleado = null;
    try {
      empleado = new Comercial("Pepe", "11111111A", "666666666", 0);
    } catch (Exception e) {
      fail("Error al crear un comercial con datos correctos");
    }
    assertEquals(300, empleado.getSalario());
  }

  @Test
  void testVentas10000() {
    // Caso: Crear un comercial con datos correctos, ventas 10000
    // RE  : El comercial se crea correctamente y su salario es de 500 euros
    Empleado empleado = null;
    try {
      empleado = new Comercial("Pepe", "11111111A", "666666666", 10000);
    } catch (Exception e) {
      fail("Error al crear un comercial con datos correctos");
    }
    assertEquals(500, empleado.getSalario());
  }

  @Test
  void testVentas10001() {
    // Caso: Crear un comercial con datos correctos, ventas 10001
    // RE  : El comercial se crea correctamente y su salario es de 800,08 euros
    Empleado empleado = null;
    try {
      empleado = new Comercial("Pepe", "11111111A", "666666666", 10001);
    } catch (Exception e) {
      fail("Error al crear un comercial con datos correctos");
    }
    assertEquals(800.08, empleado.getSalario());
  }

  @Test
  void testVentas30000() {
    // Caso: Crear un comercial con datos correctos, ventas 30000
    // RE  : El comercial se crea correctamente y su salario es de 800,08 euros
    Empleado empleado = null;
    try {
      empleado = new Comercial("Pepe", "11111111A", "666666666", 30000);
    } catch (Exception e) {
      fail("Error al crear un comercial con datos correctos");
    }
    assertEquals(2400, empleado.getSalario());
  }

  @Test
  void testVentas30001() {
    // Caso: Crear un comercial con datos correctos, ventas 30001
    // RE  : El comercial se crea correctamente y su salario es de 800,08 euros
    Empleado empleado = null;
    try {
      empleado = new Comercial("Pepe", "11111111A", "666666666", 30001);
    } catch (Exception e) {
      fail("Error al crear un comercial con datos correctos");
    }
    assertEquals(3000.1, empleado.getSalario());
  }

}
