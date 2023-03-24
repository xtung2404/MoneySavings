package com.example.qlct.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.qlct.R;
import com.example.qlct.adapter.ChiTieuAdapter;
import com.example.qlct.databinding.FragmentHomeBinding;
import com.example.qlct.databinding.FragmentSoChiTieuBinding;
import com.example.qlct.model.ChiTieu;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private ArrayList<ChiTieu> mChiTieus;
    private ChiTieuAdapter ctAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        binding = FragmentHomeBinding.bind(view);
        initView();
        return view;
    }
    private void initView() {
        mChiTieus = new ArrayList<>();
        mChiTieus.add(new ChiTieu(0,2000,1, 1, "22/2/2023", "khong co gi"));
        ctAdapter = new ChiTieuAdapter(getActivity(), mChiTieus);
        binding.rvChiTieu.setAdapter(ctAdapter);
        binding.rvChiTieu.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}