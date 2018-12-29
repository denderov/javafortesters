package com.javafortesters.chap008selectiondecisions;

import org.junit.Test;

import static com.javafortesters.domainentities.Cat.catOrCats;
import static org.junit.Assert.*;

public class SelectionTest {
    @Test
    public void isCatOrCats() {
        assertEquals("2 == cats", "cats",catOrCats(2));
        assertEquals("1 == cat", "cat",catOrCats(1));
    }

    @Test
    public void isTruthy() {

        boolean truthy = true;
        boolean falsey = false;

        if (truthy) assertTrue("truthy==true",truthy);

        if (truthy) {
            assertTrue("truthy==true",truthy);
            assertFalse("truthy!=false",!truthy);
        }

        if (truthy)
            assertTrue("truthy==true",truthy);
        else
            assertFalse("truthy==false",truthy);

        if (truthy) {
            if (!falsey)
                if (truthy&&!falsey) {
                    if (falsey||truthy) {
                        assertTrue(truthy);
                        assertFalse(falsey);
                    }
                }
            else {
                    assertTrue(truthy);
                    assertTrue(falsey);
                }
        }
        else
            if (!truthy) {
                if (falsey) {
                    assertTrue(falsey);
                    assertFalse(truthy);
                }
                else {
                    assertFalse(falsey);
                    assertFalse(truthy);
                }
            }
    }

    @Test
    public void shortCodeSwitch() {
        assertEquals("United Kingdom",fullName("UK"));
        assertEquals("United States",fullName("USA"));
        assertEquals("France",fullName("fr"));
        assertEquals("Sweden",fullName("Se"));
        assertEquals("Rest Of World",fullName("RU"));
    }

    private String fullName(String shortCode) {
        String fullName;
        switch (shortCode.toUpperCase()) {
            case "UK":
                fullName = "United Kingdom";
                break;
            case "US":
                fullName = "United States";
                break;
            case "USA":
                fullName = "United States";
                break;
            case "FR":
                fullName = "France";
                break;
            case "SE":
                fullName = "Sweden";
                break;
            default:
                fullName = "Rest Of World";
                break;
        }
        return fullName;
    }

    @Test
    public void checkNumTransition() {
        assertEquals("One",getStringByNumber(1));
        assertEquals("Two",getStringByNumber(2));
        assertEquals("Three",getStringByNumber(3));
        assertEquals("Four",getStringByNumber(4));
        assertEquals("Too small",getStringByNumber(-1));

    }

    private String getStringByNumber(int i) {
        switch (i) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            default:
                if (i>4) return "Too big";
                else return "Too small";
        }
    }
}
