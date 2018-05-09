package com.mc.books.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.widget.ImageView;

import com.bon.customview.button.ExtButton;
import com.bon.customview.textview.ExtTextView;
import com.bon.sharepreferences.AppPreferences;
import com.mc.books.R;
import com.mc.books.activity.MainActivity;
import com.mc.common.activities.BaseAppCompatActivity;
import com.mc.utilities.Constant;
import com.mc.utilities.KeycloakHelper;
import com.mc.utilities.McBookStore;

import org.jboss.aerogear.android.core.Callback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignInActivity extends BaseAppCompatActivity {

    @BindView(R.id.imglogo)
    ImageView imglogo;
    @BindView(R.id.txtLogin)
    ExtTextView txtLogin;
    @BindView(R.id.btnLogin)
    ExtButton btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.sign_in_activity;
    }

    @Override
    public ActionBar getAppSupportActionBar() {
        return null;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (!McBookStore.getInstance(getAppContext()).getString(Constant.KEY_TOKEN).equals("")) {
            startActivity(new Intent(getAppContext(), MainActivity.class));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        if (intent != null && intent.getAction() != null && intent.getData() != null) {
            KeycloakHelper.connect(this, new Callback() {
                        @Override
                        public void onSuccess(Object o) {
                            Log.e("sendPhotoToKeycloak", o.toString());
                            AppPreferences.getInstance(getAppContext()).putString(Constant.KEY_TOKEN, o.toString());
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

    @OnClick(R.id.btnLogin)
    public void onViewClicked() {
        KeycloakHelper.connect(this, new Callback() {
                    @Override
                    public void onSuccess(Object o) { }

                    @Override
                    public void onFailure(Exception e) { }
                }
        );
    }
}
