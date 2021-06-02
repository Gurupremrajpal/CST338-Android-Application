package com.guruprem.project2_cst338;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.guruprem.project2_cst338.Database.AppDatabase;
import com.guruprem.project2_cst338.Database.EcommerceDAO;

public class AddUserActivity extends AppCompatActivity {


    private EditText mUsernameField;
    private EditText mPasswordField;

    private Button mButton;

    private EcommerceDAO mEcommerce;
    ImageButton closebtn;
    private String mUsername;
    private String mPassword;

    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        closebtn = findViewById(R.id.sign_in_close_btn);
        wireupDisplay();
        getDatabase();

        closebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CreateActivity.class);
                startActivity(intent);
            }
        });
    }

    private void wireupDisplay(){
        mUsernameField = findViewById(R.id.editTextNewUsername);
        mPasswordField = findViewById(R.id.editTextNewPassword);

        mButton = findViewById(R.id.buttonCreateUser);

        mButton.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {
                getValuesFromDisplay();
                if (checkForUserAlreadyInDatabase() && userNameValidCheck()){

                    User user = new User(mUsername,mPassword);
                    mEcommerce.insert(user);
                    Toast.makeText(AddUserActivity.this, "New user added\n"+user, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),CreateActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
    private void getDatabase(){
        mEcommerce = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DB_NAME)
                .allowMainThreadQueries()
                .build()
                .getEcommerceDAO();
    }
    private void getValuesFromDisplay(){
        mUsername = mUsernameField.getText().toString();
        mPassword = mPasswordField.getText().toString();
    }

    private boolean userNameValidCheck(){
        if (mUsername.length() < 6){
            Toast.makeText(this,"Username not long enough",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (mPassword.length() < 6){
            Toast.makeText(this,"Password not long enough",Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private boolean stringEvaluator(String text){
        int charCount = 0;
        int intCount = 0;
        for (int i = 0; i < text.length(); i++){
            Log.d("AddUserActivity","Analyzing character: " +text.charAt(i));
            if (Character.isDigit(text.charAt(i)) ) {
                intCount+=1;
            }
            else if (Character.isAlphabetic(text.charAt(i))){
                charCount+=1;
            }
        }
        if ((charCount < 3) || (intCount < 3)){
            return false;
        }
        return true;
    }

    //check if user already registered in database
    private boolean checkForUserAlreadyInDatabase(){
        mUser = mEcommerce.getUserByUsername(mUsername);
        if(mUser == null){
            return true;
        }

        Toast.makeText(this,"Account already registered",Toast.LENGTH_SHORT).show();
        return false;
    }

    public static Intent intentFactory(Context context){
        Intent intent = new Intent(context, AddUserActivity.class);

        return intent;
    }
}