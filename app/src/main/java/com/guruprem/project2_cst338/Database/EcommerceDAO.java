package com.guruprem.project2_cst338.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.guruprem.project2_cst338.AddressesModel;
import com.guruprem.project2_cst338.EcommerceLog;
import com.guruprem.project2_cst338.User;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface EcommerceDAO {


    @Insert
    void insert(EcommerceLog... gymLogs);

    @Update
    void update(EcommerceLog... gymLogs);

    @Delete
    void delete(EcommerceLog gymLog);

    @Query("SELECT * FROM " + AppDatabase.Ecommerce_TABLE)
    List<EcommerceLog> getAllGymLogs();

    @Query("SELECT * FROM " + AppDatabase.Ecommerce_TABLE+ " WHERE mUserId = :userId")
    List<EcommerceLog> getGymLogsById(int userId);

    @Query("SELECT * FROM " + AppDatabase.Ecommerce_TABLE+ " WHERE mUserId = :userId ")
    List<EcommerceLog> getGymLogsByUserId(int userId);

    @Insert
    void insert(User...users);

    @Update
    void update(User...users);

    @Delete
    void delete(User users);

    @Query(value = "SELECT * FROM " + AppDatabase.USER_TABLE+ " WHERE mUsername =:username ")
    User getUserByUsername(String username);


    @Query("SELECT * FROM " + AppDatabase.USER_TABLE)
    List<User> getAllUsers();


    @Query("SELECT * FROM " + AppDatabase.USER_TABLE + " WHERE mUserId =:userId ")
    User getUserByUserId(int userId);


    public static List<String> loadedCategoriesNames=new ArrayList<>();

    public static List<String> wishlist=new ArrayList<>();


    public static List<String> myRatedIds=new ArrayList<>();
    public static List<Long> myRating=new ArrayList<>();

    public static List<String> cartList=new ArrayList<>();

    public static List<AddressesModel> addressesModelList=new ArrayList<>();
    public static int selectedAddress=-1;
}
