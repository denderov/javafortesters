package com.javafortesters.chap016random;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

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

    @Test
    public void testGaussianRandom() {
        Random generate = new Random();
        int d1 = 0;
        int d2 = 0;
        int d3 = 0;
        int d4 = 0;
        double value;
        for (int i = 0; i < 1000; i++) {
            value = Math.abs(generate.nextGaussian());
            if (value < 4) {
                d4++;
                if (value < 3) {
                    d3++;
                    if (value < 2) {
                        d2++;
                        if (value < 1) {
                            d1++;
                        }
                    }
                }
            }
        }

        System.out.println("about 68.3% one standard deviation = "+d1/10.0);
        System.out.println("about 95.4% two standard deviation = "+d2/10.0);
        System.out.println("about 99.7% three standard deviation = "+d3/10.0);
        System.out.println("about 99.9% four standard deviation = "+d4/10.0);
    }

    @Test
    public void testGaussianAge() {

        Map<Integer, Integer> agesCount = new HashMap<>();
        Random generate = new Random();
        Integer age = 0;

        for (int i = 0; i < 1000; i++)
        {

            do {
                age = (int)(generate.nextGaussian()*5)+35;
            } while (age<0&&age>150);

            Integer count = agesCount.get(age);

            if (count == null) {
                agesCount.put(age, 1);
            } else {
                agesCount.put(age,++count);
            }

        }

        for (Map.Entry<Integer, Integer> e : agesCount.entrySet()) {
            System.out.println(""+e.getKey()+":"+e.getValue());
        }
    }

}
