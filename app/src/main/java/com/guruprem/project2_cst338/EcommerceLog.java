package com.guruprem.project2_cst338;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.guruprem.project2_cst338.Database.AppDatabase;

@Entity(tableName = AppDatabase.Ecommerce_TABLE)
public class EcommerceLog {
    @PrimaryKey (autoGenerate = true)
    private int mUserId;

    private String mExercise;
    private int mReps;
    private double mWeight;



    private String mUsername;

    public EcommerceLog(int mUserId, String mExercise, int mReps, double mWeight, String mUsername) {
        this.mUserId = mUserId;
        this.mExercise = mExercise;
        this.mReps = mReps;
        this.mWeight = mWeight;
        this.mUsername = mUsername;
    }

    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int mUserId) {
        this.mUserId = mUserId;
    }

    public String getExercise() {
        return mExercise;
    }

    public void setExercise(String mExercise) {
        this.mExercise = mExercise;
    }

    public int getReps() {
        return mReps;
    }

    public void setReps(int mReps) {
        this.mReps = mReps;
    }

    public double getWeight() {
        return mWeight;
    }

    public void setWeight(double mWeight) {
        this.mWeight = mWeight;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    @Override
    public String toString() {
        return "EcommerceLog{" +
                "mUserId=" + mUserId +
                ", mExercise='" + mExercise + '\'' +
                ", mReps=" + mReps +
                ", mWeight=" + mWeight +
                ", mUsername='" + mUsername + '\'' +
                '}';
    }
}
