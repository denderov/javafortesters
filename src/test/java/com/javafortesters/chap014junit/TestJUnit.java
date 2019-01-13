package com.javafortesters.chap014junit;


import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
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

    public void junitThatTest() {

        assertThat(1,is(1));//assertEquals - check expected and actual are equal
        assertThat(false,is(false)); //assertFalse - check actual is false
        assertThat(true,is(true)); //assertTrue - check actual is true
        int[] a = {1,2,3,4,5};
        int[] b = {4,2,5,1,3};
        Arrays.sort(b);
        assertThat(a,equalTo(b)); //assertArrayEquals - check expected and actual arrays are equal
        assertThat(1,is(not(null))); //assertNotNull - check actual is not null
        assertThat(1,is(not(2))); //assertNotSame - check expected and actual are different
        assertThat(null,is(nullValue())); //assertNull - check actual is null
        assertThat(1,is(1)); //assertSame - check expected and actual are the same

    }

    public void hamcrestTest() {

        assertThat("abc",containsString("b"));
        assertThat("abc",startsWith("ab"));
        assertThat("abc",endsWith("c"));

    }
}
