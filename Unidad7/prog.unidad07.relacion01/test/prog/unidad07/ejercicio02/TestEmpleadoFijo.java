package prog.unidad07.ejercicio02;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import prog.unidad07.ejercicio02.Empleado;
import prog.unidad07.ejercicio02.EmpleadoFijo;

class TestEmpleadoFijo {

  @Test
  void testTodoNormal() {
    // Caso: Crear un empleado fijo con datos correctos y un salario de 1000 euros
    // RE  : El empleado se crea correctamente y su salario es de 1000 euros
    Empleado empleado = null;
    try {
      empleado = new EmpleadoFijo("Pepe", "11111111A", "666666666", 1000);
    } catch (Exception e) {
      fail("Error al crear un empleado fijo con datos correctos");
    }
    assertEquals(1000, empleado.getSalario());
  }

  @Test
  void testNombreNull() {
    // Caso: Crear un empleado fijo con todos los datos correctos
    //       excepto nombre que es null
    // RE  : El empleado no se crea y se lanza NullPointerException
    assertThrows(NullPointerException.class, () -> new EmpleadoFijo(null, "11111111A", "666666666", 1000));
  }

  @Test
  void testDNINull() {
    // Caso: Crear un empleado fijo con todos los datos correctos
    //       excepto dni que es null
    // RE  : El empleado no se crea y se lanza NullPointerException
    assertThrows(NullPointerException.class, () -> new EmpleadoFijo("Paco", null, "666666666", 1000));
  }

  @Test
  void testTelefonoNull() {
    // Caso: Crear un empleado fijo con todos los datos correctos
    //       excepto telefono que es null
    // RE  : El empleado no se crea y se lanza NullPointerException
    assertThrows(NullPointerException.class, () -> new EmpleadoFijo("Paco", "11111111A", null, 1000));
  }

  @Test
  void testSalarioCero() {
    // Caso: Crear un empleado fijo con datos correctos y un salario de 0 euros
    // RE  : El empleado se crea correctamente y su salario es de 0 euros
    Empleado empleado = null;
    try {
      empleado = new EmpleadoFijo("Pepe", "11111111A", "666666666", 0);
    } catch (Exception e) {
      fail("Error al crear un empleado fijo con datos correctos");
    }
    assertEquals(0, empleado.getSalario());
  }

  @Test
  void testSalarioNegativo() {
    // Caso: Crear un empleado fijo con todos los datos correctos
    //       excepto salario que es -100
    // RE  : El empleado no se crea y se lanza IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new EmpleadoFijo("Paco", "11111111A", "666666666", -100));
  }

}
