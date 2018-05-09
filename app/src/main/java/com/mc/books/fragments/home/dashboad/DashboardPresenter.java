package com.mc.books.fragments.home.dashboad;

import android.util.Log;
import android.view.View;

import com.mc.common.presenters.BaseDataPresenter;
import com.mc.di.AppComponent;
import com.mc.events.DashboadEvent;
import com.mc.events.SignInEvent;


public class DashboardPresenter<V extends IDashboardView> extends BaseDataPresenter<V> implements IDashboardPresenter<V> {

    protected DashboardPresenter(AppComponent appComponent) {
        super(appComponent);
        bus.subscribe(this, DashboadEvent.class, dashbroadevent -> {
        });
    }

    @Override
    public void showDialog(boolean isShow, View view, int position) {
        getOptView().doIfPresent(v -> v.onShowDialog(isShow, view, position));
    }

    @Override
    public void onSearchBook(String keyword) {

    }
}
