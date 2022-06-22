package com.srsofttech.studentcare.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.srsofttech.studentcare.R;
import com.srsofttech.studentcare.model.NoticeBoardModel;

import java.util.ArrayList;


public class NoticeBoardAdapter extends RecyclerView.Adapter<NoticeBoardAdapter.ViewHolder> {


    private Context context;
    private ArrayList<NoticeBoardModel> data;

    public NoticeBoardAdapter(Context context, ArrayList<NoticeBoardModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notice_board,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_notice_title.setText(data.get(position).getNotice_title());
        holder.tv_notice_date.setText(data.get(position).getNotice_date());
        holder.tv_notice_des.setText(data.get(position).getNotice_des());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_notice_title,tv_notice_date,tv_notice_des;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_notice_title=itemView.findViewById(R.id.id_notice_title);
            tv_notice_date=itemView.findViewById(R.id.id_notice_date);
            tv_notice_des=itemView.findViewById(R.id.id_notice_des);



        }
    }
}
