package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        assertThrows(RuntimeException.class, () -> new Searches()
                .findFirstProperFractionByUserId("4"));
    }

    @Test
    void testFindDecimalImproperFractionByUserNameShouldFindFractionsOfAllUsersWithSameName() {
        List<Double> expectedDecimalList = Arrays.asList(2d, -0.5d);

        List<Double> decimalList = new Searches()
                .findDecimalImproperFractionByUserName("Oscar")
                .collect(Collectors.toList());

        assertEquals(expectedDecimalList, decimalList);
    }

    @Test
    void testFindDecimalImproperFractionByUserNameShouldFindFractionsOfOneUser() {
        List<Double> expectedDecimalList = Arrays.asList(2d, 1.3333333333333);

        List<Double> decimalList = new Searches()
                .findDecimalImproperFractionByUserName("Ana")
                .collect(Collectors.toList());

        assertEquals(expectedDecimalList.get(0), decimalList.get(0));
        assertEquals(expectedDecimalList.get(1), decimalList.get(1), 10e-5);
    }

    @Test
    void testFindUserNameByAnyImproperFraction() {
        List<String> expectedUserNamesList = Arrays.asList("Oscar", "Ana", "Oscar", "Antonio", "Paula");

        List<String> userNamesList = new Searches()
                .findUserNameByAnyImproperFraction()
                .collect(Collectors.toList());

        assertEquals(expectedUserNamesList, userNamesList);
    }

    @Test
    void testFindFractionDivisionByUserId() {
        Fraction expectedFraction = new Fraction(0, 2);

        Fraction fraction = new Searches()
                .findFractionDivisionByUserId("1");

        assertEquals(expectedFraction.getNumerator(), fraction.getNumerator());
        assertEquals(expectedFraction.getDenominator(), fraction.getDenominator());
    }

    @Test
    void testFindFractionDivisionByUserIdShouldThrowExceptionWhenFractionNotFound() {

        assertThrows(RuntimeException.class, () -> new Searches()
                .findFractionDivisionByUserId("0"));

    }

}