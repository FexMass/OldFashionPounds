import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CurrencyConverterTest extends CurrencyConverter {

    @Test
    public void testSum() {
        Amount amount1 = new Amount("5p", "17s", "8d");
        Amount amount2 = new Amount("3p", "4s", "10d");
        assertEquals("Result: 9p 2s 6d", sum(amount1, amount2));
        assertThrows(IllegalArgumentException.class, ()-> new Amount("5p", "17", "8d"));
    }
    @Test
    public void testSubtract() {
        Amount amount1 = new Amount("5p", "17s", "8d");
        Amount amount2 = new Amount("3p", "4s", "10d");
        assertEquals("Result: 2p 12s 10d", subtract(amount1, amount2));
    }
    @Test
    public void testDivide() {
        Amount amount1 = new Amount("5p", "17s", "8d");
        int divider1 = 3;
        assertEquals("Result: 1p 19s 2d (2d)", divide(amount1, divider1));

        Amount amount2 = new Amount("18p", "16s", "1d");
        int divider2 = 15;
        assertEquals("Result: 1p 5s 0d (1s 1d)", divide(amount2, divider2));
    }
    @Test
    public void testMultiply() {
        Amount amount1 = new Amount("5p", "17s", "8d");
        int multiplier = 2;
        assertEquals("Result: 11p 15s 4d", multiply(amount1, multiplier));
    }
}
