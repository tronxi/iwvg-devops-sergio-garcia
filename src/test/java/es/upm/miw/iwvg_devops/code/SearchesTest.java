package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SearchesTest {

    @Test
    void testFindFirstProperFractionByUserIdShouldReturnFirstFractionIfExists() {
        Fraction expectedFraction = new Fraction(1, 5);

        Fraction fraction = new Searches().findFirstProperFractionByUserId("3");

        assertEquals(expectedFraction.getNumerator(), fraction.getNumerator());
        assertEquals(expectedFraction.getDenominator(), fraction.getDenominator());
    }

    @Test
    void testFindFirstProperFractionByUserIdShouldThrowExceptionWhenNotExists() {
        assertThrows(RuntimeException.class, () -> new Searches().findFirstProperFractionByUserId("4"));
    }

}