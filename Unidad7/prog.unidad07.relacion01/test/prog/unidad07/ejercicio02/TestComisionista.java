package prog.unidad07.ejercicio02;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import prog.unidad07.ejercicio02.Comisionista;
import prog.unidad07.ejercicio02.Empleado;

class TestComisionista {

  @Test
  void testNombreNull() {
    // Caso: Crear un comisionista con todos los datos correctos
    //       excepto nombre que es null
    // RE  : El comisionista no se crea y se lanza NullPointerException
    assertThrows(NullPointerException.class, () -> new Comisionista(null, "11111111A", "666666666", 1000, 0.1, 10000));
  }

  @Test
  void testDNINull() {
    // Caso: Crear un comisionista con todos los datos correctos
    //       excepto dni que es null
    // RE  : El comisionista no se crea y se lanza NullPointerException
    assertThrows(NullPointerException.class, () -> new Comisionista("Paco", null, "666666666", 1000, 0.1, 10000));
  }

  @Test
  void testTelefonoNull() {
    // Caso: Crear un comisionista con todos los datos correctos
    //       excepto telefono que es null
    // RE  : El comisionista no se crea y se lanza NullPointerException
    assertThrows(NullPointerException.class, () -> new Comisionista("Paco", "11111111A", null, 1000, 0.1, 10000));
  }

  @Test
  void testSalarioNegativo() {
    // Caso: Crear un comisionista con todos los datos correctos
    //       excepto salario que es -1000
    // RE  : El comisionista no se crea y se lanza IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Comisionista("Paco", "11111111A", "666666666", -1000, 0.1, 10000));
  }

  @Test
  void testPorcentajeNegativo() {
    // Caso: Crear un comisionista con todos los datos correctos
    //       excepto porcentaje que es -0.1
    // RE  : El comisionista no se crea y se lanza IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Comisionista("Paco", "11111111A", "666666666", 1000, -0.1, 10000));
  }

  @Test
  void testPorcentajeMayorQue1() {
    // Caso: Crear un comisionista con todos los datos correctos
    //       excepto porcentaje que es 1.1
    // RE  : El comisionista no se crea y se lanza IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Comisionista("Paco", "11111111A", "666666666", 1000, 1.1, 10000));
  }

  @Test
  void testVentasNegativas() {
    // Caso: Crear un comisionista con todos los datos correctos
    //       excepto ventas que es -10000
    // RE  : El comisionista no se crea y se lanza IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Comisionista("Paco", "11111111A", "666666666", 1000, 0.1, -10000));
  }

  @Test
  void testSalarioCero() {
    // Caso: Crear un comisionista con datos correctos, salario 0, porcentaje 0.1, ventas 10000
    // RE  : El comisionista se crea correctamente y su salario es de 1000 euros
    Empleado empleado = null;
    try {
      empleado = new Comisionista("Pepe", "11111111A", "666666666", 0, 0.1, 10000);
    } catch (Exception e) {
      fail("Error al crear un comisionista con datos correctos");
    }
    assertEquals(1000, empleado.getSalario());
  }

  @Test
  void testPorcentajeCero() {
    // Caso: Crear un comisionista con datos correctos, salario 1000, porcentaje 0, ventas 10000
    // RE  : El comisionista se crea correctamente y su salario es de 1000 euros
    Empleado empleado = null;
    try {
      empleado = new Comisionista("Pepe", "11111111A", "666666666", 1000, 0, 10000);
    } catch (Exception e) {
      fail("Error al crear un comisionista con datos correctos");
    }
    assertEquals(1000, empleado.getSalario());
  }

  @Test
  void testVentasCero() {
    // Caso: Crear un comisionista con datos correctos, salario 1000, porcentaje 0.1, ventas 0
    // RE  : El comisionista se crea correctamente y su salario es de 1000 euros
    Empleado empleado = null;
    try {
      empleado = new Comisionista("Pepe", "11111111A", "666666666", 1000, 0.1, 0);
    } catch (Exception e) {
      fail("Error al crear un comisionista con datos correctos");
    }
    assertEquals(1000, empleado.getSalario());
  }

  @Test
  void testPorcentajeUno() {
    // Caso: Crear un comisionista con datos correctos, salario 1000, porcentaje 1, ventas 10000
    // RE  : El comisionista se crea correctamente y su salario es de 11000 euros
    Empleado empleado = null;
    try {
      empleado = new Comisionista("Pepe", "11111111A", "666666666", 1000, 1, 10000);
    } catch (Exception e) {
      fail("Error al crear un comisionista con datos correctos");
    }
    assertEquals(11000, empleado.getSalario());
  }

  @Test
  void testPorcentajeMedio() {
    // Caso: Crear un comisionista con datos correctos, salario 1000, porcentaje 0.5, ventas 10000
    // RE  : El comisionista se crea correctamente y su salario es de 6000 euros
    Empleado empleado = null;
    try {
      empleado = new Comisionista("Pepe", "11111111A", "666666666", 1000, 0.5, 10000);
    } catch (Exception e) {
      fail("Error al crear un comisionista con datos correctos");
    }
    assertEquals(6000, empleado.getSalario());
  }

}
