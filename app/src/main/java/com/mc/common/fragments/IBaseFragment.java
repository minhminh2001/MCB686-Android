package com.mc.common.fragments;

import com.mc.application.AppContext;
import com.mc.di.AppComponent;

/**
 * Created by dangpp on 2/21/2018.
 */

public interface IBaseFragment {
    AppContext getAppContext();

    AppComponent getAppComponent();

    int getTitleId();

    void showProgress(boolean show);
}
