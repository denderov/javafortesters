package com.javafortesters.chap19files;

import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void testRoots() {
        File[] roots= File.listRoots();
        for (File f:
             roots) {
            System.out.println(f.getAbsolutePath());
        }
    }

    @Test
    public void testMakeFile() throws IOException {

        File tmpFile = new File(System.getProperty("java.io.tmpdir"), "File" + System.currentTimeMillis());
        boolean newFile = tmpFile.createNewFile();
        assertTrue(tmpFile.exists());
        assertTrue(tmpFile.getName().matches("^File\\d+$"));
        assertTrue(tmpFile.getPath().startsWith(System.getProperty("java.io.tmpdir")));
        assertTrue(tmpFile.getParent().matches(System.getProperty("java.io.tmpdir")));
        System.out.println(tmpFile.getName());
        System.out.println(tmpFile.getPath());

    }

    @Test
    public void testPaths() throws IOException {

        File canonicalPath = new File("C:/1");
        File path1 = new File("C:/1/2/3/4/../../..");
        File path2 = new File("C:/1/2/../../1");
        System.out.println(canonicalPath.getAbsolutePath());
        System.out.println(path1.getAbsolutePath());
        System.out.println(path2.getAbsolutePath());
        assertEquals(canonicalPath.getAbsolutePath(),path1.getCanonicalPath());
        assertEquals(canonicalPath.getAbsolutePath(),path2.getCanonicalPath());

    }

    @Test
    public void testIsTempDirectoryIsDirectory() {

        File tmpDir = new File(System.getProperty("java.io.tmpdir"));
        assertTrue(tmpDir.isDirectory());

    }

    @Test
    public void testFileWriter() throws IOException {

        File file = File.createTempFile("test", null);

        PrintWriter printWriter = new PrintWriter(file);
        printWriter.println("line 1");
        printWriter.close();

        PrintWriter printWriterAppend = new PrintWriter(new BufferedWriter(new FileWriter(file,true)));
        printWriterAppend.println("line 2");
        printWriterAppend.close();

    }

    @Test
    public void testListFiles() {

        File tmpDir = new File(System.getProperty("java.io.tmpdir"));
        File[] files = tmpDir.listFiles();
        for (File f:
                Objects.requireNonNull(files)) {
            System.out.println((f.isDirectory()?"DIR:":"FIL:")+f.getName()+
                    " read:"+f.canRead()+" write:"+f.canWrite()+" execute:"+f.canExecute()+
                    " modified:"+f.lastModified());
        }

    }

    @Test
    public void testCopyAndMove() throws IOException {

        File fileSource = writeTestDataFile();
        File fileDestination = new File(fileSource.getCanonicalPath() + ".copy");
        Files.copy(fileSource.toPath(), fileDestination.toPath());

        File fileMoved = new File(fileSource.getCanonicalPath() + ".move");
        Files.move(fileSource.toPath(), fileMoved.toPath());

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
