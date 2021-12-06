package com.smw.Middleground.Database;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUser {
    private int id;
    private String username;
    private String password;
    private int role;

    public MyUser(int id, String username, String password, int role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public MyUser() {}

    public UserDetails returnUserDetails() {
        if (this.role == 2) {
            UserDetails userDetails = User.builder()
                    .username(username)
                    .password(password)
                    .roles("ADMIN", "USER")
                    .build();
            return userDetails;
        }
        else {
            UserDetails userDetails = User.builder()
                    .username(username)
                    .password(password)
                    .roles("USER")
                    .build();
            return userDetails;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getRole() {
        return role;
    }
}
