package com.example.phswarrior;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout rootLayout;
    private LinearLayout drawer ;
    private LayoutInflater inflater;
    private View navDrawer;
    private Toolbar toolbar;

    //For now do not use Buttons as they are not covered up when inflating
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootLayout = findViewById(R.id.root_layout);
        inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        toolbar = findViewById(R.id.toolbar);
        navDrawer = inflater.inflate(R.layout.nav_drawer, rootLayout, false);
        drawer = navDrawer.findViewById(R.id.navDrawer);
        rootLayout.addView(navDrawer);
        navDrawer.setVisibility(View.GONE);
        setSupportActionBar(toolbar);

        navDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatorSet set = Animations.drawerClose(navDrawer, drawer, -getResources().getDimension(R.dimen.navDrawerWidth));
                set.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        navDrawer.setVisibility(View.GONE);
                        navDrawer.setAlpha(1f);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                set.start();
            }
        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Animations.buttonDrawerOpen(navDrawer, drawer, -getResources().getDimension(R.dimen.navDrawerWidth)).start();
            }
        });

    }
}
