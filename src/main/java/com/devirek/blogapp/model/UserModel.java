package com.devirek.blogapp.model;

import javax.persistence.*;

@Entity
@Table
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userName;

    @Column
    private String userPassword;

    @Column
    private String userEmail;


    public Long getId() {
        return id;
    }

    public UserModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserModel setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public UserModel setUserPassword(String userPassword) {
        this.userPassword = userPassword;
        return this;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public UserModel setUserEmail(String userEmail) {
        this.userEmail = userEmail;
        return this;
    }
}
