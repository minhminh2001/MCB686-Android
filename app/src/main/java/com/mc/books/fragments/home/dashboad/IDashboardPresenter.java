package com.mc.books.fragments.home.dashboad;

import android.view.View;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

/**
 * Created by dangpp on 3/1/2018.
 */

public interface IDashboardPresenter<V extends MvpView> extends MvpPresenter<V> {
    void showDialog(boolean isShow, View view, int position);

    void onSearchBook(String keyword);
}
