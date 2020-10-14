import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationEntryPointTest extends ApplicationEntryPoint{

    @Test
    public void testMain() {

    }

    @Test
    public void testHandleInput() {
        String inputFail1 = "5p 17s 8d - 3p 4s";
        assertEquals( "Format is wrong", handleInput(inputFail1));

        String inputFail2 = "5p 17s 8d % 3p 4s 10d";
        assertEquals("Unknown operator used", handleInput(inputFail2));

        String inputPass1 = "5p 17s 8d + 3p 4s 10d";
        assertEquals("Result: 9p 2s 6d", handleInput(inputPass1));

        String inputPass2 = "5p 17s 8d * 2";
        assertEquals("Result: 11p 15s 4d", handleInput(inputPass2));

        String inputPass3 = "5p 17s 8d - 3p 4s 10d";
        assertEquals("Result: 2p 12s 10d", handleInput(inputPass3));

        String inputPass4 = "18p 16s 1d / 15";
        assertEquals("Result: 1p 5s 0d (1s 1d)", handleInput(inputPass4));

        String inputFail3 = "5p 17s 8d + 3p rs 10d";
        assertEquals("Exception occurred: For input string: \"r\"", handleInput(inputFail3));
    }
}