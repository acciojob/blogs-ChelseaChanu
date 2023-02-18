package com.driver.models;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    @Column(unique = true)
    private String password;
    private String firstName;
    private String lastName;

    //mapping with blog
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Blog> listOfBlogsWritten = new ArrayList<>();

    public User() {

    }

    public User(String username, String password) {
        this.userName = username;
        this.password = password;
        this.firstName = "test";
        this.lastName = "test";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Blog> getListOfBlogsWritten() {
        return listOfBlogsWritten;
    }

    public void setListOfBlogsWritten(List<Blog> listOfBlogsWritten) {
        this.listOfBlogsWritten = listOfBlogsWritten;
    }
}
