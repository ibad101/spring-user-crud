package com.mecaps.springpractice.Entity;

import jakarta.persistence.*;
/*
👉 Imports all JPA annotations like:

@Entity
@Table
@Id
@GeneratedValue

👉 Without this → annotations won’t work
 */
@Entity

 /*
 👉 Marks this class as a database entity
👉 Hibernate will convert this class into a table
  */

@Table(name ="Users")
/*
👉 Specifies table name in database = users
👉 If removed → default name = user
 */
public class UserTable {
    @Id
     /*
     👉 Marks this variable as Primary Key
      */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     /*

     Auto generate value
      AUTO_INCREMENT (MySQL)
      */
    private long id;
    private String user_name;
    private  int age;
    private  String location;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
