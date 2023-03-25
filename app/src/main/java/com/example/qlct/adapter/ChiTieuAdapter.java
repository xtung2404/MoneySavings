package com.example.qlct.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qlct.R;
import com.example.qlct.model.ChiTieu;

import java.util.ArrayList;

public class ChiTieuAdapter extends RecyclerView.Adapter<ChiTieuAdapter.ChiTieuViewHolder>{
    private Context context;
    private ArrayList<ChiTieu> mChiTieus;
    private LayoutInflater layoutInflater;

    public ChiTieuAdapter(Context context, ArrayList<ChiTieu> mChiTieus) {
        this.context = context;
        this.mChiTieus = mChiTieus;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ChiTieuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.chitieu_item, parent, false);
        return new ChiTieuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChiTieuViewHolder holder, int position) {
        ChiTieu chitieu = mChiTieus.get(position);
        //if(chitieu.getMaLoaiChiTieu() == 1) {
            holder.imgItem.setImageResource(R.drawable.ic_add);
        //}
        holder.txtLoaiCT.setText(String.valueOf(chitieu.getMaLoaiCT()));
        holder.txtNgayCT.setText(String.valueOf(chitieu.getTgCT()));
        holder.txtTienCT.setText(String.valueOf(chitieu.getSoTien()));
    }

    @Override
    public int getItemCount() {
        if(mChiTieus.size() != 0) return mChiTieus.size();
        return 0;
    }

    public class ChiTieuViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgItem;
        private TextView txtLoaiCT, txtNgayCT, txtTienCT;
        public ChiTieuViewHolder(@NonNull View itemView) {
            super(itemView);
            imgItem = itemView.findViewById(R.id.imgItem);
            txtLoaiCT = itemView.findViewById(R.id.txtLoaiCT);
            txtNgayCT = itemView.findViewById(R.id.txtNgayCT);
            txtTienCT = itemView.findViewById(R.id.txtTienCT);
        }
    }
}
