import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationEntryPointTest extends ApplicationEntryPoint {

    @Test
    public void testPassInput1() {
        String input = "5p 17s 8d + 3p 4s 10d";
        assertEquals("Result: 9p 2s 6d", handleInput(input));
    }

    @Test
    public void testPassInput2() {
        String input = "5p 17s 8d * 2";
        assertEquals("Result: 11p 15s 4d", handleInput(input));
    }

    @Test
    public void testPassInput3() {
        String input = "5p 17s 8d - 3p 4s 10d";
        assertEquals("Result: 2p 12s 10d", handleInput(input));
    }

    @Test
    public void testPassInput4() {
        String input = "18p 16s 1d / 15";
        assertEquals("Result: 1p 5s 0d (1s 1d)", handleInput(input));
    }

    @Test
    public void testInvalidFormatInput() {
        String input = "5p 17s 8d - 3p 4s";
        assertEquals("Format is wrong", handleInput(input));
    }

    @Test
    public void testInvalidOperatorInput() {
        String input = "5p 17s 8d % 3p 4s 10d";
        assertEquals("Unknown operator used", handleInput(input));
    }

    @Test
    public void testExceptionFormatInput() {
        String input = "5p 17s 8d + 3p rs 10d";
        assertEquals("Exception occurred: For input string: \"r\"", handleInput(input));
    }

    @Test
    public void testUnknownInput1() {
        String input = "18p 16s 1d / 15p 14s 4d";
        assertEquals("Unknown input!", handleInput(input));
    }

    @Test
    public void testUnknownInput2() {
        String input = "18p 16s 1d * 15p 14s 4d";
        assertEquals("Unknown input!", handleInput(input));
    }
}