package com.srsofttech.studentcare.show_result;

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
import com.srsofttech.studentcare.adapters.ShowResultAdapter;
import com.srsofttech.studentcare.model.ShowResultModel;

import java.util.ArrayList;

public class ShowResultActivity extends AppCompatActivity implements View.OnClickListener{



    ImageView backPage;
    private RecyclerView recyclerView;
    private ShowResultAdapter showResultAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        backPage = findViewById(R.id.backPageId);
        backPage.setOnClickListener(this);
        recyclerView=findViewById(R.id.id_result_show_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        showResultAdapter=new ShowResultAdapter(this,List());
        recyclerView.setAdapter(showResultAdapter);


        //store data from result_activity

        String value1=getIntent().getStringExtra("key_id");
       String value2=getIntent().getStringExtra("key_semester");





    }

    private ArrayList<ShowResultModel> List() {

        ArrayList<ShowResultModel> list=new ArrayList<>();

        list.add(new ShowResultModel("Bangla",100,72,78,"Excellent"));
        list.add(new ShowResultModel("English",100,82,82,"Outstanding"));
        list.add(new ShowResultModel("Mathematics",100,87,90,"Outstanding"));
        list.add(new ShowResultModel("Social Science",100,65,72,"Good"));
        list.add(new ShowResultModel("BGS",100,80,80,"Excellent"));
        list.add(new ShowResultModel("Religion",100,89,93,"Outstanding"));
        return  list;

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.backPageId){
            finish();
            Intent intent = new Intent(ShowResultActivity.this, MainActivity.class);
            intent.putExtra("EXTRA", "openHomeFragment");
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

        }
    }

    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(ShowResultActivity.this, MainActivity.class);
        intent.putExtra("EXTRA", "openHomeFragment");
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

        super.onBackPressed();
    }
}