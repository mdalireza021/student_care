package com.srsofttech.studentcare.assessment_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.srsofttech.studentcare.R;
import com.srsofttech.studentcare.dashboard_activities.AssessmentActivity;


public class OnlineExamActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView backPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_exam);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        backPage = findViewById(R.id.backPageId);
        backPage.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.backPageId){
            finish();
            Intent intent = new Intent(OnlineExamActivity.this, AssessmentActivity.class);
            intent.putExtra("EXTRA", "openHomeFragment");
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

        }
    }
    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(OnlineExamActivity.this, AssessmentActivity.class);
        intent.putExtra("EXTRA", "openHomeFragment");
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

        super.onBackPressed();
    }
}