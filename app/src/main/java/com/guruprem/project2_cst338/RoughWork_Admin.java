package com.guruprem.project2_cst338;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RoughWork_Admin extends AppCompatActivity {

    private Button logoutadmin;
    private Button additems;
    private Button viewitem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rough_work__admin);
        logoutadmin= findViewById(R.id.logoutbutton_admin);
        additems = findViewById(R.id.additem);
        viewitem = findViewById(R.id.viewallproductbtn);

        logoutadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RoughWork_Admin.this, "Bye Admin\n", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        additems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Admin_Item.class);
                startActivity(intent);
            }
        });

        viewitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProductDetail.class);
                startActivity(intent);
            }
        });

    }

}