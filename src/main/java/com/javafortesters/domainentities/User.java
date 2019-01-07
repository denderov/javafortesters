package com.javafortesters.domainentities;

public class User {

    public String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        setPassword(password);
    }

    public User() {
        this("username","password");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length()<7) {
            throw new IllegalArgumentException("Password must be > 6 chars");
        }

        this.password = password;
    }
}
