package com.mc.books;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mc.common.activities.AloneFragmentActivity;
import com.mc.common.activities.BaseAppCompatActivity;
import com.mc.books.fragments.account.signin.SignInFragment;

/**
 * Created by HungND on 3/2/18.
 */

public class SplashActivity extends BaseAppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Bundle bundle = new Bundle();
        bundle.putInt("user", 1);

        AloneFragmentActivity.with(this)
                .parameters(new Bundle())
                .start(SignInFragment.class);
    }


}
