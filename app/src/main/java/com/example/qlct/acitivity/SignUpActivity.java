package com.example.qlct.acitivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.qlct.MainActivity;
import com.example.qlct.R;
import com.example.qlct.databinding.ActivityLogInBinding;
import com.example.qlct.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.ktx.Firebase;

public class SignUpActivity extends AppCompatActivity {
    ActivitySignUpBinding binding;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initView();
    }
    private void initView(){
        auth = FirebaseAuth.getInstance();
        binding.btnDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUp();
            }
        });
        binding.txtDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, LogInActivity.class));
            }
        });
    }

    private void SignUp() {
        String user = binding.edtEmail.getText().toString();
        String pass = binding.edtPassword.getText().toString();
        String pass2 = binding.edtRePassword.getText().toString();
        if(TextUtils.isEmpty(user)){
            Toast.makeText(this, "Email không hợp lệ", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this, "Password không hợp lệ", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass2)){
            Toast.makeText(this, "Password không hợp lệ", Toast.LENGTH_SHORT).show();
            return;
        }
        if(pass.equals(pass2)==false){
            Toast.makeText(this, "mật khẩu nhập không khớp", Toast.LENGTH_SHORT).show();
            return ;
        }
        auth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent =new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(SignUpActivity.this, "dang ki that bai", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}