package com.mc.fragments.account.signup;

import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface ISignUpView extends MvpView{
    void showLoading(boolean isLoading);

    void onEmptyUsername();

    void onEmptyPassword();

    void onSignUpSuccess();
}
