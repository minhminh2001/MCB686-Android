package com.mc.books.fragments.more.profile;

import com.mc.common.presenters.BaseDataPresenter;
import com.mc.di.AppComponent;
import com.mc.events.SignInEvent;

public class UserProfilePresenter<V extends IUserProfileView> extends BaseDataPresenter<V> implements IUserProfilePresenter<V> {
    /**
     * @param appComponent
     */
    protected UserProfilePresenter(AppComponent appComponent) {
        super(appComponent);
        bus.subscribe(this, SignInEvent.class, signInEvent -> {
        });

    }

    @Override
    public void checkEmail(String string) {

    }

    @Override
    public void checkPhoneNumber(String string) {

    }
}
