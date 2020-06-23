package com.devirek.blogapp.dto;

import org.springframework.stereotype.Component;

@Component
public class RegisterRequestDTO {

    private String userName;
    private String email;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RegisterRequestDTO{" + "userName='" + userName + '\'' + ", email='" + email + '\'' + ", password='" + password + '\'' + '}';
    }
}
