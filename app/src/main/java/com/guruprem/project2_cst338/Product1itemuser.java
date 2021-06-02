package com.guruprem.project2_cst338;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Product1itemuser extends AppCompatActivity {

    private Button next;
    private Button addcart;
    private Button viewcart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product1itemuser);
        next = findViewById(R.id.nextproductbtn);
        addcart = findViewById(R.id.add_to_cart_user1);
        viewcart = findViewById(R.id.viewcart1_user);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Product2itemuser.class);
                startActivity(intent);
            }
        });

        addcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Product1itemuser.this, "Item added to cart\n", Toast.LENGTH_SHORT).show();

            }
        });

        viewcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Cart1user.class);
                startActivity(intent);
            }
        });



    }
}