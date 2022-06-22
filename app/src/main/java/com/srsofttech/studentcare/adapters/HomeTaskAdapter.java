package com.srsofttech.studentcare.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.srsofttech.studentcare.R;
import com.srsofttech.studentcare.model.HomeTaskModel;

import java.util.ArrayList;

public class HomeTaskAdapter extends RecyclerView.Adapter<HomeTaskAdapter.holder> {

    private Context context;
    private ArrayList<HomeTaskModel> data;

    public HomeTaskAdapter(Context context, ArrayList<HomeTaskModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_task,parent,false);

        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, @SuppressLint("RecyclerView") int position) {

        holder.tv_task_name.setText(data.get(position).getTask_name());
        holder.tv_created.setText(data.get(position).getCreated_date());
        holder.tv_submission.setText(data.get(position).getSubmission_date());
        holder.tv_evaluation.setText(data.get(position).getEvaluated_date());
        holder.tv_status.setText(data.get(position).getStatus());
        if (data.get(position).getStatus()=="Completed")
        {
            holder.tv_status.setBackgroundResource(R.color.green);
        }

        holder.task_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(view.getContext(), "You clicked subject is "+data.get(position).getTask_name(),Toast.LENGTH_SHORT).show();

                //Intent i=new Intent(context, HomeTaskViewActivity.class);
                //context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class holder extends RecyclerView.ViewHolder{

        TextView tv_task_name,tv_created,tv_submission,tv_evaluation,tv_status;
        TextView task_view;

        public holder(@NonNull View itemView) {

            super(itemView);
            tv_task_name=itemView.findViewById(R.id.id_home_task_name);
            tv_created=itemView.findViewById(R.id.id_created_date);
            tv_submission=itemView.findViewById(R.id.id_submission_date);
            tv_evaluation=itemView.findViewById(R.id.id_evaluation_date);
            tv_status=itemView.findViewById(R.id.id_status_text);

            task_view=itemView.findViewById(R.id.id_task_view);


        }
    }
}
