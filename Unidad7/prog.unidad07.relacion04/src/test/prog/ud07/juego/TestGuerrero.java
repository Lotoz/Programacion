package test.prog.ud07.juego;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import prog.ud07.juego.Guerrero;

class TestGuerrero {

  @Test
  void testConstruccionOk() {
    // Caso: Crea un Guerrero con datos correctos
    // RE  : El guerrero se crea sin excepciones
    Guerrero guerrero = new Guerrero("Kandor", 100, true, Guerrero.ARMA_ESPADA);
  }

  @Test
  void testConstruccionOk2() {
    // Caso: Crea un Guerrero con datos correctos
    // RE  : El guerrero se crea sin excepciones
    Guerrero guerrero = new Guerrero("Kandor", 100, false, Guerrero.ARMA_ESPADA);
  }

  @Test
  void testConstruccionOk3() {
    // Caso: Crea un Guerrero con datos correctos
    // RE  : El guerrero se crea sin excepciones
    Guerrero guerrero = new Guerrero("Kandor", 100, true, Guerrero.ARMA_MAZA);
  }

  @Test
  void testConstruccionOk4() {
    // Caso: Crea un Guerrero con datos correctos
    // RE  : El guerrero se crea sin excepciones
    Guerrero guerrero = new Guerrero("Kandor", 100, false, Guerrero.ARMA_MAZA);
  }

  @Test
  void testConstruccionNombreNull() {
    // Caso: Crea un Guerrero con nombre nulo
    // RE  : El guerrero no se crea con NullPointerException
    assertThrows(NullPointerException.class, () -> new Guerrero(null, 100, true,
      Guerrero.ARMA_ESPADA));
  }

