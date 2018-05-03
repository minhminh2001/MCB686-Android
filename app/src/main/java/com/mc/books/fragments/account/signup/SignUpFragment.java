package com.mc.books.fragments.account.signup;

import android.os.Bundle;
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
import butterknife.Unbinder;

public class SignUpFragment extends BaseMvpFragment<ISignUpView, ISignUpPresenter<ISignUpView>> implements ISignUpView {
    @BindView(R.id.userName)
    ExtEditText userName;
    @BindView(R.id.password)
    ExtEditText password;
    @BindView(R.id.register)
    ExtButton register;
    Unbinder unbinder;

    @Override
    public ISignUpPresenter<ISignUpView> createPresenter() {
        return new SignUpPresenter<>(getAppComponent());
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

    @OnClick(R.id.register)
    public void onViewClicked() {
        presenter.onSignUp(userName.getText().toString(), password.getText().toString());
    }
}
