package com.jarvis.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by arungu on 1/11/2016.
 */
@Entity
public class User extends BaseEntity {

    @Column(length = 20)
    private String userName;

    @Column(unique = true)
    private  String userEmail;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
