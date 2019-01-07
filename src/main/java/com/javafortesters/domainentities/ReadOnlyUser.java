package com.javafortesters.domainentities;

public class ReadOnlyUser extends User {
    @Override
    public String getPermission() {
        return "ReadOnly";
    }
}
