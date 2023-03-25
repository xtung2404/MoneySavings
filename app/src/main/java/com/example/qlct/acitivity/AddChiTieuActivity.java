package com.example.qlct.acitivity;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.qlct.R;
import com.example.qlct.databinding.ActivityAddChiTieuBinding;

public class AddChiTieuActivity extends AppCompatActivity {
    ActivityAddChiTieuBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddChiTieuBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initView();
        initData();
    }
    private void initView(){
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void initData(){
        ArrayAdapter<CharSequence> cdAdapter = ArrayAdapter.createFromResource(this, R.array.listCheDo, android.R.layout.simple_spinner_dropdown_item);
        binding.spnCheDo.setAdapter(cdAdapter);
        ArrayAdapter<CharSequence> loaiCTAdapter = ArrayAdapter.createFromResource(this, R.array.listLoaiCT, android.R.layout.simple_spinner_dropdown_item);
        binding.spnLoaiChiTieu.setAdapter(loaiCTAdapter);
    }
}