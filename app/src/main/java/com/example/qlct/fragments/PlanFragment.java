package com.example.qlct.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
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
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
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
    private PieChart pieChart;
    private PieData pieData;
    private PieDataSet pieDataSet;
    private ArrayList pieEntriesArrayList;
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
        pieChart = mView.findViewById(R.id.planChart);
        getPieEntries();
        pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);

        // setting text size
        pieDataSet.setValueTextSize(16f);
        pieChart.getDescription().setEnabled(false);
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
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                mFinishedPlans.remove(position);
                mPlanAdapter.setListPlan(mFinishedPlans);
            }
        });
        itemTouchHelper.attachToRecyclerView(rvKeHoach);

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

    private void getPieEntries() {
        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();
        float[] yData = { 15, 35 };
        String[] xData = { "Chưa hoàn thành", "Hofàn thành"};

        for (int i = 0; i < yData.length;i++){
            yEntrys.add(new PieEntry(yData[i],i));
        }
        for (int i = 0; i < xData.length;i++){
            xEntrys.add(xData[i]);
        }
        pieDataSet=new PieDataSet(yEntrys,"Pie");
    }
}