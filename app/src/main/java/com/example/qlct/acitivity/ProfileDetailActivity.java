package com.example.qlct.acitivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.qlct.MainActivity;
import com.example.qlct.R;
import com.example.qlct.databinding.ActivityAddChiTieuBinding;
import com.example.qlct.databinding.ActivityProfileDetailBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileDetailActivity extends AppCompatActivity {
    ActivityProfileDetailBinding binding;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initView();
        setEnabled(false);
        showUserInformation();
    }
    private void initView(){
        auth = FirebaseAuth.getInstance();
        binding.btnDangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                finish();
                startActivity(new Intent(ProfileDetailActivity.this, MainActivity.class));
            }
        });
        binding.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setEnabled(true);
                binding.llSave.setVisibility(View.VISIBLE);
            }
        });
        binding.btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        binding.btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.llSave.setVisibility(View.GONE);
                setEnabled(false);
            }
        });
        binding.btnCloseQLTK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void showUserInformation()
    {
        FirebaseUser user = auth.getCurrentUser();
        if(user == null)
        {
            return;
        }
        String name = user.getDisplayName();
        String email = user.getEmail();
        Uri photoUrl = user.getPhotoUrl();
        binding.edtEmail.setText(email);
        binding.edtName.setText(name);
        if(photoUrl != null) {
            Glide.with(this).load(photoUrl).into(binding.imgAvt);
        }

    }
    private void setEnabled(boolean yes) {
        binding.edtEmail.setEnabled(yes);
        binding.edtName.setEnabled(yes);
        binding.imgAvt.setEnabled(yes);
    }
}