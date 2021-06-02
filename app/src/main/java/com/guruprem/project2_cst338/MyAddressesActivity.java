package com.guruprem.project2_cst338;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class MyAddressesActivity extends AppCompatActivity {

    private TextView AddNewAddress;

    private TextView saveaddress;
    private Button deliverAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addresses);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("My addresses");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        AddNewAddress = findViewById(R.id.AddNewAddress);
        saveaddress = findViewById(R.id.address_saved);
        deliverAddress = findViewById(R.id.deliver_here_button);





        deliverAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddAddressActivity.class);
                startActivity(intent);
            }
        });



    }
}