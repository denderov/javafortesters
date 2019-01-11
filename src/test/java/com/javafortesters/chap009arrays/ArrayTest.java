package com.javafortesters.chap009arrays;

import com.javafortesters.domainentities.User;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ArrayTest {
    @Test
    public void userTest() {
        User[] threeUsers = new User[3];
//        threeUsers = new User[3];
        /*
for (int i = 0; i < 3; i++) {
threeUsers[i].username = "username";
//            threeUsers[i].setUsername("username"+Integer.toString(i));
//            threeUsers[i].setPassword("password"+Integer.toString(i));
threeUsers[i].setPassword("password");
}
*/
        threeUsers[0] = new User("bob","bA55Word");
        threeUsers[1] = new User("eris","eA55Word");
        threeUsers[2] = new User("ken","kA55Word");
        assertEquals("bob",threeUsers[0].getUsername());
        assertEquals("eris",threeUsers[1].getUsername());
        assertEquals("ken",threeUsers[2].getUsername());

/*
for (User user:threeUsers
) {
System.out.println("username: "+user.getUsername());
System.out.println("password: "+user.getPassword());
}
*/

        User[] oneHundredUsers = new User[100];
        for (int i = 0; i < 100; i++) {
            int count = i + 1;
            oneHundredUsers[i] = new User("username"+ count,"password"+ count);
        }
/*
for (User user:oneHundredUsers
) {
System.out.println("username: "+user.getUsername());
System.out.println("password: "+user.getPassword());
}
*/
        for (int i = 0; i < oneHundredUsers.length; i++) {
            int count = i + 1;
            assertEquals("username"+ count,oneHundredUsers[i].getUsername());
            assertEquals("password"+ count,oneHundredUsers[i].getPassword());
        }

        User[] tenUsers;
        tenUsers = Arrays.copyOf(oneHundredUsers,10);
        for (int i = 0; i < tenUsers.length; i++) {
            int count = i + 1;
            assertEquals("username"+ count,tenUsers[i].getUsername());
            assertEquals("password"+ count,tenUsers[i].getPassword());
        }
    }

    @Test
    public void workdaysTest() {
        String[] workdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        Arrays.sort(workdays);
        assertEquals("Friday",workdays[0]);
        assertEquals("Monday",workdays[1]);
        assertEquals("Thursday",workdays[2]);
        assertEquals("Tuesday",workdays[3]);
        assertEquals("Wednesday",workdays[4]);
    }

    @Test
    public void workdaysMixedTest() {
        String[] workdays = {"monday", "Tuesday", "Wednesday", "thursday", "Friday"};
        Arrays.sort(workdays);
        assertEquals("Friday",workdays[0]);
        assertEquals("Tuesday",workdays[1]);
        assertEquals("Wednesday",workdays[2]);
        assertEquals("monday",workdays[3]);
        assertEquals("thursday",workdays[4]);
    }

    @Test
    public void defaultFillTest() {
        int[] zero = new int[1];
        assertEquals(0,zero[0]);
        String[] nl = new String[1];
        assertNull(nl[0]);
    }

    @Test
    public void testTriangle() {
        int baseCount = 16;
        int[][] triangle = createTriangle(baseCount);
        print2DIntArray(triangle);
    }

    private void print2DIntArray(int[][] multi) {
        for(int[] outer:multi) {
            if (outer==null) {
                System.out.print("null");
            } else {
                for (int inner:outer) {
                    System.out.print(inner+",");
                }
            }
            System.out.println();
        }
    }

    private int[][] createTriangle(int baseCount) {
        int[][] result = new int[baseCount][];
        for (int i = 0; i < baseCount; i++) {
            result[i] = new int[i+1];
            for (int j = 0; j <= i; j++) {
                result[i][j]=j;
            }
        }
        return result;
    }
}
