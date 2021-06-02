package com.guruprem.project2_cst338;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Admin_Item extends AppCompatActivity {

    private Button additems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_item);
        additems = findViewById(R.id.additem);

        additems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Admin_Item.this, "Item Saved\n", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), RoughWork_Admin.class);
                startActivity(intent);
            }
        });
    }
}