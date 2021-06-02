package com.guruprem.project2_cst338;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.guruprem.project2_cst338.Database.AppDatabase;

@Entity(tableName = AppDatabase.USER_TABLE)
public class User {
    @PrimaryKey(autoGenerate = true)
    private int mUserId;

    private String mUsername;
    private String mPassword;
    private String mOldPass;
    private String mNewPass;
    private String mConfPass;


    public User(String mUsername, String mPassword) {
        this.mUsername = mUsername;
        this.mPassword = mPassword;
    }



    public String getOldPass() {
        return mOldPass;
    }

    public void setOldPass(String mOldPass) {
        this.mOldPass = mOldPass;
    }

    public String getNewPass() {
        return mNewPass;
    }

    public void setNewPass(String mNewPass) {
        this.mNewPass = mNewPass;
    }

    public String getConfPass() {
        return mConfPass;
    }

    public void setConfPass(String mConfPass) {
        this.mConfPass = mConfPass;
    }

    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int userId) {
        mUserId = userId;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }


    @Override
    public String toString() {
        String output;

        output = "Username: " + mUsername;
        output += "\n";
        output += "Password: " + mPassword;


        return output;
    }
}
