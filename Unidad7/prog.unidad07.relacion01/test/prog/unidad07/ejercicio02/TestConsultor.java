package prog.unidad07.ejercicio02;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import prog.unidad07.ejercicio02.Consultor;
import prog.unidad07.ejercicio02.Empleado;

class TestConsultor {

  @Test
  void testTodoNormal() {
    // Caso: Crear un consultor con los datos correctos y tarifa 100 euros y 8 horas trabajadas
    // RE  : El empleado se crea correctamente y su salario es de 800 euros
    Empleado empleado = null;
    try {
      empleado = new Consultor("Pepe", "11111111A", "666666666", 100, 8);
    } catch (Exception e) {
      fail("Error al crear un consultor con datos correctos");
    }
    assertEquals(800, empleado.getSalario());
  }

  @Test
  void testNombreNull() {
    // Caso: Crear un consultor con todos los datos correctos
    //       excepto nombre que es null
    // RE  : El consultor no se crea y se lanza NullPointerException
    assertThrows(NullPointerException.class, () -> new Consultor(null, "11111111A", "666666666", 100, 8));
  }

  @Test
  void testDNINull() {
    // Caso: Crear un consultor con todos los datos correctos
    //       excepto dni que es null
    // RE  : El consultor no se crea y se lanza NullPointerException
    assertThrows(NullPointerException.class, () -> new Consultor("Paco", null, "666666666", 100, 8));
  }

  @Test
  void testTelefonoNull() {
    // Caso: Crear un consultor con todos los datos correctos
    //       excepto telefono que es null
    // RE  : El consultor no se crea y se lanza NullPointerException
    assertThrows(NullPointerException.class, () -> new Consultor("Paco", "11111111A", null, 100, 8));
  }

  @Test
  void testTarifaCero() {
    // Caso: Crear un consultor con datos correctos, tarifa 0 euros y 8 horas trabajadas
    // RE  : El consultor se crea correctamente y su salario es de 0 euros
    Empleado empleado = null;
    try {
      empleado = new Consultor("Pepe", "11111111A", "666666666", 0, 8);
    } catch (Exception e) {
      fail("Error al crear un consultor con datos correctos");
    }
    assertEquals(0, empleado.getSalario());
  }

  @Test
  void testHorasCero() {
    // Caso: Crear un consultor con datos correctos, tarifa 100 euros y 0 horas trabajadas
    // RE  : El consultor se crea correctamente y su salario es de 0 euros
    Empleado empleado = null;
    try {
      empleado = new Consultor("Pepe", "11111111A", "666666666", 100, 0);
    } catch (Exception e) {
      fail("Error al crear un consultor con datos correctos");
    }
    assertEquals(0, empleado.getSalario());
  }

  @Test
  void testTarifaNegativa() {
    // Caso: Crear un consultor con todos los datos correctos
    //       excepto tarifa que es -100
    // RE  : El consultor no se crea y se lanza IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Consultor("Paco", "11111111A", "666666666", -100, 8));
  }

  @Test
  void testHorasNegativas() {
    // Caso: Crear un consultor con todos los datos correctos
    //       excepto horas que es -5
    // RE  : El consultor no se crea y se lanza IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Consultor("Paco", "11111111A", "666666666", 100, -5));
  }

}
