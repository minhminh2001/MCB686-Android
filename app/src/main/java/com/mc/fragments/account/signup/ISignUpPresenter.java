package com.mc.fragments.account.signup;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface ISignUpPresenter<V extends MvpView> extends MvpPresenter<V> {

    void onSignUp(String userName, String password);
}
