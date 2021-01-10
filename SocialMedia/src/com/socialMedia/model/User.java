package com.socialMedia.model;


public class User {
    int userId;
    String name;
    String email;

    public int getUserId() {
        return userId;
    }

    public User(String name) {
        this.name = name;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
