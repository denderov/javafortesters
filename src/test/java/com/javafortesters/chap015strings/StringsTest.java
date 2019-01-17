package com.javafortesters.chap015strings;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StringsTest {

    @Test
    public void escapeTest() {
        System.out.println("Testing \\r \r;\\n \n; \\t \t;  \\b \b;");
    }

    @Test
    public void constructTest() {
        assertThat(new String("Test"), is("Test"));
        char[] charArray = {'T','e','s','t'};
        assertThat(new String(charArray), is("Test"));
        String testStr = new String(charArray);
        byte[] byteArray = testStr.getBytes();
        System.out.println(byteArray);
    }
}
