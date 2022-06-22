package com.srsofttech.studentcare;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


import android.content.DialogInterface;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.srsofttech.studentcare.auth.SignInActivity;
import com.srsofttech.studentcare.fragments.AboutFragment;
import com.srsofttech.studentcare.fragments.CalendarFragment;
import com.srsofttech.studentcare.fragments.DashboardFragment;
import com.srsofttech.studentcare.fragments.ProfileFragment;
import com.srsofttech.studentcare.fragments.TeachersInfoFragment;
import com.srsofttech.studentcare.nav_drawer.data.MenuItem;
import com.srsofttech.studentcare.nav_drawer.widget.SNavigationDrawer;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    SNavigationDrawer sNavigationDrawer;
    int color1 = 0;
    Class fragmentClass;
    public Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        sNavigationDrawer = findViewById(R.id.navigationDrawer);
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Dashboard"));
        menuItems.add(new MenuItem("Profile"));
        menuItems.add(new MenuItem("Teacher's Info"));
        menuItems.add(new MenuItem("Calendar"));
        menuItems.add(new MenuItem("About"));
        menuItems.add(new MenuItem("Logout"));
        //sNavigationDrawer.setMenuItemList(menuItems);

        sNavigationDrawer.setMenuItemList(menuItems);
        fragmentClass = DashboardFragment.class;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.frameLayout, fragment).commit();
        }


        sNavigationDrawer.setOnMenuItemClickListener(new SNavigationDrawer.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClicked(int position) {
                System.out.println("Position " + position);

                switch (position) {
                    case 0: {
                        color1 = R.color.red;
                        fragmentClass = DashboardFragment.class;
                        break;
                    }
                    case 1: {
                        color1 = R.color.orange;
                        fragmentClass = ProfileFragment.class;
                        break;
                    }
                    case 2: {
                        color1 = R.color.green;
                        fragmentClass = TeachersInfoFragment.class;
                        break;
                    }
                    case 3: {
                        color1 = R.color.green;
                        fragmentClass = CalendarFragment.class;
                        break;
                    }

                    case 4: {
                        color1 = R.color.blue;
                        fragmentClass = AboutFragment.class;
                        break;
                    }

                    case 5:{

                        startActivity(new Intent(MainActivity.this, SignInActivity.class));
                        finish();
                    }


                }
                sNavigationDrawer.setDrawerListener(new SNavigationDrawer.DrawerListener() {

                    @Override
                    public void onDrawerOpened() {

                    }

                    @Override
                    public void onDrawerOpening() {

                    }

                    @Override
                    public void onDrawerClosing() {
                        System.out.println("Drawer closed");

                        try {
                            fragment = (Fragment) fragmentClass.newInstance();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        if (fragment != null) {
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.frameLayout, fragment).commit();

                        }
                    }

                    @Override
                    public void onDrawerClosed() {


                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        System.out.println("State " + newState);
                    }
                });
            }
        });


    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Student Care");
        builder.setMessage("Do you want to close this application?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //saveResult();
                MainActivity.super.onBackPressed();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        builder.show();
    }


    }