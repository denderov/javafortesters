package com.javafortesters.chap20numbers;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TestNumbers {

    @Test
    public void testSubtract() {

        double generalAmount = 5;
        int generalAmountInCents = (int)generalAmount*100;

        //double
        generalAmount -= .43;
        generalAmount -= .73;
        generalAmount -= 1.73;

        assertEquals(2.11, generalAmount,0.01);

        //int
        generalAmountInCents -= 43;
        generalAmountInCents -= 73;
        generalAmountInCents -= 173;

        assertEquals(generalAmountInCents, 211);

        //BigDecimal
        BigDecimal generalAmountBig = new BigDecimal("5");
        BigDecimal generalBig = generalAmountBig.subtract(new BigDecimal("0.43"))
                .subtract(new BigDecimal("0.73"))
                .subtract(new BigDecimal("1.73"));

        assertEquals(new BigDecimal("2.11"), generalBig);

    }

    @Test
    public void testBigIntegerBasic() {

        BigDecimal bigDecimal = new BigDecimal(0);

        bigDecimal = bigDecimal.add(new BigDecimal(10))
                .multiply(new BigDecimal(2))
                .subtract(new BigDecimal(10))
                .divide(new BigDecimal(2));

        assertEquals(new BigDecimal(5),bigDecimal);

    }

    @Test
    public void testBigIntegerComparison() {
        //>, <, ==, !=, >=, or <=
        assertTrue(BigDecimal.TEN.compareTo(BigDecimal.ONE) > 0);
        assertFalse(BigDecimal.TEN.compareTo(BigDecimal.ONE) < 0);
        assertFalse(BigDecimal.TEN.compareTo(BigDecimal.ONE) == 0);
        assertTrue(BigDecimal.TEN.compareTo(BigDecimal.ONE) != 0);
        assertTrue(BigDecimal.TEN.compareTo(BigDecimal.ONE) >= 0);
        assertFalse(BigDecimal.TEN.compareTo(BigDecimal.ONE) <= 0);
    }

}
