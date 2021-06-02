package com.guruprem.project2_cst338;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.guruprem.project2_cst338.Database.EcommerceDAO;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateActivity extends AppCompatActivity {

    Button loginbtn;
    private Button createButton;
    private Button forgotpass;
    EditText etEmail,pass;
    EditText etPass;
    String response;
    ImageButton closebtn;

    private String mUsername;
    private String mPassword;
    private EcommerceDAO mEcommerce;
    private com.guruprem.project2_cst338.User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        loginbtn = (Button)findViewById(R.id.sign_in_btn);
        etEmail = (EditText)findViewById(R.id.sign_in_email);
        etPass = (EditText)findViewById(R.id.sign_in_password);
        createButton = findViewById(R.id.logoutbutton);
        closebtn = findViewById(R.id.sign_in_close_btn);
        forgotpass= findViewById(R.id.forgotpassbtn);


        loginbtn.setOnClickListener(new OkHandler());



        closebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ChooseLogin.class);
                startActivity(intent);
            }
        });

        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ForgotPassword.class);
                startActivity(intent);
            }
        });

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), com.guruprem.project2_cst338.AddUserActivity.class);
                startActivity(intent);
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Roughwork_User.class); //user has to log in to admin before modifying system
                intent.putExtra("needAdminAuth",true);
                startActivity(intent);
            }
        });
    }


    private void checkInputs() {
        if(!TextUtils.isEmpty(etEmail.getText())){
            if(!TextUtils.isEmpty(pass.getText()) && pass.length()>=8){
                loginbtn.setEnabled(true);
            }else{
                loginbtn.setEnabled(false);
            }
        }else{
            loginbtn.setEnabled(false);
        }
    }


    private class OkHandler implements View.OnClickListener {
        public boolean isValid(String em,String pw) {
            Pattern emailPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
            Matcher matcher = emailPattern.matcher(em);
            if(!matcher.find()) { return false; }
            if(pw.length() == 0) { return false; }
            return true;
        }
        public void onClick( View v ) {
            final String email = etEmail.getText().toString();
            final String password = etPass.getText().toString();
            if (!isValid(email,password))
                Toast.makeText(CreateActivity.this,"Error; Invalid entries",Toast.LENGTH_SHORT).show();
            else {
                Thread thread = new Thread(new Runnable() {
                    public void run() {
                        try {
                            com.guruprem.project2_cst338.LoginClient c = new com.guruprem.project2_cst338.LoginClient("grajpal@csumb.edu", 2021);
                            ArrayList<String> helloFrame = c.rframe(); // Receive HELLO
                            if (!helloFrame.get(0).equals("HELLO")) {
                                throw new IOException("ERROR");
                            }
                            String[] typeFrame = {"TYPE", "LOGIN"};
                            c.sframe(typeFrame); // send TYPE
                            ArrayList<String> back_typeFrame = c.rframe(); // Receive back TYPE
                            if (!back_typeFrame.get(0).equals("TYPE") || !back_typeFrame.get(1).equals("LOGIN")) {
                                throw new IOException("ERROR");
                            }
                            String[] regFrame = {"REGISTER", email, password};
                            c.sframe(regFrame); // send REGISTER
                            ArrayList<String> back_regFrame = c.rframe(); // Receive back REGISTER
                            if (!back_regFrame.get(0).equals("REGISTER")) {
                                throw new IOException("ERROR");
                            }
                            response = back_regFrame.get(1);
                            c.close();
                        } catch (SocketTimeoutException e) {
                            response = "Authentication Server Timeout.";
                        } catch (Exception e) {
                            response = "Authentication Server Error";
                        }
                    }
                });
                thread.start();
                try {
                    thread.join();
                } catch (Exception e) {
                    System.out.println("FAILED TO COMPLETE THREAD");
                    response = "Unknown Error";
                }

                Intent returnIntent = new Intent();
                returnIntent.putExtra("response",response);
                returnIntent.putExtra("email",email);
                returnIntent.putExtra("password",password);
                setResult(CreateActivity.RESULT_OK, returnIntent);
                finish();
            }
        }
    }
    private boolean validatePassword(){
        return mUser.getPassword().equals(mPassword);
    }

    private void getValuesFromDisplay(){
        mUsername = etEmail.getText().toString();
        mPassword = etPass.getText().toString();
    }

    private boolean checkForUserInDatabase(){
        mUser = mEcommerce.getUserByUsername(mUsername);
        if(mUser == null){
            Toast.makeText(this,"no user " + mUsername + "found",Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

}