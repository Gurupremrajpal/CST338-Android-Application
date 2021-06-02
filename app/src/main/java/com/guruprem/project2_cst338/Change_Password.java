package com.guruprem.project2_cst338;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Change_Password extends AppCompatActivity {

    private EditText oldPassword,newPassword,confirmNewPass;
    private Button updatePassBtn;
    ImageButton closebtn;

    public Change_Password() {
        //empty constructor
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        oldPassword= findViewById(R.id.old_password);
        newPassword= findViewById(R.id.new_password);
        confirmNewPass= findViewById(R.id.confirm_new_password);
        updatePassBtn= findViewById(R.id.update_pass_btn);
        closebtn= findViewById(R.id.sign_in_close_btn);


        closebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChooseLogin.class);
                startActivity(intent);
            }
        });


//        oldPassword.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                checkInputs();
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
//
//        newPassword.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                checkInputs();
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
//
//        confirmNewPass.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                checkInputs();
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });


        updatePassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Change_Password.this, "Password Changed\n", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),CreateActivity.class);
                startActivity(intent);
            }
        });
    }

    private void checkInputs() {

        if(!TextUtils.isEmpty(oldPassword.getText()) && oldPassword.length()>=8){
            if(!TextUtils.isEmpty(newPassword.getText()) && newPassword.length()>=8){
                if(!TextUtils.isEmpty(confirmNewPass.getText()) && confirmNewPass.length()>=8){
                    updatePassBtn.setEnabled(true);
                    updatePassBtn.setTextColor(Color.rgb(255,255,255));
                }else{
                    updatePassBtn.setEnabled(false);
                    updatePassBtn.setTextColor(Color.argb(50,255,255,255));
                }
            }else{
                updatePassBtn.setEnabled(false);
                updatePassBtn.setTextColor(Color.argb(50,255,255,255));
            }
        }else{
            updatePassBtn.setEnabled(false);
            updatePassBtn.setTextColor(Color.argb(50,255,255,255));
        }

    }


}