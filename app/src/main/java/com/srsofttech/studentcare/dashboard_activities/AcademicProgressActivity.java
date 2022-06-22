package com.srsofttech.studentcare.dashboard_activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;


import com.srsofttech.studentcare.MainActivity;
import com.srsofttech.studentcare.R;

import com.srsofttech.studentcare.adapters.AcademicProgressAdapter;
import com.srsofttech.studentcare.model.AcademicProgressModel;

import java.util.ArrayList;

public class AcademicProgressActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView back_page;
    private RecyclerView recyclerView;
    private AcademicProgressAdapter academicProgressAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_progress);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        back_page=findViewById(R.id.id_back_page);
        back_page.setOnClickListener(this);

        recyclerView=findViewById(R.id.id_progress_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        academicProgressAdapter=new AcademicProgressAdapter(this,List());
        recyclerView.setAdapter(academicProgressAdapter);

    }

    private ArrayList<AcademicProgressModel> List() {
        ArrayList<AcademicProgressModel> arrayList=new ArrayList<>();
        arrayList.add(new AcademicProgressModel("Md. Abdus Shukur","Assistant Teacher","Bangla","02/01/2022","Very good / satisfactory."));
        arrayList.add(new AcademicProgressModel("Mrs. Arpita Chowdhury","Assistant Teacher","English","02/01/2022","Please Take Special Care of HandWriting."));
        arrayList.add(new AcademicProgressModel("Mors. Shefali Khatun","Senior Teacher","Mathematics","03/01/2022","Very weak in Maths"));
        arrayList.add(new AcademicProgressModel("Md. Mahbubur Rahman","Teacher","General Science","04/01/2022","Requires special care"));
        arrayList.add(new AcademicProgressModel("Mr. Khairul Islam","Teacher","Religion","02/01/2022","Please Take Special Care of HandWriting."));


        return arrayList;

    }

    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.id_back_page){
            finish();
            Intent intent = new Intent(AcademicProgressActivity.this, MainActivity.class);
            intent.putExtra("EXTRA", "openHomeFragment");
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    }
    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(AcademicProgressActivity.this, MainActivity.class);
        intent.putExtra("EXTRA", "openHomeFragment");
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

        super.onBackPressed();
    }
}