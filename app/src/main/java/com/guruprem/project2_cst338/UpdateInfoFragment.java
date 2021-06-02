package com.guruprem.project2_cst338;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UpdateInfoFragment#//newInstance} factory method to
 * create an instance of this fragment.
 */
public class UpdateInfoFragment extends Fragment {

    public UpdateInfoFragment() {
        // Required empty public constructor
    }
    private String pattern="[a-zA-Z0-9._-]+@[a-z]+.[a-z]+" ,namee,emaill,photoo;
    private EditText email,name,password;
    private CircleImageView photo;
    private Button changePhotoBtn,removePhotoBtn,updateUserInfoBtn,doneBtn;
    private Dialog loadingDialog,passwordDialog;
    private Uri uri;
    private boolean updatePhoto=false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_update_info, container, false);

       // photo=view.findViewById(R.id.profile_photo);
        name=view.findViewById(R.id.name_et);
        //email=view.findViewById(R.id.email_et);
        changePhotoBtn=view.findViewById(R.id.change_pic_btn);
        removePhotoBtn=view.findViewById(R.id.remove_pic_btn);
        updateUserInfoBtn=view.findViewById(R.id.update_info_button);

        namee=getArguments().getString("Name");
        emaill=getArguments().getString("Email");
        //photoo=getArguments().getString("Photo");

        Glide.with(getContext()).load(photoo).into(photo);
        name.setText(namee);
        email.setText(emaill);

        changePhotoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (getContext().checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {

                        Intent galleryIntent = new Intent(Intent.ACTION_PICK);
                        galleryIntent.setType("image/*");
                        startActivityForResult(galleryIntent, 1);

                    }else {
                        getActivity().requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},2);
                    }
                }else {
                    Intent galleryIntent = new Intent(Intent.ACTION_PICK);
                    galleryIntent.setType("image/*");
                    startActivityForResult(galleryIntent, 1);
                }
            }
        });

        removePhotoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uri=null;
                updatePhoto=true;
                Glide.with(getContext()).load(R.drawable.user_blue).into(photo);
            }
        });

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        updateUserInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //checkEmail();
            }
        });






        return view;
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