package com.srsofttech.studentcare.dashboard_activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;


import com.srsofttech.studentcare.MainActivity;
import com.srsofttech.studentcare.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;

public class AttendanceActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView backPage;
    Toolbar toolbar;
    //CustomCalendar calendar;
    //private RequestQueue requestQueue;
   // HashMap<Object, Property> descHashMap=new HashMap<>();
    //Property defaultProperty=new Property();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //calendar=findViewById(R.id.id_calendar);
        backPage = findViewById(R.id.backPageId);
        backPage.setOnClickListener(this);

        //requestQueue= Volley.newRequestQueue(getApplicationContext());



        /*

        defaultProperty.layoutResource=R.layout.default_view;

        //assign variable
        defaultProperty.dateTextViewResource=R.id.text_view;

        //put object

        descHashMap.put("default",defaultProperty);

        //for current date
        Property currentProperty=new Property();
        currentProperty.layoutResource=R.layout.current_view;
        currentProperty.dateTextViewResource=R.id.text_view;
        descHashMap.put("current",currentProperty);


        //for present date
        Property presentProperty=new Property();
        presentProperty.layoutResource=R.layout.present_view;
        presentProperty.dateTextViewResource=R.id.text_view;
        descHashMap.put("present",presentProperty);

        //for absent
        Property absentProperty=new Property();
        absentProperty.layoutResource=R.layout.absent_view;
        absentProperty.dateTextViewResource=R.id.text_view;
        descHashMap.put("absent",absentProperty);

        //for holiday

        Property holidayProperty=new Property();
        holidayProperty.layoutResource=R.layout.holi_view;
        holidayProperty.dateTextViewResource=R.id.text_view;
        descHashMap.put("holiday",holidayProperty);



        jsonParse();

        //set desc hash map

         */



        /*
        dateHashMap.put(1,"holiday");

        dateHashMap.put(3,"present");
        dateHashMap.put(4,"present");
        dateHashMap.put(5,"present");
        dateHashMap.put(6,"holiday");
        dateHashMap.put(7,"present");
        dateHashMap.put(8,"present");
        dateHashMap.put(9,"present");
        dateHashMap.put(10,"present");
        dateHashMap.put(11,"present");

        dateHashMap.put(13,"present");
        dateHashMap.put(14,"present");
        dateHashMap.put(15,"holiday");

        dateHashMap.put(17,"holiday");
        dateHashMap.put(18,"holiday");
        dateHashMap.put(19,"holiday");
        dateHashMap.put(20,"holiday");
        dateHashMap.put(21,"holiday");
        dateHashMap.put(22,"holiday");
        dateHashMap.put(23,"holiday");
        dateHashMap.put(24,"holiday");
        dateHashMap.put(25,"absent");
        dateHashMap.put(26,"absent");
        dateHashMap.put(27,"holiday");
        dateHashMap.put(28,"holiday");
        dateHashMap.put(29,"holiday");
        dateHashMap.put(30,"holiday");
        dateHashMap.put(31,"holiday");


         */


    }

    @Override
    public void onClick(View view) {


        if(view.getId()==R.id.backPageId){
            finish();
            Intent intent = new Intent(AttendanceActivity.this, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    }

    public void onBackPressed() {
        finish();
        Intent intent = new Intent(AttendanceActivity.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        super.onBackPressed();
    }

    /*
    private void jsonParse() {

        String url = "https://raw.githubusercontent.com/rahmanreza646/attendance_json/main/attdendance.json";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            boolean test=response.getBoolean("status");


                                JSONArray jsonArray = response.getJSONArray("data");

                                JSONObject attendance = jsonArray.getJSONObject(0);
                                calendar.setMapDescToProp(descHashMap);
                                HashMap<Integer,Object> dateHashMap=new HashMap<>();
                                Calendar cal=Calendar.getInstance();
                                dateHashMap.put(cal.get(Calendar.DAY_OF_MONTH),"current");
                                for(int i=1;i<attendance.length();i++)
                                {

                                    Toast.makeText(getApplicationContext(),attendance.length()+"",Toast.LENGTH_LONG).show();

                                    if (attendance.getInt(String.valueOf(i))==1)
                                    {
                                        dateHashMap.put(i,"present");


                                    }
                                    if (attendance.getInt(String.valueOf(i))==0)
                                    {
                                        dateHashMap.put(i,"absent");

                                    }
                                    if (attendance.getInt(String.valueOf(i))==2)
                                    {
                                        dateHashMap.put(i,"holiday");

                                    }
                                    else
                                    {

                                    }
                                    calendar.setDate(cal,dateHashMap);
                                }





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