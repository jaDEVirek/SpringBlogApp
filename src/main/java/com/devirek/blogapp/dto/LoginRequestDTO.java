package com.devirek.blogapp.dto;

public class LoginRequestDTO {

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public LoginRequestDTO setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginRequestDTO setPassword(String password) {
        this.password = password;
        return this;

    }
}
