package com.example.qlct.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.qlct.R;
import com.example.qlct.acitivity.AddPlanActivity;
import com.example.qlct.acitivity.PlanDetailAcitivity;
import com.example.qlct.adapter.OnClickListener;
import com.example.qlct.adapter.PlanAdapter;
import com.example.qlct.model.Plan;
import com.google.android.material.tabs.TabLayout;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;


public class PlanFragment extends Fragment {
    private View mView;
    private TabLayout mTabLayout;
    private RecyclerView rvKeHoach;
    private PlanAdapter mPlanAdapter;
    private ArrayList<Plan> mFinishedPlans, mUnfinishedPlans;
    private ImageButton btnAddPlan;
    private OnClickListener mOnClickListener = new OnClickListener() {
        @Override
        public void onClickListener(int position) {
            Intent intent = new Intent(getActivity(), PlanDetailAcitivity.class);
            intent.putExtra("item", mFinishedPlans.get(position));
            startActivity(intent);
        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_plan, container, false);
        initView();
        return mView;
    }
    private void initView() {
        rvKeHoach = mView.findViewById(R.id.rvKeHoach);
        mTabLayout = mView.findViewById(R.id.tab_layout);
        btnAddPlan = mView.findViewById(R.id.btnAddPlan);
        mTabLayout.addTab(mTabLayout.newTab().setText("Chưa hoàn thành"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Đã hoàn thành"));
        mFinishedPlans = new ArrayList<>();
        mUnfinishedPlans = new ArrayList<>();
        Plan mPlan = new Plan("0", "8/3", 2000, "22/2/2022", "22/2/2023", "0", false);
        Plan mPlan1 = new Plan("1", "20/10", 2000, "22/2/2022", "22/2/2023", "0", false);
        Plan mPlan2 = new Plan("2", "Sinh nhật", 2000, "22/2/2022", "22/2/2023", "0", false);
        mFinishedPlans.add(mPlan);
        mFinishedPlans.add(mPlan1);
        mFinishedPlans.add(mPlan2);
        mUnfinishedPlans.add(mPlan);
        mUnfinishedPlans.add(mPlan1);


        btnAddPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddPlanActivity.class);
                startActivity(intent);
            }
        });

        mPlanAdapter = new PlanAdapter(getContext(), mUnfinishedPlans, mOnClickListener);
        rvKeHoach.setAdapter(mPlanAdapter);
        rvKeHoach.setLayoutManager(new LinearLayoutManager(getContext()));

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getText() == "Chưa hoàn thành") {
                    mPlanAdapter.setListPlan(mUnfinishedPlans);
                }
                else {
                    mPlanAdapter.setListPlan(mFinishedPlans);
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
}