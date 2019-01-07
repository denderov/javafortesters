package com.javafortesters.chap012inheritance;

import com.javafortesters.domainentities.ReadOnlyUser;
import com.javafortesters.domainentities.UserWithGetUrl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InheritanceTest
{
    @Test
    public void checkUserGetUrl() {
        assertEquals("Returns Hard Coded URL","http://192.123.0.3:67", UserWithGetUrl.getUrl());
    }

    @Test
    public void chekUserConstructor() {
        UserWithGetUrl user = new UserWithGetUrl("testUser","tstPSWD");
        assertEquals("testUser",user.getUsername());
    }

    @Test
    public void chekReadOnlyUser() {
        ReadOnlyUser user = new ReadOnlyUser();
        assertEquals("username",user.getUsername());
        assertEquals("password",user.getPassword());
        assertEquals("ReadOnly",user.getPermission());
    }

}
