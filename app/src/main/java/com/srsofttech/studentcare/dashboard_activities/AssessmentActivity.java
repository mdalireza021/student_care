package com.srsofttech.studentcare.dashboard_activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.srsofttech.studentcare.MainActivity;
import com.srsofttech.studentcare.R;
import com.srsofttech.studentcare.assessment_activity.OnlineExamActivity;

public class AssessmentActivity extends AppCompatActivity implements View.OnClickListener{

    CardView home_task, library, online_exam;
    ImageView backPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        home_task = findViewById(R.id.id_home_task);
        home_task.setOnClickListener(this);
        library = findViewById(R.id.id_library);
        library.setOnClickListener(this);
        online_exam = findViewById(R.id.id_online_exam);
        online_exam.setOnClickListener(this);

        backPage = findViewById(R.id.backPageId);
        backPage.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.id_home_task){
            Intent it = new Intent(AssessmentActivity.this, HomeTaskActivity.class);
            startActivity(it);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }

        if(view.getId()==R.id.id_library){
            Intent it = new Intent(AssessmentActivity.this, LibraryActivity.class);
            startActivity(it);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }

        if(view.getId()==R.id.id_online_exam){
            Intent it = new Intent(AssessmentActivity.this, OnlineExamActivity.class);
            startActivity(it);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }

        if(view.getId()==R.id.backPageId){
            finish();
            Intent intent = new Intent(AssessmentActivity.this, MainActivity.class);
            intent.putExtra("EXTRA", "openHomeFragment");
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    }

    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(AssessmentActivity.this, MainActivity.class);
        intent.putExtra("EXTRA", "openHomeFragment");
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

        super.onBackPressed();
    }
}