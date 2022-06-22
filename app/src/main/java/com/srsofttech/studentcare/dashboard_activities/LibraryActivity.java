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
import com.srsofttech.studentcare.show_library.ShowLibraryActivity;

public class LibraryActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView backPage;
    CardView card_class1_bn,card_class1_eng,card_class1_gk,card_class1_math,card_class2_bn,card_class2_eng,card_class2_math,card_class3_bn,card_class3_eng,card_class3_math;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        backPage = findViewById(R.id.backPageId);
        backPage.setOnClickListener(this);
        card_class1_bn=findViewById(R.id.id_class1_bangla);
        card_class1_eng=findViewById(R.id.id_class1_english);
        card_class1_math=findViewById(R.id.id_class1_math);
        card_class2_bn=findViewById(R.id.id_class2_bangla);
        card_class2_eng=findViewById(R.id.id_class2_english);
        card_class2_math=findViewById(R.id.id_class2_math);
        card_class1_eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), ShowLibraryActivity.class));
            }
        });

    }
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.backPageId){
            finish();
            Intent intent = new Intent(LibraryActivity.this, MainActivity.class);
            intent.putExtra("EXTRA", "openHomeFragment");
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

        }
    }
    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(LibraryActivity.this, MainActivity.class);
        intent.putExtra("EXTRA", "openHomeFragment");
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

        super.onBackPressed();
    }
}