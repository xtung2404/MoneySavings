package com.example.qlct.acitivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.qlct.R;
import com.example.qlct.databinding.ActivityAddChiTieuBinding;
import com.example.qlct.databinding.ActivityPlanDetailAcitivityBinding;
import com.example.qlct.model.KeHoach;

import java.util.Calendar;

public class PlanDetailAcitivity extends AppCompatActivity {
    ActivityPlanDetailAcitivityBinding binding;
    private KeHoach mPlan;
    private Calendar c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlanDetailAcitivityBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        mPlan = (KeHoach) getIntent().getSerializableExtra("item");
        initView();
    }

    private void initView() {
        binding.edtTenKeHoach.setText(mPlan.getTenKeHoach());
        binding.edtHanMuc.setText(String.valueOf(mPlan.getHanMuc()));
        binding.edtGhiChu.setText(mPlan.getGhiChu());
        binding.txtNgayBatDau.setText(mPlan.getThoiGianBatDau().toString());
        binding.txtNgayKetThuc.setText(mPlan.getThoiGianKetThuc().toString());
        setUneditableItem();
        binding.btnCloseDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setEditableItem();
                binding.edtTenKeHoach.setFocusable(true);
                binding.llButton.setVisibility(View.VISIBLE);
            }
        });

        binding.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUneditableItem();
                binding.llButton.setVisibility(View.GONE);
            }
        });
    }

    private void setEditableItem() {
        binding.edtTenKeHoach.setEnabled(true);
        binding.edtHanMuc.setEnabled(true);
        binding.edtGhiChu.setEnabled(true);

        binding.txtNgayBatDau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                DatePickerDialog bdDialog = new DatePickerDialog(PlanDetailAcitivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        binding.txtNgayBatDau.setText(String.valueOf(dayOfMonth) + "/" + String.valueOf(month) + "/" + String.valueOf(year));
                    }
                }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
                bdDialog.show();
            }
        });
        binding.txtNgayKetThuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                DatePickerDialog ktDialog = new DatePickerDialog(PlanDetailAcitivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        binding.txtNgayKetThuc.setText(String.valueOf(dayOfMonth) + "/" + String.valueOf(month) + "/" + String.valueOf(year));
                    }
                }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
                ktDialog.show();
            }
        });
    }

    private void setUneditableItem() {
        binding.edtTenKeHoach.setEnabled(false);
        binding.edtHanMuc.setEnabled(false);
        binding.edtGhiChu.setEnabled(false);
        binding.txtNgayBatDau.setClickable(false);
        binding.txtNgayKetThuc.setClickable(false);
    }
}