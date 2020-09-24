package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class UserTest {

    private User user;

    private final String ID = "1";
    private final String NAME = "sergio";
    private final String FAMILY_NAME = "garcia";
    private List<Fraction> fractionList;


    @BeforeEach
    void setUp() {
        fractionList = new ArrayList<>(Arrays.asList(new Fraction(), new Fraction()));
        user = new User(ID, NAME, FAMILY_NAME, fractionList);
    }

    @Test
    void testGetId() {
        assertEquals(user.getId(), ID);
    }

    @Test
    void testGetName() {
        assertEquals(user.getName(), NAME);
    }

    @Test
    void testGetFamilyName() {
        assertEquals(user.getFamilyName(), FAMILY_NAME);
    }

    @Test
    void testGetFractions() {
        assertEquals(user.getFractions(), fractionList);
    }

    @Test
    void testInitials() {
        assertEquals(user.initials(), "s.");
    }

    @Test
    void testFullName() {
        assertEquals(user.fullName(), NAME + " " + FAMILY_NAME);
    }

    @Test
    void testEmptyConstructor() {
        user = new User();
        assertNull(user.getId());
        assertNull(user.getName());
        assertNull(user.getFamilyName());
        assertEquals(user.getFractions(), Collections.emptyList());
    }

    @Test
    void testAddFraction() {
        Fraction fraction = new Fraction();
        int expectedFractionListSize = 3;
        user.addFraction(fraction);
        assertEquals(user.getFractions().size(), expectedFractionListSize);
    }

    @Test
    void testSetFractions() {
        int expectedFractionListSize = 0;
        user.setFractions(Collections.emptyList());
        assertEquals(user.getFractions().size(), expectedFractionListSize);
    }

    @Test
    void testSetName() {
        String newName = "aa";
        user.setName(newName);
        assertEquals(user.getName(), newName);
    }

    @Test
    void testSetFamilyName() {
        String newFamilyName = "aa";
        user.setFamilyName(newFamilyName);
        assertEquals(user.getFamilyName(), newFamilyName);
    }

}