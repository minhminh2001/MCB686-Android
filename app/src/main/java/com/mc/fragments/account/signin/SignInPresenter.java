package com.mc.fragments.account.signin;

import com.mc.common.presenters.BaseDataPresenter;
import com.mc.di.AppComponent;

/**
 * Created by dangpp on 3/1/2018.
 */

public class SignInPresenter<V extends ISignInView> extends BaseDataPresenter<V> implements ISignInPresenter<V> {
    /**
     * @param appComponent
     */
    protected SignInPresenter(AppComponent appComponent) {
        super(appComponent);
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public void onSignIn() {
        getOptView().doIfPresent(v -> v.showLoading(true));
    }
}
