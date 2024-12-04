package com.example.api1.models;

public class User {
    public String user;

    public User(String user, String token) {
        this.user = user;
    }

    public User() {

    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}
