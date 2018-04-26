package com.mc.fragments.home.dashboad;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.bon.customview.button.ExtButton;
import com.mc.books.MainActivity;
import com.mc.books.R;
import com.mc.common.fragments.BaseMvpFragment;
import com.mc.utilities.KeycloakHelper;

import org.jboss.aerogear.android.core.Callback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by dangpp on 3/1/2018.
 */

public class DashboadFragment extends BaseMvpFragment<IDashboadView, IDashboadPresenter<IDashboadView>> implements IDashboadView {

    @Override
    public IDashboadPresenter<IDashboadView> createPresenter() {
        return new DashboadPresenter<>(getAppComponent());
    }

    @Override
    public int getResourceId() {
        return R.layout.dashbroad_fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public int getTitleId() {
        return super.getTitleId();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onSignUpSuccess() {

    }

}
