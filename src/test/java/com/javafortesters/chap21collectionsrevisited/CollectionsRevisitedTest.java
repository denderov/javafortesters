package com.javafortesters.chap21collectionsrevisited;

import com.javafortesters.domainentities.User;
import com.javafortesters.domainentities.UserComparator;
import com.javafortesters.domainentities.UserWithComparator;
import com.javafortesters.domainobject.DupeUserComparator;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class CollectionsRevisitedTest {

    @Test
    public void sortedSetWithComparatorForUserByUsername(){
        User bob = new User("Bob", "pA55Word");   // 11
        User tiny = new User("TinyTim", "hello"); //12
        User rich = new User("Richie", "RichieRichieRich"); // 22
        User sun = new User("sun", "tzu"); // 6
        User mrBeer = new User("Stafford", "sys"); // 11

        SortedSet<User> userSortedList =
                new TreeSet<User>(new UserComparator());

        userSortedList.add(bob);
        userSortedList.add(tiny);
        userSortedList.add(rich);
        userSortedList.add(sun);
        userSortedList.add(mrBeer);

        User[] users = new User[userSortedList.size()];
        userSortedList.toArray(users);

        /*assertEquals(sun.getUsername(), users[0].getUsername());
        assertEquals(bob.getUsername(), users[1].getUsername());
        assertEquals(mrBeer.getUsername(), users[2].getUsername());
        assertEquals(tiny.getUsername(), users[3].getUsername());
        assertEquals(rich.getUsername(), users[4].getUsername());*/

        assertEquals(bob.getUsername(), users[0].getUsername());
        assertEquals(rich.getUsername(), users[1].getUsername());
        assertEquals(mrBeer.getUsername(), users[2].getUsername());
        assertEquals(tiny.getUsername(), users[3].getUsername());
        assertEquals(sun.getUsername(), users[4].getUsername());

    }

    @Test
    public void sortedSetWithDupeUserComparatorForUser() {

        User first = new User("First", "pwd");
        User second = new User("Second", "pwd");
        User secondSecond = new User("Second", "pwd");

        SortedSet<User> userSortedList =
                new TreeSet<User>(new DupeUserComparator());

        userSortedList.add(first);
        userSortedList.add(second);
        userSortedList.add(secondSecond);

        assertEquals(2,userSortedList.size());

        User[] users = new User[userSortedList.size()];
        userSortedList.toArray(users);

        assertEquals(first.getUsername(),users[0].getUsername());
        assertEquals(second.getUsername(),users[1].getUsername());
        assertEquals(secondSecond.getUsername(),users[1].getUsername());

    }

    @Test
    public void sortedSetForUserWithComparator() {
        UserWithComparator first = new UserWithComparator("First", "pwd");
        UserWithComparator second = new UserWithComparator("Second", "pwd");
        UserWithComparator secondSecond = new UserWithComparator("Second", "pwd");

        SortedSet<UserWithComparator> userSortedList =
                new TreeSet<>();

        userSortedList.add(first);
        userSortedList.add(second);
        userSortedList.add(secondSecond);

        assertEquals(2,userSortedList.size());

        UserWithComparator[] users = new UserWithComparator[userSortedList.size()];
        userSortedList.toArray(users);

        assertEquals(first.getUsername(),users[0].getUsername());
        assertEquals(second.getUsername(),users[1].getUsername());
        assertEquals(secondSecond.getUsername(),users[1].getUsername());

    }




}
