package com.javafortesters.domainentities;

import com.javafortesters.domainobject.TestAppEnv;

public class UserWithGetUrl extends User {

    public UserWithGetUrl(String username, String password) {
        super(username,password);
    }
    public static String getUrl() {
        return TestAppEnv.getUrl();
    }
}
