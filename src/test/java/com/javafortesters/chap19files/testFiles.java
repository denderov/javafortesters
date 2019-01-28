package com.javafortesters.chap19files;

import org.junit.Test;

import java.io.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class testFiles {

    @Test
    public void testReadFile() throws IOException {

        File inputFile = writeTestDataFile();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));

        String line;
        while((line = bufferedReader.readLine())!=null){
            System.out.println(line);
        }

//        try {
//            null;
//        } finally {
//            bufferedReader.close();
//        }

    }

    private File writeTestDataFile() throws IOException {

        File outputFile = File.createTempFile("forreading", null);
        //wrappers is not necessary. there is constructor with type of File in PrintWriter
        PrintWriter printWriter = new PrintWriter(outputFile);

        Random random = new Random();
        //https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
        int randCount = ThreadLocalRandom.current().nextInt(1, 100);
        for (int i = 1; i < randCount; i++) {
            printWriter.println("line" + i);
        }

        printWriter.close();

        return outputFile;

    }

}
