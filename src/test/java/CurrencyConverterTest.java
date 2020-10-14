import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CurrencyConverterTest extends CurrencyConverter {

    @Test
    public void testSum() {
        Amount amount1 = new Amount("5p", "17s", "8d");
        Amount amount2 = new Amount("3p", "4s", "10d");
        assertEquals("Result: 9p 2s 6d", sum(amount1, amount2));
    }

    @Test
    public void testSumNegativeAmount1() {
        Amount amount1 = new Amount("5p", "17s", "8d");
        Amount amount2 = new Amount("-3p", "4s", "10d");
        assertEquals("Number/s can't be negative", sum(amount1, amount2));
    }

    @Test
    public void testSumNegativeAmount2() {
        Amount amount1 = new Amount("3p", "-4s", "10d");
        Amount amount2 = new Amount("3p", "4s", "10d");
        assertEquals("Number/s can't be negative", sum(amount1, amount2));
    }

    @Test
    public void testShouldFailMissingFormat() {
        assertThrows(IllegalArgumentException.class, () -> new Amount("5p", "17", "8d"));
    }

    @Test
    public void testSubtract() {
        Amount amount1 = new Amount("5p", "17s", "8d");
        Amount amount2 = new Amount("3p", "4s", "10d");
        assertEquals("Result: 2p 12s 10d", subtract(amount1, amount2));
    }

    @Test
    public void testSubtractNegative1() {
        Amount amount1 = new Amount("5p", "-17s", "8d");
        Amount amount2 = new Amount("-3p", "4s", "10d");
        assertEquals("Number/s can't be negative", subtract(amount1, amount2));
        assertEquals("Number/s can't be negative", subtract(amount2, amount1));
    }

    @Test
    public void testSubtractNegative2() {
        Amount amount1 = new Amount("-3p", "4s", "10d");
        Amount amount2 = new Amount("3p", "4s", "-10d");
        assertEquals("Number/s can't be negative", subtract(amount1, amount2));
        assertEquals("Number/s can't be negative", subtract(amount2, amount1));
    }

    @Test
    public void testSubtractSecondBiggerThanFirst() {
        Amount amount1 = new Amount("5p", "17s", "8d");
        Amount amount2 = new Amount("7p", "4s", "10d");
        assertEquals("Second amount can't be bigger than first amount", subtract(amount1, amount2));
    }

    @Test
    public void testMultiply() {
        Amount amount1 = new Amount("5p", "17s", "8d");
        int multiplier = 2;
        assertEquals("Result: 11p 15s 4d", multiply(amount1, multiplier));
    }

    @Test
    public void testMultiplyNegative() {
        Amount amount1 = new Amount("5p", "-17s", "8d");
        int multiplier = 2;
        assertEquals("Number/s can't be negative", multiply(amount1, multiplier));
    }

    @Test
    public void testMultiplyNegativeMultiplier() {
        Amount amount1 = new Amount("5p", "17s", "8d");
        int negativeMultiplier = -2;
        assertEquals("Number/s can't be negative", multiply(amount1, negativeMultiplier));
    }

    @Test
    public void testDivide1() {
        Amount amount2 = new Amount("5p", "17s", "8d");
        int divider2 = 3;
        assertEquals("Result: 1p 19s 2d (2d)", divide(amount2, divider2));
    }

    @Test
    public void testDivide2() {
        Amount amount = new Amount("18p", "16s", "1d");
        int divider = 15;
        assertEquals("Result: 1p 5s 0d (1s 1d)", divide(amount, divider));
    }

    @Test
    public void testDivide3() {
        Amount amount = new Amount("70000p", "0s", "0d");
        int divider = 71000;
        assertEquals("Result: 0p 19s 8d (183p 6s 8d)", divide(amount, divider));
    }

    @Test
    public void testDivideNegativeAmount() {
        Amount amount = new Amount("-18p", "16s", "1d");
        int divider = 15;
        assertEquals("Number/s can't be negative", divide(amount, divider));
    }

    @Test
    public void testDivideNegativeDivider() {
        Amount amount = new Amount("18p", "16s", "1d");
        int divider = -15;
        assertEquals("Number/s can't be negative", divide(amount, divider));
    }
}