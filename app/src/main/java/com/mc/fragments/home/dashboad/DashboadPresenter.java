package com.mc.fragments.home.dashboad;

import android.util.Log;

import com.mc.common.presenters.BaseDataPresenter;
import com.mc.di.AppComponent;
import com.mc.events.SignInEvent;


public class DashboadPresenter<V extends IDashboadView> extends BaseDataPresenter<V> implements IDashboadPresenter<V> {

    protected DashboadPresenter(AppComponent appComponent) {
        super(appComponent);
        bus.subscribe(this, SignInEvent.class, signInEvent -> {
        });
    }

    @Override
    public void onSignIn() {
        Log.e("DashboadPresenter", "");
        getOptView().doIfPresent(v -> v.onSignUpSuccess());
    }
}
