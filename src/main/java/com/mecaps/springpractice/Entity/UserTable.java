package com.mecaps.springpractice.Entity;

import jakarta.persistence.*;

@Entity
@Table(name ="Users")
public class UserTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String userName;
    private int age;
    private String address;

    // Getter for ID
    public long getId() {
        return id;
    }

    // Setter for ID
    public void setId(long id) {
        this.id = id;
    }

    // ✅ FIXED (proper naming)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }

    // ✅ FIXED (address instead of location)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}