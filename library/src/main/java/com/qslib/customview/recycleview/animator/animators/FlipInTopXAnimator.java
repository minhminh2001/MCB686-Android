package com.qslib.customview.recycleview.animator.animators;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Interpolator;

import com.qslib.logger.Logger;

public class FlipInTopXAnimator extends BaseItemAnimator {
    private static final String TAG = FlipInTopXAnimator.class.getSimpleName();

    public FlipInTopXAnimator() {
    }

    public FlipInTopXAnimator(Interpolator interpolator) {
        mInterpolator = interpolator;
    }

    @Override
    protected void animateRemoveImpl(final RecyclerView.ViewHolder holder) {
        try {
            ViewCompat.animate(holder.itemView)
                    .rotationX(90)
                    .setDuration(getRemoveDuration())
                    .setInterpolator(mInterpolator)
                    .setListener(new DefaultRemoveVpaListener(holder))
                    .setStartDelay(getRemoveDelay(holder))
                    .start();
        } catch (Exception e) {
            Logger.e(TAG, e);
        }
    }

    @Override
    protected void preAnimateAddImpl(RecyclerView.ViewHolder holder) {
        try {
            ViewCompat.setRotationX(holder.itemView, 90);
        } catch (Exception e) {
            Logger.e(TAG, e);
        }
    }

    @Override
    protected void animateAddImpl(final RecyclerView.ViewHolder holder) {
        try {
            ViewCompat.animate(holder.itemView)
                    .rotationX(0)
                    .setDuration(getAddDuration())
                    .setInterpolator(mInterpolator)
                    .setListener(new DefaultAddVpaListener(holder))
                    .setStartDelay(getAddDelay(holder))
                    .start();
        } catch (Exception e) {
            Logger.e(TAG, e);
        }
    }
}
