package ConsolaUtilidades;

import ConsolaUtilidades.ConsolaException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ConsolaExceptionTest {

    @Test
    void testMostrarErrorGeneral() {
        // Redirigir la salida de error para capturar el mensaje
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalErr = System.err;
        System.setErr(new PrintStream(outputStream));

        ConsolaException.mostrarError(new Exception("Error general"));

        // Restaurar la salida de error original
        System.setErr(originalErr);

        String output = outputStream.toString();
        assertTrue(output.contains("Error inesperado"));
    }

    @Test
    void testMostrarErrorNumeroEntero() {
        // Redirigir la salida de error para capturar el mensaje
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalErr = System.err;
        System.setErr(new PrintStream(outputStream));

        ConsolaException.mostrarError(new NumberFormatException("No es un entero"));

        // Restaurar la salida de error original
        System.setErr(originalErr);

        String output = outputStream.toString();
        assertTrue(output.contains("Error: Entrada no válida. Debe ser un número entero."));
    }

    @Test
    void testMostrarErrorArgumentoIllegal() {
        // Redirigir la salida de error para capturar el mensaje
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalErr = System.err;
        System.setErr(new PrintStream(outputStream));

        ConsolaException.mostrarError(new IllegalArgumentException("Argumento ilegal"));

        // Restaurar la salida de error original
        System.setErr(originalErr);

        String output = outputStream.toString();
        assertTrue(output.contains("Error: Entrada no válida."));
    }

    @Test
    void testMostrarErrorCloneNotSupported() {
        // Redirigir la salida de error para capturar el mensaje
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalErr = System.err;
        System.setErr(new PrintStream(outputStream));

        ConsolaException.mostrarError(new CloneNotSupportedException("No se puede clonar"));

        // Restaurar la salida de error original
        System.setErr(originalErr);

        String output = outputStream.toString();
        assertTrue(output.contains("Error: No puedes clonar la instancia generada."));
    }
}
