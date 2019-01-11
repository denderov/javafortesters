package com.javafortesters.chap13exceptions;

import com.javafortesters.domainentities.exc.InvalidPassword;
import com.javafortesters.domainentities.exc.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestExceptions {

    @Test(expected = InvalidPassword.class)
    public void isThrownOnSetPassword() throws InvalidPassword {
        User user = new User();
        user.setPassword("123");
    }

    @Test(expected = InvalidPassword.class)
    public void isThrownOnConstructor() throws InvalidPassword {
        User user = new User("username","p");
    }

    @Test
    public void isNotThrownOnDefaultConstructor() throws InvalidPassword {
        User user = new User();
        assertEquals("password",user.getPassword());
    }

    @Test
    public void isThrownCorrectText() throws InvalidPassword {
        User user = new User();
        try {
            user.setPassword("123");
            fail("Not thrown");
        } catch (InvalidPassword e) {
            assertEquals("Password must be > 6 chars",e.getMessage());
        }
    }

}
