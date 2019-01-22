package com.javafortesters.chap015strings;

import com.javafortesters.domainentities.str.InvalidPassword;
import com.javafortesters.domainentities.str.User;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

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
        System.out.println(Arrays.toString(byteArray));
    }

    @Test
    public void regionMatchesTest() {
        String hello = "Hello Fella";
        assertTrue(hello.regionMatches(9, "young lady",6,2));
    }

    @Test
    public void regexTest() throws InvalidPassword {
        User user = new User("bob","passwo4rd");
        assertThat("passwo4rd",is(user.getPassword()));
    }

    @Test (expected = InvalidPassword.class)
    public void regexTestInvalid() throws InvalidPassword {
        User user = new User("bob","password");
        assertThat("password",is(user.getPassword()));
        StringBuilder sb=new StringBuilder("hello");
    }

    @Test
    public void stringBuilderTest() {
        StringBuilder sb = new StringBuilder(8);
        assertThat(8,is(sb.capacity()));
        sb.append("Hello stringBuilderTest!");
        assertTrue(sb.capacity()>8);
        sb.ensureCapacity(42);
        assertTrue(sb.capacity()>=42);
        sb.setLength(0);
        sb.insert(0, "Hello");
        assertEquals("Hello",sb.toString());
        sb.insert(sb.length(), '!');
        assertEquals("Hello!",sb.toString());
        sb.insert(sb.length()-1, " World");
        assertEquals("Hello World!",sb.toString());
    }

}
