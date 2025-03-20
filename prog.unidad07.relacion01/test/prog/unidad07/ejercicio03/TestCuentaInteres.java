package prog.unidad07.ejercicio03;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestCuentaInteres {

  @Test
  void testCuentaInteresSaldoCero() {
    // Caso: Crea una cuenta interes y consulta el saldo
    // RE  : El saldo debe ser cero
    Cuenta cuenta = new CuentaInteres("Paco", "11111111A");
    assertEquals(0, cuenta.getSaldo());
  }

  @Test
  void testCuentaInteresSaldoCeroActualiza() {
    // Caso: Crea una cuenta interes, le hace una actualizacion mensual y consulta el saldo
    // RE  : El saldo debe ser cero
    Cuenta cuenta = new CuentaInteres("Paco", "11111111A");
    cuenta.actualizacionMensual();
    assertEquals(0, cuenta.getSaldo());
  }

  @Test
  void testCuentaInteresSaldo90() {
    // Caso: Crea una cuenta interes, ingresa 90 y consulta el saldo
    // RE  : El saldo debe ser 90
    Cuenta cuenta = new CuentaInteres("Paco", "11111111A");
    cuenta.ingreso(90);
    assertEquals(90, cuenta.getSaldo());
  }

  @Test
  void testCuentaInteresSaldo90Actualiza() {
    // Caso: Crea una cuenta interes, ingresa 90, actualiza y consulta el saldo
    // RE  : El saldo debe ser 81.53 (-9 euros de comisión, 0.53 de intereses)
    Cuenta cuenta = new CuentaInteres("Paco", "11111111A");
    cuenta.ingreso(90);
    cuenta.actualizacionMensual();
    assertEquals(81.53, cuenta.getSaldo());
  }

  @Test
  void testCuentaInteresSaldo90ActualizaActualiza() {
    // Caso: Crea una cuenta interes, ingresa 90, actualiza dos veces y consulta el saldo
    // RE  : El saldo debe ser 73.86 (-9 y -8.15 euros de comisión, 0.53 y 0.48 de intereses)
    Cuenta cuenta = new CuentaInteres("Paco", "11111111A");
    cuenta.ingreso(90);
    cuenta.actualizacionMensual();
    cuenta.actualizacionMensual();
    assertEquals(73.86, cuenta.getSaldo());
  }

  @Test
  void testCuentaInteresSaldo100() {
    // Caso: Crea una cuenta interes, ingresa 100 y consulta el saldo
    // RE  : El saldo debe ser 100
    Cuenta cuenta = new CuentaInteres("Paco", "11111111A");
    cuenta.ingreso(100);
    assertEquals(100, cuenta.getSaldo());
  }

  @Test
  void testCuentaInteresSaldo100Actualiza() {
    // Caso: Crea una cuenta interes, ingresa 100, actualiza y consulta el saldo
    // RE  : El saldo debe ser 90.58 (-10 euros de comisiones y 0.58 de intereses
    Cuenta cuenta = new CuentaInteres("Paco", "11111111A");
    cuenta.ingreso(100);
    cuenta.actualizacionMensual();
    assertEquals(90.58, cuenta.getSaldo());
  }

  @Test
  void testCuentaInteresSaldo100ActualizaActualiza() {
    // Caso: Crea una cuenta interes, ingresa 100, actualiza dos veces y consulta el saldo
    // RE  : El saldo debe ser 82.05 (-10 y -9.06 euros de comisiones y 0.58 y 0.53 de intereses
    Cuenta cuenta = new CuentaInteres("Paco", "11111111A");
    cuenta.ingreso(100);
    cuenta.actualizacionMensual();
    cuenta.actualizacionMensual();
    assertEquals(82.05, cuenta.getSaldo());
  }

  @Test
  void testCuentaInteresSaldo110() {
    // Caso: Crea una cuenta interes, ingresa 110 y consulta el saldo
    // RE  : El saldo debe ser 110
    Cuenta cuenta = new CuentaInteres("Paco", "11111111A");
    cuenta.ingreso(110);
    assertEquals(110, cuenta.getSaldo());
  }

  @Test
  void testCuentaInteresSaldo110Actualiza() {
    // Caso: Crea una cuenta interes, ingresa 110, actualiza y consulta el saldo
    // RE  : El saldo debe ser 100.64 (-10 de comisiones y 0.64 de intereses)
    Cuenta cuenta = new CuentaInteres("Paco", "11111111A");
    cuenta.ingreso(110);
    cuenta.actualizacionMensual();
    assertEquals(100.64, cuenta.getSaldo());
  }

  @Test
  void testCuentaInteresSaldo200() {
    // Caso: Crea una cuenta interes, ingresa 200 y consulta el saldo
    // RE  : El saldo debe ser 200
    Cuenta cuenta = new CuentaInteres("Paco", "11111111A");
    cuenta.ingreso(200);
    assertEquals(200, cuenta.getSaldo());
  }

  @Test
  void testCuentaInteresSaldo200Actualiza() {
    // Caso: Crea una cuenta interes, ingresa 200, actualiza y consulta el saldo
    // RE  : El saldo debe ser 191.17 (-10 de comisiones y 1.17 de intereses)
    Cuenta cuenta = new CuentaInteres("Paco", "11111111A");
    cuenta.ingreso(200);
    cuenta.actualizacionMensual();
    assertEquals(191.17, cuenta.getSaldo());
  }

  @Test
  void testCuentaInteresSaldo200Retirada() {
    // Caso: Crea una cuenta interes, ingresa 200, retira 50 y consulta el saldo
    // RE  : El saldo debe ser 150
    Cuenta cuenta = new CuentaInteres("Paco", "11111111A");
    cuenta.ingreso(200);
    cuenta.retirada(50);
    assertEquals(150, cuenta.getSaldo());
  }

  @Test
  void testCuentaInteresSaldo200RetiradaActualiza() {
    // Caso: Crea una cuenta interes, ingresa 200, retira 50, actualiza y consulta el saldo
    // RE  : El saldo debe ser 140.88 (-10 comision y 0.88 de intereses)
    Cuenta cuenta = new CuentaInteres("Paco", "11111111A");
    cuenta.ingreso(200);
    cuenta.retirada(50);
    cuenta.actualizacionMensual();
    assertEquals(140.88, cuenta.getSaldo());
  }

  @Test
  void testCuentaInteresSaldo600Retirada() {
    // Caso: Crea una cuenta interes, ingresa 600, retira 50 y consulta el saldo
    // RE  : El saldo debe ser 550
    Cuenta cuenta = new CuentaInteres("Paco", "11111111A");
    cuenta.ingreso(600);
    cuenta.retirada(50);
    assertEquals(550, cuenta.getSaldo());
  }

  @Test
  void testCuentaInteresSaldo600RetiradaActualiza() {
    // Caso: Crea una cuenta interes, ingresa 600, retira 50, actualiza y consulta el saldo
    // RE  : El saldo debe ser 543.21 (-10 comision y 3.21 de intereses)
    Cuenta cuenta = new CuentaInteres("Paco", "11111111A");
    cuenta.ingreso(600);
    cuenta.retirada(50);
    cuenta.actualizacionMensual();
    assertEquals(543.21, cuenta.getSaldo());
  }

  @Test
  void testCuentaInteresSaldo550Retirada() {
    // Caso: Crea una cuenta interes, ingresa 550, retira 50 y consulta el saldo
    // RE  : El saldo debe ser 500
    Cuenta cuenta = new CuentaInteres("Paco", "11111111A");
    cuenta.ingreso(550);
    cuenta.retirada(50);
    assertEquals(500, cuenta.getSaldo());
  }

  @Test
  void testCuentaInteresSaldo550RetiradaActualiza() {
    // Caso: Crea una cuenta interes, ingresa 550, retira 50, actualiza y consulta el saldo
    // RE  : El saldo debe ser 492.92 (-10 comision y 2.92 de intereses)
    Cuenta cuenta = new CuentaInteres("Paco", "11111111A");
    cuenta.ingreso(550);
    cuenta.retirada(50);
    cuenta.actualizacionMensual();
    assertEquals(492.92, cuenta.getSaldo());
  }

  @Test
  void testCuentaInteresSaldo549Retirada() {
    // Caso: Crea una cuenta interes, ingresa 549 retira 50 y consulta el saldo
    // RE  : El saldo debe ser 499
    Cuenta cuenta = new CuentaInteres("Paco", "11111111A");
    cuenta.ingreso(549);
    cuenta.retirada(50);
    assertEquals(499, cuenta.getSaldo());
  }

  @Test
  void testCuentaInteresSaldo549RetiradaActualiza() {
    // Caso: Crea una cuenta interes, ingresa 549, retira 50, actualiza y consulta el saldo
    // RE  : El saldo debe ser 491.91 (-10 comision y 2.91 de intereses)
    Cuenta cuenta = new CuentaInteres("Paco", "11111111A");
    cuenta.ingreso(549);
    cuenta.retirada(50);
    cuenta.actualizacionMensual();
    assertEquals(491.91, cuenta.getSaldo());
  }
  
  @Test
  void testCuentaInteresRetiradaExcesiva() {
    // Caso: Crea una cuenta interes, ingresa 500, retira 501
    // RE  : Se debe producir IllegalArgumentException en la retirada. El saldo debes seguir siendo 500
    Cuenta cuenta = new CuentaInteres("Paco", "11111111A");
    cuenta.ingreso(500);
    // Intenta retirar más del saldo. Debe producir exception
    assertThrows(IllegalArgumentException.class, () -> cuenta.retirada(501));
    assertEquals(500, cuenta.getSaldo());
  }
  
  @Test
  void testCuentaInteresSituacionRealista() {
    // Caso: Crea una cuenta interes, ingresa 1200, retira 259.88, retira 94.80, actualiza,
    //       ingresa 1200, retira 372.08, 659.14 y 388.66, actualiza,
    //       ingresa 1200, retira 412.56 y 30.09 y actualiza
    // RE  : El saldo final debe ser de 1369.34 euros
    Cuenta cuenta = new CuentaInteres("Paco", "11111111A");
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
    assertEquals(1369.34, cuenta.getSaldo());
  }
  

}
