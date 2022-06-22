package com.srsofttech.studentcare.fragments;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.srsofttech.studentcare.R;
import com.srsofttech.studentcare.adapters.TeachersInfoAdapter;
import com.srsofttech.studentcare.model.TeachersInfoModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class TeachersInfoFragment extends Fragment {

    WebView webView;
    //RequestQueue requestQueue;
    private RecyclerView recyclerView;
    private ArrayList<TeachersInfoModel> teacher_list=new ArrayList<>();
    private TeachersInfoAdapter teachersInfoAdapter;


    public TeachersInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_teachersinfo, container, false);

        recyclerView=v.findViewById(R.id.id_teachers_info_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
        recyclerView.setHasFixedSize(true);

        teacher_list.add(new TeachersInfoModel("Md.Ali Reza","Assistant Teacher","Physics","reza646@gmail.com","01772711529"));
        teacher_list.add(new TeachersInfoModel("Akul","Lecturer","Math","akul123@gmail.com","0177235698"));
        teacher_list.add(new TeachersInfoModel("Akul","Lecturer","Math","akul123@gmail.com","0177235698"));
        teacher_list.add(new TeachersInfoModel("Akul","Lecturer","Math","akul123@gmail.com","0177235698"));
        teacher_list.add(new TeachersInfoModel("Akul","Lecturer","Math","akul123@gmail.com","0177235698"));
        teacher_list.add(new TeachersInfoModel("Akul","Lecturer","Math","akul123@gmail.com","0177235698"));
        teacher_list.add(new TeachersInfoModel("Akul","Lecturer","Math","akul123@gmail.com","0177235698"));
        teacher_list.add(new TeachersInfoModel("Akul","Lecturer","Math","akul123@gmail.com","0177235698"));
        teacher_list.add(new TeachersInfoModel("Akul","Lecturer","Math","akul123@gmail.com","0177235698"));
        teacher_list.add(new TeachersInfoModel("Akul","Lecturer","Math","akul123@gmail.com","0177235698"));


        teachersInfoAdapter=new TeachersInfoAdapter(getContext(),teacher_list);
        recyclerView.setAdapter(teachersInfoAdapter);



        //load_data();
        return v;

    }
/*
    private void load_data() {
        requestQueue= Volley.newRequestQueue(getContext());

        //String url = getString(R.string.api_url)+"/api/teacher";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            boolean test=response.getBoolean("status");
                            //Toast.makeText(getContext(),test+"",Toast.LENGTH_LONG).show();

                            if (test==true)
                            {
                                JSONArray jsonArray = response.getJSONArray("data");
                                //Toast.makeText(getContext(),jsonArray+"",Toast.LENGTH_LONG).show();

                                for (int i = 0; i < jsonArray.length(); i++) {

                                    JSONObject jsonObject = jsonArray.getJSONObject(i);


                                    teacher_list.add(new TeachersInfoModel(
                                            jsonObject.getString("name"),
                                            jsonObject.getString("designation"),
                                            jsonObject.getString("area"),
                                            jsonObject.getString("email"),
                                            jsonObject.getString("phone")

                                    ));


                                    ///Toast.makeText(getContext(),jsonObject.getString("name")+"",Toast.LENGTH_LONG).show();

                                }

                            }

                            teachersInfoAdapter=new TeachersInfoAdapter(getContext(),teacher_list);
                            recyclerView.setAdapter(teachersInfoAdapter);

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
