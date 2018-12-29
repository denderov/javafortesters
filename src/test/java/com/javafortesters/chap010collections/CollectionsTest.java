package com.javafortesters.chap010collections;

import com.javafortesters.domainentities.User;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class CollectionsTest {
    @Test
    public void checkUseForLoop() {
        String[] someDays = {"Tuesday","Thursday",
                "Wednesday","Monday",
                "Saturday","Sunday",
                "Friday"};

        List<String> days = Arrays.asList(someDays);

        int loopCount;
        for(loopCount=0; !days.get(loopCount).equals("Monday"); loopCount++ ){}
        assertEquals("Monday is at position 3", 3, loopCount);
    }

    @Test
    public void userCollections() {
        Collection<User> usersB = new ArrayList<>();
        assertEquals(0,usersB.size());
        addUsersB(usersB);
        assertEquals(2,usersB.size());
        assertFalse(usersB.isEmpty());
        Collection<User> usersA = new ArrayList<>();
        addUsersA(usersA);
        assertEquals(2,usersA.size());
        assertFalse(usersA.isEmpty());
        usersB.addAll(usersA);
        assertTrue(usersB.containsAll(usersA));
        assertEquals(4,usersB.size());
        usersA.removeAll(usersB);
        assertTrue(usersA.isEmpty());
        usersB.clear();
        assertTrue(usersB.isEmpty());
    }

    private void addUsersB(Collection<User> users) {
        users.add(new User("bob","b1"));
        users.add(new User("bill","b2"));
    }

    private void addUsersA(Collection<User> users) {
        users.add(new User("ann","a1"));
        users.add(new User("andy","a2"));
    }
}
