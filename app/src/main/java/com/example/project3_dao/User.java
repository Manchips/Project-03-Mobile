package com.example.project3_dao;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = AppDataBase.USER_TABLE)
public class User {

    @PrimaryKey(autoGenerate = true)
    private int mUserId;

    private String mUsername;
    private String mPassword;

    private List<Sheet> mSavedSheets;

    public User(String mUsername, String mPassword){
        this.mUsername = mUsername;
        this.mPassword = mPassword;
    }

    public String getUsername() {
        return mUsername;
    }
    public void setUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public String getPassword() {
        return mPassword;
    }
    public void setPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public int getUserId() {
        return mUserId;
    }
    public void setUserId(int mUserId) {
        this.mUserId = mUserId;
    }



    @Override
    public String toString() {
        return mUsername;
    }


}