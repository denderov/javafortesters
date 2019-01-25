package com.javafortesters.chap17time;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

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
        while (uniqueValue > 1) {
            chrN = (byte) (64+uniqueValue%52);
            if (chrN > 90) {
                chrN += 6;
            }
            stringBuilder.append((char)chrN);
            uniqueValue = uniqueValue/52;
        }

        System.out.println(stringBuilder.toString());

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
