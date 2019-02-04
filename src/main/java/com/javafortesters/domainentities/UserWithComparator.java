package com.javafortesters.domainentities;

import java.util.Comparator;

public class UserWithComparator implements Comparable {

    public String username;
    private String password;

    public UserWithComparator(String username, String password) {
        this.username = username;
        setPassword(password);
    }

    public UserWithComparator() {
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
        if (password.length()<0) {
            throw new IllegalArgumentException("Password must be > 6 chars");
        }

        this.password = password;
    }

    public String getPermission() {
        return "Normal";
    }

    @Override
    public int compareTo(Object o) {

        UserWithComparator user2 = (UserWithComparator)o;

        if (this.getUsername().compareTo(user2.getUsername()) == 0) {
            return 0;
        }

        int user1Comparator = this.getPassword().length() +
                this.getUsername().length();

        int user2Comparator = user2.getPassword().length() +
                user2.getUsername().length();

        int val =  user1Comparator - user2Comparator;

        if(val==0){
            val = this.getUsername().compareTo(user2.getUsername());
        }

        return val;

    }
}
