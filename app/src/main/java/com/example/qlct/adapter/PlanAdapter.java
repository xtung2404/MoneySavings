package com.example.qlct.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qlct.R;
import com.example.qlct.model.Plan;

import java.util.ArrayList;

public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.PlanViewHolder>{
    private Context context;
    private ArrayList<Plan> mPlans;
    private LayoutInflater layoutInflater;
    private OnClickListener mOnClickListener;
    public PlanAdapter(Context context, ArrayList<Plan> mPlans, OnClickListener mOnClickListener) {
        this.context = context;
        this.mPlans = mPlans;
        this.mOnClickListener = mOnClickListener;
        layoutInflater = LayoutInflater.from(context);
    }

    public void setListPlan(ArrayList<Plan> plans) {
        mPlans = plans;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PlanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.plan_item, parent, false);
        return new PlanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanViewHolder holder, int position) {
        Plan mPlan = mPlans.get(position);
        holder.txtPlanName.setText(mPlan.getTenKeHoach());
        holder.txtPlanMoney.setText(String.valueOf(mPlan.getHanMuc()));
    }

    @Override
    public int getItemCount() {
        if(mPlans.size() != 0) return mPlans.size();
        return 0;
    }

    public class PlanViewHolder extends RecyclerView.ViewHolder{
        private TextView txtPlanName, txtPlanMoney, txtPlanDateEnd;
        public PlanViewHolder(@NonNull View itemView) {
            super(itemView);
            txtPlanName = itemView.findViewById(R.id.txtPlanName);
            txtPlanMoney = itemView.findViewById(R.id.txtPlanMoney);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnClickListener.onClickListener(getAdapterPosition());
                }
            });
        }
    }
}
