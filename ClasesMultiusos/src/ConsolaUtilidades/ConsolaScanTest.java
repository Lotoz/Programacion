package ConsolaUtilidades;

import ConsolaUtilidades.ConsolaScan;
import ConsolaUtilidades.ConsolaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ConsolaScanTest {

    private ConsolaScan consolaScan;

    @BeforeEach
    void setUp() {
        consolaScan = ConsolaScan.getInstance();
    }

    @Test
    void testGetInstance() {
        ConsolaScan anotherConsolaScan = ConsolaScan.getInstance();
        assertSame(consolaScan, anotherConsolaScan, "Las instancias deben ser la misma.");
    }

    @Test
    void testCloneNotSupported() {
        assertThrows(CloneNotSupportedException.class, () -> {
            consolaScan.clone();
        }, "Se esperaba CloneNotSupportedException al intentar clonar.");
    }

    @Test
    void testLeerString() {
        // Redirigir la entrada estándar para simular la entrada del usuario
        String input = "Texto de prueba";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        
        String result = consolaScan.leerString();
        assertEquals("Texto de prueba", result);
    }

    @Test
    void testLeerInt() {
        // Redirigir la entrada estándar para simular la entrada del usuario
        String input = "123";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        
        int result = consolaScan.leerInt();
        assertEquals(123, result);
    }

    @Test
    void testLeerIntInvalid() {
        // Redirigir la entrada estándar para simular la entrada del usuario
        String input = "abc";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        
        assertThrows(NumberFormatException.class, () -> {
            consolaScan.leerInt();
        });
    }
    

    @Test
    void testLeerDoubleInvalid() {
        // Redirigir la entrada estándar para simular la entrada del usuario
        String input = "abc";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        
        assertThrows(NumberFormatException.class, () -> {
            consolaScan.leerDouble();
        });
    }

    @Test
    void testLeerFloat() {
        // Redirigir la entrada estándar para simular la entrada del usuario
        String input = "123.45";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        
        float result = consolaScan.leerFloat();
        assertEquals(123.45f, result);
    }

    @Test
    void testLeerFloatInvalid() {
        // Redirigir la entrada estándar para simular la entrada del usuario
        String input = "abc";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        
        assertThrows(NumberFormatException.class, () -> {
            consolaScan.leerFloat();
        });
    }
}