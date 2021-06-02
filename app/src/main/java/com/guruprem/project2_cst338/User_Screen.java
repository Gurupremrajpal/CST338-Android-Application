package com.guruprem.project2_cst338;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import static com.guruprem.project2_cst338.R.layout.activity_user_screen;


public class User_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_user_screen);

    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_drawer,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id== R.id.nav_sign_out){
            Intent intent = new Intent(User_Screen.this, CreateActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        if(id== R.id.nav_my_cart){
            Intent intent = new Intent(User_Screen.this, LoginActivity.class);
            startActivity(intent);
            return true;
        }
                return super.onOptionsItemSelected(item);
    }
}