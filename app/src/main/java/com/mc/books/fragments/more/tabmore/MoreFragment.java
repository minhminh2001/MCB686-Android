package com.mc.books.fragments.more.tabmore;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.ImageView;

import com.bon.customview.textview.ExtTextView;
import com.mc.books.R;
import com.mc.books.fragments.more.profile.UserProfileFragment;
import com.mc.common.fragments.BaseMvpFragment;
import com.mc.customizes.menus.ItemMenu;
import com.mc.utilities.FragmentUtils;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class MoreFragment extends BaseMvpFragment<IMoreView, IMorePresenter<IMoreView>> implements IMoreView {
    @BindView(R.id.imgAvartar)
    CircleImageView imgAvartar;
    @BindView(R.id.txtName)
    ExtTextView txtName;

    @BindView(R.id.llBooksname)
    ItemMenu llBooksname;
    @BindView(R.id.llCharts)
    ItemMenu llCharts;
    @BindView(R.id.llFanpage)
    ItemMenu llFanpage;
    @BindView(R.id.llSetting)
    ItemMenu llSetting;
    @BindView(R.id.llChangePassword)
    ItemMenu llChangePassword;
    @BindView(R.id.llUsermanual)
    ItemMenu llUsermanual;
    @BindView(R.id.llFeedback)
    ItemMenu llFeedback;
    @BindView(R.id.llLegal)
    ItemMenu llLegal;
    @BindView(R.id.llSupport)
    ItemMenu llSupport;
    @BindView(R.id.llSignout)
    ItemMenu llSignout;
    @BindView(R.id.imgNameChange)
    ImageView imgNameChange;

    public static MoreFragment newInstance() {
        Bundle args = new Bundle();
        MoreFragment fragment = new MoreFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public IMorePresenter<IMoreView> createPresenter() {
        return new MorePresenter<>(getAppComponent());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindButterKnife(view);
    }

    @Override
    public int getResourceId() {
        return R.layout.more_fragment;
    }

    @Override
    public int getTitleId() {
        return R.string.app_name;
    }

    @Override
    public void initToolbar(@NonNull ActionBar supportActionBar) {
        super.initToolbar(supportActionBar);
        supportActionBar.hide();
    }

    @OnClick(R.id.imgAvartar)
    void onClickAvatar() {
        FragmentUtils.replaceFragment(mActivity, UserProfileFragment.newInstance());
    }

    @OnClick(R.id.llBooksname)
    void onClickBook(){

    }
}
