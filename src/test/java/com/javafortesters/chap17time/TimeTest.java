package com.javafortesters.chap17time;

import org.junit.Test;

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

}
