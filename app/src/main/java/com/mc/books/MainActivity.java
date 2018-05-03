package com.mc.books;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bon.viewanimation.Techniques;
import com.bon.viewanimation.YoYo;
import com.mc.common.activities.BaseAppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseAppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.home)
    ImageView home;
    @BindView(R.id.gift)
    ImageView gift;
    @BindView(R.id.notification)
    ImageView notification;
    @BindView(R.id.profile)
    ImageView profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    @Override
    public void initFragmentDefault() {

    }

    private void playAnimator(View view) {
        YoYo.with(Techniques.ReBounceAnimator)
                .duration(1000)
                .playOn(view);
    }

    @OnClick({R.id.home, R.id.gift, R.id.notification, R.id.profile})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home:
                this.playAnimator(home);
                break;
            case R.id.gift:
                this.playAnimator(gift);
                break;
            case R.id.notification:
                this.playAnimator(notification);
                break;
            case R.id.profile:
                this.playAnimator(profile);
                break;
        }
    }
}
