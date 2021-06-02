package com.guruprem.project2_cst338;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        SystemClock.sleep(4000);
        Intent loginIntent = new Intent(SplashScreen.this,ChooseLogin.class);
        startActivity(loginIntent);
        finish();
    }


}