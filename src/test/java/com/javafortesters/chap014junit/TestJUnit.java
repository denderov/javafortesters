package com.javafortesters.chap014junit;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TestJUnit {

    @Test
    public void junitTest() {
        assertEquals(true,1==Integer.valueOf(1));
        assertFalse(new Integer(1) == new Integer(1));
        assertTrue(Integer.valueOf(1)==Integer.valueOf(1));
        int[] a = {1,2,3,4,5};
        int[] b = {4,2,5,1,3};
        Arrays.sort(b);
        assertArrayEquals(a,b);
        assertNotNull("");
        assertNotSame(new Integer(1),new Integer(1));
        assertNull(null);
        assertSame('*', (char)42);
    }
}
