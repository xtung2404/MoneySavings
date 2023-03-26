package com.example.qlct.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.qlct.R;
import com.example.qlct.adapter.ChiTieuAdapter;
import com.example.qlct.databinding.FragmentSoChiTieuViewBinding;
import com.example.qlct.model.ChiTieu;
import com.example.qlct.sqlite.ChiTieuSql;
import com.example.qlct.sqlite.ThuNhapSql;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SoChiTieuViewFragment extends Fragment {
    FragmentSoChiTieuViewBinding binding;
    private ArrayList<ChiTieu> soChiTieus = new ArrayList<>();
    int month = 0;
    int year = 0;
    private ChiTieuAdapter ctAdapter;
    ChiTieuSql chiTieuSql;
    ThuNhapSql thuNhapSql;
    FirebaseAuth auth;
    FirebaseUser user;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_so_chi_tieu_view, container, false);
        binding = FragmentSoChiTieuViewBinding.bind(view);
        getData();
        initView();
        initData();
        return view;
    }
    private void initView(){
        chiTieuSql = new ChiTieuSql(getActivity(), ChiTieuSql.TableName,null, 1);
        thuNhapSql = new ThuNhapSql(getActivity(), ThuNhapSql.TableName,null, 1);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
    }
    private void getData() {
        Bundle bundle = this.getArguments();
        month = bundle.getInt("month");
        year = bundle.getInt("year");
        Toast.makeText(getActivity(), String.valueOf(month), Toast.LENGTH_SHORT).show();
    }
    private void initData() {
        try {
            soChiTieus = chiTieuSql.getMonthChiTieu(user.getEmail(), month);
            ctAdapter = new ChiTieuAdapter(getActivity(), soChiTieus);
            binding.rcvSoGiaoDich.setAdapter(ctAdapter);
            binding.rcvSoGiaoDich.setLayoutManager(new LinearLayoutManager(getActivity()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            binding.tvTienVao.setText(String.valueOf(thuNhapSql.getMoneyInMonthTN(user.getEmail(), month)));
        } catch (ParseException e) {
            Log.d("error", e.getLocalizedMessage());
        }
        try {
            binding.tvTienRa.setText(String.valueOf(chiTieuSql.getMoneyInMonthCT(user.getEmail(), month)));
        } catch (ParseException e) {
            Log.d("error", e.getLocalizedMessage());
        }
        try {
            binding.tvTongTien.setText(String.valueOf(thuNhapSql.getMoneyInMonthTN(user.getEmail(), month) - chiTieuSql.getMoneyInMonthCT(user.getEmail(), month)));
        } catch (ParseException e) {
            Log.d("error", e.getLocalizedMessage());
        }
        try {
            soChiTieus = chiTieuSql.getMonthChiTieu(user.getEmail(), month);
            ctAdapter.notifyDataSetChanged();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        initData();
    }
}