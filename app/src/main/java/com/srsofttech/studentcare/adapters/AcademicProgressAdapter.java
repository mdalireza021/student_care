package com.srsofttech.studentcare.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.srsofttech.studentcare.R;
import com.srsofttech.studentcare.model.AcademicProgressModel;

import java.util.ArrayList;

public class AcademicProgressAdapter extends RecyclerView.Adapter<AcademicProgressAdapter.ViewHolder> {

    private Context context;
    private ArrayList<AcademicProgressModel>  data;

    public AcademicProgressAdapter(Context context, ArrayList<AcademicProgressModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_progress,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tv_progress_name.setText(data.get(position).getTeacher_name());
        holder.tv_progress_designation.setText(data.get(position).getDesignation());
        holder.tv_progress_sub.setText(data.get(position).getSubject());
        holder.tv_progress_date.setText(data.get(position).getDate());
        holder.tv_progress_comment.setText(data.get(position).getComment());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{

        TextView tv_progress_name,tv_progress_designation,tv_progress_sub,tv_progress_date,tv_progress_comment;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_progress_name=itemView.findViewById(R.id.id_progress_name);
            tv_progress_designation=itemView.findViewById(R.id.id_progress_designation);
            tv_progress_sub=itemView.findViewById(R.id.id_progress_subject);
            tv_progress_date=itemView.findViewById(R.id.id_progress_date);
            tv_progress_comment=itemView.findViewById(R.id.id_progress_comment);


        }
    }
}
