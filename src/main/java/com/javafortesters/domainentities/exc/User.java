package com.javafortesters.domainentities.exc;

public class User {

    public String username;
    private String password;

    public User(String username, String password) throws InvalidPassword {
        this.username = username;
        setPassword(password);
    }

    public User() throws InvalidPassword {
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

    public void setPassword(String password) throws InvalidPassword {
        if (password.length()<7) {
            throw new InvalidPassword("Password must be > 6 chars");
        }

        this.password = password;
    }

    public String getPermission() {
        return "Normal";
    }
}
