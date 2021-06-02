package com.guruprem.project2_cst338;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Cart1user extends AppCompatActivity {

    private Button menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart1user);

        menu =findViewById(R.id.nextbtn);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Cart1user.this, "Welcome to Main Menu\n", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),Roughwork_User.class);
                startActivity(intent);
            }
        });
    }
}