  @Test
  void testConstruccionNombreSoloBlancos() {
    // Caso: Crea un Guerrero con nombre solo blancos
    // RE  : El guerrero no se crea con IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Guerrero("  ", 100, true,
      Guerrero.ARMA_ESPADA));
  }

  @Test
  void testConstruccionVidaCero() {
    // Caso: Crea un Guerrero con vida a cero
    // RE  : El guerrero no se crea con IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Guerrero("Kandor", 0, true,
      Guerrero.ARMA_ESPADA));
  }

  @Test
  void testConstruccionVidaNegativo() {
    // Caso: Crea un Guerrero con vida negativa
    // RE  : El guerrero no se crea con IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Guerrero("Kandor", -1, true,
      Guerrero.ARMA_ESPADA));
  }

  @Test
  void testConstruccionArmaInvalida() {
    // Caso: Crea un Guerrero con arma no válida
    // RE  : El guerrero no se crea con IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Guerrero("Kandor", 100, true,
      -1));
  }

  @Test
  void testRecibeAtaqueConArmaduraEspada() {
    // Caso: Crea un Guerrero con 100 de vida, CON armadura y ESPADA. Recibe un ataque de 50
    // RE  : Debe estar vivo, SIN armadura, con una vida de 75, puntuación de ataque 37, puntuación de curación 0 
    Guerrero guerrero = new Guerrero("Kandor", 100, true, Guerrero.ARMA_ESPADA);
    guerrero.recibeAtaque(50);
    assertTrue(guerrero.estaVivo());
    assertFalse(guerrero.tieneArmadura());
    assertEquals(75, guerrero.getVida());
    assertEquals(37, guerrero.getLetalidad());
    assertEquals(0, guerrero.getPoderCuracion());
  }

  @Test
  void testRecibeAtaqueSinArmaduraEspada() {
    // Caso: Crea un Guerrero con 100 de vida, SIN armadura y ESPADA. Recibe un ataque de 50
    // RE  : Debe estar vivo, SIN armadura, con una vida de 50, puntuación de ataque 25, puntuación de curación 0 
    Guerrero guerrero = new Guerrero("Kandor", 100, false, Guerrero.ARMA_ESPADA);
    guerrero.recibeAtaque(50);
    assertTrue(guerrero.estaVivo());
    assertFalse(guerrero.tieneArmadura());
    assertEquals(50, guerrero.getVida());
    assertEquals(25, guerrero.getLetalidad());
    assertEquals(0, guerrero.getPoderCuracion());
  }

  @Test
  void testRecibeAtaqueMortalConArmaduraEspada() {
    // Caso: Crea un Guerrero con 100 de vida, CON armadura y ESPADA. Recibe un ataque de 200
    // RE  : Debe estar muerto, SIN armadur, con una vida de 0 (muerto), puntuación de ataque 0, puntuación de curación 0
    Guerrero guerrero = new Guerrero("Kandor", 100, true, Guerrero.ARMA_ESPADA);
    guerrero.recibeAtaque(200);
    assertFalse(guerrero.estaVivo());
    assertFalse(guerrero.tieneArmadura());
    assertEquals(0, guerrero.getVida());
    assertEquals(0, guerrero.getLetalidad());
    assertEquals(0, guerrero.getPoderCuracion());
  }

  @Test
  void testRecibeAtaqueMortalSinArmaduraEspada() {
    // Caso: Crea un Guerrero con 100 de vida, SIN armadura y ESPADA. Recibe un ataque de 200
    // RE  : Debe estar muerto, SIN armadura, con una vida de 0 (muerto), ataque 0, curación 0
    Guerrero guerrero = new Guerrero("Kandor", 100, false, Guerrero.ARMA_ESPADA);
    guerrero.recibeAtaque(200);
    assertFalse(guerrero.estaVivo());
    assertFalse(guerrero.tieneArmadura());
    assertEquals(0, guerrero.getVida());
    assertEquals(0, guerrero.getLetalidad());
    assertEquals(0, guerrero.getPoderCuracion());
  }

  @Test
  void testRecibeCuraConVidaLlenaEspada() {
    // Caso: Crea un Guerrero con 100 de vida, CON armadura y ESPADA. Recibe una cura de 10
    // RE  :  
    Guerrero guerrero = new Guerrero("Kandor", 100, true, Guerrero.ARMA_ESPADA);
    guerrero.recibeCuracion(10);
    assertTrue(guerrero.estaVivo());
    assertTrue(guerrero.tieneArmadura());
    assertEquals(100, guerrero.getVida());
    assertEquals(50, guerrero.getLetalidad());
    assertEquals(0, guerrero.getPoderCuracion());
  }

  @Test
  void testRecibeCuraInsuficienteEspada() {
    // Caso: Crea un Guerrero con 100 de vid, SIN armadura y ESPADA. Recibe un ataque de 50 y una cura de 10
    // RE  : Debe estar vivo,  SIN armadura, vida 70, ataque 35, curación 0
    Guerrero guerrero = new Guerrero("Kandor", 100, false, Guerrero.ARMA_ESPADA);
    guerrero.recibeAtaque(50);
    guerrero.recibeCuracion(10);
    assertTrue(guerrero.estaVivo());
    assertFalse(guerrero.tieneArmadura());
    assertEquals(70, guerrero.getVida());
    assertEquals(35, guerrero.getLetalidad());
    assertEquals(0, guerrero.getPoderCuracion());
  }

  @Test
  void testRecibeCuraMasQueNecesariaEspada() {
    // Caso: Crea un Guerrero con 100 de vida, SIN armadura y ESPADA. Recibe un ataque de 50 y una cura de 40
    // RE  : Debe estar vivo, SIN armadura, vida 100, ataque 50, curación 0
    Guerrero guerrero = new Guerrero("Kandor", 100, false, Guerrero.ARMA_ESPADA);
    guerrero.recibeAtaque(50);
    guerrero.recibeCuracion(40);
    assertTrue(guerrero.estaVivo());
    assertFalse(guerrero.tieneArmadura());
    assertEquals(100, guerrero.getVida());
    assertEquals(50, guerrero.getLetalidad());
    assertEquals(0, guerrero.getPoderCuracion());
  }

  @Test
  void testNoSePuedeCurarMuertoEspada() {
    // Caso: Crea un Guerrero con 100 de vida, SIN armadura y ESPADA. Recibe un ataque de 200 y una cura de 50
    // RE  : Debe estar muerto, SIN armadura, con una vida de 0 (muerto), puntuación de ataque 0, puntuación de curación 0
    Guerrero guerrero = new Guerrero("Kandor", 100, true, Guerrero.ARMA_ESPADA);
    guerrero.recibeAtaque(200);
    guerrero.recibeCuracion(50);
    assertFalse(guerrero.estaVivo());
    assertFalse(guerrero.tieneArmadura());
    assertEquals(0, guerrero.getVida());
    assertEquals(0, guerrero.getLetalidad());
    assertEquals(0, guerrero.getPoderCuracion());
  }

  @Test
  void testRecibeDosAtaquesDosArmadurasEspada() {
    // Caso: Crea un Guerrero con 100 de vida, CON armadura y ESPADA. Recibe un ataque de 50, una armadura y otro ataque de 50
    // RE  : Debe estar vivo, SIN armadura, con una vida de 50, puntuación de ataque 25, puntuación de curación 0 
    Guerrero guerrero = new Guerrero("Kandor", 100, true, Guerrero.ARMA_ESPADA);
    guerrero.recibeAtaque(50);
    guerrero.recibeArmadura();
    guerrero.recibeAtaque(50);
    assertTrue(guerrero.estaVivo());
    assertFalse(guerrero.tieneArmadura());
    assertEquals(50, guerrero.getVida());
    assertEquals(25, guerrero.getLetalidad());
    assertEquals(0, guerrero.getPoderCuracion());
  }

  @Test
  void testRecibeAtaqueConArmaduraMaza() {
    // Caso: Crea un Guerrero con 100 de vida, CON armadura y MAZA. Recibe un ataque de 50
    // RE  : Debe estar vivo, SIN armadura, con una vida de 75, puntuación de ataque 75, puntuación de curación 0 
    Guerrero guerrero = new Guerrero("Kandor", 100, true, Guerrero.ARMA_MAZA);
    guerrero.recibeAtaque(50);
    assertTrue(guerrero.estaVivo());
    assertFalse(guerrero.tieneArmadura());
    assertEquals(75, guerrero.getVida());
    assertEquals(75, guerrero.getLetalidad());
    assertEquals(0, guerrero.getPoderCuracion());
  }

  @Test
  void testRecibeAtaqueSinArmaduraMaza() {
    // Caso: Crea un Guerrero con 100 de vida, SIN armadura y MAZA. Recibe un ataque de 50
    // RE  : Debe estar vivo, SIN armadura, con una vida de 50, puntuación de ataque 50, puntuación de curación 0 
    Guerrero guerrero = new Guerrero("Kandor", 100, false, Guerrero.ARMA_MAZA);
    guerrero.recibeAtaque(50);
    assertTrue(guerrero.estaVivo());
    assertFalse(guerrero.tieneArmadura());
    assertEquals(50, guerrero.getVida());
    assertEquals(50, guerrero.getLetalidad());
    assertEquals(0, guerrero.getPoderCuracion());
  }

  @Test
  void testRecibeAtaqueMortalConArmaduraMaza() {
    // Caso: Crea un Guerrero con 100 de vida, CON armadura y MAZA. Recibe un ataque de 200
    // RE  : Debe estar muerto, SIN armadura, con una vida de 0 (muerto), puntuación de ataque 0, puntuación de curación 0
    Guerrero guerrero = new Guerrero("Kandor", 100, true, Guerrero.ARMA_MAZA);
    guerrero.recibeAtaque(200);
    assertFalse(guerrero.estaVivo());
    assertFalse(guerrero.tieneArmadura());
    assertEquals(0, guerrero.getVida());
    assertEquals(0, guerrero.getLetalidad());
    assertEquals(0, guerrero.getPoderCuracion());
  }

  @Test
  void testRecibeAtaqueMortalSinArmaduraMaza() {
    // Caso: Crea un Guerrero con 100 de vida, SIN armadura y MAZA. Recibe un ataque de 200
    // RE  : Debe estar muerto, SIN armadura, con una vida de 0 (muerto), ataque 0, curación 0
    Guerrero guerrero = new Guerrero("Kandor", 100, false, Guerrero.ARMA_MAZA);
    guerrero.recibeAtaque(200);
    assertFalse(guerrero.estaVivo());
    assertFalse(guerrero.tieneArmadura());
    assertEquals(0, guerrero.getVida());
    assertEquals(0, guerrero.getLetalidad());
    assertEquals(0, guerrero.getPoderCuracion());
  }

  @Test
  void testRecibeCuraConVidaLlenaMaza() {
    // Caso: Crea un Guerrero con 100 de vida, CON armadura y Maza. Recibe una cura de 10
    // RE  : Debe estar vivo, CON armadura, vida 100 (la cura no hace nada), ataque 100, curación 0
    Guerrero guerrero = new Guerrero("Kandor", 100, true, Guerrero.ARMA_MAZA);
    guerrero.recibeCuracion(10);
    assertTrue(guerrero.estaVivo());
    assertTrue(guerrero.tieneArmadura());
    assertEquals(100, guerrero.getVida());
    assertEquals(100, guerrero.getLetalidad());
    assertEquals(0, guerrero.getPoderCuracion());
  }

  @Test
  void testRecibeCuraInsuficienteMaza() {
    // Caso: Crea un Guerrero con 100 de vid, SIN armadura y MAZA. Recibe un ataque de 50 y una cura de 10
    // RE  : Debe estar vivo,  SIN armadura, vida 70, ataque 70, curación 0
    Guerrero guerrero = new Guerrero("Kandor", 100, false, Guerrero.ARMA_MAZA);
    guerrero.recibeAtaque(50);
    guerrero.recibeCuracion(10);
    assertTrue(guerrero.estaVivo());
    assertFalse(guerrero.tieneArmadura());
    assertEquals(70, guerrero.getVida());
    assertEquals(70, guerrero.getLetalidad());
    assertEquals(0, guerrero.getPoderCuracion());
  }

  @Test
  void testRecibeCuraMasQueNecesariaMaza() {
    // Caso: Crea un Guerrero con 100 de vida, SIN armadura y MAZA. Recibe un ataque de 50 y una cura de 40
    // RE  : Debe estar vivo, SIN armadura, vida 100, ataque 100, curación 0
    Guerrero guerrero = new Guerrero("Kandor", 100, false, Guerrero.ARMA_MAZA);
    guerrero.recibeAtaque(50);
    guerrero.recibeCuracion(40);
    assertTrue(guerrero.estaVivo());
    assertFalse(guerrero.tieneArmadura());
    assertEquals(100, guerrero.getVida());
    assertEquals(100, guerrero.getLetalidad());
    assertEquals(0, guerrero.getPoderCuracion());
  }

  @Test
  void testNoSePuedeCurarMuertoMaza() {
    // Caso: Crea un Guerrero con 100 de vida, SIN armadura y MAZA. Recibe un ataque de 200 y una cura de 50
    // RE  : Debe estar muerto, SIN armadura, con una vida de 0 (muerto), puntuación de ataque 0, puntuación de curación 0
    Guerrero guerrero = new Guerrero("Kandor", 100, true, Guerrero.ARMA_MAZA);
    guerrero.recibeAtaque(200);
    guerrero.recibeCuracion(50);
    assertFalse(guerrero.estaVivo());
    assertFalse(guerrero.tieneArmadura());
    assertEquals(0, guerrero.getVida());
    assertEquals(0, guerrero.getLetalidad());
    assertEquals(0, guerrero.getPoderCuracion());
  }

  @Test
  void testRecibeDosAtaquesDosArmadurasMaza() {
    // Caso: Crea un Guerrero con 100 de vida, CON armadura y MAZA. Recibe un ataque de 50, una armadura y otro ataque de 50
    // RE  : Debe estar vivo, SIN armadura, con una vida de 50, puntuación de ataque 50, puntuación de curación 0 
    Guerrero guerrero = new Guerrero("Kandor", 100, true, Guerrero.ARMA_MAZA);
    guerrero.recibeAtaque(50);
    guerrero.recibeArmadura();
    guerrero.recibeAtaque(50);
    assertTrue(guerrero.estaVivo());
    assertFalse(guerrero.tieneArmadura());
    assertEquals(50, guerrero.getVida());
    assertEquals(50, guerrero.getLetalidad());
    assertEquals(0, guerrero.getPoderCuracion());
  }

}
