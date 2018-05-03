package com.mc.books.fragments.home.dashboad;

import android.util.Log;

import com.mc.common.presenters.BaseDataPresenter;
import com.mc.di.AppComponent;
import com.mc.events.SignInEvent;


public class DashboardPresenter<V extends IDashboardView> extends BaseDataPresenter<V> implements IDashboardPresenter<V> {

    protected DashboardPresenter(AppComponent appComponent) {
        super(appComponent);
        bus.subscribe(this, SignInEvent.class, signInEvent -> {
        });
    }

    @Override
    public void onSignIn() {
        Log.e("DashboardPresenter", "");
        getOptView().doIfPresent(v -> v.onSignUpSuccess());
    }
}
