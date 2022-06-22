package com.srsofttech.studentcare.fragments;


import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.srsofttech.studentcare.Interfaces.BackListenerFragment;
import com.srsofttech.studentcare.R;
import com.srsofttech.studentcare.dashboard_activities.AcademicProgressActivity;
import com.srsofttech.studentcare.dashboard_activities.AttendanceActivity;
import com.srsofttech.studentcare.dashboard_activities.ClassRoutineActivity;
import com.srsofttech.studentcare.dashboard_activities.HomeTaskActivity;
import com.srsofttech.studentcare.dashboard_activities.LibraryActivity;
import com.srsofttech.studentcare.dashboard_activities.NoticeBoardActivity;
import com.srsofttech.studentcare.dashboard_activities.ResultActivity;
import com.srsofttech.studentcare.dashboard_activities.SyllabusActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment implements BackListenerFragment, View.OnClickListener {


    public static BackListenerFragment backBtnListener;
    CardView attendance,class_routine,home_task,notice_board,syllabus,academic_result,academic_progress,library;


    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View views= inflater.inflate(R.layout.fragment_dashboard, container, false);


        home_task = views.findViewById(R.id.id_home_task);
        home_task.setOnClickListener(this);
        academic_progress = views.findViewById(R.id.id_academic_progress);
        academic_progress.setOnClickListener(this);
        attendance = views.findViewById(R.id.id_attendance);
        attendance.setOnClickListener(this);
        class_routine = views.findViewById(R.id.id_class_routine);
        class_routine.setOnClickListener(this);
        notice_board = views.findViewById(R.id.id_notice_board);
        notice_board.setOnClickListener(this);
        library = views.findViewById(R.id.id_library);
        library.setOnClickListener(this);
        academic_result = views.findViewById(R.id.id_academic_result);
        academic_result.setOnClickListener(this);
        syllabus=views.findViewById(R.id.id_syllabus);
        syllabus.setOnClickListener(this);




    return views;
    }

    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.id_home_task){
            Intent it = new Intent(getActivity(), HomeTaskActivity.class);
            startActivity(it);
            getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }

        if(view.getId()==R.id.id_academic_progress){
            Intent it = new Intent(getActivity(), AcademicProgressActivity.class);
            startActivity(it);
            getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }


        if(view.getId()==R.id.id_attendance){
            Intent it = new Intent(getActivity(), AttendanceActivity.class);
            startActivity(it);
            getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }

        if(view.getId()==R.id.id_class_routine){
           Intent it = new Intent(getActivity(), ClassRoutineActivity.class);
            startActivity(it);
            getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }

        if(view.getId()==R.id.id_notice_board){
            Intent it = new Intent(getActivity(), NoticeBoardActivity.class);
            startActivity(it);
            getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }


        if(view.getId()==R.id.id_syllabus){
            Intent it = new Intent(getActivity(), SyllabusActivity.class);
            startActivity(it);
            getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }

        if(view.getId()==R.id.id_library){
             Intent it = new Intent(getActivity(), LibraryActivity.class);
             startActivity(it);
            getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }

        if(view.getId()==R.id.id_academic_result){
            Intent it = new Intent(getActivity(), ResultActivity.class);
            startActivity(it);
            getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        backBtnListener = this;
    }

    @Override
    public void onPause() {
        backBtnListener = null;
        super.onPause();
    }

    @Override
    public void onBackPressed() {

    }
}
