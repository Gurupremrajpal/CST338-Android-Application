package com.guruprem.project2_cst338;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class UpdateInfoUser extends AppCompatActivity {


    private String pattern="[a-zA-Z0-9._-]+@[a-z]+.[a-z]+" ,namee,emaill,photoo;
    private EditText email,name,password;
    private CircleImageView photo;
    private Button changePhotoBtn,removePhotoBtn,updateUserInfoBtn,doneBtn;
    private Dialog loadingDialog,passwordDialog;
    private Uri uri;
    private boolean updatePhoto=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_info_user);

        name= findViewById(R.id.name_et);
        //email=view.findViewById(R.id.email_et);
        changePhotoBtn= findViewById(R.id.change_pic_btn);
        removePhotoBtn= findViewById(R.id.remove_pic_btn);
        updateUserInfoBtn= findViewById(R.id.update_info_button);


        updateUserInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UpdateInfoUser.this, " Information Updated", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MyAddressesActivity.class);
                startActivity(intent);
            }
        });
    }

    private void checkInputs() {
        if(!TextUtils.isEmpty(email.getText())){
            if(!TextUtils.isEmpty(name.getText())){
                updateUserInfoBtn.setEnabled(true);
                updateUserInfoBtn.setTextColor(Color.rgb(255,255,255));
            }else{
                updateUserInfoBtn.setEnabled(false);
                updateUserInfoBtn.setTextColor(Color.argb(50,255,255,255));
            }
        }else{
            updateUserInfoBtn.setEnabled(false);
            updateUserInfoBtn.setTextColor(Color.argb(50,255,255,255));
        }
    }


}