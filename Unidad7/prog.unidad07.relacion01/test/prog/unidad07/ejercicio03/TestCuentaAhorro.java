package prog.unidad07.ejercicio03;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestCuentaAhorro {

  @Test
  void testCuentaAhorroSaldoCero() {
    // Caso: Crea una cuenta ahorro y consulta el saldo
    // RE  : El saldo debe ser cero
    Cuenta cuenta = new CuentaAhorro("Paco", "11111111A");
    assertEquals(0, cuenta.getSaldo());
  }

  @Test
  void testCuentaAhorroSaldoCeroActualiza() {
    // Caso: Crea una cuenta ahorro, le hace una actualizacion mensual y consulta el saldo
    // RE  : El saldo debe ser cero
    Cuenta cuenta = new CuentaAhorro("Paco", "11111111A");
    cuenta.actualizacionMensual();
    assertEquals(0, cuenta.getSaldo());
  }

  @Test
  void testCuentaAhorroSaldo90() {
    // Caso: Crea una cuenta ahorro, ingresa 90 y consulta el saldo
    // RE  : El saldo debe ser 90
    Cuenta cuenta = new CuentaAhorro("Paco", "11111111A");
    cuenta.ingreso(90);
    assertEquals(90, cuenta.getSaldo());
  }

  @Test
  void testCuentaAhorroSaldo90Actualiza() {
    // Caso: Crea una cuenta ahorro, ingresa 90, actualiza y consulta el saldo
    // RE  : El saldo debe ser 82.13 (-9 euros de comisión y 1.13 de intereses)
    Cuenta cuenta = new CuentaAhorro("Paco", "11111111A");
    cuenta.ingreso(90);
    cuenta.actualizacionMensual();
    assertEquals(82.13, cuenta.getSaldo());
  }

  @Test
  void testCuentaAhorroSaldo90ActualizaActualiza() {
    // Caso: Crea una cuenta ahorro, ingresa 90, actualiza dos veces y consulta el saldo
    // RE  : El saldo debe ser 74.95 (-9 y -8.21 euros de comisión y 1.13, 1.03 de intereses)
    Cuenta cuenta = new CuentaAhorro("Paco", "11111111A");
    cuenta.ingreso(90);
    cuenta.actualizacionMensual();
    cuenta.actualizacionMensual();
    assertEquals(74.95, cuenta.getSaldo());
  }

  @Test
  void testCuentaAhorroSaldo100() {
    // Caso: Crea una cuenta ahorro, ingresa 100 y consulta el saldo
    // RE  : El saldo debe ser 100
    Cuenta cuenta = new CuentaAhorro("Paco", "11111111A");
    cuenta.ingreso(100);
    assertEquals(100, cuenta.getSaldo());
  }

  @Test
  void testCuentaAhorroSaldo100Actualiza() {
    // Caso: Crea una cuenta ahorro, ingresa 100, actualiza y consulta el saldo
    // RE  : El saldo debe ser 91.25 (-10 euros de comisiones y 1.25 de intereses
    Cuenta cuenta = new CuentaAhorro("Paco", "11111111A");
    cuenta.ingreso(100);
    cuenta.actualizacionMensual();
    assertEquals(91.25, cuenta.getSaldo());
  }

  @Test
  void testCuentaAhorroSaldo100ActualizaActualiza() {
    // Caso: Crea una cuenta ahorro, ingresa 100, actualiza dos veces y consulta el saldo
    // RE  : El saldo debe ser 83.26 (-10 y -9.13 euros de comisiones y 1.25 y 1.14 de intereses
    Cuenta cuenta = new CuentaAhorro("Paco", "11111111A");
    cuenta.ingreso(100);
    cuenta.actualizacionMensual();
    cuenta.actualizacionMensual();
    assertEquals(83.26, cuenta.getSaldo());
  }

  @Test
  void testCuentaAhorroSaldo110() {
    // Caso: Crea una cuenta ahorro, ingresa 110 y consulta el saldo
    // RE  : El saldo debe ser 110
    Cuenta cuenta = new CuentaAhorro("Paco", "11111111A");
    cuenta.ingreso(110);
    assertEquals(110, cuenta.getSaldo());
  }

  @Test
  void testCuentaAhorroSaldo110Actualiza() {
    // Caso: Crea una cuenta ahorro, ingresa 110, actualiza y consulta el saldo
    // RE  : El saldo debe ser 101.38 (-10 de comisiones y 1.38 de intereses)
    Cuenta cuenta = new CuentaAhorro("Paco", "11111111A");
    cuenta.ingreso(110);
    cuenta.actualizacionMensual();
    assertEquals(101.38, cuenta.getSaldo());
  }

  @Test
  void testCuentaAhorroSaldo200() {
    // Caso: Crea una cuenta ahorro, ingresa 200 y consulta el saldo
    // RE  : El saldo debe ser 200
    Cuenta cuenta = new CuentaAhorro("Paco", "11111111A");
    cuenta.ingreso(200);
    assertEquals(200, cuenta.getSaldo());
  }

  @Test
  void testCuentaAhorroSaldo200Actualiza() {
    // Caso: Crea una cuenta ahorro, ingresa 200, actualiza y consulta el saldo
    // RE  : El saldo debe ser 192.50 (-10 de comisiones y 2.50 de intereses)
    Cuenta cuenta = new CuentaAhorro("Paco", "11111111A");
    cuenta.ingreso(200);
    cuenta.actualizacionMensual();
    assertEquals(192.50, cuenta.getSaldo());
  }

  @Test
  void testCuentaAhorroSaldo200Retirada() {
    // Caso: Crea una cuenta ahorro, ingresa 200, retira 50 y consulta el saldo
    // RE  : El saldo debe ser 150
    Cuenta cuenta = new CuentaAhorro("Paco", "11111111A");
    cuenta.ingreso(200);
    cuenta.retirada(50);
    assertEquals(150, cuenta.getSaldo());
  }

  @Test
  void testCuentaAhorroSaldo200RetiradaActualiza() {
    // Caso: Crea una cuenta ahorro, ingresa 200, retira 50, actualiza y consulta el saldo
    // RE  : El saldo debe ser 101.88 (-10 comision, -40 por penalizacion y 1.88 de intereses)
    Cuenta cuenta = new CuentaAhorro("Paco", "11111111A");
    cuenta.ingreso(200);
    cuenta.retirada(50);
    cuenta.actualizacionMensual();
    assertEquals(101.88, cuenta.getSaldo());
  }

  @Test
  void testCuentaAhorroSaldo600Retirada() {
    // Caso: Crea una cuenta ahorro, ingresa 600, retira 50 y consulta el saldo
    // RE  : El saldo debe ser 550
    Cuenta cuenta = new CuentaAhorro("Paco", "11111111A");
    cuenta.ingreso(600);
    cuenta.retirada(50);
    assertEquals(550, cuenta.getSaldo());
  }

  @Test
  void testCuentaAhorroSaldo600RetiradaActualiza() {
    // Caso: Crea una cuenta ahorro, ingresa 600, retira 50, actualiza y consulta el saldo
    // RE  : El saldo debe ser 426.88 (-10 comision, -120 de penalización y +6.88 de intereses)
    Cuenta cuenta = new CuentaAhorro("Paco", "11111111A");
    cuenta.ingreso(600);
    cuenta.retirada(50);
    cuenta.actualizacionMensual();
    assertEquals(426.88, cuenta.getSaldo());
  }

  @Test
  void testCuentaAhorroSaldo550Retirada() {
    // Caso: Crea una cuenta ahorro, ingresa 550, retira 50 y consulta el saldo
    // RE  : El saldo debe ser 500
    Cuenta cuenta = new CuentaAhorro("Paco", "11111111A");
    cuenta.ingreso(550);
    cuenta.retirada(50);
    assertEquals(500, cuenta.getSaldo());
  }

  @Test
  void testCuentaAhorroSaldo550RetiradaActualiza() {
    // Caso: Crea una cuenta ahorro, ingresa 550, retira 50, actualiza y consulta el saldo
    // RE  : El saldo debe ser 386.25 (-10 comision, -110 por penalización y 6.25 de intereses)
    Cuenta cuenta = new CuentaAhorro("Paco", "11111111A");
    cuenta.ingreso(550);
    cuenta.retirada(50);
    cuenta.actualizacionMensual();
    assertEquals(386.25, cuenta.getSaldo());
  }

  @Test
  void testCuentaAhorroSaldo549Retirada() {
    // Caso: Crea una cuenta ahorro, ingresa 549 retira 50 y consulta el saldo
    // RE  : El saldo debe ser 499
    Cuenta cuenta = new CuentaAhorro("Paco", "11111111A");
    cuenta.ingreso(549);
    cuenta.retirada(50);
    assertEquals(499, cuenta.getSaldo());
  }

  @Test
  void testCuentaAhorroSaldo549RetiradaActualiza() {
    // Caso: Crea una cuenta ahorro, ingresa 549, retira 50, actualiza y consulta el saldo
    // RE  : El saldo debe ser 385.44 (-10 comision, -109.8 por penalización y 6.24 de intereses)
    Cuenta cuenta = new CuentaAhorro("Paco", "11111111A");
    cuenta.ingreso(549);
    cuenta.retirada(50);
    cuenta.actualizacionMensual();
    assertEquals(385.44, cuenta.getSaldo());
  }
  
  @Test
  void testCuentaAhorroRetiradaExcesiva() {
    // Caso: Crea una cuenta ahorro, ingresa 500, retira 501
    // RE  : Se debe producir IllegalArgumentException en la retirada. El saldo debes seguir siendo 500
    Cuenta cuenta = new CuentaAhorro("Paco", "11111111A");
    cuenta.ingreso(500);
    // Intenta retirar más del saldo. Debe producir exception
    assertThrows(IllegalArgumentException.class, () -> cuenta.retirada(501));
    assertEquals(500, cuenta.getSaldo());
  }
  
  @Test
  void testCuentaAhorroSituacionRealista() {
    // Caso: Crea una cuenta ahorro, ingresa 1200, retira 259.88, retira 94.80, actualiza,
    //       ingresa 1200, retira 372.08, 659.14 y 388.66, actualiza,
    //       ingresa 1200, retira 412.56 y 30.09 y actualiza
    // RE  : El saldo final debe ser de 817.18 euros
    Cuenta cuenta = new CuentaAhorro("Paco", "11111111A");
    cuenta.ingreso(1200);
    cuenta.retirada(259.88);
    cuenta.retirada(94.8);
    cuenta.actualizacionMensual();
    cuenta.ingreso(1200);
    cuenta.retirada(372.08);
    cuenta.retirada(659.14);
    cuenta.retirada(388.66);
    cuenta.actualizacionMensual();
    cuenta.ingreso(1200);
    cuenta.retirada(412.56);
    cuenta.retirada(30.09);
    cuenta.actualizacionMensual();
    assertEquals(817.18, cuenta.getSaldo());
  }
}
