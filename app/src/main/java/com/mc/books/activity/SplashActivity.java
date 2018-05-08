package com.mc.books.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.view.Window;
import android.view.WindowManager;
import com.mc.books.R;
import com.mc.books.SignInActivity;
import com.mc.common.activities.BaseAppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by HungND on 3/2/18.
 */

public class SplashActivity extends BaseAppCompatActivity {
    @BindView(R.id.progress)
    GifImageView progress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_activity);
        ButterKnife.bind(this);

        final Handler handler = new Handler();
        handler.postDelayed(() -> {
//            AloneFragmentActivity.with(getApplicationContext())
//                    .start(SignInFragment.class);
            startActivity(new Intent(SplashActivity.this, SignInActivity.class));
            finish();
        }, 2000);
    }

    @Override
    public ActionBar getAppSupportActionBar() {
        return null;
    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}
