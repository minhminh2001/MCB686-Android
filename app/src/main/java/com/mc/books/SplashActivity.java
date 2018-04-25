package com.mc.books;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;

import com.mc.common.activities.AloneFragmentActivity;
import com.mc.common.activities.BaseAppCompatActivity;
import com.mc.fragments.account.signin.SignInFragment;

/**
 * Created by HungND on 3/2/18.
 */

public class SplashActivity extends BaseAppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.splash_activity);



//        Bundle bundle = new Bundle();
//        bundle.putInt("user", 1);
//
//        AloneFragmentActivity.with(this)
//                .parameters(new Bundle())
//                .start(SignInFragment.class);
    }
}
