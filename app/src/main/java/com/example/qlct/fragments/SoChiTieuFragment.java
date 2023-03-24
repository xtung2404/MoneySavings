package com.example.qlct.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.qlct.R;
import com.example.qlct.adapter.ViewStateAdapter;
import com.example.qlct.databinding.FragmentSoChiTieuBinding;
import com.example.qlct.databinding.FragmentSoChiTieuViewBinding;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Calendar;

public class SoChiTieuFragment extends Fragment {
    FragmentSoChiTieuBinding binding;
    ArrayList<String> listVi = new ArrayList<>();
    Calendar c;
    Bundle bundle;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_so_chi_tieu, container, false);
        binding = FragmentSoChiTieuBinding.bind(view);
        initView();
        return view;
    }
    private void initView(){
        binding.tablayoutCT.addTab(binding.tablayoutCT.newTab().setText("Tháng trước"));
        binding.tablayoutCT.addTab(binding.tablayoutCT.newTab().setText("Hiện tại"));
        binding.tablayoutCT.addTab(binding.tablayoutCT.newTab().setText("Tương lai"));
        c = Calendar.getInstance();
        replaceFragment(new SoChiTieuViewFragment(), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
        listVi.add("Tiền mặt");
        listVi.add("Ngân hàng");
        ArrayAdapter<String> viAdapter = new ArrayAdapter<>(getContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listVi);
        binding.tablayoutCT.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                bundle = new Bundle();
                if(tab.getText() == "Tháng trước") {
                    c = Calendar.getInstance();
                    int month = c.get(Calendar.MONTH);
                    int year = c.get(Calendar.YEAR);
                    if (month == 1) {
                        month = 12;
                        year--;
                    } else {
                        month = month - 1;
                    }
                    replaceFragment(new SoChiTieuViewFragment(),month,year);
                } else if(tab.getText() == "Hiện tại") {
                        c = Calendar.getInstance();
                        replaceFragment(new SoChiTieuViewFragment(), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
                } else {
                    c = Calendar.getInstance();
                    replaceFragment(new SoChiTieuViewFragment(), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    private void replaceFragment(Fragment fragment, int month, int year) {
        bundle = new Bundle();
        bundle.putInt("month", month);
        bundle.putInt("year", year);
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayoutCT, fragment);
        fragmentTransaction.commit();
    }
}