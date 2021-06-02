package com.guruprem.project2_cst338;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Product2Details extends AppCompatActivity {

    private Button nextproduct2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product2_details);


        nextproduct2 = findViewById(R.id.nextproductbtn);

        nextproduct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Product2Details.this, "No More Products\n Returned to the Main Menu\n", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), RoughWork_Admin.class);
                startActivity(intent);
            }
        });


    }
}