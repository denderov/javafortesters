package com.javafortesters.chap004testswithotherclasses.examples;

import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IntegerExamplesTest {
    @Test
    public void integerExploration() {
        Integer four = new Integer(4);
        assertEquals("intValue returns 4",4,four.intValue());
        Integer five = new Integer("5");
        assertEquals("intValue returns int 5",5,five.intValue());
        Integer six = 6;
        assertEquals("invValue returns 6",6,six.intValue());
        assertEquals("11 becomes b","b",Integer.toHexString(11));
        assertEquals("3 becomes 3","3",Integer.toHexString(3));
        assertEquals("21 becomes 15","15",Integer.toHexString(21));
        assertEquals("Integer.MIN_VALUE equals -2147483648",-2147483648,Integer.MIN_VALUE);
        assertEquals("Integer.MIN_VALUE equals 2147483647",2147483647,Integer.MAX_VALUE);
        Integer firstFour=new Integer(4);
        Integer secondFour=new Integer(4);
        assertEquals(firstFour,secondFour);
        assertTrue(firstFour!=secondFour);
        Integer firstSix = 6;
        Integer secondSix = 6;
        assertTrue(firstSix==secondSix);
    }
}
