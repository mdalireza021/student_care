package com.srsofttech.studentcare.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.srsofttech.studentcare.R;

public class SemesterSpinnerAdapter extends BaseAdapter {

    String program[];
    Context context;
    LayoutInflater layoutInflater;

    public SemesterSpinnerAdapter(Context context, String[] program){
        this.context = context;
        this.program = program;
    }

    @Override
    public int getCount() {
        return program.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View SpinnerView, ViewGroup parent) {
        if(SpinnerView==null){
            layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            SpinnerView = layoutInflater.inflate(R.layout.semester_spinner_adapter, parent, false);
        }

        TextView divisionTextView = SpinnerView.findViewById(R.id.programTextViewId);
        divisionTextView.setText(program[position]);

        return SpinnerView;
    }
}
