package com.javafortesters.chap018properties;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PropertiesTest {

    @Test
    public void testListProperties() {
        Properties properties = new Properties();

        //name=bob, gender=male, password=paSSw0rd
        properties.setProperty("name", "bob");
        properties.setProperty("gender", "male");
        properties.setProperty("password", "paSSw0rd");
        assertEquals(3, properties.size());

        for (String key:
             properties.stringPropertyNames() ) {
            System.out.println(key + "=" + properties.get(key));
        }

        properties.list(System.out);

        assertTrue(properties.containsKey("gender"));
        assertEquals("bob",properties.getProperty("name"));
        assertEquals("Admin",properties.getProperty("permission","Admin"));

    }

    @Test
    public void testPropertiesFile() throws IOException {

        Properties properties = new Properties();

        properties.setProperty("step1", "ready");
        properties.setProperty("step2", "go");

        String tmpFile = System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") + "tempfile.txt";

        FileOutputStream fileOutputStream = new FileOutputStream(tmpFile);

        properties.store(fileOutputStream,"Test file");

        fileOutputStream.close();

        FileReader fileReader = new FileReader(tmpFile);

        Properties loadedProperties = new Properties();

        try {
            loadedProperties.load(fileReader);
        }
        finally {
            fileReader.close();
        }

        assertEquals("ready",loadedProperties.getProperty("step1"));
        assertEquals("go",loadedProperties.getProperty("step2"));
        assertEquals(properties.getProperty("step1"),loadedProperties.getProperty("step1"));
        assertEquals(properties.getProperty("step2"),loadedProperties.getProperty("step2"));

        boolean b = new File(tmpFile).delete();

    }

}
