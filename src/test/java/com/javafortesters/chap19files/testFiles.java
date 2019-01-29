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

        try {
            String line;
            while((line = bufferedReader.readLine())!=null){
                System.out.println(line);
            }
        } finally {
            bufferedReader.close();
        }

    }

    @Test
    public void testSuffixOfTempFile() throws IOException {

        System.out.println(System.getProperty("java.io.tmpdir"));
        File outputFile = writeTestDataFile();
        System.out.println(outputFile.getName());
        outputFile.delete();
        outputFile = writeTestDataFile(".txt");
        System.out.println(outputFile.getName());
        outputFile.delete();

    }

    private File writeTestDataFile() throws IOException {

        return writeTestDataFile(null);

    }

    private File writeTestDataFile(String suffix) throws IOException {

        File outputFile = File.createTempFile("forreading", suffix);
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
