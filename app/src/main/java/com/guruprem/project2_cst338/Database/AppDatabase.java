package com.guruprem.project2_cst338.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.guruprem.project2_cst338.EcommerceLog;
import com.guruprem.project2_cst338.User;

@Database(entities = {EcommerceLog.class, User.class}, version = 1)

public abstract class AppDatabase extends RoomDatabase {
    public static final String DB_NAME = "ECOMMERCE_DATABASE";
    public static final String Ecommerce_TABLE = "ECOMMERCE_TABLE";
    public static final String USER_TABLE = "USER_TABLE";


    public abstract EcommerceDAO getEcommerceDAO();

}
