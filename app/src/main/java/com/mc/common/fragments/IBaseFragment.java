package com.mc.common.fragments;

import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;

import com.mc.application.AppContext;
import com.mc.di.AppComponent;

/**
 * Created by dangpp on 2/21/2018.
 */

public interface IBaseFragment {
    AppContext getAppContext();

    AppComponent getAppComponent();

    int getTitleId();

    void initToolbar(@NonNull ActionBar supportActionBar);

    void showProgress(boolean show);
}
