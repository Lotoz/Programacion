package test.prog.ud07.juego;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import prog.ud07.juego.Sanador;

class TestSanador {


  @Test
  void testConstruccionOk() {
    // Caso: Crea un Sanador con datos correctos
    // RE  : El sanador se crea sin excepciones
    Sanador sanador = new Sanador("Sanitol", 100);
  }

  @Test
  void testConstruccionNombreNull() {
    // Caso: Crea un Sanador con nombre nulo
    // RE  : El sanador no se crea con NullPointerException
    assertThrows(NullPointerException.class, () -> new Sanador(null, 100));
  }

  @Test
  void testConstruccionNombreSoloBlancos() {
    // Caso: Crea un Sanador con nombre solo blancos
    // RE  : El sanador no se crea con IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Sanador("  ", 100));
  }

  @Test
  void testConstruccionVidaCero() {
    // Caso: Crea un Sanador con vida a cero
    // RE  : El sanador no se crea con IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Sanador("Sanitol", 0));
  }

  @Test
  void testConstruccionVidaNegativo() {
    // Caso: Crea un Sanador con vida negativa
    // RE  : El sanador no se crea con IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Sanador("Sanitol", -1));
  }

  @Test
  void testRecibeAtaque() {
    // Caso: Crea un Sanador con 100 de vida. Recibe un ataque de 50
    // RE  : Debe estar vivo, con una vida de 50, puntuación de ataque 0, puntuación de curación 25 
    Sanador sanador = new Sanador("Sanitol", 100);
    sanador.recibeAtaque(50);
    assertTrue(sanador.estaVivo());
    assertEquals(50, sanador.getVida());
    assertEquals(0, sanador.getLetalidad());
    assertEquals(25, sanador.getPoderCuracion());
  }

  @Test
  void testRecibeAtaqueMortal() {
    // Caso: Crea un Sanador con 100 de vida. Recibe un ataque de 200
    // RE  : Debe estar muerto, con una vida de 0 (muerto), puntuación de ataque 0, puntuación de curación 0
    Sanador sanador = new Sanador("Sanitol", 100);
    sanador.recibeAtaque(200);
    assertFalse(sanador.estaVivo());
    assertEquals(0, sanador.getVida());
    assertEquals(0, sanador.getLetalidad());
    assertEquals(0, sanador.getPoderCuracion());
  }

  @Test
  void testRecibeCuraConVidaLlena() {
    // Caso: Crea un Sanador con 100 de vida. Recibe una cura de 10
    // RE  : Debe estar vivo, vida 100 (la cura no hace nada), ataque 0, curación 50
    Sanador sanador = new Sanador("Sanitol", 100);
    sanador.recibeCuracion(10);
    assertTrue(sanador.estaVivo());
    assertEquals(100, sanador.getVida());
    assertEquals(0, sanador.getLetalidad());
    assertEquals(50, sanador.getPoderCuracion());
  }

  @Test
  void testRecibeCuraInsuficiente() {
    // Caso: Crea un Sanador con 100 de vida. Recibe un ataque de 50 y una cura de 10
    // RE  : Debe estar vivo, vida 63, ataque 0, curación 31
    Sanador sanador = new Sanador("Sanitol", 100);
    sanador.recibeAtaque(50);
    sanador.recibeCuracion(10);
    assertTrue(sanador.estaVivo());
    assertEquals(63, sanador.getVida());
    assertEquals(0, sanador.getLetalidad());
    assertEquals(31, sanador.getPoderCuracion());
  }

  @Test
  void testRecibeCuraMasQueNecesaria() {
    // Caso: Crea un Sanador con 100 de vida. Recibe un ataque de 50 y una cura de 45
    // RE  : Debe estar vivo, vida 100, ataque 0, curación 50
    Sanador sanador = new Sanador("Sanitol", 100);
    sanador.recibeAtaque(50);
    sanador.recibeCuracion(45);
    assertTrue(sanador.estaVivo());
    assertEquals(100, sanador.getVida());
    assertEquals(0, sanador.getLetalidad());
    assertEquals(50, sanador.getPoderCuracion());
  }

  @Test
  void testNoSePuedeCurarMuerto() {
    // Caso: Crea un Sanador con 100 de vida. Recibe un ataque de 200 y una cura de 50
    // RE  : Debe estar muerto, con una vida de 0 (muerto), puntuación de ataque 0, puntuación de curación 0
    Sanador sanador = new Sanador("Sanitol", 100);
    sanador.recibeAtaque(200);
    sanador.recibeCuracion(50);
    assertFalse(sanador.estaVivo());
    assertEquals(0, sanador.getVida());
    assertEquals(0, sanador.getLetalidad());
    assertEquals(0, sanador.getPoderCuracion());
  }

  @Test
  void testRecibeDosAtaques() {
    // Caso: Crea un Sanador con 100 de vida. Recibe un ataque de 50 y otro ataque de 50
    // RE  : Debe estar muerto, con una vida de 0, puntuación de ataque 0, puntuación de curación 0 
    Sanador sanador = new Sanador("Sanitol", 100);
    sanador.recibeAtaque(50);
    sanador.recibeAtaque(50);
    assertFalse(sanador.estaVivo());
    assertEquals(0, sanador.getVida());
    assertEquals(0, sanador.getLetalidad());
    assertEquals(0, sanador.getPoderCuracion());
  }

}
