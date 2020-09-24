package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FractionTest {

    private Fraction fraction;

    private final int NUMERATOR = 4;
    private final int DENOMINATOR = 2;

    @BeforeEach
    void setUp() {
        fraction = new Fraction(NUMERATOR, DENOMINATOR);
    }

    @Test
    void testDecimal() {
        double decimal = fraction.decimal();
        double expectedDecimal = 2.0;
        assertEquals(decimal, expectedDecimal);
    }

    @Test
    void testGetNumerator() {
        assertEquals(fraction.getNumerator(), NUMERATOR);
    }

    @Test
    void testGetDenominator() {
        assertEquals(fraction.getDenominator(), DENOMINATOR);
    }

    @Test
    void testSetNumerator() {
        int newNumerator = 1;
        fraction.setNumerator(newNumerator);
        assertEquals(fraction.getNumerator(), newNumerator);
    }

    @Test
    void testSetDenominator() {
        int newDenominator = 1;
        fraction.setDenominator(newDenominator);
        assertEquals(fraction.getDenominator(), newDenominator);
    }

    @Test
    void testEmptyConstructor() {
        fraction = new Fraction();
        assertEquals(fraction.getNumerator(), 1);
        assertEquals(fraction.getDenominator(), 1);
    }
}