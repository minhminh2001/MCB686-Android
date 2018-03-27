package com.mc.fragments.account.signin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bon.customview.button.ExtButton;
import com.bon.customview.edittext.ExtEditText;
import com.mc.books.R;
import com.mc.common.fragments.BaseMvpFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by dangpp on 3/1/2018.
 */

public class SignInFragment extends BaseMvpFragment<ISignInView, ISignInPresenter<ISignInView>> implements ISignInView {
    @BindView(R.id.userName)
    ExtEditText userName;
    @BindView(R.id.password)
    ExtEditText password;
    @BindView(R.id.login)
    ExtButton login;
    Unbinder unbinder;

    @Override
    public ISignInPresenter<ISignInView> createPresenter() {
        return new SignInPresenter<>(getAppComponent());
    }

    @Override
    public int getResourceId() {
        return R.layout.sign_in_fragment;
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
    public void showLoading(boolean isLoading) {
        showProgress(isLoading);
    }

    @Override
    public void onEmptyUserName() {
        userName.setEmptyErrorString("Empty");
    }

    @Override
    public void onEmptyPassword() {
        password.setEmptyErrorString("Empty");
    }

    @Override
    public void navigateToMain() {
        Toast.makeText(mActivity, "Login success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.login)
    public void onViewClicked() {
        presenter.onSignIn(userName.getText().toString(), password.getText().toString());
    }
}
