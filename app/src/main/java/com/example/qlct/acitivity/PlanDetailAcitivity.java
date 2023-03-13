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
import com.example.qlct.model.Plan;

import java.util.Calendar;

public class PlanDetailAcitivity extends AppCompatActivity {
    private Plan mPlan;
    private EditText edtTenKeHoach, edtHanMuc, edtGhiChu;
    private TextView txtNgayBatDau, txtNgayKetThuc;
    private ImageButton btnEdit, btnCloseDetail;
    private AppCompatButton btnCancel, btnOK;
    private LinearLayout ll_button;
    private Calendar c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_detail_acitivity);
        mPlan = (Plan) getIntent().getSerializableExtra("item");
        initView();
    }

    private void initView() {
        edtTenKeHoach = findViewById(R.id.edtTenKeHoach);
        edtHanMuc = findViewById(R.id.edtHanMuc);
        edtGhiChu = findViewById(R.id.edtGhiChu);
        txtNgayBatDau = findViewById(R.id.txtNgayBatDau);
        txtNgayKetThuc = findViewById(R.id.txtNgayKetThuc);
        btnEdit = findViewById(R.id.btnEdit);
        btnCancel = findViewById(R.id.btnCancel);
        btnOK = findViewById(R.id.btnOK);
        btnCloseDetail = findViewById(R.id.btnCloseDetail);
        ll_button = findViewById(R.id.ll_button);
        edtTenKeHoach.setText(mPlan.getTenKeHoach());
        edtHanMuc.setText(String.valueOf(mPlan.getHanMuc()));
        edtGhiChu.setText(mPlan.getGhiChu());
        txtNgayBatDau.setText(mPlan.getThoiGianBatDau());
        txtNgayKetThuc.setText(mPlan.getThoiGianKetThuc());
        setUneditableItem();
        btnCloseDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setEditableItem();
                edtTenKeHoach.setFocusable(true);
                ll_button.setVisibility(View.VISIBLE);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUneditableItem();
                ll_button.setVisibility(View.GONE);
            }
        });
    }

    private void setEditableItem() {
        edtTenKeHoach.setEnabled(true);
        edtHanMuc.setEnabled(true);
        edtGhiChu.setEnabled(true);

        txtNgayBatDau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                DatePickerDialog bdDialog = new DatePickerDialog(PlanDetailAcitivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        txtNgayBatDau.setText(String.valueOf(dayOfMonth) + "/" + String.valueOf(month) + "/" + String.valueOf(year));
                    }
                }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
                bdDialog.show();
            }
        });
        txtNgayKetThuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                DatePickerDialog ktDialog = new DatePickerDialog(PlanDetailAcitivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        txtNgayKetThuc.setText(String.valueOf(dayOfMonth) + "/" + String.valueOf(month) + "/" + String.valueOf(year));
                    }
                }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
                ktDialog.show();
            }
        });
    }

    private void setUneditableItem() {
        edtTenKeHoach.setEnabled(false);
        edtHanMuc.setEnabled(false);
        edtGhiChu.setEnabled(false);
        txtNgayBatDau.setClickable(false);
        txtNgayKetThuc.setClickable(false);
    }
}