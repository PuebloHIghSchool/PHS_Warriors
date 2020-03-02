package com.example.phswarrior;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;

public class Animations {

    public static AnimatorSet buttonDrawerOpen(View blackScreen, LinearLayout navDrawer, Float offset){
        blackScreen.setVisibility(View.VISIBLE);
        navDrawer.setVisibility(View.VISIBLE);
        navDrawer.setTranslationX(offset);
        ObjectAnimator slide = ObjectAnimator.ofFloat(navDrawer, "TranslationX",offset, 0);

        AnimatorSet set = new AnimatorSet();
        set.setInterpolator(new DecelerateInterpolator());
        set.play(slide);
        set.setDuration(300);
        return set;
    }

    public static AnimatorSet drawerClose(View blackScreen, LinearLayout navDrawer, Float offset){
        ObjectAnimator slide = ObjectAnimator.ofFloat(navDrawer, "TranslationX", 0, offset);
        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(blackScreen, "alpha", 1f, .3f);

        AnimatorSet set = new AnimatorSet();
        set.setInterpolator(new DecelerateInterpolator());
        set.play(fadeOut).after(slide);
        set.setDuration(200);

        return set;
    }

}
