package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FractionTest {

    private Fraction fraction;

    private final int NUMERATOR = 2;
    private final int DENOMINATOR = 3;

    @BeforeEach
    void setUp() {
        fraction = new Fraction(NUMERATOR, DENOMINATOR);
    }

    @Test
    void testDecimal() {
        double decimal = fraction.decimal();
        double expectedDecimal = 0.6666;
        assertEquals(decimal, expectedDecimal, 0.01);
    }

    @Test
    void testGetNumerator() {
        assertEquals(NUMERATOR, fraction.getNumerator());
    }

    @Test
    void testGetDenominator() {
        assertEquals(DENOMINATOR, fraction.getDenominator());
    }

    @Test
    void testSetNumerator() {
        int newNumerator = 1;
        fraction.setNumerator(newNumerator);
        assertEquals(newNumerator, fraction.getNumerator());
    }

    @Test
    void testSetDenominator() {
        int newDenominator = 1;
        fraction.setDenominator(newDenominator);
        assertEquals(newDenominator, fraction.getDenominator());
    }

    @Test
    void testEmptyConstructor() {
        fraction = new Fraction();
        assertEquals(1, fraction.getNumerator());
        assertEquals(1, fraction.getDenominator());
    }

    @Test
    void testIsProper() {
        assertTrue(fraction.isProper());
    }

    @Test
    void testIsImproper() {
        fraction = new Fraction(2, 1);
        assertTrue(fraction.isImproper());
    }

    @Test
    void testIsEquivalent() {
        Fraction equivalentFraction = new Fraction(4, 6);
        assertTrue(fraction.isEquivalent(equivalentFraction));
    }

    @Test
    void testAdd() {
        Fraction fractionToAdd = new Fraction(1, 5);
        Fraction expectedFraction = new Fraction(13, 15);

        Fraction addedFraction = fraction.add(fractionToAdd);
        assertEquals(expectedFraction.getDenominator(), addedFraction.getDenominator());
        assertEquals(expectedFraction.getNumerator(), addedFraction.getNumerator());
    }

    @Test
    void testMultiply() {
        Fraction fractionToMultiply = new Fraction(2, 5);
        Fraction expectedFraction = new Fraction(4, 15);

        Fraction multipliedFraction = fraction.multiply(fractionToMultiply);
        assertEquals(expectedFraction.getDenominator(), multipliedFraction.getDenominator());
        assertEquals(expectedFraction.getNumerator(), multipliedFraction.getNumerator());
    }

    @Test
    void testDivide() {
        fraction = new Fraction(4, 5);
        Fraction fractionToDivide = new Fraction(3, 9);
        Fraction expectedFraction = new Fraction(36, 15);

        Fraction dividedFraction = fraction.divide(fractionToDivide);
        assertEquals(expectedFraction.getDenominator(), dividedFraction.getDenominator());
        assertEquals(expectedFraction.getNumerator(), dividedFraction.getNumerator());
    }

    @Test
    void testToString() {
        String expectedString = "Fraction{" +
                "numerator=2" +
                ", denominator=3"+
                '}';
        assertEquals(expectedString, fraction.toString());
    }
}