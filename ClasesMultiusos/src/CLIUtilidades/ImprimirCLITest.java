package CLIUtilidades;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ImprimirCLITest {

    private ImprimirCLI impresor;

    @BeforeEach
    void setUp() {
        impresor = ImprimirCLI.getInstance();
    }

    @Test
    void testGetInstance() {
        ImprimirCLI anotherImpresor = ImprimirCLI.getInstance();
        assertSame(impresor, anotherImpresor, "Las instancias deben ser la misma.");
    }

    @Test
    void testCloneNotSupported() {
        assertThrows(CloneNotSupportedException.class, () -> {
            impresor.clone();
        }, "Se esperaba CloneNotSupportedException al intentar clonar.");
    }

    @Test
    void testImprimir() {
        // Redirigir la salida estándar para capturar la salida
        String output = captureOutput(() -> {
            impresor.imprimir("Hola, mundo!");
        });
        assertEquals("Hola, mundo!\n", output);
    }

    @Test
    void testPrintOffJump() {
        String output = captureOutput(() -> {
            impresor.printOffJump("Texto con printf");
        });
        assertEquals("Texto con printf", output);
    }

    @Test
    void testPrintOffSpace() {
        String output = captureOutput(() -> {
            impresor.printOffSpace("  Texto con espacios  ");
        });
        assertEquals("Textoconespacios", output);
    }

    @Test
    void testPrintTrim() {
        String output = captureOutput(() -> {
            impresor.printTrim("  Texto con espacios  ");
        });
        assertEquals("Texto con espacios", output);
    }

    @Test
    void testImprimirCabecera() {
        String output = captureOutput(() -> {
            impresor.imprimirCabecera("Cabecera");
        });
        assertTrue(output.contains("Cabecera"));
        assertTrue(output.contains("=-"));
    }

    @Test
    void testImprimirUpper() {
        String output = captureOutput(() -> {
            impresor.imprimirUpper("Texto en mayúsculas");
        });
        assertTrue(output.contains("TEXTO EN MAYÚSCULAS"));
        assertTrue(output.contains("=-"));
    }

    // Método auxiliar para capturar la salida estándar
    private String captureOutput(Runnable runnable) {
        java.io.ByteArrayOutputStream outputStream = new java.io.ByteArrayOutputStream();
        java.io.PrintStream originalOut = System.out;
        System.setOut(new java.io.PrintStream(outputStream));
        runnable.run();
        System.setOut(originalOut);
        return outputStream.toString();
    }
}
