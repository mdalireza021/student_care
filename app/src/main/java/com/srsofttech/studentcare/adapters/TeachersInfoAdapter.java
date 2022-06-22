package com.srsofttech.studentcare.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.srsofttech.studentcare.R;
import com.srsofttech.studentcare.model.TeachersInfoModel;

import java.util.ArrayList;

public class TeachersInfoAdapter extends RecyclerView.Adapter<TeachersInfoAdapter.ViewHolder> {

    private Context context;
    private ArrayList<TeachersInfoModel> data;


    public TeachersInfoAdapter(Context context, ArrayList<TeachersInfoModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_teachers_info,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tv_name.setText(data.get(position).getName());
        holder.tv_designation.setText(data.get(position).getDesignation());
        holder.tv_teaching_ar.setText(data.get(position).getTeaching_area());
        holder.tv_email.setText(data.get(position).getEmail());
        holder.tv_phone.setText(data.get(position).getPhone());
        //holder.tv_name.setText(data.get(position).getFullname());


    }

    @Override
    public int getItemCount() {

        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name,tv_designation,tv_teaching_ar,tv_email,tv_phone;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name=itemView.findViewById(R.id.id_teachers_info_name);
            tv_designation=itemView.findViewById(R.id.id_teachers_info_designation);
            tv_teaching_ar=itemView.findViewById(R.id.id_teachers_info_teaching_area);
            tv_email=itemView.findViewById(R.id.id_teachers_info_email);
            tv_phone=itemView.findViewById(R.id.id_teachers_info_phone);
        }
    }
}


