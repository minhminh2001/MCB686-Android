package com.mc.books.fragments.account.signin;

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
import com.mc.books.R;
import com.mc.books.activity.MainActivity;
import com.mc.common.fragments.BaseMvpFragment;
import com.mc.utilities.Constant;
import com.mc.utilities.KeycloakHelper;
import com.mc.utilities.McBookStore;

import org.jboss.aerogear.android.core.Callback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by dangpp on 3/1/2018.
 */

public class SignInFragment extends BaseMvpFragment<ISignInView, ISignInPresenter<ISignInView>> implements ISignInView {
    @Override
    public void onStart() {
        super.onStart();
        if (!McBookStore.getInstance(getAppContext()).getString(Constant.KEY_TOKEN).equals("")) {
            startActivity(new Intent(getAppContext(), MainActivity.class));
        }
    }

    @BindView(R.id.btnLogin)
    ExtButton btnLogin;

    @Override
    public ISignInPresenter<ISignInView> createPresenter() {
        return new SignInPresenter<>(getAppComponent());
    }

    @Override
    public int getResourceId() {
        return R.layout.sign_in_fragment_new;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindButterKnife(view);
    }

    @Override
    public int getTitleId() {
        return R.string.login;
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
    public void onSignUpSuccess() {
        if (!KeycloakHelper.isConnected()) {
            Log.e("onSignUpSuccess", "!isConnected");
            KeycloakHelper.connect(getActivity(), new Callback() {
                        @Override
                        public void onSuccess(Object o) {
                            Log.e("sendPhotoToKeycloak", o.toString());
                            McBookStore.getInstance(getAppContext()).putString(Constant.KEY_TOKEN, o.toString());
                            startActivity(new Intent(getAppContext(), MainActivity.class));
                        }

                        @Override
                        public void onFailure(Exception e) {
                            Log.e("onFailure", e.toString());
                        }
                    }
            );

        }
    }

    @Override
    public void showLoading(boolean isLoading) {
        showProgress(isLoading);
    }

    @OnClick(R.id.btnLogin)
    public void onViewClicked() {
        Log.e("onViewClicked", "");
        presenter.onSignIn();
    }
}
