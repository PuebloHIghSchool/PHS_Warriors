package com.example.phswarrior;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout rootLayout;
    private LinearLayout navDrawerDeadSpace;
    private LayoutInflater inflater;
    private View navDrawer;
    private Toolbar toolbar;

    //For now do not use Buttons as they are not covered up when infalting
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootLayout = findViewById(R.id.root_layout);
        inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        toolbar = findViewById(R.id.toolbar);
        navDrawer = inflater.inflate(R.layout.nav_drawer, rootLayout, false);
        navDrawerDeadSpace = navDrawer.findViewById(R.id.navDrawerDeadSpace);

        rootLayout.addView(navDrawer);
        navDrawer.setVisibility(View.GONE);
        setSupportActionBar(toolbar);

        navDrawerDeadSpace.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                navDrawer.setVisibility(View.GONE);
                return true;
            }
        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navDrawer.setVisibility(View.VISIBLE);
            }
        });

    }
}