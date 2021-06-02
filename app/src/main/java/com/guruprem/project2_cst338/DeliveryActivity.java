package com.guruprem.project2_cst338;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class DeliveryActivity extends AppCompatActivity {

    public final static int SELECT_ADDRESS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        startActivity(new Intent(DeliveryActivity.this, Roughwork_User.class).putExtra("MODE", SELECT_ADDRESS));

    }
}