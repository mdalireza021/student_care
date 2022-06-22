package com.srsofttech.studentcare.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.srsofttech.studentcare.R;
import com.srsofttech.studentcare.model.ShowResultModel;

import java.util.ArrayList;

public class ShowResultAdapter extends RecyclerView.Adapter<ShowResultAdapter.ViewHolder> {

    private Context context;
    private ArrayList<ShowResultModel> data;

    public ShowResultAdapter(Context context, ArrayList<ShowResultModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_show_result,parent,false);

        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tv_subject.setText(data.get(position).getSubject());
        holder.tv_highest_marks.setText(data.get(position).getHighest_marks()+" ");
        holder.tv_obtain_marks.setText(data.get(position).getObtain_marks()+" ");
        holder.tv_full_marks.setText(data.get(position).getFull_marks()+" ");
        holder.tv_comment.setText(data.get(position).getComment());



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{

        TextView tv_subject,tv_full_marks,tv_obtain_marks,tv_highest_marks,tv_comment;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_subject=itemView.findViewById(R.id.id_result_subject);
            tv_full_marks=itemView.findViewById(R.id.id_result_full_marks);
            tv_obtain_marks=itemView.findViewById(R.id.id_result_obtain_marks);
            tv_highest_marks=itemView.findViewById(R.id.id_result_highest_mark);
            tv_comment=itemView.findViewById(R.id.id_result_comment);



        }
    }
}
