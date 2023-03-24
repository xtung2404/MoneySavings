package com.example.qlct.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.qlct.R;
import com.example.qlct.adapter.ChiTieuAdapter;
import com.example.qlct.databinding.FragmentSoChiTieuViewBinding;
import com.example.qlct.model.ChiTieu;

import java.util.ArrayList;
import java.util.List;

public class SoChiTieuViewFragment extends Fragment {
    FragmentSoChiTieuViewBinding binding;
    private ArrayList<ChiTieu> soChiTieus = new ArrayList<>();
    int month = 0;
    int year = 0;
    private ChiTieuAdapter ctAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_so_chi_tieu_view, container, false);
        binding = FragmentSoChiTieuViewBinding.bind(view);
        initData();
        initView();
        return view;
    }
    private void initView(){
        soChiTieus.add(new ChiTieu(0,2000,1, 1, "22/2/2023", "khong co gi"));
        ctAdapter = new ChiTieuAdapter(getActivity(), soChiTieus);
        binding.rcvSoGiaoDich.setAdapter(ctAdapter);
        binding.rcvSoGiaoDich.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
    private void initData() {
        Bundle bundle = this.getArguments();
        month = bundle.getInt("month");
        year = bundle.getInt("year");
        Toast.makeText(getActivity(), String.valueOf(month), Toast.LENGTH_SHORT).show();
    }

}