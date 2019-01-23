package com.javafortesters.chap016random;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class RandomTest {

    @Test
    public void intervalTest() {
        Random generate = new Random();
        for (int i = 0; i < 1000; i++) {
            assertTrue(generate.nextInt()<Integer.MAX_VALUE);
            assertTrue(generate.nextInt()>=Integer.MIN_VALUE);
            boolean tstBool = generate.nextBoolean();
            assertTrue(tstBool||!tstBool);
            assertTrue(generate.nextLong()>=Long.MIN_VALUE);
            assertTrue(generate.nextLong()<Long.MAX_VALUE);
            assertTrue(generate.nextFloat()>=0.0f);
            assertTrue(generate.nextFloat()<1.0f);
            assertTrue(generate.nextDouble()>=0.0d);
            assertTrue(generate.nextDouble()<1.0d);
            //nextBytes fills a byte[] with random data
            assertTrue(generate.nextInt(100)>=0);
            assertTrue(generate.nextInt(100)<100);

        }
    }

    @Test
    public void testIntervalRandomInt() {
        Random generate = new Random();
        int beginInt=15;
        int endInt=20;
        List<Integer> randomInts = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            randomInts.add(generate.nextInt(1+endInt-beginInt)+beginInt);
        }
        assertTrue(randomInts.contains(15));
        assertTrue(randomInts.contains(16));
        assertTrue(randomInts.contains(17));
        assertTrue(randomInts.contains(18));
        assertTrue(randomInts.contains(19));
        assertTrue(randomInts.contains(20));
        assertFalse(randomInts.contains(14));
        assertFalse(randomInts.contains(21));
    }

}
