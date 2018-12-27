package com.javafortesters.chap006domainentities.examples;

import com.javafortesters.domainentities.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    @Test
    public void canConstructANewUser() {
        User user = new User();
        assertEquals("default username expected","username",user.getUsername());
        assertEquals("default password expected","password",user.getPassword());
        User auser = new User();
        auser.username = "bob";
        assertEquals("not default username", "bob", auser.username);
        User buser=new User("admin","pA55w0rD");
        assertEquals("given username expected","admin",buser.getUsername());
        assertEquals("given password expected","pA55w0rD",buser.getPassword());
    }
    @Test
    public void canSetPasswordAfterConstructed() {
        User user=new User();
        user.setPassword("PaZZwor6");
        assertEquals("setter password expected","PaZZwor6",user.getPassword());
    }
}
