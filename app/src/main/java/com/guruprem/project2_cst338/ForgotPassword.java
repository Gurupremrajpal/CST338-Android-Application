package com.guruprem.project2_cst338;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {

    private EditText email;
    private TextView msg,goBack;
    private Button resetPassBtn;
    private FrameLayout parentframeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        email= findViewById(R.id.forgot_pass_email);
        resetPassBtn= findViewById(R.id.reset_pass_button);
        msg= findViewById(R.id.forgot_pass_msg);
        goBack= findViewById(R.id.forgot_pass_go_back);
        parentframeLayout= findViewById(R.id.reg_frame_layout);

        resetPassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ForgotPassword.this, "Password reset instructions send to your email id\n", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),CreateActivity.class);
                startActivity(intent);
            }
        });

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),CreateActivity.class);
                startActivity(intent);
            }
        });
    }

    private void checkInputs() {
        if(!TextUtils.isEmpty(email.getText())) {
            resetPassBtn.setEnabled(true);
        }
        else{
            resetPassBtn.setEnabled(false);
        }
    }

}