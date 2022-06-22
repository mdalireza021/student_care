package com.srsofttech.studentcare.dashboard_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.srsofttech.studentcare.MainActivity;
import com.srsofttech.studentcare.R;
import com.srsofttech.studentcare.show_result.ShowResultActivity;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView backPage;
    Button show_res;
    String id,sem;
    MaterialAutoCompleteTextView student_id,semester;

    private static final  String[]  semester_data=new String[] {"Fall 2021","Summer 2021","Spring 2021","Fall 2020","Summer 2020","Spring 2020"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        backPage = findViewById(R.id.backPageId);
        show_res=findViewById(R.id.id_show_result);
        backPage.setOnClickListener(this);
        show_res.setOnClickListener(this);

        student_id=findViewById(R.id.id_student_id);
        semester=findViewById(R.id.id_select_semester);

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,semester_data);
        semester.setAdapter(arrayAdapter);


    }

    @Override
    public void onClick(View view) {

            if(view.getId()==R.id.backPageId){
                finish();
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                intent.putExtra("EXTRA", "openHomeFragment");
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

            }
            if(view.getId()==R.id.id_show_result)
            {
                //finish();
                Intent intent = new Intent(ResultActivity.this, ShowResultActivity.class);
                id=student_id.getText().toString();
                sem=semester.getText().toString().toLowerCase();
                intent.putExtra("key_id", id);
                intent.putExtra("key_semester",sem);
                startActivity(intent);

            }
    }

        @Override
        public void onBackPressed() {
            finish();
            Intent intent = new Intent(ResultActivity.this, MainActivity.class);
            intent.putExtra("EXTRA", "openHomeFragment");
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

            super.onBackPressed();
        }

}

