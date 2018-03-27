package com.mc.fragments.account.signin;

import android.os.Handler;
import android.util.Log;

import com.mc.common.presenters.BaseDataPresenter;
import com.mc.di.AppComponent;
import com.mc.events.SignInEvent;

/**
 * Created by dangpp on 3/1/2018.
 */

public class SignInPresenter<V extends ISignInView> extends BaseDataPresenter<V> implements ISignInPresenter<V> {
    /**
     * @param appComponent
     */
    protected SignInPresenter(AppComponent appComponent) {
        super(appComponent);
        bus.subscribe(this, SignInEvent.class, signInEvent -> {

        });

        getOptView().doIfPresent(v -> v.showLoading(true));
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public void onSignIn(String userName, String password) {
        getOptView().doIfPresent(v -> v.showLoading(true));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (userName.isEmpty()) {
                    Log.e("SignInPresenter", "userName");
                    getOptView().doIfPresent(ISignInView::onEmptyUserName);
                    getOptView().doIfPresent(v -> v.showLoading(false));
                } else if (password.isEmpty()) {
                    Log.e("password", "userName");
                    getOptView().doIfPresent(ISignInView::onEmptyPassword);
                    getOptView().doIfPresent(v -> v.showLoading(false));
                } else {
                    Log.e("SignInPresenter", "else");
                    getOptView().doIfPresent(v -> v.navigateToMain());
                    getOptView().doIfPresent(v -> v.showLoading(false));
                }
            }
        }, 2000);
    }
}
