package com.mc.common.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.mc.application.AppContext;
import com.mc.common.activities.BaseAppCompatActivity;
import com.mc.di.AppComponent;
import com.bon.util.KeyboardUtils;

import butterknife.ButterKnife;

/**
 * Created by dangpp on 2/21/2018.
 */

public abstract class BaseMvpFragment<V extends MvpView, P extends MvpPresenter<V>>
        extends MvpFragment<V, P> implements IBaseFragment, IResourceFragment {

    protected BaseAppCompatActivity mActivity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof BaseAppCompatActivity) {
            this.mActivity = (BaseAppCompatActivity) activity;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getAppContext().getComponent().inject((BaseMvpFragment<MvpView, MvpPresenter<MvpView>>) this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getResourceId(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(view);

        // update title
        mActivity.setToolbarTitle(getTitleId());

        // update toolbar
        ActionBar supportActionBar = mActivity.getSupportActionBar();
        if (supportActionBar != null) {
            initToolbar(supportActionBar);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // hide loading, keyboard
        showProgress(false);
        KeyboardUtils.hideSoftKeyboard(mActivity);
    }

    @Override
    public void showProgress(boolean show) {
        if (show) {
            mActivity.showProgressDialog();
        } else {
            mActivity.hideProgressDialog();
        }
    }

    @Override
    public int getTitleId() {
        return 0;
    }

    @Override
    public AppContext getAppContext() {
        return mActivity.getAppContext();
    }

    @Override
    public AppComponent getAppComponent() {
        return mActivity.getAppContext().getComponent();
    }

    /**
     * @param supportActionBar
     */
    protected void initToolbar(@NonNull ActionBar supportActionBar) {
        supportActionBar.setDisplayHomeAsUpEnabled(false);
        supportActionBar.setHomeAsUpIndicator(0);
        supportActionBar.setIcon(0);
    }
}
