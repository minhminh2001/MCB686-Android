package com.mc.books.fragments.home.dashboad;

import android.view.View;

import com.hannesdorfmann.mosby3.mvp.MvpView;

/**
 * Created by dangpp on 3/1/2018.
 */

public interface IDashboardView extends MvpView {
    void onShowDialog(boolean isShow, View view);
}
