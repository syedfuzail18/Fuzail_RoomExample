package com.fuzail.roomexample;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "users")  //if we dont write (tableName = "users") it will create a data base with default name of class
public class User {

    @PrimaryKey
    private  int id;

    @ColumnInfo(name = "User_Name") //if we dont write @ColumnInfo(name = "Name") it will create a col named name.
    private String name;

    @ColumnInfo(name = "User_Email")
    private  String email;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
