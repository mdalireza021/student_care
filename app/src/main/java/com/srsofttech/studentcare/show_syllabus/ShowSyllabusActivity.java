package com.srsofttech.studentcare.show_syllabus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.srsofttech.studentcare.MainActivity;
import com.srsofttech.studentcare.R;


public class ShowSyllabusActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView backPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_syllabus);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        backPage = findViewById(R.id.backPageId);
        backPage.setOnClickListener(this);

        //store data from result_activity
        String value1=getIntent().getStringExtra("key_id");
        String value2=getIntent().getStringExtra("key_class");


    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.backPageId){
            finish();
            Intent intent = new Intent(ShowSyllabusActivity.this, MainActivity.class);
            intent.putExtra("EXTRA", "openHomeFragment");
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    }


    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(ShowSyllabusActivity.this, MainActivity.class);
        intent.putExtra("EXTRA", "openHomeFragment");
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        super.onBackPressed();
    }
}