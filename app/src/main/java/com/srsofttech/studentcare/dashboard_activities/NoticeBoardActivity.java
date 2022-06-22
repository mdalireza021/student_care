package com.srsofttech.studentcare.dashboard_activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.srsofttech.studentcare.MainActivity;
import com.srsofttech.studentcare.R;
import com.srsofttech.studentcare.adapters.NoticeBoardAdapter;
import com.srsofttech.studentcare.model.NoticeBoardModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NoticeBoardActivity extends AppCompatActivity implements View.OnClickListener{


    ImageView backPage;
    ArrayList<NoticeBoardModel> notice_list=new ArrayList<>();
    private RecyclerView recyclerView;
    private NoticeBoardAdapter noticeBoardAdapter;
    //private RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_board);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        backPage = findViewById(R.id.backPageId);
        backPage.setOnClickListener(this);
        recyclerView=findViewById(R.id.id_notice_board_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        notice_list.add(new NoticeBoardModel("Book distribution Notice","board book will distribute on 02.01.22 at 10.00 am.Students/Guardians are requested to bring session fee to pay slip to collect book","31/12/2021"));
        noticeBoardAdapter=new NoticeBoardAdapter(getApplicationContext(),notice_list);
        recyclerView.setAdapter(noticeBoardAdapter);

        //requestQueue= Volley.newRequestQueue(getApplicationContext());
        //jsonParse();

    }


    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.backPageId){
            finish();
            Intent intent = new Intent(NoticeBoardActivity.this, MainActivity.class);
            intent.putExtra("EXTRA", "openHomeFragment");
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

        }
    }
    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(NoticeBoardActivity.this, MainActivity.class);
        intent.putExtra("EXTRA", "openHomeFragment");
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

        super.onBackPressed();
    }
/*
    private void jsonParse() {
        String url =getString(R.string.api_url)+"/api/notice";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            boolean test=response.getBoolean("status");
                            ///mTextViewResult.append(test+"\n");
                            if (test==true)
                            {
                                JSONArray jsonArray = response.getJSONArray("data");
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    arrayList.add(new NoticeBoardModel(
                                            jsonObject.getString("name"),
                                            jsonObject.getString("description"),
                                            jsonObject.getString("available_from")

                                    ));
                                }
                            }
                            noticeBoardAdapter=new NoticeBoardAdapter(getApplicationContext(),arrayList);
                            recyclerView.setAdapter(noticeBoardAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },  new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(request);
    }
 */
}