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

import com.example.qlct.R;
import com.example.qlct.acitivity.AddPlanActivity;
import com.example.qlct.acitivity.PlanDetailAcitivity;
import com.example.qlct.adapter.OnClickListener;
import com.example.qlct.adapter.PlanAdapter;
import com.example.qlct.model.Plan;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;


public class PlanFragment extends Fragment {
    private View mView;
    private RecyclerView rvKeHoach;
    private PlanAdapter mPlanAdapter;
    private ArrayList<Plan> mPlans;
    private AppCompatButton btnAddPlan;
    private OnClickListener mOnClickListener = new OnClickListener() {
        @Override
        public void onClickListener(int position) {
            Intent intent = new Intent(getActivity(), PlanDetailAcitivity.class);
            intent.putExtra("item", mPlans.get(position));
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
        rvKeHoach = mView.findViewById(R.id.rv_KeHoach);
        btnAddPlan = mView.findViewById(R.id.btnAddPlan);
        mPlans = new ArrayList<>();
        Plan mPlan = new Plan("0", "8/3", 2000, "22/2/2022", "22/2/2023", "0", false);
        Plan mPlan1 = new Plan("1", "20/10", 2000, "22/2/2022", "22/2/2023", "0", false);
        Plan mPlan2 = new Plan("2", "Sinh nhật", 2000, "22/2/2022", "22/2/2023", "0", false);
        mPlans.add(mPlan);
        mPlans.add(mPlan1);
        mPlans.add(mPlan2);
        mPlanAdapter = new PlanAdapter(getContext(), mPlans, mOnClickListener);
        rvKeHoach.setAdapter(mPlanAdapter);
        rvKeHoach.setLayoutManager(new LinearLayoutManager(getContext()));

        btnAddPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddPlanActivity.class);
                startActivity(intent);
            }
        });
    }
}