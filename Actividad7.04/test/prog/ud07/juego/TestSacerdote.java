package prog.ud07.juego;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class TestSacerdote {


  @Test
  void testConstruccionOk() {
    // Caso: Crea un Sacerdote con datos correctos
    // RE  : El sacerdote se crea sin excepciones
    Sacerdote sacerdote = new Sacerdote("Curantium", 100, true);
  }

  @Test
  void testConstruccionOk2() {
    // Caso: Crea un Sacerdote con datos correctos
    // RE  : El sacerdote se crea sin excepciones
    Sacerdote sacerdote = new Sacerdote("Curantium", 100, false);
  }

  @Test
  void testConstruccionNombreNull() {
    // Caso: Crea un Sacerdote con nombre nulo
    // RE  : El sacerdote no se crea con NullPointerException
    assertThrows(NullPointerException.class, () -> new Sacerdote(null, 100, true));
  }

  @Test
  void testConstruccionNombreSoloBlancos() {
    // Caso: Crea un Sacerdote con nombre solo blancos
    // RE  : El sacerdote no se crea con IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Sacerdote("  ", 100, true));
  }

  @Test
  void testConstruccionVidaCero() {
    // Caso: Crea un Sacerdote con vida a cero
    // RE  : El sacerdote no se crea con IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Sacerdote("Curantium", 0, true));
  }

  @Test
  void testConstruccionVidaNegativo() {
    // Caso: Crea un Sacerdote con vida negativa
    // RE  : El sacerdote no se crea con IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Sacerdote("Curantium", -1, true));
  }

  @Test
  void testRecibeAtaqueConReliquia() {
    // Caso: Crea un Sacerdote con 100 de vida, CON reliquia. Recibe un ataque de 50
    // RE  : Debe estar vivo, SIN reliquia, con una vida de 100, puntuación de ataque 0,
    //       puntuación de curación 50 
    Sacerdote sacerdote = new Sacerdote("Curantium", 100, true);
    sacerdote.recibeAtaque(50);
    assertTrue(sacerdote.estaVivo());
    assertFalse(sacerdote.tieneReliquia());
    assertEquals(100, sacerdote.getVida());
    assertEquals(0, sacerdote.getLetalidad());
    assertEquals(50, sacerdote.getPoderCuracion());
  }

  @Test
  void testRecibeAtaqueSinReliquia() {
    // Caso: Crea un Sacerdote con 100 de vida, SIN reliquia. Recibe un ataque de 50
    // RE  : Debe estar vivo, SIN reliquia, con una vida de 50, puntuación de ataque 0
    //       puntuación de curación 25 
    Sacerdote sacerdote = new Sacerdote("Curantium", 100, false);
    sacerdote.recibeAtaque(50);
    assertTrue(sacerdote.estaVivo());
    assertFalse(sacerdote.tieneReliquia());
    assertEquals(50, sacerdote.getVida());
    assertEquals(0, sacerdote.getLetalidad());
    assertEquals(25, sacerdote.getPoderCuracion());
  }

  @Test
  void testRecibeAtaqueMortalConReliquia() {
    // Caso: Crea un Sacerdote con 100 de vida, CON reliquia. Recibe un ataque de 200
    // RE  : Debe estar vivo, SIN reliquia, con una vida de 100, puntuación de ataque 0
    //       , puntuación de curación 50
    Sacerdote sacerdote = new Sacerdote("Curantium", 100, true);
    sacerdote.recibeAtaque(200);
    assertTrue(sacerdote.estaVivo());
    assertFalse(sacerdote.tieneReliquia());
    assertEquals(100, sacerdote.getVida());
    assertEquals(0, sacerdote.getLetalidad());
    assertEquals(50, sacerdote.getPoderCuracion());
  }

  @Test
  void testRecibeAtaqueMortalSinReliquia() {
    // Caso: Crea un Sacerdote con 100 de vida, SIN reliquia. Recibe un ataque de 200
    // RE  : Debe estar muerto, SIN reliquia, con una vida de 0 (muerto), ataque 0, curación 0
    Sacerdote sacerdote = new Sacerdote("Curantium", 100, false);
    sacerdote.recibeAtaque(200);
    assertFalse(sacerdote.estaVivo());
    assertFalse(sacerdote.tieneReliquia());
    assertEquals(0, sacerdote.getVida());
    assertEquals(0, sacerdote.getLetalidad());
    assertEquals(0, sacerdote.getPoderCuracion());
  }

  @Test
  void testRecibeCuraConVidaLlena() {
    // Caso: Crea un Sacerdote con 100 de vida, CON reliquia. Recibe una cura de 10
    // RE  : Debe estar vivo, CON reliquia, vida 100 (la cura no hace nada), ataque 0, curación 100
    Sacerdote sacerdote = new Sacerdote("Curantium", 100, true);
    sacerdote.recibeCuracion(10);
    assertTrue(sacerdote.estaVivo());
    assertTrue(sacerdote.tieneReliquia());
    assertEquals(100, sacerdote.getVida());
    assertEquals(0, sacerdote.getLetalidad());
    assertEquals(100, sacerdote.getPoderCuracion());
  }

  @Test
  void testRecibeCuraInsuficiente() {
    // Caso: Crea un Sacerdote con 100 de vid, SIN reliquia. Recibe un ataque de 50 y
    //       una cura de 10
    // RE  : Debe estar vivo, SIN reliquia, vida 60, ataque 0, curación 30
    Sacerdote sacerdote = new Sacerdote("Curantium", 100, false);
    sacerdote.recibeAtaque(50);
    sacerdote.recibeCuracion(10);
    assertTrue(sacerdote.estaVivo());
    assertFalse(sacerdote.tieneReliquia());
    assertEquals(60, sacerdote.getVida());
    assertEquals(0, sacerdote.getLetalidad());
    assertEquals(30, sacerdote.getPoderCuracion());
  }

  @Test
  void testRecibeCuraMasQueNecesaria() {
    // Caso: Crea un Sacerdote con 100 de vida, SIN reliquia. Recibe un ataque de 50 y
    //       una cura de 60
    // RE  : Debe estar vivo, SIN reliquia, vida 100, ataque 0, curación 50
    Sacerdote sacerdote = new Sacerdote("Curantium", 100, false);
    sacerdote.recibeAtaque(50);
    sacerdote.recibeCuracion(60);
    assertTrue(sacerdote.estaVivo());
    assertFalse(sacerdote.tieneReliquia());
    assertEquals(100, sacerdote.getVida());
    assertEquals(0, sacerdote.getLetalidad());
    assertEquals(50, sacerdote.getPoderCuracion());
  }

  @Test
  void testNoSePuedeCurarMuerto() {
    // Caso: Crea un Sacerdote con 100 de vida, SIN reliquia. Recibe un ataque de 200 y
    //       una cura de 50
    // RE  : Debe estar muerto, SIN reliquia, con una vida de 0 (muerto), puntuación de ataque 0
    //       puntuación de curación 0
    Sacerdote sacerdote = new Sacerdote("Curantium", 100, false);
    sacerdote.recibeAtaque(200);
    sacerdote.recibeCuracion(50);
    assertFalse(sacerdote.estaVivo());
    assertFalse(sacerdote.tieneReliquia());
    assertEquals(0, sacerdote.getVida());
    assertEquals(0, sacerdote.getLetalidad());
    assertEquals(0, sacerdote.getPoderCuracion());
  }

  @Test
  void testRecibeDosAtaquesDosReliquias() {
    // Caso: Crea un Sacerdote con 100 de vida, CON reliquia. Recibe un ataque de 50
    //       una reliquia y otro ataque de 50
    // RE  : Debe estar vivo, SIN reliquia, con una vida de 100, puntuación de ataque 0, puntuación
    //       de curación 50
    Sacerdote sacerdote = new Sacerdote("Curantium", 100, true);
    sacerdote.recibeAtaque(50);
    sacerdote.recibeReliquia();
    sacerdote.recibeAtaque(50);
    assertTrue(sacerdote.estaVivo());
    assertFalse(sacerdote.tieneReliquia());
    assertEquals(100, sacerdote.getVida());
    assertEquals(0, sacerdote.getLetalidad());
    assertEquals(50, sacerdote.getPoderCuracion());
  }

  @Test
  void testRecibeDosReliquiasUnAtaque() {
    // Caso: Crea un Sacerdote con 100 de vida, CON reliquia. Se le da otra reliquia.
    //       Recibe un ataque de 50 
    // RE  : Debe estar vivo, SIN reliquia, con una vida de 100, puntuación de ataque 0, puntuación
    //       de curación 50
    Sacerdote sacerdote = new Sacerdote("Curantium", 100, true);
    sacerdote.recibeReliquia();
    sacerdote.recibeAtaque(50);
    assertTrue(sacerdote.estaVivo());
    assertFalse(sacerdote.tieneReliquia());
    assertEquals(100, sacerdote.getVida());
    assertEquals(0, sacerdote.getLetalidad());
    assertEquals(50, sacerdote.getPoderCuracion());
  }

}
