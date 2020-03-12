package com.example.phswarrior;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private View navDrawer;
    private LinearLayout drawer;

    RelativeLayout rootLayout;
    LayoutInflater inflater;
    Toolbar toolbar;
    FrameLayout fragmentContainer;
    LinearLayout homeButton, schoolButton, chatButton, callButton, studentButton;

    //For now do not use Buttons as they are not covered up when navDrawer is displayed
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
        fragmentContainer = findViewById(R.id.fragment_container);

        homeButton = findViewById(R.id.home_button);
        schoolButton = findViewById(R.id.school_button);
        chatButton = findViewById(R.id.chat_button);
        callButton = findViewById(R.id.call_button);
        studentButton = findViewById(R.id.student_button);

        rootLayout.addView(navDrawer);
        navDrawer.setVisibility(View.GONE);
        setSupportActionBar(toolbar);
        homeButton.callOnClick();

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

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                schoolButton.setSelected(false);
                chatButton.setSelected(false);
                callButton.setSelected(false);
                studentButton.setSelected(false);

                Fragment homeFragment = new HomeFragment();
                openFragment(homeFragment);
            }
        });

        schoolButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                homeButton.setSelected(false);
                chatButton.setSelected(false);
                callButton.setSelected(false);
                studentButton.setSelected(false);

                Fragment schoolFragment = new SchoolFragment();
                openFragment(schoolFragment);
            }
        });

        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                homeButton.setSelected(false);
                schoolButton.setSelected(false);
                callButton.setSelected(false);
                studentButton.setSelected(false);

                Fragment chatFragment = new ChatFragment();
                openFragment(chatFragment);            }
        });

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                homeButton.setSelected(false);
                schoolButton.setSelected(false);
                chatButton.setSelected(false);
                studentButton.setSelected(false);

                Fragment callFragment = new CallFragment();
                openFragment(callFragment);
            }
        });

        studentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                homeButton.setSelected(false);
                schoolButton.setSelected(false);
                chatButton.setSelected(false);
                callButton.setSelected(false);

                Fragment studentFragment = new StudentFragment();
                openFragment(studentFragment);
            }
        });


    }

    public void openFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}
