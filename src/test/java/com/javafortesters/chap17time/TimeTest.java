package com.javafortesters.chap17time;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TimeTest {

    @Test
    public void currentTimeMillis()
    {
        long startTime=System.nanoTime();
        for (int x=0;x<10;x++){
            System.out.println("Current Time "+System.nanoTime());
        }
        long endTime=System.nanoTime();
        System.out.println("Total Time "+(endTime-startTime));
    }

    @Test
    public void noNumbersName() {
        StringBuilder stringBuilder = new StringBuilder();
        long uniqueValue = System.currentTimeMillis();
        byte chrN;
        while (uniqueValue > 0) {
            chrN = (byte) (65+uniqueValue%52);
            if (chrN > 90) {
                chrN += 6;
            }
            stringBuilder.insert(0,(char)chrN);
            uniqueValue = uniqueValue/52;
        }

        stringBuilder.insert(0, "user");

        String userName = stringBuilder.toString();
        System.out.println(userName);

        assertFalse(userName.matches(".*\\d+.*"));
        assertTrue(userName.matches("\\w+"));

    }



    @Test
    public void calendarTest() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.toString());
        System.out.println(calendar.getTime().toString());
        //15th December 2013, at 23:49 and 54 seconds
        calendar.set(2013,Calendar.DECEMBER,15,23,49,54);
        assertEquals(2013,calendar.get(Calendar.YEAR));
        assertEquals(Calendar.DECEMBER,calendar.get(Calendar.MONTH));
        assertEquals(15,calendar.get(Calendar.DATE));
        assertEquals(23,calendar.get(Calendar.HOUR_OF_DAY));
        assertEquals(49,calendar.get(Calendar.MINUTE));
        assertEquals(54,calendar.get(Calendar.SECOND));
        assertEquals(Calendar.PM,calendar.get(Calendar.AM_PM));

    }

}
