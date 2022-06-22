package com.srsofttech.studentcare.dashboard_activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.srsofttech.studentcare.MainActivity;
import com.srsofttech.studentcare.R;
import com.srsofttech.studentcare.adapters.ClassRoutineAdapter;
import com.srsofttech.studentcare.model.ClassRoutineModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ClassRoutineActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView backPage;
    private RecyclerView recyclerView;
    private ClassRoutineAdapter classRoutineAdapter;
    private  ArrayList<ClassRoutineModel> routine=new ArrayList<>();
    //private String url="https://raw.githubusercontent.com/rahmanreza646/routinejson/main/file.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_routine);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        backPage = findViewById(R.id.backPageId);
        backPage.setOnClickListener(this);
        recyclerView=findViewById(R.id.id_class_routine_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        routine.add(new ClassRoutineModel("Sunday","9.00-10.30","10.30-12.00","12.00-1.30","2.30-4.00","4.00-5.00","Bangla","English","Math","Social s","ICT","113","113","113","113","113"));
        routine.add(new ClassRoutineModel("Monday","9.00-10.30","10.30-12.00","12.00-1.30","2.30-4.00","4.00-5.00","Bangla","English","Math","Social s","ICT","113","113","113","113","113"));
        routine.add(new ClassRoutineModel("Tuesday","9.00-10.30","10.30-12.00","12.00-1.30","2.30-4.00","4.00-5.00","Bangla","English","Math","Social s","ICT","113","113","113","113","113"));
        classRoutineAdapter=new ClassRoutineAdapter(getApplicationContext(),routine);
        recyclerView.setAdapter(classRoutineAdapter);
        classRoutineAdapter.notifyDataSetChanged();


        //GetData();

    }

    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.backPageId){
            finish();
            Intent intent = new Intent(ClassRoutineActivity.this, MainActivity.class);
            intent.putExtra("EXTRA", "openHomeFragment");
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    }
    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(ClassRoutineActivity.this, MainActivity.class);
        intent.putExtra("EXTRA", "openHomeFragment");
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

        super.onBackPressed();
    }



    /*
    private void GetData() {
        //final ProgressDialog progressDialog=new ProgressDialog(getApplicationContext());
        //progressDialog.setMessage("Loading...");
        //progressDialog.show();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        list.add(new ClassRoutineModel(
                                jsonObject.getString("day"),
                                jsonObject.getString("time1"),
                                jsonObject.getString("time2"),
                                jsonObject.getString("time3"),
                                jsonObject.getString("time4"),
                                jsonObject.getString("time5"),
                                jsonObject.getString("sub1"),
                                jsonObject.getString("sub2"),
                                jsonObject.getString("sub3"),
                                jsonObject.getString("sub4"),
                                jsonObject.getString("sub5"),
                                jsonObject.getString("room1"),
                                jsonObject.getString("room2"),
                                jsonObject.getString("room3"),
                                jsonObject.getString("room4"),
                                jsonObject.getString("room5")


                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                        //progressDialog.dismiss();
                    }
                }
                classRoutineAdapter=new ClassRoutineAdapter(getApplicationContext(),list);
                recyclerView.setAdapter(classRoutineAdapter);
                classRoutineAdapter.notifyDataSetChanged();

               ///Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

     */
}