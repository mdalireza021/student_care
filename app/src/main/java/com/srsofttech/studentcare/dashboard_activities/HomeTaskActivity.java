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
import com.srsofttech.studentcare.adapters.HomeTaskAdapter;
import com.srsofttech.studentcare.model.HomeTaskModel;

import java.util.ArrayList;

public class HomeTaskActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView backPage;

    private RecyclerView recyclerView;
    private HomeTaskAdapter homeTaskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_task);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        backPage = findViewById(R.id.backPageId);
        backPage.setOnClickListener(this);
        recyclerView=findViewById(R.id.id_home_task_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        homeTaskAdapter=new HomeTaskAdapter(this,TaskList());
        recyclerView.setAdapter(homeTaskAdapter);

    }


    private ArrayList<HomeTaskModel> TaskList() {

        ArrayList<HomeTaskModel> list=new ArrayList<>();
        HomeTaskModel a =new HomeTaskModel("Mathematics","02.01.2022","03.02.2023","null","Completed");
        list.add(a);
        HomeTaskModel b =new HomeTaskModel("English","01.01.2022","null","null","Incomplete");
        list.add(b);
        HomeTaskModel c =new HomeTaskModel("Bangla","01.01.2022","03.01.2022","null","Completed");
        list.add(c);
        HomeTaskModel d =new HomeTaskModel("General Knowledge","03.01.2022","null","null","Incomplete");
        list.add(d);
        HomeTaskModel e =new HomeTaskModel("General Science","03.01.2022","03.01.2022","03.01.2022","Completed");
        list.add(e);
        HomeTaskModel f =new HomeTaskModel("Religion","02.01.2022","04.01.2022","null","Completed");
        list.add(f);

        return list;
    }




    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.backPageId){
            finish();
            Intent intent = new Intent(HomeTaskActivity.this, MainActivity.class);
            intent.putExtra("EXTRA", "openHomeFragment");
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

        }
    }
    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(HomeTaskActivity.this, MainActivity.class);
        intent.putExtra("EXTRA", "openHomeFragment");
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

        super.onBackPressed();
    }
}