package com.qslib.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.qslib.activity.ExtBaseActivity;
import com.qslib.logger.Logger;
import com.qslib.util.KeyboardUtils;

/**
 * Created by Dang Pham Phu on 2/1/2017.
 */

public class ExtBaseFragment extends Fragment {
    private static final String TAG = ExtBaseFragment.class.getSimpleName();
    protected ExtBaseActivity mExtBaseActivity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            if (activity instanceof ExtBaseActivity) {
                mExtBaseActivity = (ExtBaseActivity) activity;
            }
        } catch (Exception ex) {
            Logger.e(TAG, ex);
        }
    }

    /**
     * show dialog
     */
    protected ExtBaseFragment showProgressDialog() {
        try {
            if (mExtBaseActivity != null) {
                mExtBaseActivity.showProgressDialog();
            }
        } catch (Exception ex) {
            Logger.e(TAG, ex);
        }

        return this;
    }

    /**
     * hide dialog
     */
    protected ExtBaseFragment hideProgressDialog() {
        try {
            if (mExtBaseActivity != null) {
                mExtBaseActivity.hideProgressDialog();
            }
        } catch (Exception ex) {
            Logger.e(TAG, ex);
        }

        return this;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            KeyboardUtils.hideKeyboard(mExtBaseActivity, view);
            KeyboardUtils.dontShowKeyboardActivity(mExtBaseActivity);
        } catch (Exception ex) {
            Logger.e(TAG, ex);
        }
    }
}

