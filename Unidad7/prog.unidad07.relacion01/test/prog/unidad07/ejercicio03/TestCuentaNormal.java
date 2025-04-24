package prog.unidad07.ejercicio03;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestCuentaNormal {
  
  @Test
  void testCreaCuentaConsultaSaldo() {
    Cuenta cuentaNormal = new CuentaNormal("Pepe", "11111111A");
    double saldo = cuentaNormal.getSaldo();
    assertEquals(0, saldo;
  }

  @Test
  void testCuentaNormalSaldoCero() {
    // Caso: Crea una cuenta normal y consulta el saldo
    // RE  : El saldo debe ser cero
    Cuenta cuenta = new CuentaNormal("Paco", "11111111A");
    assertEquals(0, cuenta.getSaldo());
  }

  @Test
  void testCuentaNormalSaldoCeroActualiza() {
    // Caso: Crea una cuenta normal, le hace una actualizacion mensual y consulta el saldo
    // RE  : El saldo debe ser cero
    Cuenta cuenta = new CuentaNormal("Paco", "11111111A");
    cuenta.actualizacionMensual();
    assertEquals(0, cuenta.getSaldo());
  }

  @Test
  void testCuentaNormalSaldo90() {
    // Caso: Crea una cuenta normal, ingresa 90 y consulta el saldo
    // RE  : El saldo debe ser 90
    Cuenta cuenta = new CuentaNormal("Paco", "11111111A");
    cuenta.ingreso(90);
    assertEquals(90, cuenta.getSaldo());
  }

  @Test
  void testCuentaNormalSaldo90Actualiza() {
    // Caso: Crea una cuenta normal, ingresa 90, actualiza y consulta el saldo
    // RE  : El saldo debe ser 81
    Cuenta cuenta = new CuentaNormal("Paco", "11111111A");
    cuenta.ingreso(90);
    cuenta.actualizacionMensual();
    assertEquals(81, cuenta.getSaldo());
  }

  @Test
  void testCuentaNormalSaldo100() {
    // Caso: Crea una cuenta normal, ingresa 100 y consulta el saldo
    // RE  : El saldo debe ser 100
    Cuenta cuenta = new CuentaNormal("Paco", "11111111A");
    cuenta.ingreso(100);
    assertEquals(100, cuenta.getSaldo());
  }

  @Test
  void testCuentaNormalSaldo100Actualiza() {
    // Caso: Crea una cuenta normal, ingresa 100, actualiza y consulta el saldo
    // RE  : El saldo debe ser 90
    Cuenta cuenta = new CuentaNormal("Paco", "11111111A");
    cuenta.ingreso(100);
    cuenta.actualizacionMensual();
    assertEquals(90, cuenta.getSaldo());
  }

  @Test
  void testCuentaNormalSaldo110() {
    // Caso: Crea una cuenta normal, ingresa 110 y consulta el saldo
    // RE  : El saldo debe ser 110
    Cuenta cuenta = new CuentaNormal("Paco", "11111111A");
    cuenta.ingreso(110);
    assertEquals(110, cuenta.getSaldo());
  }

  @Test
  void testCuentaNormalSaldo110Actualiza() {
    // Caso: Crea una cuenta normal, ingresa 110, actualiza y consulta el saldo
    // RE  : El saldo debe ser 100
    Cuenta cuenta = new CuentaNormal("Paco", "11111111A");
    cuenta.ingreso(110);
    cuenta.actualizacionMensual();
    assertEquals(100, cuenta.getSaldo());
  }

  @Test
  void testCuentaNormalSaldo200() {
    // Caso: Crea una cuenta normal, ingresa 200 y consulta el saldo
    // RE  : El saldo debe ser 200
    Cuenta cuenta = new CuentaNormal("Paco", "11111111A");
    cuenta.ingreso(200);
    assertEquals(200, cuenta.getSaldo());
  }

  @Test
  void testCuentaNormalSaldo200Actualiza() {
    // Caso: Crea una cuenta normal, ingresa 200, actualiza y consulta el saldo
    // RE  : El saldo debe ser 190
    Cuenta cuenta = new CuentaNormal("Paco", "11111111A");
    cuenta.ingreso(200);
    cuenta.actualizacionMensual();
    assertEquals(190, cuenta.getSaldo());
  }

  @Test
  void testCuentaNormalSaldo200Retirada() {
    // Caso: Crea una cuenta normal, ingresa 200, retira 50 y consulta el saldo
    // RE  : El saldo debe ser 150
    Cuenta cuenta = new CuentaNormal("Paco", "11111111A");
    cuenta.ingreso(200);
    cuenta.retirada(50);
    assertEquals(150, cuenta.getSaldo());
  }

  @Test
  void testCuentaNormalSaldo200RetiradaActualiza() {
    // Caso: Crea una cuenta normal, ingresa 200, retira 50, actualiza y consulta el saldo
    // RE  : El saldo debe ser 130 (10 comision + 10 penalizacion)
    Cuenta cuenta = new CuentaNormal("Paco", "11111111A");
    cuenta.ingreso(200);
    cuenta.retirada(50);
    cuenta.actualizacionMensual();
    assertEquals(130, cuenta.getSaldo());
  }

  @Test
  void testCuentaNormalSaldo600Retirada() {
    // Caso: Crea una cuenta normal, ingresa 600, retira 50 y consulta el saldo
    // RE  : El saldo debe ser 550
    Cuenta cuenta = new CuentaNormal("Paco", "11111111A");
    cuenta.ingreso(600);
    cuenta.retirada(50);
    assertEquals(550, cuenta.getSaldo());
  }

  @Test
  void testCuentaNormalSaldo600RetiradaActualiza() {
    // Caso: Crea una cuenta normal, ingresa 600, retira 50, actualiza y consulta el saldo
    // RE  : El saldo debe ser 540 (10 comision)
    Cuenta cuenta = new CuentaNormal("Paco", "11111111A");
    cuenta.ingreso(600);
    cuenta.retirada(50);
    cuenta.actualizacionMensual();
    assertEquals(540, cuenta.getSaldo());
  }

  @Test
  void testCuentaNormalSaldo550Retirada() {
    // Caso: Crea una cuenta normal, ingresa 550, retira 50 y consulta el saldo
    // RE  : El saldo debe ser 500
    Cuenta cuenta = new CuentaNormal("Paco", "11111111A");
    cuenta.ingreso(550);
    cuenta.retirada(50);
    assertEquals(500, cuenta.getSaldo());
  }

  @Test
  void testCuentaNormalSaldo550RetiradaActualiza() {
    // Caso: Crea una cuenta normal, ingresa 550, retira 50, actualiza y consulta el saldo
    // RE  : El saldo debe ser 490 (10 comision)
    Cuenta cuenta = new CuentaNormal("Paco", "11111111A");
    cuenta.ingreso(550);
    cuenta.retirada(50);
    cuenta.actualizacionMensual();
    assertEquals(490, cuenta.getSaldo());
  }

  @Test
  void testCuentaNormalSaldo549Retirada() {
    // Caso: Crea una cuenta normal, ingresa 549 retira 50 y consulta el saldo
    // RE  : El saldo debe ser 499
    Cuenta cuenta = new CuentaNormal("Paco", "11111111A");
    cuenta.ingreso(549);
    cuenta.retirada(50);
    assertEquals(499, cuenta.getSaldo());
  }

  @Test
  void testCuentaNormalSaldo549RetiradaActualiza() {
    // Caso: Crea una cuenta normal, ingresa 550, retira 50, actualiza y consulta el saldo
    // RE  : El saldo debe ser 479 (10 comision + 10 penalizacion)
    Cuenta cuenta = new CuentaNormal("Paco", "11111111A");
    cuenta.ingreso(549);
    cuenta.retirada(50);
    cuenta.actualizacionMensual();
    assertEquals(479, cuenta.getSaldo());
  }
  
  @Test
  void testCuentaNormalRetiradaExcesiva() {
    // Caso: Crea una cuenta normal, ingresa 500, retira 501
    // RE  : Se debe producir IllegalArgumentException en la retirada. El saldo debes seguir siendo 500
    Cuenta cuenta = new CuentaNormal("Paco", "11111111A");
    cuenta.ingreso(500);
    // Intenta retirar más del saldo. Debe producir exception
    assertThrows(IllegalArgumentException.class, () -> cuenta.retirada(501));
    assertEquals(500, cuenta.getSaldo());
  }
  
  @Test
  void testCuentaNormalSituacionRealista() {
    // Caso: Crea una cuenta normal, ingresa 1200, retira 259.88, retira 94.80, actualiza,
    //       ingresa 1200, retira 372.08, 659.14 y 388.66, actualiza,
    //       ingresa 1200, retira 412.56 y 30.09 y actualiza
    // RE  : El saldo final debe ser de 1352.79 euros
    Cuenta cuenta = new CuentaNormal("Paco", "11111111A");
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
    assertEquals(1339.07, cuenta.getSaldo());
  }
  

}
