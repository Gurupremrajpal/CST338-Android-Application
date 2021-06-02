package com.guruprem.project2_cst338;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Roughwork_User extends AppCompatActivity {

    private Button logout;
    private Button delete;
    private Button edit_account;
    private Button viewproducts;
    private Button additem;
    private Button viewproductdetails;
    private  Button viewcart;
    private  Button passchange;
    private Button viewaddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roughwork_user);
        logout= findViewById(R.id.logoutbutton_User);
        delete = findViewById(R.id.delete_account);
        edit_account = findViewById(R.id.edit_account);
        viewproducts = findViewById(R.id.viewproductsuserbtn);
        additem = findViewById(R.id.add_item_user_btn);
        viewproductdetails = findViewById(R.id.view_product_details_user);
        viewcart = findViewById(R.id.view_cart);
        passchange = findViewById(R.id.pass_change_button);
        viewaddress = findViewById(R.id.viewaddressbtn);

        viewaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ViewAddress.class);
                startActivity(intent);
            }
        });

        passchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Change_Password.class);
                startActivity(intent);
            }
        });

        viewcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Rough_Cart1.class);
                startActivity(intent);
            }
        });

        viewproductdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Product1User.class);
                startActivity(intent);
            }
        });

        additem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Product_with_cart.class);
                startActivity(intent);
            }
        });

        viewproducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ProductDetailUser.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ChooseLogin.class);
                startActivity(intent);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Roughwork_User.this, "Account Deleted\n", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),CreateActivity.class);
                startActivity(intent);
            }
        });

        edit_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),UpdateInfoUser.class);
                startActivity(intent);
            }
        });

    }




}