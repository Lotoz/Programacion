package prog.ud07.juego;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestArquero {

  @Test
  void testConstruccionOk() {
    // Caso: Crea un Arquero con datos correctos
    // RE  : El arquero se crea sin excepciones
    Arquero arquero = new Arquero("Legolas", 100, true, Arquero.NIVEL_NOVATO);
  }

  @Test
  void testConstruccionOk2() {
    // Caso: Crea un Arquero con datos correctos
    // RE  : El arquero se crea sin excepciones
    Arquero arquero = new Arquero("Legolas", 100, false, Arquero.NIVEL_NOVATO);
  }

  @Test
  void testConstruccionOk3() {
    // Caso: Crea un Arquero con datos correctos
    // RE  : El arquero se crea sin excepciones
    Arquero arquero = new Arquero("Legolas", 100, true, Arquero.NIVEL_MEDIO);
  }

  @Test
  void testConstruccionOk4() {
    // Caso: Crea un Arquero con datos correctos
    // RE  : El arquero se crea sin excepciones
    Arquero arquero = new Arquero("Legolas", 100, false, Arquero.NIVEL_MEDIO);
  }

  @Test
  void testConstruccionOk5() {
    // Caso: Crea un Arquero con datos correctos
    // RE  : El arquero se crea sin excepciones
    Arquero arquero = new Arquero("Legolas", 100, true, Arquero.NIVEL_EXPERTO);
  }

  @Test
  void testConstruccionOk6() {
    // Caso: Crea un Arquero con datos correctos
    // RE  : El arquero se crea sin excepciones
    Arquero arquero = new Arquero("Legolas", 100, false, Arquero.NIVEL_EXPERTO);
  }

  @Test
  void testConstruccionNombreNull() {
    // Caso: Crea un Arquero con nombre nulo
    // RE  : El arquero no se crea con NullPointerException
    assertThrows(NullPointerException.class, () -> new Arquero(null, 100, true,
      Arquero.NIVEL_NOVATO));
  }

  @Test
  void testConstruccionNombreSoloBlancos() {
    // Caso: Crea un Arquero con nombre solo blancos
    // RE  : El arquero no se crea con IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Arquero("  ", 100, true,
      Arquero.NIVEL_NOVATO));
  }

  @Test
  void testConstruccionVidaCero() {
    // Caso: Crea un Arquero con vida a cero
    // RE  : El arquero no se crea con IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Arquero("Legolas", 0, true,
      Arquero.NIVEL_NOVATO));
  }

  @Test
  void testConstruccionVidaNegativo() {
    // Caso: Crea un Arquero con vida negativa
    // RE  : El arquero no se crea con IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Arquero("Legolas", -1, true,
      Arquero.NIVEL_NOVATO));
  }

  @Test
  void testConstruccionArmaInvalida() {
    // Caso: Crea un Arquero con arma no válida
    // RE  : El arquero no se crea con IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Arquero("Legolas", 100, true,
      -1));
  }

  @Test
  void testRecibeAtaqueConArmaduraNovato() {
    // Caso: Crea un Arquero con 100 de vida, CON armadura y Nivel Novato. Recibe un ataque de 50
    // RE  : Debe estar vivo, SIN armadura, con una vida de 75, puntuación de ataque 15,
    //       puntuación de curación 0 
    Arquero arquero = new Arquero("Legolas", 100, true, Arquero.NIVEL_NOVATO);
    arquero.recibeAtaque(50);
    assertTrue(arquero.estaVivo());
    assertFalse(arquero.tieneArmadura());
    assertEquals(75, arquero.getVida());
    assertEquals(15, arquero.getLetalidad());
    assertEquals(0, arquero.getPoderCuracion());
  }

  @Test
  void testRecibeAtaqueSinArmaduraNovato() {
    // Caso: Crea un Arquero con 100 de vida, SIN armadura y Nivel novato. Recibe un ataque de 50
    // RE  : Debe estar vivo, SIN armadura, con una vida de 50, puntuación de ataque 10
    //       puntuación de curación 0 
    Arquero arquero = new Arquero("Legolas", 100, false, Arquero.NIVEL_NOVATO);
    arquero.recibeAtaque(50);
    assertTrue(arquero.estaVivo());
    assertFalse(arquero.tieneArmadura());
    assertEquals(50, arquero.getVida());
    assertEquals(10, arquero.getLetalidad());
    assertEquals(0, arquero.getPoderCuracion());
  }

  @Test
  void testRecibeAtaqueMortalConArmaduraNovato() {
    // Caso: Crea un Arquero con 100 de vida, CON armadura y Nivel novato. Recibe un ataque de 200
    // RE  : Debe estar muerto, SIN armadura, con una vida de 0 (muerto), puntuación de ataque 0, puntuación de curación 0
    Arquero arquero = new Arquero("Legolas", 100, true, Arquero.NIVEL_NOVATO);
    arquero.recibeAtaque(200);
    assertFalse(arquero.estaVivo());
    assertFalse(arquero.tieneArmadura());
    assertEquals(0, arquero.getVida());
    assertEquals(0, arquero.getLetalidad());
    assertEquals(0, arquero.getPoderCuracion());
  }

  @Test
  void testRecibeAtaqueMortalSinArmaduraNovato() {
    // Caso: Crea un Arquero con 100 de vida, SIN armadura y Nivel novato. Recibe un ataque de 200
    // RE  : Debe estar muerto, SIN armadura, con una vida de 0 (muerto), ataque 0, curación 0
    Arquero arquero = new Arquero("Legolas", 100, false, Arquero.NIVEL_NOVATO);
    arquero.recibeAtaque(200);
    assertFalse(arquero.estaVivo());
    assertFalse(arquero.tieneArmadura());
    assertEquals(0, arquero.getVida());
    assertEquals(0, arquero.getLetalidad());
    assertEquals(0, arquero.getPoderCuracion());
  }

  @Test
  void testRecibeCuraConVidaLlenaNovato() {
    // Caso: Crea un Arquero con 100 de vida, CON armadura y Nivel novato. Recibe una cura de 10
    // RE  : Debe estar vivo, CON armadura, vida 100 (la cura no hace nada), ataque 20, curación 0
    Arquero arquero = new Arquero("Legolas", 100, true, Arquero.NIVEL_NOVATO);
    arquero.recibeCuracion(10);
    assertTrue(arquero.estaVivo());
    assertTrue(arquero.tieneArmadura());
    assertEquals(100, arquero.getVida());
    assertEquals(20, arquero.getLetalidad());
    assertEquals(0, arquero.getPoderCuracion());
  }

  @Test
  void testRecibeCuraInsuficienteNovato() {
    // Caso: Crea un Arquero con 100 de vid, SIN armadura y Nivel novato. Recibe un ataque de 50 y
    //       una cura de 10
    // RE  : Debe estar vivo,  SIN armadura, vida 60, ataque 12, curación 0
    Arquero arquero = new Arquero("Legolas", 100, false, Arquero.NIVEL_NOVATO);
    arquero.recibeAtaque(50);
    arquero.recibeCuracion(10);
    assertTrue(arquero.estaVivo());
    assertFalse(arquero.tieneArmadura());
    assertEquals(60, arquero.getVida());
    assertEquals(12, arquero.getLetalidad());
    assertEquals(0, arquero.getPoderCuracion());
  }

  @Test
  void testRecibeCuraMasQueNecesariaNovato() {
    // Caso: Crea un Arquero con 100 de vida, SIN armadura y Nivel novato. Recibe un ataque de 50 y
    //       una cura de 60
    // RE  : Debe estar vivo, SIN armadura, vida 100, ataque 20, curación 0
    Arquero arquero = new Arquero("Legolas", 100, false, Arquero.NIVEL_NOVATO);
    arquero.recibeAtaque(50);
    arquero.recibeCuracion(60);
    assertTrue(arquero.estaVivo());
    assertFalse(arquero.tieneArmadura());
    assertEquals(100, arquero.getVida());
    assertEquals(20, arquero.getLetalidad());
    assertEquals(0, arquero.getPoderCuracion());
  }

  @Test
  void testNoSePuedeCurarMuertoNovato() {
    // Caso: Crea un Arquero con 100 de vida, SIN armadura y Nivel novato. Recibe un ataque de 200 y
    //       una cura de 50
    // RE  : Debe estar muerto, SIN armadura, con una vida de 0 (muerto), puntuación de ataque 0
    //       puntuación de curación 0
    Arquero arquero = new Arquero("Legolas", 100, true, Arquero.NIVEL_NOVATO);
    arquero.recibeAtaque(200);
    arquero.recibeCuracion(50);
    assertFalse(arquero.estaVivo());
    assertFalse(arquero.tieneArmadura());
    assertEquals(0, arquero.getVida());
    assertEquals(0, arquero.getLetalidad());
    assertEquals(0, arquero.getPoderCuracion());
  }

  @Test
  void testRecibeDosAtaquesDosArmadurasNovato() {
    // Caso: Crea un Arquero con 100 de vida, CON armadura y Nivel novato. Recibe un ataque de 50
    //       una armadura y otro ataque de 50
    // RE  : Debe estar vivo, SIN armadura, con una vida de 50, puntuación de ataque 10, puntuación
    //       de curación 0 
    Arquero arquero = new Arquero("Legolas", 100, true, Arquero.NIVEL_NOVATO);
    arquero.recibeAtaque(50);
    arquero.recibeArmadura();
    arquero.recibeAtaque(50);
    assertTrue(arquero.estaVivo());
    assertFalse(arquero.tieneArmadura());
    assertEquals(50, arquero.getVida());
    assertEquals(10, arquero.getLetalidad());
    assertEquals(0, arquero.getPoderCuracion());
  }

  @Test
  void testRecibeAtaqueConArmaduraMedio() {
    // Caso: Crea un Arquero con 100 de vida, CON armadura y Nivel Medio. Recibe un ataque de 50
    // RE  : Debe estar vivo, SIN armadura, con una vida de 75, puntuación de ataque 25,
    //       puntuación de curación 0 
    Arquero arquero = new Arquero("Legolas", 100, true, Arquero.NIVEL_MEDIO);
    arquero.recibeAtaque(50);
    assertTrue(arquero.estaVivo());
    assertFalse(arquero.tieneArmadura());
    assertEquals(75, arquero.getVida());
    assertEquals(25, arquero.getLetalidad());
    assertEquals(0, arquero.getPoderCuracion());
  }

  @Test
  void testRecibeAtaqueSinArmaduraMedio() {
    // Caso: Crea un Arquero con 100 de vida, SIN armadura y Nivel medio. Recibe un ataque de 50
    // RE  : Debe estar vivo, SIN armadura, con una vida de 50, puntuación de ataque 16
    //       puntuación de curación 0 
    Arquero arquero = new Arquero("Legolas", 100, false, Arquero.NIVEL_MEDIO);
    arquero.recibeAtaque(50);
    assertTrue(arquero.estaVivo());
    assertFalse(arquero.tieneArmadura());
    assertEquals(50, arquero.getVida());
    assertEquals(16, arquero.getLetalidad());
    assertEquals(0, arquero.getPoderCuracion());
  }

  @Test
  void testRecibeAtaqueMortalConArmaduraMedio() {
    // Caso: Crea un Arquero con 100 de vida, CON armadura y Nivel medio. Recibe un ataque de 200
    // RE  : Debe estar muerto, SIN armadura, con una vida de 0 (muerto), puntuación de ataque 0, puntuación de curación 0
    Arquero arquero = new Arquero("Legolas", 100, true, Arquero.NIVEL_MEDIO);
    arquero.recibeAtaque(200);
    assertFalse(arquero.estaVivo());
    assertFalse(arquero.tieneArmadura());
    assertEquals(0, arquero.getVida());
    assertEquals(0, arquero.getLetalidad());
    assertEquals(0, arquero.getPoderCuracion());
  }

  @Test
  void testRecibeAtaqueMortalSinArmaduraMedio() {
    // Caso: Crea un Arquero con 100 de vida, SIN armadura y Nivel medio. Recibe un ataque de 200
    // RE  : Debe estar muerto, SIN armadura, con una vida de 0 (muerto), ataque 0, curación 0
    Arquero arquero = new Arquero("Legolas", 100, false, Arquero.NIVEL_MEDIO);
    arquero.recibeAtaque(200);
    assertFalse(arquero.estaVivo());
    assertFalse(arquero.tieneArmadura());
    assertEquals(0, arquero.getVida());
    assertEquals(0, arquero.getLetalidad());
    assertEquals(0, arquero.getPoderCuracion());
  }

  @Test
  void testRecibeCuraConVidaLlenaMedio() {
    // Caso: Crea un Arquero con 100 de vida, CON armadura y Nivel medio. Recibe una cura de 10
    // RE  : Debe estar vivo, CON armadura, vida 100 (la cura no hace nada), ataque 33, curación 0
    Arquero arquero = new Arquero("Legolas", 100, true, Arquero.NIVEL_MEDIO);
    arquero.recibeCuracion(10);
    assertTrue(arquero.estaVivo());
    assertTrue(arquero.tieneArmadura());
    assertEquals(100, arquero.getVida());
    assertEquals(33, arquero.getLetalidad());
    assertEquals(0, arquero.getPoderCuracion());
  }

  @Test
  void testRecibeCuraInsuficienteMedio() {
    // Caso: Crea un Arquero con 100 de vid, SIN armadura y Nivel medio. Recibe un ataque de 50 y
    //       una cura de 10
    // RE  : Debe estar vivo,  SIN armadura, vida 60, ataque 20, curación 0
    Arquero arquero = new Arquero("Legolas", 100, false, Arquero.NIVEL_MEDIO);
    arquero.recibeAtaque(50);
    arquero.recibeCuracion(10);
    assertTrue(arquero.estaVivo());
    assertFalse(arquero.tieneArmadura());
    assertEquals(60, arquero.getVida());
    assertEquals(20, arquero.getLetalidad());
    assertEquals(0, arquero.getPoderCuracion());
  }

  @Test
  void testRecibeCuraMasQueNecesariaMedio() {
    // Caso: Crea un Arquero con 100 de vida, SIN armadura y Nivel medio. Recibe un ataque de 50 y
    //       una cura de 60
    // RE  : Debe estar vivo, SIN armadura, vida 100, ataque 33, curación 0
    Arquero arquero = new Arquero("Legolas", 100, false, Arquero.NIVEL_MEDIO);
    arquero.recibeAtaque(50);
    arquero.recibeCuracion(60);
    assertTrue(arquero.estaVivo());
    assertFalse(arquero.tieneArmadura());
    assertEquals(100, arquero.getVida());
    assertEquals(33, arquero.getLetalidad());
    assertEquals(0, arquero.getPoderCuracion());
  }

  @Test
  void testNoSePuedeCurarMuertoMedio() {
    // Caso: Crea un Arquero con 100 de vida, SIN armadura y Nivel medio. Recibe un ataque de 200 y
    //       una cura de 50
    // RE  : Debe estar muerto, SIN armadura, con una vida de 0 (muerto), puntuación de ataque 0
    //       puntuación de curación 0
    Arquero arquero = new Arquero("Legolas", 100, true, Arquero.NIVEL_MEDIO);
    arquero.recibeAtaque(200);
    arquero.recibeCuracion(50);
    assertFalse(arquero.estaVivo());
    assertFalse(arquero.tieneArmadura());
    assertEquals(0, arquero.getVida());
    assertEquals(0, arquero.getLetalidad());
    assertEquals(0, arquero.getPoderCuracion());
  }

  @Test
  void testRecibeDosAtaquesDosArmadurasMedio() {
    // Caso: Crea un Arquero con 100 de vida, CON armadura y Nivel medio. Recibe un ataque de 50
    //       una armadura y otro ataque de 50
    // RE  : Debe estar vivo, SIN armadura, con una vida de 50, puntuación de ataque 16, puntuación
    //       de curación 0 
    Arquero arquero = new Arquero("Legolas", 100, true, Arquero.NIVEL_MEDIO);
    arquero.recibeAtaque(50);
    arquero.recibeArmadura();
    arquero.recibeAtaque(50);
    assertTrue(arquero.estaVivo());
    assertFalse(arquero.tieneArmadura());
    assertEquals(50, arquero.getVida());
    assertEquals(16, arquero.getLetalidad());
    assertEquals(0, arquero.getPoderCuracion());
  }

  @Test
  void testRecibeAtaqueConArmaduraExperto() {
    // Caso: Crea un Arquero con 100 de vida, CON armadura y Nivel experto. Recibe un ataque de 50
    // RE  : Debe estar vivo, SIN armadura, con una vida de 75, puntuación de ataque 37,
    //       puntuación de curación 0 
    Arquero arquero = new Arquero("Legolas", 100, true, Arquero.NIVEL_EXPERTO);
    arquero.recibeAtaque(50);
    assertTrue(arquero.estaVivo());
    assertFalse(arquero.tieneArmadura());
    assertEquals(75, arquero.getVida());
    assertEquals(37, arquero.getLetalidad());
    assertEquals(0, arquero.getPoderCuracion());
  }

  @Test
  void testRecibeAtaqueSinArmaduraExperto() {
    // Caso: Crea un Arquero con 100 de vida, SIN armadura y Nivel experto. Recibe un ataque de 50
    // RE  : Debe estar vivo, SIN armadura, con una vida de 50, puntuación de ataque 25
    //       puntuación de curación 0 
    Arquero arquero = new Arquero("Legolas", 100, false, Arquero.NIVEL_EXPERTO);
    arquero.recibeAtaque(50);
    assertTrue(arquero.estaVivo());
    assertFalse(arquero.tieneArmadura());
    assertEquals(50, arquero.getVida());
    assertEquals(25, arquero.getLetalidad());
    assertEquals(0, arquero.getPoderCuracion());
  }

  @Test
  void testRecibeAtaqueMortalConArmaduraExperto() {
    // Caso: Crea un Arquero con 100 de vida, CON armadura y Nivel experto. Recibe un ataque de 200
    // RE  : Debe estar muerto, SIN armadura, con una vida de 0 (muerto), puntuación de ataque 0
    //       puntuación de curación 0
    Arquero arquero = new Arquero("Legolas", 100, true, Arquero.NIVEL_EXPERTO);
    arquero.recibeAtaque(200);
    assertFalse(arquero.estaVivo());
    assertFalse(arquero.tieneArmadura());
    assertEquals(0, arquero.getVida());
    assertEquals(0, arquero.getLetalidad());
    assertEquals(0, arquero.getPoderCuracion());
  }

  @Test
  void testRecibeAtaqueMortalSinArmaduraExperto() {
    // Caso: Crea un Arquero con 100 de vida, SIN armadura y Nivel experto. Recibe un ataque de 200
    // RE  : Debe estar muerto, SIN armadura, con una vida de 0 (muerto), ataque 0, curación 0
    Arquero arquero = new Arquero("Legolas", 100, false, Arquero.NIVEL_EXPERTO);
    arquero.recibeAtaque(200);
    assertFalse(arquero.estaVivo());
    assertFalse(arquero.tieneArmadura());
    assertEquals(0, arquero.getVida());
    assertEquals(0, arquero.getLetalidad());
    assertEquals(0, arquero.getPoderCuracion());
  }

  @Test
  void testRecibeCuraConVidaLlenaExperto() {
    // Caso: Crea un Arquero con 100 de vida, CON armadura y Nivel experto. Recibe una cura de 10
    // RE  : Debe estar vivo, CON armadura, vida 100 (la cura no hace nada), ataque 50, curación 0
    Arquero arquero = new Arquero("Legolas", 100, true, Arquero.NIVEL_EXPERTO);
    arquero.recibeCuracion(10);
    assertTrue(arquero.estaVivo());
    assertTrue(arquero.tieneArmadura());
    assertEquals(100, arquero.getVida());
    assertEquals(50, arquero.getLetalidad());
    assertEquals(0, arquero.getPoderCuracion());
  }

  @Test
  void testRecibeCuraInsuficienteExperto() {
    // Caso: Crea un Arquero con 100 de vid, SIN armadura y Nivel experto. Recibe un ataque de 50 y
    //       una cura de 10
    // RE  : Debe estar vivo,  SIN armadura, vida 60, ataque 30, curación 0
    Arquero arquero = new Arquero("Legolas", 100, false, Arquero.NIVEL_EXPERTO);
    arquero.recibeAtaque(50);
    arquero.recibeCuracion(10);
    assertTrue(arquero.estaVivo());
    assertFalse(arquero.tieneArmadura());
    assertEquals(60, arquero.getVida());
    assertEquals(30, arquero.getLetalidad());
    assertEquals(0, arquero.getPoderCuracion());
  }

  @Test
  void testRecibeCuraMasQueNecesariaExperto() {
    // Caso: Crea un Arquero con 100 de vida, SIN armadura y Nivel experto. Recibe un ataque de 50 y
    //       una cura de 60
    // RE  : Debe estar vivo, SIN armadura, vida 100, ataque 50, curación 0
    Arquero arquero = new Arquero("Legolas", 100, false, Arquero.NIVEL_EXPERTO);
    arquero.recibeAtaque(50);
    arquero.recibeCuracion(60);
    assertTrue(arquero.estaVivo());
    assertFalse(arquero.tieneArmadura());
    assertEquals(100, arquero.getVida());
    assertEquals(50, arquero.getLetalidad());
    assertEquals(0, arquero.getPoderCuracion());
  }

  @Test
  void testNoSePuedeCurarMuertoExperto() {
    // Caso: Crea un Arquero con 100 de vida, SIN armadura y Nivel novato. Recibe un ataque de 200 y
    //       una cura de 50
    // RE  : Debe estar muerto, SIN armadura, con una vida de 0 (muerto), puntuación de ataque 0
    //       puntuación de curación 0
    Arquero arquero = new Arquero("Legolas", 100, true, Arquero.NIVEL_EXPERTO);
    arquero.recibeAtaque(200);
    arquero.recibeCuracion(50);
    assertFalse(arquero.estaVivo());
    assertFalse(arquero.tieneArmadura());
    assertEquals(0, arquero.getVida());
    assertEquals(0, arquero.getLetalidad());
    assertEquals(0, arquero.getPoderCuracion());
  }

  @Test
  void testRecibeDosAtaquesDosArmadurasExperto() {
    // Caso: Crea un Arquero con 100 de vida, CON armadura y Nivel novato. Recibe un ataque de 50
    //       una armadura y otro ataque de 50
    // RE  : Debe estar vivo, SIN armadura, con una vida de 50, puntuación de ataque 25, puntuación
    //       de curación 0 
    Arquero arquero = new Arquero("Legolas", 100, true, Arquero.NIVEL_EXPERTO);
    arquero.recibeAtaque(50);
    arquero.recibeArmadura();
    arquero.recibeAtaque(50);
    assertTrue(arquero.estaVivo());
    assertFalse(arquero.tieneArmadura());
    assertEquals(50, arquero.getVida());
    assertEquals(25, arquero.getLetalidad());
    assertEquals(0, arquero.getPoderCuracion());
  }

}
