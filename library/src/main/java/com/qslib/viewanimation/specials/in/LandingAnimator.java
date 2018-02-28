package com.qslib.viewanimation.specials.in;

import android.view.View;

import com.nineoldandroids.animation.ObjectAnimator;
import com.qslib.viewanimation.BaseViewAnimator;
import com.qslib.viewanimation.easing.Glider;
import com.qslib.viewanimation.easing.Skill;

public class LandingAnimator extends BaseViewAnimator {
    @Override
    protected void prepare(View target) {
        try {
            getAnimatorAgent().playTogether(
                    Glider.glide(Skill.QuintEaseOut, getDuration(), ObjectAnimator.ofFloat(target, "scaleX", 1.5f, 1f)),
                    Glider.glide(Skill.QuintEaseOut, getDuration(), ObjectAnimator.ofFloat(target, "scaleY", 1.5f, 1f)),
                    Glider.glide(Skill.QuintEaseOut, getDuration(), ObjectAnimator.ofFloat(target, "alpha", 0, 1f))
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
