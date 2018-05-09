package com.mc.books.fragments.account.signup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
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

public class SignUpFragment extends BaseMvpFragment<ISignUpView, ISignUpPresenter<ISignUpView>> implements ISignUpView {
    @BindView(R.id.userName)
    ExtEditText userName;
    @BindView(R.id.password)
    ExtEditText password;
    @BindView(R.id.register)
    ExtButton register;

    @Override
    public ISignUpPresenter<ISignUpView> createPresenter() {
        return new SignUpPresenter<>(getAppComponent());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindButterKnife(view);
    }

    @Override
    public int getResourceId() {
        return R.layout.sign_up_fragment;
    }

    @Override
    public int getTitleId() {
        return R.string.register;
    }

    @Override
    public void showLoading(boolean isLoading) {
        showProgress(isLoading);
    }

    @Override
    public void onEmptyUsername() {
       userName.setEmptyErrorString("Empty");
    }

    @Override
    public void onEmptyPassword() {
        password.setEmptyErrorString("Empty");
    }

    @Override
    public void onSignUpSuccess() {
        Toast.makeText(mActivity, "Register success", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.register)
    public void onViewClicked() {
        presenter.onSignUp(userName.getText().toString(), password.getText().toString());
    }
}
