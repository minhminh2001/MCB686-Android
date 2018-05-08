package com.mc.books.fragments.more.profile;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface IUserProfilePresenter<V extends MvpView> extends MvpPresenter<V> {
        void checkEmail(String string);
        void checkPhoneNumber(String string);
}
