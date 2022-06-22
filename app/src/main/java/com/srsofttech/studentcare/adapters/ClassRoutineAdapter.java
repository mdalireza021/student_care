package com.srsofttech.studentcare.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.srsofttech.studentcare.R;
import com.srsofttech.studentcare.model.ClassRoutineModel;

import java.util.ArrayList;

public class ClassRoutineAdapter extends RecyclerView.Adapter<ClassRoutineAdapter.ViewHolder> {

    private Context context;
    private ArrayList<ClassRoutineModel> data;

    public ClassRoutineAdapter(Context context, ArrayList<ClassRoutineModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_class_routine,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tv_class_day.setText(data.get(position).getClass_day());

        holder.tv_time1.setText(data.get(position).getTime1());
        holder.tv_time2.setText(data.get(position).getTime2());
        holder.tv_time3.setText(data.get(position).getTime3());
        holder.tv_time4.setText(data.get(position).getTime4());
        holder.tv_time5.setText(data.get(position).getTime5());


        holder.tv_sub1.setText(data.get(position).getSub1());
        holder.tv_sub2.setText(data.get(position).getSub2());
        holder.tv_sub3.setText(data.get(position).getSub3());
        holder.tv_sub4.setText(data.get(position).getSub4());
        holder.tv_sub5.setText(data.get(position).getSub5());

        holder.tv_room1.setText(data.get(position).getRoom1());
        holder.tv_room2.setText(data.get(position).getRoom2());
        holder.tv_room3.setText(data.get(position).getRoom3());
        holder.tv_room4.setText(data.get(position).getRoom4());
        holder.tv_room5.setText(data.get(position).getRoom5());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_class_day,tv_time1,tv_time2,tv_time3,tv_time4,tv_time5,tv_sub1,tv_sub2,tv_sub3,tv_sub4,tv_sub5,tv_room1,tv_room2,tv_room3,tv_room4,tv_room5;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_class_day=itemView.findViewById(R.id.id_class_day);

            tv_time1=itemView.findViewById(R.id.id_routine_time1);
            tv_time2=itemView.findViewById(R.id.id_routine_time2);
            tv_time3=itemView.findViewById(R.id.id_routine_time3);
            tv_time4=itemView.findViewById(R.id.id_routine_time4);
            tv_time5=itemView.findViewById(R.id.id_routine_time5);

            tv_sub1=itemView.findViewById(R.id.id_routine_sub1);
            tv_sub2=itemView.findViewById(R.id.id_routine_sub2);
            tv_sub3=itemView.findViewById(R.id.id_routine_sub3);
            tv_sub4=itemView.findViewById(R.id.id_routine_sub4);
            tv_sub5=itemView.findViewById(R.id.id_routine_sub5);

            tv_room1=itemView.findViewById(R.id.id_routine_room1);
            tv_room2=itemView.findViewById(R.id.id_routine_room2);
            tv_room3=itemView.findViewById(R.id.id_routine_room3);
            tv_room4=itemView.findViewById(R.id.id_routine_room4);
            tv_room5=itemView.findViewById(R.id.id_routine_room5);


        }
    }
}
