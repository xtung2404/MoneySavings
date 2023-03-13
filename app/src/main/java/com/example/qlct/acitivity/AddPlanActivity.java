package com.example.qlct.acitivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.qlct.R;

import java.util.Calendar;

public class AddPlanActivity extends AppCompatActivity {
    private ImageButton btnCloseAddPlan;
    private TextView txtChonNgayBatDau, txtChonNgayKetThuc;
    private Calendar c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plan);
        initView();
    }
    private void initView() {
        btnCloseAddPlan = findViewById(R.id.btnCloseAddPlan);
        txtChonNgayBatDau = findViewById(R.id.txtChonNgayBatDau);
        txtChonNgayKetThuc = findViewById(R.id.txtChonNgayKetThuc);

        btnCloseAddPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        txtChonNgayBatDau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                DatePickerDialog bdDialog = new DatePickerDialog(AddPlanActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        txtChonNgayBatDau.setText(String.valueOf(dayOfMonth) + "/" + String.valueOf(month) + "/" + String.valueOf(year));
                    }
                }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
                bdDialog.show();
            }
        });

        txtChonNgayKetThuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtChonNgayKetThuc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        c = Calendar.getInstance();
                        DatePickerDialog ktDialog = new DatePickerDialog(AddPlanActivity.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                txtChonNgayKetThuc.setText(String.valueOf(dayOfMonth) + "/" + String.valueOf(month) + "/" + String.valueOf(year));
                            }
                        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
                        ktDialog.show();
                    }
                });
            }
        });
    }
}