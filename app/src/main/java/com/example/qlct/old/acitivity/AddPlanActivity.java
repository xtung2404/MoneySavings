package com.example.qlct.old.acitivity;

import androidx.appcompat.app.AppCompatActivity;

public class AddPlanActivity extends AppCompatActivity {
//    ActivityAddPlanBinding binding;
//    private Calendar c;
//    Date dateBatDau;
//    Date dateKetThuc;
//    KeHoachSql keHoachSql;
//    FirebaseAuth auth;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = ActivityAddPlanBinding.inflate(getLayoutInflater());
//        View view = binding.getRoot();
//        setContentView(view);
//        initView();
//    }
//    private void initView() {
//        keHoachSql = new KeHoachSql(this, KeHoachSql.TableName, null, 1);
//        auth = FirebaseAuth.getInstance();
//        FirebaseUser user = auth.getCurrentUser();
//        binding.btnCloseAddPlan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
//
//        binding.txtChonNgayBatDau.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                c = Calendar.getInstance();
//                DatePickerDialog bdDialog = new DatePickerDialog(AddPlanActivity.this, new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                        dateBatDau = new Date(year, month, dayOfMonth);
//                        binding.txtChonNgayBatDau.setText(String.valueOf(dayOfMonth) + "/" + String.valueOf(month) + "/" + String.valueOf(year));
//                    }
//                }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
//                bdDialog.show();
//            }
//        });
//
//        binding.txtChonNgayKetThuc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                binding.txtChonNgayKetThuc.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        c = Calendar.getInstance();
//                        DatePickerDialog ktDialog = new DatePickerDialog(AddPlanActivity.this, new DatePickerDialog.OnDateSetListener() {
//                            @Override
//                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                                dateKetThuc = new Date(year, month, dayOfMonth);
//                                binding.txtChonNgayKetThuc.setText(String.valueOf(dayOfMonth) + "/" + String.valueOf(month) + "/" + String.valueOf(year));
//                            }
//                        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
//                        ktDialog.show();
//                    }
//                });
//            }
//        });
//        binding.btnAddPlan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(isValidated()) {
//                    String tenKH = binding.edtTenKeHoach.getText().toString().trim();
//                    Double hanMuc = Double.parseDouble(binding.edtHanMuc.getText().toString().trim());
//                    String GhiChu = binding.edtGhiChu.getText().toString().trim();
//                    keHoachSql.addKeHoach(new KeHoach(0, tenKH, dateBatDau, dateKetThuc, hanMuc, GhiChu, user.getEmail(), 0));
//                    Toast.makeText(AddPlanActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
//                    finish();
//                } else {
//                    Toast.makeText(AddPlanActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
//    private boolean isValidated() {
//        if(TextUtils.isEmpty(binding.edtTenKeHoach.getText().toString().trim())) {
//            Toast.makeText(this, "Nhập tên kế hoạch", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//        if(TextUtils.isEmpty(binding.edtGhiChu.getText().toString().trim())) {
//            Toast.makeText(this, "Nhập ghi chú", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//        if(TextUtils.isEmpty(binding.edtHanMuc.getText().toString().trim())) {
//            Toast.makeText(this, "Nhập hạn mức", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//        if(TextUtils.isEmpty(binding.txtChonNgayBatDau.getText().toString().trim())) {
//            Toast.makeText(this, "Chọn ngày", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//        if(TextUtils.isEmpty(binding.txtChonNgayKetThuc.getText().toString().trim())) {
//            Toast.makeText(this, "Chọn ngày", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//        return true;
//    }
}