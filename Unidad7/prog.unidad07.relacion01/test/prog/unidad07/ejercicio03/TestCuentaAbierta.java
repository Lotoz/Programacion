package prog.unidad07.ejercicio03;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestCuentaAbierta {

  @Test
  void testCuentaAbiertaSaldoCero() {
    // Caso: Crea una cuenta abierta y consulta el saldo
    // RE  : El saldo debe ser cero
    Cuenta cuenta = new CuentaAbierta("Paco", "11111111A");
    assertEquals(0, cuenta.getSaldo());
  }

  @Test
  void testCuentaAbiertaSaldoCeroActualiza() {
    // Caso: Crea una cuenta abierta, le hace una actualizacion mensual y consulta el saldo
    // RE  : El saldo debe ser cero
    Cuenta cuenta = new CuentaAbierta("Paco", "11111111A");
    cuenta.actualizacionMensual();
    assertEquals(0, cuenta.getSaldo());
  }

  @Test
  void testCuentaAbiertaSaldo90() {
    // Caso: Crea una cuenta abierta, ingresa 90 y consulta el saldo
    // RE  : El saldo debe ser 90
    Cuenta cuenta = new CuentaAbierta("Paco", "11111111A");
    cuenta.ingreso(90);
    assertEquals(90, cuenta.getSaldo());
  }

  @Test
  void testCuentaAbiertaSaldo90Actualiza() {
    // Caso: Crea una cuenta abierta, ingresa 90, actualiza y consulta el saldo
    // RE  : El saldo debe ser 81.43 (-9 euros de comisión, -0.1 por 1 transaccion, 0.53 de intereses)
    Cuenta cuenta = new CuentaAbierta("Paco", "11111111A");
    cuenta.ingreso(90);
    cuenta.actualizacionMensual();
    assertEquals(81.43, cuenta.getSaldo());
  }

  @Test
  void testCuentaAbiertaSaldo90ActualizaActualiza() {
    // Caso: Crea una cuenta abierta, ingresa 90, actualiza dos veces y consulta el saldo
    // RE  : El saldo debe ser 73.77 (-9 y -8.05 euros de comisión. -0.1 por 1 transaccion (en la primera actualización) , 0.53 y 0.48 de intereses)
    Cuenta cuenta = new CuentaAbierta("Paco", "11111111A");
    cuenta.ingreso(90);
    cuenta.actualizacionMensual();
    cuenta.actualizacionMensual();
    assertEquals(73.77, cuenta.getSaldo());
  }

  @Test
  void testCuentaAbiertaSaldo100() {
    // Caso: Crea una cuenta abierta, ingresa 100 y consulta el saldo
    // RE  : El saldo debe ser 100
    Cuenta cuenta = new CuentaAbierta("Paco", "11111111A");
    cuenta.ingreso(100);
    assertEquals(100, cuenta.getSaldo());
  }

  @Test
  void testCuentaAbiertaSaldo100Actualiza() {
    // Caso: Crea una cuenta abierta, ingresa 100, actualiza y consulta el saldo
    // RE  : El saldo debe ser 90.48 (-10 euros de comisiones, -0.1 por 1 transaccion y 0.58 de intereses
    Cuenta cuenta = new CuentaAbierta("Paco", "11111111A");
    cuenta.ingreso(100);
    cuenta.actualizacionMensual();
    assertEquals(90.48, cuenta.getSaldo());
  }

  @Test
  void testCuentaAbiertaSaldo100ActualizaActualiza() {
    // Caso: Crea una cuenta abierta, ingresa 100, actualiza dos veces y consulta el saldo
    // RE  : El saldo debe ser 81.96 (-10 y -9.05 euros de comisiones, -0.1 por 1 transaccion (en la primera actualizacion) y 0.58 y 0.53 de intereses
    Cuenta cuenta = new CuentaAbierta("Paco", "11111111A");
    cuenta.ingreso(100);
    cuenta.actualizacionMensual();
    cuenta.actualizacionMensual();
    assertEquals(81.96, cuenta.getSaldo());
  }

  @Test
  void testCuentaAbiertaSaldo110() {
    // Caso: Crea una cuenta abierta, ingresa 110 y consulta el saldo
    // RE  : El saldo debe ser 110
    Cuenta cuenta = new CuentaAbierta("Paco", "11111111A");
    cuenta.ingreso(110);
    assertEquals(110, cuenta.getSaldo());
  }

  @Test
  void testCuentaAbiertaSaldo110Actualiza() {
    // Caso: Crea una cuenta abierta, ingresa 110, actualiza y consulta el saldo
    // RE  : El saldo debe ser 100.54 (-10 de comisiones, -0.10 por 1 transacción y 0.64 de intereses)
    Cuenta cuenta = new CuentaAbierta("Paco", "11111111A");
    cuenta.ingreso(110);
    cuenta.actualizacionMensual();
    assertEquals(100.54, cuenta.getSaldo());
  }

  @Test
  void testCuentaAbiertaSaldo200() {
    // Caso: Crea una cuenta abierta, ingresa 200 y consulta el saldo
    // RE  : El saldo debe ser 200
    Cuenta cuenta = new CuentaAbierta("Paco", "11111111A");
    cuenta.ingreso(200);
    assertEquals(200, cuenta.getSaldo());
  }

  @Test
  void testCuentaAbiertaSaldo200Actualiza() {
    // Caso: Crea una cuenta abierta, ingresa 200, actualiza y consulta el saldo
    // RE  : El saldo debe ser 191.07 (-10 de comisiones , -0.1 por una transaccion y 1.17 de intereses)
    Cuenta cuenta = new CuentaAbierta("Paco", "11111111A");
    cuenta.ingreso(200);
    cuenta.actualizacionMensual();
    assertEquals(191.07, cuenta.getSaldo());
  }

  @Test
  void testCuentaAbiertaSaldo200Retirada() {
    // Caso: Crea una cuenta abierta, ingresa 200, retira 50 y consulta el saldo
    // RE  : El saldo debe ser 150
    Cuenta cuenta = new CuentaAbierta("Paco", "11111111A");
    cuenta.ingreso(200);
    cuenta.retirada(50);
    assertEquals(150, cuenta.getSaldo());
  }

  @Test
  void testCuentaAbiertaSaldo200RetiradaActualiza() {
    // Caso: Crea una cuenta abierta, ingresa 200, retira 50, actualiza y consulta el saldo
    // RE  : El saldo debe ser 140.68 (-10 comision, -0.2 por dos transacciones y 0.88 de intereses)
    Cuenta cuenta = new CuentaAbierta("Paco", "11111111A");
    cuenta.ingreso(200);
    cuenta.retirada(50);
    cuenta.actualizacionMensual();
    assertEquals(140.68, cuenta.getSaldo());
  }

  @Test
  void testCuentaAbiertaSaldo600Retirada() {
    // Caso: Crea una cuenta abierta, ingresa 600, retira 50 y consulta el saldo
    // RE  : El saldo debe ser 550
    Cuenta cuenta = new CuentaAbierta("Paco", "11111111A");
    cuenta.ingreso(600);
    cuenta.retirada(50);
    assertEquals(550, cuenta.getSaldo());
  }

  @Test
  void testCuentaAbiertaSaldo600RetiradaActualiza() {
    // Caso: Crea una cuenta abierta, ingresa 600, retira 50, actualiza y consulta el saldo
    // RE  : El saldo debe ser 543.01 (-10 comision, -0.2 por dos transacciones y 3.21 de intereses)
    Cuenta cuenta = new CuentaAbierta("Paco", "11111111A");
    cuenta.ingreso(600);
    cuenta.retirada(50);
    cuenta.actualizacionMensual();
    assertEquals(543.01, cuenta.getSaldo());
  }

  @Test
  void testCuentaAbiertaSaldo550Retirada() {
    // Caso: Crea una cuenta abierta, ingresa 550, retira 50 y consulta el saldo
    // RE  : El saldo debe ser 500
    Cuenta cuenta = new CuentaAbierta("Paco", "11111111A");
    cuenta.ingreso(550);
    cuenta.retirada(50);
    assertEquals(500, cuenta.getSaldo());
  }

  @Test
  void testCuentaAbiertaSaldo550RetiradaActualiza() {
    // Caso: Crea una cuenta abierta, ingresa 550, retira 50, actualiza y consulta el saldo
    // RE  : El saldo debe ser 492.72 (-10 comision, -0.2 por dos transacciones y 2.92 de intereses)
    Cuenta cuenta = new CuentaAbierta("Paco", "11111111A");
    cuenta.ingreso(550);
    cuenta.retirada(50);
    cuenta.actualizacionMensual();
    assertEquals(492.72, cuenta.getSaldo());
  }

  @Test
  void testCuentaAbiertaSaldo549Retirada() {
    // Caso: Crea una cuenta abierta, ingresa 549 retira 50 y consulta el saldo
    // RE  : El saldo debe ser 499
    Cuenta cuenta = new CuentaAbierta("Paco", "11111111A");
    cuenta.ingreso(549);
    cuenta.retirada(50);
    assertEquals(499, cuenta.getSaldo());
  }

  @Test
  void testCuentaAbiertaSaldo549RetiradaActualiza() {
    // Caso: Crea una cuenta abierta, ingresa 549, retira 50, actualiza y consulta el saldo
    // RE  : El saldo debe ser 491.71 (-10 comision, -0.2 por dos transacciones y 2.91 de intereses)
    Cuenta cuenta = new CuentaAbierta("Paco", "11111111A");
    cuenta.ingreso(549);
    cuenta.retirada(50);
    cuenta.actualizacionMensual();
    assertEquals(491.71, cuenta.getSaldo());
  }
  
  @Test
  void testCuentaAbiertaRetiradaExcesiva() {
    // Caso: Crea una cuenta abierta, ingresa 500, retira 501
    // RE  : Se debe producir IllegalArgumentException en la retirada. El saldo debes seguir siendo 500
    Cuenta cuenta = new CuentaAbierta("Paco", "11111111A");
    cuenta.ingreso(500);
    // Intenta retirar más del saldo. Debe producir exception
    assertThrows(IllegalArgumentException.class, () -> cuenta.retirada(501));
    assertEquals(500, cuenta.getSaldo());
  }
  
  @Test
  void testCuentaAbiertaSituacionRealista() {
    // Caso: Crea una cuenta abierta, ingresa 1200, retira 259.88, retira 94.80, actualiza,
    //       ingresa 1200, retira 372.08, 659.14 y 388.66, actualiza,
    //       ingresa 1200, retira 412.56 y 30.09 y actualiza
    // RE  : El saldo final debe ser de 1368.34 euros
    Cuenta cuenta = new CuentaAbierta("Paco", "11111111A");
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
    assertEquals(1368.34, cuenta.getSaldo());
  }
}
