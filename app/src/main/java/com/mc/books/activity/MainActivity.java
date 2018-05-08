package com.mc.books;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bon.viewanimation.Techniques;
import com.bon.viewanimation.YoYo;
import com.mc.books.R;
import com.mc.books.fragments.home.dashboad.DashboardFragment;
import com.mc.books.fragments.more.MoreFragment;
import com.mc.common.activities.BaseAppCompatActivity;
import com.mc.common.fragments.BaseMvpFragment;
import com.mc.utilities.FragmentUtils;
import com.mc.utilities.shadow.ShadowProperty;
import com.mc.utilities.shadow.ShadowViewDrawable;

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
    @BindView(R.id.more)
    ImageView more;
    @BindView(R.id.lineHome)
    View lineHome;
    @BindView(R.id.lineGift)
    View lineGift;
    @BindView(R.id.lineNotification)
    View lineNotification;
    @BindView(R.id.lineMore)
    View lineMore;
    @BindView(R.id.llBottomBar)
    LinearLayout llBottomBar;

    public static final int HOME_TAB = 110;
    public static final int GIFT_TAB = 111;
    public static final int NOTIFICATION_TAB = 112;
    public static final int MORE_TAB = 113;
    public int currentFragmentIndex = HOME_TAB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ShadowProperty sp = new ShadowProperty()
                .setShadowColor(R.color.colorPink)
                .setShadowDy(dip2px(this, 0.5f))
                .setShadowRadius(dip2px(this, 3))
                .setShadowSide(ShadowProperty.TOP);
        ShadowViewDrawable sd = new ShadowViewDrawable(sp, Color.TRANSPARENT, 0, 0);
        ViewCompat.setBackground(llBottomBar, sd);
        ViewCompat.setLayerType(llBottomBar, ViewCompat.LAYER_TYPE_SOFTWARE, null);

        this.initFragmentDefault();
//        Log.e("redirectUrl", "redirectUrl:: " + AppPreferences.getInstance(this).getString("REDIRECT_URL"));
//        Log.e("refresh_token", "refresh_token:: " + AppPreferences.getInstance(this).getString("refresh_token"));
//        Log.e("accessToken", "accessToken:: " + AppPreferences.getInstance(this).getString("accessToken"));
//        Log.e("authorizationCode", "authorizationCode:: " + AppPreferences.getInstance(this).getString("authorizationCode"));

    }

    @Override
    public ActionBar getAppSupportActionBar() {
        return getSupportActionBar();
    }

    @Override
    public void initFragmentDefault() {
        this.changeTabBottom(HOME_TAB);
    }

    private void playAnimator(View view) {
        YoYo.with(Techniques.ReBounceAnimator)
                .duration(1000)
                .playOn(view);
    }

    public static int dip2px(Context context, float dpValue) {
        try {
            final float scale = context.getResources().getDisplayMetrics().density;
            return (int) (dpValue * scale + 0.5f);
        } catch (Throwable throwable) {
            // igonre
        }
        return 0;
    }

    private void activeTab(int index) {
        home.setImageResource(R.drawable.ic_book_normal);
        gift.setImageResource(R.drawable.ic_card_giftcard_normal);
        notification.setImageResource(R.drawable.ic_notifications_normal);
        more.setImageResource(R.drawable.ic_bars_line_normal);
        lineGift.setVisibility(View.INVISIBLE);
        lineHome.setVisibility(View.INVISIBLE);
        lineMore.setVisibility(View.INVISIBLE);
        lineNotification.setVisibility(View.INVISIBLE);

        if (index == HOME_TAB) {
            home.setImageResource(R.drawable.ic_book_active);
            lineHome.setVisibility(View.VISIBLE);
        } else if (index == GIFT_TAB) {
            gift.setImageResource(R.drawable.ic_card_giftcard_active);
            lineGift.setVisibility(View.VISIBLE);
        } else if (index == NOTIFICATION_TAB) {
            notification.setImageResource(R.drawable.ic_notifications_active);
            lineNotification.setVisibility(View.VISIBLE);
        } else if (index == MORE_TAB) {
            more.setImageResource(R.drawable.ic_bars_line_active);
            lineMore.setVisibility(View.VISIBLE);
            toolbar.setVisibility(View.GONE);
        }
    }

    @OnClick({R.id.home, R.id.gift, R.id.notification, R.id.more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home:
                this.playAnimator(home);
                this.activeTab(HOME_TAB);
                changeTabBottom(HOME_TAB);
                break;
            case R.id.gift:
                this.playAnimator(gift);
                this.activeTab(GIFT_TAB);
                changeTabBottom(GIFT_TAB);
                break;
            case R.id.notification:
                this.playAnimator(notification);
                this.activeTab(NOTIFICATION_TAB);
                changeTabBottom(NOTIFICATION_TAB);
                break;
            case R.id.more:
                this.playAnimator(more);
                this.activeTab(MORE_TAB);
                changeTabBottom(MORE_TAB);
                break;
        }
    }

    public void changeTabBottom(int index) {
        try {
            BaseMvpFragment fragment;
            switch (index) {
                case HOME_TAB:
                    fragment = DashboardFragment.newInstance();
                    break;
                case GIFT_TAB:
                    fragment = DashboardFragment.newInstance();
                    break;
                case NOTIFICATION_TAB:
                    fragment = DashboardFragment.newInstance();
                    break;
                case MORE_TAB:
                    fragment = MoreFragment.newInstance();
                    break;
                default:
                    fragment = DashboardFragment.newInstance();

            }

            FragmentUtils.replaceFragment(this, fragment);
            this.activeTab(index);
            this.currentFragmentIndex = index;
            this.fragments.clear();
        } catch (Exception e) {
        }
    }
}
