package com.guruprem.project2_cst338;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.guruprem.project2_cst338.Database.AppDatabase;
import com.guruprem.project2_cst338.Database.EcommerceDAO;

public class LoginActivity extends AppCompatActivity {

    private EditText mUsernameField;
    private EditText mPasswordField;

    private Button mButton;

    private EcommerceDAO mEcommerce;

    private String mUsername;
    private String mPassword;
    private ImageButton closebtn;

    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        closebtn = findViewById(R.id.sign_in_close_btn);

        wireupDisplay();

        getDatabase();

        closebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChooseLogin.class);
                startActivity(intent);
            }
        });
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RoughWork_Admin.class);
                startActivity(intent);
            }
        });

    }

    private void wireupDisplay(){
        mUsernameField = findViewById(R.id.usernameInput);
        mPasswordField = findViewById(R.id.passwordInput);

        mButton = findViewById(R.id.signButton);
        Intent intent = getIntent();
        final boolean ADMIN = intent.getBooleanExtra("needAdminAuth",false);
        final boolean SEATS = intent.getBooleanExtra("reserveSeats",false);


    }

    private boolean validatePassword(){
        return mUser.getPassword().equals(mPassword);
    }

    private void getValuesFromDisplay(){
        mUsername = mUsernameField.getText().toString();
        mPassword = mPasswordField.getText().toString();
    }

    private boolean checkForUserInDatabase(){
        mUser = mEcommerce.getUserByUsername(mUsername);
        if(mUser == null){
            Toast.makeText(this,"no user " + mUsername + "found",Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void getDatabase(){
        mEcommerce = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DB_NAME)
                .allowMainThreadQueries()
                .build()
                .getEcommerceDAO();
    }

    public static Intent intentFactory(Context context){
        Intent intent = new Intent(context, LoginActivity.class);

        return intent;
    }
}
